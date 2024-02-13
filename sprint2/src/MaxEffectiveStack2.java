import java.util.Scanner;

public class MaxEffectiveStack2 extends Stack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());

        MaxEffectiveStack2 stack = new MaxEffectiveStack2();
        Stack max = new Stack();

        while (count-- != 0) {
            String line = scanner.nextLine();
            String[] partsLine = line.split(" ");
            if (partsLine[0].equals("pop")) {
                if (stack.top != -1 && stack.peek() == max.peek()) {
                    max.pop();
                }
                stack.pop();
            }
            if (partsLine[0].equals("push")) {
                int value = Integer.parseInt(partsLine[1]);
                if (max.top == -1 || value > max.peek()) {
                    max.push(value);
                }
                stack.push(value);
            }
            if (partsLine[0].equals("get_max")) {
                if (stack.top == -1) {
                    System.out.println("None");
                } else {
                    System.out.println(max.peek());
                }
            }
            if (partsLine[0].equals("top")) {
                if (stack.top == -1) {
                    System.out.println("error");
                } else {
                    System.out.println(stack.peek());
                }
            }
        }
    }

    @Override
    int pop() {
        if (top == -1) {
            System.out.println("error");
            return Integer.MIN_VALUE;
        } else  {
            return super.pop();
        }
    }
}

