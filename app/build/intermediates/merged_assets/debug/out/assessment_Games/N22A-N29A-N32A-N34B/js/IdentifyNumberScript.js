var IdentifyNumber = {};
var Utils = {};
Utils.Path = '';
Utils.mobileDeviceFlag = false;
var starttime = "0", scoredmarks = "0", label ="",langIndex;
$(document).ready(function () {
	$(".se-pre-con").fadeOut("slow");
	if((navigator.userAgent.match(/Android|BlackBerry|iPhone|iPad|iPod|Opera Mini|IEMobile/i)) && !(window.location.href.includes('http')))
        Utils.mobileDeviceFlag = true;
	setTimeout(function () {
		IdentifyNumber.init();
	}, 100);
}); 

IdentifyNumber.init = function()
{
    $('#questioMark').hide();
    IdentifyNumber.initializeVariables ();
	if (Utils.mobileDeviceFlag) {
        var val = Android.getGameLang();		//GET ANDROID GAME LANGUAGE
        var lang = IdentifyNumber.data.find(checkIndex);
        langIndex = IdentifyNumber.data.indexOf(lang);
		
        function checkIndex(i) {
            if (i.language.toLowerCase() == val.toLowerCase())
                return i;
       }
	   if(val=="Urdu-Pakistan"){
		$("#heading").css("direction","rtl");
		}
	   var val1=Android.getGameID();		//GET GAME CODE
		var data=IdentifyNumber.data[langIndex].nodeInfo.find(checkIndex1);
		IdentifyNumber.level=IdentifyNumber.data[langIndex].nodeInfo.indexOf(data);
		
		function checkIndex1(i){
		if(i.gameName==val1)
		return i;
		}
		
	 }
    else{
		langIndex = 14;		//GET RANDOM GAME LANGUAGE
		IdentifyNumber.level=Math.floor(Math.random()*IdentifyNumber.data[langIndex].nodeInfo.length);
		if(langIndex==14){
		$("#heading").css("text-align","right");    
		$("#heading").css("direction","rtl");
		}
	}
	 if(IdentifyNumber.data[langIndex].languageFont!=null)
           setFontFamilyForLang(IdentifyNumber.data[langIndex].languageFont);
	d = new Date();  //date object
	starttime = d.getDate() + "-" + (d.getMonth() + 1) + "-" + d.getFullYear() + " " + d.getHours() + ":" + d.getMinutes() + ":" + d.getSeconds();  //to get the current date
    IdentifyNumber.playGame ();
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
IdentifyNumber.initializeVariables = function()
{
    IdentifyNumber.answer;//stored answer
    IdentifyNumber.level;
    IdentifyNumber.selectUniqueNumber=[];
    IdentifyNumber.answerFlag=false;
    IdentifyNumber.currentClickId;
    IdentifyNumber.currectAnswerFlag=false;
}
function showQues()
{
    $('#questioMark').hide();
    $('#myModal').css('display','block');
}
function hideQuestion()
{
    $('#questioMark').show();
    $('#myModal').css('display','none');
}
IdentifyNumber.playGame = function(object)
{
    IdentifyNumber.initializeVariables ();
    document.getElementById("queNo").innerHTML=IdentifyNumber.data[langIndex].nodeInfo[IdentifyNumber.level].gameName;
    document.title =IdentifyNumber.data[langIndex].nodeInfo[IdentifyNumber.level].gameName;
    document.getElementById("heading").innerHTML=IdentifyNumber.data[langIndex].nodeInfo[IdentifyNumber.level].instruction;
    IdentifyNumber.answer=IdentifyNumber.data[langIndex].nodeInfo[IdentifyNumber.level].ans;
    IdentifyNumber.showOptions();
}
//display question and images
IdentifyNumber.showOptions=function()
{
	if(IdentifyNumber.data[langIndex].nodeInfo[IdentifyNumber.level].gameName=="N29A"){
	shuffleArray(IdentifyNumber.data[langIndex].nodeInfo[IdentifyNumber.level].optionArray);}
    for(var i=0;i<4;i++)//no of image column
    {
        var Div = document.createElement("div");
        Div.setAttribute("id", "div"+i);
        Div.setAttribute("class", " nopadding options  col-lg-2 col-md-2 col-sm-2 col-xs-2 col-xs-offset-1 col-sm-offset-1 col-md-offset-1 col-lg-offset-1");
        document.getElementById('optionDiv').appendChild(Div);
        Div.setAttribute("onclick", "IdentifyNumber.checkAnswer(this)");
        Div.innerHTML=IdentifyNumber.data[langIndex].nodeInfo[IdentifyNumber.level].optionArray[i];
    }
	$('#heading').parent().css('font-weight', 'unset');
}
function shuffleArray(array) {
    var i, j, temp;
    for (i = array.length - 1; i > 0; i--) {
        j = Math.floor(Math.random() * (i + 1));
        temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    return array;
}
//check Answer
IdentifyNumber.checkAnswer=function(object)
{
    IdentifyNumber.answerFlag=true;
    $(IdentifyNumber.currentClickId).removeClass("border");
    IdentifyNumber.currentClickId=document.getElementById(object.id);
    $("#" +object.id).addClass("border");
    label=document.getElementById(object.id).innerHTML;
    if(IdentifyNumber.answer==document.getElementById(object.id).innerHTML)
    {
        IdentifyNumber.currectAnswerFlag=true;
    }
}
IdentifyNumber.NextLevel=function()
{
   // document.body.style.pointerEvents = "none";
   $(IdentifyNumber.currentClickId).removeClass("border");
    if(IdentifyNumber.currectAnswerFlag==true && IdentifyNumber.answerFlag==true)
        scoredmarks="2";
    else if(IdentifyNumber.currectAnswerFlag==false && IdentifyNumber.answerFlag==true)
        scoredmarks="1";
    else if(IdentifyNumber.answerFlag==false)
    {
        label="null";
        scoredmarks="0";
    }
	//alert("ScoredMarks = " + scoredmarks +","+" "+"Label = " +label);
    IdentifyNumber.scoreFunction();
	//IdentifyNumber.answer="";
    IdentifyNumber.selectUniqueNumber=[];
    IdentifyNumber.answerFlag=false;
    IdentifyNumber.currectAnswerFlag=false;
}
IdentifyNumber.scoreFunction = function () {
    console.log(scoredmarks,starttime, label);
    if (Utils.mobileDeviceFlag) {
		Android.gotoNextGame(scoredmarks, starttime, label);
    }
}
IdentifyNumber.resetAll=function()
{
    $(IdentifyNumber.currentClickId).removeClass("border");
    document.getElementById('optionDiv').innerHTML="";
    IdentifyNumber.playGame();
}