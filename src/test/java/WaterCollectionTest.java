import config.AppConstants;
import dto.LandscapeDto;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import service.landscape.LandscapeService;
import service.landscape.LandscapeServiceImpl;
import service.watercalculation.WaterCalculationService;
import service.watercalculation.WaterCalculationServiceImpl;

public class WaterCollectionTest {

    private static LandscapeDto landscape;
    private static WaterCalculationService waterCalculationService;
    private static LandscapeService landscapeService;

    @Before
    public static void init(){
        landscapeService = new LandscapeServiceImpl();
        waterCalculationService = new WaterCalculationServiceImpl();
    }

    @Test
    public void createLandscape(){
        landscape = landscapeService.createLandscape();
        assertNotNull(landscape);
    }

    @Test
    public void createExactLandscape(){
        int[] testLandscape = {5,2,3,4,5,4,0,3,1};
        landscape = landscapeService.createExactLandscape(testLandscape);
        assertNotNull(landscape);
        assertArrayEquals(testLandscape, landscape.getLandscapeHeights());
    }

    @Test
    public void validateOverHeights(){
        int[] testLandscape = {5,2,3,4, AppConstants.MAX_LANDSCAPE_HEIGHT + 1,4,0,3,1};
        landscape = landscapeService.createExactLandscape(testLandscape);
        assertFalse(landscapeService.validateLandscape(landscape));
    }

    @Test
    public void validateNegativeHeights(){
        int[] testLandscape = {5,2,3,4,AppConstants.MIN_LANDSCAPE_HEIGHT - 1,4,0,3,1};
        landscape = landscapeService.createExactLandscape(testLandscape);
        assertFalse(landscapeService.validateLandscape(landscape));
    }

    @Test
    public void validateLandscapeLength(){
        int[] testLandscape = new int[AppConstants.MAX_LANDSCAPE_POSITIONS+1];
        landscape = landscapeService.createExactLandscape(testLandscape);
        assertFalse(landscapeService.validateLandscape(landscape));
    }

    @Test
    public void testWaterCalculation() {
        int[] testLandscape = {5,2,3,4,5,4,0,3,1};
        landscape = landscapeService.createExactLandscape(testLandscape);
        long water = waterCalculationService.calculateWaterAmount(landscape.getLandscapeHeights());
        assertEquals(9,water);
    }
}
