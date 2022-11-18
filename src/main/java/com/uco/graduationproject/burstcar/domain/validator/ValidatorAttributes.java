package com.uco.graduationproject.burstcar.domain.validator;

import java.util.List;

public class ValidatorAttributes {

    private static final String PATTERN_PASSWORD = "^(?=.*\\d)(?=.*[\\u0021-\\u002b\\u003c-\\u0040])(?=.*[A-Z])(?=.*[a-z])\\S{8,16}";
    private static final String PATTERN_EMAIL = "^[a-zA-Z0-9_!#$%&'\\*+/=?{|}~^.-]+@[a-zA-Z0-9.-]+$";

    private ValidatorAttributes() {
    }

    public static void validateRequired(String valor, String message) {
        if(valor == null || valor.isBlank()) {
            throw new IllegalArgumentException(message);
        }
    }

    private static void sizePassword(String valor, String message)
    {
        if(!(valor.length()>=8 && valor.length()<=16))
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
            ValidatorAttributes.sizePassword(password, "Valor del tamaño excedido");
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
