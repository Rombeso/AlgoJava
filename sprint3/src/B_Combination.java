import java.util.HashMap;
import java.util.Scanner;

public class B_Combination {
    private static HashMap<Character, String> myMap = new HashMap<>();

    static {
        myMap.put('2', "abc");
        myMap.put('3', "def");
        myMap.put('4', "ghi");
        myMap.put('5', "jkl");
        myMap.put('6', "mno");
        myMap.put('7', "pqrs");
        myMap.put('8', "tuv");
        myMap.put('9', "wxyz");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String numbers = scanner.nextLine();

        StringBuilder output = new StringBuilder();
        generateWords(numbers, 0, output, "");
        System.out.println(output);

    }

    public static void generateWords(String numbers, int index, StringBuilder result, String str) {
        if (index == numbers.length()) {
            result.append(str).append(" ");
            return;
        }
        for (char item : myMap.get(numbers.charAt(index)).toCharArray()) {
            generateWords(numbers, index + 1, result, str + item);
        }
    }
}
