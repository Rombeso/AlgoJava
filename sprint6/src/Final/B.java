package Final;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class B {

    public static ArrayList<ArrayList<Integer>> neighborList = new ArrayList<>();
    public static int[] coloring;
    public static int vertexCount;

    public static void main(String[] args) throws IOException {
        readDirectedGraph();
        viewLoopInGraph();
    }

    private static void readDirectedGraph() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        vertexCount = Integer.parseInt(reader.readLine());

        initializeNeighborList();
        addArcs(reader);
    }

    private static void initializeNeighborList() {
        for (int i = 0; i <= vertexCount; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            neighborList.add(list);
        }
    }

    private static void addArcs(BufferedReader reader) throws IOException {
        for (int i = 1; i < vertexCount; i++) {
            String line = reader.readLine();
            for (int j = 0; j < line.length(); j++) {
                int firstVertex;
                int secondVertex;
                if (line.charAt(j) == 'R') {
                    firstVertex = i;
                    secondVertex = i + j + 1;
                } else {
                    firstVertex = i + j + 1;
                    secondVertex = i;
                }

                neighborList.get(firstVertex).add(secondVertex);
            }
        }
    }

    private static void viewLoopInGraph() {
        if (detectLoop()) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }
    }

    private static boolean detectLoop() {
        coloring = new int[vertexCount + 1]; // 0 - white, 1 - grey, 2 - black, first element is dummy
        for (int i = 1; i <= vertexCount; i++) {
            if (coloring[i] == 0) {
                if (looping(i)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean looping(int startVertex) {
        ArrayList<Integer> stack = new ArrayList<>();
        stack.add(startVertex);
        while (!stack.isEmpty()) {
            int vertex = stack.get(stack.size() - 1);
            stack.remove(stack.size() - 1);
            if (coloring[vertex] == 0) {
                coloring[vertex] = 1;
                stack.add(vertex);
                if (neighborList.get(vertex) == null) {
                    continue;
                }
                for (Integer adjacentVertex : neighborList.get(vertex)) {
                    if (coloring[adjacentVertex] == 0) {
                        stack.add(adjacentVertex);
                    }
                    if (coloring[adjacentVertex] == 1) {
                        return true;
                    }
                }
            } else {
                if (coloring[vertex] == 1) {
                    coloring[vertex] = 2;
                }
            }
        }
        return false;
    }
}

