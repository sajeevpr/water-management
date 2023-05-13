package com.waterbill.watermanagement.validation;

import com.waterbill.watermanagement.exception.ValidateException;

import java.util.List;

/**
 * Validator interface
 */
public interface Validator {

    /**
     * To validate the list of input commands
     * @param inputCommands input commands
     * @throws ValidateException validate exception if any validation fails
     */
    void validate(List<String> inputCommands) throws ValidateException;
}
