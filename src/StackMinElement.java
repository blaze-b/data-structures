import java.util.Stack;

public class StackMinElement {

    private Stack<Integer> elements;

    private Stack<Integer> minElement;


    public StackMinElement() {
        elements = new Stack<>();
        minElement = new Stack<>();
    }

    public Integer push(int item) {
        elements.push(item);
        if(minElement.empty() || minElement.peek() > item)
            minElement.push(item);
        else
            minElement.push(minElement.pop());
        return item;
    }


    public Integer getMinElement() {
        return minElement.peek();
    }

    public Stack<Integer> getSorted() {
        return minElement;
    }

}
