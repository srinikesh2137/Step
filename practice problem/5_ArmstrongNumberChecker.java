import java.util.Scanner;

public class ArmstrongNumberChecker {
    static void checkArmstrong(int number) {
        int origNumber = number;
        int temp = number;
        int digits = 0;

        if (temp == 0) {
            digits = 1;
        } else {
            while (temp != 0) {
                digits++;
                temp = temp / 10;
            }
        }

        int sum = 0;
        temp = number;

        while (temp != 0) {
            int digit = temp % 10;
            int power = 1;

            for (int i = 0; i < digits; i++) {
                power *= digit;
            }

            sum += power;
            temp = temp / 10;
        }

        System.out.println("Is the number " + origNumber + " an Armstrong number? " +
                           (sum == origNumber));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        int number = sc.nextInt();
        checkArmstrong(number);
        sc.close();
    }
}
