var name = 'abcdedede';
var name1 = 'ddeeff';
var pattern = /abc?/;

console.log(pattern.test(name));
console.log(pattern.test(name1));

var text = "Wow";
var text1 = "WooWoo";
var pattern1 = /Wo+w/;

console.log(pattern1.test(text)); //true
console.log(pattern1.test(text1)); //false

var aab = "1s#2s*3d*4t";
var pattern2 = "(?:([0-9]+)([SDT])([*#]?))";
console.log(pattern2.test(aab));
