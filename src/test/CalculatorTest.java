package test;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {
    private static Calculator calculator = new Calculator();
    @Before
    public void setUp() {
        calculator.clear();
    }

    @Test
    public void testAdd() {
        calculator.add(2);
        calculator.add(3);
        assertEquals(5, calculator.getResult());
    }

    @Test
    public void testSubtract() {
        calculator.add(10);
        calculator.subtract(2);
        assertEquals(8, calculator.getResult());
    }

    @Test
    public void testMultiply() {
        calculator.add(2);
        calculator.multiply(3);
        assertEquals(6, calculator.getResult());
    }

    @Test
    public void testDivide() {
        calculator.add(9);
        calculator.divide(3);
        assertEquals(3, calculator.getResult());
    }

    @Ignore
    public void testCubic() {
        calculator.cubic(2);
        assertEquals(8, calculator.getResult());
    }

    @Test(timeout = 1000)
    public void squareRoot() {
        calculator.squareRoot(4);
        assertEquals(2, calculator.getResult());
    }

}
