import java.util.*;

public class DeliveryFeeCalculator {
    static abstract class Delivery {
        protected double weight, distance;
        Delivery(double weight, double distance) {
            this.weight = weight;
            this.distance = distance;
        }
        abstract double fee();
    }

    static class StandardDelivery extends Delivery {
        StandardDelivery(double w, double d) { super(w, d); }
        double fee() { return 5 + 0.50 * weight + 0.10 * distance; }
    }

    static class ExpressDelivery extends Delivery {
        ExpressDelivery(double w, double d) { super(w, d); }
        double fee() { return 15 + 1.00 * weight + 0.20 * distance; }
    }

    static class InternationalDelivery extends Delivery {
        private double customsFee;
        InternationalDelivery(double w, double d, double c) {
            super(w, d);
            customsFee = c;
        }
        double fee() { return 25 + 2.00 * weight + 0.50 * distance + customsFee; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Delivery> deliveries = new ArrayList<>();
        List<String> types = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double weight = sc.nextDouble();
            double distance = sc.nextDouble();

            if (type.equals("STANDARD"))
                deliveries.add(new StandardDelivery(weight, distance));
            else if (type.equals("EXPRESS"))
                deliveries.add(new ExpressDelivery(weight, distance));
            else
                deliveries.add(new InternationalDelivery(weight, distance, sc.nextDouble()));

            types.add(type);
        }

        double total = 0;
        for (int i = 0; i < deliveries.size(); i++) {
            double fee = deliveries.get(i).fee();
            total += fee;
            System.out.printf("%s: %.2f%n", types.get(i), fee);
        }
        System.out.printf("Total: %.2f%n", total);
    }
}