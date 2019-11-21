function print() {
    let arr = document.querySelectorAll("li"); //html의 li태그 값 다 가져오기
    console.log(toString.call(arr));
    let listArray = Array.from(arr); //li nodes로 구성된 배열
    console.log(typeof listArray) //listArray 타입 확인
    let EinArray = listArray.filter(function (v) {
        return v.innerText.includes("e");
    });
    console.log(EinArray.length);
}

print();