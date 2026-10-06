import java.util.*;

public class CityCabFareMeter {
    interface NightService {
        double nightFare(double fare);
    }

    static abstract class Cab {
        protected double km;
        static final double MIN_FARE = 100;

        Cab(double km) { this.km = km; }
        abstract double rate();

        double baseFare() {
            return Math.max(MIN_FARE, km * rate());
        }
    }

    static class Mini extends Cab {
        Mini(double km) { super(km); }
        double rate() { return 10; }
    }

    static class Sedan extends Cab implements NightService {
        Sedan(double km) { super(km); }
        double rate() { return 14; }
        public double nightFare(double fare) { return fare * 1.20; }
    }

    static class SUV extends Cab implements NightService {
        SUV(double km) { super(km); }
        double rate() { return 18; }
        public double nightFare(double fare) { return fare * 1.20; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Cab> cabs = new ArrayList<>();
        List<String> names = new ArrayList<>();
        List<String> times = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String cab = sc.next();
            double km = sc.nextDouble();
            String time = sc.next();

            if (cab.equals("MINI")) cabs.add(new Mini(km));
            else if (cab.equals("SEDAN")) cabs.add(new Sedan(km));
            else cabs.add(new SUV(km));
            names.add(cab);
            times.add(time);
        }

        double total = 0;
        for (int i = 0; i < cabs.size(); i++) {
            Cab cab = cabs.get(i);
            String name = names.get(i);
            String time = times.get(i);

            if (time.equals("NIGHT") && !(cab instanceof NightService)) {
                System.out.println(name + ": night service not available");
                continue;
            }

            double fare = cab.baseFare();
            if (time.equals("NIGHT"))
                fare = ((NightService) cab).nightFare(fare);

            total += fare;
            System.out.printf("%s: %.2f%n", name, fare);
        }
        System.out.printf("Total: %.2f%n", total);
    }
}