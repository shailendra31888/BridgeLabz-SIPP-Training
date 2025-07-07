package Encapsulation_Polymorphism;

interface Transactable {
    void deposit(double amount);
    void withdraw(double amount);
}

abstract class Account implements Transactable {
    private String accountHolder;
    private String accountNumber;
    protected double balance;

    public Account(String accountHolder, String accountNumber, double balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void displayAccountInfo() {
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: ₹" + balance);
    }

    public abstract void deposit(double amount);
    public abstract void withdraw(double amount);
}

class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(String accountHolder, String accountNumber, double balance, double interestRate) {
        super(accountHolder, accountNumber, balance);
        this.interestRate = interestRate;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited ₹" + amount + " to Savings Account.");
    }

    @Override
    public void withdraw(double amount) {
        if (balance - amount >= 500) {
            balance -= amount;
            System.out.println("Withdrew ₹" + amount + " from Savings Account.");
        } else {
            System.out.println("Minimum balance of ₹500 must be maintained.");
        }
    }

    public void displayAccountInfo() {
        super.displayAccountInfo();
        System.out.println("Account Type: Savings");
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}

class CurrentAccount extends Account {
    private double overdraftLimit;

    public CurrentAccount(String accountHolder, String accountNumber, double balance, double overdraftLimit) {
        super(accountHolder, accountNumber, balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited ₹" + amount + " to Current Account.");
    }

    @Override
    public void withdraw(double amount) {
        if (balance + overdraftLimit >= amount) {
            balance -= amount;
            System.out.println("Withdrew ₹" + amount + " from Current Account.");
        } else {
            System.out.println("Withdrawal exceeds overdraft limit.");
        }
    }

    public void displayAccountInfo() {
        super.displayAccountInfo();
        System.out.println("Account Type: Current");
        System.out.println("Overdraft Limit: ₹" + overdraftLimit);
    }
}

public class BankManagementSystem {
    public static void main(String[] args) {
        Account acc1 = new SavingsAccount("Priya Sharma", "SB101", 5000, 4.5);
        Account acc2 = new CurrentAccount("Pragati Gupta", "CA201", 10000, 3000);

        acc1.displayAccountInfo();
        acc1.deposit(2000);
        acc1.withdraw(3000);
        acc1.withdraw(6000);  
        System.out.println("----------------");

        acc2.displayAccountInfo();
        acc2.withdraw(12000); 
        acc2.withdraw(5000);  
    }
}

