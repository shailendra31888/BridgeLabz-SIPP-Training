
class Stall {

    String name;
    int footfall;

    public Stall(String name, int footfall) {
        this.name = name;
        this.footfall = footfall;
    }

    @Override
    public String toString() {
        return name + " (" + footfall + ")";
    }
}

public class FoodFestMergeSort {

    // Merge two sorted arrays of stalls
    public static Stall[] mergeSortedStalls(Stall[] zoneA, Stall[] zoneB) {
        int n = zoneA.length, m = zoneB.length;
        Stall[] merged = new Stall[n + m];
        int i = 0, j = 0, k = 0;
        while (i < n && j < m) {
            if (zoneA[i].footfall <= zoneB[j].footfall) {
                merged[k++] = zoneA[i++];
            } else {
                merged[k++] = zoneB[j++];
            }
        }
        while (i < n) {
            merged[k++] = zoneA[i++];
        }
        while (j < m) {
            merged[k++] = zoneB[j++];
        }
        return merged;
    }

    // Merge sort for stalls array
    public static void mergeSort(Stall[] stalls, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(stalls, left, mid);
            mergeSort(stalls, mid + 1, right);
            merge(stalls, left, mid, right);
        }
    }

    private static void merge(Stall[] stalls, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        Stall[] L = new Stall[n1];
        Stall[] R = new Stall[n2];
        for (int i = 0; i < n1; i++) {
            L[i] = stalls[left + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = stalls[mid + 1 + j];
        }

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i].footfall <= R[j].footfall) {
                stalls[k++] = L[i++];
            } else {
                stalls[k++] = R[j++];
            }
        }
        while (i < n1) {
            stalls[k++] = L[i++];
        }
        while (j < n2) {
            stalls[k++] = R[j++];
        }
    }

    public static void main(String[] args) {
        // Zone A and Zone B are already sorted by footfall
        Stall[] zoneA = {
            new Stall("Pizza", 120),
            new Stall("Burger", 150),
            new Stall("Sushi", 200)
        };
        Stall[] zoneB = {
            new Stall("Tacos", 100),
            new Stall("Pasta", 180),
            new Stall("Ice Cream", 220)
        };

        System.out.println("Zone A:");
        for (Stall s : zoneA) {
            System.out.println(s);
        }
        System.out.println("Zone B:");
        for (Stall s : zoneB) {
            System.out.println(s);
        }

        Stall[] masterList = mergeSortedStalls(zoneA, zoneB);

        System.out.println("\nMaster list after merging:");
        for (Stall s : masterList) {
            System.out.println(s);
        }

        // If you want to sort a combined unsorted list:
        Stall[] unsorted = {
            new Stall("Pizza", 120),
            new Stall("Burger", 150),
            new Stall("Sushi", 200),
            new Stall("Tacos", 100),
            new Stall("Pasta", 180),
            new Stall("Ice Cream", 220)
        };
        mergeSort(unsorted, 0, unsorted.length - 1);

        System.out.println("\nMaster list after merge sort:");
        for (Stall s : unsorted) {
            System.out.println(s);
        }
    }
}
