import java.util.*;

public class SlidingWindowMax {

    public static List<Integer> maxInSlidingWindow(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < nums.length; i++) {
            // Remove indices out of current window
            while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            // Remove smaller elements (they won't be max)
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            // Add current index
            deque.offerLast(i);

            // Starting from i = k - 1, collect the max
            if (i >= k - 1) {
                result.add(nums[deque.peekFirst()]);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        List<Integer> maxWindow = maxInSlidingWindow(arr, k);

        System.out.println("Array:       " + Arrays.toString(arr));
        System.out.println("Window Size: " + k);
        System.out.println("Max in Each Window: " + maxWindow);
    }
}
