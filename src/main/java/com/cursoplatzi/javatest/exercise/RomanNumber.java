package com.cursoplatzi.javatest.exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

//Reto #2
public class RomanNumber {
    static Map<Integer, String> roman = new TreeMap<>();

    public static String arabicToRoman(int number) {
        roman.put(1, "I");
        roman.put(2, "II");
        roman.put(3, "III");
        roman.put(4, "IV");
        roman.put(5, "V");
        roman.put(6, "VI");
        roman.put(7, "VII");
        roman.put(8, "VIII");
        roman.put(9, "IX");
        roman.put(10, "X");
        roman.put(40, "XL");
        roman.put(50, "L");
        roman.put(90, "XC");
        roman.put(100, "C");
        roman.put(400, "CD");
        roman.put(500, "D");
        roman.put(900, "CM");
        roman.put(1000, "M");
        if (roman.containsKey(number)) {
            return roman.get(number);
        }
        int numR = 11;
        while (numR <= number) {
            String rom = "";
            int digits = (int) (Math.pow(10, String.valueOf(numR).length() - 1));
            int unit = (numR % digits);
            int tens = numR - unit;
            if (roman.containsKey(tens)) {
                rom += roman.get(tens) + ((roman.get(unit) == null) ? "" : roman.get(unit));
            } else {
                String g = roman.get(tens - digits);
                rom += g + roman.get(digits);
            }
            roman.put(numR, rom);
            numR++;
        }
        return roman.get(number);
    }


}
