package com.uco.graduationproject.burstcar.domain.validator;

import java.util.List;

public class ValidatorAttributes {

    private static final String PATTERN_PASSWORD = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\\\S+$).{8,}$";
    private static final String PATTERN_EMAIL = "^[\\w-]+(\\.[\\w-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    private ValidatorAttributes() {
    }

    public static void validateRequired(String valor, String message) {
        if(valor == null || valor.isBlank()) {
            throw new IllegalArgumentException(message);
        }
    }

    private static void sizePassword(String valor, String message)
    {
        if(valor.length()>=8 && valor.length()<=15)
        {
            throw new IllegalArgumentException(message);
        }
    }

    public static void noEmpty(List<? extends Object> list, String message){
        if(list == null || list.isEmpty()){
            throw  new IllegalArgumentException(message);
        }
    }

    private static boolean acceptancePatternPassword(String data, String pattern)
    {
        return data.matches(pattern);
    }

    private static boolean acceptancePatternEmail(String data, String pattern)
    {
        return data.matches(pattern);
    }

    public static void specialCharactersPassword(String password, String message)
    {
        if(!acceptancePatternPassword(password, PATTERN_PASSWORD))
        {
            throw new IllegalArgumentException(message);
        }
        else{
            ValidatorAttributes.sizePassword(password, message);
        }
    }

    public static void specialCharactersEmail(String email, String message)
    {
        if(!acceptancePatternEmail(email, PATTERN_EMAIL))
        {
            throw new IllegalArgumentException(message);
        }
    }
}
