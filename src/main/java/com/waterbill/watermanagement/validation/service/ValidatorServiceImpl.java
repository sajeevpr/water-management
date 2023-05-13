package com.waterbill.watermanagement.validation.service;

import com.waterbill.watermanagement.exception.ValidateException;
import com.waterbill.watermanagement.validation.impl.AddGuestValidator;
import com.waterbill.watermanagement.validation.impl.AllotWaterValidator;
import com.waterbill.watermanagement.validation.impl.BillCommandValidator;
import com.waterbill.watermanagement.validation.Validator;

import java.util.ArrayList;
import java.util.List;

/**
 * Validator service implementation
 */
public class ValidatorServiceImpl implements ValidatorService{

    /**
     * List of validators
     */
    List<Validator> validatorList;

    /**
     * Constructor
     */
    public ValidatorServiceImpl() {
        validatorList = new ArrayList<>();
        validatorList.add(new AllotWaterValidator());
        validatorList.add(new AddGuestValidator());
        validatorList.add(new BillCommandValidator());
    }

    /**
     * To validate the list of input commands for all validators in validatorList
     * @param inputCommands input commands
     * @throws ValidateException validate exception
     */
    @Override
    public void validate(List<String> inputCommands) throws ValidateException {
        for (Validator validator: validatorList) {
            validator.validate(inputCommands);
        }
    }

}
