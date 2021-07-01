package com.cursoplatzi.javatest.util;

public class StringUtil {
    public static String repeact(String str, int times) {
        if (times < 0) {
            throw new IllegalArgumentException("negative times not allowed");
        }
        String s = "";
        for (int i = 0; i < times; i++) {
            s += str;
        }
        return s;
    }
}
