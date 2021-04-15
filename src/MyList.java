public interface MyList<T> {
    void add(T e);
    void add(int index, T element);
    void addAll(T[] c);
    void addAll(int index, T[] c) throws IndexOutOfBoundsException;
    T get(int index) throws IndexOutOfBoundsException;
    T remove(int index) throws IndexOutOfBoundsException;

    void set(int index, T element);

    int indexOf(T o);

    int size();
    T[] toArray();
}