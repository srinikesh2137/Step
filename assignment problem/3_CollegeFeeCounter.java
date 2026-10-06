import java.util.*;

public class CollegeFeeCounter {
    static abstract class Student {
        protected String name;
        static final double TRANSPORT_FEE = 12000;

        Student(String name) { this.name = name; }
        abstract double tuition();
        abstract boolean usesBus();

        double fee() {
            return tuition() + (usesBus() ? TRANSPORT_FEE : 0);
        }
    }

    static class DayScholar extends Student {
        DayScholar(String name) { super(name); }
        double tuition() { return 40000; }
        boolean usesBus() { return true; }
    }

    static class Hosteller extends Student {
        Hosteller(String name) { super(name); }
        double tuition() { return 40000 + 60000; }
        boolean usesBus() { return false; }
    }

    static class Scholar extends Student {
        Scholar(String name) { super(name); }
        double tuition() { return 20000; }
        boolean usesBus() { return true; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Student> students = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            if (type.equals("DAY_SCHOLAR")) students.add(new DayScholar(name));
            else if (type.equals("HOSTELLER")) students.add(new Hosteller(name));
            else students.add(new Scholar(name));
        }

        double total = 0;
        for (Student student : students) {
            double fee = student.fee();
            total += fee;
            System.out.printf("%s: %.2f%n", student.name, fee);
        }
        System.out.printf("Total Collected: %.2f%n", total);
    }
}