public class Main {

    public static void main(String[] args) {
        // Get the min element from the
        StackMinElement stackMinElement = new StackMinElement();
        stackMinElement.push(12);
        stackMinElement.push(12);
        stackMinElement.push(12);
        stackMinElement.push(11);
        stackMinElement.push(20);
        stackMinElement.push(10);
        System.out.println(stackMinElement.getMinElement());
        System.out.println(stackMinElement.getSorted());
    }
}
