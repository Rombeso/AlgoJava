package Final;

import java.util.Arrays;
import java.util.OptionalInt;

class QueueDeque {
    private Integer[] queue;
    private int head;
    private int tail;
    private int max_n;
    private int size;

    public QueueDeque(Integer n) {
        queue = new Integer[n];
        head = 0;
        tail = 0;
        max_n = n;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void pushBack(int x) {
        if (size != max_n) {
            queue[tail] = x;
            tail = (tail + 1) % (max_n);
            size++;
        } else {
            throw new IllegalStateException("error");
        }
    }

    public void pushFront(int x) {
        if (size != max_n) {
            head = (head - 1 + max_n) % (max_n);
            queue[head] = x;
            size++;
        } else {
            throw new IllegalStateException("error");
        }
    }

    public OptionalInt popFront() {
        if (isEmpty()) {
            return OptionalInt.empty();
        }
        int x = queue[head];
        queue[head] = null;
        head = (head + 1) % (max_n);
        size--;
        return OptionalInt.of(x);
    }

    public OptionalInt popBack() {
        if (isEmpty()) {
            return OptionalInt.empty();
        }
        tail = (tail - 1 + max_n) % max_n;
        int x = queue[tail];
        queue[tail] = null;
        size--;
        return OptionalInt.of(x);
    }


    public OptionalInt peek() {
        if (isEmpty()) {
            return OptionalInt.empty();
        }
        return OptionalInt.of(queue[head]);
    }

    public void printQueue() {
        System.out.println(Arrays.toString(queue));
    }
    public int size() {
        return size;
    }
}
