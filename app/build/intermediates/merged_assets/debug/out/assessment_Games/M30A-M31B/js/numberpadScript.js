function numberKey() {
    var row, i = 0, j = 0, buttonValue = 1;
    for (i = 1; i <= 4; i++) {
        var row = document.createElement("div");
        row.setAttribute("id", "row" + i);
        row.setAttribute("class", "nopadding col-sm-11 col-xs-11 col-md-11 col-lg-11");
        document.getElementById("keys").appendChild(row);
        for (j = 1; j <= 3; j++) {
            var button = document.createElement("button");
            button.setAttribute("id", "buttonId" + i + j);
            button.setAttribute("class", "nopadding buttonClass  col-sm-3 col-xs-3 col-md-3 col-lg-3 col-sm-offset-1 col-xs-offset-1 col-lg-offset-1 col-md-offset-1");
            row.appendChild(button);
            if (buttonValue < 10) {
                button.setAttribute("onclick", "displayNumber(this)");
                button.innerHTML = buttonValue;
                buttonValue++;
            }
            else {
                if (buttonValue == 10) {
                    buttonValue = 0;
                    button.setAttribute("onclick", "displayNumber(this)");
                }
                if (j == 2)
                    button.innerHTML = buttonValue;
                else if (j == 3) {
                    button.setAttribute("class", "nopadding buttonClass glyphicon glyphiColor glyphicon-erase col-sm-3 col-xs-3 col-md-3 col-lg-3 col-sm-offset-1 col-xs-offset-1 col-lg-offset-1 col-md-offset-1");
                    button.setAttribute("onclick", "clearText()");
                }
                else {
                    button.innerHTML = " ";
                    button.style.visibility = "hidden";
                }
                buttonValue = 10;
            }
        }
    }

}


