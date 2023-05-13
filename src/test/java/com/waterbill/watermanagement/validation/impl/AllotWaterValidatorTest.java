package com.waterbill.watermanagement.validation.impl;

import com.waterbill.watermanagement.exception.ValidateException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AllotWaterValidatorTest {

    AllotWaterValidator allotWaterValidator;

    @BeforeEach
    void setUp() {
        allotWaterValidator = new AllotWaterValidator();
    }

    @Test
    void testValidate() throws ValidateException {
        List<String> inputCommands = new ArrayList<>();
        inputCommands.add("ALLOT_WATER 2 1:2");
        inputCommands.add("BILL");
        allotWaterValidator.validate(inputCommands);
    }

    @Test
    void testValidateAllotNotFirst() throws ValidateException {
        List<String> inputCommands = new ArrayList<>();
        inputCommands.add("BILL");
        Assertions.assertThrows(ValidateException.class,
                () -> allotWaterValidator.validate(inputCommands));
    }

    @Test
    void testValidateAllotDuplicate() throws ValidateException {
        List<String> inputCommands = new ArrayList<>();
        inputCommands.add("ALLOT_WATER 2 1:2");
        inputCommands.add("BILL");
        inputCommands.add("ALLOT_WATER 2 1:3");
        Assertions.assertThrows(ValidateException.class,
                () -> allotWaterValidator.validate(inputCommands));
    }

    @Test
    void testValidateAllotStructureIncorrectCommand() throws ValidateException {
        List<String> inputCommands = new ArrayList<>();
        inputCommands.add("ALLOT_WATER1 2 1:2");
        inputCommands.add("BILL");
        Assertions.assertThrows(ValidateException.class,
                () -> allotWaterValidator.validate(inputCommands));
    }

    @Test
    void testValidateAllotStructureBedroomWrong() throws ValidateException {
        List<String> inputCommands = new ArrayList<>();
        inputCommands.add("ALLOT_WATER 5 1:2");
        inputCommands.add("BILL");
        Assertions.assertThrows(ValidateException.class,
                () -> allotWaterValidator.validate(inputCommands));
    }

    @Test
    void testValidateAllotStructureIncorrectRatioLength() throws ValidateException {
        List<String> inputCommands = new ArrayList<>();
        inputCommands.add("ALLOT_WATER 2 1");
        inputCommands.add("BILL");
        Assertions.assertThrows(ValidateException.class,
                () -> allotWaterValidator.validate(inputCommands));
    }

    @Test
    void testValidateAllotStructureIncorrectRatio1() throws ValidateException {
        List<String> inputCommands = new ArrayList<>();
        inputCommands.add("ALLOT_WATER 2 A:2");
        inputCommands.add("BILL");
        Assertions.assertThrows(ValidateException.class,
                () -> allotWaterValidator.validate(inputCommands));
    }

    @Test
    void testValidateAllotStructureIncorrectRatio2() throws ValidateException {
        List<String> inputCommands = new ArrayList<>();
        inputCommands.add("ALLOT_WATER 2 1:B");
        inputCommands.add("BILL");
        Assertions.assertThrows(ValidateException.class,
                () -> allotWaterValidator.validate(inputCommands));
    }
}