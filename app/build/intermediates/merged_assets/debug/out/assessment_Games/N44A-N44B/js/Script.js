var CountBottles = {};
var Utils = {};
Utils.Path = '';
Utils.mobileDeviceFlag = false;
CountBottles.attemptFlag = false;
CountBottles.givenAnswer = '';
var startTime = '';
var label = "null";
var ansTextArr = ["Answer", "उत्तर", "Jawabu", "Jawabu", "جواب", "Respuesta", "Respuesta", "উত্তর", "Réponse", "Réponse", "जवाफ", "Resposta"];
var ansKeyTextArr = ["Answer", "उत्तर", "Jawabu", "Jawabu", "جواب", "Respuesta", "Respuesta", "উত্তর", "Réponse", "Réponse", "जवाफ", "Resposta"];


langCtr = 11;
len = 2;
$(document).ready(function () {
	$(".se-pre-con").fadeOut("slow");
	if ((navigator.userAgent.match(/Android|BlackBerry|iPhone|iPad|iPod|Opera Mini|IEMobile/i)) && !(window.location.href.includes('http')))
		Utils.mobileDeviceFlag = true;
	else
		Utils.mobileDeviceFlag = false;

	setTimeout(function () {
		$('#coverPage,#homeAndLogoDiv').show();
		$('#questioMark').hide();
		$('#myModal').css('display', 'block');
		CountBottles.setImages();
		CountBottles.init();
	}, 200);
});

function showQues() {
	$('#questioMark').hide();
	$('#myModal').css('display', 'block');
}

function hideQuestion() {
	$('#questioMark').show();
	$('#myModal').css('display', 'none');
}

CountBottles.init = function () {
	$('#gamePage,#numberSystemDiv').hide();
	$('#inputText').text('');
	$(document).prop("title", CountBottles.hardcodedata.NameoftheGame);
	createNumberpad();
	CountBottles.playGame();
}

CountBottles.setImages = function () {

}

CountBottles.playGame = function () {
	$('#gamePage,#nextDiv').show();//call reset function


	if (Utils.mobileDeviceFlag) {
		var val = Android.getGameLang();		//GET ANDROID GAME LANGUAGE
		/*  var val = 'ENGLISH' */
		var lang = CountBottles.data.find(checkLang);
		langCtr = CountBottles.data.indexOf(lang);
		function checkLang(i) {
			if (i.language.toLowerCase() == val.toLowerCase())
				return i;
		}
		var val = Android.getGameID();
		data = CountBottles.data[langCtr].gamedata.find(checkIndex);
		gameNo = CountBottles.data[langCtr].gamedata.indexOf(data);
		function checkIndex(i) {
			if (i.gamecode == val)
				return i;
		}
		CountBottles.currentNode = CountBottles.data[langCtr].gamedata[gameNo];
		randomGame = CountBottles.currentNode.gamecode;
	}
	else {
		gameNo = Math.floor(1 + Math.random() * CountBottles.data[langCtr].gamedata.length - 1);
		CountBottles.currentNode = CountBottles.data[langCtr].gamedata[gameNo];
		randomGame = CountBottles.currentNode.gamecode;
	}
	if (gameNo == 1) {
		$("#directCoding").show()
		$("#ansKeypadDiv").hide();
	}
	// 	for(var i=0;i<CountBottles.data.length;i++){
	// 	if(randomGame == CountBottles.data[i].gamecode){
	// 		CountBottles.currentGame = CountBottles.data[i];
	// 	}
	// }

	$('#answerText').text(ansTextArr[langCtr] + " : ");
	$('#answerKeyText').text(ansKeyTextArr[langCtr] + " : ");
	$("#answerKeyText").append(CountBottles.currentNode.answer);
	$('#queNo').text(CountBottles.currentNode.gamecode);
	document.getElementById('heading').innerHTML = CountBottles.currentNode.instruction;
	if (langCtr == 4) {
		document.getElementById("heading").style.direction = "rtl";
	}
	$('#heading').parent().css('font-weight', 'unset');
	// CountBottles.createNumberDivs(numberSystemDiv,0)
	CountBottles.showQuestion();
	if (CountBottles.data[langCtr].languageFont != null)
		setFontFamilyForLang(CountBottles.data[langCtr].languageFont);

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
CountBottles.showQuestion = function () {
	var d = new Date();
	startTime = d.getDate() + "-" + (d.getMonth() + 1) + "-" + d.getFullYear() + " " + d.getHours() + ":" + d.getMinutes() + ":" + d.getSeconds();
	//$('#bottles').prop('src',Utils.Path+'images/'+CountBottles.currentGame.bottles);
	//$('#brokenbottles').prop('src',Utils.Path+'images/'+CountBottles.currentGame.brokenbottles);
	$('#bottlesImg').prop('src', Utils.Path + 'images/' + CountBottles.currentNode.image);
};

function createNumberpad() {
	numberSystemDiv = document.createElement('div');
	$(numberSystemDiv).prop('id', 'numberSystemDiv');
	$(numberSystemDiv).prop('class', 'col-lg-12 col-md-12 col-xs-12 col-sm-12 ');
	$(".keyPad").append(numberSystemDiv);
	// $('#numberSystemDiv').hide();
	createNumberDivs('numberSystemDiv')
}

CountBottles.resetGame = function () {
	CountBottles.clearText();
	CountBottles.attemptFlag = false;
	$('.selection').removeClass('selection');
	CountBottles.givenAnswer = 'null';
};

CountBottles.checkAnswer = function () {
	if (CountBottles.givenAnswer.length == 0) {
		showModal();
	}
	else {
		score = CountBottles.givenAnswer;
		//alert("ScoredMarks = " + score + "," + " " + "Label = " + CountBottles.givenAnswer);
		console.log(score, startTime, label);
		if (Utils.mobileDeviceFlag)
			Android.gotoNextGame(score, startTime, label);
	}
};

CountBottles.showNextGame = function () {
	CountBottles.givenAnswer = $("#inputText").text();
	CountBottles.checkAnswer();
	$('body').css('pointer-events', 'auto')
};





