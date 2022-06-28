import java.util.UUID;

public class J1Inheritance {

    public static void main(String[] args) {
        System.out.println("Inheritance testing....");
        Programmer programmer = new Programmer();
        //Access the changes from the parent and the sub class
        System.out.println(programmer.id);
        System.out.println(programmer.salary);
        System.out.println(programmer.bonus);
    }
}

/**
 * Parent class
 */
class Employee {
    protected int salary = 10000;
}

/**
 * Sub class
 */
class Programmer extends Employee {
    protected String id = UUID.randomUUID().toString();
    protected int bonus = 1000;
}
