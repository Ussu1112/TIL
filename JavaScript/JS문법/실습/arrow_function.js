// setTimeout(function() {
//     console.log('settimeout');
// }, 1000);

// let newArr = [1,2,3,4,5].map(function(value, index, object){
//     return value * 2;
// }); 
 
let newArr = [1,2,3,4,5].map((v) => v * 2);
console.log(newArr);

const myObj = {
    runTimeout(){
        setTimeout(() => {
            this.printData();
        }, 200);
    },

    printData(){
        console.log("hi ")
    }
}
myObj.runTimeout();



