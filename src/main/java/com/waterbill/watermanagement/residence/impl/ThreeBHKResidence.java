package com.waterbill.watermanagement.residence.impl;

import com.waterbill.watermanagement.residence.Residence;
/**
 * Three BHK residence
 */
public class ThreeBHKResidence extends Residence {

    /**
     * Number of residents
     */
    public static final int RESIDENTS = 5;

    /**
     * Constructor
     * @param corporationWaterRatio corporationWaterRatio
     * @param boreWellWaterRatio boreWellWaterRatio
     */
    public ThreeBHKResidence(int corporationWaterRatio, int boreWellWaterRatio) {
        super(RESIDENTS, corporationWaterRatio, boreWellWaterRatio);
    }
}
