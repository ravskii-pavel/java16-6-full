package ua.dp.levelup.list;

public class Node {

    private Node next = null;
    private Node previous = null;
    private Object value;

    public Node(Object value) {
        this.value = value;
    }

    public Node next() {
        return next;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
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
