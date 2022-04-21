package stack;

import java.util.Arrays;

/**
 * Stack is an ordered list in which insertion and deletion are done at one end, called a top.
 * The last element inserted is the first one to be deleted, HENCE,
 * it is called the Last in First Out (LIFO) or the First is Last Out (FILO) list
 * <p>
 * Stack Operations: It makes a stack an Abstract Data Type
 * <p>
 * Stack Concepts:
 * When an element is inserted in a stack, the concept is called a push
 * When an element is removed in a stack, the concept is called a pop
 * Trying to pop out an empty stack is called underflow(treat as Exception)
 * Trying to push an element in a full stack is called overflow(treat as Exception)
 */
public class StackArrayImpl {
    public static final int CAPACITY = 16;
    protected int capacity;

    protected int[] stackArray;

    protected int top = -1;

    public StackArrayImpl() {
        this(CAPACITY);
    }

    public StackArrayImpl(int capacity) {
        this.capacity = capacity;
        stackArray = new int[this.capacity];
    }

    public int size() {
        return top + 1;
    }

    public boolean isEmpty() {
        return (top < 0);
    }

    public void push(int data) throws Exception {
        if (size() == capacity)
            throw new Exception("Stack is full. ");
        final int increment = ++top;
        System.out.println(increment);
        stackArray[increment] = data;
    }

    public int top() throws Exception {
        if (isEmpty())
            throw new Exception("Stack is empty. ");
        return stackArray[0];
    }

    public int pop() throws Exception {
        int data;
        if (isEmpty())
            throw new Exception("Stack is empty. ");
        data = stackArray[top];
        final int decrement = top--;
        stackArray[decrement] = Integer.MIN_VALUE;
        return data;
    }

    @Override
    public String toString() {
        return "StackArrayImpl{" +
                "capacity=" + capacity +
                ", stackArray=" + Arrays.toString(stackArray) +
                ", top=" + top +
                '}';
    }
}
