import java.util.LinkedList;

public class StackLinkedList {
    private LinkedList<Integer> stack; // Основной стэк
    private LinkedList<Integer> max; // Стэк для хранения макс числа

    public StackLinkedList() {
        stack = new LinkedList<>();
        max = new LinkedList<>();
    }

    public void push(int value){
        if (max.isEmpty() || value > max.peekLast()) {
            max.add(value);
        }
        stack.add(value);

    }

    public String pop() {
        if (stack.isEmpty()) {
            return "error";
        }
        int value = stack.pollLast();
        if (value == max.peekLast()) {
            max.pollLast();
        }
        return "";
    }

    public String peek() {
        if (stack.isEmpty()) {
            return "error";
        }
        return String.valueOf(stack.peekLast());
    }

    public String getMax(){
        if (stack.isEmpty()) {
            return "None";
        } else {
            return String.valueOf(max.peekLast());
        }
    }

}
