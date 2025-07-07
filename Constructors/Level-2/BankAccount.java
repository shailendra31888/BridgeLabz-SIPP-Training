public class BankAccount {
    public String accountNumber;
    protected String accountHolder;
    private double balance;

    public BankAccount(String accountNumber, String accountHolder, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        }
    }

    public static class SavingsAccount extends BankAccount {
        private double interestRate;

        public SavingsAccount(String accountNumber, String accountHolder, double initialBalance, double interestRate) {
            super(accountNumber, accountHolder, initialBalance);
            this.interestRate = interestRate;
        }

        public void applyInterest() {
            double interest = getBalance() * interestRate / 100;
            deposit(interest);
        }
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount("123456", "John Doe", 1000.0);
        account.deposit(500);
        account.withdraw(200);
        System.out.println("Account Balance: $" + account.getBalance());

        SavingsAccount savingsAccount = new SavingsAccount("654321", "Jane Doe", 2000.0, 5);
        savingsAccount.applyInterest();
        System.out.println("Savings Account Balance after interest: $" + savingsAccount.getBalance());
    }
}