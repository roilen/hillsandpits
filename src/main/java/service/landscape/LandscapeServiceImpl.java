package service.landscape;

import config.AppConstants;
import config.ExceptionStrings;
import dto.LandscapeDto;

import java.util.Random;

public class LandscapeServiceImpl implements LandscapeService {
    public LandscapeDto createLandscape() {
        LandscapeDto landscapeDto = new LandscapeDto();
        Random rnd = new Random();
        int[] landscape = new int[rnd.nextInt(AppConstants.MAX_LANDSCAPE_POSITIONS)];
        for(int i=0; i < landscape.length; i++){
            landscape[i] = rnd.nextInt(AppConstants.MAX_LANDSCAPE_HEIGHT);
        }
        landscapeDto.setLandscapeHeights(landscape);
        return landscapeDto;
    }

    public LandscapeDto createExactLandscape(int[] landscape){
        LandscapeDto landscapeDto = new LandscapeDto();
        landscapeDto.setLandscapeHeights(landscape);
        return landscapeDto;
    }

    public boolean validateLandscape(LandscapeDto landscapeDto) {
        if(landscapeDto.getLandscapeHeights() == null){
            System.out.println(ExceptionStrings.LANDSCAPE_IS_NULL);
            return false;
        }
        if(landscapeDto.getLandscapeHeights().length > AppConstants.MAX_LANDSCAPE_POSITIONS){
            System.out.println(ExceptionStrings.LANDSCAPE_LENGTH_OVER_MAXIMUM);
            return false;
        }
        int[] landscape = landscapeDto.getLandscapeHeights();
        for(int i = 0; i < landscape.length; i++){
            if(landscape[i] > AppConstants.MAX_LANDSCAPE_HEIGHT){
                System.out.println(ExceptionStrings.LANDSCAPE_HAS_HEIGHT_OVER_MAXIMUM + i + ": " + landscape[i]);
                return false;
            } else if (landscape[i] < AppConstants.MIN_LANDSCAPE_HEIGHT){
                System.out.println(ExceptionStrings.LANDSCAPE_HAS_HEIGHT_LOWER_MINIMUM + i + ": " + landscape[i]);
                return false;
            }
        }
        return true;
    }
}
