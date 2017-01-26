package ua.dp.levelup.list;

//import groovyx.gpars.extra166y.Ops;

import java.util.Optional;

/**
 * Created by java on 24.01.2017.
 */
public class SingleLinkedList extends AbstractList {

    private Node root = null;

    @Override
    public void addFirst(Node node) {
        if (null == node) return;
        if(null == root){
            root = node;
        }
        else {
            node.setNext(root);
            root = node;
        }
        size++;
    }

    @Override
    public void addLast(Node node) {
        if (null == node) return;
        if (null == root){
            root = node;
        }
        else {
            Node tmp = root;
            while(tmp.next() != null){
                tmp = tmp.next();
            }
            tmp.setNext(node);
        }
        size++;
    }
    @Override
    public void addNode(Node node, int index) {
        if(index < 0 || index > size || null == node) return;
        size++;
        if (null == root){
            root = node;
        }
        else {
            Node current = root;
            Node tmp = root;
            Node prev = null;
            for(int currentIndex = 0; currentIndex < size; currentIndex++){
                if (index == currentIndex){
                    tmp = current;
                    current = node;
                    prev = tmp.previous();
                    prev = tmp.previous();
                    current.setNext(current);
                    current = node;
                    break;
                }
                prev = current;
                current = current.next();
            }
            while(tmp.next() != null){
                tmp = tmp.next();
            }
            tmp.setNext(node);
        }
        size++;


        /*if(index < 0 || index >= size) return Optional.empty();
        Node result = root;
        for(int currentIndex = 0; currentIndex < size; currentIndex++){
            if (currentIndex == index) break;
            result = result.next();
        }
        return Optional.of(result);*/
    }

    @Override
    public void removeFirst() {
        Node first = root;
        if(null == first) return; //do nothing
        if(first.next() != null){
            root = first.next(); // can be null, if list size = 1
            first.setNext(null);
        }
        else{
            root = null;
        }
        size--;
    }

    @Override
    public void removeLast() {

        Node first = root;
        if (null == first) return;
        if (null == first.next()){
            root = null;
        }
        else {
            Node tmp = first.next();
            Node prev = tmp;
            while (null != tmp.next()){
                prev = tmp;
                tmp = tmp.next();
            }
            prev.setNext(null);
        }
        size--;
    }

    @Override
    public Optional<Node> getFirst() {
        return Optional.ofNullable(root);
    }

    @Override
    public Optional<Node> getLast() {
       Node last = root;
       while (last != null && last.next() != null) {
          last = last.next();
       }
       return Optional.ofNullable(last);
    }

    @Override
    public Optional<Node> get(int index) {
        if(index < 0 || index >= size) return Optional.empty();
        Node result = root;
        for(int currentIndex = 0; currentIndex < size; currentIndex++){
            if (currentIndex == index) break;
            result = result.next();
        }
        return Optional.of(result);
    }

    @Override
    public boolean isEmpty() {
        return null == root;
    }

    @Override
    public boolean isNotEmpty() {
        return !isEmpty();
    }
}
