public class C {
    public static Node<String> solution(Node<String> head, int idx) {
        // Your code
        if (idx == 0) {
            return head.next;
        }
        Node previousNode = getNodeByIndex(head, idx-1);
        Node currentNode = getNodeByIndex(head, idx);
        previousNode.next = currentNode.next;
        while (head != null) {
            System.out.println(head.value);
            head = head.next;
        }
        return head;
    }
    public static Node getNodeByIndex(Node node, int index) {
        while (index > 0) {
            node = node.next;
            index--;
        }
        return node;
    }
    public static void main(String[] args) {
        Node<String> node3 = new Node<>("node3", null);
        Node<String> node2 = new Node<>("node2", node3);
        Node<String> node1 = new Node<>("node1", node2);
        Node<String> node0 = new Node<>("node0", node1);
        Node<String> newHead = solution(node0, 1);
        assert newHead == node0;
        assert newHead.next == node2;
        assert newHead.next.next == node3;
        assert newHead.next.next.next == null;
        // result is : node0 -> node2 -> node3
    }
}

