public class B {
    public static boolean treeSolution(Node head) {
        // Your code
        // “ヽ(´▽｀)ノ”
        if (head == null) {
            return true;
        }
        int leftHeight = getHeight(head.left);
        int rightHeight = getHeight(head.right);

        int heightDiff = Math.abs(leftHeight - rightHeight);
        boolean resSolution = heightDiff <= 1 && treeSolution(head.left) && treeSolution(head.right);
        return resSolution;
    }

    private static int getHeight(Node head) {
        if (head == null) return 0;
        int resHeight = Math.max(getHeight(head.left), getHeight(head.right)) + 1;
        return resHeight;
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

    private static void test() {
        Node node1 = new Node(1);
        Node node2 = new Node(-5);
        Node node3 = new Node(3);
        node3.left = node1;
        node3.right = node2;
        Node node4 = new Node(10);
        Node node5 = new Node(2);
        node5.left = node3;
        node5.right = node4;
//        assert treeSolution(node5);
        System.out.println(treeSolution(node5));
    }

    public static void main(String[] args) {
        test();
    }
}