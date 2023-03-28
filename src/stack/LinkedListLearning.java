package stack;

import java.util.LinkedList;
import java.util.List;

public class LinkedListLearning {

    private Link first;

    public LinkedListLearning() {
        this.first=null;
    }

    public void insertFirst(int key, int data) {
        Link link = new Link(key, data);
        link.next = first;
        first = link;
    }





    public static void main(String[] args) {

        LinkedListLearning list = new LinkedListLearning();

        list.insertFirst(1, 10);
        list.insertFirst(2, 20);
        list.insertFirst(3, 30);
        list.insertFirst(4, 1);
        list.insertFirst(5, 40);
        list.insertFirst(6, 56);

        System.out.print("\nOriginal List: " + list);
    }
}

class Link {

    public Link next;
    public int data;
    public int key;

    public Link(int key, int data) {
        this.key = key;
        this.data= data;
    }

    public void display () {
        System.out.println("{"+key+"," + data + "}");
    }
}
