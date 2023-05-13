package com.waterbill.watermanagement.validation.service;

import com.waterbill.watermanagement.exception.ValidateException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorServiceImplTest {

    ValidatorServiceImpl validatorService;

    @BeforeEach
    void setUp() {
        validatorService = new ValidatorServiceImpl();
    }

    @Test
    void testValidate() throws ValidateException {
        List<String> inputCommands = new ArrayList<>();
        inputCommands.add("ALLOT_WATER 2 1:2");
        inputCommands.add("ADD_GUESTS 4");
        inputCommands.add("BILL");
        validatorService.validate(inputCommands);
    }

    @Test
    void testValidateException() throws ValidateException {
        List<String> inputCommands = new ArrayList<>();
        inputCommands.add("ALLOT_WATER 2 1:2");
        inputCommands.add("ADD_GUESTS 4");
        inputCommands.add("ALLOT_WATER 2 1:2");
        inputCommands.add("BILL");
        Assertions.assertThrows(ValidateException.class,
                () -> validatorService.validate(inputCommands));
    }
}