import java.util.*;

public class LibraryLateFineCounter {
    static abstract class Item {
        String title;
        int daysLate;
        Item(String title, int daysLate) { this.title = title; this.daysLate = daysLate; }
        abstract double fine();
    }

    static class Book extends Item {
        Book(String title, int daysLate) { super(title, daysLate); }
        double fine() { return daysLate * 2.0; }
    }

    static class DVD extends Item {
        DVD(String title, int daysLate) { super(title, daysLate); }
        double fine() { return Math.min(daysLate * 5.0, 50); }
    }

    static class Magazine extends Item {
        Magazine(String title, int daysLate) { super(title, daysLate); }
        double fine() { return daysLate; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Item> items = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String title = sc.next();
            int days = sc.nextInt();
            if (type.equals("BOOK")) items.add(new Book(title, days));
            else if (type.equals("DVD")) items.add(new DVD(title, days));
            else items.add(new Magazine(title, days));
        }

        double total = 0;
        for (Item item : items) {
            double fine = item.fine();
            total += fine;
            System.out.printf("%s: %.2f%n", item.title, fine);
        }
        System.out.printf("Total Fines: %.2f%n", total);
    }
}
