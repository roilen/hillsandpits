package service.watercalculation;

public class WaterCalculationServiceImpl implements WaterCalculationService {

    public long calculateWaterAmount(int[] landscape) {
        int left[] = new int[landscape.length];
        int right[] = new int[landscape.length];

        int water = 0;

        left[0] = landscape[0];
        for (int i = 1; i < landscape.length; i++)
            left[i] = Math.max(left[i-1], landscape[i]);

        right[landscape.length-1] = landscape[landscape.length-1];
        for (int i = landscape.length-2; i >= 0; i--)
            right[i] = Math.max(right[i+1], landscape[i]);

        for (int i = 0; i < landscape.length; i++)
            water += Math.min(left[i],right[i]) - landscape[i];

        return water;

    }
}
