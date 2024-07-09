var Utils={};
Utils.Path='';
Utils.mobileDeviceFlag=true;
startTime = '';
givenAnswer = 'null';
gamesArr=['M8A','M8B'];
counter = 0;
score = '0';
len = 2;
currentLang = 5; gameFlag = false;
/*-- Document Ready Starts --*/
$(document).ready(function() {		
	// device detection
	// if(/(android|bb\d+|meego).+mobile|avantgo|bada\/|blackberry|blazer|compal|elaine|fennec|hiptop|iemobile|ip(hone|od)|ipad|iris|kindle|Android|Silk|lge |maemo|midp|mmp|netfront|opera m(ob|in)i|palm( os)?|phone|p(ixi|re)\/|plucker|pocket|psp|series(4|6)0|symbian|treo|up\.(browser|link)|vodafone|wap|windows (ce|phone)|xda|xiino/i.test(navigator.userAgent) 
	// 	|| /1207|6310|6590|3gso|4thp|50[1-6]i|770s|802s|a wa|abac|ac(er|oo|s\-)|ai(ko|rn)|al(av|ca|co)|amoi|an(ex|ny|yw)|aptu|ar(ch|go)|as(te|us)|attw|au(di|\-m|r |s )|avan|be(ck|ll|nq)|bi(lb|rd)|bl(ac|az)|br(e|v)w|bumb|bw\-(n|u)|c55\/|capi|ccwa|cdm\-|cell|chtm|cldc|cmd\-|co(mp|nd)|craw|da(it|ll|ng)|dbte|dc\-s|devi|dica|dmob|do(c|p)o|ds(12|\-d)|el(49|ai)|em(l2|ul)|er(ic|k0)|esl8|ez([4-7]0|os|wa|ze)|fetc|fly(\-|_)|g1 u|g560|gene|gf\-5|g\-mo|go(\.w|od)|gr(ad|un)|haie|hcit|hd\-(m|p|t)|hei\-|hi(pt|ta)|hp( i|ip)|hs\-c|ht(c(\-| |_|a|g|p|s|t)|tp)|hu(aw|tc)|i\-(20|go|ma)|i230|iac( |\-|\/)|ibro|idea|ig01|ikom|im1k|inno|ipaq|iris|ja(t|v)a|jbro|jemu|jigs|kddi|keji|kgt( |\/)|klon|kpt |kwc\-|kyo(c|k)|le(no|xi)|lg( g|\/(k|l|u)|50|54|\-[a-w])|libw|lynx|m1\-w|m3ga|m50\/|ma(te|ui|xo)|mc(01|21|ca)|m\-cr|me(rc|ri)|mi(o8|oa|ts)|mmef|mo(01|02|bi|de|do|t(\-| |o|v)|zz)|mt(50|p1|v )|mwbp|mywa|n10[0-2]|n20[2-3]|n30(0|2)|n50(0|2|5)|n7(0(0|1)|10)|ne((c|m)\-|on|tf|wf|wg|wt)|nok(6|i)|nzph|o2im|op(ti|wv)|oran|owg1|p800|pan(a|d|t)|pdxg|pg(13|\-([1-8]|c))|phil|pire|pl(ay|uc)|pn\-2|po(ck|rt|se)|prox|psio|pt\-g|qa\-a|qc(07|12|21|32|60|\-[2-7]|i\-)|qtek|r380|r600|raks|rim9|ro(ve|zo)|s55\/|sa(ge|ma|mm|ms|ny|va)|sc(01|h\-|oo|p\-)|sdk\/|se(c(\-|0|1)|47|mc|nd|ri)|sgh\-|shar|sie(\-|m)|sk\-0|sl(45|id)|sm(al|ar|b3|it|t5)|so(ft|ny)|sp(01|h\-|v\-|v )|sy(01|mb)|t2(18|50)|t6(00|10|18)|ta(gt|lk)|tcl\-|tdg\-|tel(i|m)|tim\-|t\-mo|to(pl|sh)|ts(70|m\-|m3|m5)|tx\-9|up(\.b|g1|si)|utst|v400|v750|veri|vi(rg|te)|vk(40|5[0-3]|\-v)|vm40|voda|vulc|vx(52|53|60|61|70|80|81|83|85|98)|w3c(\-| )|webc|whit|wi(g |nc|nw)|wmlb|wonu|x700|yas\-|your|zeto|zte\-/i.test(navigator.userAgent.substr(0,4))) { 
	// 	IsDevice = true;
	// }	
	if((navigator.userAgent.match(/Android|BlackBerry|iPhone|iPad|iPod|Opera Mini|IEMobile/i)) && !(window.location.href.includes('http')))
		Utils.mobileDeviceFlag=true;
	else
		Utils.mobileDeviceFlag=false;

	$('title').text(harcodedData.gameName)
	$(".row").remove();
	resizeHandler();		
	document.ontouchmove = function(e) {};		
	RegisterEvents();		
	InitActivity();	
});
/*-- Document Ready Ends --*/

/*-- Common Framework Functions Starts --*/
function RegisterEvents(){	
	$(window).resize(function() {resizeHandler();});
	$(window).on("orientationchange", function( event ) {resizeHandler();});
	$("div").mousedown(function(e) {});
	$("html").mousedown(function(e) {});   
};
function showQues(){$('#questioMark').hide();$('#myModal').css('display','block');}
function hideQuestion(){$('#questioMark').show(); $('#myModal').css('display','none');}
function goNext(){HandleNextQues();}
function resetGame(){ResetActivity();}
function UpdateActivityNum(ActNo){$('#queNo').html(ActNo);}
function UpdateActivityHeading(HeadingText){$('#heading').html(HeadingText);}
function ShowDiv(DivID) {$("#" + DivID).css('display','block');}
function HideDiv(DivID) {$("#" + DivID).css('display','none');}
/*-- Common Framework Functions Ends --*/

/*-- Game Functions : Starts --*/

var IsDevice = false; //initiate as false
var TotalScr = 1;
var ZoomFact = 1;
var GData = { "CurrScrNo":0, "QuesCount":0, "MaxQues":0, "SelectedQID":0, "DivLineWidth":10 };
var ArrShuff = [];
var LastArrFirstId;
var IsFirst = false;
var dragItem, original, shapes, wrapperLeft;
var IsDropped = false;
var DropCount = 0;
var DropCount0 = 0;
var DropCount1 = 0;
var Answer = "";
var CurrentDropID = "";
//var divLeft = $("#DvDrop1_0").position();
//var originalLeft = divLeft.left ;
function HideAllScreen(){for(var i=0; i<TotalScr; i++){HideDiv("DvScr"+i);}}

function LoadScreen(ScrNo){	
	HideAllScreen();
	switch(ScrNo){
		case 0:
			ShowDiv("DvScr0"); GData.CurrScrNo = 0;
			break;		
		default:
			ShowDiv("DvScr0"); GData.CurrScrNo = 0;
			break;
	}
}

function InitActivity(){		
	//LoadScreen(0);
/* 	var d = new Date();
	startTime = d.getDate() + "-" + (d.getMonth() + 1) + "-" + d.getFullYear() + " " + d.getHours() + ":" + d.getMinutes() + ":" + d.getSeconds(); */
	if(Utils.mobileDeviceFlag){
		var langName = Android.getGameLang();
	    currentLang =  QuesArr.findIndex(obj => obj.language == langName);
	    currentGameData =  QuesArr[currentLang];
		if(langName == "Urdu-Pakistan")
		   $("#heading").css({"text-align":"right" , "direction" : "rtl"});
      }
      else{
          currentGameData =QuesArr[currentLang];	
		  if(currentLang == 3)
		      $("#heading").css({"text-align":"right" , "direction" : "rtl"});
       }
	$('#modalIcon').css('visibility','hidden');
	 $('#inputText').text('');

	 if(QuesArr[currentLang].languageFont!=null)
	    setFontFamilyForLang(QuesArr[currentLang].languageFont);

		

	createNumberpad();
    ReadyQuestions();   	
	$("#DvInpAns").InputFilter0(function (value) {
		return /^\d*$/.test(value) && (value === "" || (parseInt(value) >= 0 && parseInt(value) <= 9999));
	});	

	$('.ClsDragStyle , .ClsDragStyle0, .ClsDragStyle1').draggable({
		containment: "#DvFrameCont",
		/*cancel: ".base",*/		
		start: function (event, ui) {
			var original = ui.originalPosition;
			$(this).css("z-index", 1000);
			IsDropped = false;			
		},
		drag: function (event, ui) {
			wrapperLeft = $("#DvMainCont").offset().left;

			var changeLeft = ui.position.left;

			var newLeft = changeLeft / DragDropScale.x; //newScale u can get jquery
		
			var changeTop = ui.position.top;
			var newTop = changeTop / DragDropScale.y; //newScale u can get jquery

			dragItem = $(this);		

			ui.position.left = newLeft;
			ui.position.top = newTop;
			if(newLeft < 300)
			  CurrentDropID = 0;
			else
			   CurrentDropID = 1;
			
		},
		stop: function (e, ui){
			dragItem.draggable( 'option', 'revert', false )
			$(this).removeAttr("style");
			if(!gameFlag){
				if(DropCount < exampleData[currentLang].DropCnt){
					IsDropped = true;			
					ShowDiv("DvExampleBlock00"+ "_" + DropCount);	
					//DropCount++;
			  }
			      $("#DvDrop0").css("width", 150 + (120 * DropCount) + "px");
			  }
			if(IsDropped){	
				if(!gameFlag){
					if(DropCount < exampleData[currentLang].DropCnt){
						HideDiv($(this).attr("id"));
						DropCount++;				
				}
				    
			}	
				else{	
				if(CurrentDropID == 0){
					if(DropCount0 < currentGameData.gamedata[GData.SelectedQID].AnsNo0){
						HideDiv($(this).attr("id"));
						DropCount0++;				
					}
				}
				else  if(CurrentDropID == 1){
					if(DropCount1 < currentGameData.gamedata[GData.SelectedQID].AnsNo1){
						HideDiv($(this).attr("id"));
						DropCount1++;				
					}
				}
			}
		 }
		}
	});


	$( "#DvDrop0,#DvDrop0_0, #DvDrop0_1, #DvDrop1_0, #DvDrop1_1" ).droppable({
		tolerance: "touch",
		drop: function( event, ui ) {	
          if(!gameFlag){
			if(DropCount < exampleData[currentLang].DropCnt){
				IsDropped = true;			
				ShowDiv("DvExampleBlock00"+ "_" + DropCount);	
		  }
		  }
		  else{
		 // CurrentDropID = Number($(this).attr("data-value"));
		  if(CurrentDropID == 0){
			if(DropCount0 < currentGameData.gamedata[GData.SelectedQID].AnsNo0){
				IsDropped = true;				
				ShowDiv("DvAnsBlock"+GData.SelectedQID + CurrentDropID + "_" + DropCount0);				
		    }
		  }
		  else  if(CurrentDropID == 1){
			if(DropCount1 < currentGameData.gamedata[GData.SelectedQID].AnsNo1){
				IsDropped = true;				
				ShowDiv("DvAnsBlock"+GData.SelectedQID + CurrentDropID + "_" + DropCount1);				
		    }
		  }		  		  	  		  
		}
	  }
	});
}

(function ($) {
	$.fn.InputFilter0 = function (InputFilter0) {
		//return this.on("input keydown keyup mousedown mouseup select contextmenu drop", function () {
		  return this.on("keyup mouseup contextmenu drop", function () {
			if (InputFilter0(this.value)) {
				this.oldValue = this.value;
				this.oldSelectionStart = this.selectionStart;
				this.oldSelectionEnd = this.selectionEnd;
			} else if (this.hasOwnProperty("oldValue")) {
				this.value = this.oldValue;
				this.setSelectionRange(this.oldSelectionStart, this.oldSelectionEnd);

			} else {
				this.value = "";
			}
				if (this.value != "") {
					var Ans0 = Number(currentGameData.gamedata[GData.SelectedQID].AnsNo0);
					var Ans1 = Number(currentGameData.gamedata[GData.SelectedQID].AnsNo1);
					var AnsDiff = Number(currentGameData.gamedata[GData.SelectedQID].AnsDiff);
					var AnsText = this.value;
					Answer = "";
					if(DropCount0 == Ans0 && DropCount1 == Ans1 && AnsText == AnsDiff.toString()){
						Answer = "Correct";					
					}
					else{
						Answer = "Wrong";					
					}
					
				}
			
		});		
	};
}(jQuery));

function createNumberpad(){
	numberSystemDiv = document.createElement('div');
	$(numberSystemDiv).prop('id', 'numberSystemDiv');
	$(numberSystemDiv).prop('class', 'col-lg-12 col-md-12 col-xs-12 col-sm-12 ');
	$(".keyPad").append(numberSystemDiv);
	// $('#numberSystemDiv').hide();
	createNumberDivs('numberSystemDiv');
}

function ReadyQuestions(){ 
	
    GData.MaxQues = currentGameData.gamedata.length;
    GData.QuesCount = Math.floor(Math.random() * (1 - 0 + 1)) + 0;  
	$('#queNo').html(exampleData[currentLang].ActNo);
	$("#heading").html(exampleData[currentLang].Ques);
	$("#ansId").html(QuesArr[currentLang].gamedata[0].QuesText);
	//LoadNextQuestion();           
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
/*-- screen 0 functions : starts --*/

//Shuffle Array
function ShuffleArray(){     
    var TempArr = [];
    TempArr = ArrShuff;
    ArrShuff = [];
	var currentIndex = TempArr.length, temporaryValue, randomIndex;
	// While there remain elements to shuffle...
	while (0 !== currentIndex) {
	// Pick a remaining element...
	randomIndex = Math.floor(Math.random() * currentIndex);
	currentIndex -= 1;
	// And swap it with the current element.
	temporaryValue = TempArr[currentIndex];
	TempArr[currentIndex] = TempArr[randomIndex];
	TempArr[randomIndex] = temporaryValue;
	}

    if(LastArrFirstId == null){
        ArrShuff = TempArr;
        LastArrFirstId = ArrShuff[0];      
    }
    else{
        if(TempArr[0] == LastArrFirstId){
            ShuffleArray();
        }
        else{
            ArrShuff = TempArr;
            LastArrFirstId = ArrShuff[0];
        }        
    }
};

function HandleNextQues(e){ 
	//GData.QuesCount++;
	//LoadNextQuestion(); 
	if(!gameFlag){
		gameFlag = true;
		$('#modalIcon').css('visibility','visible');
		$('#DvFrameEg').hide();
		$("#DvFrame0").show();
		LoadNextQuestion(); 
	}
	else{
		/* givenAnswer = $("#inputText").text();
		calculateScore(); */
		checkAnswer();
	}
  
};
function LoadNextQuestion(){ 	  
	score = '0';
    givenAnswer = 'null';
	var d = new Date();
	startTime = d.getDate() + "-" + (d.getMonth() + 1) + "-" + d.getFullYear() + " " + d.getHours() + ":" + d.getMinutes() + ":" + d.getSeconds();
	ResetAll();
	if(GData.QuesCount >= GData.MaxQues){
		 GData.QuesCount = 0;
	} 
	
	if(Utils.mobileDeviceFlag){
      var randomGame = Android.getGameID();
        currentNode = currentGameData.gamedata.find(el => el.ActNo === randomGame)
    }else{
		randomGame = random();
		currentNode = currentGameData.gamedata.find(el => el.ActNo === randomGame)
    }
    
	$("#answerKeyText").text(" "+QuesArr[currentLang].ans);
	//$("#answerKeyText").append(" "+QuesArr[currentLang].gamedata[currentNode].AnsDiff);
	$("#answerKeyText").append(" "+currentNode.AnsDiff);
	UpdateActivityHeading(currentNode.Ques);    
	GData.SelectedQID =  Number(currentNode.QuesID);
	if(GData.SelectedQID == 0){
	   $("#DvFrame3").hide();
	   $("#DvFrame1").show();
	}
	else{
	   $("#DvFrame1").hide();
	   $("#DvFrame3").show();
	}

	UpdateActivityNum(currentNode.ActNo);
	

	ShowDiv("DvQuesImg"+GData.SelectedQID + "0");	
	ShowDiv("DvQuesImg"+GData.SelectedQID + "1");

	ShowDiv("DvAnsBlock"+GData.SelectedQID + "0");
	ShowDiv("DvAnsBlock"+GData.SelectedQID + "1");

	ShowDiv("DvDropLine"+GData.SelectedQID);

	ShowDiv("DvDrop"+GData.SelectedQID + "_0");
	ShowDiv("DvDrop"+GData.SelectedQID + "_1");

	ShowDiv("DvContDrag"+GData.SelectedQID);	
	DropCount0 = 0;        
	DropCount1 = 0;
	showQues();
}

function ResetActivity(){	
	score = '0';
	givenAnswer = 'null';
	$("#inputText").text('');
	HideDiv("DvExampleBlock00_0");	HideDiv("DvExampleBlock00_1");HideDiv("DvExampleBlock00_2");HideDiv("DvExampleBlock00_3"); HideDiv("DvExampleBlock00_4"); HideDiv("DvExampleBlock00_5");
    HideDiv("DvAnsBlock00_0");	HideDiv("DvAnsBlock00_1");HideDiv("DvAnsBlock00_2");HideDiv("DvAnsBlock00_3");
	HideDiv("DvAnsBlock01_0");	HideDiv("DvAnsBlock01_1"); HideDiv("DvAnsBlock01_2");HideDiv("DvAnsBlock01_3"); HideDiv("DvAnsBlock01_4");HideDiv("DvAnsBlock01_5");

	HideDiv("DvAnsBlock10_0");	HideDiv("DvAnsBlock10_1"); HideDiv("DvAnsBlock10_2"); HideDiv("DvAnsBlock10_3");HideDiv("DvAnsBlock10_4"); HideDiv("DvAnsBlock10_5");
	HideDiv("DvAnsBlock11_0");	HideDiv("DvAnsBlock11_1"); HideDiv("DvAnsBlock11_2"); HideDiv("DvAnsBlock11_3");
	HideDiv("DvAnsBlock11_4");HideDiv("DvAnsBlock11_5");HideDiv("DvAnsBlock11_6");

	for(var j=0; j<6; j++){
		$("#DvDrag"+j).removeAttr("style");			
	}

	for(var j=0; j<6; j++){
		$("#DvDrag0_"+j).removeAttr("style");			
	}

	for(var j=0; j<12; j++){
		$("#DvDrag1_"+j).removeAttr("style");			
	}

	$("#DvInpAns").val("");
	DropCount0 = 0;
	DropCount1 = 0;
	DropCount =0;
}


function ResetAll(){
    HideDiv("DvExampleBlock00_0");	HideDiv("DvExampleBlock00_1");HideDiv("DvExampleBlock00_2");HideDiv("DvExampleBlock00_3"); HideDiv("DvExampleBlock00_4");HideDiv("DvExampleBlock00_5");
	HideDiv("DvAnsBlock00_0");	HideDiv("DvAnsBlock00_1");HideDiv("DvAnsBlock00_2");HideDiv("DvAnsBlock00_3");
	HideDiv("DvAnsBlock01_0");	HideDiv("DvAnsBlock01_1"); HideDiv("DvAnsBlock01_2");HideDiv("DvAnsBlock01_3"); HideDiv("DvAnsBlock01_4");HideDiv("DvAnsBlock01_5");

    HideDiv("DvAnsBlock10_0");	HideDiv("DvAnsBlock10_1"); HideDiv("DvAnsBlock10_2");/*  HideDiv("DvAnsBlock10_3"); */
	HideDiv("DvAnsBlock11_0");	HideDiv("DvAnsBlock11_1"); HideDiv("DvAnsBlock11_2"); HideDiv("DvAnsBlock11_3");
	HideDiv("DvAnsBlock11_4"); /* HideDiv("DvAnsBlock11_5"); */

	for(var i=0; i<currentGameData.gamedata.length; i++){	

		HideDiv("DvQuesImg"+ i + "0");	
		HideDiv("DvQuesImg"+ i + "1");

		HideDiv("DvAnsBlock"+ i + "0");
		HideDiv("DvAnsBlock"+ i + "1");

		HideDiv("DvDropLine"+ i);

		HideDiv("DvDrop"+ i + "_0");
		HideDiv("DvDrop"+ i + "_1");
		HideDiv("DvDrop0");
		HideDiv("DvContExampleDrag0");
		HideDiv("DvContDrag"+ i);
	//	HideDiv("DvContDrag"+ i);

	for(var j=0; j<6; j++){
		$("#DvDrag"+j).removeAttr("style");			
	}

		for(var j=0; j<6; j++){
			$("#DvDrag0_"+j).removeAttr("style");			
		}

		for(var j=0; j<9; j++){
			$("#DvDrag1_"+j).removeAttr("style");			
		}
	}

	$("#DvInpAns").val("");
	DropCount0 = 0;
	DropCount1 = 0;
}

function random() {
  let randomNum = Math.floor(1+Math.random() * gamesArr.length-1);
	return gamesArr[randomNum]
}

function checkAnswer(){
	if(clickOption.length !== 0){
		score=clickOption;	
		label='null';
		scoreFunction();
	}else{
		$("#modalRoot").addClass("visible");
		$("body").addClass("overlay");
		$(".opacityClass").css("opacity","0.1");
		$(".pointerClass").css("pointer-events","none");
		
	}
	
};

function scoreFunction (){
 	console.log(score,startTime,givenAnswer);
		if(Utils.mobileDeviceFlag)
			Android.gotoNextGame(score, startTime, givenAnswer);
}
/*-- screen 0 functions : ends --*/
/*-- Game Functions : Ends --*/