
var Measurement = {};
var Utils = {};
Utils.Path = "";
var scoredmarks = '0', starttime = '0', label ='null', len = 0;

$(document).ready(function () {
    /* if(navigator.userAgent.match(/Android|BlackBerry|iPhone|iPad|iPod|Opera Mini|IEMobile/i))
		Utils.mobileDeviceFlag=true; */
    if((navigator.userAgent.match(/Android|BlackBerry|iPhone|iPad|iPod|Opera Mini|IEMobile/i)) && !(window.location.href.includes('http')))
        Utils.mobileDeviceFlag = true;
	else
        Utils.mobileDeviceFlag = false;

    setTimeout(function () {
        Measurement.init();
    });
}, 200);

Measurement.init = function () {
    $('#modalIcon').css('visibility', 'hidden');
    $("#gamepage").show();
    Measurement.setImages();
    Measurement.initVariables();
    Measurement.play();
    showQues();
}

Measurement.setImages = function()
{
    $("#Yes").text(Measurement.hardcodedData.yes);
    $("#No").text(Measurement.hardcodedData.no);
    $("#serveyorInstr").text(Measurement.hardcodedData.surveyorInstr);
}

Measurement.initVariables = function () 
{
    Measurement.randQue = 0;
    Measurement.attemptFlag = false;
	Measurement.currentGame = null;
    Measurement.clickedOptionData = null;
    Measurement.previousClickedOption = null;
    Measurement.imgArray = [];
}

function showQues(){
    $('#questioMark').hide();
    $('#myModal').css('display','block');
}
function hideQuestion(){
    $('#questioMark').show();
    $('#myModal').css('display','none');
}

Measurement.play = function()
{
    var langIndex = 3, randLang = '';
    $('#inputText').text('');

    //Utils.mobileDeviceFlag = true;
    if(Utils.mobileDeviceFlag){					//For mobile device.
		randLang = Android.getGameLang();
		//randLang = 'Urdu-Pakistan';
		var langIndex = Measurement.imageData.findIndex(obj => obj.language.toLowerCase().trim() == randLang.toLowerCase().trim());
        var gameCode = Android.getGameID();
        //var gameCode = 'M11C';
        Measurement.randQue = Measurement.imageData[langIndex].gameArray.findIndex(obj => obj.gameName == gameCode);
    }
    else{ 										//For browser.
        Measurement.randQue = Math.floor(Math.random() * Measurement.imageData[langIndex].gameArray.length);                                          //For browser
    }

    if(langIndex == 10 || randLang == 'Urdu-Pakistan'){
        $("#heading").css('direction', 'rtl');
    }

	//Measurement.randQue = 1;
    switch(Measurement.randQue){
        case 0:
        case 1:
        case 2:
        case 3:
        case 4:
            $("#heading").css('font-size', '1.8vw');   //P9A, P14A, P15A, P16A
            break;
    }
    if(Measurement.randQue != 4)
        $('#modalIcon').css('visibility', 'visible');
    else
        $('#resetDiv').css('visibility', 'visible');

	$("#ansText").text(Measurement.imageData[langIndex].ansText);
    $("#answerKeyText").text(Measurement.imageData[langIndex].ansText);
	Measurement.currentGame = Measurement.imageData[langIndex].gameArray[Measurement.randQue];
    document.title = Measurement.currentGame.gameName;   
    $('#queNo').text(Measurement.currentGame.gameName);
    document.getElementById("heading").innerHTML = Measurement.currentGame.questionText;
    $("#heading").css('font-weight', 'normal');
    $('.ans,#answerKeyText').text(Measurement.imageData[langIndex].ansText);
    
    d = new Date();
	starttime = d.getDate() + "-" + (d.getMonth() + 1) + "-" + d.getFullYear() + " " + d.getHours() + ":" + d.getMinutes() + ":" + d.getSeconds();
    //questionId = Measurement.currentGame.gameName;
    Measurement.imgArray = Measurement.currentGame.data;

    if(Measurement.imageData[langIndex].languageFont!=null)
        setFontFamilyForLang(Measurement.imageData[langIndex].languageFont);

    Measurement.showQuestion();
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

Measurement.showQuestion = function(index)      //Show Question Options.
{    
    for(i = 0; i < Measurement.imgArray.length; i++)
	{	
		div = document.createElement("div");
		document.getElementById("questionDiv").appendChild(div);
        div.setAttribute("id","queDiv"+(i+1));        
        if(Measurement.imgArray.length == 2){   
            
            if(Measurement.randQue == 4){        //For M12C question.
                $("#questionDiv").prop('class', 'nopadding col-sm-6 col-lg-6 col-md-6 col-xs-6 col-xs-offset-1 col-md-offset-1 col-lg-offset-1 col-sm-offset-1');
                div.setAttribute("class", "divBorder nopadding col-xs-5 col-sm-5 col-md-5 col-lg-5 col-xs-offset-1 col-md-offset-1 col-lg-offset-1 col-sm-offset-1");
            }   
            else{                                //For M12A question.
                //len = Measurement.currentGame.answer.length;
                len = 3;
                if(i == 0)
                   // $("#answerKeyText").append(Measurement.currentGame.answer);
                $("#questionDiv").prop('class', 'nopadding col-sm-8 col-lg-8 col-md-8 col-xs-8 col-xs-offset-2 col-md-offset-2 col-lg-offset-2 col-sm-offset-2');
                div.setAttribute("class", "nopadding col-xs-7 col-sm-7 col-md-7 col-lg-7 col-xs-offset-3 col-md-offset-3 col-lg-offset-3 col-sm-offset-3");
                $("#questionDiv").css('position', 'fixed');
                $("#questionDiv").css('bottom', '15vh');
            }  
        }
        else{                                   //For M11B, M11C, M12B questions.
            //len = Measurement.currentGame.data[i].answer.length;
            len = 3;
            //$("#answerKeyText").append(Measurement.currentGame.data[i].answer);
            $("#questionDiv").prop('class', 'nopadding col-sm-8 col-lg-8 col-md-8 col-xs-8 col-xs-offset-2 col-md-offset-2 col-lg-offset-2 col-sm-offset-2');
            div.setAttribute("class", "leftCss divBorder nopadding col-xs-10 col-sm-10 col-md-10 col-lg-10 col-xs-offset-1 col-md-offset-1 col-lg-offset-1 col-sm-offset-1");
        }
        
        if(Measurement.randQue == 4){           //For M12C question.
            div.setAttribute('onclick','Measurement.selectQueDiv(this.id)');
			$("#questionDiv").prop('class', 'nopadding col-sm-6 col-lg-6 col-md-6 col-xs-6 col-xs-offset-3 col-md-offset-3 col-lg-offset-3 col-sm-offset-3');
           // $("#queDiv"+(i+1)).css("box-shadow", "3px 3px 3px 3px");
            $("#queDiv"+(i+1)).css("border", "1px solid black");
            $("#srveInstr").hide();
            $("#ansLine").hide();
        }

        image = document.createElement("img");
        document.getElementById("queDiv"+(i+1)).appendChild(image);
        image.setAttribute("id","queImage"+(i+1));
        image.setAttribute("class","imgCss img-responsive nopadding col-xs-12 col-sm-12 col-md-12 col-lg-12"); 
        image.src = Utils.Path + "images/" + Measurement.imgArray[i].ansImg + ".png";
        $('#answerKeyText').append(' '+Measurement.imgArray[i].answer);
        
		$("#inputText").data('answer',Measurement.imgArray[i].answer);			//For M11B, M11C, M12A, M12B
		$("#queDiv"+(i+1)).data('answer',Measurement.imgArray[i].answer);		//For M12C
        $("#queDiv"+(i+1)).data('ansData',Measurement.imgArray[i].ansData);		//For M12C
        $("#queDiv"+(i+1)).data('ansImg',Measurement.imgArray[i].ansImg); 		//For M12C
    }    
}

Measurement.selectQueDiv = function(queDivClickId)
{
    //Measurement.attemptFlag = true;
    if(Measurement.randQue == 4)
        $("#"+ Measurement.previousClickedOption).css('border', '1px solid black');
    else
        $("#"+ Measurement.previousClickedOption).css('border', '');
    $("#"+ queDivClickId).css('border', '6px solid rgb(255, 190, 0)');
    Measurement.previousClickedOption = queDivClickId;
    Measurement.clickedOptionData = $("#"+ queDivClickId).data('answer');
    //console.log(Measurement.clickedOptionData);
    label = $("#"+ queDivClickId).data('ansData'); 
}

Measurement.nextQue=function()
{
	if(clickOption == '')
		showModal();
	else{
		scoredmarks = clickOption;
		console.log(scoredmarks, starttime, label);
        if (Utils.mobileDeviceFlag)
            Android.gotoNextGame(scoredmarks, starttime, label);
	}
}

/* Measurement.nextQue = function()
{     
    ans = $("#inputText").text(); 
    if(Measurement.clickedOptionData != null || ans != ''){            //To give ans compulsarily
        if(Measurement.randQue == 4){     //for M12C
            if(label.length == 0){
                label = "null";
                scoredmarks = '0';
            }
            else{
                if(Measurement.clickedOptionData == 'Correct')     
                    scoredmarks = '2';
                else
                    scoredmarks = '1';
            }
        }
        else{           
            label = $("#inputText").text();    //for M11B, M11C, M12A, M12B
            if(label.length == 0){
                label = "null";
                scoredmarks = '0';
            }
            else{              
                correctAns = $("#inputText").data('answer');	//for M12A
                if(label == correctAns)      
                    scoredmarks = '2';
                else
                    scoredmarks = '1';
            }
        }
        console.log(scoredmarks, starttime, label);
        if (Utils.mobileDeviceFlag)
            Android.gotoNextGame(scoredmarks, starttime, label);
        //alert("ScoredMarks = " + scoredmarks +","+" "+"Label = " +label);
    }
    else
        showModal();
} */

Measurement.reset = function()
{    
    $("#"+ Measurement.previousClickedOption).css('border', '1px solid black');
    label = '';
    scoredmarks = '0';
    //Measurement.attemptFlag = false;
    Measurement.clickedOptionData = null;
    Measurement.previousClickedOption = null;
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
