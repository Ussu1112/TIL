### Template 처리

UI개발에서 중요한 작업
json 으로 응답을 받고 , javascript object로 변환한 후에 데이터처리 조작을 한 후에 DOM에 추가한다.
데이터 + HTML문자열의 결합이 필요하기 때문에

```javascript
const data = [
    {
        name : 'coffee-bean',
        order : true,
        items : ['ammericano', 'milk', 'green-tea']
    },
    {
        name : 'starbucks',
        order : false,
    },
]
```

```javascript
const template = `<div>welcome ${data[0].name} !!`
console.log(template); //"<div>welcome coffee-bean!!"
```


### Tagged template literals

템플릿 조작을 위해 함수내에서 처리 후 사용

[바로가기] /TIL-Javascript-/JavaScript/JS문법/실습/Tagged_Template_literals.js


### Arrow function 활용

```javascript
let newArr = [1,2,3,4,5].map((v) => v * 2);
console.log(newArr);
```
