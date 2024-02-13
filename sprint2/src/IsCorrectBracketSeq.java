import java.util.Scanner;

class IsCorrectBracketSeq {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        if (correctBracket(command)) System.out.println("True");
        else System.out.println("False");

    }
    public static boolean correctBracket(String command){
        if (command.isEmpty()) {
            return true;
        } else if (command.length() % 2 != 0) return false;
        StackDeque stack = new StackDeque();
        char[] arrayChar = command.toCharArray();
        for (int i = 0; i < arrayChar.length; i++) {
            String symbol = Character.toString(arrayChar[i]);
            switch (symbol) {
                case "(":
                case "[":
                case "{":
                    stack.push(symbol);
                    break;
                case ")":
                    if (stack.isEmpty()) {
                        return false;
                    }
                    if (stack.pop().equals("(")) {
                        break;
                    } else {
                        return false;
                    }
                case "]":
                    if (stack.isEmpty()) {
                        return false;
                    }
                    if (stack.pop().equals("[")) {
                        break;
                    } else {
                        return false;
                    }
                case "}":
                    if (stack.isEmpty()) {
                        return false;
                    }
                    if (stack.pop().equals("{")) {
                        break;
                    } else {
                        return false;
                    }
                default:
                    break;
            }
        }
        if (!stack.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }
}