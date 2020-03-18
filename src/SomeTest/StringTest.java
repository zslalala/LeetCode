package SomeTest;

public class StringTest {

    public static void main(String[] args) {
        String A = new String("aa");
        String B = A.intern();
        String C = "aa";
        System.out.println(A);
        System.out.println(B);
        System.out.println(C);
        System.out.println(C == B);   //TRUE
        System.out.println(C == A);   //FALSE
    }
}
