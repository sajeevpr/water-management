package com.waterbill.watermanagement.bill.model;

/**
 * Bill model object
 */
public class Bill {

    /**
     * Water consumed in litres
     */
    private int waterConsumedInLitres;

    /**
     * Total cost for the consumed water
     */
    private int totalCost;

    /**
     * Constructor
     * @param waterConsumedInLitres water consumed in litres
     * @param totalCost total cost
     */
    public Bill(int waterConsumedInLitres, int totalCost) {
        this.waterConsumedInLitres = waterConsumedInLitres;
        this.totalCost = totalCost;
    }

    /**
     * To get water consumed in litres
     * @return waterConsumedInLitres
     */
    public int getWaterConsumedInLitres() {
        return waterConsumedInLitres;
    }

    /**
     * To get total cost
     * @return total cost of consumed water
     */
    public int getTotalCost() {
        return totalCost;
    }
}
