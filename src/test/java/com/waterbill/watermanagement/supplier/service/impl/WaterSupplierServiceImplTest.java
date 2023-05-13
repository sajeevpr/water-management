package com.waterbill.watermanagement.supplier.service.impl;

import com.waterbill.watermanagement.residence.Residence;
import com.waterbill.watermanagement.residence.impl.ThreeBHKResidence;
import com.waterbill.watermanagement.supplier.WaterSupplier;
import com.waterbill.watermanagement.supplier.impl.BoreWellWaterSupplier;
import com.waterbill.watermanagement.supplier.impl.CorporationWaterSupplier;
import com.waterbill.watermanagement.supplier.impl.TankerWaterSupplier;
import junit.framework.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class WaterSupplierServiceImplTest {

    WaterSupplierServiceImpl waterSupplierService;

    @BeforeEach
    void setUp() {
        waterSupplierService = new WaterSupplierServiceImpl();
    }

    @Test
    void testGetWaterSuppliers() {
        Residence residence = new ThreeBHKResidence(2, 1);
        residence.addVisitors(4);
        residence.addVisitors(1);
        residence.addVisitors(-1);
        List<WaterSupplier> suppliers = waterSupplierService.getWaterSuppliers(residence);
        Assert.assertEquals(3,suppliers.size());
        CorporationWaterSupplier corporationWaterSupplier = (CorporationWaterSupplier) suppliers.get(0);
        BoreWellWaterSupplier boreWellWaterSupplier = (BoreWellWaterSupplier) suppliers.get(1);
        TankerWaterSupplier tankerWaterSupplier = (TankerWaterSupplier) suppliers.get(2);
        Assert.assertEquals(1000.0, corporationWaterSupplier.getLitres());
        Assert.assertEquals(1000.0, corporationWaterSupplier.getWaterCost());
        Assert.assertEquals(500.0, boreWellWaterSupplier.getLitres());
        Assert.assertEquals(750.0, boreWellWaterSupplier.getWaterCost());
        Assert.assertEquals(1500.0, tankerWaterSupplier.getLitres());
        Assert.assertEquals(4000.0, tankerWaterSupplier.getWaterCost());

    }
}