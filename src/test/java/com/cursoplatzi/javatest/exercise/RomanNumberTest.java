package com.cursoplatzi.javatest.exercise;

import org.junit.Test;

import static org.junit.Assert.*;

public class RomanNumberTest {


    @Test
    public void number_is_roman() {
        assertEquals("I", RomanNumber.arabicToRoman(1));
        assertEquals("II", RomanNumber.arabicToRoman(2));
        assertEquals("III", RomanNumber.arabicToRoman(3));
        assertEquals("V", RomanNumber.arabicToRoman(5));
        assertEquals("VI", RomanNumber.arabicToRoman(6));
        assertEquals("VII", RomanNumber.arabicToRoman(7));
        assertEquals("X", RomanNumber.arabicToRoman(10));
        assertEquals("XI", RomanNumber.arabicToRoman(11));
        assertEquals("XV", RomanNumber.arabicToRoman(15));
        assertEquals("XVI", RomanNumber.arabicToRoman(16));
        assertEquals("L", RomanNumber.arabicToRoman(50));
        assertEquals("LI", RomanNumber.arabicToRoman(51));
        assertEquals("LV", RomanNumber.arabicToRoman(55));
        assertEquals("LVI", RomanNumber.arabicToRoman(56));
        assertEquals("LX", RomanNumber.arabicToRoman(60));
        assertEquals("LXX", RomanNumber.arabicToRoman(70));
        assertEquals("LXXX", RomanNumber.arabicToRoman(80));
        assertEquals("LXXXI", RomanNumber.arabicToRoman(81));
        assertEquals("LXXXV", RomanNumber.arabicToRoman(85));
        assertEquals("LXXXVI", RomanNumber.arabicToRoman(86));
        assertEquals("CXXVI", RomanNumber.arabicToRoman(126));
        assertEquals("MMDVII", RomanNumber.arabicToRoman(2507));
        assertEquals("IV",RomanNumber.arabicToRoman(4));
        assertEquals("IX",RomanNumber.arabicToRoman(9));
        assertEquals("XIV",RomanNumber.arabicToRoman(14));
        assertEquals("XIX",RomanNumber.arabicToRoman(19));
        assertEquals("XXIV",RomanNumber.arabicToRoman(24));
        assertEquals("XL",RomanNumber.arabicToRoman(40));
        assertEquals("XLIX",RomanNumber.arabicToRoman(49));
        assertEquals("XC",RomanNumber.arabicToRoman(90));
        assertEquals("XCIX",RomanNumber.arabicToRoman(99));
        assertEquals("CD",RomanNumber.arabicToRoman(400));
        assertEquals("CM",RomanNumber.arabicToRoman(900));



    }
}