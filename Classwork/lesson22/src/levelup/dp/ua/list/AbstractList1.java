public abstract class AbstractList<N> {

    protected int size = 0;

    public int size() {
        return size;
    }

    public abstract void add(N node, int index);

    public abstract void addFirst(N node);

    public abstract void addLast(N node);

    public abstract void removeFirst();

    public abstract void removeLast();

    public abstract Optional<N> getFirst();

    public abstract Optional<N> getLast();

    public abstract Optional<N> get(int index);

    public abstract boolean isEmpty();

    public abstract boolean isNotEmpty();
}