package example.service;

import example.domain.House;
import example.dto.ApiResponse;
import example.repository.HouseRepository;
import example.exceptions.HouseNotFoundException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

/**
 * @author Duc Hien Nguyen
 */
public class HouseServiceTest {


    private static final Long OWNER_ID = 11L;

    private HouseService houseService;

    @Mock
    private HouseRepository houseRepos;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        houseService = new HouseService(houseRepos);

        House house = new House();
        house.setOwnerId(OWNER_ID);
        when(houseRepos.findByOwnerId(OWNER_ID)).thenReturn(Optional.of(house));
        when(houseRepos.findByOwnerId(0L)).thenReturn(Optional.empty());
    }

    @Test
    public void getHouseByOwnerId() throws Exception {
        ApiResponse<House> response = houseService.getHouseByOwnerId(OWNER_ID);
        assertEquals(HttpStatus.OK, response.getStatus());
        assertEquals(OWNER_ID, response.getPayload().getOwnerId());
    }

    @Test(expected = HouseNotFoundException.class)
    public void getHouseNotFound() {
        houseService.getHouseByOwnerId(0L);
    }


}