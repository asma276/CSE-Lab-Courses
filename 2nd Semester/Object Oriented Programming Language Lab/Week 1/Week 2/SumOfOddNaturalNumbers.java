import java.util.Scanner;

public class SumOfOddNaturalNumbers {
    public static void main(String[] args) {
        Scanner Scanner = new Scanner(System.in);

        System.out.print("Input number of terms is: ");
        int terms = Scanner.nextInt();

        int sum = 0;
        int oddNumber = 1;

        System.out.println("The odd numbers are:");

        for (int i = 1; i <= terms; i++) {
            sum += oddNumber;
            System.out.println(oddNumber);
            oddNumber += 2;
        }

        System.out.println("The Sum of odd Natural Number upto " + terms + " terms is: " + sum);
    }
}