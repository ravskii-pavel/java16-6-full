package ua.dp.levelup.list;

//import groovyx.gpars.extra166y.Ops;

import java.util.Optional;

/**
 * Created by java on 24.01.2017.
 */
public class SingleLinkedList extends AbstractList {

    private Node start = null;

    @Override
    public void addFirst(Node node) {
        if(null == node) return;
        if(null == start){
            start = node;
        }
        else {
            node.setNext(start);
            start = node;
        }
        size++;
    }

    @Override
    public void addLast(Node node) {
        if (null == node) return;
        if (null == start){
            start = node;
        }
        else {
            Node tmp = start;
            while(tmp.next() != null){
                tmp = tmp.next();
            }
            tmp.setNext(node);
        }
        size++;
    }
    @Override
    public void addNode(Node node, int index) {

        if (index < 0 || index > size || null == node) return;
        if (null == start) {
            start = node;
        } else {
            Node current = start;
            Node prev = null;
            for (int currentIndex = 0; currentIndex <= size; currentIndex++) {
                if (index == currentIndex) {
                    node.setNext(current);
                    prev.setNext(node);
                    break;
                } else {
                    prev = current;
                    current = current.next();
                }
            }
        }
        size++;
    }

    @Override
    public void removeFirst() {
        Node first = start;
        if(null == first) return; //do nothing
        if(first.next() != null){
            start = first.next(); // can be null, if list size = 1
            first.setNext(null);
        }
        else{
            start = null;
        }
        size--;
    }

    @Override
    public void removeLast() {

        Node first = start;
        if (null == first) return;
        if (null == first.next()){
            start = null;
        }
        else {
            Node tmp = first.next();
            Node prev = first;
            while (null != tmp.next()){
                prev = tmp;
                tmp = tmp.next();
            }
            prev.setNext(null);
        }
        size--;
    }

    @Override
    public void removeNode(int index) {
        if (index < 0 || index >= size || null == start) return;
        if (null == start.next()) removeFirst();
        else {
            Node current = start;
            Node prev = null;
            for (int currentIndex = 0; currentIndex < size; currentIndex++) {
                if (index == currentIndex) {
                    prev.setNext(current.next());
                    break;
                } else {
                    prev = current;
                    current = current.next();
                }
            }
        }
        size--;
    }

    @Override
    public Optional<Node> getFirst() {
        return Optional.ofNullable(start);
    }

    @Override
    public Optional<Node> getLast() {
       Node last = start;
       while (last != null && last.next() != null) {
          last = last.next();
       }
       return Optional.ofNullable(last);
    }

    @Override
    public Optional<Node> get(int index) {
        if(index < 0 || index >= size) return Optional.empty();
        Node result = start;
        for(int currentIndex = 0; currentIndex < size; currentIndex++){
            if (currentIndex == index) break;
            result = result.next();
        }
        return Optional.of(result);
    }

    @Override
    public boolean isEmpty() {
        return null == start;
    }

    @Override
    public boolean isNotEmpty() {
        return !isEmpty();
    }
}
