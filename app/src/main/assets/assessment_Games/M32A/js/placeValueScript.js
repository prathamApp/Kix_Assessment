var Sequence = {};
var Utils = {};
Utils.Path = '';
Utils.mobileDeviceFlag = false;
Sequence.randomIndex=0;
var questionId = 0, startTime = 0, scoredMarks = "0", totalMarks = 10, resId = 0,label="";
var len=1;
Sequence.attemptFlag=false;
//function for loader */
$(document).ready(function () {
	if ((navigator.userAgent.match(/Android|BlackBerry|iPhone|iPad|iPod|Opera Mini|IEMobile/i)) && !(window.location.href.includes('http')))
		Utils.mobileDeviceFlag = true;
		showQues();
	Sequence.generateQue();
	$("#resetDiv").css("visibility","hidden");
});
Sequence.generateQue = function () {
	if (Utils.mobileDeviceFlag)
	{
		var val = Android.getGameLang();		//GET ANDROID GAME LANGUAGE
		// var val = 'Hindi'
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
		/* var gameCode="M32A";
		Sequence.randomIndex=Sequence.data.findIndex(obj=>obj.gameName==gameCode) */
	}
	console.log(Sequence.randomIndex);
	$(".directCoding").hide();
	//Sequence.randomIndex=Math.floor(Math.random()*Sequence.data.length);
	d = new Date();
	startTime = d.getDate() + "-" + (d.getMonth() + 1) + "-" + d.getFullYear() + " " + d.getHours() + ":" + d.getMinutes() + ":" + d.getSeconds();
	document.getElementById("heading").innerHTML=Sequence.data[langIndex].nodeInfo[Sequence.randomIndex].queText;
	$("#heading").css("font-size","1.5vw");
	if(val=="Urdu-Pakistan")
		$("#heading").css("direction","rtl");
	$("#queNo").text(Sequence.data[langIndex].nodeInfo[Sequence.randomIndex].gameName);
	$('#heading').parent().css('font-weight', 'unset');
	$("#answerKeyText").append(Sequence.data[langIndex].ansText+" : "+Sequence.data[langIndex].nodeInfo[Sequence.randomIndex].ansTime);
	$("#Answer").text(Sequence.data[langIndex].ansText +" :");
	Sequence.createDivs(queImgDiv, 2, 'option', '');
	//createNumberDivs("numPad");
	$(".directCoding").show();
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
Sequence.createDivs = function (parentDiv, numberOfDivs, idName, classname) {
	var temp, optionDiv, imgDiv;
		temp = 6;
	for (var i = 1; i <= numberOfDivs; i++) {
		optionDiv = document.createElement("div");
		optionDiv.setAttribute("id", "" + idName + '' + i);
		optionDiv.setAttribute("class", "noPadding " + classname + " col-xs-" + temp + " col-md-" + temp + " col-lg-" + temp + " col-sm-" + temp);
		parentDiv.appendChild(optionDiv);
			imgDiv = document.createElement("img");
			imgDiv.setAttribute("id",'img' + i);
			optionDiv.appendChild(imgDiv);
			imgDiv.setAttribute("class", "imgClass img-responsive noPadding col-lg-10 col-md-10 col-xs-10 col-sm-10 col-sm-offset-1 col-lg-offset-1 col-xs-offset-1 col-md-offset-1");
			$("#img" + i).prop("src", Utils.Path + "images/" + Sequence.data[langIndex].nodeInfo[Sequence.randomIndex].queImage[i-1]);
			//Sequence.data[langIndex].nodeInfo[Sequence.randomIndex].
	}
}
Sequence.checkAnswer=function()
{
	label = "null";
	if($("#inputText").text().trim()==Sequence.data[langIndex].nodeInfo[Sequence.randomIndex].ansTime)
		scoredMarks="2";
	else									//FALSE
		scoredMarks="1";
}
Sequence.nextQue=function()		//NEXT CLICK
{
	/* if ($("#inputText").text() == '') {
		scoredMarks = "0";
		label = "null";
	}
	else
		Sequence.checkAnswer();
		//$('body').css('pointer-events', 'none');
	Sequence.calculateScore(); */
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
}

function showQues(){
	$('#questioMark').hide();
	$('#myModal').css('display','block');
}
function hideQuestion(){
    $('#questioMark').show();
    $('#myModal').css('display','none');
}
function resetGame()
{
	scoredMarks = "0";
	label = "null";
}
Sequence.calculateScore = function () {
	label = "null";
	console.log(scoredMarks,startTime,label);
	if (Utils.mobileDeviceFlag)
		Android.gotoNextGame(scoredMarks,startTime,label);
	//alert("scoredMarks="+scoredMarks+","+" "+"Label = "+label);
}