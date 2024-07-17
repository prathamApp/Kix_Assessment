var L9A_L9B ={};
Utils={};
Utils.Path = " ";
Utils.mobileDeviceFlag;
var startTime = "0", scoredMarks = "0", label = "null",scoreFlag = false,gameFlag = false;
L9A_L9B.currentques = 0 , L9A_L9B.optionArr=[],L9A_L9B.currentLang = 1;
$(document).ready(function () {
   document.title = L9A_L9B.hardcoded.title;
       if ((navigator.userAgent.match(/Android|BlackBerry|iPhone|iPad|iPod|Opera Mini|IEMobile/i))&& !(window.location.href.includes('http')))
           Utils.mobileDeviceFlag = true;
           L9A_L9B.calculation();
           L9A_L9B.showQues();
   });

   L9A_L9B.showQues = function(){
    $('#questioMark').hide();
    $('#myModal').css('display','block');
}
L9A_L9B.hideQuestion = function(){
    $('#questioMark').show();
    $('#myModal').css('display','none');
}

L9A_L9B.calculation = function()
{
	/* if (Utils.mobileDeviceFlag) {
        var val = "Spanish-Mexico";//Android.getGameLang();		//GET ANDROID GAME LANGUAGE
        var lang = L9A_L9B.gameNameArr.find(checkIndex);
        L9A_L9B.currentLang = L9A_L9B.gameNameArr.indexOf(lang);
		
        function checkIndex(i) {
            if (i.language.toLowerCase() == val.toLowerCase())
                return i;
       }
	    var val=1;//Android.getGameID();		//GET GAME CODE
		var data=L9A_L9B.gameNameArr[L9A_L9B.currentLang ].gameData.find(checkIndex1);
		L9A_L9B.currentques=L9A_L9B.gameNameArr[L9A_L9B.currentLang ].gameData.indexOf(data);
		
		function checkIndex1(i){
		if(i.name==val)
		return i;
		}
	   } */
   if(Utils.mobileDeviceFlag)
    {
          var langName = Android.getGameLang();
        L9A_L9B.currentLang =  L9A_L9B.gameNameArr.findIndex(obj => obj.language == langName);
        var gameCode = Android.getGameID();
        L9A_L9B.currentques = L9A_L9B.gameNameArr[L9A_L9B.currentLang].gameData.findIndex(obj => obj.name == gameCode);
		if(langName=="Urdu-Pakistan"){
		$("#heading").css("direction","rtl");
		}
    }
    else{
       L9A_L9B.currentques= Math.floor(Math.random()*L9A_L9B.gameNameArr[L9A_L9B.currentLang].gameData.length);
       /* L9A_L9B.currentLang = 11;
       L9A_L9B.currentques= 4; */
		if(L9A_L9B.currentLang==11){
		$("#heading").css("text-align","right");
		$("#heading").css("direction","rtl");
		}
    }
	 if(L9A_L9B.gameNameArr[L9A_L9B.currentLang].languageFont!=null)
           setFontFamilyForLang(L9A_L9B.gameNameArr[L9A_L9B.currentLang].languageFont);
    
	document.getElementById("heading").innerHTML = L9A_L9B.gameNameArr[L9A_L9B.currentLang].gameData[L9A_L9B.currentques].instrText;
     if(L9A_L9B.gameNameArr[L9A_L9B.currentLang].gameData[L9A_L9B.currentques].data == 1){
         $("#modalIcon").css("visibility","hidden");
         $("#resetDiv").css("visibility","visible");
           L9A_L9B.optionArr=  L9A_L9B.gameNameArr[L9A_L9B.currentLang ].gameData[L9A_L9B.currentques].optionArray ; 
            L9A_L9B.optionArr =  shuffle(L9A_L9B.optionArr);
     } 
     else{
        $("#modalIcon").css("visibility","visible");
        $("#resetDiv").css("visibility","hiddden");
        $("#optionDivId").hide();
        $("#quesId").css("top","20vh");
     }
	    $("#queNo").css("font-size","2vw");
        $("#heading").css("font-size",L9A_L9B.gameNameArr[L9A_L9B.currentLang ].fontSize);
        document.getElementById("queNo").innerHTML = L9A_L9B.gameNameArr[L9A_L9B.currentLang ].gameData[L9A_L9B.currentques].name;
        $("#queNo").css("font-size","1.6vw");
        $("#quesId").text(L9A_L9B.gameNameArr[L9A_L9B.currentLang ].gameData[L9A_L9B.currentques].ques);
        L9A_L9B.createDiv ();
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
L9A_L9B.createDiv = function(){
    d = new Date();  //date object
	startTime = d.getDate() + "-" + (d.getMonth() + 1) + "-" + d.getFullYear() + " " + d.getHours() + ":" + d.getMinutes() + ":" + d.getSeconds();  //to get the current date
    
    for(var i=0;i<4;i++){
        var opdiv = document.createElement("div");
        opdiv.setAttribute("id","optionId"+i);
        opdiv.setAttribute("class","noPadding optionClass borderClass col-sm-2 col-xs-2 col-lg-2 col-md-2");
        opdiv.setAttribute("onclick","L9A_L9B.checkAns(this.id)");
        opdiv.innerHTML = L9A_L9B.optionArr[i];
        $(opdiv).css("background-color","unset");
        document.getElementById("optionDivId").appendChild(opdiv);
    }
}
L9A_L9B.checkAns = function(clicked_option){
    scoreFlag = true;
    $(".optionClass").css("border","1px solid black");
    $("#"+clicked_option).css("border","6px solid rgb(255, 190, 0)");
    if(L9A_L9B.gameNameArr[L9A_L9B.currentLang].gameData[L9A_L9B.currentques].Ans == $("#"+clicked_option).text())
     { 
         scoredMarks = "2";
         label = L9A_L9B.gameNameArr[L9A_L9B.currentLang].gameData[L9A_L9B.currentques].Ans;
     }
     else{
        scoredMarks = "1";
        label = $("#"+clicked_option).text();
     }
}
L9A_L9B.goNext = function(){
    if(L9A_L9B.gameNameArr[L9A_L9B.currentLang].gameData[L9A_L9B.currentques].data == 2){
		console.log(clickOption);
        if(clickOption == '')
        scoredMarks = "0";
   // else 
      //  scoredMarks = clickOption;
       
     label = "null";
    }
    else{
        if(!scoreFlag){
            scoredMarks = 0;
            label="null";
        }
    }
   
   // L9A_L9B.scoreFunction();
	if(clickOption!="" || L9A_L9B.gameNameArr[L9A_L9B.currentLang].gameData[L9A_L9B.currentques].data == 1)
	{
		//scoredMarks=clickOption;
		L9A_L9B.scoreFunction();
	}
	else if(L9A_L9B.gameNameArr[L9A_L9B.currentLang].gameData[L9A_L9B.currentques].data == 2){
		showModal();}
}
resetGame = function(){
    scoreFlag = false;
    $(".optionClass").css('border',' 2px solid rgb(102 98 85)');
    $(".buttonClass").css('border',' 2px solid rgb(102 98 85)');
    
    label = "null",
   
    scoredMarks = "0"; 
}
L9A_L9B.scoreFunction = function () {
    console.log(scoredMarks,startTime, label);
  //  alert("scoredMarks = " + scoredMarks +","+" "+"Label = " +label);
    if (Utils.mobileDeviceFlag) {
        Android.gotoNextGame(scoredMarks,startTime, label);
    }
}
function hideQuestion()
{
    $('#questioMark').show();
    $('#myModal').css('display','none');
}
function showQues()
{
    $('#questioMark').hide();
    $('#myModal').css('display','block');
}

function shuffle(sarray) {
    var arrayLength = sarray.length;
    var temp, random_index;
    while (arrayLength > 0) {
        random_index = Math.floor(Math.random() * arrayLength);
        arrayLength--;
        temp = sarray[arrayLength];
        sarray[arrayLength] = sarray[random_index];
        sarray[random_index] = temp;
    }
    return (sarray);
}