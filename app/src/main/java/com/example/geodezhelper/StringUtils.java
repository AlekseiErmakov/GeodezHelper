package com.example.geodezhelper;

import java.util.Locale;

public class StringUtils {
    public static String coordTxt(Double a){
        return a != null ? String.format(Locale.ENGLISH,"%.3f",a) : "";
    }
    public static String reportTxt(Integer a){
        return a != null ? String.format(Locale.ENGLISH,"%d",a) : "";
    }
}
