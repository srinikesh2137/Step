import java.util.*;

public class ParcelShippingDesk {
    static abstract class Parcel {
        protected double weight, value;

        Parcel(double weight, double value) {
            this.weight = weight;
            this.value = value;
        }

        abstract double charge();
        abstract double insurance();

        double total() {
            return charge() + insurance();
        }
    }

    static class Standard extends Parcel {
        Standard(double weight, double value) { super(weight, value); }
        double charge() { return 40 + 10 * weight; }
        double insurance() { return 0; }
    }

    static class Express extends Parcel {
        Express(double weight, double value) { super(weight, value); }
        double charge() { return 80 + 15 * weight; }
        double insurance() { return 0.02 * value; }
    }

    static class Fragile extends Parcel {
        Fragile(double weight, double value) { super(weight, value); }
        double charge() { return 40 + 10 * weight + 50; }
        double insurance() { return 0.02 * value; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Parcel> parcels = new ArrayList<>();
        List<String> types = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double weight = sc.nextDouble();
            double value = sc.nextDouble();

            if (type.equals("STANDARD")) parcels.add(new Standard(weight, value));
            else if (type.equals("EXPRESS")) parcels.add(new Express(weight, value));
            else parcels.add(new Fragile(weight, value));
            types.add(type);
        }

        double grandTotal = 0;
        for (int i = 0; i < parcels.size(); i++) {
            Parcel p = parcels.get(i);
            double charge = p.charge();
            double insurance = p.insurance();
            double total = p.total();
            grandTotal += total;
            System.out.printf("%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                    types.get(i), charge, insurance, total);
        }
        System.out.printf("Grand Total: %.2f%n", grandTotal);
    }
}