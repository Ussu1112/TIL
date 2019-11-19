const a = '123';
console.log(a.padStart(5,'0'));
console.log(a.padEnd(10,'2'));

const b = '11110000';
const change1 = /1/gi;
const change2 = /0/gi;
console.log(b.replace(change1,'#').replace(change2,' '));

var aa = 2;
var bb = 16;
var cc = aa | bb;
console.log(cc);