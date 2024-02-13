import java.util.Scanner;

public class StackMaxEffective {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();  // Считываем перевод строки после числа команд
        StackLinkedList stackMax = new StackLinkedList();
        for (int i = 0; i < n; i++) {
            String command = scanner.nextLine();
            if (command.startsWith("push")) {
                int x = Integer.parseInt(command.split(" ")[1]);
                stackMax.push(x);
            } else if (command.equals("pop")) {
                String result = stackMax.pop();
                if (result.equals("error")) {
                    System.out.println("error");
                }
            } else if (command.equals("get_max")) {
                System.out.println(stackMax.getMax());
            } else if (command.equals("top")) {
                System.out.println(stackMax.peek());
            }
        }
    }
}
