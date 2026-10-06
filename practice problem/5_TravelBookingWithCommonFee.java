import java.util.*;

public class TravelBookingWithCommonFee {
    static abstract class Booking {
        double distance;
        static final double BOOKING_FEE = 50;

        Booking(double distance) { this.distance = distance; }
        abstract double baseFare();

        double total() { return baseFare() + BOOKING_FEE; }
    }

    static class Bus extends Booking {
        Bus(double distance) { super(distance); }
        double baseFare() { return distance * 2; }
    }

    static class Train extends Booking {
        Train(double distance) { super(distance); }
        double baseFare() { return distance * 1.5; }
    }

    static class Flight extends Booking {
        Flight(double distance) { super(distance); }
        double baseFare() { return 2500 + distance * 4; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Booking> bookings = new ArrayList<>();
        List<String> modes = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String mode = sc.next();
            double distance = sc.nextDouble();
            if (mode.equals("BUS")) bookings.add(new Bus(distance));
            else if (mode.equals("TRAIN")) bookings.add(new Train(distance));
            else bookings.add(new Flight(distance));
            modes.add(mode);
        }

        for (int i = 0; i < n; i++)
            System.out.printf("%s: %.2f%n", modes.get(i), bookings.get(i).total());
    }
}
