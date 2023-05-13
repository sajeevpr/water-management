package com.waterbill.watermanagement.validation.impl;

import com.waterbill.watermanagement.constants.WaterBillConstants;
import com.waterbill.watermanagement.exception.ValidateException;
import com.waterbill.watermanagement.util.WaterManagementUtil;
import com.waterbill.watermanagement.validation.Validator;

import java.util.List;

/**
 * Vaidator implementation for Add Guests command
 */
public class AddGuestValidator implements Validator {

    /**
     * To validate the list of input commands
     * @param inputCommands input commands
     * @throws ValidateException validate exception if any validation fails
     */
    @Override
    public void validate(List<String> inputCommands) throws ValidateException {

        //validate structure of ADD_GUESTS
        for (int i=1; i< inputCommands.size()-1;i++) {
            String command = inputCommands.get(i);
            final String[] commandArray = command.split(WaterBillConstants.SPACE);
            if ( commandArray.length != 2
                  || !commandArray[0].equals(WaterBillConstants.ADD_GUESTS)
                  || !WaterManagementUtil.isValidPositiveNumber(commandArray[1])) {
                throw new ValidateException(WaterBillConstants.ADD_GUESTS+" structure is incorrect :"+command);
            }
        }

    }
}
