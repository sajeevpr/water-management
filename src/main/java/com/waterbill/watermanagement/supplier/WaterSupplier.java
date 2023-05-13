package com.waterbill.watermanagement.supplier;

/**
 * Abstract class for WaterSupplier
 */
public abstract class WaterSupplier {

    /**
     * Number of litres
     */
    protected double litres;

    /**
     * Constructor
     * @param litres litres
     */
    protected WaterSupplier(double litres) {
        this.litres = litres;
    }

    /**
     * Get litres of water
     * @return litres
     */
    public double getLitres() {
        return litres;
    }

    /**
     * Get water cost
     * @return water cost
     */
    public abstract double getWaterCost();
}
