package com.cursoplatzi.javatest.exercise;

//Reto # 1
public class FizzBuzz {
    public static String fizzBuzz(int i) {
        String num = "";
        if (i % 3 == 0) {
            num += "Fizz";
        }
      if (i % 5 == 0) {
            num += "Buzz";
        }
        return num.isEmpty() ? i + "" : num;
    }
}
