var G15A = {};

var Utils = {};
Utils.Path = '';
Utils.mobileDeviceFlag = false;
var questionId = 0, starttime = 0, scoredmarks = '0', resId = 0, label='null',resId=0;
G15A.patternCount=0;
resetVariable=false;
var typingDiv=0;var langIndex=0;
$(document).ready(function () {
    if ((navigator.userAgent.match(/Android|BlackBerry|iPhone|iPad|iPod|Opera Mini|IEMobile/i)) && !(window.location.href.includes('http')))
        Utils.mobileDeviceFlag = true;
        showQues();
        $('.code').text('Code');
       
       /*  for(var i=1;i<=3;i++)
            $('#code'+i).text(i-1); */
        G15A.setQuestion();        
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
    $('.selectClass').removeClass('selectClass');
    scoredmarks='0';
}

G15A.setQuestion=function(){
    var d;
    scoredmarks ='0';
    d = new Date();
    starttime = d.getDate() + "-" + (d.getMonth() + 1) + "-" + d.getFullYear() + " " + d.getHours() + ":" + d.getMinutes() + ":" + d.getSeconds();

    if (Utils.mobileDeviceFlag) {
        var val = Android.getGameLang();		//GET ANDROID GAME LANGUAGE
        //var val = 'ENGLISH'
        var lang = G15A.data.find(checkIndex);
        if(lang.language=='Urdu-Pakistan')
        {
            $('#heading').css('direction','rtl');
        }
        langIndex = G15A.data.indexOf(lang);

        
		
        function checkIndex(i) {
            if (i.language.toLowerCase().trim() == val.toLowerCase().trim())
                return i;
       }
    }
    else 
		langIndex = 7;//Math.floor(Math.random() * G15A.data.length);			//GET RANDOM GAME LANGUAGE

    if(G15A.data[langIndex].languageFont!=null)
        setFontFamilyForLang(G15A.data[langIndex].languageFont);
        
	if(Utils.mobileDeviceFlag)
	{
			var val=Android.getGameID();
		/* val='G4A'; */
		var data=G15A.data[langIndex].nodeInfo.find(checkIndex);
		G15A.patternCount=G15A.data[langIndex].nodeInfo.indexOf(data);

		function checkIndex(i){
			if(i.queNo==val)
			return i;
		}
	}
	else
	{
		 G15A.patternCount=Math.floor(Math.random()* (G15A.data[langIndex].nodeInfo.length));
	}

    $('#question').prop('src','images/'+G15A.data[langIndex].nodeInfo[G15A.patternCount].queImg+'.png');
    questionId=G15A.data[langIndex].nodeInfo[G15A.patternCount].queNo;
    $('#queNo').text(G15A.data[langIndex].nodeInfo[G15A.patternCount].queNo);
    /* $('#heading').text(G15A.data[G15A.patternCount].que); */
	document.getElementById('heading').innerHTML=G15A.data[langIndex].nodeInfo[G15A.patternCount].que;
    $("#answerKeyText").append(G15A.data[langIndex].answer + G15A.data[langIndex].nodeInfo[G15A.patternCount].answerKey);
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
G15A.nextQue=function(){
    if(clickOption!="")
	{
		scoredMarks=clickOption;
		G15A.submitAns();
	}
	else
	{
		$("#modalRoot").addClass("visible");
		$("body").addClass("overlay");
		$(".opacityClass").css("opacity","0.1");
		$(".pointerClass").css("pointer-events","none");
		//scoredMarks="0";
	}
}
G15A.submitAns=function(){
    if(Utils.mobileDeviceFlag)
        Android.gotoNextGame(scoredmarks, starttime, label);   
    console.log(scoredmarks,starttime,label);
    //alert("ScoredMarks = " + scoredmarks +","+" "+"Label = " +label);
}
function getScore(ele)
{
	resetVariable=false;
    $('.selectClass').removeClass('selectClass');
    $('#'+ele).addClass('selectClass');
	scoredmarks=$('#'+ele).text();
}