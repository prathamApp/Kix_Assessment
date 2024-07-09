WholeNum = {};
var Utils = {};
Utils.Path = '';
Utils.mobileDeviceFlag = false;
var questionId = '', startTime = '', scoredMarks = '', label = 'null', nodeIndex, langIndex;
WholeNum.selectedArr = [];		//img selected arr
N9B = [3, 5, 0, 7, 1, 9];
N11B = [25, 10, 19, 18, 11, 27];
N13B = [75, 30, 49, 52, 66, 87];
N15B = [206, 602, 499, 110, 660, 333];
$(document).ready(function () {
	if ((navigator.userAgent.match(/Android|BlackBerry|iPhone|iPad|iPod|Opera Mini|IEMobile/i)) && !(window.location.href.includes('http')))
		Utils.mobileDeviceFlag = true;
	$('.number').css('background-image', 'url("images/Card_01.png")');
	$('.modal').css('padding', '0');
	$('#queNo').css('font-size', '1.8vw')
	showQues();
	WholeNum.getGameCode();					//get code from url
});
function showQues() {
	$('#questioMark').hide();
	$('#myModal').css('display', 'block');
}
function hideQuestion() {
	$('#questioMark').show();
	$('#myModal').css('display', 'none');
}
WholeNum.getGameCode = function () {
	var d;
	d = new Date();
	startTime = d.getDate() + "-" + (d.getMonth() + 1) + "-" + d.getFullYear() + " " + d.getHours() + ":" + d.getMinutes() + ":" + d.getSeconds();
	if (Utils.mobileDeviceFlag) {
		var val = Android.getGameLang();		//GET ANDROID GAME LANGUAGE
		//var val = 'Urdu-Pakistan'
		var lang = WholeNum.Data.find(checkIndex);
		langIndex = WholeNum.Data.indexOf(lang);
		if (lang.language == 'Urdu-Pakistan')
			$('#heading').css('direction', 'rtl')
		function checkIndex(i) {
			if (i.language.toLowerCase().trim() == val.toLowerCase().trim())
				return i;
		}
	}
	else
		langIndex = 6;/* Math.floor(Math.random() * WholeNum.Data.length);		//GET RANDOM GAME LANGUAGE */
	if (Utils.mobileDeviceFlag) {
		var val = Android.getGameID();		//GET GAME CODE
		//val = 'N13A'
		var data = WholeNum.Data[langIndex].nodeInfo.find(checkIndex);
		nodeIndex = WholeNum.Data[langIndex].nodeInfo.indexOf(data);

		function checkIndex(i) {
			if (i.gameCode == val)
				return i;
		}
	}
	else
		nodeIndex = Math.floor(Math.random() * WholeNum.Data[langIndex].nodeInfo.length);

	$('#queNo').text(WholeNum.Data[langIndex].nodeInfo[nodeIndex].gameCode);
	questionId = WholeNum.Data[langIndex].nodeInfo[nodeIndex].gameCode;

	$('#heading').css('font-size', '1.6vw');
	document.getElementById("heading").innerHTML = WholeNum.Data[langIndex].nodeInfo[nodeIndex].langInstruction;
	if (questionId != 'N9A.1' && questionId != 'N9A.2' && questionId != 'N9A.3') {

		$('.gridSet').show();
		$('#resetDiv,#answerKeyText').css('visibility', 'visible');
		$('#clearDiv').css('visibility', 'hidden');
		$('.directCoding').hide();
		WholeNum.createGrid(1, 4);
		$('#answerKeyText').append(' ' + WholeNum.Data[langIndex].nodeInfo[nodeIndex].number)
	}
	else {
		$('#modalIcon').css('visibility', 'visible');
		$('.number').show();
		$('.number').text(WholeNum.Data[langIndex].nodeInfo[nodeIndex].number)
	}
	$('#heading').parent().css('font-weight', 'unset');
	if (WholeNum.Data[langIndex].languageFont != null)
		setFontFamilyForLang(WholeNum.Data[langIndex].languageFont);

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

WholeNum.createGrid = function (rows, cols) {
	$('.gridSet').prop('class', 'gridSet txtClass col-xs-8 col-sm-8 col-md-8 col-lg-8 col-sm-offset-2 col-lg-offset-2 col-md-offset-2 col-xs-offset-2 noPadding');

	var rowDiv, colDiv, cnt = 0, asciiCode = 65;
	for (let i = 0; i < rows; i++) {
		rowDiv = document.createElement('div');
		$(rowDiv).prop('class', 'col-lg-12 col-md-12 col-xs-12 col-sm-12');
		$(rowDiv).css({ 'display': 'flex', 'justify-content': 'space-between' });
		if (i == 0)
			$(rowDiv).css({ 'margin-bottom': '10vh' });
		$('.gridSet').append(rowDiv);
		for (let j = 0; j < cols; j++) {
			colDiv = document.createElement('div');
			$(colDiv).prop('class', 'codeCls gridNum col-lg-2 col-md-2 col-xs-2 col-sm-2 noPadding');

			/* 	switch (questionId.split('.')[0]) {
					case 'N9B':
						$(colDiv).text(N9B[cnt]);
						break;
					case 'N11B':
						$(colDiv).text(N11B[cnt]);
						break;
					case 'N13B':
						$(colDiv).text(N13B[cnt]);
						break;
					case 'N15B':
						$(colDiv).text(N15B[cnt]);
						break;
					default:
						break;
				} */
			$(colDiv).text(WholeNum.Data[langIndex].nodeInfo[nodeIndex].optns[cnt])
			$(colDiv).data('value', String.fromCharCode(asciiCode));
			$(colDiv).click(function () { WholeNum.clickOnGrid(this) })
			$(rowDiv).append(colDiv);
			cnt++;
			asciiCode++;
		}
	}
}
WholeNum.clickOnGrid = function (ele) {
	label = $(ele).text();
	clickOnCode(ele);
	$('.codeCls').css('border', '3px solid black');
	$(ele).css('border', '6px solid #ffbe00');
}
WholeNum.checkAnswer = function () {
	scoredMarks = '0';

	if (clickOption != '') {
		if (questionId != 'N9A.1' && questionId != 'N9A.2' && questionId != 'N9A.3') {
			if (clickOption == WholeNum.Data[langIndex].nodeInfo[nodeIndex].number)
				scoredMarks = '2';
			else
				scoredMarks = '1';
		}
		else
			scoredMarks = clickOption;
	}
}
resetGame = function () {
	clickOption = '';
	label = 'null';
	$('.codeCls').css('border', '3px solid black');
}
WholeNum.nextQue = function () {
	WholeNum.checkAnswer();
	console.log(scoredMarks, startTime, label);
	//alert("ScoredMarks = " + scoredMarks +","+" "+"Label = " +label);
	if (Utils.mobileDeviceFlag)
		Android.gotoNextGame(scoredMarks, startTime, label);
}