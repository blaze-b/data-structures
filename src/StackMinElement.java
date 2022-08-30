import java.util.Stack;

/**
 * For the pushing 2*insertedElement - minElement
 * For popping it is 2*minElement - poppedElement
 */

public class StackMinElement {

    private Stack<Integer> stack;

    private int minElement;

    public StackMinElement() {
        stack = new Stack<>();
    }

    public Stack<Integer> getStack() {
        return stack;
    }

    public void setStack(Stack<Integer> stack) {
        this.stack = stack;
    }

    public int getMinElement() {
        return minElement;
    }

    public void peek() {
        if (stack.isEmpty()) {
            System.out.println("Stack is empty ");
            return;
        }
        Integer t = stack.peek();
        System.out.print("Top Most Element is: ");
        if (t < minElement)
            System.out.println(minElement);
        else
            System.out.println(t);
    }

    public void pop() {
        if (stack.isEmpty()) {
            System.out.println();
            return;
        }
        System.out.println("Top element on the stack: " + stack);
        Integer t = stack.pop();
        if (t < minElement) {
            minElement = 2 * minElement - t;
            System.out.println(minElement);
        } else
            System.out.println(t);
    }

    public void push(int val) {
        if (stack.isEmpty()) {
            minElement = val;
            stack.push(val);
            System.out.println("Inserted value : " + val);
            return;
        }
        if (val < minElement) {
            stack.push(2 * val - minElement);
            minElement = val;
        } else
            stack.push(val);
    }

    public static class StackMinElementUsingStack {

        private Stack<Integer> elements;

        private Stack<Integer> minElementStack;

        public StackMinElementUsingStack() {
            elements = new Stack<>();
            minElementStack = new Stack<>();
        }

        public void push(int number) {
            elements.push(number);
            if (minElementStack.isEmpty() || number < minElementStack.peek()) {
                minElementStack.push(number);
            } else
                minElementStack.push(minElementStack.pop());
            System.out.println("Min element::" + minElementStack);
        }

        public Integer pop() throws Exception {
            if(minElementStack.isEmpty() && elements.isEmpty())
                throw new Exception("No element...");
            final Integer pop = this.elements.pop();
            final Integer minElement = this.getMin();

            System.out.println("Final elements::" + elements);
            System.out.println("Min element list::" + minElementStack);
            return pop;
        }

        public Integer peek() throws Exception {
            if(minElementStack.isEmpty())
                throw new Exception("No element...");
            return elements.elementAt(minElementStack.peek());
        }

        public Integer getMin() throws Exception {
            if(minElementStack.isEmpty())
                throw new Exception("No element...");
            return minElementStack.peek();
        }
    }
}
