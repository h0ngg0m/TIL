import java.util.Arrays;

public class MyArrayListV4<E> {

    private static final int DEFAULT_CAPACITY = 5;
    private Object[] elements;
    private int size;

    public MyArrayListV4() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyArrayListV4(int initialCapacity) {
        elements = new Object[initialCapacity];
    }

    public int size() {
        return size;
    }

    public void add(E element) {
        if (size == elements.length) {
            grow();
        }
        elements[size] = element;
        size++;
    }

    public void add(int index, E element) {
        if (size == elements.length) {
            grow();
        }
        shiftToRightFrom(index);
        elements[size] = element;
        size++;
    }

    private void shiftToRightFrom(int index) {
        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }
    }

    private void grow() {
        int oldCapacity = elements.length;
        int newCapacity = oldCapacity * 2;
        elements = Arrays.copyOf(elements, newCapacity);
    }

    public E get(int index) {
        return (E) elements[index];
    }

    public E set(int index, E element) {
        E oldElement = get(index);
        elements[index] = element;
        return oldElement;
    }

    public E remove(int index) {
        E oldElement = get(index);
        shiftToLeftFrom(index);
        size--;
        elements[size] = null;
        return oldElement;
    }

    private void shiftToLeftFrom(int index) {
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
    }

    public int indexOf(E element) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(elements[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

}
