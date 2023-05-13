package com.waterbill.watermanagement.supplier.impl;

import com.waterbill.watermanagement.supplier.WaterSupplier;

/**
 * BoreWellWater supplier
 */
public class BoreWellWaterSupplier extends WaterSupplier {

    /**
     * Water rate per litre
     */
    public static final double WATER_RATE = 1.5;

    /**
     * Constructor
     * @param litres litres
     */
    public BoreWellWaterSupplier(double litres) {
        super(litres);
    }

    /**
     * Get water cost
     * @return water cost for litres of water
     */
    @Override
    public double getWaterCost() {
        return WATER_RATE *litres;
    }
}
