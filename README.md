TIL(개인공부 저장소)
====
Today I learned (23.04.03 수정)

<br>

md (markdown) 문서 작성법
--

<br>

- 개행

다음줄 넘기기 - 엔터 두번  
글 작성중 개행 - 줄 맨끝에 스페이스바 두번  
공간 띄우기 \<br>

<br>

글자 크기 지정
--

대제목 사용 시 아래 (=) 
===
\====

중제목 사용 시 아래 (-)
-
\------

갯수 상관없이 추가해도 된다!

<br>

###### 샵6
##### 샵5
#### 샵4
### 샵3
## 샵2 
# 샵1 갯수에 따라 크기조정


강조하기
-

- ** 감싸기  __ 감싸기

와우 **JavaScript**를 __공부__ 하시는 군요?

. 기울임체 - *** 감싸기

나 ***비뚫어질거야*** 

. 취소선 - ~~ 감싸기

취소 ! ~~취소!~~

. 코드넣기 -  ``` 감싸기 + 언어 \n 코드내용

```javascript
console.log('Hello');
```

<br>

인용하기
--


 - 문장앞에 >

> 인용문구 입니다

URL 링크 - 보이기, 숨기기

https://developer.mozilla.org/ko/docs/Web/JavaScript

[바로가기]https://developer.mozilla.org/ko/docs/Web/JavaScript

[상대적참조] (../JavaScript/JS문법/cheatNote)

<br>

리스트 작성하기 -  리스트 앞에 -, *, +
--

- 1초라도 안보이면
* 2렇게 초조한데
+ 3초는 어떻게 기다려

<br>

순서가 필요한 목록 \<ol>, \<ul> 목록 태그로 변환
--

1. 순서가 필요한 목록
1. 순서가 필요한 목록
    - 순서 없음
    - 순서 없음
1. 순서 필요
    1. 순서 필요
    1. 순서 필요
1. 순서 필요

이미지 삽입
```
![대체 텍스트 작성](이미지 링크)
[logo] : 이미지 링크
[![이름](이미지 링크)](링크)
```

수평선
---
(하이픈 ---)

***
(Asterisks ***)

___
(Underscores)

. 마크다운 표 만들기
|제목 셀1|제목 셀2|제목 셀3|제목 셀4|
|---|---|---|---|
|내용 1|내용 2|내용 3|내용 4|
|내용 5|내용 6|내용 7|내용 8|
|내용 9|내용 10|내용 11|내용 12|




