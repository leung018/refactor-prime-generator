import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrimeGeneratorTest {

    @Test
    public void testGeneratePrimes() {
        int[] expected = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47};
        int[] result = PrimeGenerator.generatePrimes(50);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testGeneratePrimesWithMaxValueLessThanTwo() {
        int[] expected = new int[]{};
        int[] result = PrimeGenerator.generatePrimes(1);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testGeneratePrimesWithTwoAsMaxValue() {
        int[] expected = new int[]{2};
        int[] result = PrimeGenerator.generatePrimes(2);
        assertArrayEquals(expected, result);
    }
}