//startingDate:17-02-2021
var N1A = {};
var Utils = {};
Utils.Path = '';
Utils.mobileDeviceFlag = false;
var starttime = "", scoredmarks = "0", label = 'null';
N1A.langCtr = 2;
var startYear = 2000;
var endYear = 2020;
var month = 0;
var year = 0;
var Months = ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"];
var daysArray = [["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"], ["रविवार", "सोमवार", "मंगलवार", "बुधवार", "गुरुवार", "शुक्रवार", "शनिवार"], ["Jumapili", "Jumatatu", "Jumanne", "Jumatano", "Alhamisi", "Ijumaa", "Jumamosi"], ["Jumapili", "Jumatatu", "Jumanne", "Jumatano", "Alhamisi", "Ijumaa", "Jumamosi"], ["اتوار", "سوموار", "منگل", "بدھ", "جمعرات", "جمعہ", "ہفتہ"], ["Domingo", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado"], ["Domingo", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado"], ["রবিবার", "সোমবার", "মঙ্গলবার", "বুধবার", "বৃহস্পতিবার", "শুক্রবার", "শনিবার"], ["Dimanche", "Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi"], ["Dimanche", "Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi"], ["आइतबार", "सोमबार", "मंगलबार", "बुधबार", "बिहीबार", "शुक्रबार", "शनिबार"], ["Domingo", "Segunda-feiraTerça-feira", "Quarta-feira", "Quinta-feira", "Sexta-feira", "Sábado"]];
var ansTextArr = ["Answer", "उत्तर", "Jawabu", "Jawabu", "جواب", "Respuesta", "Respuesta", "উত্তর", "Réponse", "Réponse", "जवाफ", "Resposta"];
var ansKeyTextArr = ["Answer", "उत्तर", "Jawabu", "Jawabu", "جواب", "Respuesta", "Respuesta", "উত্তর", "Réponse", "Réponse", "जवाफ", "Resposta"];

$(document).ready(function () {
	if ((navigator.userAgent.match(/Android|BlackBerry|iPhone|iPad|iPod|Opera Mini|IEMobile/i)) && !(window.location.href.includes('http')))
		Utils.mobileDeviceFlag = true;
	/* if(Utils.mobileDeviceFlag) 
		Utils.Path=Android.getMediaPath("N1A");  */
	setTimeout(function () {
		N1A.init();
	}, 100);
});

N1A.init = function () {
	document.title = Object.values(N1A.AcknowledgementPageData)[0];
	//document.body.style.backgroundColor = "white";
	$("#gamepage").show();
	N1A.initializeVariables();
	//N1A.setAllImages();
	createNumberDivs("numPad");
	N1A.playGame();
	N1A.addDays();

}

N1A.initializeVariables = function () {
	N1A.level = 0;
}
N1A.setAllImages = function () {
	//document.getElementById("logoImg").src = Utils.Path + "images/skin/logo.png";
	//document.getElementById("submit").src = Utils.Path + "images/skin/Submit.png";
	//document.getElementById("nextImage").src = Utils.Path + "images/skin/Next.png";
}
N1A.createOptions = function () {
	parentDiv = document.getElementById("optionDiv");
	for (i = 0; i < 4; i++) {
		optionDiv = document.createElement("DIV");
		optionDiv.setAttribute("id", "optionDiv" + i);
		optionDiv.setAttribute("class", "options noPadding col-xs-2 col-md-2 col-lg-2 col-sm-2 col-xs-offset-2 col-md-offset-1 col-lg-offset-1 col-sm-offset-1")
		optionDiv.setAttribute("onclick", "N1A.checkAnswer(this.id);")
		optionDiv.style.backgroundImage = "url(" + Utils.Path + "images/skin/gridBox.png";
		parentDiv.appendChild(optionDiv);
	}
}
N1A.playGame = function () {
	var data;
	d = new Date();
	starttime = d.getDate() + "-" + (d.getMonth() + 1) + "-" + d.getFullYear() + " " + d.getHours() + ":" + d.getMinutes() + ":" + d.getSeconds();
	if (Utils.mobileDeviceFlag) {
		var val = Android.getGameLang();		//GET ANDROID GAME LANGUAGE
		/*  var val = 'ENGLISH' */
		var lang = N1A.questions.find(checkLang);
		N1A.langCtr = N1A.questions.indexOf(lang);
		function checkLang(i) {
			if (i.lang.toLowerCase() == val.toLowerCase())
				return i;
		}
		var val = Android.getGameID();
		data = N1A.questions[N1A.langCtr].data.find(checkIndex);
		N1A.level = N1A.questions[N1A.langCtr].data.indexOf(data);
		function checkIndex(i) {
			if (i.queNo == val)
				return i;
		}
	}
	else
		N1A.level = Math.floor(Math.random() * N1A.questions[N1A.langCtr].data.length);
	if (N1A.level == 2 || N1A.level == 3) {
		$("#DvCalenderCont").show();
		$("#questionAndAnsDiv").hide();
		$("#modalIcon").css("visibility", "hidden");
		$(".dayName").css("pointer-events", "none");
		InitActivity();
		if (N1A.level == 3)
			$("#answerKeyText").css("visibility", "visible");
	}
	else {
		$("#questionAndAnsDiv").show();
		$("#DvCalenderCont").hide();
	}
	N1A.setQuestion();
	if (N1A.questions[N1A.langCtr].languageFont != null)
		setFontFamilyForLang(N1A.questions[N1A.langCtr].languageFont);

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

N1A.setQuestion = function () {
	rno = Math.floor(Math.random() * N1A.questions[N1A.langCtr].data.length);
	img = N1A.questions[N1A.langCtr].data[N1A.level].image;
	N1A.answer = N1A.questions[N1A.langCtr].data[N1A.level].answer;
	document.getElementById("answerKeyText").innerHTML = ansKeyTextArr[N1A.langCtr] + " : "
	$("#answerKeyText").append(N1A.answer);
	$("#inputText").text("");

	document.getElementById("questionImg").src = Utils.Path + "images/" + img;
	document.getElementById("queNo").innerHTML = N1A.questions[N1A.langCtr].data[N1A.level].queNo;
	document.getElementById("heading").innerHTML = N1A.questions[N1A.langCtr].data[N1A.level].questionText;
	document.getElementById("uttarText").innerHTML = ansTextArr[N1A.langCtr] + " :";
	if (N1A.level >= 4)
		document.getElementById("heading").style.fontSize = "1.3vw";
	else
		document.getElementById("heading").style.fontSize = "1.6vw";
	if (N1A.langCtr == 4) {
		document.getElementById("heading").style.direction = "rtl";
	}
	$('#heading').parent().css('font-weight', 'unset');


}
N1A.showNumberSystem = function () {
	$("#numberpadDiv").show();
	$("#numberpadDiv").addClass("animated zoonIn");
}

displayNumber = function (element) {//inputs the number in selected textbox when user clicks the number on numberpad.
	N1A.attemptFlag = true;
	if ($("#AnswerDiv").text().length < 4) {
		$("#AnswerDiv").append($(element).text());
		$("#submit").css("pointer-events", "auto");
	}
	label = $("#AnswerDiv").text();
}

N1A.checkAnswer = function () {
	//$("#AnswerDiv").css("pointer-events", "none");
	$("#numberpadDiv").hide();
	//$("#nextImgDiv").addClass("blink_me");
	if (N1A.level == 0) {
		if ($("#inputText").text() == '') {
			showModal();
		}
		else {

			scoredmarks = $("#inputText").text();

			//document.getElementById("playSound").play();
			console.log(scoredmarks, starttime, label);
			// alert("ScoredMarks = " + scoredmarks + "," + " " + "Label = " + label);
			// $("#inputText").text("");

			if (Utils.mobileDeviceFlag)
				Android.gotoNextGame(scoredmarks, starttime, label);
		}
	}
	else {
		console.log(scoredmarks, starttime, label);
		// alert("ScoredMarks = " + scoredmarks + "," + " " + "Label = " + label);
		$("#inputText").text("");

		if (Utils.mobileDeviceFlag)
			Android.gotoNextGame(scoredmarks, starttime, label);
	}

}
N1A.onNextClick = function () {
}

N1A.nextQuestion = function () {
	$("#submit").css("pointer-events", "none");
	$("#nextImgDiv").removeClass("blink_me");
	$("AnswerDiv").css("pointer-events", "auto");
	document.getElementById("AnswerDiv").style.color = "black";
	clearText();
	if (N1A.level == 0) {
		N1A.level = 1;
		N1A.setQuestion();
		N1A.setOptions();
	}
	else {

	}
}

N1A.shuffle = function (array) {
	var ctr = array.length, temp, index;
	while (ctr > 0) {
		index = Math.floor(Math.random() * array.length);
		ctr--;
		temp = array[ctr];
		array[ctr] = array[index];
		array[index] = temp;
	}
}

N1A.closeNumberSystem = function () {
	$("#numberpadDiv").hide();
}
clearText = function () {
	($("#AnswerDiv")).text("");
}
hideQuestion = function () {
	$("#myModal").hide();
	$("#questioMark").show();
}
showQues = function () {
	$("#myModal").show();
	$("#questioMark").hide();
}

resetGame = function () {
	ResetAllDays();
	N1A.attemptFlag = false;
	clearText();
	N1A.closeNumberSystem();
}

N1A.addDays = function () {
	for (i = 0; i < daysArray[N1A.langCtr].length; i++) {
		document.getElementById("DvDay" + i).innerHTML = daysArray[N1A.langCtr][i];
	}
}

function InitActivity() {
	//LoadScreen(0);
	var date = new Date();
	month = 9;
	year = 2019;
	document.getElementById("curMonth").innerHTML = N1A.hardCodedData.month[N1A.langCtr];
	document.getElementById("curYear").innerHTML = year;
	loadCalendarMonths();
	loadCalendarYears();
	loadCalendarDays();
	//ReadyQuestions();
	$(".day").mousedown(function (e) { HandleDayMouseDown(e) });
}

function loadCalendarMonths() {
	for (var i = 0; i < Months.length; i++) {
		var doc = document.createElement("div");
		doc.innerHTML = Months[i];
		doc.classList.add("dropdown-item");
		doc.onclick = (function () {
			var selectedMonth = i;
			return function () {
				month = 9;
				document.getElementById("curMonth").innerHTML = Months[month] + " 2021";
				loadCalendarDays();
				return month;
			}
		})();
		document.getElementById("months").appendChild(doc);
	}
}

function loadCalendarYears() {
	document.getElementById("years").innerHTML = "";
	for (var i = startYear; i <= endYear; i++) {
		var doc = document.createElement("div");
		doc.innerHTML = i;
		doc.classList.add("dropdown-item");

		doc.onclick = (function () {
			var selectedYear = i;
			return function () {
				year = selectedYear;
				document.getElementById("curYear").innerHTML = year;
				loadCalendarDays();
				return year;
			}
		})();
		document.getElementById("years").appendChild(doc);
	}
}

function loadCalendarDays() {
	document.getElementById("calendarDays").innerHTML = "";
	var tmpDate = new Date(year, month, 0);
	var num = daysInMonth(month, year);
	var dayofweek = tmpDate.getDay();       // find where to start calendar day of week
	for (var i = 0; i <= dayofweek; i++) {
		var d = document.createElement("div");
		d.classList.add("day");
		d.classList.add("blank");
		document.getElementById("calendarDays").appendChild(d);
	}
	for (var i = 0; i < num; i++) {
		var tmp = i + 1;
		var d = document.createElement("div");
		d.id = "calendarday_" + i;
		d.className = "day";
		d.innerHTML = tmp;
		document.getElementById("calendarDays").appendChild(d);
	}
	var clear = document.createElement("div");
	clear.className = "clear";
	document.getElementById("calendarDays").appendChild(clear);
}

function daysInMonth(month, year) { var d = new Date(year, month + 1, 0); return d.getDate(); }

function GetDayName(DayId) { return ArrDay[DayId]; }

function HandleNextQues(e) {
	GData.QuesCount++;
	LoadNextQuestion();
};

function HandleDayMouseDown(e) {
	ResetAllDays();
	//console.log($("#"+e.target.id).html());
	$("#" + e.target.id).addClass("ClsSelectedDay");
	//GData.SelAnsObj.SelectedID = e.target.id;
	if ($("#" + e.target.id).text() == N1A.answer) {
		scoredmarks = "2";
	}
	else
		scoredmarks = "1";
	label = $("#" + e.target.id).text();

}

function HandleDayNameMouseDown(e) {
	ResetAllDays();
	//console.log($("#"+e.target.id).html());
	$("#" + e.target.id).addClass("ClsSelectedDay");
	if ($("#" + e.target.id).text() == N1A.answer) {
		scoredmarks = "2";
	}
	else
		scoredmarks = "1";
	label = $("#" + e.target.id).text();

}
function ResetAllDays() {
	$("#calendarDays div").each(function (i) {
		//var ThisID = this.id;
		//console.log(ThisID);
		$(this).removeClass("ClsSelectedDay");
		$(this).removeClass("ClsWrongSelect");
		$(this).removeClass("ClsRightSelect");
	});

	$("#DvDays div").each(function (i) {
		//var ThisID = this.id;
		//console.log(ThisID);
		$(this).removeClass("ClsSelectedDay");
		$(this).removeClass("ClsWrongSelect");
		$(this).removeClass("ClsRightSelect");
	});
}
