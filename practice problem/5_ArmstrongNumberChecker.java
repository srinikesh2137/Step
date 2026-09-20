import java.util.Scanner;

public class ArmstrongNumberChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        int originalNumber = number;
        int temp = Math.abs(number);
        int digits = String.valueOf(temp).length();
        int sum = 0;

        while (temp != 0) {
            int digit = temp % 10;
            sum += (int) Math.pow(digit, digits);
            temp /= 10;
        }

        if (originalNumber >= 0 && sum == originalNumber)
            System.out.println(originalNumber + " is an Armstrong number.");
        else
            System.out.println(originalNumber + " is not an Armstrong number.");
    }
}