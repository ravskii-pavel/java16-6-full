public class Node<V> {

    private Node<V> next = null;
    private Node<V> prev = null;
    private final V value;

    private Node(V value) {
        this.value = value;
    }

    public Node<V> getNext() {
        return next;
    }

    public void setNext(Node<V> next) {
        this.next = next;
        if(next != null) next.setPrev(this);
    }

    public Node<V> getPrev() {
        return prev;
    }

    public void setPrev(Node<V> prev) {
        this.prev = prev;
        if (prev != null) prev.setNext(this);
    }

    public V getValue() {
        return value;
    }
}