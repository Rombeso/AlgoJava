public class Stack {
    protected int top = -1;

    final int[] stack = new int[1_000];

    int pop () {
        return stack[top--];
    }

    int push (int value) {
        return stack[++top] = value;
    }

    int peek () {
        return stack[top];
    }

    int size() {
        return top + 1;
    }

}
