package link;

public class MyLinkedListV1 {

    private Node first;
    private int size = 0;

    public void add(Object e) {
        Node newNode = new Node(e);
        if (first == null) {
            first = newNode;
        } else {
            Node last = getLastNode();
            last.setNext(newNode);
        }
        size++;
    }

    private Node getLastNode() {
        Node x = first;
        while (x.getNext() != null) {
            x = x.getNext();
        }
        return x;
    }

    public Object set(int index, Object e) {
        Node x = getNode(index);
        Object oldElement = x.getElement();
        x.setElement(e);
        return oldElement;
    }

    public Object get(int index) {
        Node x = getNode(index);
        return x.getElement();
    }

    private Node getNode(int index) {
        Node x = first;
        for (int i = 0; i < index; i++) {
            x = x.getNext();
        }
        return x;
    }

    public int indexOf(Object e) {
        Node x = first;
        for (int i = 0; i < size; i++) {
            if (x.getElement().equals(e)) {
                return i;
            }
            x = x.getNext();
        }
        return -1;
    }

    public int size() {
        return size;
    }
}
