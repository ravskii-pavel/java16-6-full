package tree;

import java.util.Comparator;

/**
 * Created by java on 27.01.2017.
 */
public class BinaryTree<T> implements Tree<T> {

    private class Node<V>{
        private Node<V> parrent;
        private Node<V> left;
        private Node<V> right;
        private final V value;

        public Node(V value) {
            this.value = value;
        }

        public void setParrent(Node<V> parrent) {
            this.parrent = parrent;
        }

        public void setLeft(Node<V> left) {
            left.setParrent(this);
            this.left = left;
        }

        public void setRight(Node<V> right) {
            right.setParrent(this);
            this.right = right;
        }

        public Node<V> getParrent() {
            return parrent;
        }

        public Node<V> getLeft() {
            return left;
        }

        public Node<V> getRight() {
            return right;
        }

        public V getValue() {
            return value;
        }
    }

    private Node<T> root;
    private int siz = 0;
    private final Comparator<T> comparator;

    public BinaryTree(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    @Override
    public void add(T value) {
        if(null== root){
            root = new Node<>(value);
        }
        else {
                add(value, root);
           }
    }
    private void add(T val, Node<T> parrent){
        if(comparator.compare(val, root.getValue()) < 0) {
            //left
            if(parrent.getLeft() == null){
                parrent.setLeft(new Node<>(val));
            }
            else {
                add(val, parrent.getLeft());
            }
        }
        else if (comparator.compare(val, root.getValue()) > 0) {
            //right
            if(parrent.getRight() == null){
                parrent.setRight(new Node<>(val));
            }
            else {
                add(val, parrent.getRight());
            }
        }
    }

    @Override
    public void addAll(T[] value) {

    }

    @Override
    public void remove(T value) {

    }

    @Override
    public void print() {
        if (null == root) return;
        printChild(root);
    }

    private void printChild(Node<T> parrent) {
        if (parrent.getLeft() != null){
            printChild(parrent.getLeft());
        }
        System.out.println(parrent.getValue());

        if (parrent.getRight() != null){
            printChild(parrent.getRight());
        }
    }
}

