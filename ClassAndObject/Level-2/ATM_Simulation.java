import java.util.Scanner;

class ATM_Simulation{
    String accountHolder;
    String accountNumber;
    double balance;

    ATM_Simulation(String accountHolder, String accountNumber, double balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    void deposit(double amount) {
        balance += amount;
    }

    void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient balance");
        }
    }

    void displayBalance() {
        System.out.println("Current Balance: " + balance);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter account holder name: ");
        String name = scanner.nextLine();
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        System.out.print("Enter initial balance: ");
        double balance = scanner.nextDouble();
        ATM_Simulation account = new ATM_Simulation(name, accountNumber, balance);
        account.deposit(100);
        account.withdraw(50);
        account.displayBalance();
    }
}