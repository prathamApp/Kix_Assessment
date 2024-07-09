var Geometry={};
var Utils={};
Utils.Path='';
Utils.mobileDeviceFlag=false;
Geometry.attemptFlag=false;
Geometry.givenAnswer='';
Geometry.counter=0;
Geometry.currentLang = 4;
clickOption='';
startTime='',scoreMarks='0',label='null';
gameAttemptFlag = false;

$(document).ready(function()
{
	$(".se-pre-con").fadeOut("slow");
	if ((navigator.userAgent.match(/Android|BlackBerry|iPhone|iPad|iPod|Opera Mini|IEMobile/i))&& !(window.location.href.includes('http')))
		Utils.mobileDeviceFlag=true;

	setTimeout(function()
	{
		$('#coverPage,#homeAndLogoDiv').show();
		$('#questioMark').hide();
		$('#myModal').css('display','block');
	//	Geometry.setImages();
		Geometry.init();
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

Geometry.init=function()
{
	$('#gamePage,#numberSystemDiv').hide();
	$('#inputText').text('');
	$('#modalIcon').css('visibility','hidden');
	$(document).prop("title",Geometry.hardcodedata.NameoftheGame);

	if(Utils.mobileDeviceFlag){
		 var langName = Android.getGameLang();
         Geometry.currentLang =  Geometry.data.findIndex(obj => obj.language == langName);
		 gamecode = Android.getGameID();
		Geometry.currentGame=Geometry.data[Geometry.currentLang ].gameData.findIndex(el => el.gamecode === gamecode);
		if(langName == "Urdu-Pakistan")
		   $("#heading").css({"direction":"rtl" , "text-align":"right"});
	}
	else{
		//Geometry.currentLang = Math.floor(Math.random()* Geometry.data.length)
		// Geometry.currentLang = 5;
		   Geometry.currentGame= Math.floor(Math.random()* Geometry.data[Geometry.currentLang].gameData.length);
		   if(Geometry.currentLang == 3)
		      $("#heading").css({"direction":"rtl" , "text-align":"right"});
	}
	     if(Geometry.data[Geometry.currentLang].languageFont!=null)
	          setFontFamilyForLang(Geometry.data[Geometry.currentLang].languageFont);

	   if(Geometry.currentGame == 0 || Geometry.currentGame == 1){
		   num = 0;
		   $('#queNo').text(Geometry.exampledata[Geometry.currentLang].gameData[num].gamecode);
		document.getElementById('heading').innerHTML=Geometry.exampledata[Geometry.currentLang].gameData[num].instruction;
	   }
	   else if(Geometry.currentGame == 2 || Geometry.currentGame == 3){
		   num = 1;
		$('#queNo').text(Geometry.exampledata[Geometry.currentLang].gameData[num].gamecode);
		document.getElementById('heading').innerHTML=Geometry.exampledata[Geometry.currentLang].gameData[num].instruction;
	   }
	   else{
			num = 2;
			$('#queNo').text(Geometry.exampledata[Geometry.currentLang].gameData[num].gamecode);
			document.getElementById('heading').innerHTML=Geometry.exampledata[Geometry.currentLang].gameData[num].instruction;
	   }
	Geometry.playGame()
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
Geometry.playGame=function(){
	//resetGame();
	$('#dropArea').empty();
	$('#gamePage,#nextDiv').show();//call reset function
	Geometry.showQuestion();	
};

Geometry.showQuestion = function(){
	
	if(!gameAttemptFlag){
	
	var d = new Date();
	startTime = d.getDate() + "-" + (d.getMonth() + 1) + "-" + d.getFullYear() + " " + d.getHours() + ":" + d.getMinutes() + ":" + d.getSeconds();

	$('#questionImage').prop('src',Utils.Path+'images/'+Geometry.exampledata[Geometry.currentLang].gameData[num].question);
	/* $('#questionDiv').css('margin-top',Geometry.exampledata[Geometry.currentLang].gameData[num].questionMarginTop);
	$('#separatorDiv').css('margin-top',Geometry.exampledata[Geometry.currentLang].gameData[num].seperatorMarginTop); */
	}
	else{
		$("#modalIcon").css("visibility","visible");
		$('#questionImage').prop('src',Utils.Path+'images/'+Geometry.data[Geometry.currentLang].gameData[Geometry.currentGame].question);
    	/* $('#questionDiv').css('margin-top',Geometry.data[Geometry.currentLang].gameData[Geometry.currentGame].questionMarginTop);
	   $('#separatorDiv').css('margin-top',Geometry.data[Geometry.currentLang].gameData[Geometry.currentGame].seperatorMarginTop); */
	  
	}
	Geometry.setOptions();
};

Geometry.setOptions = function(){
	$('.option').prop('src','');
 if(!gameAttemptFlag){
	 gameAttemptFlag = true ; 
	$("#"+Geometry.exampledata[Geometry.currentLang].gameData[num].type).addClass("block");
	for(var i=0;i<Geometry.exampledata[Geometry.currentLang].gameData[num].options.length;i++){
		$('#'+Geometry.exampledata[Geometry.currentLang].gameData[num].type+'option'+i).prop('src',Utils.Path+'images/'+Geometry.exampledata[Geometry.currentLang].gameData[num].options[i]);
		$('#'+Geometry.exampledata[Geometry.currentLang].gameData[num].type+'option'+i).data('top',$('#'+Geometry.exampledata[Geometry.currentLang].gameData[num].type+'option'+i).offset().top);
		$('#'+Geometry.exampledata[Geometry.currentLang].gameData[num].type+'option'+i).data('left',$('#'+Geometry.exampledata[Geometry.currentLang].gameData[num].type+'option'+i).offset().left);
		$('#'+Geometry.exampledata[Geometry.currentLang].gameData[num].type+'option'+i).data('parent',$('#'+Geometry.exampledata[Geometry.currentLang].gameData[num].type+'option'+i).parent().prop('id'));
	}
}
    else{
		gameAttemptFlag = false;
		Geometry.counter = 1;
		for(var i=0;i<Geometry.data[Geometry.currentLang].gameData[Geometry.currentGame].options.length;i++){
			$('#'+Geometry.data[Geometry.currentLang].gameData[Geometry.currentGame].type+'option'+i).prop('src',Utils.Path+'images/'+Geometry.data[Geometry.currentLang].gameData[Geometry.currentGame].options[i]);
			$('#'+Geometry.data[Geometry.currentLang].gameData[Geometry.currentGame].type+'option'+i).data('top',$('#'+Geometry.data[Geometry.currentLang].gameData[Geometry.currentGame].type+'option'+i).offset().top);
			$('#'+Geometry.data[Geometry.currentLang].gameData[Geometry.currentGame].type+'option'+i).data('left',$('#'+Geometry.data[Geometry.currentLang].gameData[Geometry.currentGame].type+'option'+i).offset().left);
			$('#'+Geometry.data[Geometry.currentLang].gameData[Geometry.currentGame].type+'option'+i).data('parent',$('#'+Geometry.data[Geometry.currentLang].gameData[Geometry.currentGame].type+'option'+i).parent().prop('id'));
	}
}
	$('.option').draggable({
		revert:'invalid'
	});
	$('#dropArea').droppable({
		drop:Geometry.handleDrop
	});
	
};
Geometry.setHeight =function(){
	for(var i=0;i<Geometry.exampledata[Geometry.currentLang].gameData[num].length;i++){
		console.log($('#'+Geometry.exampledata[Geometry.currentLang].gameData[num].type+'option'+i).outerHeight());
		
	}
};

Geometry.handleDrop=function(event,ui){
	var childPos,parentPos;
	src=ui.draggable;	
	dst=$(this);
	childPos = $(src).offset();
	parentPos = $(dst).offset();	
	$(dst).append(src);
	$(src).css({
		'position':'absolute',
		'top':(childPos.top - parentPos.top)+'px',
		'left':(childPos.left - parentPos.left)+'px',
	});
}


Geometry.checkAnswer=function(){
	if(clickOption.length !== 0){
		scoreMarks=clickOption;	
		label='null';
		Geometry.scoreFunction();
	}else{
		$("#modalRoot").addClass("visible");
		$("body").addClass("overlay");
		$(".opacityClass").css("opacity","0.1");
		$(".pointerClass").css("pointer-events","none");
	}
	
};
Geometry.scoreFunction = function(){
	console.log(scoreMarks,startTime,label);
	//alert("ScoredMarks = " + scoreMarks +","+" "+"Label = " +label);
	if(Utils.mobileDeviceFlag)
		Android.gotoNextGame(scoreMarks,startTime,label);
}
Geometry.showNextGame=function()
{
	if(gameAttemptFlag == true){
		//gameAttemptFlag = false;
		Geometry.counter = 1;
		$("#"+Geometry.exampledata[Geometry.currentLang].gameData[num].type).removeClass('block');
		$("#"+Geometry.data[Geometry.currentLang].gameData[Geometry.currentGame].type).addClass('block');
		$('#queNo').text(Geometry.data[Geometry.currentLang].gameData[Geometry.currentGame].gamecode);
		document.getElementById('heading').innerHTML=Geometry.data[Geometry.currentLang].gameData[Geometry.currentGame].instruction;
		Geometry.playGame();
	}
	else{
		Geometry.checkAnswer();
		$('body').css('pointer-events','auto')
	}
};

resetGame=function(){
	scoreMarks='0';
	label='null';
	clickOption='';
	if(Geometry.counter == 0){
		//Geometry.counter = 1;
 	for(var i=0;i<Geometry.exampledata[Geometry.currentLang].gameData[num].options.length;i++){
			$('#'+$('#'+Geometry.exampledata[Geometry.currentLang].gameData[num].type+'option'+i).data('parent')).append($('#'+Geometry.exampledata[Geometry.currentLang].gameData[num].type+'option'+i));
			$('#'+Geometry.exampledata[Geometry.currentLang].gameData[num].type+'option'+i).css({
				'position':'relative',
				'top':'0px',
				'left':'0px'
			});
			
		}
	}
	if(Geometry.counter == 1){
		for(var i=0;i<Geometry.data[Geometry.currentLang].gameData[Geometry.currentGame].options.length;i++){
			$('#'+$('#'+Geometry.data[Geometry.currentLang].gameData[Geometry.currentGame].type+'option'+i).data('parent')).append($('#'+Geometry.data[Geometry.currentLang].gameData[Geometry.currentGame].type+'option'+i));
			$('#'+Geometry.data[Geometry.currentLang].gameData[Geometry.currentGame].type+'option'+i).css({
				'position':'relative',
				'top':'0px',
				'left':'0px'
			});
			
		}
	}	
}



