import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class A_Circles {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        HashMap<String, Integer> mapper = new HashMap<String, Integer>();
        for (int i = 0; i < n; i++) {
            String str = reader.readLine();
            // Если ключ уже есть в мапе
            if (mapper.containsKey(str)) {
                continue;
            }
            mapper.put(str, i);
        }
        // Создаем список пар ключ-значение
        List<Map.Entry<String, Integer>> list = new LinkedList<>(mapper.entrySet());
        // Сортируем список по значению (количеству повторений строки)
        list.sort(Map.Entry.comparingByValue());
        // Выводим отсортированные строки
        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey());
        }
    }
}
