package com.waterbill.watermanagement.supplier.impl;

import junit.framework.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoreWellWaterSupplierTest {

    BoreWellWaterSupplier supplier;

    @BeforeEach
    void setUp() {
        supplier = new BoreWellWaterSupplier(1000);
    }

    @Test
    void getWaterCost() {
        Assert.assertEquals(1500.0, supplier.getWaterCost());
    }
}