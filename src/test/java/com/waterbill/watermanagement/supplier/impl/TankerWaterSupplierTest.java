package com.waterbill.watermanagement.supplier.impl;

import junit.framework.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TankerWaterSupplierTest {

    @Test
    void testGetWaterCostSlab1() {
        TankerWaterSupplier supplier = new TankerWaterSupplier(400);
        Assert.assertEquals(800.0, supplier.getWaterCost());
    }

    @Test
    void testGetWaterCostSlab2() {
        TankerWaterSupplier supplier = new TankerWaterSupplier(800);
        Assert.assertEquals(1900.0, supplier.getWaterCost());
    }

    @Test
    void testGetWaterCostSlab3() {
        TankerWaterSupplier supplier = new TankerWaterSupplier(2000);
        Assert.assertEquals(6500.0, supplier.getWaterCost());
    }

    @Test
    void testGetWaterCostSlab4() {
        TankerWaterSupplier supplier = new TankerWaterSupplier(4000);
        Assert.assertEquals(19500.0, supplier.getWaterCost());
    }

}