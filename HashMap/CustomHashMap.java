
public class CustomHashMap<K, V> {

    // Static inner class for key-value pairs
    private static class Node<K, V> {
        K key;
        V value;
        Node<K, V> next;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int SIZE = 16; // Default bucket size
    private Node<K, V>[] buckets;

    @SuppressWarnings("unchecked")
    public CustomHashMap() {
        // Safe generic array creation workaround
        buckets = (Node<K, V>[]) new Node[SIZE];
    }

    private int getBucketIndex(K key) {
        return Math.abs(key.hashCode()) % SIZE;
    }

    public void put(K key, V value) {
        int index = getBucketIndex(key);
        Node<K, V> head = buckets[index];

        // Check for existing key
        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value; // Update existing
                return;
            }
            head = head.next;
        }

        // Insert new at head
        Node<K, V> newNode = new Node<>(key, value);
        newNode.next = buckets[index];
        buckets[index] = newNode;
    }

    public V get(K key) {
        int index = getBucketIndex(key);
        Node<K, V> head = buckets[index];

        while (head != null) {
            if (head.key.equals(key)) {
                return head.value;
            }
            head = head.next;
        }

        return null; // Not found
    }

    public void remove(K key) {
        int index = getBucketIndex(key);
        Node<K, V> head = buckets[index];
        Node<K, V> prev = null;

        while (head != null) {
            if (head.key.equals(key)) {
                if (prev != null) {
                    prev.next = head.next;
                } else {
                    buckets[index] = head.next;
                }
                return;
            }
            prev = head;
            head = head.next;
        }
    }

    public boolean containsKey(K key) {
        return get(key) != null;
    }

    public void printMap() {
        for (int i = 0; i < SIZE; i++) {
            Node<K, V> head = buckets[i];
            while (head != null) {
                System.out.println("Key: " + head.key + ", Value: " + head.value);
                head = head.next;
            }
        }
    }

    // Test the custom hashmap
    public static void main(String[] args) {
        CustomHashMap<String, Integer> map = new CustomHashMap<>();

        map.put("apple", 10);
        map.put("banana", 20);
        map.put("orange", 30);
        map.put("banana", 25); // update test

        System.out.println("Value for 'banana': " + map.get("banana")); // 25
        System.out.println("Contains 'apple': " + map.containsKey("apple")); // true

        map.remove("apple");
        System.out.println("Contains 'apple' after removal: " + map.containsKey("apple")); // false

        System.out.println("Current Map:");
        map.printMap();
    }
}
