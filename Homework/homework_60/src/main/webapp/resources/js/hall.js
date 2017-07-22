// document.getElementById("create-hall").addEventListener('click', createHall);
/*document.getElementById("add-seats").addEventListener('click', createSeats);*/

function createHall() {

    document.getElementById("add-hall").setAttribute('hidden', '');
    document.getElementById("add-rows").removeAttribute('hidden');
    let quantityRows = document.getElementById("quantity-rows").value;
    let hallName = document.getElementById("hall-name").value;
    let inputRows = [];
    let paragraf, span, button;

    for(let i = 0; i < quantityRows; i++){
        paragraf = document.createElement('p');
        document.getElementById("add-rows").appendChild(paragraf);
        span = document.createElement('span');
        span.innerHTML = 'Row ' + (i+1) + ' - quantity seats:  ';
        paragraf.appendChild(span);
        inputRows[i] = document.createElement('input');
        inputRows[i].setAttribute('type', 'number');
        inputRows[i].setAttribute('required', '');
        inputRows[i].setAttribute('maxlength', '2');
        inputRows[i].setAttribute('min', '1');
        inputRows[i].setAttribute('max', '99');
        inputRows[i].value = 5;
        paragraf.appendChild(inputRows[i]);
    }
    button = document.createElement('button');
    paragraf = document.createElement('p');
    document.getElementById("add-rows").appendChild(paragraf);
    paragraf.appendChild(button);
    button.setAttribute('id', 'add-seats');
    button.setAttribute('onclick', 'createSeats()');
    button.innerHTML = 'CREATE';

    return false;
}

function createSeats() {

    let quantityRows = document.getElementById("quantity-rows").value;
    let hallName = document.getElementById("hall-name").value;
    let rows = document.getElementById("add-rows");
    let inputsSeats = rows.getElementsByTagName("input");
    let numberSeat, numberRow;
    let seat = {numberSeat};
    let arrSeats = [seat];
    let row = {numberRow, arrSeats};
    let arrRows = [row];
    let hall = {hallName, arrRows};
    for(let i = 0; i < quantityRows; i++) {
        arrRows[i].numberRow = i+1;
        for(let j = 0; j < inputsSeats[i].value; j++) {
            arrSeats[j].numberSeat = j+1;
            // hall.arrRows[i].numberRow
        }
        arrRows[i].arrSeats = arrSeats;
    }
}