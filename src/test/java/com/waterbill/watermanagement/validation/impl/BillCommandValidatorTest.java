package com.waterbill.watermanagement.validation.impl;

import com.waterbill.watermanagement.exception.ValidateException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class BillCommandValidatorTest {

    BillCommandValidator billCommandValidator;

    @BeforeEach
    void setUp() {
        billCommandValidator = new BillCommandValidator();
    }

    @Test
    void testValidate() throws ValidateException {
        List<String> inputCommands = new ArrayList<>();
        inputCommands.add("ALLOT_WATER 2 1:2");
        inputCommands.add("ADD_GUESTS 4");
        inputCommands.add("BILL");
        billCommandValidator.validate(inputCommands);
    }

    @Test
    void testValidateBillNotLast() throws ValidateException {
        List<String> inputCommands = new ArrayList<>();
        inputCommands.add("ALLOT_WATER 2 1:2");
        inputCommands.add("ADD_GUESTS 4");
        inputCommands.add("BILL");
        inputCommands.add("ADD_GUESTS 4");
        Assertions.assertThrows(ValidateException.class,
                () -> billCommandValidator.validate(inputCommands));
    }

    @Test
    void testValidateDuplicateBill() throws ValidateException {
        List<String> inputCommands = new ArrayList<>();
        inputCommands.add("ALLOT_WATER 2 1:2");
        inputCommands.add("ADD_GUESTS 4");
        inputCommands.add("BILL");
        inputCommands.add("BILL");
        Assertions.assertThrows(ValidateException.class,
                () -> billCommandValidator.validate(inputCommands));
    }

    @Test
    void testValidateBillStructure() throws ValidateException {
        List<String> inputCommands = new ArrayList<>();
        inputCommands.add("ALLOT_WATER 2 1:2");
        inputCommands.add("ADD_GUESTS 4");
        inputCommands.add("BILL abc");
        Assertions.assertThrows(ValidateException.class,
                () -> billCommandValidator.validate(inputCommands));
    }
}