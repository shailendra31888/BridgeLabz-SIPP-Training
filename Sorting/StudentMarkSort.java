import java.util.Arrays;

public class StudentMarkSort {

    // Bubble sort implementation
    public static void bubbleSort(int[] marks) {
        int n = marks.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - 1 - i; j++) {
                if (marks[j] > marks[j + 1]) {
                    // Swap
                    int temp = marks[j];
                    marks[j] = marks[j + 1];
                    marks[j + 1] = temp;
                    swapped = true;
                }
            }

            // Optimization: if no swaps occurred, array is sorted
            if (!swapped) break;
        }
    }

    public static void main(String[] args) {
        int[] marks = {85, 92, 75, 60, 99, 80};

        System.out.println("Original Marks: " + Arrays.toString(marks));
        bubbleSort(marks);
        System.out.println("Sorted Marks  : " + Arrays.toString(marks));
    }
}
