import java.util.Scanner;

public class ATMPinRetrySystem {
    static void atmPinRetry(String correctPin, String[] attempts) {
        int attempt = 0;
        boolean success = false;

        while (attempt < attempts.length && attempt < 3 && !success) {
            if (attempts[attempt].equals(correctPin)) {
                success = true;
                System.out.println("PIN accepted");
                break;
            }
            attempt++;
        }

        if (!success) {
            System.out.println("Card blocked — too many incorrect attempts");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter correct PIN: ");
        String correctPin = sc.nextLine();

        String[] attempts = new String[3];
        System.out.println("Enter up to 3 PIN attempts:");
        for (int i = 0; i < 3; i++) {
            attempts[i] = sc.nextLine();
        }

        atmPinRetry(correctPin, attempts);
        sc.close();
    }
}
