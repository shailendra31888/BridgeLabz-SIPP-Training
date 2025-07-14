
public class CompareStringBufferBuilder {

    public static void main(String[] args) {
        int n = 1_000_000;
        String str = "hello";
        long startSB = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(str);
        }
        long endSB = System.nanoTime();

        long startSF = System.nanoTime();
        StringBuffer sf = new StringBuffer();
        for (int i = 0; i < n; i++) {
            sf.append(str);
        }
        long endSF = System.nanoTime();

        System.out.println("StringBuilder: " + (endSB - startSB) / 1e6 + " ms");
        System.out.println("StringBuffer: " + (endSF - startSF) / 1e6 + " ms");
    }
}
