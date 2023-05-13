package com.waterbill.watermanagement.validation.service;

import com.waterbill.watermanagement.exception.ValidateException;

import java.util.List;

/**
 * Validator service interface
 */
public interface ValidatorService {

    /**
     * Validate input commands
     * @param inputCommands input commands
     * @throws ValidateException validate exception
     */
    void validate(List<String> inputCommands) throws ValidateException;

}
