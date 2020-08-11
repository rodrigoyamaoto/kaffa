package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Menu {

    public static void startApplication() throws IOException{
        boolean keepRunning = true;

        while(keepRunning){
            showMenu();
            String selectedOption = readInput("Enter the option: ");

            if      (selectedOption.equals("0"))    keepRunning = false;
            else if (selectedOption.equals("1"))    validateCNPJ();
            else if (selectedOption.equals("2"))    validateCNPJDigits();

            waitToContinue();
            simulateCleanScreen();
        }
    }

    private static void showMenu(){
        System.out.println("***************************************");
        System.out.println("* 0 - Exit Application                *");
        System.out.println("* 1 - Validate CNPJ format (Mask)     *");
        System.out.println("* 2 - Validate CNPJ Digits            *");
        System.out.println("***************************************");
        System.out.println();
    }

    private static String readInput(String message) throws IOException{
        System.out.println(message);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputValue = reader.readLine();
        return inputValue;
    }

    private static void validateCNPJ() throws IOException{
        String cnpj = readInput("Enter the CNPJ value: ");
        if(ValidateCNPJFormat.validateFormat(cnpj)) System.out.println(String.format("The CNPJ %s is a valid one", cnpj));
        else                                        System.out.println(String.format("The CNPJ %s is not a valid one", cnpj));
    }

    private static void validateCNPJDigits() throws IOException{
        String cnpj = readInput("Enter the CNPJ value: ");
        if(ValidateCNPJDigits.checkDigits(cnpj))    System.out.println(String.format("The CNPJ %s is a valid one", cnpj));
        else                                        System.out.println(String.format("The CNPJ %s is not a valid one", cnpj));
    }

    private static void waitToContinue() throws IOException{
        readInput("Press any key to continue");
    }

    private static void simulateCleanScreen(){
        for(int i=0; i<10; i++){
            System.out.println("\n");
        }
    }
}
