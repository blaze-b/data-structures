import learning.GenericInterview;

public class Main {
    public static void main(String[] args) {
        //Swap two numbers without using any third variable
        GenericInterview genericInterview = new GenericInterview();
//        genericInterview.swapNumbers(10, 11);
//        // check the number is a palindrome
//        genericInterview.checkPalindrome(12345);

        int number = 1;
        int count = 1;
        while(count <= 10) {
            if(genericInterview.isPrime(number)) {
                count++;
                System.out.println("Prime Numbers " + number);
            }
            number++;
        }
    }
}
