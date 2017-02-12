package levelup.dp.ua.list;

/**
 * Created by java on 31.01.2017.
 */
public class Node<V> {
        private Node next = null;
        private Node prev = null;
        private final V value;

        private Node(V value) {
            this.value = value;
        }
    }
}
