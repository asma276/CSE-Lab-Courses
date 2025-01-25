import java.util.*;
public class MultiplyingTwoNumByFunction {
    public static int calculateproduct(int a, int b) {
        return a * b; //Operation
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Input
        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println("Product of 2 numbers is: "+ calculateproduct(a, b)); // The product is returned here and the function call exicuted at the same time.
    }
}
