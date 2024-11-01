package link;

public class MyLinkedListV3<E> {

    private Node<E> first;
    private int size = 0;

    public void add(E e) {
        Node<E> newNode = new Node<>(e);
        if (first == null) {
            first = newNode;
        } else {
            Node<E> last = getLastNode();
            last.setNext(newNode);
        }
        size++;
    }

    public void add(int index, E e) {
        Node<E> newNode = new Node<>(e);
        if (index == 0) {
            newNode.setNext(first);
            first = newNode;
        } else {
            Node<E> prev = getNode(index - 1);
            newNode.setNext(prev.getNext());
            prev.setNext(newNode);
        }
        size++;
    }

    public E remove(int index) {
        Node<E> removedNode = getNode(index);
        E removedElement = removedNode.getElement();
        if (index == 0) {
            first = first.getNext();
        } else {
            Node<E> prev = getNode(index - 1);
            prev.setNext(removedNode.getNext());
        }
        removedNode.setNext(null);
        removedNode.setElement(null);
        size--;
        return removedElement;
    }

    private Node<E> getLastNode() {
        Node<E> x = first;
        while (x.getNext() != null) {
            x = x.getNext();
        }
        return x;
    }

    public E set(int index, E e) {
        Node<E> x = getNode(index);
        E oldElement = x.getElement();
        x.setElement(e);
        return oldElement;
    }

    public E get(int index) {
        Node<E> x = getNode(index);
        return x.getElement();
    }

    private Node<E> getNode(int index) {
        Node<E> x = first;
        for (int i = 0; i < index; i++) {
            x = x.getNext();
        }
        return x;
    }

    public int indexOf(E e) {
        Node<E> x = first;
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

    private static class Node<E> {
        private E element;
        private Node<E> next;

        public Node(E element) {
            this.element = element;
        }

        public E getElement() {
            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }
}
