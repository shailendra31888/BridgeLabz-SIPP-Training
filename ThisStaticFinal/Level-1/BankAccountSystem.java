public class BankAccountSystem{
    private static String bankName = "Global Bank";
    private static int totalAccounts = 0;
    private final int accountNumber;
    private String accountHolderName;

    public BankAccountSystem(String accountHolderName) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = ++totalAccounts;
    }

    public static int getTotalAccounts() {
        return totalAccounts;
    }

    public void displayDetails() {
        if (this instanceof BankAccountSystem) {
            System.out.println("Account Holder: " + accountHolderName);
            System.out.println("Account Number: " + accountNumber);
            System.out.println("Bank Name: " + bankName);
        }
    }

    public static void main(String[] args) {
        BankAccountSystem account1 = new BankAccountSystem("Alice");
        account1.displayDetails();
        BankAccountSystem account2 = new BankAccountSystem("Bob");
        account2.displayDetails();
        System.out.println("Total Accounts: " + BankAccountSystem.getTotalAccounts());
    }
}