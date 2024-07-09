var N47A = {};

var Utils = {};
Utils.Path = '';
Utils.mobileDeviceFlag = false;
var questionId = 0, starttime = 0, scoredmarks = '0', resId = 0, label="null",resId=0;
N47A.patternCount=0;var langIndex=0;
resetVariable=true;
var typingDiv=0;
$(document).ready(function () {
    //$('.pattern2').hide();
    if ((navigator.userAgent.match(/Android|BlackBerry|iPhone|iPad|iPod|Opera Mini|IEMobile/i)) && !(window.location.href.includes('http')))
        Utils.mobileDeviceFlag = true;
        
        showQues();
        $('#verticalEqu').hide();
        
        //createNumberDivs('numPad');
        N47A.setQuestion();
       // N47A.getGameCode();
        //N47A.setQuestion();        
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
    $("#div5").text('');
    $("#verticalDiv4").text('');
    resetVariable=true;
    label='null';
    scoredmarks = '0';
}

N47A.setQuestion=function(){
    var d;
    scoredmarks = '0';
    d = new Date();
    starttime = d.getDate() + "-" + (d.getMonth() + 1) + "-" + d.getFullYear() + " " + d.getHours() + ":" + d.getMinutes() + ":" + d.getSeconds();
    /* N47A.patternCount=Math.floor(Math.random()*data.length); */
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
		langIndex =10;//Math.floor(Math.random() * data.length);			//GET RANDOM GAME LANGUAGE
    
    if(data[langIndex].languageFont!=null)
        setFontFamilyForLang(data[langIndex].languageFont);
        
	if(Utils.mobileDeviceFlag)
	{
        var val=Android.getGameID();
		var index=data[langIndex].nodeInfo.find(checkIndex);
		N47A.patternCount=data[langIndex].nodeInfo.indexOf(index);

		function checkIndex(i){
			if(i.queNo==val)
			return i;
		}
	}
	else
		N47A.patternCount=Math.floor(Math.random()*data[langIndex].nodeInfo.length);

    questionId=data[langIndex].nodeInfo[N47A.patternCount].queNo;
    $('#queNo').text(data[langIndex].nodeInfo[N47A.patternCount].queNo);
    $('#text').text(data[langIndex].text);
    /* $('#heading').text(data[N47A.patternCount].que); */
	document.getElementById('heading').innerHTML=data[langIndex].nodeInfo[N47A.patternCount].que
    $('#heading').css('font-size',data[langIndex].nodeInfo[N47A.patternCount].fontSize);
    $('#answerKeyText').text(data[langIndex].text+data[langIndex].nodeInfo[N47A.patternCount].answerKey)
    $('#questionImg').prop('src','images/'+data[langIndex].nodeInfo[N47A.patternCount].queImg+'.png');
   // N47A.createDiv();
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
N47A.createDiv=function(){
    for(var i=0;i<5;i++){
        var div=document.createElement('div');
        if (i== 0 || i==2)
            $(div).prop('class',' fontStyle  options col-xs-3 col-sm-3 col-lg-3 col-md-3 noPadding');
        else if(i== 1 || i==3)
            $(div).prop('class',' fontStyle  options col-xs-1 col-sm-1 col-lg-1 col-md-1 noPadding');
        else
        {
            $(div).prop('class',' fontStyle  options col-xs-2 col-sm-2 col-lg-2 col-md-2 noPadding');
            $(div).css('margin-left', '1vw');
        }
            
        if(i==4)
        {
            $(div).on('click',function(){
                showNumPad(this.id);
            })
        }
        $(div).prop('id','div'+(i+1));

        if(i<4)
        {
            var span=document.createElement('span');
            $(span).prop('id','span'+(i+1));
            $(span).text(data[langIndex].nodeInfo[N47A.patternCount].numberArr[i]);
            $(div).append(span);
        }
        $('#equation').append(div);
        $(div).css("background-color", "unset")
    }
}

N47A.submitAns=function(){
    
   
    if(clickOption!='')
    {
        if(Utils.mobileDeviceFlag)
            Android.gotoNextGame(scoredmarks, starttime, label);
    
        console.log(scoredmarks,starttime,label);
    }
    else
        showModal()
   // alert("ScoredMarks = " + scoredmarks +","+" "+"Label = " +label);
}

N47A.displayNumber = function (element) {//inputs the number in selected textbox when user clicks the number on numberpad.
    resetVariable=false;
    $("#"+typingDiv).append($('#'+element).text());
}

function showNumPad(ele){
    typingDiv='';
    $('#numberpadDiv').show();
    typingDiv=ele;
}