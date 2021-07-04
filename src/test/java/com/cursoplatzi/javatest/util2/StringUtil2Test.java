package com.cursoplatzi.javatest.util2;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringUtil2Test {

    @Test
    public void string_null_is_empty() {
        assertFalse(StringUtil2.isEmpty(null));
    }

    @Test
    public void string_is_empty() {
        assertFalse(StringUtil2.isEmpty(""));
    }

    @Test
    public void space_is_empty() {
        assertFalse(StringUtil2.isEmpty(" "));
    }

    @Test
    public void string_is_not_empty() {
        assertTrue(StringUtil2.isEmpty("w"));
    }


}