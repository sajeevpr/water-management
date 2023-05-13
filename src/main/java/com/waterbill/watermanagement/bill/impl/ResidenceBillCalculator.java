package com.waterbill.watermanagement.bill.impl;

import com.waterbill.watermanagement.bill.BillCalculator;
import com.waterbill.watermanagement.bill.model.Bill;
import com.waterbill.watermanagement.residence.Residence;
import com.waterbill.watermanagement.supplier.WaterSupplier;
import com.waterbill.watermanagement.supplier.service.WaterSupplierService;

import java.util.List;

/**
 * Residence BillCalculator taking Residence and WaterSupplierService
 */
public class ResidenceBillCalculator implements BillCalculator {

    /**
     * Calculates the bill based on the residence and water suppliers
     * @param residence residence
     * @param waterSupplierService watersupplier service
     * @return bill
     */
    @Override
    public Bill getTotalBill(Residence residence, WaterSupplierService waterSupplierService) {
        double cost = 0.0;
        double litres = 0.0;
        List<WaterSupplier> supplierList = waterSupplierService.getWaterSuppliers(residence);
        for (WaterSupplier supplier: supplierList) {
            litres += supplier.getLitres();
            cost += supplier.getWaterCost();
        }

        return new Bill((int)Math.round(litres), (int)Math.round(cost));
    }
}
