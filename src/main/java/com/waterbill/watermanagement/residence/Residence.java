package com.waterbill.watermanagement.residence;

/**
 * Residence abstract class
 */
public abstract class Residence {

    /**
     * Number of residents in the residence
     */
    private final int residents;

    /**
     * Number of visitors in the residence
     */
    private int visitors;

    /**
     * Corporation water ratio
     */
    private final double corporationWaterRatio;

    /**
     * Borewell water ratio
     */
    private final double boreWellWaterRatio;

    /**
     * Constructor
     * @param residents residents
     * @param corporationWaterRatio corporationWaterRatio
     * @param boreWellWaterRatio boreWellWaterRatio
     */
    public Residence(int residents, double corporationWaterRatio, double boreWellWaterRatio) {
        this.residents = residents;
        this.corporationWaterRatio = corporationWaterRatio;
        this.boreWellWaterRatio = boreWellWaterRatio;
    }

    /**
     * Get residents
     * @return residents
     */
    public int getResidents() {
        return residents;
    }

    /**
     * Get visitors
     * @return visitors
     */
    public int getVisitors() {
        return visitors;
    }

    /**
     * Get corporation water ratio
     * @return corporationWaterRatio
     */
    public double getCorporationWaterRatio() {
        return corporationWaterRatio;
    }

    /**
     * Get Borewell water ratio
     * @return boreWellWaterRatio
     */
    public double getBoreWellWaterRatio() {
        return boreWellWaterRatio;
    }

    /**
     * Add visitors
     * @param newVisitors number of new visitors
     * @return total visitors
     */
    public int addVisitors(int newVisitors) {
        if (newVisitors > 0) {
            this.visitors += newVisitors;
        }
        return this.visitors;
    }
}
