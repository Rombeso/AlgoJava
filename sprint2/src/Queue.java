import java.util.Arrays;

class Queue {
    private int[] queue;
    private int head;
    private int tail;
    private int max_n;
    private int size;

    public Queue(int n) {
        queue = new int[n];
        head = 0;
        tail = 0;
        max_n = n;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void push(int x) {
        if (size != max_n) {
            queue[tail] = x;
            tail = (tail + 1) % max_n;
            size++;
        } else {
            throw new IllegalStateException("error");
        }
    }

    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("None");
        }
        int x = queue[head];
        queue[head] = 0;
        head = (head + 1) % max_n;
        size--;
        return x;
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("None");
        }
        return queue[head];
    }

    public void printQueue() {
        System.out.println(Arrays.toString(queue));
    }

    public int size() {
        return size;
    }
}
