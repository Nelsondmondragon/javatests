package com.cursoplatzi.javatest;

import com.cursoplatzi.javatest.util.StringUtil;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringUtilTest {

    @Test
    public void repeat_string_once(){
        assertEquals("hola", StringUtil.repeact("hola",1));
    }

    @Test
    public void repeat_string_multiple_times(){
        assertEquals("holaholahola",StringUtil.repeact("hola",3));
    }

    @Test
    public void repeat_string_zero_times(){
        assertEquals("",StringUtil.repeact("hola",0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void repeat_string_negative_times(){
        StringUtil.repeact("hola",-1);
    }
}