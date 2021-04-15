import java.util.AbstractList;
import java.util.Arrays;
import java.util.Iterator;

public class KWArrayList < E >  extends AbstractList<E> {

    // Data Fields

    /**
     * The default initial capacity
     */
    private static int MAX_NUMBER = 10;
    /**
     * The underlying data array
     */
    private E[] theData;
    /**
     * The current size
     */
    private int size = 0;
    /**
     * The current capacity
     */
    private int capacity = 0;

    /**
     * Construct an empty KWArrayList with the default
     * initial capacity
     */
    public KWArrayList() {
        capacity = MAX_NUMBER;
        theData = (E[]) new Object[capacity];
    }



    public boolean add(E anEntry) {
        if (size == capacity) {
            reallocate();
        }
        theData[size] = anEntry;
        size++;
        return true;
    }

    /**
     * Get a value in the array based on its index.
     *
     * @param index - The index of the item desired
     * @return The contents of the array at that index
     * @throws ArrayIndexOutOfBoundsException - if the index
     *                                        is negative or if it is greater than or equal to the
     *                                        current size
     */
    public E get(int index) {
        if (index < 0 /*|| index >= size*/) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        return theData[index];
    }

    /**
     * Set the value in the array based on its index.
     *
     * @param index    - The index of the item desired
     * @param newValue - The new value to store at this position
     * @return The old value at this position
     * @throws ArrayIndexOutOfBoundsException - if the index
     *                                        is negative or if it is greater than or equal to the
     *                                        current size
     */
    public E set(int index, E newValue) {
        if (index < 0 /*|| index >= size*/) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        E oldValue = theData[index];
        theData[index] = newValue;
        return oldValue;
    }

    /**
     * Remove an entry based on its index
     *
     * @param index - The index of the entry to be removed
     * @return The value removed
     * @throws ArrayIndexOutOfBoundsException - if the index
     *                                        is negative or if it is greater than or equal to the
     *                                        current size
     */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        E returnValue = theData[index];
        for (int i = index + 1; i < size; i++) {
            theData[i - 1] = theData[i];
        }
        size--;
        return returnValue;
    }

    /**
     * Allocate a new array to hold the directory
     */
    private void reallocate() {
        capacity = 2 * capacity;
        theData = Arrays.copyOf(theData, capacity);
    }

    /**
     * Get the current size of the array
     *
     * @return The current size of the array
     */
    public int size() {
        return size;
    }

    /**
     * Construct an empty KWArrayList with a specified initial capacity
     *
     * @param capacity The initial capacity
     */
    public KWArrayList(int capacity) {
        theData = (E[]) new Object[capacity];
    }


    /**
     * Returns the index of the first occurence of the specified element
     * in this list, or -1 if this list does not contain the element
     *
     * @param item The object to search for
     * @returns The index of the first occurence of the specified item
     * or -1 if this list does not contain the element
     */
    public int indexOf(Object item) {
        int Index = -1;
        for (int i = 0; (i < theData.length && Index == -1); i++) {
            if (theData[i] == item) {
                Index = i;
            }
        }
        return Index;
    }


    public static void main(String[] args) {
        //test your methods here to make sure they work.
        KWArrayList<Integer> l = new KWArrayList();
        l.add(5);
        System.out.println("Current KWArrayList: " + l);

        KWArrayList<Integer> al = new KWArrayList<Integer>();
        al.add(1);
        al.add(2);
        al.add(3);

    }
}