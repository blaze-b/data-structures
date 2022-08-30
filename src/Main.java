public class Main {

    public static void main1(String[] args) {
        // Get the min element from the
        StackMinElement stackMinElement = new StackMinElement();
        stackMinElement.push(4);
        stackMinElement.push(5);
        stackMinElement.push(3);
        stackMinElement.push(2);
        stackMinElement.push(0);
        stackMinElement.push(1);
        stackMinElement.push(7);
        System.out.println(stackMinElement.getMinElement());
        stackMinElement.pop();
        System.out.println(stackMinElement.getMinElement());
        stackMinElement.pop();
        System.out.println(stackMinElement.getMinElement());
        stackMinElement.pop();
        System.out.println(stackMinElement.getMinElement());
    }

    public static void main(String[] args) throws Exception {
        StackMinElement.StackMinElementUsingStack stackMinElementUsingStack =
                new StackMinElement.StackMinElementUsingStack();
        stackMinElementUsingStack.push(10);
        stackMinElementUsingStack.push(11);
        stackMinElementUsingStack.push(13);
        System.out.println(stackMinElementUsingStack.getMin());
        System.out.println(stackMinElementUsingStack.pop());
        System.out.println(stackMinElementUsingStack.peek());
        System.out.println(stackMinElementUsingStack);
    }
}
