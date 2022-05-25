var GeometryShapes = {};

var Utils = {};
Utils.Path = '';
Utils.mobileDeviceFlag = false;
GeometryShapes.randomImg=0;
GeometryShapes.count=0;var langIndex=0;
var questionId = 0, starttime = 0, scoredmarks = '0', resetVar=" ",label='null',resId=0;
$(document).ready(function () {
    
    if ((navigator.userAgent.match(/Android|BlackBerry|iPhone|iPad|iPod|Opera Mini|IEMobile/i)) && !(window.location.href.includes('http')))
        Utils.mobileDeviceFlag = true;
        showQues();
        $('#modalIcon').css('visibility','hidden');
        $("#answerKeyText").append('?');
       // GeometryShapes.getGameCode();
       GeometryShapes.showQuestion();
       $('.code').text('Code');
		
			for(var i=1;i<=3;i++)
				$('#code'+i).text(i-1);
	
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
    $('.styleClass').removeClass('selectClass');
    $(".options").removeClass('border');
    resetVar=" ";
    scoredmarks='0';
    label='null';
}

GeometryShapes.showQuestion=function()
{
    var d;
    scoredmarks = '0';
    d = new Date();
    starttime = d.getDate() + "-" + (d.getMonth() + 1) + "-" + d.getFullYear() + " " + d.getHours() + ":" + d.getMinutes() + ":" + d.getSeconds();

    if (Utils.mobileDeviceFlag) {
        var val = Android.getGameLang();		//GET ANDROID GAME LANGUAGE
        //var val = 'ENGLISH'
        var lang = GeometryShapes.data.find(checkIndex);
        if(lang.language=='Urdu-Pakistan')
        {
            $('#heading').css('direction','rtl');
        }
        langIndex = GeometryShapes.data.indexOf(lang);
		
        function checkIndex(i) {
            if (i.language.toLowerCase().trim() == val.toLowerCase().trim())
                return i;
       }
    }
    else 
		langIndex = 0;//Math.floor(Math.random() * GeometryShapes.data.length);			//GET RANDOM GAME LANGUAGE

    if(Utils.mobileDeviceFlag)
	{
			var val=Android.getGameID();
		/* val='G4A'; */
		var data=GeometryShapes.data[langIndex].nodeInfo.find(checkIndex);
		GeometryShapes.count=GeometryShapes.data[langIndex].nodeInfo.indexOf(data);

		function checkIndex(i){
			if(i.queNo==val)
			return i;
		}
	}
	else
	{
		GeometryShapes.count=Math.floor(Math.random() * (GeometryShapes.data[langIndex].nodeInfo.length ));
	}
   /*  if(GeometryShapes.data[langIndex].nodeInfo[GeometryShapes.count].queNo=='G5A' || GeometryShapes.data[langIndex].nodeInfo[GeometryShapes.count].queNo=='G5B' || GeometryShapes.data[langIndex].nodeInfo[GeometryShapes.count].queNo=='G5C' || GeometryShapes.data[langIndex].nodeInfo[GeometryShapes.count].queNo=='G6A')
        $('.directCode').show();
    else
        $('.directCode').hide(); */
    //shuffleArray(GeometryShapes.data[langIndex].nodeInfo[GeometryShapes.count].images);
    $('#queNo').text(GeometryShapes.data[langIndex].nodeInfo[GeometryShapes.count].queNo);
    questionId=GeometryShapes.data[langIndex].nodeInfo[GeometryShapes.count].queNo;

    GeometryShapes.randomImg=Math.floor(Math.random()*GeometryShapes.data[langIndex].nodeInfo[GeometryShapes.count].images.length);
    /* $('#heading').text(GeometryShapes.data[GeometryShapes.count].question+" ?"); */
	document.getElementById('heading').innerHTML=GeometryShapes.data[langIndex].nodeInfo[GeometryShapes.count].question;
	$('#heading').css('font-size',GeometryShapes.data[langIndex].nodeInfo[GeometryShapes.count].fontSize+'vw');
    GeometryShapes.createDiv('pattern','options col-xs-2 col-sm-2 col-lg-2 col-md-2 col-xs-offset-1  col-sm-offset-1 col-lg-offset-1 col-md-offset-1 noPadding','option');   
}

GeometryShapes.createDiv=function(id,className,parentDiv){
    var labelArr=['A','B','C','D'];
    for(var i=0;i<GeometryShapes.data[langIndex].nodeInfo[GeometryShapes.count].images.length;i++)
    {
        var div=document.createElement('div');
        $(div).prop('id',id+(i+1));
        if(i==0)
            $(div).prop('class','options col-xs-2 col-sm-2 col-lg-2 col-md-2 noPadding');
        else
            $(div).prop('class',className);
        $(div).on('click',function(){
            GeometryShapes.checkAns(this.id);
        });
        $(div).data("imgName",GeometryShapes.data[langIndex].nodeInfo[GeometryShapes.count].images[i]);
        $(div).data("labelName",labelArr[i]);
        var img=document.createElement('img');
        $(img).prop('class','img-responsive col-xs-12 col-sm-12 col-lg-12 col-md-12 noPadding');
        $(img).prop('src','images/'+GeometryShapes.data[langIndex].nodeInfo[GeometryShapes.count].images[i]+'.png');
        $(div).append(img);
        $('#'+parentDiv).append(div);
    }
    if(GeometryShapes.data[langIndex].nodeInfo[GeometryShapes.count].queNo=='G5A' || GeometryShapes.data[langIndex].nodeInfo[GeometryShapes.count].queNo=='G5B' || GeometryShapes.data[langIndex].nodeInfo[GeometryShapes.count].queNo=='G5C' || GeometryShapes.data[langIndex].nodeInfo[GeometryShapes.count].queNo=='G6A')
    {
        $('#modalIcon').css('visibility','visible');
        $('#resetDiv').css('visibility','hidden');
        $(".options").css('pointer-events','none');
    }
    else{
        $('#modalIcon').css('visibility','hidden');
        $('#resetDiv').css('visibility','visible');
        $(".options").css('pointer-events','auto');
    }
}

GeometryShapes.checkAns=function(ele)
{
    $(".options").removeClass('border');
    $('#'+ele).addClass('border');    
    label=$("#"+ele).data("imgName");
    resetVar=$("#"+ele).data("imgName");
    if(GeometryShapes.data[langIndex].nodeInfo[GeometryShapes.count].que==resetVar)
        scoredmarks='2';
    else if(resetVar==" ")
	{
		label='null';
        scoredmarks='0';
	}
    else
        scoredmarks='1';   
}

GeometryShapes.nextQuestion=function(){
    /* $('body').css('pointer-events','none'); */  
    if(Utils.mobileDeviceFlag)
        Android.gotoNextGame(scoredmarks,starttime,label);
    console.log(scoredmarks,starttime,label);
	//alert("ScoredMarks = " + scoredmarks +","+" "+"Label = " +label);
}
/* GeometryShapes.nextGame=function(){
    $('#nextDiv').removeClass('blink_me');
    $(".toBottom").css("pointer-events","none");
    $('.pattern1').hide();
    $('.pattern2').show();
    GeometryShapes.count++;
    GeometryShapes.showQuestion();
} */

 

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

function appendNumbertoText (obj) {
	var givenAnswer=$('#inputText').text().trim()+''+$('#'+obj).text();
	if(givenAnswer.toString().length<=len)
		$("#inputText").text($('#inputText').text().trim()+''+$('#'+obj).text());
};