import java.util.*;

public class MovieTicketCounter {
    static abstract class Ticket {
        protected int count;
        static final double CONVENIENCE_FEE = 20;

        Ticket(int count) { this.count = count; }
        abstract double price();

        double amount() {
            return count * (price() + CONVENIENCE_FEE);
        }
    }

    static class Regular extends Ticket {
        Regular(int count) { super(count); }
        double price() { return 150; }
    }

    static class Premium extends Ticket {
        Premium(int count) { super(count); }
        double price() { return 250; }
    }

    static class Recliner extends Ticket {
        Recliner(int count) { super(count); }
        double price() { return 400; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Ticket> tickets = new ArrayList<>();
        List<String> seats = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String seat = sc.next();
            int count = sc.nextInt();
            if (seat.equals("REGULAR")) tickets.add(new Regular(count));
            else if (seat.equals("PREMIUM")) tickets.add(new Premium(count));
            else tickets.add(new Recliner(count));
            seats.add(seat);
        }

        double total = 0;
        for (int i = 0; i < tickets.size(); i++) {
            double amount = tickets.get(i).amount();
            total += amount;
            System.out.printf("%s: %.2f%n", seats.get(i), amount);
        }
        System.out.printf("Total: %.2f%n", total);
    }
}