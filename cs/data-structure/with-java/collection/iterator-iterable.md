# Iterator, Iterable

### Iterator 인터페이스의 주요 메서드
```java
public interface Iterator<E> {
    boolean hasNext();
    E next();
}
```

### Iterable 인터페이스의 주요 메서드
```java
public interface Iterable<E> {
    Iterator<E> iterator();
}
```

- 반복이 가능한 객체에 `Iterable` 인터페이스를 구현하고, 이를 통해 `Iterator` 인터페이스를 반환한다.
  - `Iterator` 인터페이스 구현을 통해 어떻게 반복할지에 대한 로직을 구현한다.


### 구현 예시
```java
import java.util.Iterator;

public class MyArray implements Iterable<Integer> {

    private int[] array;

    public MyArray(int[] array) {
        this.array = array;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new MyArrayIterator(array);
    }
}
```
- 위와 같이 순회를 원하는 객체에 `Iterable` 인터페이스를 구현하고, `Iterator` 인터페이스를 반환하는 `iterator` 메서드를 구현한다.

```java
import java.util.Iterator;

public class MyArrayIterator implements Iterator<Integer> {

    private int[] array;
    private int index = -1;

    public MyArrayIterator(int[] array) {
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        return index < array.length - 1;
    }

    @Override
    public Integer next() {
        return array[++index];
    }
}
```
- `Iterator` 인터페이스를 구현하는 클래스는 구체적으로 어떻게 반복할지에 대한 로직을 구현한다.

```java
public class Main {
    public static void main(String[] args) {
        MyArray myArray = new MyArray(new int[]{1, 2, 3, 4, 5});

        for (int num : myArray) {
            System.out.println(num);
        }
    }
}
```
- `Iterable` 인터페이스를 구현한 객체는 `for-each` 문을 통해 간편하게 순회할 수 있다. (문법적 설탕)
- List, Set, Queue 등의 인터페이스는 `Iterable` 인터페이스를 상속하고 있어 `for-each` 문을 통해 순회할 수 있다.