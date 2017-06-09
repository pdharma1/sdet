function processNumber() {

    var number = document.getElementsByName("userInputText")[0].value;
    console.log("You entered: " + number);

    if (validateNumber(number)) {
        displayMultiplicationTable(number);
    }
}

function validateNumber(number) {

    if (isNaN(number)) {
        return false;
    } else if (number <= 0) {
        return false;
    } else {
        return true;
    }
}

function displayMultiplicationTable(number) {

    var message = "";
    for (var i = 1; i <= 10; i++) {
        message = (number) + " * " + (i) + " = " + (number * i);
        console.log((number) + " * " + (i) + " = " + (number * i));
        var multiplytable = document.createElement("div");
        var multiplytableText = document.createTextNode(message);
        multiplytable.appendChild(multiplytableText);
        fieldSet = document.createElement("fieldset");
        fieldSet.appendChild(multiplytable);
        document.body.appendChild(fieldSet);
        message = "";
    }
}
