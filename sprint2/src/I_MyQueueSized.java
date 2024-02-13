import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class I_MyQueueSized {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(reader.readLine());
        int maxLength = Integer.parseInt(reader.readLine());
        Queue queue = new Queue(maxLength);
        for (int i = 0; i < n; i++) {
            String command = reader.readLine();
            StringTokenizer commandTokenizer = new StringTokenizer(command);
            switch (commandTokenizer.nextToken()) {
                case "push":
                    int x = Integer.parseInt(commandTokenizer.nextToken());
                    try {
                        queue.push(x);
                    } catch (IllegalStateException e) {
                        writer.write(e.getMessage());
                        writer.newLine();
                        writer.flush();
                    }
                    break;
                case "pop":
                    try {
                        writer.write(String.valueOf(queue.pop()));
                        writer.newLine();
                        writer.flush();
                    } catch (IllegalStateException e) {
                        writer.write(e.getMessage());
                        writer.newLine();
                        writer.flush();
                    }
                    break;
                case "size":
                    writer.write(String.valueOf(queue.size()));
                    writer.newLine();
                    writer.flush();
                    break;
                case "peek":
                    try {
                        writer.write(String.valueOf(queue.peek()));
                        writer.newLine();
                        writer.flush();
                    } catch (IllegalStateException e) {
                        writer.write(e.getMessage());
                        writer.newLine();
                        writer.flush();
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
