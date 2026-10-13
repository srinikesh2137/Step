import java.util.Scanner;

class Student {
    String name;
    int[] marks;

    Student(String name, int[] marks) {
        this.name = name;
        this.marks = marks;
    }

    double average() {
        return (marks[0] + marks[1] + marks[2]) / 3.0;
    }

    char grade() {
        double avg = average();
        if (avg >= 75) return 'B';
        if (avg >= 60) return 'C';
        if (avg >= 40) return 'D';
        return 'F';
    }
}

public class StudentResultCardGenerator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int[] marks = {sc.nextInt(), sc.nextInt(), sc.nextInt()};
            Student student = new Student(name, marks);
            System.out.printf("%s: Average %.1f, Grade %c%n",
                    student.name.toUpperCase(), student.average(), student.grade());
        }
    }
}