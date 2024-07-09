
var IdentifyNumber = {};
var Utils = {};
Utils.Path = "";
var scoredmarks = '0', starttime = '0', label ='';

$(document).ready(function () {
    /* if(navigator.userAgent.match(/Android|BlackBerry|iPhone|iPad|iPod|Opera Mini|IEMobile/i))
		Utils.mobileDeviceFlag=true; */
    if((navigator.userAgent.match(/Android|BlackBerry|iPhone|iPad|iPod|Opera Mini|IEMobile/i)) && !(window.location.href.includes('http')))
        Utils.mobileDeviceFlag = true;
	else
        Utils.mobileDeviceFlag = false;

    setTimeout(function () {
        IdentifyNumber.init();
    });
}, 200);

IdentifyNumber.init = function () {
    $("#gamePage").show();
    IdentifyNumber.initVariables();
    IdentifyNumber.play();
    showQues();
}

IdentifyNumber.initVariables = function () 
{
    IdentifyNumber.randQue = 0;
    IdentifyNumber.attemptFlag = false;
    IdentifyNumber.currentGame = null;
	IdentifyNumber.clickedOptionData = null;
    IdentifyNumber.previousClickedOption = null;
}

function showQues(){
    $('#questioMark').hide();
    $('#myModal').css('display','block');
}
function hideQuestion(){
    $('#questioMark').show();
    $('#myModal').css('display','none');
}

IdentifyNumber.play = function()
{
    var langIndex = 3, randLang = '';

    //Utils.mobileDeviceFlag = true;
    if(Utils.mobileDeviceFlag){					//For mobile device.
		randLang = Android.getGameLang();
		//randLang = 'Hindi-India';
		langIndex = IdentifyNumber.numberData.findIndex(obj => obj.language.toLowerCase().trim() == randLang.toLowerCase().trim());
        var gameCode = Android.getGameID();
        //var gameCode = 'N39B';
        IdentifyNumber.randQue = IdentifyNumber.numberData[langIndex].gameArray.findIndex(obj => obj.gameName == gameCode);
    }
    else{ 
        IdentifyNumber.randQue = Math.floor(Math.random() * IdentifyNumber.numberData[langIndex].gameArray.length);                                          //For browser
    }

    if(langIndex == 10 || randLang == 'Urdu-Pakistan'){
        $("#heading").css('direction', 'rtl');
    }

    //IdentifyNumber.randQue = 0;
    switch(IdentifyNumber.randQue){
        case 0:
        case 1:
            $("#heading").css('font-size', '1.8vw');   //P9A, P14A, P15A, P16A
            break;
    }
	IdentifyNumber.currentGame = IdentifyNumber.numberData[langIndex].gameArray[IdentifyNumber.randQue];
    document.title = IdentifyNumber.currentGame.gameName;   
    $('#queNo').text(IdentifyNumber.currentGame.gameName);
    document.getElementById("heading").innerHTML = IdentifyNumber.currentGame.questionText;
    $("#heading").css('font-weight', 'normal');

    d = new Date();
	starttime = d.getDate() + "-" + (d.getMonth() + 1) + "-" + d.getFullYear() + " " + d.getHours() + ":" + d.getMinutes() + ":" + d.getSeconds();
    //questionId = IdentifyNumber.currentGame.gameName;

    if(IdentifyNumber.numberData[langIndex].languageFont!=null)
        setFontFamilyForLang(IdentifyNumber.numberData[langIndex].languageFont);

    IdentifyNumber.showQuestion();
}

setFontFamilyForLang = function (fontFilePath) {
    var newStyle = "<style>" +
        "@font-face { " +
        "font-family: 'CustomFontFamily';" +
        "src: url('" + fontFilePath + "') format('truetype');" +
        "} </style>";
    $("head").append(newStyle);
    $("body").css("font-family", "CustomFontFamily");
}

IdentifyNumber.showQuestion = function(index)      //Show Question and Answer.
{
    var optionArray = [];
    document.getElementById("queImg").src = Utils.Path + "images/" + IdentifyNumber.currentGame.queImg + ".png";
    optionArray = IdentifyNumber.currentGame.numberArray;
    shuffle(optionArray);
    //console.log(optionArray);
    for(i = 0; i < optionArray.length; i++)
	{	
		div = document.createElement("div");
		document.getElementById("ansOptionDiv").appendChild(div);
        div.setAttribute("id","ansDiv"+(i+1));
        div.setAttribute('onclick','IdentifyNumber.selectOption(this.id)')
        div.setAttribute("class","divBorder numberCss nopadding col-xs-2 col-sm-2 col-md-2 col-lg-2 col-xs-offset-1 col-md-offset-1 col-lg-offset-1 col-sm-offset-1");
        $("#ansDiv"+(i+1)).text(optionArray[i]);
    }    
}

IdentifyNumber.selectOption = function(optionId)
{
    IdentifyNumber.attemptFlag = true;
    $("#"+ IdentifyNumber.previousClickedOption).css('border', '2px solid black');
    IdentifyNumber.clickedOptionData = $("#"+ optionId).text();
    //console.log(IdentifyNumber.clickedOptionData);
    $("#"+ optionId).css('border', '6px solid rgb(255, 190, 0)');
    IdentifyNumber.previousClickedOption = optionId;
}

IdentifyNumber.nextQue = function()
{     
    if(IdentifyNumber.attemptFlag == false){
        label = "null";
        scoredmarks = '0';
    }
    else{
        label = IdentifyNumber.clickedOptionData;
        if(IdentifyNumber.clickedOptionData == IdentifyNumber.currentGame.corectAns){     
            //console.log('Correct');
            scoredmarks = '2';
        }
        else{                                                   
            //console.log('Wrong');
            scoredmarks = '1';
        }
    }
    console.log(scoredmarks, starttime, label);
	if (Utils.mobileDeviceFlag)
        Android.gotoNextGame(scoredmarks, starttime, label);
}

IdentifyNumber.reset = function()
{
    $("#"+ IdentifyNumber.previousClickedOption).css('border', '2px solid black');
    label = '';
    scoredmarks = '0';
    IdentifyNumber.attemptFlag = false;
    IdentifyNumber.clickedOptionData = null;
    IdentifyNumber.previousClickedOption = null;
}

function shuffle(randomArray) {
    var arrayLength = randomArray.length;
    var temp, random_index;
    while (arrayLength > 0) {
        random_index = Math.floor(Math.random() * arrayLength);
        arrayLength--;
        temp = randomArray[arrayLength];
        randomArray[arrayLength] = randomArray[random_index];
        randomArray[random_index] = temp;
    }
    return (randomArray);
}
