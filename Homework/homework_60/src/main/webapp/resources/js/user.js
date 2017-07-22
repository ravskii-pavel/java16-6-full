document.getElementById("changeUserData").addEventListener('click', allowChangeData);
document.getElementById("changePass").addEventListener('click', changePassword);
document.getElementById("save").addEventListener('click', sendUser);
/*document.getElementById("cancel").addEventListener('click', disallowChangeData);*/

function allowChangeData(event) {
    event.preventDefault();
    document.getElementById("changeUserData").hidden = true;
    document.getElementById("save").hidden = false;
    document.getElementById("changePass").hidden = true;
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
    document.getElementById("changePass").hidden = false;
    document.getElementById("save").hidden = true;
    document.getElementById("cancel").hidden = true;

    var inputs = document.getElementsByClassName('textButton');
    for(var i = 0; i < inputs.length; i++) {
            inputs[i].disabled = true;
    }
    //document.getElementById('change-form').reset();
    document.getElementById('change-form').update();
}

function changePassword(event) {
    event.preventDefault();
        document.getElementById("changePass").hidden = true;
        document.getElementById("changeUserData").hidden = true;
        document.getElementById("password").disabled = false;
        document.getElementById("save").hidden = false;
        document.getElementById("cancel").hidden = false;
}

function sendUser() {

    var id = document.getElementById('id').innerText;
    var login = document.getElementById('login').value;
    var fullName = document.getElementById('name').value;
    var email = document.getElementById('email').value;
    var age = document.getElementById('age').value;
    var phone= document.getElementById('phone').value;
    var password = document.getElementById('password').value;
    var requestParams = "id=" + id + "&login=" + login +"&name=" + fullName + "&email=" + email +
        "&age=" + age + "&phone=" + phone + "&password=" + password;

    fetch('http://localhost:8080/userpage', {
        method: 'POST',
        headers: {
            'Accept': 'application/json, application/xml, text/plain, text/html, *.*',
            'Content-Type': 'application/x-www-form-urlencoded; charset=utf-8'
        },
        body: requestParams
    }).catch(alert);

    document.getElementById('id').innerText = id;
    document.getElementById('login').value = login;
    document.getElementById('name').value = fullName;
    document.getElementById('phone').value = phone;
    document.getElementById('email').value = email;
    document.getElementById('age').value = age;
    document.getElementById('password').value = password;
    disallowChangeData(event);

   /* var inputs = document.getElementsByTagName('input');
    inputs[0].value =

    for(var i = 0; i < inputs.length; i++) {
        inputs[i].disabled = true;
    }*/
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
//var user = getFormData();
//let requestParams = `login=${user.login}&name=${user.fullName}&email=${user.email}&age=${user.age}&phone=${user.phone}&password=${user.password}`;