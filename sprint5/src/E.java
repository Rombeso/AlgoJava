public class E {
    public static boolean treeSolution(Node head) {
        // Your code
        // “ヽ(´▽｀)ノ”
        return treeSolutionRec(head, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean treeSolutionRec(Node head, int min, int max) {
        // Your code
        // “ヽ(´▽｀)ノ”
        if (head == null) {
            return true;
        }

        if (head.value <= min || head.value >= max) {
            return false;
        }

        return treeSolutionRec(head.left, min, head.value) && treeSolutionRec(head.right, head.value, max);
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

        Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    // <template>
    public static void main(String[] args) {
        Node node1 = new Node(1, null, null);
        Node node2 = new Node(4, null, null);
        Node node3 = new Node(3, node1, node2);
        Node node4 = new Node(8, null, null);
        Node node5 = new Node(5, node3, node4);
        System.out.println(treeSolution(node5));
        assert treeSolution(node5);
        node2.value = 4;
        System.out.println(treeSolution(node5));
        assert !treeSolution(node5);
    }

}

