import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

class StackMaxx {
    private Deque<Integer> stack;
    private Deque<Integer> maxStack;

    public StackMaxx() {
        stack = new ArrayDeque<>();
        maxStack = new ArrayDeque<>();
    }

    public void push(int value) {
        stack.push(value);
        if (maxStack.isEmpty() || value >= maxStack.peek()) {
            maxStack.push(value);
        }
    }

    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("error");
        }
        int popped = stack.pop();
        if (popped == maxStack.peek()) {
            maxStack.pop();
        }
        return popped;
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("error");
        }
        return stack.peek();
    }

    public int getMax() {
        if (isEmpty()) {
            throw new IllegalStateException("None");
        }
        return maxStack.peek();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}

class MaxEffective3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        StackMaxx stackMax = new StackMaxx();
        for (int i = 0; i < n; i++) {
            String command = scanner.next();
            switch (command) {
                case "push":
                    int x = scanner.nextInt();
                    stackMax.push(x);
                    break;
                case "pop":
                    try {
                        stackMax.pop();
                    } catch (IllegalStateException e) {
                        System.out.println("error");
                    }
                    break;
                case "get_max":
                    try {
                        System.out.println(stackMax.getMax());
                    } catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "top":
                    try {
                        System.out.println(stackMax.peek());
                    } catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    System.out.println("Unknown command");
            }
        }
    }
}
