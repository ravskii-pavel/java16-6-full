document.getElementById("changeUserData").addEventListener('click', allowChangeData);
document.getElementById("cancel").addEventListener('click', disallowChangeData);
document.getElementById("changePass").addEventListener('click', changePassword);
document.getElementById("save").addEventListener('click', sendUser);

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

function changePassword(event) {
    event.preventDefault();
    if (document.getElementById("password").disabled == false) {
        document.getElementById("password").disabled = true;
    }
    else {document.getElementById("password").disabled = false;}
}

function sendUser() {
    //var user = getFormData();
    //let requestParams = `login=${user.login}&name=${user.fullName}&email=${user.email}&age=${user.age}&phone=${user.phone}&password=${user.password}`;

    var login = document.getElementById('login').value;
    var fullName = document.getElementById('name').value;
    var email = document.getElementById('email').value;
    var age = document.getElementById('age').value;
    var phone= document.getElementById('phone').value;
    var password = document.getElementById('password').value;
    var requestParams = "login=" + login +"&name=" + fullName + "&email=" + email +
        "&age=" + age + "&phone=" + phone + "&password=" + password;
    /*var headers = new Headers({
        'Content-Type':'application/x-www-form-urlencoded'
        // 'Access-Control-Allow-Origin': '*'
    });*/

    fetch('http://localhost:8080/userpage', {
        method: 'POST',
        headers: {
            'Accept': 'application/json, application/xml, text/plain, text/html, *.*',
            'Content-Type': 'application/x-www-form-urlencoded; charset=utf-8'
        },
        body: requestParams
    }).catch(alert);

    /*
        .then(function (response) {
            console.log(response);
        })*/

}

function getFormData() {
    var login = document.getElementById('login').value;
    var fullName = document.getElementById('name').value;
    var phone = document.getElementById('phone').value;
    var email = document.getElementById('email').value;
    var age = document.getElementById('age').value;
    var password = document.getElementById('password').value;
    //let roleSelect = document.getElementById('role');
    //let role = roleSelect.options[roleSelect.selectedIndex].text;
    //let gender = document.getElementById('gender').value;
    return {login, fullName, phone,  email, age, password};
}

/* fetch('/user/registration', {
 method: 'POST',
 headers: {'Content-Type':'application/x-www-form-urlencoded'},
 body: form
 })
 .then(function (response) {
 console.log(response);
 })
 var form = new FormData();
 form.append('login', user.login);
 form.append('email', user.email);
 form.append('age', user.age);
 .catch(alert);*/