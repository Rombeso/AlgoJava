/*
-- ПРИНЦИП РАБОТЫ --
Данный алгоритм реализует структуру данных двусторонняя очередь (deque) с использованием массива. Очередь представляет собой кольцевой буфер с указателями на начало (head) и конец (tail) очереди. Операции добавления элементов выполняются с учетом кольцевой структуры, что позволяет эффективно добавлять элементы как в начало, так и в конец очереди. Операции удаления элементов также учитывают кольцевую структуру и обновляют указатели.

-- ДОКАЗАТЕЛЬСТВО КОРРЕКТНОСТИ --
Корректность работы данного алгоритма обеспечивается правильной реализацией операций добавления и удаления элементов в очередь. При добавлении элемента происходит проверка на заполненность очереди, и если место еще есть, элемент добавляется в соответствующую позицию. При удалении элемента также проверяется, что очередь не пуста, и элемент удаляется из соответствующей позиции с обновлением указателей.

-- ВРЕМЕННАЯ СЛОЖНОСТЬ --
Временная сложность операций добавления и удаления элементов из очереди в данном алгоритме составляет O(1). Добавление элемента происходит за постоянное время, так как используется кольцевая структура, и нет необходимости перемещать другие элементы. Удаление элемента также происходит за постоянное время, так как обновление указателей осуществляется непосредственно.

-- ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ --
Пространственная сложность данного алгоритма определяется размером массива, который используется для хранения элементов очереди. В данном случае пространственная сложность равна O(n), где n - максимальная длина очереди. Каждый элемент занимает постоянное количество памяти, поэтому общее количество памяти, необходимое для хранения всех элементов очереди, пропорционально их количеству.

*/

package Final;

import java.io.*;
import java.util.OptionalInt;
import java.util.StringTokenizer;

public class A_MyDeque {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(reader.readLine());
        int maxLength = Integer.parseInt(reader.readLine());
        QueueDeque queue = new QueueDeque(maxLength);
        for (int i = 0; i < n; i++) {
            String command = reader.readLine();
            StringTokenizer commandTokenizer = new StringTokenizer(command);
            switch (commandTokenizer.nextToken()) {
                case "push_back":
                    int x = Integer.parseInt(commandTokenizer.nextToken());
                    try {
                        queue.pushBack(x);
                        queue.printQueue();
                    } catch (IllegalStateException e) {
                        writer.write(e.getMessage());
                        writer.newLine();
                        writer.flush();
                    }
                    break;
                case "push_front":
                    int c = Integer.parseInt(commandTokenizer.nextToken());
                    try {
                        queue.pushFront(c);
                        queue.printQueue();
                    } catch (IllegalStateException e) {
                        writer.write(e.getMessage());
                        writer.newLine();
                        writer.flush();
                    }
                    break;
                case "pop_front":
                    OptionalInt popFront = queue.popFront();
                    if (popFront.isPresent()) {
                        writer.write(String.valueOf(popFront.getAsInt()));
                        writer.newLine();
                        writer.flush();
                        queue.printQueue();
                    } else {
                        System.out.println("error");
                    }
                    break;
                case "pop_back":
                    OptionalInt popBack = queue.popBack();
                    if (popBack.isPresent()) {
                        writer.write(String.valueOf(popBack.getAsInt()));
                        writer.newLine();
                        writer.flush();
                        queue.printQueue();
                    } else {
                        System.out.println("error");
                    }
                    break;
                case "size":
                    writer.write(String.valueOf(queue.size()));
                    writer.newLine();
                    writer.flush();
                    break;
                case "peek":
                    OptionalInt peek = queue.peek();
                    if (peek.isPresent()) {
                        writer.write(String.valueOf(peek.getAsInt()));
                        writer.newLine();
                        writer.flush();
                        queue.printQueue();
                    } else {
                        System.out.println("error");
                    }
                    break;
                default:
                    writer.write("Unknown command");
                    writer.newLine();
                    writer.flush();
            }
        }
    }
}
