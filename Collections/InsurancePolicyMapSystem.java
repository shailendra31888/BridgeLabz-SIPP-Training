
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

class Policy {

    private String policyNumber;
    private String policyholderName;
    private LocalDate expiryDate;
    private String coverageType;
    private double premiumAmount;

    public Policy(String policyNumber, String policyholderName, LocalDate expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public String getPolicyholderName() {
        return policyholderName;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public String getCoverageType() {
        return coverageType;
    }

    public double getPremiumAmount() {
        return premiumAmount;
    }

    @Override
    public String toString() {
        return "[" + policyNumber + "] " + policyholderName + " | " + coverageType
                + " | Expires: " + expiryDate + " | Premium: $" + premiumAmount;
    }
}

public class InsurancePolicyMapSystem {

    private Map<String, Policy> hashMap = new HashMap<>();
    private Map<String, Policy> linkedHashMap = new LinkedHashMap<>();
    private TreeMap<LocalDate, Policy> treeMap = new TreeMap<>();

    // Add policy to all maps
    public void addPolicy(Policy policy) {
        hashMap.put(policy.getPolicyNumber(), policy);
        linkedHashMap.put(policy.getPolicyNumber(), policy);
        treeMap.put(policy.getExpiryDate(), policy);
    }

    // Retrieve a policy by its number
    public Policy getPolicyByNumber(String policyNumber) {
        return hashMap.get(policyNumber);
    }

    // List all policies expiring within the next 30 days
    public void listExpiringSoon() {
        System.out.println("Policies Expiring Within 30 Days:");
        LocalDate now = LocalDate.now();
        for (Policy p : treeMap.values()) {
            long days = ChronoUnit.DAYS.between(now, p.getExpiryDate());
            if (days >= 0 && days <= 30) {
                System.out.println(p);
            }
        }
    }

    // List all policies for a specific policyholder
    public void listPoliciesByHolder(String holderName) {
        System.out.println("Policies for Policyholder: " + holderName);
        for (Policy p : hashMap.values()) {
            if (p.getPolicyholderName().equalsIgnoreCase(holderName)) {
                System.out.println(p);
            }
        }
    }

    // Remove policies that are expired
    public void removeExpiredPolicies() {
        LocalDate now = LocalDate.now();
        Iterator<Map.Entry<String, Policy>> it = hashMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Policy> entry = it.next();
            if (entry.getValue().getExpiryDate().isBefore(now)) {
                it.remove();
            }
        }
        // Remove from linkedHashMap
        it = linkedHashMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Policy> entry = it.next();
            if (entry.getValue().getExpiryDate().isBefore(now)) {
                it.remove();
            }
        }
        // Remove from treeMap
        Iterator<Map.Entry<LocalDate, Policy>> treeIt = treeMap.entrySet().iterator();
        while (treeIt.hasNext()) {
            Map.Entry<LocalDate, Policy> entry = treeIt.next();
            if (entry.getKey().isBefore(now)) {
                treeIt.remove();
            }
        }
    }

    // Display all policies in insertion order
    public void displayPoliciesInInsertionOrder() {
        System.out.println("Policies in Insertion Order (LinkedHashMap):");
        for (Policy p : linkedHashMap.values()) {
            System.out.println(p);
        }
    }

    // Display all policies sorted by expiry date
    public void displayPoliciesSortedByExpiry() {
        System.out.println("Policies Sorted by Expiry Date (TreeMap):");
        for (Policy p : treeMap.values()) {
            System.out.println(p);
        }
    }

    public static void main(String[] args) {
        InsurancePolicyMapSystem system = new InsurancePolicyMapSystem();

        system.addPolicy(new Policy("P1001", "Alice", LocalDate.now().plusDays(10), "Health", 5000));
        system.addPolicy(new Policy("P1002", "Bob", LocalDate.now().plusDays(40), "Auto", 3000));
        system.addPolicy(new Policy("P1003", "Charlie", LocalDate.now().plusDays(25), "Home", 4000));
        system.addPolicy(new Policy("P1004", "Diana", LocalDate.now().plusDays(5), "Health", 3500));
        system.addPolicy(new Policy("P1005", "Alice", LocalDate.now().minusDays(2), "Auto", 3200)); // Expired

        System.out.println("Retrieve by Policy Number (P1002):");
        System.out.println(system.getPolicyByNumber("P1002"));

        system.listExpiringSoon();
        system.listPoliciesByHolder("Alice");

        system.displayPoliciesInInsertionOrder();
        system.displayPoliciesSortedByExpiry();

        System.out.println("\nRemoving Expired Policies...");
        system.removeExpiredPolicies();

        system.displayPoliciesInInsertionOrder();
        system.displayPoliciesSortedByExpiry();
    }
}
