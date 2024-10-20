import java.util.Arrays;

public class MyArrayListV3 {

    private static final int DEFAULT_CAPACITY = 5;
    private Object[] elements;
    private int size;

    public MyArrayListV3() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyArrayListV3(int initialCapacity) {
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

    public void add(int index, Object element) {
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

    public Object get(int index) {
        return elements[index];
    }

    public Object set(int index, Object element) {
        Object oldElement = elements[index];
        elements[index] = element;
        return oldElement;
    }

    public Object remove(int index) {
        Object oldElement = elements[index];
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
