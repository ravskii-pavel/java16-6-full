console.log	("	Hello from JS");
console.log(`	Hello from JS`);
console.log('	Hello from JS');

function fireClick() {
	console.log("fire!!!");

	let log = document.getElementById('login');
	login.value = "Bob";
}

let btn = document.getElementById("btn");
btn.addEventListener("click", fireClick);