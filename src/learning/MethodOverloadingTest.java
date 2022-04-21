package learning;

public class MethodOverloadingTest {

    public int test(String s) {
        System.out.println(s);
        return 0;
    }
    public int test(Object s) {
        System.out.println(s);
        return 1;
    }
    public static void main(String[] args) {
        MethodOverloadingTest methodOverloadingTest = new MethodOverloadingTest();
        int test = methodOverloadingTest.test(null);
        System.out.println(test);
    }
}
