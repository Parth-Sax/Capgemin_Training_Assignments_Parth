import org.example.Calculator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {
    Calculator calculator = new Calculator();

    @Test
    public void testAdd() {
        assertEquals(5, calculator.add(2,3));
    }

    @Test
    public void testSubtract() {
        assertEquals(4, calculator.subtract(7, 3));
    }

    @Test
    public void testMultiply() {
        assertEquals(21, calculator.multiply(7, 3));
    }

    @Test
    public void testDivide() {
        assertEquals(2, calculator.divide(6, 3));
    }

    @Test(expected = ArithmeticException.class)
    public void testDivideByZero() {
        calculator.divide(5, 0);
    }

    @Test
    public void testSquare() {
        assertEquals(9, calculator.square(3));
    }
}
