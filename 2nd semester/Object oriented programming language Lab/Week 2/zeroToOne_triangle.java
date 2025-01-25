public class zeroToOne_triangle {
    public static void main(String[] args) {
        int n =5;

        //outer loop
        for (int i=1; i<=n; i++){
            //inner loop
            for (int j=1; j<=i; j++){
                int sum = i+j;
                if(sum % 2 == 0){ //Even
                    System.out.print("1 ");
                } else { //Odd
                    System.out.print("0 ");
                }
               
            }
              System.out.println();
        }
    }
}
