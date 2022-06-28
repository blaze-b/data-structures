public class J2Aggregation {
    public static void main(String[] args) {
        System.out.println("Aggregation testing....");
        Circle circle = new Circle();
        System.out.println(circle.area(11));
        Rectangle rectangle = new Rectangle();
        System.out.println(rectangle.area(5, 10));
    }
}

class Operation {
    int square(int n) {
        return n * n;
    }

    int product(int l, int b) {
        return l * b;
    }
}

class Circle {
    //Aggregation of entities
    Operation op;
    double pi = 3.14;

    double area(int radius) {
        op = new Operation();
        int rsquare = op.square(radius);
        return pi * rsquare;
    }
}


class Rectangle {

    Operation op;

    double area(int l, int b) {
        op = new Operation();
        return op.product(l, b);
    }
}
