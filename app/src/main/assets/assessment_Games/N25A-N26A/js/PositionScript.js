Position={};
var Utils={};
Utils.Path='';
Utils.mobileDeviceFlag = false;
var questionId = '', startTime = '', scoredMarks = '0', label = 'null', nodeIndex,langIndex,len=1;
Position.selectedImg = '';
$(document).ready(function()
{
	if((navigator.userAgent.match(/Android|BlackBerry|iPhone|iPad|iPod|Opera Mini|IEMobile/i)) && !(window.location.href.includes('http')))
		Utils.mobileDeviceFlag = true;
	
	$('.modal').css('padding', '0');
	showQues();
	document.getElementById("gamepage").style.backgroundImage=Utils.Path+"url('images/BG.PNG')";
	Position.getGameCode();					//get code from url
});
function showQues(){
    $('#questioMark').hide();
    $('#myModal').css('display','block');
}
function hideQuestion(){
    $('#questioMark').show();
    $('#myModal').css('display','none');
}
Position.getGameCode = function () {
	var d;
	d = new Date();
	startTime = d.getDate() + "-" + (d.getMonth() + 1) + "-" + d.getFullYear() + " " + d.getHours() + ":" + d.getMinutes() + ":" + d.getSeconds();
	if (Utils.mobileDeviceFlag) {
		var val = Android.getGameLang();		//GET ANDROID GAME LANGUAGE
		// var val = 'Urdu-Pakistan'
		var lang = Position.Data.find(checkIndex);
		langIndex = Position.Data.indexOf(lang);
		if (lang.language == 'Urdu-Pakistan')
			$('#heading').css('direction','rtl')
		function checkIndex(i) {
			if (i.language.toLowerCase().trim() == val.toLowerCase().trim())
				return i;
		}
	}
	else{
		langIndex = 0;/* Math.floor(Math.random() * Position.Data.length);		//GET RANDOM GAME LANGUAGE */
	
	}
	if (Utils.mobileDeviceFlag)
	{
		var val=Android.getGameID();		//GET GAME CODE
		//val = 'N26A_2'
		var data= Position.Data[langIndex].nodeInfo.find(checkIndex);
		nodeIndex= Position.Data[langIndex].nodeInfo.indexOf(data);
		
		function checkIndex(i){
		if(i.gameCode==val)
		return i;
		}
	}
	else
		nodeIndex = Math.floor(Math.random() *  Position.Data[langIndex].nodeInfo.length);
	
	$('#queNo').text( Position.Data[langIndex].nodeInfo[nodeIndex].gameCode);
	$('.ans,#answerKeyText').text( Position.Data[langIndex].nodeInfo[nodeIndex].ansText);
	questionId =  Position.Data[langIndex].nodeInfo[nodeIndex].gameCode;
	document.getElementById("heading").innerHTML= Position.Data[langIndex].nodeInfo[nodeIndex].question;
	$('#heading').css('font-size', '1.6vw');
	$('#heading').parent().css('font-weight', 'unset');
	var asciiCode = 65;
	for (var i = 0; i <  Position.Data[langIndex].nodeInfo[nodeIndex].imgList.length; i++)
	{
		var div, img,col=12;
		div = document.createElement('div');
		if(i==1 && questionId =='N25A')
			$(div).prop('class', ' noPadding col-xs-4 col-sm-4 col-md-4 col-lg-4');
		else
			$(div).prop('class', ' noPadding col-xs-2 col-sm-2 col-md-2 col-lg-2');
		$('.images').append(div);

		
		img = document.createElement('img');
		if (i == 0 && questionId =='N25A')
		{
			col = 12
		}
		else if (i == 1 && questionId =='N25A')
		{
			col = 12
		}
		else if ((i == 2 || i == 3) && questionId =='N25A')
		{
			col=8
		}
		else if ((i == 4) && questionId =='N25A')
		{
			col=3
		}
		$(img).prop('class','img-responsive imgClass noPadding col-xs-'+col+' col-sm-'+col+' col-md-'+col+' col-lg-'+col)
		$(img).prop('src', Utils.Path + 'images/' +  Position.Data[langIndex].nodeInfo[nodeIndex].imgList[i].img + '.png');
		
		$(div).append(img)
		if (questionId == 'N25A' && i > 0)		//excluding first image
		{
			$(img).data('name', String.fromCharCode(asciiCode));
			asciiCode++;
			$(img).data('dataImg',Position.Data[langIndex].nodeInfo[nodeIndex].imgList[i].img + '.png');
			$(img).click(function () { Position.selectAns(this) })
		}
	}
	
	if (questionId == 'N26A')
	{
		
		$('#answerKeyText').append(' '+ Position.Data[langIndex].nodeInfo[nodeIndex].ansKey);
		$("#resetDiv").css('visibility','hidden');
		$("#modalIcon").css('visibility','visible');
			numberSystemDiv = document.createElement('div');
		$(numberSystemDiv).prop('id', 'numberSystemDiv');
		$(numberSystemDiv).prop('class', 'col-lg-12 col-md-12 col-xs-12 col-sm-12 ');
		$(".keyPad").append(numberSystemDiv);
		createNumberDivs('numberSystemDiv')
	}
if(Position.Data[langIndex].languageFont!=null)
        setFontFamilyForLang(Position.Data[langIndex].languageFont);
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
Position.selectAns = function (ele)
{
	$('.imgClass').css('border', 'none');
	$(ele).css('border', '6px solid #ffbe00');
	Position.selectedImg = $(ele).data('name');
	Position.selectImgData=$(ele).data('dataImg');
}
Position.checkAnswer = function (ele) {
	scoredMarks = '0'; label = 'null';
	if (Position.selectedImg != "" && questionId == 'N25A')
	{
		label = Position.selectImgData;
		if (Position.selectedImg == Position.Data[langIndex].nodeInfo[nodeIndex].correctAns)
			scoredMarks = '2';
		else
			scoredMarks = '1';
	}
	else if(clickOption!='' && questionId == 'N26A')
			scoredMarks = clickOption;
	if(clickOption=='' && questionId == 'N26A')	
	{
		$("#modalRoot").addClass("visible");
		$("body").addClass("overlay");
		$(".opacityClass").css("opacity","0.1");
		$(".pointerClass").css("pointer-events","none");
	}	
}
resetGame = function () {
	
	Position.selectedImg= '';
	scoredMarks = '0';
	$('.imgClass,.optClass').css('border', 'none');
}
Position.nextQue=function()
{
	Position.checkAnswer();
	console.log(scoredMarks, startTime, label); 
	if(clickOption!="")
	{
		
	}
	//alert("ScoredMarks = " + scoredMarks +","+" "+"Label = " +label);
	if(Utils.mobileDeviceFlag)
		Android.gotoNextGame(scoredMarks, startTime, label);
}