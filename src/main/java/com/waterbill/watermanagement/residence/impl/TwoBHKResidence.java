package com.waterbill.watermanagement.residence.impl;

import com.waterbill.watermanagement.residence.Residence;

/**
 * Two BHK residence
 */
public class TwoBHKResidence extends Residence {

    /**
     * Number of residents
     */
    public static final int RESIDENTS = 3;

    /**
     * Constructor
     * @param corporationWaterRatio corporationWaterRatio
     * @param boreWellWaterRatio boreWellWaterRatio
     */
    public TwoBHKResidence(int corporationWaterRatio, int boreWellWaterRatio) {
        super(RESIDENTS, corporationWaterRatio, boreWellWaterRatio);
    }
}
