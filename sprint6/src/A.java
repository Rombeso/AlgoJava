import java.util.ArrayList;
import java.util.Scanner;

public class A {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] firstLine = scanner.nextLine().split(" ");
        int n = Integer.parseInt(firstLine[0]); // число вершин
        int m = Integer.parseInt(firstLine[1]); // число рёбер


        // Создаем список смежности
        ArrayList<ArrayList<Integer>> adjacencyMatrices =  new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjacencyMatrices.add(new ArrayList<>());
        }

        // Заполняем список смежности
        for (int i = 0; i < m; i++) {
            String[] edge = scanner.nextLine().split(" ");
            int u = Integer.parseInt(edge[0]); // вершина от
            int v = Integer.parseInt(edge[1]); // вершина до
            adjacencyMatrices.get(u - 1).add(v);
        }

        // Выводим информацию о рёбрах, исходящих из каждой вершины
        for (int i = 0; i < n; i++) {
            System.out.print(adjacencyMatrices.get(i).size() + " "); // количество рёбер из вершины i
            for (int j = 0; j < adjacencyMatrices.get(i).size(); j++) {
                System.out.print(adjacencyMatrices.get(i).get(j) + " "); // вершины, в которые ведут рёбра
            }
            System.out.println(); // переходим на новую строку для следующей вершины
        }
    }
}
