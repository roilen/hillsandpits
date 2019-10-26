package service.watercalculation;

public interface WaterCalculationService {

    /*
     * This methods calculates the amount of water collected in all pits of the landscape.
     * @param int[] landscape
     */
    long calculateWaterAmount(int[] landscape);
}
