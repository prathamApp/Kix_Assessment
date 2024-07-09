
var identifyPattern = {};
var Utils = {};
Utils.Path = "";
var starttime = '0', scoredmarks = '0', label ='';

$(document).ready(function () {
    /* if(navigator.userAgent.match(/Android|BlackBerry|iPhone|iPad|iPod|Opera Mini|IEMobile/i))
		Utils.mobileDeviceFlag=true; */
    if((navigator.userAgent.match(/Android|BlackBerry|iPhone|iPad|iPod|Opera Mini|IEMobile/i)) && !(window.location.href.includes('http')))
        Utils.mobileDeviceFlag = true;
	else
        Utils.mobileDeviceFlag=false;

    setTimeout(function () {
        identifyPattern.init();
    });
}, 200);

identifyPattern.init = function () {
    $("#gamePage").show();
    identifyPattern.initVariables();
    identifyPattern.play();
    showQues();
}

identifyPattern.initVariables = function () 
{
    identifyPattern.randQue = 0;
    identifyPattern.attemptFlag = false;
	identifyPattern.currentGame = null;
    identifyPattern.clickedOptionData = null;
    identifyPattern.previousClickedOption = null;
}

function showQues(){
    $('#questioMark').hide();
    $('#myModal').css('display','block');
}
function hideQuestion(){
    $('#questioMark').show();
    $('#myModal').css('display','none');
}

identifyPattern.play = function()
{
	var langIndex = 8, randLang = '';
    //Utils.mobileDeviceFlag = true;
    if(Utils.mobileDeviceFlag){					//For mobile device.
		randLang = Android.getGameLang();
		//randLang = 'Bangla-Bangladesh';
		langIndex = identifyPattern.patternData.findIndex(obj => obj.language.toLowerCase().trim()  == randLang.toLowerCase().trim() );
        var gameCode = Android.getGameID();
        //var gameCode = "L7E.5";
        var gameCodeArray = gameCode.split(".");
        var langRandQue = identifyPattern.patternData[langIndex].gameArray.findIndex(obj => obj.gameName == gameCodeArray[0]);

        identifyPattern.randQue = identifyPattern.patternData[langIndex].gameArray[langRandQue].langGameArray.findIndex(obj => obj.langGameName == gameCode);
    }
    else{ 
        var langRandQue = Math.floor(Math.random() * identifyPattern.patternData[langIndex].gameArray.length);
        //langRandQue = 0;
        identifyPattern.randQue = Math.floor(Math.random() * identifyPattern.patternData[langIndex].gameArray[langRandQue].langGameArray.length);        //For browser
        //identifyPattern.randQue = 4;
    } 

    if(langIndex == 10 || randLang == 'Urdu-Pakistan'){
        $("#heading").css('direction', 'rtl');
    }

    $("#heading").css('font-size', identifyPattern.patternData[langIndex].gameArray[langRandQue].fontSize);               
	identifyPattern.currentGame = identifyPattern.patternData[langIndex].gameArray[langRandQue].langGameArray[identifyPattern.randQue];
    document.title = identifyPattern.currentGame.langGameName;   
    $('#queNo').text(identifyPattern.currentGame.langGameName);
    if(langRandQue == 0)
        document.getElementById("heading").innerHTML = identifyPattern.currentGame.questionText;
    else{
        document.getElementById("heading").innerHTML = identifyPattern.patternData[langIndex].gameArray[langRandQue].questionText;
        document.getElementById("questionDiv").innerHTML = identifyPattern.patternData[langIndex].gameArray[langRandQue].langGameArray[identifyPattern.randQue].queText;
    }
    $("#heading").css('font-weight', 'normal');
    
    d = new Date();
	starttime = d.getDate() + "-" + (d.getMonth() + 1) + "-" + d.getFullYear() + " " + d.getHours() + ":" + d.getMinutes() + ":" + d.getSeconds();
    questionId = identifyPattern.currentGame.langGameName;

    if(identifyPattern.patternData[langIndex].languageFont!=null)
        setFontFamilyForLang(identifyPattern.patternData[langIndex].languageFont);

    identifyPattern.showQuestion();
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

identifyPattern.showQuestion = function(index)      //Show Question and Answer.
{
    var optionArray = [];

    if(identifyPattern.currentGame.queText == null)
        document.getElementById("questionDiv").innerHTML = identifyPattern.currentGame.queText;
    else
        $('#ansOptionDiv').css('margin-top', '20vh');
    optionArray = identifyPattern.currentGame.data;
    shuffle(optionArray);
    //console.log(optionArray);
    for(i = 0; i < optionArray.length; i++)
	{	
		div = document.createElement("div");
		document.getElementById("ansOptionDiv").appendChild(div);
        div.setAttribute("id","ansDiv"+(i+1));
        div.setAttribute('onclick','identifyPattern.selectOption(this.id)')
        div.setAttribute("class","divBorder nopadding col-xs-2 col-sm-2 col-md-2 col-lg-2 col-xs-offset-1 col-md-offset-1 col-lg-offset-1 col-sm-offset-1");

        image = document.createElement("img");
        document.getElementById("ansDiv"+(i+1)).appendChild(image);
        image.setAttribute("id","ansImage"+(i+1));
        image.setAttribute("class","img-responsive nopadding imgcss col-xs-12 col-sm-12 col-md-12 col-lg-12"); 
        image.src = Utils.Path + "images/" + optionArray[i].ansImg + ".png";
        
        $("#ansDiv"+(i+1)).data('ans',optionArray[i].answer);
        $("#ansDiv"+(i+1)).data('ansImg',optionArray[i].ansImg);
        //$("#ansDiv"+(i+1)).data('ansData',optionArray[i].ansData);
        
        let onlyAnsImgArr = optionArray[i].ansImg.split('/');
        let onlyAnsImg = onlyAnsImgArr[onlyAnsImgArr.length - 1];
        $("#ansDiv"+(i+1)).data('ansData',onlyAnsImg + '.png');
    }    
}

identifyPattern.selectOption = function(optionId)
{
    identifyPattern.attemptFlag = true;
    $("#"+ identifyPattern.previousClickedOption).children('img').css('border-radius', '2vh');
    $("#"+ identifyPattern.previousClickedOption).css('border', '1px solid black');
    identifyPattern.clickedOptionData = $("#"+ optionId).data('ans');
    //console.log(identifyPattern.clickedOptionData);   
    label = $("#"+ optionId).data('ansData'); 
    $("#"+ optionId).children('img').css('border-radius', '0vh');
    $("#"+ optionId).css('border', '10px solid rgb(255, 190, 0)');
    identifyPattern.previousClickedOption = optionId;
}

identifyPattern.nextQue = function()
{    
    if(identifyPattern.attemptFlag == false){
        label = "null";
        scoredmarks = '0';
    }
    else{ 
        if(identifyPattern.clickedOptionData == 'Correct'){     
            //console.log('Correct');
            scoredmarks = '2';
        }
        else{                                                   
            //console.log('Wrong');
            scoredmarks = '1';
        }
    }
    /* $("#footer").css("pointer-events", "none");
    $("#nextDiv").css("pointer-events", "none");
    $("#resetDiv").css("pointer-events", "none");
    $("#ansOptionDiv").css("pointer-events", "none"); */
    console.log(scoredmarks, starttime, label);
	if (Utils.mobileDeviceFlag)
        Android.gotoNextGame(scoredmarks, starttime, label);
        
    //alert("ScoredMarks = " + scoredmarks +","+" "+"Label = " +label);
}

identifyPattern.reset = function()
{
    $("#"+ identifyPattern.previousClickedOption).css('border', '1px solid black');
    label = 'null';
    scoredmarks = 0;
    identifyPattern.attemptFlag = false;
    identifyPattern.clickedOptionData = null;
    identifyPattern.previousClickedOption = null;
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
