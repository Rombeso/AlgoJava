package Final;

public class Participant implements Comparable<Participant>{
    public String name;
    public int tasks;
    public int penalPoints;

    public Participant(String name, int tasks, int penalPoints) {
        this.name = name;
        this.tasks = tasks;
        this.penalPoints = penalPoints;
    }

    public int compareTo(Participant item) {
        if (this.tasks != item.tasks) {
            return Integer.compare(item.tasks, this.tasks); // Сортировка по убыванию количества задач
        }
        if (this.penalPoints != item.penalPoints) {
            return Integer.compare(this.penalPoints, item.penalPoints); // Сортировка по возрастанию штрафных баллов
        } else {
            return this.name.compareTo(item.name); // Сортировка по имени в алфавитном порядке
        }
    }
}
