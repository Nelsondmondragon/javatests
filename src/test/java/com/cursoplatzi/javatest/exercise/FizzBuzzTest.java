package com.cursoplatzi.javatest.exercise;

import org.junit.Test;

import static org.junit.Assert.*;

public class FizzBuzzTest {

    @Test
    public void number_is_divisible_by_3() {
        assertEquals("Fizz", FizzBuzz.fizzBuzz(3));
    }

    @Test
    public void number_is_divisible_by_5() {
        assertEquals("Buzz", FizzBuzz.fizzBuzz(5));
    }

    @Test
    public void number_is_divisible_by_3_and_5() {
        assertEquals("FizzBuzz", FizzBuzz.fizzBuzz(15));
    }
}