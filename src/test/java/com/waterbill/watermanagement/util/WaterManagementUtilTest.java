package com.waterbill.watermanagement.util;

import junit.framework.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WaterManagementUtilTest {

    @Test
    void testIsNumeric() {
        Assert.assertEquals(true, WaterManagementUtil.isNumeric("1"));
    }

    @Test
    void testIsNumericNull() {
        Assert.assertEquals(false, WaterManagementUtil.isNumeric(null));
    }


    @Test
    void testIsNumericNegative() {
        Assert.assertEquals(false, WaterManagementUtil.isNumeric("A"));
    }

    @Test
    void isValidPositiveNumber() {
        Assert.assertEquals(true, WaterManagementUtil.isValidPositiveNumber("1.0"));
    }

    @Test
    void isValidPositiveNumberInvalidInput() {
        Assert.assertEquals(false, WaterManagementUtil.isValidPositiveNumber("A"));
    }

    @Test
    void isValidPositiveNumberNegativeInput() {
        Assert.assertEquals(false, WaterManagementUtil.isValidPositiveNumber("-1"));
    }
}