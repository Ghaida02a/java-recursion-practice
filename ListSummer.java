import java.util.Arrays;
import java.util.List;

public class ListSummer {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);

        System.out.println("Calculating sum using recursion...");

        int totalSum = calculateSumRecursive(numbers, 0);

        System.out.println("--------------------------");
        System.out.println("The final sum is: " + totalSum);
    }

    // Recursive function to calculate sum
    public static int calculateSumRecursive(List<Integer> nums, int index) {
        if (index == nums.size()) {
            return 0;
        }
        int currentSum = nums.get(index) + calculateSumRecursive(nums, index + 1);
        System.out.println("Current sum " + currentSum);
        return currentSum;
    }
}
