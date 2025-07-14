import java.util.Arrays;

public class SalarySorter {

    // Heap Sort implementation
    public static void heapSort(int[] salaries) {
        int n = salaries.length;

        // Step 1: Build max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(salaries, n, i);
        }

        // Step 2: Extract elements from heap one by one
        for (int i = n - 1; i > 0; i--) {
            // Swap current root with end
            int temp = salaries[0];
            salaries[0] = salaries[i];
            salaries[i] = temp;

            // Re-heapify the reduced heap
            heapify(salaries, i, 0);
        }
    }

    // Heapify a subtree rooted at index i in array of size n
    private static void heapify(int[] arr, int n, int i) {
        int largest = i;       // Initialize largest as root
        int left = 2 * i + 1;  // left child
        int right = 2 * i + 2; // right child

        // If left child is larger than root
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        // If right child is larger than largest so far
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // If largest is not root, swap and continue heapifying
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            // Recursively heapify the affected subtree
            heapify(arr, n, largest);
        }
    }

    public static void main(String[] args) {
        int[] expectedSalaries = {50000, 70000, 45000, 60000, 80000};

        System.out.println("Original Salaries: " + Arrays.toString(expectedSalaries));
        heapSort(expectedSalaries);
        System.out.println("Sorted Salaries  : " + Arrays.toString(expectedSalaries));
    }
}
