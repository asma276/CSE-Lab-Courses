public class SwapVariables {
    public static void main(String[] args) {
        int x = 10;
        int y = 20;

        System.out.println("Before swapping:");
        System.out.println("x = " + x);
        System.out.println("y = " + y);

       
        int temp = x;
        x = y;
        y = temp;

        System.out.println("After swapping:");
        System.out.println("x = " + x);
        System.out.println("y = " + y);
    }
}