import java.util.*;

public class WeeklyStaffPay {
    static abstract class Staff {
        String name;
        Staff(String name) { this.name = name; }
        abstract double pay();
    }

    static class FullTime extends Staff {
        double salary;
        FullTime(String name, double salary) { super(name); this.salary = salary; }
        double pay() { return salary; }
    }

    static class Hourly extends Staff {
        double hours, rate;
        Hourly(String name, double hours, double rate) {
            super(name); this.hours = hours; this.rate = rate;
        }
        double pay() { return hours <= 40 ? hours * rate : 40 * rate + (hours - 40) * rate * 1.5; }
    }

    static class Intern extends Staff {
        double stipend;
        Intern(String name, double stipend) { super(name); this.stipend = stipend; }
        double pay() { return stipend; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Staff> staff = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            if (type.equals("FULLTIME")) staff.add(new FullTime(name, sc.nextDouble()));
            else if (type.equals("HOURLY")) staff.add(new Hourly(name, sc.nextDouble(), sc.nextDouble()));
            else staff.add(new Intern(name, sc.nextDouble()));
        }

        double total = 0;
        for (Staff s : staff) {
            double pay = s.pay();
            total += pay;
            System.out.printf("%s: %.2f%n", s.name, pay);
        }
        System.out.printf("Total Payroll: %.2f%n", total);
    }
}
