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
}