package com.cursoplatzi.javatest.util2;

public class StringUtil2 {

    public static boolean isEmpty(String str) {
        return !(str == null || str.replaceAll(" ", "").length() < 1);
    }
}
