package Final;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

class StackCalc {
    private LinkedList<Integer> stack;

    public StackCalc() {
        stack = new LinkedList<>();
    }

    public void push(int x) {
        stack.push(x);
    }

    public int pop() {
        return stack.pop();
    }

    public int size() {
        return stack.size();
    }
}

public class B_Calc {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] arrayLine = reader.readLine().split(" ");
        StackCalc stack = new StackCalc();
        for (int i = 0; i < arrayLine.length; i++) {
            String element = arrayLine[i];
            if (element.equals("*") || element.equals("/") || element.equals("+") || element.equals("-")) {
                if (stack.size() < 2) {
                    writer.write("error");
                    writer.newLine();
                    writer.flush();
                    return;
                }
            }
            switch (element) {
                case "*":
                        int secondMult = stack.pop();
                        int firstMult = stack.pop();
                        stack.push(firstMult * secondMult);
                    break;
                case "/":
                        int secondDiv = stack.pop();
                        int firstDiv = stack.pop();
                        stack.push(Math.floorDiv(firstDiv, secondDiv));
                    break;
                case "+":
                        int secondAdd = stack.pop();
                        int firstAdd = stack.pop();
                        stack.push(firstAdd + secondAdd);
                    break;
                case "-":
                        int secondSub = stack.pop();
                        int firstSub = stack.pop();
                        stack.push(firstSub - secondSub);
                    break;
                default:
                    stack.push(Integer.parseInt(element));
            }
        }
        writer.write(String.valueOf(stack.pop()));
        writer.newLine();
        writer.flush();
    }
}