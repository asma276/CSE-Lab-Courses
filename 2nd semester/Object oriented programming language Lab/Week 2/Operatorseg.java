public class Operatorseg {
    public static void main(String[] args) {
        int a,b,c;
        String str1,str2;
        //  assignment operators
        a=10; b=20; c=0;
        str1="Hello" ; str2="World";
        //concatenation operation, Arithmetic operations, compound assignment
        System.out.println(str1+" "+str2);
        c=a+b; 
        System.out.println(c);
        a*=b;
        System.out.println(a);
        //relational opeators
        boolean x = a>b;
        System.out.println(x);
        //logical opeators
        if (a>b && b<c)
        System.out.println("hello");
        //conditional operators
        System.out.println(a>b?"ture":"false");

    }
}
