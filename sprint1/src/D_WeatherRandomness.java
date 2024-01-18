import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.List;
import java.io.IOException;


public class D_WeatherRandomness {

    private static int getWeatherRandomness(List<Integer> temperatures) {
        // Ваше решение
        int chaoticDays = 0;
        if (temperatures.size() == 1) {
            return 1;
        } else {
            for (int i = 0; i < temperatures.size(); i++) {
                if (i == 0 && temperatures.get(i) > temperatures.get(i + 1)) {
                    chaoticDays++;
                } else if (i == temperatures.size() - 1 && temperatures.get(i - 1) < temperatures.get(i)) {
                    chaoticDays++;
                } else if (i != 0 && i != temperatures.size() - 1
                        && temperatures.get(i - 1) < temperatures.get(i)
                        && temperatures.get(i) > temperatures.get(i + 1)) {
                    chaoticDays++;
                }
            }
            return chaoticDays;
        }

    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int numberOfDays = readInt(reader);
            List<Integer> temperatures = readList(reader);
            int chaosNumber = getWeatherRandomness(temperatures);
            System.out.println(chaosNumber);
        }
    }

    private static int readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }

    private static List<Integer> readList(BufferedReader reader) throws IOException {
        return Arrays.asList(reader.readLine().split(" "))
                .stream()
                .map(elem -> Integer.parseInt(elem))
                .collect(Collectors.toList());
    }
}
