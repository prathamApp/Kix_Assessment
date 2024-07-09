var N43A = {};

var Utils = {};
Utils.Path = '';
Utils.mobileDeviceFlag = false;
var questionId = 0, starttime = 0, scoredmarks = '0', resId = 0, label="null",resId=0;
N43A.patternCount=0;var langIndex=0;
resetVariable=true;
var typingDiv=0;
$(document).ready(function () {
    //$('.pattern2').hide();
    if ((navigator.userAgent.match(/Android|BlackBerry|iPhone|iPad|iPod|Opera Mini|IEMobile/i)) && !(window.location.href.includes('http')))
        Utils.mobileDeviceFlag = true;
        $('#inputText').text('');
        showQues();
        $('.pattern1').hide();
        $('.pattern').hide();
        
      // numberKey();
        N43A.setQuestion();
        /* numberSystemDiv = document.createElement('div');
		$(numberSystemDiv).prop('id', 'numberSystemDiv');
		$(numberSystemDiv).prop('class', 'col-lg-12 col-md-12 col-xs-12 col-sm-12 ');
		$(".keyPad").append(numberSystemDiv); */
		// $('#numberSystemDiv').hide();
		//createNumberDivs('numPad')
       // N43A.getGameCode();
        //N43A.setQuestion();        
});


function showQues(){
    $('#questioMark').hide();
    $('#myModal').css('display','block');
}

function hideQuestion(){
    $('#questioMark').show();
    $('#myModal').css('display','none');
}

function resetGame(){
	$('#numberpadDiv').hide();
    if(N43A.patternCount==0)
        $("#AnswerDiv").text('');
    else if(N43A.patternCount==1)
        $("#AnswerDiv1").text('');
    else
    {
        $('#remainder,#Quotient').text('');
    }
   resetVariable=true;
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
N43A.setQuestion=function(){
    var d;
    scoredmarks = '0';
    d = new Date();
    starttime = d.getDate() + "-" + (d.getMonth() + 1) + "-" + d.getFullYear() + " " + d.getHours() + ":" + d.getMinutes() + ":" + d.getSeconds();

    if (Utils.mobileDeviceFlag) {
        var val = Android.getGameLang();		//GET ANDROID GAME LANGUAGE
       // var val = 'ENGLISH'
        var lang =data.find(checkIndex);
        if(lang.language=='Urdu-Pakistan')
        {
            $('#heading').css('direction','rtl');
        }
        langIndex = data.indexOf(lang);
		
        function checkIndex(i) {
            if (i.language.toLowerCase().trim() == val.toLowerCase().trim())
                return i;
       }
    }
    else
		langIndex = 5;//Math.floor(Math.random() * data.length);			//GET RANDOM GAME LANGUAGE

    if(data[langIndex].languageFont!=null)
        setFontFamilyForLang(data[langIndex].languageFont);

	if(Utils.mobileDeviceFlag)
	{
        var val=Android.getGameID();
		var index=data[langIndex].nodeInfo.find(checkIndex);
		N43A.patternCount=data[langIndex].nodeInfo.indexOf(index);

		function checkIndex(i){
			if(i.queNo==val)
			return i;
		}
	}
	else
		N43A.patternCount=Math.floor(Math.random()*data[langIndex].nodeInfo.length);

    questionId=data[langIndex].nodeInfo[N43A.patternCount].queNo;
    $('#queNo').text(data[langIndex].nodeInfo[N43A.patternCount].queNo);
   /*  $('#heading').text(data[N43A.patternCount].que); */
   document.getElementById('heading').innerHTML=data[langIndex].nodeInfo[N43A.patternCount].que;
    $('#heading').css('font-size',data[langIndex].nodeInfo[N43A.patternCount].fontSize);
    if(N43A.patternCount==3)
    {
        $('#imgDiv1').removeClass('col-xs-8 col-sm-8 col-lg-8 col-md-8 col-xs-offset-2 col-sm-offset-2 col-lg-offset-2 col-md-offset-2 noPadding');
        $('#imgDiv1').addClass('col-xs-4 col-sm-4 col-lg-4 col-md-4 col-xs-offset-4 col-sm-offset-4 col-lg-offset-4 col-md-offset-4 noPadding');
    }
    if(N43A.patternCount==0 || N43A.patternCount==1 || N43A.patternCount==3)
    {
        $('.pattern').show();
        $('.pattern1').hide();
        $('.pattern2').hide();
        $('#answerDiv').css('display','block');
        $('#quoRemainder').css('display','none');
        $("#answerKeyText").append(data[langIndex].hardCodedData[0]+data[langIndex].nodeInfo[N43A.patternCount].answerKey);
        $('#img3').prop('src','images/'+data[langIndex].nodeInfo[N43A.patternCount].img+'.png');
    }
   /*  else if(N43A.patternCount==1)
    {
        $('.pattern').hide();
        $('.pattern1').show();
        $('.pattern2').hide();
        $('#answerDiv').css('display','block');
        $('#quoRemainder').css('display','none');
        $("#answerKeyText").append('9');
        $('#queImg').prop('src','images/'+data[langIndex].nodeInfo[N43A.patternCount].img+'.png');
    } */
    else
    {
        $('.pattern').hide();
        $('.pattern1').hide();
        $('.pattern2').show();
        $('#answerDiv').css('display','none');
        $('#quoRemainder').css('display','block');
        $("#answerKeyText").append(data[langIndex].hardCodedData[0]+data[langIndex].hardCodedData[1]+data[langIndex].nodeInfo[N43A.patternCount].answerKey[0]+data[langIndex].hardCodedData[2]+data[langIndex].nodeInfo[N43A.patternCount].answerKey[1]);
        $('#que').prop('src','images/'+data[langIndex].nodeInfo[N43A.patternCount].img+'.png');
        //$('#footer').hide();
    }
    $('#answerTxt').text(data[langIndex].hardCodedData[0]);
    $('#quoTxt').text(data[langIndex].hardCodedData[1]);
    $('#remainderTxt').text(data[langIndex].hardCodedData[2]);
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
N43A.nextQue=function(){
   
        if(clickOption!="")
            N43A.submitAns();
        else
            showModal()
}

N43A.submitAns=function(){
    /* var answer,answer1='';
	/* $('body').css('pointer-events','none'); */
   /*  if(N43A.patternCount==0 || N43A.patternCount==1 || N43A.patternCount==3)
    {
        var answer=$('#inputText').text();
        label=$('#inputText').text();
    }
    else
    {
        var answer=$('#Quotient').text();
        var answer1=$('#remainder').text();
        label=answer+','+answer1;
    }
    if(N43A.patternCount==0 || N43A.patternCount==1 || N43A.patternCount==3)
        var condition=answer==data[langIndex].nodeInfo[N43A.patternCount].answer;
    else
        var condition=answer==data[langIndex].nodeInfo[N43A.patternCount].answer[0] && answer1==data[langIndex].nodeInfo[N43A.patternCount].answer[1]
    
    if(condition)
        scoredmarks='2';
    else if(resetVariable)
    {
        scoredmarks='0';
        label='null'
    } 
    else
        scoredmarks='1';
 */ 
    if(Utils.mobileDeviceFlag)
        Android.gotoNextGame(scoredmarks,starttime,label);
    console.log(scoredmarks,starttime,label);
    //alert("ScoredMarks = " + scoredmarks +","+" "+"Label = " +label);
}

function shuffleArray(array) {
    var i, j, temp;
    for (i = array.length - 1; i > 0; i--) {
        j = Math.floor(Math.random() * (i + 1));
        temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    return array;
}

N43A.displayNumber = function (element) {//inputs the number in selected textbox when user clicks the number on numberpad.
    resetVariable=false;
    $("#"+typingDiv).append($('#'+element).text());
}

function showNumPad(ele){
    typingDiv='';
    typingDiv=ele;
}

function appendNumbertoText (obj) {
	resetVariable=false;
    if(N43A.patternCount==2)
    {
        N43A.givenAnswer=$("#"+typingDiv).text().trim()+''+$('#'+obj).text();
        if(N43A.givenAnswer.toString().length<=2)
		    $("#"+typingDiv).text($('#'+typingDiv).text().trim()+''+$('#'+obj).text());
    }
    else{
        N43A.givenAnswer=$('#inputText').text().trim()+''+$('#'+obj).text();
        if(N43A.givenAnswer.toString().length<=2)
            $("#inputText").text($('#inputText').text().trim()+''+$('#'+obj).text());
    }
	
};