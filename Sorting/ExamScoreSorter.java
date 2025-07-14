import java.util.Arrays;

public class ExamScoreSorter {

    // Selection sort implementation
    public static void selectionSort(int[] scores) {
        int n = scores.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            // Find the index of the minimum element
            for (int j = i + 1; j < n; j++) {
                if (scores[j] < scores[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap if needed
            if (minIndex != i) {
                int temp = scores[i];
                scores[i] = scores[minIndex];
                scores[minIndex] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] examScores = {72, 88, 95, 60, 84};

        System.out.println("Original Exam Scores: " + Arrays.toString(examScores));
        selectionSort(examScores);
        System.out.println("Sorted Exam Scores  : " + Arrays.toString(examScores));
    }
}
