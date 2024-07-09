var CountBiscuits={};
var Utils={};
Utils.Path='';
Utils.mobileDeviceFlag=false;
CountBiscuits.attemptFlag=false;
label='null';
var startTime='';
len=2;
$(document).ready(function()
{
	$(".se-pre-con").fadeOut("slow");
	if((navigator.userAgent.match(/Android|BlackBerry|iPhone|iPad|iPod|Opera Mini|IEMobile/i)) && !(window.location.href.includes('http')))
		Utils.mobileDeviceFlag=true;
	else
		Utils.mobileDeviceFlag=false;
	 

	setTimeout(function()
	{
		$('#coverPage,#homeAndLogoDiv').show();
		$('#questioMark').hide();
		$('#myModal').css('display','block');
		CountBiscuits.setImages();
		CountBiscuits.init();
	},200);
});

function showQues(){
    $('#questioMark').hide();
    $('#myModal').css('display','block');
}

function hideQuestion(){
    $('#questioMark').show();
    $('#myModal').css('display','none');
}

CountBiscuits.init=function()
{
	$('#gamePage,#numberSystemDiv').hide();
	$('#inputText').text('');
	$(document).prop("title",CountBiscuits.hardcodedata.NameoftheGame);
	//createNumberpad();
	CountBiscuits.playGame();
}

CountBiscuits.setImages=function()
{
	
}

CountBiscuits.playGame=function(){
	$('#gamePage,#nextDiv').show();//call reset function

	if (Utils.mobileDeviceFlag) {
        var val = Android.getGameLang();		//GET ANDROID GAME LANGUAGE
        var lang = CountBiscuits.data.find(checkIndex);
        langIndex = CountBiscuits.data.indexOf(lang);
		if(lang.language=='Urdu-Pakistan'){
			$('#heading').css('direction','rtl');
		}
        function checkIndex(i) {
            if (i.language.toLowerCase().trim() == val.toLowerCase().trim())
                return i;
       }
    }
    else 
		langIndex = 0;//Math.floor(Math.random() * CountBiscuits.data.length);			//GET RANDOM GAME LANGUAGE

	if(CountBiscuits.data[langIndex].languageFont!=null)
        setFontFamilyForLang(CountBiscuits.data[langIndex].languageFont);

	if(Utils.mobileDeviceFlag)
	{
		var val=Android.getGameID();
		/* val='G4A'; */
		var data=CountBiscuits.data[langIndex].gamedata.find(checkIndex);
		CountBiscuits.currentGame=CountBiscuits.data[langIndex].gamedata.indexOf(data);

		function checkIndex(i){
			if(i.gamecode==val)
			return i;
		}
	}
	else
	{
		CountBiscuits.currentGame=Math.floor(Math.random() * (CountBiscuits.data[langIndex].gamedata.length ));
	} 
	
			
	// 	for(var i=0;i<CountBiscuits.data.length;i++){
	// 	if(randomGame == CountBiscuits.data[i].gamecode){
	// 		CountBiscuits.currentGame = CountBiscuits.data[i];
	// 	}
	// }

	$('#answerText').text(CountBiscuits.data[langIndex].answerText);
	//CountBiscuits.currentNode = CountBiscuits.currentGame.gamedata.find(el => el.gamecode === randomGame)
	$('#queNo').text(CountBiscuits.data[langIndex].gamedata[CountBiscuits.currentGame].gamecode);
	document.getElementById('heading').innerHTML=CountBiscuits.data[langIndex].gamedata[CountBiscuits.currentGame].instruction;
	$("#answerKeyText").append(CountBiscuits.data[langIndex].answerText+CountBiscuits.data[langIndex].gamedata[CountBiscuits.currentGame].answerKey);
	CountBiscuits.showQuestion();	
};

CountBiscuits.showQuestion = function(){
	var d = new Date();
	startTime = d.getDate() + "-" + (d.getMonth() + 1) + "-" + d.getFullYear() + " " + d.getHours() + ":" + d.getMinutes() + ":" + d.getSeconds();
	$('#questionImage').prop('src',Utils.Path+'images/'+CountBiscuits.data[langIndex].gamedata[CountBiscuits.currentGame].question);
};

// CountBiscuits.createNumberDivs=function(parentDiv,buttonCount)
// {
// 	var i = 0, j = 0, row, newbutton;
// 		for (i = 1; i <= 4; i++) {
// 			row = document.createElement('div');
// 			row.setAttribute("id", "row" + i);
// 			row.setAttribute("class", "rowClass col-xs-11 col-sm-11 col-md-11 col-lg-11 nopadding");
// 				for (j = 1; j <= 3; j++) {
// 					if (buttonCount <= 9) {
// 						newbutton = document.createElement('BUTTON');
// 						newbutton.setAttribute("id", "buttonValue" + buttonCount);
// 						if(buttonCount == 9)
// 							newbutton.setAttribute("class", "borderClass buttonClass noPadding col-sm-offset-5 col-xs-offset-5 col-lg-offset-5 col-md-offset-5 col-xs-3 col-sm-3 col-md-3 col-lg-3 nopadding");
// 						else
// 							newbutton.setAttribute("class", "borderClass buttonClass noPadding col-sm-offset-1 col-xs-offset-1 col-lg-offset-1 col-md-offset-1 col-xs-3 col-sm-3 col-md-3 col-lg-3 nopadding");
// 						$(newbutton).text(buttonCount);
// 						newbutton.setAttribute("onclick", "CountBiscuits.appendNumbertoText(this.id)");
// 					}
// 					row.append(newbutton);
// 					parentDiv.append(row);
// 					buttonCount++;
// 			}
// 		}
// };

// CountBiscuits.showCalculator=function(){
// 	$('#numberSystemDiv').show();
// };

// CountBiscuits.appendNumbertoText=function(obj){
// 	CountBiscuits.attemptFlag = true;
// 	CountBiscuits.givenAnswer=$('#inputText').text()+''+$('#'+obj).text();
// 	if(CountBiscuits.givenAnswer.toString().length<=2)
// 		$("#inputText").text($('#inputText').text()+''+$('#'+obj).text());
// };

// //function which executes on clear btn
// CountBiscuits.clearText=function(){
// 	$("#inputText").text("");
// };

function createNumberpad(){
	numberSystemDiv = document.createElement('div');
	$(numberSystemDiv).prop('id', 'numberSystemDiv');
	$(numberSystemDiv).prop('class', 'col-lg-12 col-md-12 col-xs-12 col-sm-12 ');
	$(".keyPad").append(numberSystemDiv);
	// $('#numberSystemDiv').hide();
	createNumberDivs('numberSystemDiv')
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
CountBiscuits.resetGame=function(){
	CountBiscuits.clearText();
	CountBiscuits.attemptFlag=false;
	$('.selection').removeClass('selection');
	CountBiscuits.givenAnswer='null';
};

CountBiscuits.checkAnswer=function(){
	
	console.log(clickOption,startTime,label);
	if(Utils.mobileDeviceFlag)
		Android.gotoNextGame(clickOption, startTime, label); 
};

CountBiscuits.showNextGame=function(){
	if(clickOption==='')
		showModal();
	else
		CountBiscuits.checkAnswer();
	$('body').css('pointer-events','auto')
};





