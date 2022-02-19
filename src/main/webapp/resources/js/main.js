let xVal, yVal, rVal;
function validateValues() {
    document.getElementById("messageArea").innerHTML = "";
    let message = "";
    let check = true;
    if (!validateX()) {
        check = false;
        message += "Y не задан\n";
    }
    if (!validateY()) {
        check = false;
        message += "Y - число в интервале [-5;3]\n";
    }
    if (!validateR()) {
        check = false;
        message += "Радиус не задан\n";
    }
    if (!check) document.getElementById("messageArea").innerHTML = message;
    return check;
}

function validateX() {
    xVal = document.getElementById("input_form:x_hidden").value;
    if (xVal === "") {
        return false;
    }
    return true;
}

function isNumeric(n) {
    return !isNaN(parseFloat(n)) && isFinite(n);
}

function validateY() {
    const Y_MIN = -5.0;
    const Y_MAX = 3.0;
    yVal = document.getElementById("input_form:y_input").value;
    let numY = yVal.replace(',', '.');
    if (isNumeric(numY) && numY >= Y_MIN && numY <= Y_MAX) {
        return true;
    }
    return false;
}

function validateR() {
    rVal = document.getElementById("input_form:r_hidden").value;
    if (rVal === "") {
        return false;
    }
    return true;
}