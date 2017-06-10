/*document.getElementById("addUser").addEventListener('click', sendUser);*/

function showAddForm(){
    if(document.getElementById('addUserForm').hidden === true) {
        document.getElementById('addUserForm').removeAttribute('hidden');
        document.getElementById('hideForm').removeAttribute('hidden');
        document.getElementById('showForm').setAttribute('hidden', true);
    }
    else{
        document.getElementById('addUserForm').setAttribute('hidden', true);
        document.getElementById('hideForm').setAttribute('hidden', true);
        document.getElementById('showForm').removeAttribute('hidden');
    }
}