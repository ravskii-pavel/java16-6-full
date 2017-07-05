document.getElementById("addUser").addEventListener('click', validateEmail);
document.getElementById("cancelAddUser").addEventListener('click', clearFormData);
document.getElementById("saveEditUser").addEventListener('click', saveEditUser);
document.getElementById("new-login").addEventListener("focus", resetLoginField);
document.getElementById("new-email").addEventListener("focus", resetEmailField);
document.getElementById("filterData").addEventListener("input", searchUsers, true);

function validateEmail(event){
    event.preventDefault();
    let email = document.getElementById("new-email");
    let emailText = email.value;
    if(emailText.length === 0 || emailText.includes(" ") || emailText.indexOf("@") === -1){
        email.classList.add('red-border');
    }
    else { validateLogin(event);}
}

function validateLogin(event){
    event.preventDefault();
    let login = document.getElementById("new-login");
    let loginText = login.value;
    if(loginText.length === 0 || loginText.includes(" ")){
        login.classList.add('red-border');
    }
    else {saveUser();}
}

function resetEmailField(){
    /*document.getElementById("email").style = "";*/
    document.getElementById("new-email").classList.remove('red-border');
}
function resetLoginField(){
    /*document.getElementById("email").style = "";*/
    document.getElementById("new-login").classList.remove('red-border');
}
function showAddForm(){
    document.getElementById('addUserForm').removeAttribute('hidden');
    document.getElementById('hideForm').removeAttribute('hidden');
    document.getElementById('showAddForm').setAttribute('hidden', true);
    document.getElementById('showFindForm').setAttribute('hidden', true);
    document.getElementById('addFindForm').setAttribute('hidden', true);

}

function showFindForm(){
    document.getElementById('addFindForm').removeAttribute('hidden');
    document.getElementById('hideForm').removeAttribute('hidden');
    document.getElementById('showAddForm').setAttribute('hidden', true);
    document.getElementById('showFindForm').setAttribute('hidden', true);
    document.getElementById('addUserForm').setAttribute('hidden', true);
    //document.getElementById('addFindForm').setAttribute('findEnable', '');
}

function hideForm(){
    document.getElementById('addUserForm').setAttribute('hidden', true);
    document.getElementById('addFindForm').setAttribute('hidden', true);
    document.getElementById('hideForm').setAttribute('hidden', true);
    document.getElementById('showAddForm').removeAttribute('hidden');
    document.getElementById('showFindForm').removeAttribute('hidden');
    //document.getElementById('addFindForm').removeAttribute('findEnable');
}

function searchUsers() {
    let userTableData = document.querySelector('[id="user-table"]');
    let trList = userTableData.querySelectorAll('tr');
    let find = document.getElementById("findUser");
    let filter = document.getElementById("filterData").value;
    let typeSearch;
    for (let j = 0; j < find.options.length; j++) {
        if (find.options[j].selected) {
            if(find.options[j].value.localeCompare("findByEmail") == 0){
                typeSearch = "email";
            }
            else typeSearch = "phone";
        }
    }
    for(let i = 0; i < trList.length; i++){
        let str = trList[i].querySelector('[id='+typeSearch+']').value;
        if(!(str.indexOf(filter)+1)) {  //indexOf() возвращает если не найдено -1, если найдено - позицию вхождения. В js 0==false, любое др. число даёт true;
            trList[i].setAttribute("hidden", true);
        }
        else{
            trList[i].removeAttribute("hidden");
        }
    }
}

function clearFormData() {
    let addForm = document.getElementById('addUserFormTable');
    let clearInputs = addForm.getElementsByTagName("input");
    for (let i = 0; i < clearInputs.length; i++){
        clearInputs[i].value="";
    }
}

function saveUser() {
    let login = document.getElementById('new-login').value;
    let fullName = document.getElementById('new-fullName').value;
    let email = document.getElementById('new-email').value;
    let age = document.getElementById('new-age').value;
    let phone= document.getElementById('new-phone').value;
    let password = document.getElementById('new-password').value;
    let gender;
    let genderCheck = document.getElementsByName('new-gender');
    for(let i = 0; i < genderCheck.length; i++) {
        if(genderCheck[i].checked) gender = genderCheck[i].value;
    }
    let roleSelect = document.getElementById('new-roleUser');
    let role = roleSelect.options[roleSelect.selectedIndex].value;
    let action = document.getElementById("addUser").name;
    let requestParams = "role=" + role + "&gender=" + gender + "&login=" + login +"&name=" + fullName + "&email=" + email +
        "&age=" + age + "&phone=" + phone + "&password=" + password + "&action=" + action;
    fetch('http://localhost:8080/adminpage', {
        method: 'POST',
        headers: {
            'Accept': 'application/json, application/xml, text/plain, text/html, *.*',
            'Content-Type': 'application/x-www-form-urlencoded; charset=utf-8'
        },
        body: requestParams
    }).catch(alert);
    clearFormData();
    setTimeout(reloadWindow, 200);
}

function editUser(data){
    if(document.querySelectorAll('tr[in-editing]').length === 0){
        let currentRow = data.parentNode.parentNode;
        currentRow.setAttribute('in-editing', '');
        enabledForm(currentRow);
    }
    else {
        cancelEditUser();
        let currentRow = data.parentNode.parentNode;
        currentRow.setAttribute('in-editing', '');
        enabledForm(currentRow);
    }
}

function saveEditUser(data) {
    let currentRow = data.parentNode.parentNode;
    let login = currentRow.querySelector('[id="login"]').value;
    let fullName = currentRow.querySelector('[id="name"]').value;
    let email = currentRow.querySelector('[id="email"]').value;
    let age = currentRow.querySelector('[id="age"]').value;
    let phone= currentRow.querySelector('[id="phone"]').value;
    let password = currentRow.querySelector('[id="password"]').value;
    let gender;
    let genderCheck = currentRow.querySelectorAll('[name="gender"]');
    for(let i = 0; i < genderCheck.length; i++) {
        if(genderCheck[i].checked) gender = genderCheck[i].value;
    }
    let roleSelect = currentRow.querySelector('[id="roleUser"]');
    let role = roleSelect.options[roleSelect.selectedIndex].value;
    let action = currentRow.querySelector('[id="saveEditUser"]').name;
    let requestParams = "role=" + role + "&gender=" + gender + "&login=" + login +"&name=" + fullName + "&email=" + email +
        "&age=" + age + "&phone=" + phone + "&password=" + password + "&action=" + action;
    fetch('http://localhost:8080/adminpage', {
        method: 'POST',
        headers: {
            'Accept': 'application/json, application/xml, text/plain, text/html, *.*',
            'Content-Type': 'application/x-www-form-urlencoded; charset=utf-8'
        },
        body: requestParams
    })
    .catch(alert);
    currentRow.setAttribute('save-enable', '');
    cancelEditUser();
}

function reloadWindow(){
    document.location.reload(true);
}

function cancelEditUser(){
    let editingRow = document.querySelector('tr[in-editing]');
    let allInputs = editingRow.querySelectorAll('input');
    let roleUser = editingRow.querySelector('[id="roleUserName"]').innerHTML;
    let roleSelect = editingRow.querySelector('[id="roleUser"]');
    if(document.querySelector('tr[save-enable]')) {
        for (let k = 0; k < allInputs.length; k++) {
            if ((allInputs[k].name).localeCompare("gender") != 0) {
                allInputs[k].defaultValue = allInputs[k].value;
                allInputs[k].value = allInputs[k].defaultValue;
                allInputs[k].classList.remove('border');
                allInputs[k].disabled = true;
            }
            else if ((allInputs[k].name).localeCompare("gender") === 0) {
                let gender;
                let genderCheck = editingRow.querySelectorAll('[name="gender"]');
                for (let i = 0; i < genderCheck.length; i++) {
                    if (genderCheck[i].checked) {
                        gender = genderCheck[i].value;
                    }
                }
                allInputs[k].removeAttribute('checked');
                editingRow.querySelector('[id="genderName"]').innerHTML = gender;
            }
        }
        for (let j = 0; j < roleSelect.options.length; j++) {
            if (roleSelect.options[j].selected) {
                editingRow.querySelector('[id="roleUserName"]').innerHTML = roleSelect.options[j].value;
                roleSelect.options[j].defaultValue = roleSelect.options[j].value;
            }
        }
    }
    else{
        for (let k = 0; k < allInputs.length; k++) {
            if ((allInputs[k].name).localeCompare("gender") === 0) {
                let genderCheck = editingRow.querySelectorAll('[name="gender"]');
                for (let i = 0; i < genderCheck.length; i++) {
                    genderCheck[i].removeAttribute('checked');
                }
            }
            else {
                allInputs[k].value = allInputs[k].defaultValue;
                allInputs[k].classList.remove('border');
                allInputs[k].disabled = true;
            }
        }
    }


    editingRow.removeAttribute('save-enable');
    editingRow.querySelector('[id="editUser"]').removeAttribute("hidden");
    editingRow.querySelector('[id="saveEditUser"]').setAttribute("hidden", true);
    editingRow.querySelector('[id="cancelEditUser"]').setAttribute("hidden", true);
    editingRow.querySelector('[id="gender"]').setAttribute("hidden", true);
    editingRow.querySelector('[id="genderName"]').removeAttribute("hidden");
    editingRow.querySelector('[id="roleUser"]').setAttribute("hidden", true);
    editingRow.querySelector('[id="roleUserName"]').removeAttribute("hidden");
    /*editingRow.querySelector('[id="roleUserName"]').innerHTML = ;*/
    editingRow.removeAttribute('in-editing');
    /*setTimeout(reloadWindow, 100);*/
}

function enabledForm(data){

    let checkedGenderName = data.querySelector('[id="genderName"]').innerText;
    let genderNames = data.querySelectorAll('[name="gender"]');
    for(let i = 0; i < genderNames.length; i++) {
        if(checkedGenderName === genderNames[i].value){ /*&& (genderNames[i].checked === false)*/
            genderNames[i].checked = true;
        }
    }
    data.querySelector('[id="genderName"]').setAttribute("hidden", true);
    data.querySelector('[id="gender"]').removeAttribute("hidden");

    let roleUser = data.querySelector('[id="roleUserName"]').innerText;
    let roleSelect = data.querySelector('[id="roleUser"]');
    for(let j = 0; j < roleSelect.options.length; j++){
        if (roleUser === roleSelect.options[j].value) {
            roleSelect.options[j].selected = true;
        }
    }

    let allInputs = data.querySelectorAll('input');
    for(let k = 0; k < allInputs.length; k++){
        if((allInputs[k].name).localeCompare("gender") != 0) {
            allInputs[k].classList.add('border');
            allInputs[k].disabled = false;
        }
    }
    data.querySelector('[id="roleUserName"]').setAttribute("hidden", true);
    data.querySelector('[id="roleUser"]').removeAttribute("hidden");
    data.querySelector('[id="editUser"]').setAttribute("hidden", true);
    data.querySelector('[id="saveEditUser"]').removeAttribute("hidden");
    data.querySelector('[id="cancelEditUser"]').removeAttribute("hidden");
}
function findUser(){

}

function saveDataTable(){

}

/*data.querySelector('[id="login"]').disabled = false;
 data.querySelector('[id="name"]').disabled = false;
 data.querySelector('[id="email"]').disabled = false;
 data.querySelector('[id="phone"]').disabled = false;
 data.querySelector('[id="age"]').disabled = false;
 data.querySelector('[id="password"]').disabled = false;*/

/*window.onload = function (){
 var k = document.getElementsByTagName("button");
 for(var i = 0; i < k.length; i++)
 k[i].onclick = function (){
 alert(this.innerHTML);
 }

 /*window.addEventListener("load", saveDataTable);*/
/*<body onload="myFunction()">
 window.onload = function() { Custom.init(); fillGrades(); }
 document.onload = function() { Custom.init(); fillGrades(); }
 }
 */

/*data.parentNode.parentNode.children[0]*/
/*let id = currentRow.querySelector('td[name="id"]').innerHTML;
 let login = currentRow.querySelector('td[name="login"]').innerHTML;
 let email = currentRow.querySelector('td[name="email"]').innerHTML;
 let age = currentRow.querySelector('td[name="age"]').innerHTML;
 let roleUser = currentRow.querySelector('td[name="roleUser"]').innerHTML;
 let gender = currentRow.querySelector('td[name="gender"]').innerHTML;

 document.getElementById('id').value = id;
 document.getElementById('login').value = login;
 document.getElementById('email').value = email;
 document.getElementById('age').value = age;
 document.getElementById('roleUser').value = roleUser;
 document.getElementById('gender').value = gender;

 let roleSelect = document.getElementById('roleUser').options;

 for(let i = roleSelect.length - 1; i >= 0; i--){
 let opt = roleSelect[i];
 if (roleUser === opt.innerHTML) {
 roleSelect[i].selected = true;
 }
 else{
 roleSelect[i].selected = false;
 }
 }*/
