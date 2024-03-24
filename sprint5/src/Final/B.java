package Final;

// <template>
class Node {
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

public class B {
    public static Node remove(Node root, int key) {
        if (root == null) {
            return null;
        }

        Node deleteParent = null;
        Node delete = root;

        while (delete.getValue() != key) {
            deleteParent = delete;

            if (delete.getValue() < key) {
                delete = delete.getRight();
            } else {
                delete = delete.getLeft();
            }

            if (delete == null) {
                return root;
            }
        }

        if (delete.getLeft() == null && delete.getRight() == null) {
            if (!(delete == root)) {
                if (deleteParent.getLeft() == delete) {
                    deleteParent.setLeft(null);
                } else {
                    deleteParent.setRight(null);
                }
            } else {
                root = null;
            }
        } else if (delete.getLeft() != null && delete.getRight() != null) {
            Node heir = getHeir(delete.getLeft());
            int value = heir.getValue();
            remove(delete, value);
            delete.setValue(value);
        } else {
            if (delete.getLeft() != null) {
                if (delete == root) {
                    root = delete.getLeft();
                } else if (deleteParent.getLeft() == delete) {
                    deleteParent.setLeft(delete.getLeft());
                } else deleteParent.setRight(delete.getLeft());
            } else {
                if (delete == root) {
                    root = delete.getRight();
                } else if (deleteParent.getLeft() == delete) {
                    deleteParent.setLeft(delete.getRight());
                } else deleteParent.setRight(delete.getRight());
            }
        }
        return root;
    }

    private static Node getHeir(Node root) {
        while (root.getRight() != null) {
            root = root.getRight();
        }
        return root;
    }

    private static void test() {
        Node node1 = new Node(null, null, 2);
        Node node2 = new Node(node1, null, 3);
        Node node3 = new Node(null, node2, 1);
        Node node4 = new Node(null, null, 6);
        Node node5 = new Node(node4, null, 8);
        Node node6 = new Node(node5, null, 10);
        Node node7 = new Node(node3, node6, 5);
        Node newHead = remove(node7, 10);
        System.out.println(newHead.getValue() == 5);
        System.out.println(newHead.getRight() == node5);
        System.out.println(newHead.getRight().getValue() == 8);
        assert newHead.getValue() == 5;
        assert newHead.getRight() == node5;
        assert newHead.getRight().getValue() == 8;
    }
}