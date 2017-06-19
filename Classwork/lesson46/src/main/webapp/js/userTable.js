function fillTable(userList) {
  var userTable = document.getElementById("user-table");

  clearTable(userTable);

  userList.forEach(function (user) {
    var row = userTable.insertRow();

    var id = row.insertCell(0);
    var login = row.insertCell(1);
    var email = row.insertCell(2);
    var firstName = row.insertCell(3);
    var lastName = row.insertCell(4);
    var age = row.insertCell(5);
    var address = row.insertCell(6);

    id.innerHTML = user.id;
    login.innerHTML = user.login;
    email.innerHTML = user.email;
    firstName.innerHTML = user.userDetails.firstName;
    lastName.innerHTML = user.userDetails.lastName;
    age.innerHTML = user.userDetails.age;
    address.innerHTML = user.address.country + ", " + user.address.city + ", " + user.address.street + ", " + user.address.houseNumber;
  });
}

function clearTable(table) {
  table.innerHTML = '';
}


function search() {
  var  query = document.getElementById("user-search").value;

  // var data = new FormData();
  // data.append( "json", JSON.stringify( query ) );

  fetch('/search', {
    method: 'POST',
    headers: {'Content-Type':'application/x-www-form-urlencoded'},
    body: 'query=' + query
  })
    .then(function (response) {
      return response.json();
    })
    .then(function (userList) {
      fillTable(userList);
    })
    .catch(alert);
}