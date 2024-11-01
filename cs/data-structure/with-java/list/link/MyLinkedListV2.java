package link;

public class MyLinkedListV2 {

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

    public void add(int index, Object e) {
        Node newNode = new Node(e);
        if (index == 0) {
            newNode.setNext(first);
            first = newNode;
        } else {
            Node prev = getNode(index - 1);
            newNode.setNext(prev.getNext());
            prev.setNext(newNode);
        }
        size++;
    }

    public Object remove(int index) {
        Node removedNode = getNode(index);
        Object removedElement = removedNode.getElement();
        if (index == 0) {
            first = first.getNext();
        } else {
            Node prev = getNode(index - 1);
            prev.setNext(removedNode.getNext());
        }
        removedNode.setNext(null);
        removedNode.setElement(null);
        size--;
        return removedElement;
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
