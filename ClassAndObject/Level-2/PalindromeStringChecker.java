import java.util.Scanner;

class PalindromeStringChecker{
    String text;

    PalindromeStringChecker(String text) {
        this.text = text;
    }

    boolean isPalindrome() {
        String reversed = new StringBuilder(text).reverse().toString();
        return text.equals(reversed);
    }

    void displayResult() {
        if (isPalindrome()) {
            System.out.println(text + " is a palindrome.");
        } else {
            System.out.println(text + " is not a palindrome.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = scanner.nextLine();
        PalindromeStringChecker checker = new PalindromeStringChecker(text);
        checker.displayResult();
    }
}