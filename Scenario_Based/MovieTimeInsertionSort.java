
import java.time.LocalTime;

class Show {

    String movieName;
    LocalTime showTime;

    public Show(String movieName, LocalTime showTime) {
        this.movieName = movieName;
        this.showTime = showTime;
    }

    @Override
    public String toString() {
        return movieName + " at " + showTime;
    }
}

public class MovieTimeInsertionSort {

    // Insertion Sort by showTime (ascending)
    public static void insertionSort(Show[] shows) {
        int n = shows.length;
        for (int i = 1; i < n; i++) {
            Show key = shows[i];
            int j = i - 1;
            while (j >= 0 && shows[j].showTime.isAfter(key.showTime)) {
                shows[j + 1] = shows[j];
                j--;
            }
            shows[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        Show[] shows = {
            new Show("Inception", LocalTime.of(18, 30)),
            new Show("Interstellar", LocalTime.of(15, 45)),
            new Show("The Dark Knight", LocalTime.of(20, 0)),
            new Show("Tenet", LocalTime.of(17, 15)),
            new Show("Dunkirk", LocalTime.of(14, 0))
        };

        System.out.println("Before sorting:");
        for (Show s : shows) {
            System.out.println(s);
        }

        insertionSort(shows);

        System.out.println("\nAfter sorting by showtime:");
        for (Show s : shows) {
            System.out.println(s);
        }
    }
}
