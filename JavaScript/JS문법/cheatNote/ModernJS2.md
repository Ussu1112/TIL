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



#### ref ..
[디스트럭처링] https://poiemaweb.com/es6-destructuring

