import java.util.*;

public class PairWithGivenSum {

    public static boolean hasPairWithSum(int[] arr, int targetSum) {
        Set<Integer> seen = new HashSet<>();

        for (int num : arr) {
            int complement = targetSum - num;
            if (seen.contains(complement)) {
                System.out.println("Pair found: (" + complement + ", " + num + ")");
                return true;
            }
            seen.add(num);
        }

        System.out.println("No pair with the given sum exists.");
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {8, 7, 2, 5, 3, 1};
        int targetSum = 10;

        hasPairWithSum(arr, targetSum);
    }
}
