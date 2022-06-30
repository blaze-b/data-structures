import java.util.Scanner;

public class J7ControlStatements {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the first value");
        int x = scanner.nextInt();
        System.out.println("Enter the second value");
        int y = scanner.nextInt();

        //Sample if
        if (x + y > 10)
            System.out.println("Sum::" + (x + y));
        else
            System.out.println("Could not print as the sum is less than 10");

        //Switch Statements
        System.out.println("Enter the date for testing: ");
        int date = scanner.nextInt();
        String day = null;
        switch (date) {
            case 1:
                day = "Sunday";
                break;
            case 2:
                day = "Monday";
                break;
            case 3:
                day = "Tuesday";
                break;
            case 4:
                day = "Wednesday";
                break;
            case 5:
                day = "Thursday";
                break;
            case 6:
                day = "Friday";
                break;
            case 7:
                day = "Saturday";
                break;
            // Default case
            default:
                day = "Invalid day";

        }
        System.out.println("Day for the entered date: " + day);

        System.out.println("Inside a sample do while loop");
        do {
            System.out.println(x);
            x++;
        } while (x < 10);
        System.out.println("Final value::" + x);

        System.out.println("Inside a sample while loop");
        while (x > 1) {
            System.out.println(x);
            x--;
        }

        System.out.println("Final value::" + x);
        System.out.println("Enter the for loop");
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }

        System.out.println("For each loop");
        int[] arrayDetails = new int[]{1, 2, 3, 8, 19, 9, 11};
        for (int arrayElement : arrayDetails) {
            System.out.println(arrayElement);
        }

        System.out.println("Break And Continue example");
        int[] finalArray = new int[arrayDetails.length];
        int counter = 0;
        for (int array : arrayDetails) {
            if (array == 8) {
                System.out.println("Breaking");
                break;
            }
            finalArray[counter] = array;
            counter++;
        }

        for (int i = 0; i < finalArray.length; i++) {
            if (finalArray[i] != 0)
                System.out.println("Final array = " + finalArray[i]);
        }

        counter = 0;
        for (int array : arrayDetails) {
            if (array == 8) {
                System.out.println("Continuing");
                continue;
            }
            finalArray[counter] = array;
            counter++;
        }
        for (int i = 0; i < finalArray.length; i++) {
            if (finalArray[i] != 0)
                System.out.println("Final array = " + finalArray[i]);
        }
    }

}
