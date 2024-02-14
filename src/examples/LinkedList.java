package examples;

public class LinkedList {
    Node head;

    public void print() {
        Node temp = head;
        while(temp!=null){
            System.out.println(temp.getData());
            temp = temp.nextNode;
        }
    }
}
