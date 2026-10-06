import java.util.*;

public class GardenPlotAreaReport {
    static abstract class Plot {
        String owner;
        Plot(String owner) { this.owner = owner; }
        abstract double area();
    }

    static class Circle extends Plot {
        double radius;
        Circle(String owner, double radius) { super(owner); this.radius = radius; }
        double area() { return Math.PI * radius * radius; }
    }

    static class Rectangle extends Plot {
        double length, width;
        Rectangle(String owner, double length, double width) {
            super(owner); this.length = length; this.width = width;
        }
        double area() { return length * width; }
    }

    static class Triangle extends Plot {
        double base, height;
        Triangle(String owner, double base, double height) {
            super(owner); this.base = base; this.height = height;
        }
        double area() { return 0.5 * base * height; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Plot> plots = new ArrayList<>();
        List<String> shapes = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String shape = sc.next();
            String owner = sc.next();
            if (shape.equals("CIRCLE")) plots.add(new Circle(owner, sc.nextDouble()));
            else if (shape.equals("RECTANGLE")) plots.add(new Rectangle(owner, sc.nextDouble(), sc.nextDouble()));
            else plots.add(new Triangle(owner, sc.nextDouble(), sc.nextDouble()));
            shapes.add(shape);
        }

        double total = 0;
        for (int i = 0; i < n; i++) {
            double area = plots.get(i).area();
            total += area;
            System.out.printf("%s (%s): %.2f%n", plots.get(i).owner, shapes.get(i), area);
        }
        System.out.printf("Total Area: %.2f%n", total);
    }
}
