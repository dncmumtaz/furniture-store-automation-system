public class LinkedList<T> implements MyList<T> {

    private T[] a;
    private Node headNode;
    private Node lastusedNode;

    private class Node<T>{
        public T value;
        public Node link;

        public Node(T value, Node link){
            this.value = value;
            this.link = link;
        }
        public Node(T value){
            this.value = value;
            this.link = null;
        }

    }


    public LinkedList(T value){
        Node<T> head = new Node<T>(value);
        this.headNode = head;
        this.lastusedNode = head;
    }


    public void add(T e) {
        Node<T> added = new Node<T>(e);
        Node takenItem = this.headNode;
        while (takenItem.link != null){
            takenItem = takenItem.link;
        }
        takenItem.link = added;
    }

    public void add(int index, T value) {
        Node takenItem = this.headNode;
        Node<T> added = new Node<T>(value);
        int i = 0;
        while(takenItem.link!=null && i < index){
            takenItem = takenItem.link;
            i++;
        }
        if (index > 0) {
            added.link = takenItem.link;
            takenItem.link = added;
        } else {
            added.link = this.headNode;
            this.headNode = added;
        }
    }

    public void addAll(T[] c) {
        for (int i=0;i<c.length;i++){
            add( (T) c[i]);
        }
    }

    public void addAll(int index, T[] c) throws IndexOutOfBoundsException {
        for (int i=index;i<index+c.length;i++){
            add(i,(T) c[i-index]);
        }
    }

    public T get(int index) throws IndexOutOfBoundsException {
        Node takenItem = this.headNode;
        for(int i=0;i<index;i++){
            if (takenItem.link !=  null)
                takenItem = takenItem.link;
            else {
                return null;
            }
        }
        return (T)takenItem.value;
    }

    public T remove(int index) throws IndexOutOfBoundsException {
        Node takenItem = this.headNode;
        Node previousItem = takenItem;
        for(int i=0;i<index;i++){
            previousItem = takenItem;
            takenItem = takenItem.link;
        }
        previousItem.link = takenItem.link;
        return (T) takenItem.value;
    }

    public void set(int index, T value) {
        Node takenItem = this.headNode;
        for (int i=0;i<index;i++)
            takenItem = takenItem.link;
        takenItem.value = value;
    }



    public int indexOf(T o) {
        int c= 0;
        Node takenItem = this.headNode;
        while(takenItem.link != null){
            c++;
            if (takenItem.value == o) return c;
            takenItem = takenItem.link;
        }
        return -1;
    }

    public int size() {
        Node takenItem = this.headNode;
        int c = 0;
        while(takenItem.link != null){
            takenItem = takenItem.link;
            c++;
        }
        return c;
    }

    public T[] toArray() {
        Node takenItem = this.headNode;
        T[] arr = (T[]) new Object[size()+1];
        int c = 0;
        while(takenItem.link != null){
            arr[c] = (T) takenItem.value;
            takenItem = takenItem.link;
            c++;
        }
        return arr;
    }

    @Override
    public String toString(){
        String out = new String();
        Node takenItem = this.headNode;
        while (takenItem != null) {
            out += "[" + takenItem.value + "]";
            takenItem = takenItem.link;
        }
        return out;
    }

}
