public class DoublyLinkedList<T> extends AbstractList<Node<T>> implements Iterable<Node<T>>{

    private Node<T> head = null;
    private Node<T> tail = null;
    private int size = 0;

    @Override
    public void add(Node<T> node, int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException(String.format("Passed not correct index: %d", index));

        if (index == 0) {
            addFirst(node);
        } else if (index == size) {
            addLast(node);
        } else {
            Optional<Node<T>> tmp = get(index);
            if(tmp.isPresent()) {
                Node<T> oldNode = tmp.get();
                Node<T> prevOld = oldNode.getPrev();

                prevOld.setNext(node);
                node.setPrev(prevOld);

                node.setNext(oldNode);
                oldNode.setPrev(node);
            }
        }
    }

    @Override
    public void addFirst(Node<T> node) {
        if (null == node) return;
        if (null == head) {
            head = node;
            tail = node;
        } else {
            node.setNext(head);
            head.setPrev(node);
            head = node;
        }
        size++;
    }

    @Override
    public void addLast(Node<T> node) {
        if (null == node) return;
        if (null == tail) {
            addFirst(node);
            return;
        } else {
            tail.setNext(node);
            node.setPrev(tail);
            tail = node;
        }
        size++;

    }

    @Override
    public void removeFirst() {
        if(null == head) return;
        if(size == 1) {
            head = null;
            tail = null;
        } else {
            head.getNext().setPrev(null);
            head = head.getNext();
        }
        size--;
    }

    @Override
    public void removeLast() {
        if(null == tail) return;
        if(size == 1) {
            head = null;
            tail = null;
        } else {
            tail.getPrev().setNext(null);
            tail = tail.getPrev();
        }
        size--;
    }

    @Override
    public Optional<Node<T>> getFirst() {
        return Optional.ofNullable(head);
    }

    @Override
    public Optional<Node<T>> getLast() {
        return Optional.ofNullable(tail);
    }

    @Override
    public Optional<Node<T>> get(int index) {
        if (index < 0 || index > size - 1)
            throw new IllegalArgumentException(String.format("Passed not correct index: %d", index));

//        Node<T> res = head;
//        for(int i = 0; i <= index; i++) {
//            res = res.getNext();
//        }
        Node<T> res = null;

        Iterator<Node<T>> iterator = iterator();
        int currentIndex = 0;
        while (iterator.hasNext() && currentIndex <= index) {
            res = iterator.next();
        }
        return Optional.ofNullable(res);
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean isNotEmpty() {
        return false;
    }

    @Override
    public Iterator<Node<T>> iterator() {
        return new Iterator<Node<T>>() {

            private Node<T> cursor = head;

            @Override
            public boolean hasNext() {
                return null != cursor;
            }

            @Override
            public Node<T> next() {
                if(!hasNext()) throw new NoSuchElementException();
                Node<T> tmp = cursor;
                cursor = tmp.getNext();
                return tmp;
            }
        };
    }

    public void swap(int nodeA, int nodeB) {
        if(nodeA == nodeB) return;

        Node<T> tmpA = get(nodeA).get();
        Node<T> tmpB = get(nodeB).get();

        if(tmpA.getPrev() == tmpB) {
            tmpB.setNext(tmpA.getNext());
            tmpA.setPrev(tmpB.getPrev());
            tmpA.setNext(tmpB);
        } else if(tmpA.getNext() == tmpB) {

        } else {

        }
    }
}