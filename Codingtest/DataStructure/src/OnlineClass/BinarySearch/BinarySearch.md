### BinarySearch

- 오름차순 **정렬**되어 있는 리스트 내에서 특정 값의 인덱스를 찾는 알고리즘
- 빠른속도
  - 탐색마다 절반씩 줄어 O(logN)의 시간복잡도를 갖는다.
  - N = 100  vs logN = 6.64
- 정렬된 리스트에서만 사용가능하다.

#### 이진탐색 진행방식
1. 데이터의 중간 인덱스 값을 찾는다
2. 중간 인덱스 위치를 기준으로 arr을 절반으로 나눈다.
3. 나눠진 절반의 리스트에서 target값을 찾는다.
