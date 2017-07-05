//document.getElementById("new-login").addEventListener('click', validateEmail);
function validateEmail(event){

    event.preventDefault();
    var email = document.getElementById("new-email");
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
    var login = document.getElementById("new-login");
    var loginText = login.value;

    if(loginText.length === 0 || loginText.includes(" ")){
        login.classList.add('red-border');
    }
    else {
        sendUser;
        /*document.getElementsByTagName("form")[0].submit();*/
    }
}

function resetEmailField(){
    /*document.getElementById("email").style = "";*/
    document.getElementById("new-email").classList.remove('red-border');
}

function resetLoginField(){
    /*document.getElementById("email").style = "";*/
    document.getElementById("new-login").classList.remove('red-border');
}

document.getElementById("loginBtn").addEventListener('click', validateLogin);
document.getElementById("registrBtn").addEventListener('click', validateEmail);

document.getElementById("new-login").addEventListener("focus", resetLoginField);
document.getElementById("new-email").addEventListener("focus", resetEmailField);


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
