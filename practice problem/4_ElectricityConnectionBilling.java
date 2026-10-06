import java.util.*;

public class ElectricityConnectionBilling {
    static abstract class Connection {
        double units;
        Connection(double units) { this.units = units; }
        abstract double bill();
    }

    static class Home extends Connection {
        Home(double units) { super(units); }
        double bill() { return units <= 100 ? units * 5 : 500 + (units - 100) * 7; }
    }

    static class Shop extends Connection {
        Shop(double units) { super(units); }
        double bill() { return units * 8 + 100; }
    }

    static class Factory extends Connection {
        Factory(double units) { super(units); }
        double bill() { return Math.max(units * 6, 1000); }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Connection> connections = new ArrayList<>();
        List<String> types = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double units = sc.nextDouble();
            if (type.equals("HOME")) connections.add(new Home(units));
            else if (type.equals("SHOP")) connections.add(new Shop(units));
            else connections.add(new Factory(units));
            types.add(type);
        }

        double total = 0;
        for (int i = 0; i < n; i++) {
            double bill = connections.get(i).bill();
            total += bill;
            System.out.printf("%s: %.2f%n", types.get(i), bill);
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
