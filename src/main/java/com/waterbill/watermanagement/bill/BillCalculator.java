package com.waterbill.watermanagement.bill;

import com.waterbill.watermanagement.bill.model.Bill;
import com.waterbill.watermanagement.residence.Residence;
import com.waterbill.watermanagement.supplier.service.WaterSupplierService;

/**
 * Interface for BillCalculator taking Residence and WaterSupplierService
 */
public interface BillCalculator {

    /**
     * Calculates the bill based on the residence and water suppliers
     * @param residence residence
     * @param waterSupplierService watersupplier service
     * @return bill
     */
    Bill getTotalBill(Residence residence, WaterSupplierService waterSupplierService);
}
