
var Sequence = {};
var Utils = {};
Utils.Path = '';
Utils.mobileDeviceFlag = false;
var questionId = '', startTime = 0, scoredMarks = "0", resId = 0,label='null';
var dataImg="";
//function for loader
$(document).ready(function () {
	if ((navigator.userAgent.match(/Android|BlackBerry|iPhone|iPad|iPod|Opera Mini|IEMobile/i)) && !(window.location.href.includes('http')))
		Utils.mobileDeviceFlag = true;
	setTimeout(function () {
		showQues();
		Sequence.initVariables();
		Sequence.arrangeSequence();
	}, 300);
});
Sequence.initVariables = function ()	//function to set images
{
	Sequence.imageArr = [];			//image array
	Sequence.no = 0;
	Sequence.uniqueRandomQuestion = [];		//unique questions
	Sequence.dragFlag = false;	
	Sequence.randomIndex=0;
	var positionArr=[];
	Sequence.attemptFlag=false;
	Sequence.exampleFlag=false;
	Sequence.blinkCounter=1;
	Sequence.nextClick=0;
	//Sequence.diffGameArray=["M15A","M17A","M20A"];
}
Sequence.arrangeSequence = function () {
	Sequence.imageArr=[];
	Sequence.dragFlag = false;
	var answerDiv;
	Sequence.result = false;
	positionArr=[];
	if (Utils.mobileDeviceFlag)
	{
		 var val = Android.getGameLang();		//GET ANDROID GAME LANGUAGE
    	//var val = 'Hindi'
        var lang = Sequence.Images.find(checkIndex);
        langIndex = Sequence.Images.indexOf(lang);
        function checkIndex(i) {
            if (i.language.toLowerCase() == val.toLowerCase())
                return i;
       }
		var gameCode = Android.getGameID();
		Sequence.randomIndex=Sequence.Images[langIndex].nodeInfo.findIndex(obj=>obj.gameName==gameCode)
	}
	else
	{
	//	var val = 'Urdu-Pakistan';
		langIndex=0;
		Sequence.randomIndex=Math.floor(Math.random()*(Sequence.Images[langIndex].nodeInfo.length-1))+1;
	}
	console.log(Sequence.randomIndex);
	var d;
	d = new Date();
	startTime = d.getDate() + "-" + (d.getMonth() + 1) + "-" + d.getFullYear() + " " + d.getHours() + ":" + d.getMinutes() + ":" + d.getSeconds();
	Sequence.imageArr = Sequence.Images[langIndex].nodeInfo.slice();	//image data
	Sequence.no=Sequence.Images[langIndex].nodeInfo[0].imgCount;
	document.getElementById("heading").innerHTML=Sequence.Images[langIndex].nodeInfo[0].queText;
	$("#heading").css("font-size","1.5vw");
	if(val=="Urdu-Pakistan")
		$("#heading").css("direction","rtl");
	$("#queNo").text(Sequence.Images[langIndex].nodeInfo[Sequence.randomIndex].gameName+"Eg");
	$('#heading').parent().css('font-weight', 'unset');
	document.getElementById('answerDiv').innerHTML = "";
	answerDiv = document.getElementById('answerDiv');
	Sequence.createDivs(answerDiv, Sequence.no , 'drop', 'dropClass');
	Sequence.createDivs(optionsDiv, Sequence.no , 'options', 'dropClass');
	Sequence.addInsideImages();
if(Sequence.Images[langIndex].languageFont!=null)
        setFontFamilyForLang(Sequence.Images[langIndex].languageFont);
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
Sequence.createDivs = function (parentDiv, numberOfDivs, idName, classname) 	//create main outer divs
{
	var temp, dropDiv;
		$("#answerDiv,#optionsDiv").addClass("flexClass");
		if(!Sequence.exampleFlag)
		{
		temp =2;
		$("#optionsDiv,#answerDiv").addClass("col-sm-12 col-lg-12 col-md-12 col-xs-12");
		}
		else
		{
			temp = Math.floor(12 / numberOfDivs);
			$("#optionsDiv,#answerDiv").addClass("col-sm-10 col-lg-10 col-md-10 col-xs-10 col-sm-offset-1 col-lg-offset-1 col-md-offset-1 col-xs-offset-1");
		}
		for (var i = 1; i <= numberOfDivs; i++) {
			dropDiv = document.createElement("div");
			dropDiv.setAttribute("id", "" + idName + '' + i);
			dropDiv.setAttribute("class", "noPadding " + classname + " col-xs-" + temp + " col-md-" + temp + " col-lg-" + temp + " col-sm-" + temp);
			parentDiv.appendChild(dropDiv);
		}
		
			$("#mainDiv").css("marginTop","5vh");
}

Sequence.addInsideImages = function ()		//set images of objects
{
	for (var i = 1; i <= Sequence.no; i++) {
		subDiv = document.createElement("div");
		subDiv.setAttribute("id", "subDiv" + i);
		subDiv.setAttribute("class", "noPadding  col-xs-11 col-md-11 col-lg-11 col-sm-11");
		subDiv.setAttribute("onclick","Sequence.getOptionImg(this.id)");
		document.getElementById("drop" + i).appendChild(subDiv);
		$("#subDiv" + i).data('answer', Sequence.alphabetsArray[i-1]);

		subOptionDiv = document.createElement("div");
		subOptionDiv.setAttribute("id", "subOptionDiv" + i);
		subOptionDiv.setAttribute("class", "noPadding subDivClass col-xs-11 col-md-11 col-lg-11 col-sm-11");
		
		//subOptionDiv.setAttribute("onclick","Sequence.setOptionImg(this.id)");
		document.getElementById("options" + i).appendChild(subOptionDiv);
		
		
		sequenceImg = document.createElement("img");
		sequenceImg.setAttribute("id", "sequenceImg" + i);
		sequenceImg.setAttribute("class", "img-responsive noPadding col-xs-12 col-md-12 col-lg-12 col-sm-12");

		optionImg = document.createElement("img");
		optionImg.setAttribute("id", "optionImg" + i);
		optionImg.setAttribute("class", "img-responsive optionImg noPadding col-xs-12 col-md-12 col-lg-12 col-sm-12");

		$("#subDiv" + i).append(sequenceImg);
		$("#subOptionDiv" + i).append(optionImg);
		$("#subOptionDiv" + i).data("numData",i);
		$(".optionImg").css({"visibility":"hidden","pointer-events":"none"});
		$("#subOptionDiv"+Sequence.blinkCounter).addClass("Blink_me");
	}
		for (var i = 1; i <= Sequence.no; i++) {
			if(Sequence.exampleFlag)
			{
				$("#subDiv"+ i).data('ans',Sequence.imageArr[Sequence.randomIndex].imgname + i + Sequence.imageArr[Sequence.randomIndex].imgtype);//
			//	$("#sequenceImg" + i).data('answer',Sequence.Images[langIndex].nodeInfo[Sequence.randomIndex].ansArray[i-1]);
				$("#sequenceImg" + i).prop("src", Utils.Path + Sequence.imageArr[Sequence.randomIndex].imgname + i + Sequence.imageArr[Sequence.randomIndex].imgtype);
				$("#optionImg" + i).prop("src", Utils.Path + Sequence.imageArr[Sequence.randomIndex].imgname + i + Sequence.imageArr[Sequence.randomIndex].imgtype);
				if(Sequence.Images[langIndex].nodeInfo[Sequence.randomIndex].gameName=="M18A")
				{
					document.getElementById("answerDiv").setAttribute("class", "noPadding col-sm-8 col-lg-8 col-md-8 col-xs-8 col-sm-offset-2 col-lg-offset-2 col-md-offset-2 col-xs-offset-2");
					document.getElementById("optionsDiv").setAttribute("class", "noPadding col-sm-8 col-lg-8 col-md-8 col-xs-8 col-sm-offset-2 col-lg-offset-2 col-md-offset-2 col-xs-offset-2");
				}
			}
			else{
				$("#subDiv"+ i).data('ans',Sequence.imageArr[0].imgname + i + Sequence.imageArr[0].imgtype);
				//$("#innerDiv" + i).data('answer', Sequence.alphabetsArray[i-1]);
					$("#sequenceImg" + i).prop("src", Utils.Path + Sequence.imageArr[0].imgname + i + Sequence.imageArr[0].imgtype);
					$("#optionImg" + i).prop("src", Utils.Path + Sequence.imageArr[0].imgname + i + Sequence.imageArr[0].imgtype);
			}
		}
}
Sequence.getOptionImg=function(obj)
{
	Sequence.attemptFlag=true;
	$(".Blink_me").removeClass("Blink_me");
	dataImg=$("#"+obj).data("ans");
	dataNumber=$("#"+obj).data("answer");
	$("#"+obj).css({"pointer-events":"none"})
	$("#"+obj).children().css({"visibility":"hidden","pointer-events":"none"})
	//alert($("#"+obj).children().prop("id"));
	$("#subOptionDiv"+Sequence.blinkCounter).data("answer",dataNumber);
	$("#optionImg"+Sequence.blinkCounter).prop("src", Utils.Path + dataImg);
	$("#optionImg"+Sequence.blinkCounter).css({"visibility":"visible"});
	Sequence.blinkCounter++;
	$("#subOptionDiv"+Sequence.blinkCounter).addClass("Blink_me");
}
Sequence.setOptionImg=function(object)
{
	$(".Blink_me").removeClass("Blink_me");
	Sequence.blinkCounter=$("#"+object).data("numData");
	$("#subOptionDiv"+Sequence.blinkCounter).addClass("Blink_me");
}

Sequence.checkAnswer = function ()	// check Answer
{
	var labelArray=[];
	var counter = 0;
	//$("#check,#answerDiv").css("pointer-events","none");
	answerDiv = document.getElementById('answerDiv');
	for (var i = 1; i <= Sequence.no; i++)
	{
		if ($('#subOptionDiv' + i).data('answer') === Sequence.Images[langIndex].nodeInfo[Sequence.randomIndex].ansArray[i-1])
			counter++;		// ans count
		labelArray.push($('#subOptionDiv' + i).data('answer'));
	}
	console.log(labelArray);
	console.log(labelArray.length);
	label="";
	for(var l=0;l<Sequence.blinkCounter-1;l++)
	{
		if(l==0)
			label=label+" "+labelArray[l];
		else
			label=label+", "+labelArray[l];
	}
	if(Sequence.blinkCounter==1)
		label="null";
	if (counter == Sequence.no)
		scoredMarks="2";
	else									//FALSE
		scoredMarks="1";
}
Sequence.nextQue=function()		//NEXT CLICK
{
	Sequence.nextClick++;
	if(Sequence.nextClick==1)
		Sequence.blinkCounter=1;
	$(".Blink_me").removeClass("Blink_me");
	if(!Sequence.exampleFlag)
	{
		Sequence.exampleFlag=true;
		Sequence.imageArr = Sequence.Images[langIndex].nodeInfo.slice();	//image data
		Sequence.no=Sequence.Images[langIndex].nodeInfo[Sequence.randomIndex].imgCount;
		document.getElementById("heading").innerHTML=Sequence.Images[langIndex].nodeInfo[Sequence.randomIndex].queText;
		$("#heading").css("font-size","1.5vw");
		$("#queNo").text(Sequence.Images[langIndex].nodeInfo[Sequence.randomIndex].gameName);
		document.getElementById('answerDiv').innerHTML = "";//
		document.getElementById('optionsDiv').innerHTML = "";
		answerDiv = document.getElementById('answerDiv');
		Sequence.createDivs(answerDiv, Sequence.no , 'drop', 'dropClass');
		Sequence.createDivs(optionsDiv, Sequence.no , 'options', 'dropClass');
		Sequence.addInsideImages();
		if(Sequence.Images[langIndex].nodeInfo[Sequence.randomIndex].gameName=="M15A" || Sequence.Images[langIndex].nodeInfo[Sequence.randomIndex].gameName=="M20A")
			$("#mainDiv").css("marginTop","15vh");
		else
			$("#mainDiv").css("marginTop","5vh");
	}
	else
	{
		if (Sequence.attemptFlag)
			Sequence.checkAnswer();
		else
			scoredMarks="0";
		//	$('body').css('pointer-events', 'none');
		Sequence.calculateScore();
	}
}

function allowDrop(event) {
	event.preventDefault();
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
	$(".Blink_me").removeClass("Blink_me");
	Sequence.blinkCounter=1;
	label="null";
	document.getElementById('answerDiv').innerHTML = "";
	document.getElementById('optionsDiv').innerHTML = "";
	answerDiv = document.getElementById('answerDiv');
	Sequence.createDivs(answerDiv, Sequence.no , 'drop', 'dropClass');
	Sequence.createDivs(optionsDiv, Sequence.no , 'options', 'dropClass');
	Sequence.addInsideImages();
}
Sequence.calculateScore = function () {
	console.log(scoredMarks,startTime,label);
	if (Utils.mobileDeviceFlag)
		Android.gotoNextGame(scoredMarks,startTime,label);
//	alert("ScoredMarks="+scoredMarks+","+" "+"Label = "+label);
}