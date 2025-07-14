import java.util.Arrays;

public class EmployeeIdSorter {

    // Insertion sort implementation
    public static void insertionSort(int[] empIds) {
        for (int i = 1; i < empIds.length; i++) {
            int key = empIds[i];
            int j = i - 1;

            // Shift larger elements to the right
            while (j >= 0 && empIds[j] > key) {
                empIds[j + 1] = empIds[j];
                j--;
            }

            // Insert key at correct position
            empIds[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] employeeIDs = {105, 102, 110, 101, 108};

        System.out.println("Original Employee IDs: " + Arrays.toString(employeeIDs));
        insertionSort(employeeIDs);
        System.out.println("Sorted Employee IDs  : " + Arrays.toString(employeeIDs));
    }
}