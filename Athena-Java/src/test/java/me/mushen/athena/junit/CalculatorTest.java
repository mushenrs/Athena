package me.mushen.athena.junit;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @Desc
 * @Author Remilia
 * @Create 2016-09-05
 */
public class CalculatorTest {

    @Test
    public void testAdd(){
        Calculator calculator = new Calculator();
        double result = calculator.add(10, 20);
        assertEquals(30, result, 0);
    }
}
