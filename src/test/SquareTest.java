package test;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

@RunWith(Parameterized.class)
public class SquareTest {

    private static Calculator calculator = new Calculator();
    private int param;
    private int result;

    @Rule
    public ExpectedException thrown = ExpectedException.none();


    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][] {
                {2, 4},
                {0, 0},
                {-3, 9},
                {-15, 225},
        });
    }

    public SquareTest(int param, int result) {
        this.param = param;
        this.result = result;
    }

    @Test
    public void square() {
        calculator.square(param);
        assertEquals(result, calculator.getResult());
    }

    @Test
    public void divideByZeroThrowsException() {
        try {
            calculator.add(8);
            calculator.divide(0);
            fail("Fail by test DivideByZero!");
        } catch (java.lang.ArithmeticException arithmeticException) {
            assertTrue(arithmeticException.getMessage().contains("/ by zero"));
        }
    }

    @Test(expected = java.lang.ArithmeticException.class)
    public void divideByZero() {
        calculator.add(8);
        calculator.divide(0);
    }

    @Test
    public void TheThirdDivideByZero() throws java.lang.ArithmeticException {
        thrown.expect(java.lang.ArithmeticException.class);
        thrown.expectMessage("/ by zero");
        calculator.add(8);
        calculator.divide(0);
    }

}
