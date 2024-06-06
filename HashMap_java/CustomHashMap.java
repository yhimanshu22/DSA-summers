import java.util.*;

public class CustomHashMap {
    static class HashMap<K, V> {
        // Node class to store key-value pairs
        private class Node {
            K key;
            V value;

            public Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int n; // number of nodes
        private int N; // size of buckets array
        private LinkedList<Node>[] buckets; // buckets array

        // Constructor to initialize the HashMap
        @SuppressWarnings("unchecked")
        public HashMap() {
            this.N = 4;
            this.buckets = new LinkedList[4];
            for (int i = 0; i < 4; i++) {
                this.buckets[i] = new LinkedList<>();
            }
        }

        // Hash function to calculate bucket index
        private int hashFunction(K key) {
            int bi = key.hashCode();
            return Math.abs(bi) % N;
        }

        // Search for a key in a specific linked list (bucket) and return its index
        private int searchInLL(K key, int bi) {
            LinkedList<Node> ll = buckets[bi];
            for (int i = 0; i < ll.size(); i++) {
                if (ll.get(i).key.equals(key)) {
                    return i; // data index in linked list
                }
            }
            return -1; // key not found
        }

        // Rehash the HashMap when the load factor exceeds a threshold
        @SuppressWarnings("unchecked")
        private void rehash() {
            LinkedList<Node>[] oldBuckets = buckets;
            buckets = new LinkedList[N * 2];
            N = N * 2;
            for (int i = 0; i < buckets.length; i++) {
                buckets[i] = new LinkedList<>();
            }

            for (int i = 0; i < oldBuckets.length; i++) {
                LinkedList<Node> ll = oldBuckets[i];
                for (Node node : ll) {
                    put(node.key, node.value);
                }
            }
        }

        // Insert a key-value pair into the HashMap
        public void put(K key, V value) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if (di == -1) {
                // key doesn't exist, add new node
                buckets[bi].add(new Node(key, value));
                n++;
            } else {
                // key exists, update value
                Node node = buckets[bi].get(di);
                node.value = value;
            }

            // Check load factor and rehash if necessary
            double lambda = (double) n / N;
            if (lambda > 2.0) {
                rehash();
            }
        }

        // Check if a key exists in the HashMap
        public boolean containsKey(K key) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);
            return di != -1;
        }

        // Remove a key-value pair from the HashMap
        public V remove(K key) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if (di == -1) {
                return null; // key doesn't exist
            } else {
                Node node = buckets[bi].remove(di);
                n--;
                return node.value;
            }
        }

        // Get the value associated with a key
        public V get(K key) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if (di == -1) {
                return null; // key doesn't exist
            } else {
                Node node = buckets[bi].get(di);
                return node.value;
            }
        }

        // Get a list of all keys in the HashMap
        public ArrayList<K> keySet() {
            ArrayList<K> keys = new ArrayList<>();

            for (int i = 0; i < buckets.length; i++) {
                LinkedList<Node> ll = buckets[i];
                for (Node node : ll) {
                    keys.add(node.key);
                }
            }
            return keys;
        }

        // Check if the HashMap is empty
        public boolean isEmpty() {
            return n == 0;
        }
    }

    public static void main(String args[]) {
        HashMap<String, Integer> map = new HashMap<>();

        map.put("India", 190);
        map.put("China", 200);
        map.put("US", 50);

        ArrayList<String> keys = map.keySet();

        for (String key : keys) {
            System.out.println(key + " " + map.get(key));
        }
    }
}
