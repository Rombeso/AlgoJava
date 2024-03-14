package Final;

import java.io.*;
import java.util.*;

public class HashTable {

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

        while (count-- !=0) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            String command = tokenizer.nextToken();

            if(command.equals(COMMAND_PUT)) {
                int key = Integer.parseInt(tokenizer.nextToken());
                int value = Integer.parseInt(tokenizer.nextToken());

                map.put(key, value);
            } else if(command.equals(COMMAND_GET)) {
                int key = Integer.parseInt(tokenizer.nextToken());

                Integer value = map.get(key);
                if(value == null) {
                    out.append(NONE);
                    out.append("\n");
                }
                else {
                    out.append(value);
                    out.append("\n");
                }

            } else if(command.equals(COMMAND_DELETE)) {
                int key = Integer.parseInt(tokenizer.nextToken());

                Integer value = map.remove(key);
                if(value == null) {
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

        Node<K, V>[] table;

        public MyHashMap(int capacity) {
            this.table = new Node[capacity];
        }


        private int indexFor(int h, int length) {
            return  h % length;
        }

        public V put(K key, V value) {
            int index = indexFor((Integer) key, table.length);
            Node<K, V> node = table[index];

            while (node != null) {
                if (key.equals(node.getKey())) {
                    V oldValue = node.setValue(value);
                    return oldValue;
                }
                node = node.next;
            }

            node = table[index];
            if (node == null) {
                table[index] = new Node(key, value, null);
            } else {
                table[index] = new Node(key, value, node);
            }

            return null;
        }

        public V get(Object key) {
            int index = indexFor((Integer)key, table.length);
            Node<K, V> node = table[index];

            while (node != null) {
                if (key.equals(node.getKey())) {
                    return node.getValue();
                }
                node = node.next;
            }
            return null;
        }

        public V remove(Object key) {
            int index = indexFor((Integer)key, table.length);
            Node<K, V> node = table[index];
            Node<K, V> previous = null;

            while (node != null) {
                if (key.equals(node.getKey())) {
                    if (previous == null)
                        table[index] = node.next;
                    else
                        previous.next = node.next;
                    return node.getValue();
                }
                previous = node;
                node = node.next;
            }
            return null;
        }

        public static class Node<K, V> {
            private final K key;
            private V value;
            private Node<K, V> next;

            public Node(K key, V value, Node<K, V> next) {
                this.key = key;
                this.value = value;
                this.next = next;
            }

            public K getKey() {
                return key;
            }

            public V getValue() {
                return value;
            }

            public V setValue(V value) {
                V oldValue = this.value;
                this.value = value;
                return oldValue;
            }
        }
    }
}