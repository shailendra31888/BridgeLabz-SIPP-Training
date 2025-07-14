
public class FindSentenceWithWord {

    public static String findSentence(String[] sentences, String word) {
        for (String s : sentences) {
            if (s.contains(word)) {
                return s;
            }
        }
        return "Not Found";
    }

    public static void main(String[] args) {
        String[] sentences = {"hello world", "java programming", "search me"};
        System.out.println(findSentence(sentences, "java"));
    }
}
