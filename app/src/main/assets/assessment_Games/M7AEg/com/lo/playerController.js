var Utils={};
Utils.Path='';
Utils.mobileDeviceFlag=true;
givenAnswer = 'null';
clickOption='';
gamesArr=['M7A','M7B','M7C'];
startTime = '';
counter = 0;
score = '0';
len = 2;
label='null';
currentLang = 0;

/*-- Document Ready Starts --*/
$(document).ready(function() {		
	// device detection
	// if(/(android|bb\d+|meego).+mobile|avantgo|bada\/|blackberry|blazer|compal|elaine|fennec|hiptop|iemobile|ip(hone|od)|ipad|iris|kindle|Android|Silk|lge |maemo|midp|mmp|netfront|opera m(ob|in)i|palm( os)?|phone|p(ixi|re)\/|plucker|pocket|psp|series(4|6)0|symbian|treo|up\.(browser|link)|vodafone|wap|windows (ce|phone)|xda|xiino/i.test(navigator.userAgent) 
	// 	|| /1207|6310|6590|3gso|4thp|50[1-6]i|770s|802s|a wa|abac|ac(er|oo|s\-)|ai(ko|rn)|al(av|ca|co)|amoi|an(ex|ny|yw)|aptu|ar(ch|go)|as(te|us)|attw|au(di|\-m|r |s )|avan|be(ck|ll|nq)|bi(lb|rd)|bl(ac|az)|br(e|v)w|bumb|bw\-(n|u)|c55\/|capi|ccwa|cdm\-|cell|chtm|cldc|cmd\-|co(mp|nd)|craw|da(it|ll|ng)|dbte|dc\-s|devi|dica|dmob|do(c|p)o|ds(12|\-d)|el(49|ai)|em(l2|ul)|er(ic|k0)|esl8|ez([4-7]0|os|wa|ze)|fetc|fly(\-|_)|g1 u|g560|gene|gf\-5|g\-mo|go(\.w|od)|gr(ad|un)|haie|hcit|hd\-(m|p|t)|hei\-|hi(pt|ta)|hp( i|ip)|hs\-c|ht(c(\-| |_|a|g|p|s|t)|tp)|hu(aw|tc)|i\-(20|go|ma)|i230|iac( |\-|\/)|ibro|idea|ig01|ikom|im1k|inno|ipaq|iris|ja(t|v)a|jbro|jemu|jigs|kddi|keji|kgt( |\/)|klon|kpt |kwc\-|kyo(c|k)|le(no|xi)|lg( g|\/(k|l|u)|50|54|\-[a-w])|libw|lynx|m1\-w|m3ga|m50\/|ma(te|ui|xo)|mc(01|21|ca)|m\-cr|me(rc|ri)|mi(o8|oa|ts)|mmef|mo(01|02|bi|de|do|t(\-| |o|v)|zz)|mt(50|p1|v )|mwbp|mywa|n10[0-2]|n20[2-3]|n30(0|2)|n50(0|2|5)|n7(0(0|1)|10)|ne((c|m)\-|on|tf|wf|wg|wt)|nok(6|i)|nzph|o2im|op(ti|wv)|oran|owg1|p800|pan(a|d|t)|pdxg|pg(13|\-([1-8]|c))|phil|pire|pl(ay|uc)|pn\-2|po(ck|rt|se)|prox|psio|pt\-g|qa\-a|qc(07|12|21|32|60|\-[2-7]|i\-)|qtek|r380|r600|raks|rim9|ro(ve|zo)|s55\/|sa(ge|ma|mm|ms|ny|va)|sc(01|h\-|oo|p\-)|sdk\/|se(c(\-|0|1)|47|mc|nd|ri)|sgh\-|shar|sie(\-|m)|sk\-0|sl(45|id)|sm(al|ar|b3|it|t5)|so(ft|ny)|sp(01|h\-|v\-|v )|sy(01|mb)|t2(18|50)|t6(00|10|18)|ta(gt|lk)|tcl\-|tdg\-|tel(i|m)|tim\-|t\-mo|to(pl|sh)|ts(70|m\-|m3|m5)|tx\-9|up(\.b|g1|si)|utst|v400|v750|veri|vi(rg|te)|vk(40|5[0-3]|\-v)|vm40|voda|vulc|vx(52|53|60|61|70|80|81|83|85|98)|w3c(\-| )|webc|whit|wi(g |nc|nw)|wmlb|wonu|x700|yas\-|your|zeto|zte\-/i.test(navigator.userAgent.substr(0,4))) { 
	// 	IsDevice = true;
	// }
	if((navigator.userAgent.match(/Android|BlackBerry|iPhone|iPad|iPod|Opera Mini|IEMobile/i)) && !(window.location.href.includes('http'))){
		Utils.mobileDeviceFlag=true;
	}
	else{
		Utils.mobileDeviceFlag=false;
	}	
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
var Answer = "";

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
	if(Utils.mobileDeviceFlag){
			 var langName = Android.getGameLang();
         currentLang =  QuesArr.findIndex(obj => obj.language == langName);
         currentGameData =  QuesArr[currentLang];
	}
	else{
	  currentGameData =QuesArr[currentLang ];	
	}
	$('#modalIcon').css('visibility','hidden');
	$('#inputText').text('');
	createNumberpad();	    
    ReadyQuestions();   	
	$("#DvInpAns").InputFilter0(function (value) {
		return /^\d*$/.test(value) && (value === "" || (parseInt(value) >= 0 && parseInt(value) <= 9999));
	});	

	$('.ClsDragStyle0, .ClsDragStyle1, .ClsDragStyle2').draggable({
		containment: "#DvFrameCont",
		/*cancel: ".base",*/		
		start: function (event, ui) {
			var original = ui.originalPosition;
			$(this).css("z-index", 1000);
			IsDropped = false;
			// shapes = {
			// 	  x: original.left,
			// 	  y: original.top
			// };

			//console.log(event, ui);
			//console.log(event.originalEvent.clientX, event.originalEvent.clientY);
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
			//console.log(event.originalEvent.clientX, event.originalEvent.clientY);
		},
		stop: function (e, ui){
			dragItem.draggable( 'option', 'revert', false )
			$(this).removeAttr("style");
			if(IsDropped){
				if(DropCount < currentGameData.gamedata[GData.SelectedQID].DropCnt){
					HideDiv($(this).attr("id"));
					DropCount++;					
				}
			}
			//console.log(e.target);
		}
	});


	$( "#DvDrop0, #DvDrop1, #DvDrop2, #DvDrop3" ).droppable({
		tolerance: "touch",
		drop: function( event, ui ) {
		  //$( this ).addClass( "ui-state-highlight" ).find( "p" ).html( "Dropped!" );
		  
		  if(DropCount < currentGameData.gamedata[GData.SelectedQID].DropCnt){
				IsDropped = true;
				//console.log(DropCount, "DvAnsBlock"+GData.SelectedQID+"_" +DropCount);
				ShowDiv("DvAnsBlock"+GData.SelectedQID+"_" +DropCount);				
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
				var Ans = Number(currentGameData.gamedata[GData.SelectedQID].AnsNo);
				var AnsText = this.value;
				Answer = "";
				if(DropCount == Ans  && AnsText == Ans.toString()){
					Answer = "Correct";					
				}
				else{
					Answer = "Wrong";					
				}
				console.log(Answer);
			}
			else {										
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
	createNumberDivs('numberSystemDiv')
	
}

function ReadyQuestions(){   	
    GData.MaxQues = currentGameData.gamedata.length-1;
    GData.QuesCount = 0;  
    //ArrShuff = [1,1,2,3];
    // for(var i=1; i<QuesArr.length; i++){
    //     ArrShuff.push(i);        
    // }
    //ShuffleArray();  
	LoadNextQuestion();           
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
    //console.log(QuesArr);
	//return TempArr;	
};

function HandleNextQues(e){ 
	givenAnswer = $("#inputText").text();
	$('#modalIcon').css('visibility','visible');
	GData.QuesCount++;
	if(GData.QuesCount < 2)
	 	LoadNextQuestion(); 
	else
		checkAnswer();
};
function LoadNextQuestion(){	    
	ResetAll();
	var d = new Date();
	startTime = d.getDate() + "-" + (d.getMonth() + 1) + "-" + d.getFullYear() + " " + d.getHours() + ":" + d.getMinutes() + ":" + d.getSeconds();
	if(GData.QuesCount > GData.MaxQues){ GData.QuesCount = 1; }  
	
	if(!GData.QuesCount == 0){
		if(Utils.mobileDeviceFlag){
			randomtype = Android.getGameID();
			currentNode = currentGameData.gamedata.find(el => el.ActNo === randomtype)
		}else{
			randomtype = random();
			currentNode = currentGameData.gamedata.find(el => el.ActNo === randomtype)
		}
		$("#answerKeyText").html(currentNode.QuesText);
		$("#answerKeyText").append(currentNode.AnsNo);	
	}else{
		currentNode = currentGameData.gamedata[0];
	}

	
	UpdateActivityHeading(currentNode.Ques);    
	GData.SelectedQID =  Number(currentNode.QuesID);
	UpdateActivityNum(currentNode.ActNo);

	ShowDiv("DvQuesImg"+GData.SelectedQID);	
	ShowDiv("DvAnsBlock"+GData.SelectedQID);
	ShowDiv("DvDropLine"+GData.SelectedQID);
	ShowDiv("DvDrop"+GData.SelectedQID);
	ShowDiv("DvContDrag"+GData.SelectedQID);	
	DropCount = 0;        
	showQues();

	if(GData.SelectedQID > 0){ShowDiv("DvFrame2");}
	else {HideDiv("DvFrame2");}
}

function ResetActivity(){	
	// givenAnswer = 'null';
	label='null';
	clickOption='';
	scoredMarks = '0';
	
	$("#inputText").text('');
	for(var j=0; j<currentGameData.gamedata[GData.SelectedQID].DropCnt; j++){
		HideDiv("DvAnsBlock"+GData.SelectedQID + "_" + j);			
	}

	for(var j=0; j<6; j++){
		$("#DvDrag"+GData.SelectedQID + "_" + j).removeAttr("style");			
	}

	$("#DvInpAns").val("");
	DropCount = 0;
}

function ResetAll(){
	for(var i=0; i<currentGameData.gamedata.length; i++){
		HideDiv("DvAnsBlock"+i);
		HideDiv("DvDropLine"+i);
		HideDiv("DvDrop"+i);
		HideDiv("DvQuesImg"+i);		
		HideDiv("DvContDrag"+i);			
		
		for(var j=0; j<currentGameData.gamedata[i].DropCnt; j++){
			HideDiv("DvAnsBlock"+i+"_"+j);			
		}

		for(var j=0; j<6; j++){
			$("#DvDrag"+i+"_"+j).removeAttr("style");			
		}
	}
	$("#DvInpAns").val("");
	DropCount = 0;
}

function random() {
	// let randomNum = Math.random() * (max - min) + min;
	// return Math.floor(randomNum);
	let randomNum = Math.floor(1+Math.random() * gamesArr.length-1);
	return gamesArr[randomNum]
}

function checkAnswer(){
	if(clickOption.length !== 0){
		scoreMarks=clickOption;	
		label='null';
		scoreFunction();
	}else{
		$("#modalRoot").addClass("visible");
		$("body").addClass("overlay");
		$(".opacityClass").css("opacity","0.1");
		$(".pointerClass").css("pointer-events","none");
		//scoredMarks="0";
	}
	
};
function scoreFunction (){
	console.log(scoreMarks,startTime,label);
	//alert("ScoredMarks = " + scoreMarks +","+" "+"Label = " +label);
	if(Utils.mobileDeviceFlag)
		Android.gotoNextGame(scoreMarks,startTime,label);
}
// function calculateScore(){
// 	if(givenAnswer.length == 0){
// 		scoredMarks = '0';
// 		givenAnswer = 'null';
// 	}
// 	else{
// 		if(givenAnswer==Number(currentNode.AnsNo))
// 			scoredMarks = '2';
// 		else 
// 			scoredMarks = '1';
// 	}
// 	alert("ScoredMarks = " + scoredMarks +","+" "+"Label = " +givenAnswer);
// 	console.log(scoredMarks,startTime,givenAnswer);
// 	if(Utils.mobileDeviceFlag)
// 		Android.gotoNextGame(scoredMarks, startTime, givenAnswer);
// }

// function CheckAns(){
// 	var Ans = Number(QuesArr[GData.SelectedQID].AnsNo);
// 	var AnsText = $("#DvInpAns").val();
// 	if(DropCount == Ans  && AnsText == Ans.toString()){
// 		console.log("Correct");
// 	}
// 	else{
// 		console.log("Wrong");
// 	}
// }

/*-- screen 0 functions : ends --*/
/*-- Game Functions : Ends --*/