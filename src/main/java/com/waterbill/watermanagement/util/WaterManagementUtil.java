package com.waterbill.watermanagement.util;

/**
 * WaterManagement Utility class
 */
public final class WaterManagementUtil {

    /**
     * Private constructor
     */
    private WaterManagementUtil() {
    }

    /**
     * To check if the given input is numeric or not
     * @param strNum string input
     * @return true if numeric else false
     */
    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
