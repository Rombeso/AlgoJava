package Final;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class A {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int number = readInt(reader);
            List<Player> players = readPlayers(reader, number);

            List<Player> sortedPlayers = sortedPlayers(players);

            StringBuilder sb = new StringBuilder();
            for (Player player : sortedPlayers) {
                sb.append(player.getName()).append("\n");
            }
            System.out.println(sb);
        }
    }

    private static List<Player> sortedPlayers(List<Player> players) {
        MyHeap heap = new MyHeap(players);

        List<Player> sortedArray = new ArrayList<>();
        while (!heap.isEmpty()) {
            sortedArray.add(heap.popMax());
        }
        return sortedArray;
    }

    private static int readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }

    private static List<Player> readPlayers(BufferedReader reader, int number) throws IOException {
        List<Player> players = new ArrayList<>(number);

        for (int i = 1; i <= number; i++) {
            String[] s = reader.readLine().split(" ");
            Player player = new Player(s[0], Integer.parseInt(s[1]), Integer.parseInt(s[2]));
            players.add(player);
        }

        return players;
    }
}
class MyHeap {
    List<Player> heap;

    public MyHeap(List<Player> heap) {
        this.heap = heap;
        for (int i = heap.size() / 2; i >= 0; i--) {
            siftDown(i);
        }
    }

        public void heapAdd(Player player) {
            heap.add(player);
            siftUp(heap.size());
        }

    public Player popMax() {
        Player result = heap.get(0);
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        siftDown(0);
        return result;
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

        private void siftUp(int index) {
            int parentIndex = index / 2;
            while (parentIndex > 0) {
                if (compare(heap.get(parentIndex - 1), heap.get(index - 1)) < 1) {
                    Player temp = heap.get(parentIndex - 1);
                    heap.set(parentIndex - 1, heap.get(index - 1));
                    heap.set(index - 1, temp);
                } else return;
                index = parentIndex;
                parentIndex /= 2;
            }
        }

    private void siftDown(int index) {
        int n = heap.size();
        while (index < n / 2) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            int indexLargest = left;

            if (right < n && compare(heap.get(left), heap.get(right)) < 0) {
                indexLargest = right;
            }

            if (compare(heap.get(index), heap.get(indexLargest)) >= 0) {
                break;
            }

            Player temp = heap.get(index);
            heap.set(index, heap.get(indexLargest));
            heap.set(indexLargest, temp);
            index = indexLargest;
        }
    }

    private int compare(Player p1,  Player p2) {
        if (p1.getTasksSolved() != p2.getTasksSolved()) {
            return p1.getTasksSolved() - p2.getTasksSolved();
        }
        if (p1.getPenalty() != p2.getPenalty()) {
            return p2.getPenalty() - p1.getPenalty();
        }
        return p2.getName().compareTo(p1.getName());
    }
}
class Player {
    private final String name;
    private final int tasksSolved;
    private final int penalty;

    public Player(String name, int tasksSolved, int penalty) {
        this.name = name;
        this.tasksSolved = tasksSolved;
        this.penalty = penalty;
    }

    public String getName() {
        return name;
    }

    public int getTasksSolved() {
        return tasksSolved;
    }

    public int getPenalty() {
        return penalty;
    }
}





