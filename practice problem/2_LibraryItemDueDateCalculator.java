import java.time.LocalDate;
import java.util.*;

public class LibraryItemDueDateCalculator {
    static abstract class LibraryItem {
        protected String title;
        LibraryItem(String title) { this.title = title; }
        abstract int borrowingDays();
        LocalDate dueDate(LocalDate currentDate) {
            return currentDate.plusDays(borrowingDays());
        }
    }

    static class Book extends LibraryItem {
        Book(String title) { super(title); }
        int borrowingDays() { return 14; }
    }

    static class DVD extends LibraryItem {
        DVD(String title) { super(title); }
        int borrowingDays() { return 7; }
    }

    static class Magazine extends LibraryItem {
        Magazine(String title) { super(title); }
        int borrowingDays() { return 3; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LocalDate currentDate = LocalDate.of(2023, 10, 26);
        int n = Integer.parseInt(sc.nextLine().trim());
        List<LibraryItem> items = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            int space = line.indexOf(' ');
            String type = line.substring(0, space);
            String title = line.substring(space + 1).trim();

            if (title.startsWith("\"") && title.endsWith("\""))
                title = title.substring(1, title.length() - 1);

            if (type.equals("BOOK"))
                items.add(new Book(title));
            else if (type.equals("DVD"))
                items.add(new DVD(title));
            else
                items.add(new Magazine(title));
        }

        for (LibraryItem item : items)
            System.out.println(item.title + ": " + item.dueDate(currentDate));
    }
}