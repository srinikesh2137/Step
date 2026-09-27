import java.util.*;

public class TheHostelElectricityBill {
    static abstract class Room {
        protected int units;
        Room(int units) { this.units = units; }
        abstract double bill();
    }

    static class SingleRoom extends Room {
        SingleRoom(int units) { super(units); }
        double bill() { return units * 8.0; }
    }

    static class SharedRoom extends Room {
        private int occupants;
        SharedRoom(int units, int occupants) {
            super(units);
            this.occupants = occupants;
        }
        double bill() { return (units * 6.0) / occupants; }
    }

    static class ACRoom extends Room {
        ACRoom(int units) { super(units); }
        double bill() { return units * 10.0 + 200; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Room> rooms = new ArrayList<>();
        List<String> types = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int units = sc.nextInt();

            if (type.equals("SINGLE")) rooms.add(new SingleRoom(units));
            else if (type.equals("SHARED"))
                rooms.add(new SharedRoom(units, sc.nextInt()));
            else rooms.add(new ACRoom(units));

            types.add(type);
        }

        double total = 0;
        for (int i = 0; i < rooms.size(); i++) {
            double bill = rooms.get(i).bill();
            total += bill;
            System.out.printf("%s: %.2f%n", types.get(i), bill);
        }
        System.out.printf("Total: %.2f%n", total);
    }
}