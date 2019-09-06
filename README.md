# Programmers.2017_Java_KAKAOBLINDRECRUITMENT_SecretMap

## 프로그래머스 2017 카카오 블라인드 리쿠르트 > 비밀 지도

### 1. 문제설명

문제: https://programmers.co.kr/learn/courses/30/lessons/17681

input으로 가로세로의 길이가 같은 지도의 한 변의 길이 n, 1번지도의 정보 int[] arr1, 2번지도의 정보 int[] arr2가 들어온다. 지도의 정보중 int배열에서 하나의 값은 한 행의 정보이며 arr[i]를 이진수로 나타내었을 때 벽이 1, 빈 공간이 0으로 표시된 지도의 i번째 행을 의미한다.

arr1과 arr2를 겹쳐서 얻는 지도가 우리가 얻으려는 지도의 모습이다. 하나라도 벽인 부분은 전체지도에서 벽이되며 1번지도와 2번지도 모두 공백인 부분만이 전체지도에서 공백일 때, 전체지도의 행마다의 지도의 모습을 return하는 문제

ex) 

input
```java
int n = 5;
int[] arr1 = {9, 20, 28, 18, 11};
int[] arr2 = [30, 1, 21, 17, 28};
```
output ```["#####","# # #", "### #", "# ##", "#####"]```

### 2. 풀이

이진수로 지도를 표시했다는 점에서 비트연산자를 이용하여 풀어야 겠다 생각했다.

```java
for (int i = 0; i < n; i++) {
  answer[i] = Integer.toBinaryString(arr1[i] | arr2[i]);
  int diff = n - answer[i].length();
  while (diff-- != 0) {
    answer[i] = "0" + answer[i];
  }
  answer[i] = answer[i].replace('1','#').replace('0',' ');
}
```

(arr1[i] | arr2[i]) 을 이용해 전체 지도의 값을 알았으며 이를 Integer내에 있는 toBinaryString을 이용해 문자열로 이진수 값을 얻어냈다. 이후 1은 #으로 0은 공백으로 대체하여 문제를 해결하였다.

### 3. 어려웠던 점

```Integer.toBinaryString```을 이용하면 이진수 문자열이 나온다. 즉, 숫자가 작을 때 문자열의 길이가 n개로 나오지 않을 수 있다. 하지만 지도를 표시할 때 하나의 행마다 n개의 문자가 존재해야 하므로 n개가 되지 않는 문자열을 얻으면 길이의 차이만큼 앞에 빈칸을 추가하도록 하여 문제를 해결하였다.
