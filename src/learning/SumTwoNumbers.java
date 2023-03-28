package learning;

public class SumTwoNumbers {

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            System.out.println("number: "+ nums[i]);
            int firstNumber = nums[i];
            for (int j = 0 ; j < nums.length; j++) {
                if (firstNumber != nums [j]) {
                    int sum = firstNumber + nums[j];
                    if (sum == target)
                      return new int [] {i, j};
                }
            }
        }
        return new int [] {0, 1};
    }

    public static void main(String[] args) {
        SumTwoNumbers sumTwoNumbers = new SumTwoNumbers();
        sumTwoNumbers.twoSum(new int [] {3,2,3}, 6);
    }
}
