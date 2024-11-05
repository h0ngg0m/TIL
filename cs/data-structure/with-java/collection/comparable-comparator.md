## 비교자 - Comparator
```java
public interface Comparator<T> {
    int compare(T o1, T o2);
}
```
- 두 인수를 비교해서 결과 값을 반환하면 된다.
  - 첫 번째 인수가 더 작으면 음수, 예 (`-1`)
  - 두 값이 같으면 `0`
  - 첫 번째 인수가 더 크면 양수, 예 (`1`)

```java
public static void main(String[] args) {
    Integer[] array = new Integer[]{1, 3, 2};
    Arrays.sort(array, new AscComparator());
    System.out.println(Arrays.toString(array)); // [1, 2, 3]
    Arrays.sort(array, new DescComparator());
    System.out.println(Arrays.toString(array)); // [3, 2, 1]
}

static class AscComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer a, Integer b) {
        return (a < b) ? -1 : ((a == b) ? 0 : 1);
    }
}

static class DescComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer a, Integer b) {
        return (a < b) ? -1 : ((a == b) ? 0 : 1) * -1;
    }
}
```

## 비교 가능한 객체를 만들기 - Comparable
```java
public interface Comparable<T> {
    int compareTo(T o);
}
```

```java
public class MyUser implements Comparable<MyUser> {

    private String id;
    private int age;

    public MyUser(String id, int age) {
        this.id = id;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(MyUser o) {
        return this.age < o.age ? -1 : (this.age == o.age ? 0 : 1);
    }
}
```

```java
public static void main(String[] args) {
    MyUser user1 = new MyUser("a", 30);
    MyUser user2 = new MyUser("b", 20);
    MyUser user3 = new MyUser("c", 10);

    MyUser[] array = new MyUser[]{user1, user2, user3};
    System.out.println("Before sorting:");
    System.out.println(Arrays.toString(array)); // MyUser{id='a', age=30}, MyUser{id='b', age=20}, MyUser{id='c', age=10}

    System.out.println("After sorting:");
    Arrays.sort(array);
    System.out.println(Arrays.toString(array)); // MyUser{id='c', age=10}, MyUser{id='b', age=20}, MyUser{id='a', age=30} => sorted by age
}
```
- `Comparable` 인터페이스를 구현하면 `Arrays.sort()` 메서드를 사용할 때 정렬 기준을 제공할 수 있다.
  - 별도의 정렬을 제공하고 싶다면 `Comparator` 인터페이스를 구현하여 `Arrays.sort()` 메서드에 전달하면 된다. 