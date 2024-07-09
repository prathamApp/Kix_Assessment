var Sequence = {};
var Utils = {};
Utils.Path = '';
Utils.mobileDeviceFlag = false;
Sequence.randomIndex=0;
var questionId = 0, startTime = 0, scoredMarks = "0", totalMarks = 10, resId = 0,label="null";
var len=8;
Sequence.attemptFlag=false;
//function for loader */
$(document).ready(function () {
	if ((navigator.userAgent.match(/Android|BlackBerry|iPhone|iPad|iPod|Opera Mini|IEMobile/i)) && !(window.location.href.includes('http')))
		Utils.mobileDeviceFlag = true;
		showQues();
	Sequence.generateQue();
});
Sequence.generateQue = function () {
	if (Utils.mobileDeviceFlag)
	{
		var val = Android.getGameLang();		//GET ANDROID GAME LANGUAGE
    	//var val = 'English-Uganda'
        var lang = Sequence.data.find(checkIndex);
        langIndex = Sequence.data.indexOf(lang);
        function checkIndex(i) {
            if (i.language.toLowerCase() == val.toLowerCase())
                return i;
       }
		var gameCode = Android.getGameID();
		Sequence.randomIndex=Sequence.data[langIndex].nodeInfo.findIndex(obj=>obj.gameName==gameCode)
	}
	else
	{
		//var val = 'Urdu-Pakistan';
		langIndex=0;
		Sequence.randomIndex=Math.floor(Math.random()*Sequence.data[langIndex].nodeInfo.length);
	//	var gameCode="M26A";
	//	Sequence.randomIndex=Sequence.data[langIndex].nodeInfo.findIndex(obj=>obj.gameName==gameCode)
	}
	console.log(Sequence.randomIndex);
	//$("#numberpadDiv").hide();
	//Sequence.randomIndex=Math.floor(Math.random()*Sequence.data[langIndex].nodeInfo.length);
	d = new Date();
	startTime = d.getDate() + "-" + (d.getMonth() + 1) + "-" + d.getFullYear() + " " + d.getHours() + ":" + d.getMinutes() + ":" + d.getSeconds();
	document.getElementById("heading").innerHTML=Sequence.data[langIndex].nodeInfo[Sequence.randomIndex].queText;
	if(val=="Urdu-Pakistan")
		$("#heading").css("direction","rtl");
	$("#queNo").text(Sequence.data[langIndex].nodeInfo[Sequence.randomIndex].gameName);
	questionId=Sequence.data[langIndex].nodeInfo[Sequence.randomIndex].gameName;
	$("#queImg").prop("src",Utils.Path +"images/"+Sequence.data[langIndex].nodeInfo[Sequence.randomIndex].queImage);
//	createNumberDivs("numPad");
$("#inputText").hide();
	$(".directCoding").show();
	$("#answerKeyText").append(Sequence.data[langIndex].ansText+" : "+Sequence.data[langIndex].nodeInfo[Sequence.randomIndex].ansKey);
//	$("#Answer").text(Sequence.data[langIndex].ansText +" :");
if(Sequence.data[langIndex].languageFont!=null)
        setFontFamilyForLang(Sequence.data[langIndex].languageFont);
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
Sequence.checkAnswer=function()
{
	label=$("#inputText").text().trim();
	for(var i=0;i<Sequence.data[langIndex].nodeInfo[Sequence.randomIndex].ansArray.length;i++)
	{
	if($("#inputText").text().trim()==Sequence.data[langIndex].nodeInfo[Sequence.randomIndex].ansArray[i].trim())
	{
		scoredMarks="2";
		return 0;
	}
	else									//FALSE
		scoredMarks="1";
	}
}
Sequence.nextQue=function()		//NEXT CLICK
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
		//scoredMarks="0";
	}
		//$('body').css('pointer-events', 'none');
	/* if(clickOption!="")
	{
		label=$("#inputText").text().trim();
		scoredMarks=clickOption;
	}
	else
	{
		label="null";
		scoredMarks="0";
	} */
	
}
/* Sequence.enterNumber=function()
{
	Sequence.ansDivFlag=true;
	//$("#ansDiv").addClass("blink_me");
	$("#numberpadDiv").show();
//	$("#ansDiv").css("border","6px solid black");
}
function displayNumber(element)
{
	if(Sequence.ansDivFlag)
	{
		Sequence.attemptFlag=true;
		$("#ansDiv").removeClass("blink_me");
		var num="";
		num=$('#ansDiv').text().trim();
		if(num.toString().length<5)
			$("#ansDiv").append($("#"+element).text());
		$("#buttonId43").css("pointer-events", "auto");
		$("#buttonId43").css("opacity", 1);
	}
}
Sequence.getScore=function(ele)
{
	scoredMarks=$("#"+ele).text();
	$(".CodeClass").addClass("borderClass");
	$("#"+ele).removeClass("borderClass");
	$("#"+ele).addClass("selectBorder");
} */
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
	Sequence.attemptFlag=false;
	$('#ansDiv').text("");
	label="null";
	scoredMarks="0";
	$(".CodeClass").removeClass("selectBorder");
	$(".CodeClass").addClass("borderClass");
	$("#numberpadDiv").hide();
}
Sequence.calculateScore = function () {
	label="null";
	console.log(scoredMarks,startTime,label);
	if (Utils.mobileDeviceFlag)
		Android.gotoNextGame(scoredMarks,startTime,label);
	//alert("ScoredMarks="+scoredMarks+","+" "+"Label = "+label);
}