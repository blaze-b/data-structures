package learning;

public class MethodOverloading {

    public int test(String s) {
        System.out.println(s);
        return 0;
    }
    public int test(Object s) {
        System.out.println(s);
        return 1;
    }
    public static void main(String[] args) {
        MethodOverloading methodOverloading = new MethodOverloading();
        int test = methodOverloading.test(null);
        System.out.println(test);
    }
}
