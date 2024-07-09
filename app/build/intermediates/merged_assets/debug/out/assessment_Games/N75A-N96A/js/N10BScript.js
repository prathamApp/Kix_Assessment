//startingDate:17-02-2021
var N10B = {};
var Utils = {};
Utils.Path = '';
Utils.mobileDeviceFlag = false;
var starttime = 0, scoredMarks = "0", label = 'null';
var randomNum1 = 0, randomNum2 = 0;
N10B.langCtr = 2;
var ansTextArr = ["Answer", "उत्तर", "Jawabu", "Jawabu", "جواب", "Respuesta", "Respuesta", "উত্তর", "Réponse", "Réponse", "जवाफ", "Resposta"];
var ansKeyTextArr = ["Answer", "उत्तर", "Jawabu", "Jawabu", "جواب", "Respuesta", "Respuesta", "উত্তর", "Réponse", "Réponse", "जवाफ", "Resposta"];

$(document).ready(function () {
	if ((navigator.userAgent.match(/Android|BlackBerry|iPhone|iPad|iPod|Opera Mini|IEMobile/i)) && !(window.location.href.includes('http')))
		Utils.mobileDeviceFlag = true;
	/* if(Utils.mobileDeviceFlag) 
		Utils.Path=Android.getMediaPath("N10B");  */
	setTimeout(function () {
		N10B.init();
	}, 100);
});

N10B.init = function () {
	document.title = Object.values(N10B.AcknowledgementPageData)[0];
	//document.body.style.backgroundColor = "white";
	$("#gamePage").show();
	//document.body.style.backgroundImage = "url(" + Utils.Path + "images/skin/" + N10B.hardCodedData.cover_page;
	N10B.initializeVariables();
	N10B.setAllImages();
	createNumberDivs("numPad");
	N10B.playGame();
}

N10B.initializeVariables = function () {
	N10B.level = 0;
}
N10B.setAllImages = function () {
	document.getElementById("soundImg").src = Utils.Path + "images/skin/Sound.png";
	//document.getElementById("nextImage").src = Utils.Path + "images/skin/Next.png";
	// document.getElementById("submit").src = Utils.Path + "images/skin/Submit.png";
}
N10B.playGame = function () {
	d = new Date();
	starttime = d.getDate() + "-" + (d.getMonth() + 1) + "-" + d.getFullYear() + " " + d.getHours() + ":" + d.getMinutes() + ":" + d.getSeconds();
	if (Utils.mobileDeviceFlag) {
		var val = Android.getGameLang();		//GET ANDROID GAME LANGUAGE
		/*  var val = 'ENGLISH' */
		var lang = N10B.questions.find(checkLang);
		N10B.langCtr = N10B.questions.indexOf(lang);
		function checkLang(i) {
			if (i.lang.toLowerCase() == val.toLowerCase())
				return i;
		}
		var val = Android.getGameID();
		data = N10B.questions[N10B.langCtr].data.find(checkIndex);
		N10B.level = N10B.questions[N10B.langCtr].data.indexOf(data);

		function checkIndex(i) {
			if (i.queNo == val)
				return i;
		}
	}
	else
		N10B.level = Math.floor(Math.random() * N10B.questions[N10B.langCtr].data.length);
	N10B.setQuestion();
	//N10B.setOptions();
	if (N10B.questions[N10B.langCtr].languageFont != null)
		setFontFamilyForLang(N10B.questions[N10B.langCtr].languageFont);
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
N10B.setQuestion = function () {
	// if (N10B.level == 0) {
	// 	$("#questionDiv").show();
	// 	$("#outerDiv").hide();

	// }
	questionText = N10B.questions[N10B.langCtr].data[N10B.level].question;
	queNo = N10B.questions[N10B.langCtr].data[N10B.level].queNo;
	N10B.answer = N10B.questions[N10B.langCtr].data[N10B.level].answer;
	N10B.screenText = N10B.questions[N10B.langCtr].data[N10B.level].screenText;
	document.getElementById("answerKeyText").innerHTML = ansKeyTextArr[N10B.langCtr] + " : ";
	$("#answerKeyText").append(N10B.answer);
	$("#inputText").text("");

	document.getElementById("uttarText").innerHTML = ansTextArr[N10B.langCtr] + " :";
	document.getElementById("heading").innerHTML = questionText;
	document.getElementById("heading").style.fontSize = "1.8vw";
	document.getElementById("queNo").innerHTML = queNo;
	document.getElementById("questionDiv").innerHTML = N10B.screenText;
	if (N10B.langCtr == 4) {
		document.getElementById("heading").style.direction = "rtl";
		document.getElementById("questionDiv").style.direction = "rtl";

	}
	$('#heading').parent().css('font-weight', 'unset');

}

N10B.showNumberSystem = function () {
	$("#numberpadDiv").show();
	$("#numberpadDiv").addClass("animated zoonIn");
}


displayNumber = function (element) {//inputs the number in selected textbox when user clicks the number on numberpad.
	N10B.attemptFlag = true;
	if ($("#AnswerDiv").text().length < 4) {
		$("#AnswerDiv").append($(element).text());
		$("#submit").css("pointer-events", "auto");
	}
}

N10B.checkAnswer = function () {
	//label = document.getElementById("AnswerDiv").innerHTML;
	$("#AnswerDiv").css("pointer-events", "none");
	$("#numberpadDiv").hide();
	//$("#nextImgDiv").addClass("blink_me");
	if (clickOption == '') {
		showModal();
	}
	else {
		scoredmarks = clickOption;

		console.log(scoredmarks, starttime, label);
		// alert("ScoredMarks = " + scoredmarks + "," + " " + "Label = " + label);
		$("#inputText").text("");

		if (Utils.mobileDeviceFlag)
			Android.gotoNextGame(scoredmarks, starttime, label);
	}
}

N10B.onNextClick = function () {
}

N10B.nextQuestion = function () {
	$("#numberpadDiv").css("pointer-events", "auto");
	document.getElementById("AnswerDiv").style.color = "black";
	clearText();
	if (N10B.level <= 1) {
		N10B.level = N10B.level + 1;
		N10B.setQuestion();
		//N10B.setOptions();
	}
	else {
	}
}

resetGame = function () {
	($("#AnswerDiv")).text("");
	$("#numberpadDiv").hide();
	N10B.attemptFlag = false;
}

hideQuestion = function () {
	$("#myModal").hide();
	$("#questioMark").show();
}
showQues = function () {
	$("#myModal").show();
	$("#questioMark").hide();
}
