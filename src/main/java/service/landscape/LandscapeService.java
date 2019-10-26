package service.landscape;

import dto.LandscapeDto;

public interface LandscapeService {
    LandscapeDto createLandscape();
    LandscapeDto createExactLandscape(int[] landscape);
    boolean validateLandscape(LandscapeDto landscapeDto);
}
