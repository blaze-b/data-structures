public class J3Abstraction {
    public static void main(String[] args) {
        System.out.println("Abstraction example.......");
        OperationAbs operationOne = new CircleAbs(10);
        System.out.println("circle-area::" + operationOne.area());
        operationOne = new RectangleAbs(11.1, 12.1);
        System.out.println("rectangle-ares::" + operationOne.area());
    }
}

abstract class OperationAbs {
    //Abstract method
    abstract double area();

    //Maximum reusable
    //Non-Abstract method
    int square(int n) {
        return n * n;
    }

    //Non-Abstract method
    double product(double l, double b) {
        return l * b;
    }
}

class CircleAbs extends OperationAbs {

    double pi = 3.14;
    int radius;

    CircleAbs(int radius) {
        this.radius = radius;
    }

    @Override
    double area() {
        return pi * square(radius);
    }


}


class RectangleAbs extends OperationAbs {

    double length;
    double breadth;

    RectangleAbs(double length, double breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    @Override
    double area() {
        return product(length, breadth);
    }
}
