package learning;

import java.util.Arrays;

public class ArraysSort {

    public int[] getSortedArrays(int inputSize, int[] inputArray) {
        Arrays.sort(inputArray);
        int firstElement = inputArray[0];
        boolean isEven = false;
        int[] finalList = new int[inputSize];
        if(firstElement % 2 == 0)
            isEven = true;
        if(isEven) {
            System.out.println("Even Number");
        }
        return inputArray;
    }

    public static void main(String[] args) {
        ArraysSort arraysSort = new ArraysSort();
        int[] sortedArray = arraysSort.getSortedArrays(5, new int[] {5, 8, 10, 7, 11});
        for(int i = 0; i < sortedArray.length; i++) {
            System.out.println(sortedArray[i]);
        }
    }
}
