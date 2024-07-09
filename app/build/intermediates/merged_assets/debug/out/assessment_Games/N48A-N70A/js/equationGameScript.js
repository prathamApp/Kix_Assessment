var Equation = {};
var Utils = {};
Utils.Path = '';
Utils.mobileDeviceFlag = false;
Equation.imagesArr = [];
Equation.OptionsArr = [];
Equation.answer = 0;
Equation.givenAnswer = 'null';
Equation.attemptFlag = false;
len = 2;
langCtr = 2;
label = "null";
var ansTextArr = ["Answer", "उत्तर", "Jawabu", "Jawabu", "جواب", "Respuesta", "Respuesta", "উত্তর", "Réponse", "Réponse", "जवाफ", "Resposta"];
var ansKeyTextArr = ["Answer", "उत्तर", "Jawabu", "Jawabu", "جواب", "Respuesta", "Respuesta", "উত্তর", "Réponse", "Réponse", "जवाफ", "Resposta"];

var questionId = 0, startTime = 0, scoredMarks = 0, totalMarks = 10, resId = 0;

$(document).ready(function () {
	$(".se-pre-con").fadeOut("slow");
	if ((navigator.userAgent.match(/Android|BlackBerry|iPhone|iPad|iPod|Opera Mini|IEMobile/i)) && !(window.location.href.includes('http')))
		Utils.mobileDeviceFlag = true;
	else
		Utils.mobileDeviceFlag = false;

	setTimeout(function () {
		$('#questioMark').hide();
		$('#myModal').css('display', 'block');
		Equation.init();
	}, 100);
}, 200);

Equation.init = function () {
	$(document).prop("title", Equation.hardcoredata.NameoftheGame);
	$('#scoreDiv').css('visibility', 'visible');
	$('#gamePage,#endPage').hide();
	$("#inputText").text('');
	Equation.setImages();
	Equation.playGame();
}

function showQues() {
	$('#questioMark').hide();
	$('#myModal').css('display', 'block');
}

function hideQuestion() {
	$('#questioMark').show();
	$('#myModal').css('display', 'none');
}

// set Images//
Equation.setImages = function () {

}
//function which executes on play button click
Equation.playGame = function () {
	$('#logoImage,#gamePage').show();
	createNumberpad();
	Equation.showQuestion();
}
//function which gets call on next question
Equation.showQuestion = function () {
	var d = new Date();
	startTime = d.getDate() + "-" + (d.getMonth() + 1) + "-" + d.getFullYear() + " " + d.getHours() + ":" + d.getMinutes() + ":" + d.getSeconds();
	if (Utils.mobileDeviceFlag) {
		var val = Android.getGameLang();		//GET ANDROID GAME LANGUAGE
		/*  var val = 'ENGLISH' */
		var lang = Equation.data.find(checkLang);
		langCtr = Equation.data.indexOf(lang);
		function checkLang(i) {
			if (i.language.toLowerCase() == val.toLowerCase())
				return i;
		}
		var val = Android.getGameID();
		data = Equation.data[langCtr].gamedata.find(checkIndex);
		gameNo = Equation.data[langCtr].gamedata.indexOf(data);
		function checkIndex(i) {
			if (i.gamecode == val)
				return i;
		}
		Equation.currentNode = Equation.data[langCtr].gamedata[gameNo];
		randomType = Equation.currentNode.gamecode;

	} else {
		randomGame = Math.floor(1 + Math.random() * Equation.data[langCtr].gamedata.length - 1);
		randomType = Equation.data[langCtr].gamedata[randomGame].gamecode;
	}
	if (randomType == "N70A" || randomType == "N48A") {
		$('#question').prop('class', 'noPadding text-center col-xs-6 col-sm-6 col-md-6 col-lg-6 col-sm-offset-3 col-lg-offset-3 col-md-offset-3 col-xs-offset-3');
	}
	if ((langCtr == 8 || langCtr == 9) && randomType == "N70A")
		$("#questionImg").css("height", "55vh");
	$('#answerText').text(ansTextArr[langCtr] + " : ");
	// $('#answerText').text(Equation.data[langCtr].answerText);
	$('#answerKeyText').text(ansKeyTextArr[langCtr] + " : ");
	Equation.currentNode = Equation.data[langCtr].gamedata.find(el => el.gamecode === randomType)
	if (Equation.currentNode.type == 'vertical') {
		$('#horizontal').hide()
		$('#' + Equation.currentNode.type).show()
		$('#questionImg').prop('src', Utils.Path + 'images/' + Equation.currentNode.image);
	} else {
		$('#vertical').hide()
		$('#' + Equation.currentNode.type).show();
		$('#' + Equation.currentNode.operand1Id).text(Equation.currentNode.operand1);
		$('#' + Equation.currentNode.operand2Id).text(Equation.currentNode.operand2);
		$('#' + Equation.currentNode.operatorId).text(Equation.currentNode.operator);
	}
	$("#answerKeyText").append(Equation.currentNode.answer);
	$('#queNo').text(Equation.currentNode.gamecode);
	document.getElementById('heading').innerHTML = Equation.currentNode.instruction;
	Equation.answer = Equation.currentNode.answer;
	$('#heading').parent().css('font-weight', 'unset');

	if (langCtr == 4) {
		document.getElementById("heading").style.direction = "rtl";
	}
	if (Equation.data[langCtr].languageFont != null)
		setFontFamilyForLang(Equation.data[langCtr].languageFont);

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
//function which executes on home button click
Equation.goToHome = function () {
	location.reload();
}
function createNumberpad() {
	numberSystemDiv = document.createElement('div');
	$(numberSystemDiv).prop('id', 'numberSystemDiv');
	$(numberSystemDiv).prop('class', 'col-lg-12 col-md-12 col-xs-12 col-sm-12 ');
	$(".keyPad").append(numberSystemDiv);
	// $('#numberSystemDiv').hide();
	createNumberDivs('numberSystemDiv')
}

Equation.resetGame = function () {
	Equation.attemptFlag = false;
	Equation.clearText()
	Equation.givenAnswer = 'null';
};

//function which executes on clear btn
Equation.clearText = function () {
	$("#" + Equation.currentNode.answerId).text('');
};

//function which generates x & y values
Equation.generateQuestion = function (limit, operator, type) {
	/*let limit2,unitPlace1,unitPlace2;

	Equation.opr1=Math.floor(1 +Math.random()*((limit)-1));
	limit2=limit-Equation.opr1;
	Equation.opr2=Math.floor(1 +Math.random()*((limit2/2)-1));

	unitPlace1=Equation.opr1%10;
	unitPlace2=Equation.opr2%10;

	switch(type){
		case 'withoutborrow':
			if(Equation.opr2 > Equation.opr1){
				let temp = Equation.opr2;
				Equation.opr2 = Equation.opr1;
				Equation.opr1= temp;
			}
			break;
		case 'borrow':
			while(((unitPlace1+unitPlace2)<10) || (unitPlace1>unitPlace2) || (unitPlace1==unitPlace2))
			{
				Equation.opr1=Math.floor(Math.random()*(limit-10+1)+10);
				limit2=limit-Equation.opr1;
				Equation.opr2=Math.floor(1 +Math.random()*((limit2/2)-1));
	
				unitPlace1=Equation.opr1%10;
				unitPlace2=Equation.opr2%10;
			}
			break;
	}
	
	Equation.answer=eval(Equation.opr1+operator+Equation.opr2);

	$('#operand1').text(Equation.opr1);
	$('#operator').text(operator);
	$('#operand2').text(Equation.opr2);

	
	unitPlace1=Equation.opr1%10;
	unitPlace2=Equation.opr2%10;
	
	switch(type){
		case 'withoutborrow':		
			while((unitPlace1+unitPlace2)>=10)
			{
				Equation.opr1=Math.floor(1 +Math.random()*((limit)-1));
				limit2=limit-Equation.opr1;
				Equation.opr2=Math.floor(1 +Math.random()*((limit2/2)-1));
	
				unitPlace1=Equation.opr1%10;
				unitPlace2=Equation.opr2%10;
			}
		break;
		case 'carry':
			while((unitPlace1+unitPlace2)<=10)
			{
				Equation.opr1=Math.floor(1 +Math.random()*((limit)-1));
				limit2=limit-Equation.opr1;
				Equation.opr2=Math.floor(1 +Math.random()*((limit2/2)-1));
	
				unitPlace1=Equation.opr1%10;
				unitPlace2=Equation.opr2%10;
			}
			break;
		case 'zero':
			while((Equation.opr1%10)!=0){
				Equation.opr1=Math.floor(1 +Math.random()*((limit)-1));
			}
			break;
	}*/
}


Equation.checkAnswer = function () {
	if (Equation.givenAnswer.length == 0) {
		showModal();
	}
	else {
		scoredMarks = Equation.givenAnswer;
		//	alert("ScoredMarks = " + scoredMarks + "," + " " + "Label = " + Equation.givenAnswer);
		console.log(scoredMarks, startTime, label);
		if (Utils.mobileDeviceFlag)
			Android.gotoNextGame(scoredMarks, startTime, label);
	}
};

//function android call to the next game
Equation.nextGame = function () {
	Equation.givenAnswer = clickOption;
	Equation.checkAnswer();
	$("body").css("pointer-events", "auto");
	// if(Utils.mobileDeviceFlag)
	// 	Android.GotoNextGame(); 
};
