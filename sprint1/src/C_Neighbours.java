import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.io.IOException;

public class C_Neighbours {

    private static List<Integer> getNeighbours(List<List<Integer>> matrix, int row, int col) {
        // Ваше решение
        List<Integer> res = new ArrayList<Integer>();
        if (row != 0) {
            res.add(matrix.get(row - 1).get(col)); // Получ. эл сверху
        }
        if (row != matrix.size() - 1) {
            res.add(matrix.get(row + 1).get(col)); // Получение эл снизу
        }
        if (col != 0) {
            res.add(matrix.get(row).get(col - 1));
        }
        if (col != matrix.get(0).size() - 1) {
            res.add(matrix.get(row).get(col + 1));
        }
        Collections.sort(res);
        return res;
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int rowsCount = readInt(reader);
            int colsCount = readInt(reader);
            List<List<Integer>> matrix = readMatrix(reader, rowsCount);
            int rowId = readInt(reader);
            int colId = readInt(reader);
            List<Integer> neighbours = getNeighbours(matrix, rowId, colId);
            for (int element : neighbours) {
                System.out.print(element + " ");
            }
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

    private static List<List<Integer>> readMatrix(BufferedReader reader, int rowsCount) throws IOException {
        List<List<Integer>> matrix = new ArrayList<>(rowsCount);
        for (int i = 0; i < rowsCount; i++) {
            matrix.add(readList(reader));
        }
        return matrix;
    }
}