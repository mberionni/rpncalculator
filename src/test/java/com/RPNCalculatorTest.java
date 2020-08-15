package com;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RPNCalculatorTest {
    private RPNCalc rpn;

    @BeforeEach
    void setUp() {
        this.rpn = new RPNCalc();
    }

    private void testInternal(String in, String expected) {
        String ret = rpn.process(in);
        expected = ("stack: " + expected).trim();
        assertEquals(ret, expected, "The function returned \""+ ret + "\", while \""+ expected + "\" was expected.");
    }

    @Test
    public void testEx1() {
        testInternal("5 2", "5 2");
    }

    @Test
    public void testEx2() {
        testInternal("2 sqrt", "1.4142135623");
        testInternal("clear 9 sqrt", "3");
    }

    @Test
    public void testEx3() {
        testInternal("5 2 -", "3");
        testInternal("3 -", "0");
        testInternal("clear", "");
    }

    @Test
    public void testEx4() {
        testInternal("5 4 3 2", "5 4 3 2");
        testInternal("undo undo *", "20");
        testInternal("5 *", "100");
        testInternal("undo", "20 5");
    }

    @Test
    public void testEx5() {
        testInternal("7 12 2 /", "7 6");
        testInternal("*", "42");
        testInternal("4 /", "10.5");
    }

    @Test
    public void testEx6() {
        testInternal("1 2 3 4 5", "1 2 3 4 5");
        testInternal("*", "1 2 3 20");
        testInternal("clear 3 4 -", "-1");
    }

    @Test
    public void testEx7() {
        testInternal("1 2 3 4 5", "1 2 3 4 5");
        testInternal("* * * *", "120");
    }

    @Test
    public void testEx8() {
        testInternal("1 2 3 * 5 + * * 6 5", "11");
    }

    @Test
    public void testEx7Ex8() {
        testInternal("1 2 3 4 5", "1 2 3 4 5");
        testInternal("* * * *", "120");
        rpn.clearState();
        testInternal("1 2 3 * 5 + * * 6 5", "11");
    }
}
