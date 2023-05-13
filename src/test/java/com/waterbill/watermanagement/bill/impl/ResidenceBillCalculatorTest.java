package com.waterbill.watermanagement.bill.impl;

import com.waterbill.watermanagement.bill.model.Bill;
import com.waterbill.watermanagement.residence.Residence;
import com.waterbill.watermanagement.residence.impl.ThreeBHKResidence;
import com.waterbill.watermanagement.supplier.service.WaterSupplierService;
import com.waterbill.watermanagement.supplier.service.impl.WaterSupplierServiceImpl;
import junit.framework.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResidenceBillCalculatorTest {

    ResidenceBillCalculator residenceBillCalculator;

    @BeforeEach
    void setUp() {
        residenceBillCalculator = new ResidenceBillCalculator();
    }

    @Test
    void testGetTotalBill() {
        Residence residence = new ThreeBHKResidence(2, 1);
        residence.addVisitors(4);
        residence.addVisitors(1);
        WaterSupplierService waterSupplierService = new WaterSupplierServiceImpl();
        Bill bill = residenceBillCalculator.getTotalBill(residence, waterSupplierService);
        Assert.assertEquals(3000,bill.getWaterConsumedInLitres());
        Assert.assertEquals(5750,bill.getTotalCost());
    }
}