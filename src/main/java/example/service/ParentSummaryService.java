package example.service;

import example.domain.Child;
import example.domain.ParentSummary;
import example.dto.ApiResponse;
import example.repository.ChildRepository;
import example.repository.ParentSummaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.*;

/**
 * @author Duc Hien Nguyen
 */
@Component
public class ParentSummaryService {

    private final ChildRepository childRepository;

    private final ParentSummaryRepository parentSummaryRepository;

    private static final int SUMMARIZE_FIXED_RATE_IN_MS = 15 * 3600 * 1000;


    @Autowired
    public ParentSummaryService(ChildRepository childRepository,
                                ParentSummaryRepository parentSummaryRepository) {
        this.childRepository = childRepository;
        this.parentSummaryRepository = parentSummaryRepository;
    }

    @Scheduled(fixedRate = SUMMARIZE_FIXED_RATE_IN_MS)
    public void summarize() {

        List<Child> childList = getAllChildrenByPages();

        HashMap<Long, Long> childrenByParentIds = childList.stream().collect(groupingBy(Child::getParentId, HashMap::new, counting()));

        Collection<Long> amountOfChildrenCollection = childrenByParentIds.values();
        HashMap<Long, Long> histogram = amountOfChildrenCollection.stream().
                collect(groupingBy(identity(), HashMap::new, counting()));

        List<ParentSummary> parentSummaryList = histogram.keySet().stream().map(k -> new ParentSummary(k, histogram.get(k))).collect(toList());

        parentSummaryRepository.save(parentSummaryList);
    }

    private List<Child> getAllChildrenByPages() {
        int pageSize = 10000;
        int pageIndex = 0;
        boolean hasNext = true;

        List<Child> childList = new ArrayList<>();

        while (hasNext) {
            Page<Child> childrenPage = getChildrenPage(pageSize, pageIndex);
            hasNext = childrenPage.hasNext();
            pageIndex += 1;

            childList.addAll(childrenPage.getContent());
        }
        return childList;
    }

    private Page<Child> getChildrenPage(int pageSize, int pageIndex) {
        Pageable pageRequest = new PageRequest(pageSize, pageIndex, new Sort(Sort.Direction.ASC, "parentId"));
        return childRepository.findAll(pageRequest);
    }

    public ApiResponse<List<Long>> getAmountOfParentsWhoHaveNChildren() {
        List<Long> amountOfParentsWhoHaveNChildren = new ArrayList<>();
        Iterable<ParentSummary> all = parentSummaryRepository.findAll(new Sort(Sort.Direction.ASC, "amountOfChildren"));
        all.forEach(s->amountOfParentsWhoHaveNChildren.add(s.getAmountOfChildren()));
        return new ApiResponse<>(amountOfParentsWhoHaveNChildren);
    }
}

