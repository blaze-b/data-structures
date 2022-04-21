package learning;

import java.io.StringReader;

/**
 * The type Generic interview.
 */
public class GenericInterview {

    /**
     * Swap numbers without using the operator
     *
     * @param a the a
     * @param b the b
     */
    public void swapNumbers(int a, int b) {
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("Swapped a -> " + a + "Swapped b -> " + b);
    }

    public boolean checkPalindrome(int input) {
        int reverse = 0;
        boolean palindrome = false;
        while (input != 0) {
            int number = input % 10;
            reverse = reverse * 10 + number;
            input /= 10;
        }
        if (input == reverse)
            palindrome = true;
        return palindrome;
    }

    public boolean isPrime(int number) {
        if(number == 1 || number == 0)
            return true;
        if(number == 2)
            return true;
        for(int i = 2; i <= Math.sqrt(number); i++) {
            if(number%i==0)
                return false;
            return true;
        }
        return false;
    }
}
