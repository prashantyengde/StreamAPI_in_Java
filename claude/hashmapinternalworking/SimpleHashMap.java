package claude.hashmapinternalworking;

public class SimpleHashMap {

    // Each bucket holds a key-value pair and a pointer to the next (for collisions)
    static class Node {
        String key;
        String value;
        Node next;

        Node(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    // The bucket array — 8 slots
    Node[] buckets = new Node[20];

    // Turn a key into a bucket index
    int getBucketIndex(String key) {
		/*
		 * System.out.println(key.hashCode());
		 * System.out.println((Math.abs(key.hashCode())));
		 * System.out.println((Math.abs(key.hashCode()) % buckets.length));
		 */
        return Math.abs(key.hashCode()) % buckets.length;
    }

    // PUT: store a key-value pair
    void put(String key, String value) {
        int index = getBucketIndex(key);
        Node node = buckets[index];

        // Check if key already exists — update it
        while (node != null) {
            if (node.key.equals(key)) {
                node.value = value;
                return;
            }
            node = node.next;
        }

        // Key not found — add new node at the front
        Node newNode = new Node(key, value);
        newNode.next = buckets[index];
        buckets[index] = newNode;
    }

    // GET: retrieve a value by key
    String get(String key) {
        int index = getBucketIndex(key);
        Node node = buckets[index];

        while (node != null) {
            if (node.key.equals(key)) {
                return node.value;
            }
            node = node.next;
        }

        return null; // not found
    }

    // REMOVE: delete a key-value pair
    void remove(String key) {
        int index = getBucketIndex(key);
        Node node = buckets[index];
        Node prev = null;

        while (node != null) {
            if (node.key.equals(key)) {
                if (prev == null) {
                    buckets[index] = node.next;
                } else {
                    prev.next = node.next;
                }
                return;
            }
            prev = node;
            node = node.next;
        }
    }

    // PRINT: show what's inside
    void print() {
        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i] != null) {
                System.out.print("bucket[" + i + "] -> ");
                Node node = buckets[i];
                while (node != null) {
                    System.out.print("[" + node.key + "=" + node.value + "] ");
                    node = node.next;
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        SimpleHashMap map = new SimpleHashMap();

        // Put
        map.put("name", "Alice");
        map.put("name45", "Alice");
        map.put("age", "25");
        map.put("city", "Pune");
        map.put("cityR", "BLR");
       
        map.put("cityR", "BLRrrrttyy");
        map.put("Prashant", "BLRe");
        map.put("Prashant", "BLRe456");
        // Get
        System.out.println(map.get("name")); // Alice
        System.out.println(map.get("age"));  // 25

        // Update
        map.put("age", "30");
        System.out.println(map.get("age"));  // 30

        // Remove
		
		  map.remove("city");
		  System.out.println(map.get("city"));
		 // null

        // Print internals
        map.print();
        System.out.println(map);
    }
}