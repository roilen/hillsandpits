import config.ExceptionStrings;
import dto.LandscapeDto;
import service.landscape.LandscapeService;
import service.landscape.LandscapeServiceImpl;
import service.watercalculation.WaterCalculationService;
import service.watercalculation.WaterCalculationServiceImpl;

public class Main {
    private static LandscapeService landscapeService;
    private static WaterCalculationService waterService;
    private static LandscapeDto landscape;

    public static void main(String[] args) {
        initialize();
        if(landscapeService.validateLandscape(landscape)){
            System.out.println("Maximum water collected between pits is " +
                    waterService.calculateWaterAmount(landscape.getLandscapeHeights()));
        } else {
            System.out.println(ExceptionStrings.LANDSCAPE_NOT_VALID);
        }
    }

    static void initialize(){
        landscapeService = new LandscapeServiceImpl();
        waterService = new WaterCalculationServiceImpl();
        landscape = landscapeService.createLandscape();
    }

}
