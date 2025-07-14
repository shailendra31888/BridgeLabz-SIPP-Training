import java.util.Arrays;

public class StudentAgeSorter {

    public static void countingSort(int[] ages, int minAge, int maxAge) {
        int range = maxAge - minAge + 1;
        int[] count = new int[range];
        int[] output = new int[ages.length];

        // Step 1: Count occurrences
        for (int age : ages) {
            count[age - minAge]++;
        }

        // Step 2: Cumulative count
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        // Step 3: Build output array (iterate from end to maintain stability)
        for (int i = ages.length - 1; i >= 0; i--) {
            int age = ages[i];
            int index = count[age - minAge] - 1;
            output[index] = age;
            count[age - minAge]--;
        }

        // Step 4: Copy output to original array
        for (int i = 0; i < ages.length; i++) {
            ages[i] = output[i];
        }
    }

    public static void main(String[] args) {
        int[] studentAges = {15, 12, 18, 10, 17, 12, 14, 13, 16};

        System.out.println("Original Ages: " + Arrays.toString(studentAges));
        countingSort(studentAges, 10, 18);
        System.out.println("Sorted Ages  : " + Arrays.toString(studentAges));
    }
}
