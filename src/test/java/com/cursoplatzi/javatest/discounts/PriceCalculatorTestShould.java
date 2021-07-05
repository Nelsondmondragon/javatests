package com.cursoplatzi.javatest.discounts;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PriceCalculatorTestShould {
    private PriceCalculator calculator;


    @Before
    public void setup() {
        calculator = new PriceCalculator();
    }

    @Test
    public void total_zero_when_there_are_prices() {
        assertEquals(0, calculator.getTotal(), 0);
    }

    @Test
    public void total_is_the_sum_of_prices() {
        calculator.addPrice(10.00);
        calculator.addPrice(15);
        assertEquals(25, calculator.getTotal(), 0);
    }

    @Test
    public void apply_discount_to_prices() {
        calculator.addPrice(50);
        calculator.addPrice(50);
        calculator.addPrice(100);
        calculator.setDiscount(25);
        assertEquals(150, calculator.getTotal(), 0);
    }
}