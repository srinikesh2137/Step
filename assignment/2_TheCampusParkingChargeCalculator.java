import java.util.*;

public class TheCampusParkingChargeCalculator {
    static abstract class Vehicle {
        protected int hours;
        Vehicle(int hours) { this.hours = hours; }
        abstract double charge();
    }

    static class Bike extends Vehicle {
        Bike(int hours) { super(hours); }
        double charge() { return hours * 10.0; }
    }

    static class Car extends Vehicle {
        Car(int hours) { super(hours); }
        double charge() { return 30 + (hours - 1) * 20.0; }
    }

    static class Truck extends Vehicle {
        Truck(int hours) { super(hours); }
        double charge() { return Math.max(100, hours * 50.0); }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Vehicle> vehicles = new ArrayList<>();
        List<String> types = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int hours = sc.nextInt();

            if (type.equals("BIKE")) vehicles.add(new Bike(hours));
            else if (type.equals("CAR")) vehicles.add(new Car(hours));
            else vehicles.add(new Truck(hours));

            types.add(type);
        }

        double total = 0;
        for (int i = 0; i < vehicles.size(); i++) {
            double charge = vehicles.get(i).charge();
            total += charge;
            System.out.printf("%s: %.2f%n", types.get(i), charge);
        }
        System.out.printf("Total: %.2f%n", total);
    }
}