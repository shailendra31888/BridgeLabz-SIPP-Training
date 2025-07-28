
import java.util.*;

public class VotingSystem {

    private Map<String, Integer> voteMap = new HashMap<>();
    private Map<String, Integer> voteOrderMap = new LinkedHashMap<>();
    private TreeMap<String, Integer> sortedVoteMap = new TreeMap<>();

    // Cast a vote for a candidate
    public void castVote(String candidate) {
        // HashMap: store/update total votes
        voteMap.put(candidate, voteMap.getOrDefault(candidate, 0) + 1);

        // LinkedHashMap: maintain order of votes
        voteOrderMap.put(candidate, voteOrderMap.getOrDefault(candidate, 0) + 1);

        // TreeMap: update sorted votes
        sortedVoteMap.put(candidate, sortedVoteMap.getOrDefault(candidate, 0) + 1);
    }

    // Display votes in insertion order (LinkedHashMap)
    public void displayVotesInOrder() {
        System.out.println("Votes in order of casting (LinkedHashMap):");
        for (Map.Entry<String, Integer> entry : voteOrderMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    // Display votes in sorted order (TreeMap)
    public void displaySortedResults() {
        System.out.println("Sorted Results (TreeMap):");
        for (Map.Entry<String, Integer> entry : sortedVoteMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    // Display total votes (HashMap)
    public void displayTotalVotes() {
        System.out.println("Total Votes (HashMap):");
        for (Map.Entry<String, Integer> entry : voteMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        VotingSystem system = new VotingSystem();

        system.castVote("Alice");
        system.castVote("Bob");
        system.castVote("Alice");
        system.castVote("Charlie");
        system.castVote("Bob");
        system.castVote("Alice");

        system.displayTotalVotes();
        system.displayVotesInOrder();
        system.displaySortedResults();
    }
}
