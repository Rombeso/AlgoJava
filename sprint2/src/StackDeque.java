import java.util.ArrayDeque;
import java.util.Deque;

class StackDeque {
    private Deque<String> stack;

    public StackDeque() {
        stack = new ArrayDeque<>();
    }

    public void push(String value) {
        stack.push(value);
    }

    public String pop() {
        if (isEmpty()) {
            throw new IllegalStateException("error");
        }
        String popped = stack.pop();
        return popped;
    }

    public String peek() {
        if (isEmpty()) {
            throw new IllegalStateException("error");
        }
        return stack.peek();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}


