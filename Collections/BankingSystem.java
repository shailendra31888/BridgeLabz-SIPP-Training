
import java.util.*;

class WithdrawalRequest {

    String accountNumber;
    double amount;

    public WithdrawalRequest(String accountNumber, double amount) {
        this.accountNumber = accountNumber;
        this.amount = amount;
    }
}

public class BankingSystem {

    private Map<String, Double> accountMap = new HashMap<>();
    private TreeMap<Double, String> balanceSortedMap = new TreeMap<>();
    private Queue<WithdrawalRequest> withdrawalQueue = new LinkedList<>();

    // Add a customer account
    public void addAccount(String accountNumber, double balance) {
        accountMap.put(accountNumber, balance);
        balanceSortedMap.put(balance, accountNumber);
    }

    // Display all accounts (HashMap)
    public void displayAccounts() {
        System.out.println("Customer Accounts (HashMap):");
        for (Map.Entry<String, Double> entry : accountMap.entrySet()) {
            System.out.println("Account: " + entry.getKey() + ", Balance: $" + entry.getValue());
        }
    }

    // Display accounts sorted by balance (TreeMap)
    public void displaySortedByBalance() {
        System.out.println("Accounts sorted by balance (TreeMap):");
        for (Map.Entry<Double, String> entry : balanceSortedMap.entrySet()) {
            System.out.println("Account: " + entry.getValue() + ", Balance: $" + entry.getKey());
        }
    }

    // Add withdrawal request to queue
    public void addWithdrawalRequest(String accountNumber, double amount) {
        withdrawalQueue.offer(new WithdrawalRequest(accountNumber, amount));
        System.out.println("Withdrawal request added for account " + accountNumber + ": $" + amount);
    }

    // Process withdrawal requests
    public void processWithdrawals() {
        while (!withdrawalQueue.isEmpty()) {
            WithdrawalRequest req = withdrawalQueue.poll();
            Double balance = accountMap.get(req.accountNumber);
            if (balance == null) {
                System.out.println("Account not found: " + req.accountNumber);
                continue;
            }
            if (balance >= req.amount) {
                accountMap.put(req.accountNumber, balance - req.amount);
                System.out.println("Withdrawal of $" + req.amount + " from account " + req.accountNumber + " successful.");
            } else {
                System.out.println("Insufficient funds for account " + req.accountNumber);
            }
        }
        // Update balanceSortedMap after withdrawals
        balanceSortedMap.clear();
        for (Map.Entry<String, Double> entry : accountMap.entrySet()) {
            balanceSortedMap.put(entry.getValue(), entry.getKey());
        }
    }

    public static void main(String[] args) {
        BankingSystem bank = new BankingSystem();

        bank.addAccount("A1001", 5000);
        bank.addAccount("A1002", 3000);
        bank.addAccount("A1003", 7000);

        bank.displayAccounts();
        bank.displaySortedByBalance();

        bank.addWithdrawalRequest("A1001", 1200);
        bank.addWithdrawalRequest("A1002", 3500);
        bank.addWithdrawalRequest("A1003", 2000);

        bank.processWithdrawals();

        bank.displayAccounts();
        bank.displaySortedByBalance();
    }
}
