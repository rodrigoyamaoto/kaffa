package com.company;

public class ValidateCNPJFormat {

    public static boolean validateFormat(String cnpj){

        if(cnpj.length() == 18)         return checksWithSpecialChactared(cnpj);
        else if(cnpj.length() == 14)    return checksWithoutSpecialChactared(cnpj);
        else                            return false;
    }

    /**
     * Use Regex to checks if the CNPJ matches.
     * Must follow the pattern: xx.xxx.xxx/xxxx-xx
     *
     * regex used = ^\d{2}\.\d{3}\.\d{3}\/\d{4}\-\d{2}$ that equals to
     *              ^\d\d\.\d\d\d\.\d\d\d\/\d\d\d\d\-\d\d$
     */
    private static boolean checksWithSpecialChactared(String cnpj){
        boolean response = false;
        String pattern = "^\\d{2}\\.\\d{3}\\.\\d{3}\\/\\d{4}\\-\\d{2}$";
        response = cnpj.matches(pattern);
        return response;
    }

    /**
     * Use Regex to checks if the CNPJ matches.
     * Must follow the pattern: xxxxxxxxxxxxxx
     *
     * regex used = ^\d{14}$ that equals to
     *              ^\d\d\d\d\d\d\d\d\d\d\d\d\d\d$
     */
    private static boolean checksWithoutSpecialChactared(String cnpj){
        boolean response = false;
        String pattern = "^\\d{14}$";
        response = cnpj.matches(pattern);
        return response;
    }
}
