var Sequence = {};
var Utils = {};
Utils.Path = '';
Utils.mobileDeviceFlag = false; 
var questionId = '', startTime = 0, scoredMarks = "0", resId = 0,label='';
Sequence.queCnt=0;
Sequence.attemptFlag=false;
var text;
//function for loader */
$(document).ready(function () {
	if ((navigator.userAgent.match(/Android|BlackBerry|iPhone|iPad|iPod|Opera Mini|IEMobile/i)) && !(window.location.href.includes('http')))
		Utils.mobileDeviceFlag = true;
		showQues();
	Sequence.generateQue();
	$(".directCoding").show();
	$(".ansKeypadDiv").hide();
});
Sequence.generateQue = function () {
	
	Sequence.attemptFlag=false;
	if (Utils.mobileDeviceFlag)
	{
		var val = Android.getGameLang();		//GET ANDROID GAME LANGUAGE
    	//var val = 'Bangla-Bangladesh'
        var lang = Sequence.data.find(checkIndex);
        langIndex = Sequence.data.indexOf(lang);
        function checkIndex(i) {
            if (i.language.toLowerCase() == val.toLowerCase())
                return i;
       }
		var gameCode = Android.getGameID();
		Sequence.queCnt=Sequence.data[langIndex].nodeInfo.findIndex(obj=>obj.gameNode==gameCode)
	}
	else
	{
		var val = 'Urdu-Pakistan';
		langIndex=14;
		Sequence.queCnt=Math.floor(Math.random()*Sequence.data[langIndex].nodeInfo.length);
		//var gameCode="N19B";
		//Sequence.queCnt=Sequence.data.findIndex(obj=>obj.gameNode==gameCode)
	}
	console.log(Sequence.queCnt);
	var d;
	d = new Date();
	startTime = d.getDate() + "-" + (d.getMonth() + 1) + "-" + d.getFullYear() + " " + d.getHours() + ":" + d.getMinutes() + ":" + d.getSeconds();
	$("#queNo").text(Sequence.data[langIndex].nodeInfo[Sequence.queCnt].gameNode);
	document.getElementById("heading").innerHTML=Sequence.data[langIndex].nodeInfo[Sequence.queCnt].queText;
	$("#firstNum").text(Sequence.data[langIndex].nodeInfo[Sequence.queCnt].firstNo);
	$("#secondNum").text(Sequence.data[langIndex].nodeInfo[Sequence.queCnt].secondNo);
	$("#heading").css("font-size","1.8vw");
	if(val=="Urdu-Pakistan")
		$("#heading").css("direction","rtl");
	$("#answerKeyText").append(Sequence.data[langIndex].ansText+" : "+Sequence.data[langIndex].nodeInfo[Sequence.queCnt].ansKey);
}

Sequence.nextQue=function()
{
	if(clickOption!="")
	{
		scoredMarks=clickOption;
		Sequence.calculateScore();
	}
	else
		{
			$("#modalRoot").addClass("visible");
		$("body").addClass("overlay");
		$(".opacityClass").css("opacity","0.1");
		$(".pointerClass").css("pointer-events","none");
		}	
}

function showQues(){
    $('#questioMark').hide();
    $('#myModal').css('display','block');
}
function hideQuestion(){
    $('#questioMark').show();
    $('#myModal').css('display','none');
}
Sequence.resetGame=function()
{
	label="null";
	scoredMarks="0";
}
Sequence.calculateScore = function () {
	label="null";
	console.log(scoredMarks,startTime,label);
	if (Utils.mobileDeviceFlag)
		Android.gotoNextGame(scoredMarks,startTime,label);
	//alert("ScoredMarks="+scoredMarks+","+" "+"Label = "+label);
}