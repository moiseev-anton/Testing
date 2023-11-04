package Homework01.Calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {

    @Test
    public void testCalculator() {
        assertThat(Calculator.calculatingDiscount(100, 20)).isEqualTo(80);
        assertThat(Calculator.calculatingDiscount(100, 0)).isEqualTo(100);

        assertThatThrownBy(() -> Calculator.calculatingDiscount(-100, 20)).isInstanceOf(ArithmeticException.class);
        assertThatThrownBy(() -> Calculator.calculatingDiscount(100, 120)).isInstanceOf(ArithmeticException.class);
        assertThatThrownBy(() -> Calculator.calculatingDiscount(100, -20)).isInstanceOf(ArithmeticException.class);
    }
}