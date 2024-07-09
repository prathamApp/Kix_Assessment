var Sequence = {};
var Utils = {};
Utils.Path = '';
Utils.mobileDeviceFlag = false;
Sequence.attemptFlag=false;
var questionId = 0, startTime = 0, scoredMarks = "0", totalMarks = 10, resId = 0;
Sequence.dataText="";
Sequence.randomIndex=0;
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
    	//var val = 'Spanish-Nicaragua'
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
		langIndex=3;
		Sequence.randomIndex=Math.floor(Math.random()*Sequence.data[langIndex].nodeInfo.length);
		//var gameCode="M10D";
		//Sequence.randomIndex=Sequence.data.findIndex(obj=>obj.gameName==gameCode) 
	}
	console.log(Sequence.randomIndex);
	Sequence.attemptFlag=false;
	//Sequence.randomIndex=Math.floor(Math.random()*Sequence.data.length);
	var d;
	d = new Date();
	startTime = d.getDate() + "-" + (d.getMonth() + 1) + "-" + d.getFullYear() + " " + d.getHours() + ":" + d.getMinutes() + ":" + d.getSeconds();
	document.getElementById("heading").innerHTML=Sequence.data[langIndex].nodeInfo[Sequence.randomIndex].queText;
	$("#heading").css("font-size","1.7vw");
	if(val=="Urdu-Pakistan")
		$("#heading").css("direction","rtl");
	$("#queNo").text(Sequence.data[langIndex].nodeInfo[Sequence.randomIndex].gameName);
	$('#heading').parent().css('font-weight', 'unset');
	questionId=Sequence.data[langIndex].nodeInfo[Sequence.randomIndex].gameName;
	Sequence.createDivs(optionDiv, Sequence.data[langIndex].nodeInfo[Sequence.randomIndex].queImage.length,'option', '');
	if((Sequence.data[langIndex].nodeInfo[Sequence.randomIndex].gameName=="M2C") || (Sequence.data[langIndex].nodeInfo[Sequence.randomIndex].gameName=="M2D"))
	{
		$("#optionDiv").removeClass("flexClass");
		$("#optionDiv").css("margin-top","1vh");
	}
	else
		$("#optionDiv").removeClass("gridClass");
	if(Sequence.data[langIndex].nodeInfo[Sequence.randomIndex].gameName!="M10D")
		$("#ballDiv").hide();
	else
		{
			$("#ballImg").prop("src", Utils.Path + "images/M10D_5.png");
		}
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
Sequence.checkAns=function(ele)
{
	Sequence.attemptFlag=true;
	Sequence.dataText=$("#"+ele).data("ansData");
	Sequence.lableData=$("#"+ele).data("lableData");
	$(".optionImg").removeClass("selectBorder");
	$("#"+ele).addClass("selectBorder");
}
Sequence.nextQue=function()
{
	if(Sequence.attemptFlag)
	{
	if(Sequence.dataText==Sequence.data[langIndex].nodeInfo[Sequence.randomIndex].ans)
		scoredMarks = "2";
	else
		scoredMarks = "1";
	}
	else
	{
		scoredMarks = "0";
		Sequence.lableData="null";
	}
	//	$('body').css('pointer-events', 'none');
		Sequence.calculateScore();
}
Sequence.createDivs = function (parentDiv, numberOfDivs, idName, classname) {
	
	var temp, optionDiv, imgDiv;
	if(Sequence.data[langIndex].nodeInfo[Sequence.randomIndex].queImage.length==2)
	{
		temp = 5;
		if(Sequence.randomIndex>3)
		{
			temp = 4;
		$("#optionDiv").css("margin-top","3vh");
		}
	}
	else
		temp=3;
	for (var i = 1; i <= numberOfDivs; i++) {
		optionDiv = document.createElement("div");
		optionDiv.setAttribute("id", "" + idName + '' + i);
		if((Sequence.data[langIndex].nodeInfo[Sequence.randomIndex].gameName=="M2C") || (Sequence.data[langIndex].nodeInfo[Sequence.randomIndex].gameName=="M2D"))
		{
			optionDiv.setAttribute("class", "noPadding col-sm-6 col-lg-6 col-md-6 col-xs-6 col-sm-offset-3 col-lg-offset-3 col-md-offset-3 col-xs-offset-3");
		//	$(".optionImg").addClass("heightClass");
			$("#gamapage").css("position","absolute");
		}
		else
			optionDiv.setAttribute("class", "noPadding " + classname + " col-xs-" + temp + " col-md-" + temp + " col-lg-" + temp + " col-sm-" + temp);
		parentDiv.appendChild(optionDiv);
		
		imgDiv = document.createElement("img");
		imgDiv.setAttribute("id",'img' + i);
		optionDiv.appendChild(imgDiv);
		if((Sequence.data[langIndex].nodeInfo[Sequence.randomIndex].gameName=="M2C") || (Sequence.data[langIndex].nodeInfo[Sequence.randomIndex].gameName=="M2D"))
			imgDiv.setAttribute("class", "img-responsive optionImg optionImgBorder noPadding col-lg-10 col-md-10 col-xs-10 col-sm-10 col-sm-offset-2 col-lg-offset-2 col-md-offset-2 col-xs-offset-2");
		else
			imgDiv.setAttribute("class", "img-responsive optionImg optionImgBorder noPadding col-lg-12 col-md-12 col-xs-12 col-sm-12");
		$("#img" + i).prop("src", Utils.Path + "images/" + Sequence.data[langIndex].nodeInfo[Sequence.randomIndex].queImage[i-1]);
		$("#img" + i).data("ansData",Sequence.data[langIndex].nodeInfo[Sequence.randomIndex].ansDataArray[i-1]);
		$("#img" + i).data("lableData",Sequence.data[langIndex].nodeInfo[Sequence.randomIndex].queImage[i-1]);
		imgDiv.setAttribute("onclick","Sequence.checkAns(this.id)");
	}
	if((Sequence.data[langIndex].nodeInfo[Sequence.randomIndex].gameName=="M2C") || (Sequence.data[langIndex].nodeInfo[Sequence.randomIndex].gameName=="M2D"))
		$(".optionImg").addClass("heightClass");
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
	Sequence.attemptFlag=false;
	$(".optionImg").removeClass("selectBorder");
	Sequence.lableData="null";
}
Sequence.calculateScore = function () {
	console.log(scoredMarks,startTime,Sequence.lableData);
	if (Utils.mobileDeviceFlag)
		Android.gotoNextGame(scoredMarks,startTime,Sequence.lableData);
	//alert("ScoredMarks="+scoredMarks+","+" "+"Label = "+Sequence.lableData);
}