# 연산자
## 문자열 연결 연산자, 산술 연산자
```javascript
// 문자열 연결 연산자
'1' + 2; // '12'
1 + '2' // '12

// 산술 연산자
1 + 2; // 3

// true는 1로 타입 변환된다.
1 + true; // 2

// false는 0으로 타입 변환된다.
1 + false; // 1

// null은 0으로 타입 변환된다.
1 + null; // 1

// undefined는 숫자로 타입 변환되지 않는다.
+undefined; // NaN
1 + undefined; // NaN
```

## 할당문은 표현식인 문이다
```javascript
var x;

// 할당문은 표현식인 문이다.
console.log(x = 10); // 10

var a, b, c;

// 연쇄 할당, 오른쪽에서 왼쪽으로 진행
// c = 0 : 0으로 평가됨
// b = 0 : 0으로 평가됨
// a = 0 : 0으로 평가됨
a = b = c = 0;

console.log(a, b, c); // 0 0 0
```

## 동일/일치 비교 연산자
- ==: 동등 비교 / x == y / x와 y의 값이 같음
- ===: 일치 비교 / x === y / x와 y의 값과 타입이 같음
- !=: 부동등 비교 / x != y / x와 y의 값이 다름
- !==: 불일치 비교 / x !== y / x와 y의 값과 타입이 다름

## NaN은 자신과 일치하지 않는 유일한 값이다
```javascript
NaN === NaN; // false
```

## isNaN
```javascript
// isNaN 함수는 지정한 값이 NaN인지 확인하고 그 결과를 불리언 값으로 반환
isNaN(NaN); // true
isNaN(10); // false
isNaN(1 + undefined); // true
```

## Object.is 메서드
```javascript
// Object.is 메서드는 예측 가능한 정확한 비교 결과를 반환한다.
-0 === +0; // true
Object.is(-0, +0); // false

NaN === NaN; // false
Object.is(NaN, NaN); // true
```