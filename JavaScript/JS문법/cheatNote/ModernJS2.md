### 간단한 객체생성하기

```javascript
const name = "crong"
const age = 33;

const obj ={
    name : name;
    age : age;
}

function getObj() {
    const name ="crong";
    const getName = function (){
        return name;
    }
    const setName = function(newName){
    name = newName;
    }
    const printName = function() {
        console.log(name);
    }
    // return {
    //     getName : getName,
    //     setName : setName
    //     }
    return {getName, setName, name}
    var obj = getObj();
    console.log(obj);
    console.log(obj.getName()); //crong
    }
```

### Destructuring Array (구조 분해 할당)

배열의 각 요소를 배열로부터 추출하여 변수 리스트에 할당. 이때 추출/할당 기준은 배열의 인덱스이다.

배열에서 필요한 요소만 추출하여 변수에 할당하고 싶은 경우에 유용하다.
ex) Date 객체서에서 년도, 월, 일을 추출하는 것

```javascript
let data = ["abc", "def", "ghi", "jkl"];
let [aa11,,bb22] = data;
console.log(aa11,,bb22); //output: "abc", "ghi"
```

### Destructuring Object

```javascript
let obj = {
    name : "crong",
    address : "Korea",
    age : 20
}

let {name, age} = obj;
console.log(name,age); //output : "crong", 10

let {name:myName, age:MyAge} = obj;
console.log(myName, myAge); //output : "crong" 10
```

### Destructuring 활용 JSON 파싱
 
### Destructuring 활용 Event 객체 전달

```javascript
document.querySelector("div").addEventListener("click", function({type}){
    console.log(target.innerText);
})
```

### Set 

중복없이 유일한 값을 저정하려고 할 때 사용, 이미 존재여부 체크할 때 유용
```javascript
let mySet = new Set();
console.log(toString.call(mySet)); //Set
```
```javascript
mySet.add("crong");

if(mySet.has("crong")); //존재 여부 확인

mySet.forEach(function(v){
    console.log(v);
})

mySet.delete("crong");
```

### WeakSet

참조를 가지고 있는 객체만 저장이 가능하다.
객체형태를 중복없이 저장하려고 할 때 유용하다.

```javascript
let arr = [1,2,3,4];
let arr2 = [5,6,7,8];
let obj = {arr, arr2};
let ws = new WeakSet()

ws.add(arr);
ws.add(arr2);
ws.add(obj);

//arr = null; 가비지컬렉션 대상이 된다.

console.log(ws);
```


### map & WeakMap

Array를 개선 -> Set,WeakSet
Object를 개선 -> map, WeakMap

map은 key/value 구조


```javascript
let wm = new WeakMap();
let myfun = function(){};//이 함수가 얼마나 실행됐지? 를 알려고 할 때.

wm.set(myfun,0);

console.log(wm); //WeakMap {f => 0}
console.log(wm.get(myfun)); // 0
myfun = null;
console.log(wm.has(myfun)); //false
```


### WeakMap 활용 (WeakMap 클래스 인스턴스 변수 보호하기)

인스턴스 관리를 용이하게 하기위해


```javascript

const wm = new WeakMap();//프라이빗한 변수를 클래스에서 만들어 쓸 때

function Area(height,width){
    // this.height = height;
    // this.width = width;
    wm.set(this, {height, width});
}

Area.prototype.getArea = function(){
    const {height, width} = wm.get(this);
    // return this.height = this.width;
    return height * width;   
}

let myarea = new Area(10,20);
console.log(myarea.getArea());

```


#### ref ..
[디스트럭처링] https://poiemaweb.com/es6-destructuring

