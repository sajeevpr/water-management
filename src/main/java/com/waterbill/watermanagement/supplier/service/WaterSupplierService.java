package com.waterbill.watermanagement.supplier.service;

import com.waterbill.watermanagement.residence.Residence;
import com.waterbill.watermanagement.supplier.WaterSupplier;

import java.util.List;

/**
 * Interface for WaterSupplier
 */
public interface WaterSupplierService {

    /**
     * To get the list of water suppliers for a given residence
     * @param residence residence
     * @return list of water suppliers
     */
    List<WaterSupplier> getWaterSuppliers(Residence residence);
}
