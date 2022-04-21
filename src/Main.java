import learning.GenericInterview;
import stack.StackArrayImpl;

public class Main {

    public static void main(String[] args) {
        //Swap two numbers without using any third variable
        GenericInterview genericInterview = new GenericInterview();
        genericInterview.swapNumbers(10, 11);
        // check the number is a palindrome
        genericInterview.checkPalindrome(12345);
        int number = 1;
        int count = 1;
        while(count <= 10) {
            if(genericInterview.isPrime(number)) {
                count++;
                System.out.println("Prime Numbers " + number);
            }
            number++;
        }

        StackArrayImpl stackArray = new StackArrayImpl(2);
        System.out.println(stackArray);
        try {
            stackArray.push(5);
            stackArray.push(8);
            System.out.println("*********************Fixed Stack Array Implementation*********************");
            System.out.println("Print stack elements before pop(): " + stackArray.toString());
            System.out.println("Size of stack : " + stackArray.size());
            System.out.println("Pop element from Stack : " + stackArray.pop());
            System.out.println("Pop element from Stack : " + stackArray.pop());
            System.out.println("Pop element from Stack : " + stackArray.pop());

            System.out.println("Print stack elements after opo() : " + stackArray.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
