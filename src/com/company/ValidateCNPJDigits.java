package com.company;

import java.security.InvalidParameterException;

public class ValidateCNPJDigits {

    public static boolean checkDigits(final String CNPJ){
        boolean response = true;
        String cnpjEdited = formatCNPJ(CNPJ);

        if(!isFirstDigitValid(cnpjEdited))    response = false;
        if(!isSecondDigitValid(cnpjEdited))   response = false;

        return response;
    }

    private static String formatCNPJ(String CNPJ){
        String cnpjEdited = new String(CNPJ);

        return cnpjEdited.replaceAll("\\.", "")
                         .replaceAll("\\/","")
                         .replaceAll("\\-", "");
    }

    private static boolean isFirstDigitValid(String cnpj){
        final int MODULO_ONZE = 11;

        boolean response = true;
        int sum = 0;
        int resto = 0;
        int weight = 0;
        int digitoVerificador = 0;
        int digitoVerificadorCNPJ = Integer.parseInt(cnpj.substring(12, 13));
        char[] characters = cnpj.substring(0, 12).toCharArray();
        int charactersLenght = characters.length;

        for(int i=charactersLenght-1; i >= 0; i--){
            // Auxiliar Variables
            char character = characters[i];
            String characterAsString = String.valueOf(character);
            int characterAsInt = Integer.parseInt(characterAsString);

            weight = getNextWeight(weight);
            sum += characterAsInt * weight;
        }

        resto = sum % MODULO_ONZE;
        digitoVerificador = MODULO_ONZE - resto;

        if(digitoVerificador >= 10) digitoVerificador = 0;

        if(digitoVerificadorCNPJ == digitoVerificador) return true;
        else                                           return false;
    }

    private static boolean isSecondDigitValid(String cnpj){
        final int MODULO_ONZE = 11;

        boolean response = true;
        int sum = 0;
        int resto = 0;
        int weight = 0;
        int digitoVerificador = 0;
        int digitoVerificadorCNPJ = Integer.parseInt(cnpj.substring(13));
        char[] characters = cnpj.substring(0, 13).toCharArray();
        int charactersLenght = characters.length;

        for(int i=charactersLenght-1; i >= 0; i--){
            // Auxiliar Variables
            char character = characters[i];
            String characterAsString = String.valueOf(character);
            int characterAsInt = Integer.parseInt(characterAsString);

            weight = getNextWeight(weight);
            sum += characterAsInt * weight;
        }

        resto = sum % MODULO_ONZE;
        digitoVerificador = MODULO_ONZE - resto;

        if(digitoVerificador >= 10) digitoVerificador = 0;

        if(digitoVerificadorCNPJ == digitoVerificador) return true;
        else                                           return false;
    }

    private static int getNextWeight(int currentWeight){
        if      (currentWeight >= 2 && currentWeight < 9)   return ++currentWeight;
        else if (currentWeight == 0 || currentWeight == 9)  return 2;
        else                                                throw new InvalidParameterException("currentWeight must be between 2 and 9");
    }
}
