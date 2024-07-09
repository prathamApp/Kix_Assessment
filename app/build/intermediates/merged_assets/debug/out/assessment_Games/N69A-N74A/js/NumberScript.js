Numbers = {};
var Utils={};
Utils.Path='';
Utils.mobileDeviceFlag = false;
Numbers.attemptFlag = false;
var questionId = '', startTime = '', scoredMarks = '0', nodeIndex, label='null',langIndex,len=3;
$(document).ready(function()
{
	if((navigator.userAgent.match(/Android|BlackBerry|iPhone|iPad|iPod|Opera Mini|IEMobile/i)) && !(window.location.href.includes('http')))
		Utils.mobileDeviceFlag = true;
		$('#heading').css({ 'font-size': '1.7vw' });
	showQues();
	Numbers.getGameCode();					//get code from url
})
function showQues(){
    $('#questioMark').hide();
    $('#myModal').css('display','block');
}
function hideQuestion(){
    $('#questioMark').show();
    $('#myModal').css('display','none');
}
Numbers.getGameCode = function () {
	var d;
	d = new Date();
	startTime = d.getDate() + "-" + (d.getMonth() + 1) + "-" + d.getFullYear() + " " + d.getHours() + ":" + d.getMinutes() + ":" + d.getSeconds();
	if (Utils.mobileDeviceFlag) {
		var val = Android.getGameLang();		//GET ANDROID GAME LANGUAGE
		// var val = 'Urdu-Pakistan'
		var lang = Numbers.Data.find(checkIndex);
		langIndex = Numbers.Data.indexOf(lang);
		if (lang.language == 'Urdu-Pakistan')
			$('#heading').css('direction','rtl')
		function checkIndex(i) {
			if (i.language.toLowerCase().trim() == val.toLowerCase().trim())
				return i;
		}
	}
	else
		langIndex = 10;/* Math.floor(Math.random() * Numbers.Data.length);		//GET RANDOM GAME LANGUAGE */
	
	if (Utils.mobileDeviceFlag)
	{
		var val=Android.getGameID();		//GET GAME CODE
		//val = 'G11A'
		var data=Numbers.Data[langIndex].nodeInfo.find(checkIndex);
		nodeIndex=Numbers.Data[langIndex].nodeInfo.indexOf(data);
		
		function checkIndex(i){
		if(i.gameCode==val)
		return i;
		}
	}
	else
		nodeIndex = Math.floor(Math.random() * Numbers.Data[langIndex].nodeInfo.length);
		//nodeIndex = 1;
	$('#queNo').text(Numbers.Data[langIndex].nodeInfo[nodeIndex].gameCode);
	$('.ans,#answerKeyText').text(Numbers.Data[langIndex].ansText);
	$('#answerKeyText').append(' '+Numbers.Data[langIndex].nodeInfo[nodeIndex].queNode.correctAns);
	questionId=Numbers.Data[langIndex].nodeInfo[nodeIndex].gameCode
	document.getElementById("heading").innerHTML=Numbers.Data[langIndex].nodeInfo[nodeIndex].question;
	$("#heading").css('font-weight', 'normal');

	if(Numbers.Data[langIndex].languageFont!=null)
        setFontFamilyForLang(Numbers.Data[langIndex].languageFont);

	Numbers.createDivs();
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

Numbers.createDivs = function () {
	var leftDiv,questionDiv;
	leftDiv = document.createElement('div');
	$(leftDiv).prop('class', 'centerClass equation col-lg-8 col-md-8 col-xs-8 col-sm-8 col-lg-offset-2 col-md-offset-2 col-xs-offset-2 col-sm-offset-2 noPadding');
	$("#gamepage").append(leftDiv);
	//questionId = 'N71A';
	if (questionId != 'N71A' && questionId != 'N69A') {
		var equDiv, totalLen = Numbers.Data[langIndex].nodeInfo[nodeIndex].queNode.equArr.length + 1;
		for (var i = 0; i < totalLen; i++) {
			equDiv = document.createElement('div');
			
			if (i == totalLen - 1)
				$(equDiv).prop('class', 'box txtClass borderClass noPadding text-center h-25 col-xs-2 col-md-2 col-lg-2 col-sm-2');
			else if (i % 2 == 0)
				$(equDiv).prop('class', 'noPadding text-center  col-xs-3 col-md-3 col-lg-3 col-sm-3');
			else
				$(equDiv).prop('class', 'noPadding text-center  col-xs-1 col-md-1 col-lg-1 col-sm-1');
			$(equDiv).css({ 'font-size': '6vw', 'text-align': 'center', 'font-weight': 'bold' });
			if (i < totalLen - 1)
				$(equDiv).text(Numbers.Data[langIndex].nodeInfo[nodeIndex].queNode.equArr[i])
			else
				$(equDiv).css('height', '12vh')
			$(leftDiv).append(equDiv);
		}
	}
	if (questionId == 'N71A' || questionId == 'N69A')
		Numbers.createQuestion();
	
	numberSystemDiv = document.createElement('div');
	$(numberSystemDiv).prop('id', 'numberSystemDiv');
	$(numberSystemDiv).prop('class', 'col-lg-12 col-md-12 col-xs-12 col-sm-12 ');
	$(".keyPad").append(numberSystemDiv);
	createNumberDivs('numberSystemDiv')
}
Numbers.createQuestion = function ()
{
	var img = document.createElement('img');
	if (questionId == 'N71A'){
		$(img).prop('src', "images/" + Numbers.Data[langIndex].nodeInfo[nodeIndex].image)
		$(img).prop('class', 'img-responsive col-lg-6 col-md-6 col-xs-6 col-sm-6 ');
	}
	else{				//N69A
		$(img).prop('src', "images/" + Numbers.Data[langIndex].nodeInfo[nodeIndex].image)
		$(img).prop('class', 'img-responsive col-lg-10 col-md-10 col-xs-10 col-sm-10');
	}
	$('.equation').append(img);
	$('.box').hide();
	 $('#gamepage').css('margin-top', '6vh');
	
}
//function which executes on clear btn
Numbers.clearText=function(){
	$("#inputText").text("");
};
Numbers.checkAnswer = function () {
	scoredMarks = '0';
	label = 'null';
	if ($("#inputText").text().trim() != '') {
		label = $("#inputText").text();
		if (Numbers.Data[langIndex].nodeInfo[nodeIndex].queNode.correctAns == $("#inputText").text())
			scoredMarks = '2';
		else
			scoredMarks = '1';
	}
}
resetGame=function() {
	Numbers.selectedOption = null;
	Numbers.attemptFlag = false;
	
	$('.optionShadow').css('border', '2px solid rgb(102 98 85)');
	Numbers.clearText();
}
Numbers.nextQue=function()
{
	if(clickOption == '')
		showModal();
	else{
		//Numbers.checkAnswer();
		scoredMarks = clickOption;
		console.log(scoredMarks, startTime, label);
		if(Utils.mobileDeviceFlag)
			Android.gotoNextGame(scoredMarks, startTime, label);
	}
}
