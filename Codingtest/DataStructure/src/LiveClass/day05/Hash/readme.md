### 해시

알고리즘 문제풀이에서의 해시
- key-value를 이용해 한 쌍으로 데이터를 다루는 방식
- 매우빠른 검색속도 O(1)
- 표 형태의 데이터

해시 충돌과 해결법
1. 체이닝(Chaining)
버킷 내에 연결리스트(Linked List)를 할당하여, 버켓에 데이터를 삽입하다가 해시 충돌을 발생하면
연결리스트로 데이터들으 연결하는 방식

2. 개방 주소법(Open Addressing)
해시 충돌이 일어나면 다른 버켓에 데이터를 삽입하는 방식
- 선형 탐색 : 해시충돌 시 다음 버켓 혹은 몇 개를 건너뛰어 데이터를 삽입
- 제곱 탐색 : 해시충돌 시 제곱만큼 건너뛴 버켓에 데이터를 삽입
- ?? 탐색 : 


#### 유용한 메서드
getOrDefault(Object key, V Default)
