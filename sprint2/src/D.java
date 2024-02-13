public class D {
    public static int solution(Node<String> head, String elem) {
        // Your code
        int index = 0;
        while (true) {
            if (head == null) {return -1;}
            if (head.value.equals(elem)) {return index;}
            head = head.next;
            index++;
        }
    }
    public static void main(String[] args) {
        Node<String> node3 = new Node<>("node3", null);
        Node<String> node2 = new Node<>("node2", node3);
        Node<String> node1 = new Node<>("node1", node2);
        Node<String> node0 = new Node<>("node0", node1);
        int idx = solution(node0, "node20");
        assert idx == 2;
        System.out.println(idx);
    }
}
