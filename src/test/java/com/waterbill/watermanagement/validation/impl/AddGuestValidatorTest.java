package com.waterbill.watermanagement.validation.impl;

import com.waterbill.watermanagement.exception.ValidateException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AddGuestValidatorTest {

    AddGuestValidator addGuestValidator;

    @BeforeEach
    void setUp() {
        addGuestValidator = new AddGuestValidator();
    }

    @Test
    void testValidate() throws ValidateException {
        List<String> inputCommands = new ArrayList<>();
        inputCommands.add("ALLOT_WATER 2 1:2");
        inputCommands.add("ADD_GUESTS 4");
        inputCommands.add("BILL");
        addGuestValidator.validate(inputCommands);
    }

    @Test
    void testValidateStructureLength() throws ValidateException {
        List<String> inputCommands = new ArrayList<>();
        inputCommands.add("ALLOT_WATER 2 1:2");
        inputCommands.add("ADD_GUESTS 4 5");
        inputCommands.add("BILL");
        Assertions.assertThrows(ValidateException.class,
                () -> addGuestValidator.validate(inputCommands));
    }

    @Test
    void testValidateStructureWrongCommand() throws ValidateException {
        List<String> inputCommands = new ArrayList<>();
        inputCommands.add("ALLOT_WATER 2 1:2");
        inputCommands.add("ADD_GUESTS2 4");
        inputCommands.add("BILL");
        Assertions.assertThrows(ValidateException.class,
                () -> addGuestValidator.validate(inputCommands));
    }

    @Test
    void testValidateStructureIncorrectGuestNumber() throws ValidateException {
        List<String> inputCommands = new ArrayList<>();
        inputCommands.add("ALLOT_WATER 2 1:2");
        inputCommands.add("ADD_GUESTS A");
        inputCommands.add("BILL");
        Assertions.assertThrows(ValidateException.class,
                () -> addGuestValidator.validate(inputCommands));
    }
}