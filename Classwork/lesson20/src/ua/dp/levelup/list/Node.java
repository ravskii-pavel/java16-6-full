package ua.dp.levelup.list;

public class Node {

    private Node next = null;
    private Object value;

    public Node(Object value) {
        this.value = value;
    }

    public Node next() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
