public class J {
    public static Node insert(Node root, int key) {
        // Your code
        // “ヽ(´▽｀)ノ”
        if (root == null) {
            root = new Node(null, null, key);
            return root;
        }

        if (root.getValue() > key) {
            root.setLeft(insert(root.getLeft(), key));
        } else if (root.getValue() <= key) {
            root.setRight(insert(root.getRight(), key));
        }

        return root;
    }

    // <template>
    private static class Node {
        private int value;
        private Node left;
        private Node right;

        Node(Node left, Node right, int value) {
            this.left = left;
            this.right = right;
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }
    // <template>

    private static void test() {
        Node node1 = new Node(null, null, 7);
        Node node2 = new Node(node1, null, 8);
        Node node3 = new Node(null, node2, 7);
        Node newHead = insert(node3, 6);
        Node newHead2 = insert(newHead, 8);
        assert newHead == node3;
        assert newHead.getLeft().getValue() == 6;
        System.out.println(newHead.getLeft().getValue());
        System.out.println(newHead.getRight().getValue());
        System.out.println(newHead2.getRight().getValue());
        System.out.println(newHead2.getLeft().getValue());
    }

    public static void main(String[] args) {
        test();
    }
}
