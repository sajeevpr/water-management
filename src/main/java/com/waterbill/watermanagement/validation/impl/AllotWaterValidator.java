package com.waterbill.watermanagement.validation.impl;

import com.waterbill.watermanagement.constants.WaterBillConstants;
import com.waterbill.watermanagement.exception.ValidateException;
import com.waterbill.watermanagement.util.WaterManagementUtil;
import com.waterbill.watermanagement.validation.Validator;

import java.util.List;

/**
 * Validator implementation for AllotWater command
 */
public class AllotWaterValidator implements Validator {
    /**
     * Constant to hold two bed number
     */
    public static final String TWO_BED = "2";

    /**
     * Constant to hold three bed number
     */
    public static final String THREE_BED = "3";

    /**
     * To validate the list of input commands
     * @param inputCommands input commands
     * @throws ValidateException validate exception if any validation fails
     */
    @Override
    public void validate(List<String> inputCommands) throws ValidateException {
        //check if the first command is ALLOT_WATER
        if (!inputCommands.get(0).startsWith(WaterBillConstants.ALLOT_WATER)) {
            throw new ValidateException("The first user command should be ALLOT_WATER," +
                    " but found "+inputCommands.get(0));
        }

        //check for any duplicate ALLOT_WATER
        int allotWaterCounts = 0;
        for (String command: inputCommands) {
            if (command.startsWith(WaterBillConstants.ALLOT_WATER)) {
                allotWaterCounts++;
            }
        }
        if (allotWaterCounts > 1) {
            throw new ValidateException(WaterBillConstants.ALLOT_WATER+" command found "+allotWaterCounts+" times which is not allowed");
        }

        //check for the structure of ALLOT_WATER
        final String command = inputCommands.get(0);
        final String[] commandArray = command.split(WaterBillConstants.SPACE);
        String ratio[] = null;
        if (commandArray.length == 3) {
            ratio = commandArray[2].split(WaterBillConstants.COLON);
        }
        if (commandArray.length != 3
                || !commandArray[0].equals(WaterBillConstants.ALLOT_WATER)
                || !( commandArray[1].equals(TWO_BED) || commandArray[1].equals(THREE_BED))
                || !(ratio != null && ratio.length == 2
                && WaterManagementUtil.isValidPositiveNumber(ratio[0]) && WaterManagementUtil.isValidPositiveNumber(ratio[1]))
        ) {
            throw new ValidateException(WaterBillConstants.ALLOT_WATER+" structure is incorrect :"+command);
        }

    }


}
