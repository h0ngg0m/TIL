## ArrayList Big-O

- 데이터 추가
    - 맨 뒤에 추가: O(1)
    - 중간에 추가: O(n)
- 데이터 삭제
    - 맨 뒤에서 삭제: O(1)
    - 중간에서 삭제: O(n)
- 인덱스 조회: O(1)
- 데이터 조회: O(n)

## 의존관계 주입, 알고리즘 선택의 중요성

```java
public class BatchApp {

    private final List list;

    BatchApp(List list) {
        this.list = list;
    }

    public void logic(int size) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            list.add(0, i);
        }
        long end = System.currentTimeMillis();
        System.out.println("걸린 시간: " + (end - start) + "ms");
    }
}

// ...

public class Main {
    public static void main(String[] args) {
        List arrayList = new ArrayList();
        LinkedList linkedList = new LinkedList();

//        BatchApp arrayListApp = new BatchApp(arrayList);
//        arrayListApp.logic(1_000); // 0ms
//        arrayListApp.logic(10_000); // 5ms
//        arrayListApp.logic(100_000); // 516ms
//        arrayListApp.logic(500_000); // 15405ms

        BatchApp linkedListApp = new BatchApp(linkedList);
        linkedListApp.logic(1_000); // 0ms
        linkedListApp.logic(10_000); // 0ms
        linkedListApp.logic(100_000); // 2ms
        linkedListApp.logic(500_000); // 26ms
    }
}
```
- 의존성 주입
  - 인터페이스 의존: `BatchApp`은 구체적인 구현체가 아닌 인터페이스에 의존하고 있어 `코드 변경 하나없이` 핵심적인 로직에 필요한 ArrayList, LinkedList를 `주입`받아 사용할 수 있다.
- 알고리즘 선택의 중요성
  - `ArrayList`는 인덱스 0에 데이터를 추가할 때, `O(n)`의 시간복잡도를 가지고 있어 데이터가 많아질수록 시간이 많이 걸린다. (데이터를 추가할 때, 기존 데이터를 한 칸씩 뒤로 밀어야 하기 때문)
  - 반면 `LinkedList`는 인덱스 0에 데이터를 추가할 때, `O(1)`의 시간복잡도를 가지고 있어 데이터가 많아져도 시간이 거의 걸리지 않는다. (데이터를 추가할 때, 앞 뒤 노드의 주소만 변경하면 되기 때문)

## 유연한 (재사용성이 좋은) 코드 작성의 핵심
- `결정을 내리는 시점을 최대한 늦추는 것`
  - 함수의 예시: 아래 함수에서 `printA`, `printB`는 컴파일 시점에 어떤 것을 출력할지 결정되지만, `print`는 런타임 시점에 어떤 것을 출력할지 결정된다. 따라서
  `print` 함수는 어떤 것을 출력할지에 대한 `결정의 시점이 늦춰져 있어` 앞 두 함수보다 유연한 코드라고 할 수 있다.
  ```java
    public void printA() {
        System.out.println("A");
    }
    
    public void printB() {
        System.out.println("B");
    }
    
    // ... 
  
    public void print(String s) {
        System.out.println(s);
    }
  ```
  - 의존성 주입의 예시: `BatchApp`은 `List` 인터페이스에 의존하고 있어, `ArrayList`, `LinkedList` 등의 구현체 사용에 대한 결정을 `최대한 늦추고` 있다. 따라서 `BatchApp`은 런타임 시점에
  어떤 구현체를 사용할지 결정할 수 있어 `유연한 코드`라고 할 수 있다.
  ```java
  public class BatchApp {

      private final List list;

      BatchApp(List list) {
          this.list = list;
      }

      public void logic(int size) {
          long start = System.currentTimeMillis();
          for (int i = 0; i < size; i++) {
              list.add(0, i);
          }
          long end = System.currentTimeMillis();
          System.out.println("걸린 시간: " + (end - start) + "ms");
      }
  }
  ```
