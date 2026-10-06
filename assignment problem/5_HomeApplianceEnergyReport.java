import java.util.*;

public class HomeApplianceEnergyReport {
    interface SaverMode {
        double savedUnits(double units);
    }

    static abstract class Appliance {
        protected double hours;

        Appliance(double hours) { this.hours = hours; }
        abstract double power();

        double units() {
            return power() * hours / 1000.0;
        }
    }

    static class Fridge extends Appliance {
        Fridge(double hours) { super(hours); }
        double power() { return 150; }
    }

    static class AC extends Appliance implements SaverMode {
        AC(double hours) { super(hours); }
        double power() { return 1500; }
        public double savedUnits(double units) { return units * 0.75; }
    }

    static class TV extends Appliance {
        TV(double hours) { super(hours); }
        double power() { return 100; }
    }

    static class Washer extends Appliance implements SaverMode {
        Washer(double hours) { super(hours); }
        double power() { return 500; }
        public double savedUnits(double units) { return units * 0.75; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Appliance> appliances = new ArrayList<>();
        List<String> names = new ArrayList<>();
        List<Boolean> saver = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String name = sc.next();
            double hours = sc.nextDouble();
            boolean useSaver = sc.hasNext("SAVER");
            if (useSaver) sc.next();

            if (name.equals("FRIDGE")) appliances.add(new Fridge(hours));
            else if (name.equals("AC")) appliances.add(new AC(hours));
            else if (name.equals("TV")) appliances.add(new TV(hours));
            else appliances.add(new Washer(hours));

            names.add(name);
            saver.add(useSaver);
        }

        double totalCost = 0;
        for (int i = 0; i < appliances.size(); i++) {
            Appliance appliance = appliances.get(i);
            String name = names.get(i);

            if (saver.get(i) && !(appliance instanceof SaverMode)) {
                System.out.println(name + ": saver mode not supported");
                continue;
            }

            double units = appliance.units();
            if (saver.get(i))
                units = ((SaverMode) appliance).savedUnits(units);

            double cost = units * 8;
            totalCost += cost;
            System.out.printf("%s: Units=%.2f Cost=%.2f%n", name, units, cost);
        }
        System.out.printf("Total Cost: %.2f%n", totalCost);
    }
}