
function validateEmail(event){

    event.preventDefault();
    let email = document.getElementById("email");

    console.log(email.value);

    let emailText = email.value;

    console.log(emailText.indexOf("@") === -1);

/*    if(emailText.indexOf("@") === -1){
        email.style = "border-color: red";
    }*/if(emailText.indexOf("@") === -1){
     email.classList.add('red-border');
     }
    else {
        document.getElementById("registration-form").submit();
    }
}

document.getElementById("registerBtn").addEventListener('click', validateEmail);

document.getElementById("email").addEventListener("focus", resetEmailField);

function resetEmailField(){
    /*document.getElementById("email").style = "";*/
    document.getElementById("email").classList.remove('red-border');

}
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

function moveNext(){
    let navTab = document.getElementsByClassName("nav-tabs active")

    let navLi = navTab.getElementsByTagName("li")[0];

    navLi.getElementsByTagName("a")[0].fireEvent('onclick');
}
*/
