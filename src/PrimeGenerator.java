import java.util.Arrays;

/**　This is my attempt to refactor the original version of PrimeGenerator from the book 'Clean Code' written by
 * Uncle Bob in Chapter 4. I have used a different representation, but kept the same implementation,
 * which is the Sieve of Eratosthenes algorithm.
 */
public class PrimeGenerator {

    private static boolean[] primeFlags; // Indicates whether the number represented by index is prime or not.
    public static int[] generatePrimes(int maxValue) {
        if (maxValue < 2)
            return new int[0];
        else {
            initPrimeFlags(maxValue);
            return getPrimes();
        }
    }
    private static void initPrimeFlags(int maxValue) {
        primeFlags = new boolean[maxValue + 1];
        Arrays.fill(primeFlags, true);
        double limit = Math.sqrt(primeFlags.length);

        for (int i = 2; i <= limit; i++)
            if (primeFlags[i])
                for (int multiple = 2 * i;
                    multiple < primeFlags.length;
                    multiple += i)
                    primeFlags[multiple] = false;

    }
    private static int[] getPrimes() {
        int[] result = new int[numberOfPrimes()];
        for (int j = 0, i = 2; i < primeFlags.length; i++)
            if (primeFlags[i])
                result[j++] = i;
        return result;
    }

    private static int numberOfPrimes() {
        int count = 0;
        for (int i = 2; i < primeFlags.length; i++)
            if (primeFlags[i])
                count++;
        return count;
    }
}