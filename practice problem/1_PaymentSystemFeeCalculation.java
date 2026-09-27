import java.util.*;

public class PaymentSystemFeeCalculation {
    static abstract class Payment {
        protected double amount;
        Payment(double amount) { this.amount = amount; }
        abstract double finalAmount();
    }

    static class CardPayment extends Payment {
        CardPayment(double amount) { super(amount); }
        double finalAmount() { return amount * 1.02; }
    }

    static class WalletPayment extends Payment {
        WalletPayment(double amount) { super(amount); }
        double finalAmount() { return amount * 1.01; }
    }

    static class BankTransferPayment extends Payment {
        BankTransferPayment(double amount) { super(amount); }
        double finalAmount() { return amount; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Payment> payments = new ArrayList<>();
        List<String> types = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();

            if (type.equals("CARD"))
                payments.add(new CardPayment(amount));
            else if (type.equals("WALLET"))
                payments.add(new WalletPayment(amount));
            else
                payments.add(new BankTransferPayment(amount));

            types.add(type);
        }

        double total = 0;
        for (int i = 0; i < payments.size(); i++) {
            double adjusted = payments.get(i).finalAmount();
            total += adjusted;
            System.out.printf("%s: %.2f%n", types.get(i), adjusted);
        }
        System.out.printf("Total: %.2f%n", total);
    }
}