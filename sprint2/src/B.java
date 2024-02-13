public class B {
    public static void solution(Node<String> head) {
        // Your code
        while (head != null) {
            System.out.println(head.value);
            head = head.next;
        }
    }
    public static void main(String[] args) {
        Node<String> node3 = new Node<>("node3", null);
        Node<String> node2 = new Node<>("node2", node3);
        Node<String> node1 = new Node<>("node1", node2);
        Node<String> node0 = new Node<>("node0", node1);
        solution(node0);
    }
}

