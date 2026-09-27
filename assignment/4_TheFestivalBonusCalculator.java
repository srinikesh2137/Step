import java.util.*;

public class TheFestivalBonusCalculator {
    static abstract class Employee {
        protected String name;
        protected double salary;

        Employee(String name, double salary) {
            this.name = name;
            this.salary = salary;
        }

        abstract double bonus();
    }

    static class FullTime extends Employee {
        FullTime(String name, double salary) { super(name, salary); }
        double bonus() { return salary * 0.10; }
    }

    static class PartTime extends Employee {
        PartTime(String name, double salary) { super(name, salary); }
        double bonus() { return salary * 0.05; }
    }

    static class Intern extends Employee {
        Intern(String name, double salary) { super(name, salary); }
        double bonus() { return 2000; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Employee> employees = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            double salary = sc.nextDouble();

            if (type.equals("FULLTIME"))
                employees.add(new FullTime(name, salary));
            else if (type.equals("PARTTIME"))
                employees.add(new PartTime(name, salary));
            else
                employees.add(new Intern(name, salary));
        }

        double total = 0;
        for (Employee employee : employees) {
            double bonus = employee.bonus();
            total += bonus;
            System.out.printf("%s: %.2f%n", employee.name, bonus);
        }
        System.out.printf("Total Bonus: %.2f%n", total);
    }
}