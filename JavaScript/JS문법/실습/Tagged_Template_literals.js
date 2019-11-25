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
    {
        name : 'coffee-king',
        order : true,
        items : ['ammericano', 'latte']
    },
]

function fn(tags, name, items){
    if(items === 'undefined'){
        items = "주문가능한 상품이 없습니다";
    }
    return (tags[0] + name + tags[1] + items + tags[2]);
}
data.forEach((v) => {
    let template = `<div>welcome ${v.name} !!</div>
    <h2>주문가능항목</h2><div>${v.items}</div>`;
    console.log(template);
});