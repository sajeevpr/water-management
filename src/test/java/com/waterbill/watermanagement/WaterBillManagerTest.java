package com.waterbill.watermanagement;

import com.waterbill.watermanagement.bill.model.Bill;
import com.waterbill.watermanagement.exception.ValidateException;
import junit.framework.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

public class WaterBillManagerTest {

    WaterBillManager waterBillManager;

    @BeforeEach
    void setUp() {
        waterBillManager = new WaterBillManager();
    }

    @Test
    void testBillGenerateFor2BHK() throws ValidateException, IOException {
        Bill bill = waterBillManager.generateBill("sample_input/TwoBHK.txt");
        Assert.assertEquals(2400, bill.getWaterConsumedInLitres());
        Assert.assertEquals(5215, bill.getTotalCost());
    }

    @Test
    void testBillGenerateFor2BHKNoGuests() throws ValidateException, IOException {
        Bill bill = waterBillManager.generateBill("sample_input/TwoBHKNoGuests.txt");
        Assert.assertEquals(900, bill.getWaterConsumedInLitres());
        Assert.assertEquals(1200, bill.getTotalCost());
    }

    @Test
    void testBillGenerateFor3BHK() throws ValidateException, IOException {
        Bill bill = waterBillManager.generateBill("sample_input/ThreeBHK.txt");
        Assert.assertEquals(3000, bill.getWaterConsumedInLitres());
        Assert.assertEquals(5750, bill.getTotalCost());
    }

    @Test
    void testBillGenerateFor3BHKNoGuests() throws ValidateException, IOException {
        Bill bill = waterBillManager.generateBill("sample_input/ThreeBHKNoGuests.txt");
        Assert.assertEquals(1500, bill.getWaterConsumedInLitres());
        Assert.assertEquals(1750, bill.getTotalCost());
    }

    @Test
    void testValidInputArguments() throws ValidateException {
        WaterBillManager.validateInputArgs(new String[]{"file.txt"});
    }

    @Test
    void testInvalidInputArguments() {
        Assertions.assertThrows(ValidateException.class,
                () -> WaterBillManager.validateInputArgs(new String[]{}));
    }

    @Test
    void testBillGenerateInputFileNotFound() {
        Assertions.assertThrows(FileNotFoundException.class,
                () -> waterBillManager.generateBill("sample_input/NoFile.txt"));
    }

    @Test
    void testBillGenerateMain()  {
        WaterBillManager.main(new String[]{"sample_input/ThreeBHKNoGuests.txt"});
    }

    @Test
    void testBillGenerateMainException()  {
        WaterBillManager.main(new String[]{"sample_input/NoFile.txt"});
    }
}