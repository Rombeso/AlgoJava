public class A {
    public static int treeSolution(Node head) {
        // Your code
        // “ヽ(´▽｀)ノ”
        if (head == null) {
            return Integer.MIN_VALUE;
        }

        int maxBrightness = head.value;

        int leftMax = treeSolution(head.left);

        int rightMax = treeSolution(head.right);

        maxBrightness = Math.max(maxBrightness, Math.max(leftMax, rightMax));

        return maxBrightness;

    }

    // <template>
    private static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
    // <template>

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(-5);
        Node node3 = new Node(3);
        node3.left = node1;
        node3.right = node2;
        Node node4 = new Node(2);
        node4.left = node3;
        assert treeSolution(node4) == 3;
    }
}
