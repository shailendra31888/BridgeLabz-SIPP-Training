
public class ConcatenateStringsBuffer {

    public static String concat(String[] arr) {
        StringBuffer sb = new StringBuffer();
        for (String s : arr) {
            sb.append(s);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] arr = {"a", "b", "c"};
        System.out.println(concat(arr));
    }
}
