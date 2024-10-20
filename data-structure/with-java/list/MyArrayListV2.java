import java.util.Arrays;

public class MyArrayListV2 {

    private static final int DEFAULT_CAPACITY = 5;
    private Object[] elements;
    private int size;

    public MyArrayListV2() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyArrayListV2(int initialCapacity) {
        elements = new Object[initialCapacity];
    }

    public int size() {
        return size;
    }

    public void add(Object element) {
        if (size == elements.length) {
            grow();
        }
        elements[size] = element;
        size++;
    }

    private void grow() {
        int oldCapacity = elements.length;
        int newCapacity = oldCapacity * 2;
        elements = Arrays.copyOf(elements, newCapacity);
    }

    public Object get(int index) {
        return elements[index];
    }

    public Object set(int index, Object element) {
        Object oldElement = elements[index];
        elements[index] = element;
        return oldElement;
    }

    public int indexOf(Object element) {
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
