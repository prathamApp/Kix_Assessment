var N66A = {};

var Utils = {};
Utils.Path = '';
Utils.mobileDeviceFlag = false;
var questionId = 0, starttime = 0, scoredmarks = '0', resId = 0, label="null",resId=0;
N66A.patternCount=0;
resetVariable=true;var langIndex=0;
var typingDiv=0;
$(document).ready(function () {
    if ((navigator.userAgent.match(/Android|BlackBerry|iPhone|iPad|iPod|Opera Mini|IEMobile/i)) && !(window.location.href.includes('http')))
        Utils.mobileDeviceFlag = true;
        $('#inputText').text('');
        //createNumberDivs('numPad');
        $("#answerKeyText").append('?');
        showQues();
        N66A.setQuestion();        
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
    $("#AnswerDiv1").text('');
    resetVariable=true;
    label='null';
    scoredmarks = '0'
}

N66A.setQuestion=function(){
    var d;
    scoredmarks = '0';
    d = new Date();
    starttime = d.getDate() + "-" + (d.getMonth() + 1) + "-" + d.getFullYear() + " " + d.getHours() + ":" + d.getMinutes() + ":" + d.getSeconds();
    $('#queImg').empty();

    if (Utils.mobileDeviceFlag) {
        var val = Android.getGameLang();		//GET ANDROID GAME LANGUAGE
        //var val = 'ENGLISH'
        var lang =N66A.data.find(checkIndex);
        if(lang.language=='Urdu-Pakistan')
        {
            $('#heading').css('direction','rtl');
        }
        langIndex =N66A.data.indexOf(lang);
		
        function checkIndex(i) {
            if (i.language.toLowerCase().trim() == val.toLowerCase().trim())
                return i;
       }
    }
    else
		langIndex = 5;//Math.floor(Math.random() * N66A.data.length);			//GET RANDOM GAME LANGUAGE

    if(N66A.data[langIndex].languageFont!=null)
        setFontFamilyForLang(N66A.data[langIndex].languageFont);

	if(Utils.mobileDeviceFlag)
	{
		var val=Android.getGameID();
		var data=N66A.data[langIndex].nodeInfo.find(checkIndex);
		N66A.patternCount=N66A.data[langIndex].nodeInfo.indexOf(data);
		function checkIndex(i){
			if(i.queNo==val)
			return i;
		}
	}
	else
		 N66A.patternCount=Math.floor(Math.random()*N66A.data[langIndex].nodeInfo.length);
    questionId=N66A.data[langIndex].nodeInfo[N66A.patternCount].queNo;
	$('#text').text(N66A.data[langIndex].text);
    $('#queNo').text(N66A.data[langIndex].nodeInfo[N66A.patternCount].queNo);
    /* $('#heading').text(N66A.data[N66A.patternCount].que); */
	document.getElementById('heading').innerHTML=N66A.data[langIndex].nodeInfo[N66A.patternCount].que;
    if(N66A.data[langIndex].nodeInfo[N66A.patternCount].queNo=='N66A' || N66A.data[langIndex].nodeInfo[N66A.patternCount].queNo=='N43C')
       {
           $('#queImg').removeClass('col-xs-8 col-sm-8 col-lg-8 col-md-8 col-xs-offset-2 col-sm-offset-2 col-lg-offset-2 col-md-offset-2  noPadding')
           $('#queImg').removeClass('col-xs-12s col-sm-12 col-lg-12 col-md-12 noPadding')
       }
    var img=document.createElement('img');
    $(img).prop('src','images/'+N66A.data[langIndex].nodeInfo[N66A.patternCount].imgArr[0]+'.png');
    $(img).prop('class','col-sm-10 col-lg-10 col-md-10 col-xs-10 col-xs-offset-1 col-sm-offset-1 col-lg-offset-1  col-md-offset-1 noPadding img-responsive');
    $('#queImg').append(img);
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
N66A.nextQue=function(){
    //var input = $('#inputText').text();
    if(clickOption != "")
        N66A.submitAns();
    else
        showModal();

}

N66A.submitAns=function(){
	/* $('body').css('pointer-events','none'); */
    //label=$("#inputText").text();
   
    if(Utils.mobileDeviceFlag)
        Android.gotoNextGame(scoredmarks, starttime, label);
       /*  Android.addScore(resId,questionId,scoredmarks,starttime,label); */
        
    console.log(scoredmarks,starttime,label);
   // alert("ScoredMarks = " + scoredmarks +","+" "+"Label = " +label);
    $("#inputText").text('');
}
N66A.displayNumber = function (element) {//inputs the number in selected textbox when user clicks the number on numberpad.
    resetVariable=false;
    $("#"+typingDiv).append($('#'+element).text());
}

function showNumPad(ele){
    typingDiv='';
    $('#numberpadDiv').show();
    typingDiv=ele;
}