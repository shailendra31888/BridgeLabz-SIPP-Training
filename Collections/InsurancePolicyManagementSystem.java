
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

class Policy implements Comparable<Policy> {

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
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Policy)) {
            return false;
        }
        Policy policy = (Policy) o;
        return Objects.equals(policyNumber, policy.policyNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(policyNumber);
    }

    @Override
    public int compareTo(Policy other) {
        return this.expiryDate.compareTo(other.expiryDate);
    }

    @Override
    public String toString() {
        return "[" + policyNumber + "] " + policyholderName + " | " + coverageType
                + " | Expires: " + expiryDate + " | Premium: $" + premiumAmount;
    }
}

public class InsurancePolicyManagementSystem {

    private Set<Policy> hashSet = new HashSet<>();
    private Set<Policy> linkedHashSet = new LinkedHashSet<>();
    private Set<Policy> treeSet = new TreeSet<>();
    private Map<String, Integer> policyNumberCount = new HashMap<>();

    // Add policy to all sets
    public void addPolicy(Policy policy) {
        hashSet.add(policy);
        linkedHashSet.add(policy);
        treeSet.add(policy);
        policyNumberCount.put(policy.getPolicyNumber(),
                policyNumberCount.getOrDefault(policy.getPolicyNumber(), 0) + 1);
    }

    // Display all unique policies (HashSet)
    public void displayAllUniquePolicies() {
        System.out.println("All Unique Policies (HashSet):");
        for (Policy p : hashSet) {
            System.out.println(p);
        }
    }

    // Display policies in insertion order (LinkedHashSet)
    public void displayPoliciesInInsertionOrder() {
        System.out.println("Policies in Insertion Order (LinkedHashSet):");
        for (Policy p : linkedHashSet) {
            System.out.println(p);
        }
    }

    // Display policies sorted by expiry date (TreeSet)
    public void displayPoliciesSortedByExpiry() {
        System.out.println("Policies Sorted by Expiry Date (TreeSet):");
        for (Policy p : treeSet) {
            System.out.println(p);
        }
    }

    // Policies expiring within next 30 days
    public void displayExpiringSoon() {
        System.out.println("Policies Expiring Within 30 Days:");
        LocalDate now = LocalDate.now();
        for (Policy p : treeSet) {
            long days = ChronoUnit.DAYS.between(now, p.getExpiryDate());
            if (days >= 0 && days <= 30) {
                System.out.println(p);
            }
        }
    }

    // Policies with specific coverage type
    public void displayByCoverageType(String coverageType) {
        System.out.println("Policies with Coverage Type: " + coverageType);
        for (Policy p : hashSet) {
            if (p.getCoverageType().equalsIgnoreCase(coverageType)) {
                System.out.println(p);
            }
        }
    }

    // Display duplicate policies by policy number
    public void displayDuplicatePolicies() {
        System.out.println("Duplicate Policies (by Policy Number):");
        for (String num : policyNumberCount.keySet()) {
            if (policyNumberCount.get(num) > 1) {
                System.out.println("Policy Number: " + num + " (Count: " + policyNumberCount.get(num) + ")");
            }
        }
    }

    public static void main(String[] args) {
        InsurancePolicyManagementSystem system = new InsurancePolicyManagementSystem();

        system.addPolicy(new Policy("P1001", "Alice", LocalDate.now().plusDays(10), "Health", 5000));
        system.addPolicy(new Policy("P1002", "Bob", LocalDate.now().plusDays(40), "Auto", 3000));
        system.addPolicy(new Policy("P1003", "Charlie", LocalDate.now().plusDays(25), "Home", 4000));
        system.addPolicy(new Policy("P1001", "Alice", LocalDate.now().plusDays(10), "Health", 5000)); // Duplicate
        system.addPolicy(new Policy("P1004", "Diana", LocalDate.now().plusDays(5), "Health", 3500));

        system.displayAllUniquePolicies();
        system.displayPoliciesInInsertionOrder();
        system.displayPoliciesSortedByExpiry();
        system.displayExpiringSoon();
        system.displayByCoverageType("Health");
        system.displayDuplicatePolicies();
    }
}
