package com.waterbill.watermanagement;

import com.waterbill.watermanagement.bill.model.Bill;
import com.waterbill.watermanagement.bill.BillCalculator;
import com.waterbill.watermanagement.bill.impl.ResidenceBillCalculator;
import com.waterbill.watermanagement.exception.ValidateException;
import com.waterbill.watermanagement.residence.Residence;
import com.waterbill.watermanagement.residence.impl.ThreeBHKResidence;
import com.waterbill.watermanagement.residence.impl.TwoBHKResidence;
import com.waterbill.watermanagement.supplier.service.WaterSupplierService;
import com.waterbill.watermanagement.supplier.service.impl.WaterSupplierServiceImpl;
import com.waterbill.watermanagement.validation.service.ValidatorService;
import com.waterbill.watermanagement.validation.service.ValidatorServiceImpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

/**
 * WaterBillManager is the main class for orchestrating the bill generation for a household
 */
public class WaterBillManager {

    /**
     * Main method
     * @param args input arguments with first argument as the file name
     */
    public static void main(String[] args) {

        WaterBillManager billManager = new WaterBillManager();
        try {
            validateInputArgs(args);
            final String fileName = args[0];
            Bill bill = billManager.generateBill(fileName);
            System.out.println(bill.getWaterConsumedInLitres() + " " + bill.getTotalCost());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    /**
     * To validate the input arguments
     * @param args input arguments
     * @throws ValidateException validate exception
     */
    public static void validateInputArgs(String[] args) throws ValidateException {
        if (args.length == 0) {
            throw new ValidateException("Please provide the absolute input file name");
        }
    }

    /**
     * Generate Bill based on the input file name
     * @param fileName file name
     * @return bill
     * @throws ValidateException validate exception
     * @throws IOException io exception
     */
    public Bill generateBill(final String fileName) throws ValidateException, IOException {

        //read user input
        List<String> inputCommands = readUserInputFile(fileName);

        //validate userInput
        validateUserInput(inputCommands);

        //execute user commands
        return executeUserCommands(inputCommands);
    }

    /**
     * Execute the user input commands
     * @param inputCommands input commands
     * @return bill
     */
    private Bill executeUserCommands(List<String> inputCommands) {
        //process ALLOT_WATER
        Residence residence = processAllotWater(inputCommands.get(0));
        //process ADD_GUESTS
        processAddGuests(inputCommands, residence);
        //process BILL
        return processBill(residence);
    }

    /**
     * Process ALLOT_WATER
     * @param command allot water command
     * @return residence
     */
    private Residence processAllotWater(String command) {
        String[] commandArray = command.split(" ");
        Residence residence = null;
        int bedrooms = Integer.parseInt(commandArray[1]);
        String[] ratio = commandArray[2].split(":");
        if (bedrooms == 2) {
            residence = new TwoBHKResidence(Integer.parseInt(ratio[0]), Integer.parseInt(ratio[1]));
        } else if (bedrooms == 3) {
            residence = new ThreeBHKResidence(Integer.parseInt(ratio[0]), Integer.parseInt(ratio[1]));
        }
        return residence;
    }

    /**
     * Process ADD_GUESTS and update the residence
     * @param inputCommands input commands
     * @param residence residence
     */
    private void processAddGuests(List<String> inputCommands, Residence residence) {
        for (int i = 1; i < inputCommands.size() - 1; i++) {
            int newVisitors = Integer.parseInt(inputCommands.get(i).split(" ")[1]);
            residence.addVisitors(newVisitors);
        }
    }

    /**
     * Process BILL
     * @param residence residence
     * @return bill
     */
    private Bill processBill(Residence residence) {
        BillCalculator billCalculator = new ResidenceBillCalculator();
        WaterSupplierService waterSupplierService = new WaterSupplierServiceImpl();
        return billCalculator.getTotalBill(residence, waterSupplierService);
    }

    /**
     * Read User input file name
     * @param inputFileName input file name
     * @return list of input commands
     * @throws IOException
     */
    private List<String> readUserInputFile(String inputFileName) throws IOException {
        File inputFile = new File(inputFileName);
        List<String> inputCommands = null;
        if (inputFile.exists()) {
            inputCommands = Files.readAllLines(inputFile.toPath());
        } else {
            throw new FileNotFoundException("File Not found " + inputFileName);
        }

        return inputCommands;
    }

    /**
     * Validate input commands
     * @param inputCommands input commands
     * @throws ValidateException validate exception
     */
    private void validateUserInput(List<String> inputCommands) throws ValidateException {
        ValidatorService validatorService = new ValidatorServiceImpl();
        validatorService.validate(inputCommands);
    }

}
