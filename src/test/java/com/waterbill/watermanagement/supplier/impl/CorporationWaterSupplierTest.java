package com.waterbill.watermanagement.supplier.impl;

import junit.framework.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CorporationWaterSupplierTest {

    CorporationWaterSupplier supplier;

    @BeforeEach
    void setUp() {
        supplier = new CorporationWaterSupplier(1000);
    }

    @Test
    void testGetWaterCost() {
        Assert.assertEquals(1000.0, supplier.getWaterCost());
    }
}