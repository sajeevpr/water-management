package com.waterbill.watermanagement.validation.impl;

import com.waterbill.watermanagement.constants.WaterBillConstants;
import com.waterbill.watermanagement.exception.ValidateException;
import com.waterbill.watermanagement.validation.Validator;

import java.util.List;

/**
 * Validator implementation for Bill command
 */
public class BillCommandValidator implements Validator {

    /**
     * To validate the list of input commands
     * @param inputCommands input commands
     * @throws ValidateException validate exception if any validation fails
     */
    @Override
    public void validate(List<String> inputCommands) throws ValidateException {
        //check if the last command is BILL
        if (!inputCommands.get(inputCommands.size()-1).startsWith(WaterBillConstants.BILL)) {
            throw new ValidateException("The last user command should be BILL," +
                    " but found "+inputCommands.get(inputCommands.size()-1));
        }

        //check for any duplicate BILL
        int billCounts = 0;
        for (String command: inputCommands) {
            if (command.startsWith(WaterBillConstants.BILL)) {
                billCounts++;
            }
        }

        if (billCounts > 1) {
            throw new ValidateException(WaterBillConstants.BILL+" command found "+billCounts+" times which is not allowed");
        }

        //validate bill command structure
        final String command = inputCommands.get(inputCommands.size()-1);
        if (!command.trim().equals(WaterBillConstants.BILL)) {
            throw new ValidateException(WaterBillConstants.BILL+" structure is incorrect :"+command);
        }
    }
}
