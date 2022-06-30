public class J5Reference {
    public static void main(String[] args) {
        System.out.println("Reference variable");
        String value = null;
        value = "Hello World";
        System.out.println(value);

        EmployeeRef employeeRef = new EmployeeRef();
        //Print the reference value
        System.out.println(employeeRef);
    }
}


class EmployeeRef {

    private int id;
    private int salary;

    int getSalary() {
        return salary;
    }

    int getId() {
        return id;
    }

    void setSalary(int salary) {
        this.salary = salary;
    }

    void setId(int id) {
        this.id = id;
    }

//    @Override
//    public String toString() {
//        return "EmployeeRef{" +
//                "id=" + id +
//                ", salary=" + salary +
//                '}';
//    }
}
