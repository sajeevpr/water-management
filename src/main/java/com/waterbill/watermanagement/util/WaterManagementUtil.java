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
            Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    /**
     * To check if the given string is a valid positive number
     * @param strNum input string number
     * @return true if valid positive number else false
     */
    public static boolean isValidPositiveNumber(String strNum) {
        if (isNumeric(strNum)) {
            double doubleNum = Double.parseDouble(strNum);
            if (doubleNum > 0) {
                return true;
            }
        }
        return false;
    }
}
