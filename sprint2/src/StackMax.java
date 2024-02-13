import java.util.Scanner;

public class StackMax extends Stack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());

        StackMax stack = new StackMax();

        while (count-- != 0) {
            String line = scanner.nextLine();
            String[] partsLine = line.split(" ");
            if (partsLine[0].equals("pop")) {
                stack.pop();
            }
            if (partsLine[0].equals("push")) {
                int value = Integer.parseInt(partsLine[1]);
                stack.push(value);


            }
            if (partsLine[0].equals("get_max")) {
                stack.getMax();
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

    void getMax () {
        if (top == -1) {
            System.out.println("None");
        } else {
            int max = Integer.MIN_VALUE;
            for (int i = 0; i <= top; i++) {
                if( max < stack[i]) {
                    max = stack[i];
                }
            }
            System.out.println(max);
        }
    }
}
