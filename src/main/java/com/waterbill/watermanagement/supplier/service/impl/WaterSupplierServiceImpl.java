package com.waterbill.watermanagement.supplier.service.impl;

import com.waterbill.watermanagement.residence.Residence;
import com.waterbill.watermanagement.supplier.WaterSupplier;
import com.waterbill.watermanagement.supplier.impl.BoreWellWaterSupplier;
import com.waterbill.watermanagement.supplier.impl.CorporationWaterSupplier;
import com.waterbill.watermanagement.supplier.impl.TankerWaterSupplier;
import com.waterbill.watermanagement.supplier.service.WaterSupplierService;

import java.util.Arrays;
import java.util.List;

/**
 * WaterSupplierService implementation
 */
public class WaterSupplierServiceImpl implements WaterSupplierService {

    /**
     * Water allocation for a resident per day
     */
    public static final int WATER_ALLOCATION_PER_DAY = 10;
    /**
     * Days in a month
     */
    public static final int DAYS_IN_MONTH = 30;

    /**
     * To get the list of water suppliers for a given residence
     * @param residence residence
     * @return list of water suppliers
     */
    @Override
    public List<WaterSupplier> getWaterSuppliers(Residence residence) {
        int residents = residence.getResidents();
        int visitors = residence.getVisitors();
        double corporationWaterRatio = residence.getCorporationWaterRatio();
        double boreWellWaterRatio = residence.getBoreWellWaterRatio();
        int totalWaterRequiredForResidents = residents * WATER_ALLOCATION_PER_DAY * DAYS_IN_MONTH;
        double waterAllocatedFromCorporation =
                totalWaterRequiredForResidents *
                        (corporationWaterRatio/(corporationWaterRatio + boreWellWaterRatio));
        double waterAllocatedFromBoreWell =
                totalWaterRequiredForResidents *
                        (boreWellWaterRatio/(corporationWaterRatio + boreWellWaterRatio));
        WaterSupplier corporationWaterSupplier = new CorporationWaterSupplier(waterAllocatedFromCorporation);
        WaterSupplier boreWellWaterSupplier = new BoreWellWaterSupplier(waterAllocatedFromBoreWell);

        int totalWaterRequiredForVisitors = visitors * WATER_ALLOCATION_PER_DAY * DAYS_IN_MONTH;
        WaterSupplier tankerWaterSupplier = new TankerWaterSupplier(totalWaterRequiredForVisitors);

        return Arrays.asList(corporationWaterSupplier, boreWellWaterSupplier, tankerWaterSupplier);
    }
}
