var NumberOrdering = {};
var Utils = {};
Utils.Path = "";
Utils.mobileDeviceFlag = false;
NumberOrdering.currentSet='';
NumberOrdering.correctCount=0;
NumberOrdering.randomType=0;
NumberOrdering.counter=0;
NumberOrdering.data;
NumberOrdering.question=[];
NumberOrdering.resetFlag=false;
NumberOrdering.attemptFlag=false;
NumberOrdering.givenAnswer = '';
NumberOrdering.currentLang = 1;
var startTime = '';


$(document).ready(function() {
	$(".se-pre-con").fadeOut("slow");
	
	if((navigator.userAgent.match(/Android|BlackBerry|iPhone|iPad|iPod|Opera Mini|IEMobile/i)) && !(window.location.href.includes('http')))
		Utils.mobileDeviceFlag = true;
	$(document).prop("title",NumberOrdering.AcknowledgementPageData.NameoftheGame);
	$('#questioMark').hide();
	$('#myModal').css('display','block');
	NumberOrdering.setAllImages();
	NumberOrdering.init();
});

showQues = function(){
    $('#questioMark').hide();
    $('#myModal').css('display','block');
}

function hideQuestion(){
    $('#questioMark').show();
    $('#myModal').css('display','none');
}

NumberOrdering.setAllImages = function() {
	//$("#Next,#Reset").prop("src",Utils.Path + "images/Next.png");
	//$("#logo").prop("src",Utils.Path + "images/logo.png");
};

NumberOrdering.init = function() {
	$("#playGame,#playGameDiv").show();
	$("#gamePage,#levelDiv,#endPage").hide();
	NumberOrdering.startGame();
};

NumberOrdering.startGame = function() {
	$("#NumbersDiv,.spaces,.align6InLine").empty();
	$("#gamePage,#Next").show();
	$("#coverPage,#FinalOk").hide();

/* 	if(Utils.mobileDeviceFlag){
		randomGame = Android.getGameID();
		for(var i=0;i<NumberOrdering.type.length;i++){
			if(randomGame == NumberOrdering.type[i].code){
				NumberOrdering.data=NumberOrdering.type[i].data;
			}
		}
	}
	else{
		NumberOrdering.random=Math.floor(1+Math.random()  *NumberOrdering.type.length-1);
		NumberOrdering.data=NumberOrdering.type[NumberOrdering.random].data;
	} */
	
	// NumberOrdering.random=Math.floor(1+Math.random()  *NumberOrdering.type.length-1);
	// NumberOrdering.data=NumberOrdering.type[NumberOrdering.random].data;
	if(Utils.mobileDeviceFlag)
    {
         var langName = Android.getGameLang();
          NumberOrdering.currentLang =   NumberOrdering.gameNameArr.findIndex(obj => obj.Lang == langName);
        var gameCode =Android.getGameID();
        NumberOrdering.currentques = NumberOrdering.gameNameArr[NumberOrdering.currentLang].gameData.findIndex(obj => obj.gameName == gameCode);
    }
    else{
        //NumberOrdering.currentLang= Math.floor(Math.random()* NumberOrdering.gameNameArr.length);
       NumberOrdering.currentques= Math.floor(Math.random()* NumberOrdering.gameNameArr[ NumberOrdering.currentLang].gameData.length);
    }
	NumberOrdering.setQuestion();
};

NumberOrdering.setQuestion = function(){
	NumberOrdering.arrOfNumbers = [];
	var d = new Date();
	startTime = d.getDate() + "-" + (d.getMonth() + 1) + "-" + d.getFullYear() + " " + d.getHours() + ":" + d.getMinutes() + ":" + d.getSeconds();
	questionId = NumberOrdering.data[NumberOrdering.counter].gamecode;
	$('#queNo').text(NumberOrdering.data[NumberOrdering.counter].gamecode);
	document.getElementById('heading').innerHTML=NumberOrdering.exampleData[ NumberOrdering.currentLang].instr1;
	NumberOrdering.chooseNumbers(NumberOrdering.data[NumberOrdering.counter].options);
}

NumberOrdering.chooseNumbers = function(options) {
	NumberOrdering.numbercount = options;
	NumberOrdering.arrOfNumbers=[];
	NumberOrdering.arrOfNumbers=NumberOrdering.data[NumberOrdering.counter].answer;
	console.log(NumberOrdering.arrOfNumbers);
	NumberOrdering.createOptions(NumberOrdering.data[NumberOrdering.counter].col,NumberOrdering.data[NumberOrdering.counter].offset,NumberOrdering.numbercount );
};

NumberOrdering.allowDrop = function(event) {
	event.preventDefault();
};

NumberOrdering.shuffleNumbers = function(array) {
	var i = 0,
		j = 0,
		temp = 0;
	for(i = array.length - 1; i > 0; i--) {
		j = Math.floor(Math.random() * (i + 1));
		temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
};

NumberOrdering.createOptions = function(col,offset,options) {
	var div,spanElement;
	if(!NumberOrdering.resetFlag){
		NumberOrdering.question = NumberOrdering.arrOfNumbers.slice();
		NumberOrdering.shuffleNumbers(NumberOrdering.question);
	}
		for(var j = 0; j < options; j++) {
			innerDiv=document.createElement('div');
			innerDiv.setAttribute('id','option'+j);
			innerDiv.setAttribute('class',"noPadding text-center"+" "+"col-lg-"+col+" "+"col-md-"+col+" "+"col-sm-"+col+" "+"col-xs-"+col+" "+"col-lg-offset-"+offset+" "+"col-md-offset-"+offset+" "+"col-sm-offset-"+offset+" "+"col-xs-offset-"+offset);
			$(innerDiv).data("Answer",NumberOrdering.arrOfNumbers[j]);
			div = $(
				'<div id="div' +
				j +
				'"class="options noPadding text-center col-lg-10 col-md-10 col-xs-10 col-sm-10 col-lg-offset-1 col-md-offset-1 col-sm-offset-1 col-xs-offset-1 left" >'+"</div>"
			);
			$(innerDiv).droppable({
				drop: NumberOrdering.Handledrop,
				dragover: NumberOrdering.allowDrop
			});
			$(div).data("Answer",NumberOrdering.arrOfNumbers[j]);
			if(j < NumberOrdering.numbercount) {
				spanElement = $(
					'<p id="space' +
					j +
					'" class="text-center noPadding spaces" >' +
					NumberOrdering.question[j] +
					"</p>"
				);
				$(div).draggable({
					cursor: "move",
					snap: "#div" + j,
					revert: "invalid",
					zIndex: 1,
					containment: "#optionsDiv",
					scroll: false,
					start: function(event,ui) {
						document.getElementById('playSound').pause();
					}
				});
				$(div).append(spanElement);
			}
			$(innerDiv).append(div);
			$("#optionsDiv").append(innerDiv);
		}
};


NumberOrdering.checkAnswer = function(type) {
	let correctCount=0;
	NumberOrdering.givenAnswer =''
	if(NumberOrdering.attemptFlag){
		for(var i = 0; i < NumberOrdering.arrOfNumbers.length; i++) {
			if($("#option"+ i).data("Answer") == $("#option"+i).children("div").children("p").text()) {
				correctCount++;
			}
			NumberOrdering.givenAnswer= NumberOrdering.givenAnswer+' '+$("#option"+i).children("div").children("p").text();
		}
		if(correctCount == NumberOrdering.arrOfNumbers.length){
			console.log('correct');
			NumberOrdering.score='2';
		}
		else{
			console.log('wrong');
			NumberOrdering.score='1';
		}
	}else
		NumberOrdering.score='0';

	console.log(NumberOrdering.score,startTime,NumberOrdering.givenAnswer);
	if(Utils.mobileDeviceFlag)
		Android.gotoNextGame(NumberOrdering.score, startTime, NumberOrdering.givenAnswer);
	// if(Utils.mobileDeviceFlag)
	// 	Android.addScore(resId,parseInt(questionId),NumberOrdering.score,0,1,startTime); 		

	//$(".options").css("pointer-events","none");
};

NumberOrdering.Handledrop = function(event,ui) {
	var destiDiv,sourceDiv;
	sourceChild = ui.draggable;
	sourceDiv = $(ui.draggable).parent();
	destiDiv = $(this);
	destChild = $(this).children();
	NumberOrdering.currentSet=$(destiDiv).parent().parent().data('type');
	$(sourceChild).css({
		top: "0px",
		left: "0px"
	});
	$(sourceChild).appendTo(destiDiv);
	$(destChild).appendTo(sourceDiv);
	NumberOrdering.attemptFlag=true;
};


NumberOrdering.allowDrop = function(event) {
	event.preventDefault();
};

NumberOrdering.resetGame = function(){
	$(optionsDiv).empty();
	NumberOrdering.attemptFlag=false;
	NumberOrdering.resetFlag=true;
	NumberOrdering.counter=1;
	NumberOrdering.createOptions(NumberOrdering.data[NumberOrdering.counter].col,NumberOrdering.data[NumberOrdering.counter].offset,NumberOrdering.numbercount );
};

//function android call to the next game
NumberOrdering.nextGame=function()
{
	if(NumberOrdering.counter >= 1)
		NumberOrdering.checkAnswer()
	NumberOrdering.counter++;
	if(NumberOrdering.counter < 2){
		$('#optionsDiv').empty();
		NumberOrdering.resetFlag=false;
		NumberOrdering.attemptFlag=false;
		NumberOrdering.setQuestion();
	}else{
		$('body').css('pointer-events','auto');
	}
	//NumberOrdering.addClickEvents();
	// if(Utils.mobileDeviceFlag)
	// 	Android.GotoNextGame(); 
};


