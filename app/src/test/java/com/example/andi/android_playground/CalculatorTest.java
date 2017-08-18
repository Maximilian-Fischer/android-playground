package com.example.andi.android_playground;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {

    @Test
    public void simpleTest() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testCalculate() {
        MainActivity mainActivity = new MainActivity();

        long result = mainActivity.calculate(40,2);

        assertEquals(42l, result);
    }
}
