import java.util.Scanner;

public class PrimeNumberChecker {
    static void checkPrime(int number) {
        boolean isPrime = true;

        if (number < 2) {
            isPrime = false;
        } else {
            for (int i = 2; i < number; i++) {
                if (number % i == 0) {
                    isPrime = false;
                    break;
                }
            }
        }

        System.out.println("Is the number " + number + " a Prime number? " + isPrime);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        int number = sc.nextInt();
        checkPrime(number);
        sc.close();
    }
}
