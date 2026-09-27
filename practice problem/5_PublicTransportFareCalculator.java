import java.util.*;

public class PublicTransportFareCalculator {
    static abstract class Transport {
        protected double distance;
        Transport(double distance) { this.distance = distance; }
        abstract double fare();
    }

    static class Bus extends Transport {
        Bus(double d) { super(d); }
        double fare() { return Math.min(2 + 0.10 * distance, 10); }
    }

    static class Train extends Transport {
        Train(double d) { super(d); }
        double fare() { return 3 + 0.15 * distance; }
    }

    static class Metro extends Transport {
        private double peakHourFactor;
        Metro(double d, double factor) {
            super(d);
            peakHourFactor = factor;
        }
        double fare() { return (1.50 + 0.20 * distance) * peakHourFactor; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Transport> journeys = new ArrayList<>();
        List<String> types = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double distance = sc.nextDouble();

            if (type.equals("BUS"))
                journeys.add(new Bus(distance));
            else if (type.equals("TRAIN"))
                journeys.add(new Train(distance));
            else
                journeys.add(new Metro(distance, sc.nextDouble()));

            types.add(type);
        }

        double total = 0;
        for (int i = 0; i < journeys.size(); i++) {
            double fare = journeys.get(i).fare();
            total += fare;
            System.out.printf("%s: %.2f%n", types.get(i), fare);
        }
        System.out.printf("Total: %.2f%n", total);
    }
}