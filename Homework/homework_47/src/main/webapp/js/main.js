
function validateEmail(event){

    event.preventDefault();
    var email = document.getElementById("email");
    var emailText = email.value;

    if(emailText.length === 0 || emailText.includes(" ") || emailText.indexOf("@") === -1){
        email.classList.add('red-border');
     }
    else {
        validateLogin;
    }
}

function validateLogin(event){

    event.preventDefault();
    var login = document.getElementById("login");
    var loginText = login.value;

    if(loginText.length === 0 || loginText.includes(" ")){
        login.classList.add('red-border');
    }
    else {
        document.getElementsByTagName("form")[0].submit();
    }
}

function resetEmailField(){
    /*document.getElementById("email").style = "";*/
    document.getElementById("email").classList.remove('red-border');
}

function resetLoginField(){
    /*document.getElementById("email").style = "";*/
    document.getElementById("login").classList.remove('red-border');
}

document.getElementById("loginBtn").addEventListener('click', validateLogin);
document.getElementById("registrBtn").addEventListener('click', validateEmail);

document.getElementById("login").addEventListener("focus", resetLoginField);
document.getElementById("email").addEventListener("focus", resetEmailField);


/*document.getElementById('my-input-id').disabled = false;

var inputs = document.getElementsByTagName('');
for(var i = 0; i < inputs.length; i++) {
    inputs[i].disabled = false;
}*/

/*
$('.btnNext').click(function(){
    $('.nav-tabs > .active').next('li').find('a').trigger('click');
});

$('.btnPrevious').click(function(){
    $('.nav-tabs > .active').prev('li').find('a').trigger('click');
});
*/

/*JS*/

/*
let nextBtns = document.getElementsByClassName("btnNext");


for(var e in nextBtns){
    e.addEventListener('click', moveNext);
};

 //console.log(emailText.indexOf("@") === -1);

 /*    if(emailText.indexOf("@") === -1){
 email.style = "border-color: red";

function moveNext(){
    let navTab = document.getElementsByClassName("nav-tabs active")

    let navLi = navTab.getElementsByTagName("li")[0];

    navLi.getElementsByTagName("a")[0].fireEvent('onclick');
}
*/
