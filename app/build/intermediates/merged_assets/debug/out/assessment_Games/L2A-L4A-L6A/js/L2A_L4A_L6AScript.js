L2A_L4A_L6A = {};
var Utils = {};
Utils.Path = '';
Utils.mobileDeviceFlag = false;
var questionId = '', startTime = '', scoredMarks = '0', label = 'null', nodeIndex, langIndex;
$(document).ready(function () {
	if ((navigator.userAgent.match(/Android|BlackBerry|iPhone|iPad|iPod|Opera Mini|IEMobile/i)) && !(window.location.href.includes('http')))
		Utils.mobileDeviceFlag = true;
	$('.modal').css('padding', '0');
	$('#queNo').css('font-size', '1.8vw')
	showQues();
	L2A_L4A_L6A.getGameCode();					//get code from url
});
function showQues() {
	$('#questioMark').hide();
	$('#myModal').css('display', 'block');
}
function hideQuestion() {
	$('#questioMark').show();
	$('#myModal').css('display', 'none');
}
L2A_L4A_L6A.getGameCode = function () {
	var d;
	d = new Date();
	startTime = d.getDate() + "-" + (d.getMonth() + 1) + "-" + d.getFullYear() + " " + d.getHours() + ":" + d.getMinutes() + ":" + d.getSeconds();
	if (Utils.mobileDeviceFlag) {
		var val = Android.getGameLang();		//GET ANDROID GAME LANGUAGE
		//var val = 'Urdu-Pakistan'
		var lang = L2A_L4A_L6A.Data.find(checkIndex);
		langIndex = L2A_L4A_L6A.Data.indexOf(lang);
		if (lang.language == 'Urdu-Pakistan')
			$('#heading').css('direction', 'rtl')
		function checkIndex(i) {
			if (i.language.toLowerCase().trim() == val.toLowerCase().trim())
				return i;
		}
	}
	else
		langIndex = 8/* Math.floor(Math.random() * L2A_L4A_L6A.Data.length);		//GET RANDOM GAME LANGUAGE */
	if (Utils.mobileDeviceFlag) {
		var val = Android.getGameID();		//GET GAME CODE
		//val = 'N13A'
		var data = L2A_L4A_L6A.Data[langIndex].nodeInfo.find(checkIndex);
		nodeIndex = L2A_L4A_L6A.Data[langIndex].nodeInfo.indexOf(data);

		function checkIndex(i) {
			if (i.gameCode == val)
				return i;
		}
	}
	else
		nodeIndex = Math.floor(Math.random() * L2A_L4A_L6A.Data[langIndex].nodeInfo.length);

	$('#queNo').text(L2A_L4A_L6A.Data[langIndex].nodeInfo[nodeIndex].gameCode);
	questionId = L2A_L4A_L6A.Data[langIndex].nodeInfo[nodeIndex].gameCode;

	$('#heading').css('font-size', '1.6vw');
	$('#heading').parent().css('font-weight', 'unset');
	$('#modalIcon').css('visibility', 'visible');
	$('.question').show();
	$('.question').css({ 'background-color': 'transparent', 'padding': '3vw' })
	if (L2A_L4A_L6A.Data[langIndex].nodeInfo[nodeIndex].gameCode.includes('L2')) {
		$('#gamepage').css({ 'justify-content': 'unset' })
		$('.question').addClass(' col-lg-4 col-md-4 col-xs-4 col-sm-4 col-lg-offset-4 col-md-offset-4 col-xs-offset-4 col-sm-offset-4')
		var img = document.createElement('img');
		$(img).prop('class', 'img-responsive col-xs-12 col-sm-12 col-md-12 col-lg-12');
		$(img).prop('src', 'images/' + L2A_L4A_L6A.Data[langIndex].nodeInfo[nodeIndex].question);
		$('.question').append(img);
		$('.question').css('padding', '0%')
		if (L2A_L4A_L6A.Data[langIndex].nodeInfo[nodeIndex].correctAns != undefined) {
			$('#answerKeyText').css('visibility', 'visible');
			$('#answerKeyText').text(L2A_L4A_L6A.Data[langIndex].ansText);
			$('#answerKeyText').append(' ' + L2A_L4A_L6A.Data[langIndex].nodeInfo[nodeIndex].correctAns);
		}

	}
	else
		$('.question').text(L2A_L4A_L6A.Data[langIndex].nodeInfo[nodeIndex].question);
	document.getElementById("heading").innerHTML = L2A_L4A_L6A.Data[langIndex].nodeInfo[nodeIndex].instruction;
	if (L2A_L4A_L6A.Data[langIndex].languageFont != null)
		setFontFamilyForLang(L2A_L4A_L6A.Data[langIndex].languageFont);
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

L2A_L4A_L6A.checkAnswer = function () {
	scoredMarks = '0';
	if (clickOption != '') {
		scoredMarks = clickOption;
		L2A_L4A_L6A.nextQue();
	}
	else
		showModal()

}
resetGame = function () {
	clickOption = '';
	label = 'null';
	$('.codeCls').css('border', '2px solid rgb(102 98 85)');
}
L2A_L4A_L6A.nextQue = function () {
	// L2A_L4A_L6A.checkAnswer();
	console.log(scoredMarks, startTime, label);
	//	alert("ScoredMarks = " + scoredMarks +","+" "+"Label = " +label);
	if (Utils.mobileDeviceFlag)
		Android.gotoNextGame(scoredMarks, startTime, label);
}