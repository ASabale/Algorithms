package examples;

public class Node {
    private int data;
    Node nextNode = null;
    public Node(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }
}
