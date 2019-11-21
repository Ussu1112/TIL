### let

블럭 단위의 스코프에서 지원 , 변경이 가능하다.

- 한번 선언 했을 시 똑같은 이름으로 선언 불가

### const

변경이 되지않는 변수

const를 기본으로 하고, 변경이 될 수 있는 변수는 let을 사용하고 var는 사용하지 않는다.

const를 사용하더라도 배열과 오브젝트의 값을 변경하는 것은 가능하다.            

### 스코프 (Scope)

어떤 변수들에 접근할 수 있는지를 정의
전역 스코프(global Scope)와 지역 스코프(local Scope)로 나뉜다.

#### Global Scope

변수가 함수 바깥이나 중괄호 바깥에 선언되었다면, 전역 스코프에 정의되었다고 한다.

```javascript
const globalVariable = 'some value'
```
전역으로 선언할 수 있지만, 사용을 지양한다.
두 개 이상의 변수의 이름이 충동하는 경우가 생길 수 있음.

const, let 선언 시 에러 발생
var 선언시 덮어씀

### Local Scope

특정 부분에서만 사용할 수 있는 변수는 지역 스코프에 있다고 할 수 있음 -> 지역 변수

지역 변수 내에 함수 스코프와 블록 스코프로 나뉨

#### 함수 스코프 (Function Scope)

함수 내부에 변수 선언시에 선언한 변수는 함수 내부에서만 접근 가능

#### 블록 스코프 (Block Scope)

중괄호{} 내부에서 const, let 선언 시 중괄호 블록 내부에서만 접근 가능

### closure

### immutable array

뒤로가기, 앞으로가기 할 때 저장된 데이터로 보여줘야 할 때
불변의 array를 만드는 것 기존의 데이터를 건들지 않는다.

```javascript
const list = ["apple", "orange", "watermelon"]
list2 = [].concat(list,"banana")
console.log(list === list2); //output : false
```

### ES2015 string에 새로운 메소드들

```javascript
let str = "hello world !"
let matchstart = "hello";
let matchend = "d !"
console.log(str.startsWith(matchstart)); //output : true
console.log(str.endsWith(matchend)); //output : true
console.log(str.includes("world")); //output : true
```

### for of

```javascript
var data = [1,2,undefined,NaN,null,""];
data.forEach(function(value){
    console.log("value :", value);
});

for (let idx in data){
    console.log(data[idx]);
} 
```
for in은 자신이 갖지않은 상위 데이터까지 검색한다. (Array 에서 사용하지 말것)

```javascript
for(let value of data) {
    console.log(value);
} 
```
배열 순회시 for of 사용

```javascript
for(let value of str){
    console.log(value);
}
```
문자열에도 사용가능

### spread operator , 펼침연산자
 
```javascript
let pre = ["apple","orange",100];
let newData = [...pre];  // [] : 배열을 뜻함. ... : 펼쳐서 출력
console.log(pre,newData);
```

### spread operator 활용

```javascript 
let pre = [100,200,"hello",null];
let newData = [0,1,2,3, ...pre, 4];
//output : [0,1,2,3,100,200,"hello",null, 4]
```

```javascript
function sum(a,b,c){
    return a+b+c;
}

let pre = [100,200,300];

sum.apply(null, pre); //spread operator 사용 전 방법

console.log(sum(...pre));
```

### 유사배열 (가짜배열)

```javascript

var array = [1,2,3];
var nodes = documents.querySelectorAll('div');
var els = document.body.children;

Array.isArray(array); // true
Array.inArray(nodes); // false
Array.inArray(els); //false

```
유사 배열은 배열도 객체라는 성질을 이용한 트릭이다. nodes[0],nodes[1],nodes.length 등 모두 활용이 가능하지만 배열의 메소드를 쓸 수 없다.

```javascript
els.forEach(function(el) { console.log(el); });
```

### from method

```javascript
function addMark(){
    let newData = [];
    // for(let i=0; i<arguments.length; i++){
    //     newData.push(argument[i] + "!");
    // }
    // console.log(newData);

    let newArray = Array.from(arguments); 
    arguments.map(function(value){
        return value + "!";
    });

    console.log(newData)
}
addMark(1,2,3,4,5);
```

from 으로 유사배열을 진짜배열로 변환이 가능하다.








### ref
[모던 자바스크립트-벨로퍼트] https://learnjs.vlpt.us/
[유사배열] https://www.zerocho.com/category/JavaScript/post/5af6f9e707d77a001bb579d2
