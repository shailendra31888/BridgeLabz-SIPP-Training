
import java.io.*;

public class CountWordInFile {

    public static void main(String[] args) throws IOException {
        String target = "hello";
        int count = 0;
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            for (String word : line.split("\\s+")) {
                if (word.equals(target)) {
                    count++;
                }
            }
        }
        br.close();
        System.out.println("Occurrences of '" + target + "': " + count);
    }
}
