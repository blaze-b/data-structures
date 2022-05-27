package sme;

public class Initliaze {
    public static void main(String[] args) {
        int a = 1;
        System.out.println(a);
        a = Integer.MIN_VALUE;
        System.out.println(a);
        a = Integer.MAX_VALUE;
        System.out.println(a);
        long b = a;
        System.out.println(b);
        a = 13;
        double c = (double) a;
        System.out.println(c);
        double x = 13.4;                          //int y = x; // if we use this, a "loss of precision" error will occur
        int y = (int)x;
        System.out.println(y);
    }
}
