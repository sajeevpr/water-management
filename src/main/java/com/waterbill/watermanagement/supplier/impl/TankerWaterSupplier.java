package com.waterbill.watermanagement.supplier.impl;

import com.waterbill.watermanagement.supplier.WaterSupplier;

/**
 * TankerWater supplier
 */
public class TankerWaterSupplier extends WaterSupplier {


    /**
     * Slab rate for 0->500
     */
    public static final int ZERO_TO_500_SLAB_RATE = 2;

    /**
     * Constant 500
     */
    public static final int FIVE_HUNDRED = 500;

    /**
     * Constant 1500
     */
    public static final int THOUSAND_FIVE_HUNDRED = 1500;

    /**
     * Slab rate for 500->1500
     */
    public static final int FIVE_HUNDRED_TO_1500_SLAB_RATE = 3;

    /**
     * Constant for 1000
     */
    public static final int THOUSAND = 1000;
    /**
     * Constant for 3000
     */
    public static final int THREE_THOUSAND = 3000;

    /**
     * Slab rate for 1500-3000
     */
    public static final int THOUSAND_FIVE_HUNDRED_TO_3000_SLAB_RATE = 5;
    /**
     * Slab rate for 3000+
     */
    public static final int THREE_THOUSAND_PLUS_SLAB_RATE = 8;

    /**
     * Constructor
     * @param litres litres
     */
    public TankerWaterSupplier(double litres) {
        super(litres);
    }

    /**
     * Get water costs
     * @return water costs for all litres of water
     */
    @Override
    public double getWaterCost() {
        double cost = 0.0;
        //slab 1
        if (litres <= FIVE_HUNDRED) {
            cost = litres * ZERO_TO_500_SLAB_RATE;
        } else {
            cost = FIVE_HUNDRED * ZERO_TO_500_SLAB_RATE;
        }

        //slab 2
        if (litres > FIVE_HUNDRED && litres <= THOUSAND_FIVE_HUNDRED) {
            double diffLitres = litres - FIVE_HUNDRED;
            cost += diffLitres * FIVE_HUNDRED_TO_1500_SLAB_RATE;
        } else if (litres > THOUSAND_FIVE_HUNDRED) {
            cost += THOUSAND * FIVE_HUNDRED_TO_1500_SLAB_RATE;
        }

        //slab 3
        if (litres > THOUSAND_FIVE_HUNDRED && litres <= THREE_THOUSAND) {
            double diffLitres = litres - THOUSAND_FIVE_HUNDRED;
            cost += diffLitres * THOUSAND_FIVE_HUNDRED_TO_3000_SLAB_RATE;
        } else if (litres > THREE_THOUSAND) {
            cost +=THOUSAND_FIVE_HUNDRED * THOUSAND_FIVE_HUNDRED_TO_3000_SLAB_RATE;
        }

        //slab 4
        if (litres > 3000) {
            double diffLitres = litres - THREE_THOUSAND;
            cost += diffLitres * THREE_THOUSAND_PLUS_SLAB_RATE;
        }

        return cost;
    }
}
