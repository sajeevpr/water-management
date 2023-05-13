package com.waterbill.watermanagement.supplier.impl;

import com.waterbill.watermanagement.supplier.WaterSupplier;

/**
 * CorporationWater supplier
 */
public class CorporationWaterSupplier extends WaterSupplier {


    /**
     * Water rate for one litre
     */
    public static final double WATER_RATE = 1;

    /**
     * Constructor
     * @param litres litres
     */
    public CorporationWaterSupplier(double litres) {
        super(litres);
    }

    /**
     * Get water cost
     * @return water cost for given litres
     */
    @Override
    public double getWaterCost() {
        return WATER_RATE * litres;
    }
}
