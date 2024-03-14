package Final;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class HashTable2 {

    private static final int CAPACITY = 100_000;
    private static final String COMMAND_PUT = "put";
    private static final String COMMAND_GET = "get";
    private static final String COMMAND_DELETE = "delete";
    private static final String NONE = "None";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        int count = Integer.parseInt(reader.readLine());

        MyHashMap<Integer, Integer> map = new MyHashMap<>(CAPACITY);

        while (count-- != 0) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            String command = tokenizer.nextToken();

            if (command.equals(COMMAND_PUT)) {
                int key = Integer.parseInt(tokenizer.nextToken());
                int value = Integer.parseInt(tokenizer.nextToken());

                map.put(key, value);
            } else if (command.equals(COMMAND_GET)) {
                int key = Integer.parseInt(tokenizer.nextToken());

                Integer value = map.get(key);
                if (value == null) {
                    out.append(NONE);
                    out.append("\n");
                } else {
                    out.append(value);
                    out.append("\n");
                }

            } else if (command.equals(COMMAND_DELETE)) {
                int key = Integer.parseInt(tokenizer.nextToken());

                Integer value = map.remove(key);
                if (value == null) {
                    out.append(NONE);
                    out.append("\n");
                } else {
                    out.append(value);
                    out.append("\n");
                }
            } else
                throw new RuntimeException("Unknown command");
        }

        System.out.println(out);
    }

    public static class MyHashMap<K, V> {

        ArrayList<LinkedList<Node<K, V>>> table;

        public MyHashMap(int capacity) {
            table = new ArrayList<>(capacity);
            for (int i = 0; i < capacity; i++) {
                table.add(new LinkedList<>());
            }
        }

        private int indexFor(K key, int length) {
            return Math.abs(key.hashCode() % length);
        }

        public void put(K key, V value) {
            int index = indexFor(key, table.size());
            LinkedList<Node<K, V>> bucket = table.get(index);

            for (Node<K, V> node : bucket) {
                if (key.equals(node.getKey())) {
                    node.setValue(value);
                    return;
                }
            }

            bucket.add(new Node<>(key, value));
        }

        public V get(K key) {
            int index = indexFor(key, table.size());
            LinkedList<Node<K, V>> bucket = table.get(index);

            for (Node<K, V> node : bucket) {
                if (key.equals(node.getKey())) {
                    return node.getValue();
                }
            }
            return null;
        }

        public V remove(K key) {
            int index = indexFor(key, table.size());
            LinkedList<Node<K, V>> bucket = table.get(index);

            for (Node<K, V> node : bucket) {
                if (key.equals(node.getKey())) {
                    bucket.remove(node);
                    return node.getValue();
                }
            }
            return null;
        }

        public static class Node<K, V> {
            private final K key;
            private V value;

            public Node(K key, V value) {
                this.key = key;
                this.value = value;
            }

            public K getKey() {
                return key;
            }

            public V getValue() {
                return value;
            }

            public void setValue(V value) {
                this.value = value;
            }
        }
    }
}
