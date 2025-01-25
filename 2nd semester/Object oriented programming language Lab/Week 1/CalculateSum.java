import java.util.*;
public class CalculateSum {
public static int CalculateSum(int a, int b) { //function decleared
       int sum = a + b; //Operations
       return sum;
}
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in); // Input
    int a = sc.nextInt();
    int b = sc.nextInt();

    int sum = CalculateSum(a, b); //function call
    System.out.println("Sum of 2 numbers is: "+ sum); // The sum is returned here
  }
}