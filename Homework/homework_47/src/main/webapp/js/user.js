document.getElementById("changeUserData").addEventListener('click', allowChangeData);
document.getElementById("cancel").addEventListener('click', disallowChangeData);
document.getElementById("changePass").addEventListener('click', changePassword);

function allowChangeData(event) {
    event.preventDefault();
    document.getElementById("changeUserData").hidden = true;
    document.getElementById("save").hidden = false;
    document.getElementById("cancel").hidden = false;

    var inputs = document.getElementsByClassName('textButton');
    for(var i = 0; i < inputs.length; i++) {
        if (inputs[i].name === 'password') inputs[i].disabled = true;
        else inputs[i].disabled = false;
    }
}

function disallowChangeData(event) {
    event.preventDefault();
    document.getElementById("changeUserData").hidden = false;
    document.getElementById("save").hidden = true;
    document.getElementById("cancel").hidden = true;

    var inputs = document.getElementsByClassName('textButton');
    for(var i = 0; i < inputs.length; i++) {
            inputs[i].disabled = true;
    }
    document.getElementById('change-form').reset();
}

/*   function rememberForm(event){
    var fullName = (document.getElementById("fullName")).value;
    var email = (document.getElementById("email")).value;
    var password = (document.getElementById("password")).value;
    var age = (document.getElementById("age")).value;
    var phone = (document.getElementById("phone")).value;

    return [fullName, email, password, age, phone];
}*/

function changePassword(event) {
    event.preventDefault();
    if (document.getElementById("password").disabled == false) {
        document.getElementById("password").disabled = true;
    }
    else {document.getElementById("password").disabled = false;}
}


function sendUser() {
    let user = getFormData();

    var form = new FormData();
    form.append('login', user.login);
    form.append('email', user.email);
    form.append('age', user.age);
    //form.append('role', user.role);

    fetch("http://localhost:8080/login", {
        method: "POST",
        headers: {"Content-Type": "multipart/form-data;  charset=UTF-8"},
        body: form
    })
        .then(function(response) {
            console.log(response.headers.get('Content-Type'));
            console.log(response.headers.get('Date'));
            console.log(response.status);
            console.log(response.statusText);
            console.log(response.type);
            console.log(response.url);
        })
        .then(function (data) {
            console.log('Request succeeded with JSON response', data);
        })
        .catch(function (error) {
            console.log('Request failed', error);
        });
}

function getFormData() {
    let id = document.getElementById('id').value;
    let login = document.getElementById('login').value;
    let email = document.getElementById('email').value;
    let age = document.getElementById('age').value;
    //let roleSelect = document.getElementById('role');

    //let role = roleSelect.options[roleSelect.selectedIndex].text;
    //let gender = document.getElementById('gender').value;

    return {id, login, email, age};
}
        /*.then(function (response) {
            console.log(response);
        })
        .catch(alert);*/

/* fetch('/user/registration', {
 method: 'POST',
 headers: {'Content-Type':'application/x-www-form-urlencoded'},
 body: form
 })
 .then(function (response) {
 console.log(response);
 })
 .catch(alert);*/