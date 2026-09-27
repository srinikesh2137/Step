import java.util.*;

public class TheCanteenBillingCounter {
    static abstract class Customer {
        protected double amount;
        Customer(double amount) { this.amount = amount; }
        abstract double finalAmount();
    }

    static class Student extends Customer {
        Student(double amount) { super(amount); }
        double finalAmount() { return amount * 0.90; }
    }

    static class Staff extends Customer {
        Staff(double amount) { super(amount); }
        double finalAmount() { return amount * 0.95; }
    }

    static class Guest extends Customer {
        Guest(double amount) { super(amount); }
        double finalAmount() { return amount + 10; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Customer> customers = new ArrayList<>();
        List<String> types = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();

            if (type.equals("STUDENT")) customers.add(new Student(amount));
            else if (type.equals("STAFF")) customers.add(new Staff(amount));
            else customers.add(new Guest(amount));

            types.add(type);
        }

        double total = 0;
        for (int i = 0; i < customers.size(); i++) {
            double finalAmount = customers.get(i).finalAmount();
            total += finalAmount;
            System.out.printf("%s: %.2f%n", types.get(i), finalAmount);
        }
        System.out.printf("Total: %.2f%n", total);
    }
}