import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class L_ExcessiveLetter {

    private static char getExcessiveLetter(String s, String t) {
        // Ваше решение

        char[] sortCharS = s.toCharArray();
        Arrays.sort(sortCharS);
        char[] sortCharT = t.toCharArray();
        Arrays.sort(sortCharT);

        for (int i = 0; i < sortCharS.length && i < sortCharT.length; i++) {
            if(sortCharS[i] != sortCharT[i]) {
                return sortCharT[i];
            }
        }
        return sortCharT[sortCharT.length-1];
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String s = reader.readLine();
            String t = reader.readLine();
            System.out.println(getExcessiveLetter(s, t));

        }
    }
}