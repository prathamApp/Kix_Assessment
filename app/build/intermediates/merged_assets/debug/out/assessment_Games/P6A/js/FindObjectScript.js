var P6A = {};
var Utils = {};
Utils.Path = '';
Utils.mobileDeviceFlag = false;
var starttime = "0", scoredmarks = "0", label ="",langIndex,labelStr="";
$(document).ready(function () {
	$(".se-pre-con").fadeOut("slow");
	if((navigator.userAgent.match(/Android|BlackBerry|iPhone|iPad|iPod|Opera Mini|IEMobile/i)) && !(window.location.href.includes('http')))
        Utils.mobileDeviceFlag = true;
	setTimeout(function () {
       P6A.init();
	}, 100);
}); 
P6A.init = function()
{
    $('#questioMark').hide();
    P6A.initializeVariables ();
	if (Utils.mobileDeviceFlag) {
        var val = Android.getGameLang();		//GET RANDOM GAME LANGUAGE
        var lang = P6A.Data.find(checkIndex);
        langIndex = P6A.Data.indexOf(lang);
		
        function checkIndex(i) {
            if (i.language.toLowerCase() == val.toLowerCase())
                return i;
       }
	   if(val=="Urdu-Pakistan"){
		$("#heading").css("direction","rtl");
		}
	   var val1=Android.getGameID();		//GET GAME CODE
		var data=P6A.Data[langIndex].nodeInfo.find(checkIndex1);
		P6A.level=P6A.Data[langIndex].nodeInfo.indexOf(data);
		
		function checkIndex1(i){
		if(i.gameName==val1)
		return i;
		}
	 }
    else{
		langIndex =11;		//GET RANDOM GAME LANGUAGE
		P6A.level=Math.floor(Math.random()*P6A.Data[langIndex].nodeInfo.length);
		if(langIndex==14){
		$("#heading").css("text-align","right");
		$("#heading").css("direction","rtl");
		}
	}
	 if(P6A.Data[langIndex].languageFont!=null)
           setFontFamilyForLang(P6A.Data[langIndex].languageFont);
    d = new Date();  //date object
	starttime = d.getDate() + "-" + (d.getMonth() + 1) + "-" + d.getFullYear() + " " + d.getHours() + ":" + d.getMinutes() + ":" + d.getSeconds();  //to get the current date
   P6A.playGame ();
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
P6A.initializeVariables = function()
{
    P6A.answer;//stored answer
    P6A.Counter;
    P6A.level;
    P6A.selectRandomImage=[];
    P6A.attemptFlag=false;
    P6A.answerArray=[];
    P6A.str="";
    P6A.currentClickId;
	P6A.noOfBlocks;
}
P6A.playGame = function(object)
{
    P6A.initializeVariables();
	document.getElementById("questionImage").src = Utils.Path+"images/"+P6A.Data[langIndex].nodeInfo[P6A.level].levelData[0].img;
    document.getElementById("queNo").innerHTML=P6A.Data[langIndex].nodeInfo[P6A.level].gameName;
    document.title =P6A.Data[langIndex].nodeInfo[P6A.level].gameName;
    document.getElementById("heading").innerHTML=P6A.Data[langIndex].nodeInfo[P6A.level].Instruction;
    P6A.showOptions();
    P6A.showAnswerDiv();
}
function showQues()
{
    $('#questioMark').hide();
    $('#myModal').css('display','block');
}
function hideQuestion()
{
    $('#questioMark').show();
    $('#myModal').css('display','none');
}
P6A.showOptions=function()
{
	P6A.str=P6A.Data[langIndex].nodeInfo[P6A.level].pattern.split("");
    for(var j=0;j<P6A.Data[langIndex].nodeInfo[P6A.level].levelData[0].option.length;j++)//no of image  rows
    {
        var imageDiv = document.createElement("div");
        imageDiv.setAttribute("id", "optionDiv"+j);
        imageDiv.setAttribute("class", "  cls col-lg-4 col-md-4 col-sm-4 col-xs-4 ");
        document.getElementById('optionDiv').appendChild(imageDiv);
        imageDiv.setAttribute("onclick", "P6A.getAnswer(this)");
        imageDiv.setAttribute("data",P6A.Data[langIndex].nodeInfo[P6A.level].levelData[0].option[j]);
		if(P6A.Data[langIndex].nodeInfo[P6A.level].gameName=="P7A"){
		imageDiv.setAttribute("Answerdata",P6A.str[j+1]);}
		else if(P6A.Data[langIndex].nodeInfo[P6A.level].gameName=="P6A"){
			if(j<3)
				imageDiv.setAttribute("Answerdata",P6A.str[0]);
			else
				imageDiv.setAttribute("Answerdata",P6A.str[1]);
		}
		else {
			if(j<1)
				imageDiv.setAttribute("Answerdata",P6A.str[2]);
			else
				imageDiv.setAttribute("Answerdata",P6A.str[0]);
		}
        var img = document.createElement("img");
        img.setAttribute("id", "optionimg"+j);
        img.setAttribute("class", "noPadding img-responsive imageCls col-lg-12 col-md-12 col-sm-12 col-xs-12");
        imageDiv.appendChild(img);
        img.src = Utils.Path + "images/"+P6A.Data[langIndex].nodeInfo[P6A.level].levelData[0].option[j];
    } 
	/*if(P6A.Data[langIndex].nodeInfo[P6A.level].gameName=="P8A")
		P6A.Data[langIndex].nodeInfo[P6A.level].levelData[0].option.splice(0, 1);*/
	if(P6A.Data[langIndex].nodeInfo[P6A.level].gameName=="P6A" || P6A.Data[langIndex].nodeInfo[P6A.level].gameName=="P7A"){
		var a=P6A.Data[langIndex].nodeInfo[P6A.level].levelData[0].option[0];
		P6A.Data[langIndex].nodeInfo[P6A.level].levelData[0].option[0]=P6A.Data[langIndex].nodeInfo[P6A.level].levelData[0].option[1]
		P6A.Data[langIndex].nodeInfo[P6A.level].levelData[0].option[1]=a;}
		
}
//display question and images
P6A.showAnswerDiv=function()
{
	if(P6A.Data[langIndex].nodeInfo[P6A.level].gameName=="P6A"){
		P6A.noOfBlocks=6;
	    P6A.Counter=1;
		}
	else if(P6A.Data[langIndex].nodeInfo[P6A.level].gameName=="P7A"){
		P6A.noOfBlocks=6;
		P6A.Counter=1;
	}
	else{
		P6A.noOfBlocks=6;
		P6A.Counter=1;
	}
    for(var j=0;j<P6A.noOfBlocks;j++)//no of image  rows
    {
        var imageDiv = document.createElement("div");
        imageDiv.setAttribute("id", "answerDiv"+j);
        imageDiv.setAttribute("class", "  ansCls col-lg-1 col-md-1 col-sm-1 col-xs-1 ");
        document.getElementById('answerDiv').appendChild(imageDiv);

        var img = document.createElement("img");
        img.setAttribute("id", "answerimg"+j);
        img.setAttribute("class", "noPadding img-responsive  col-lg-12 col-md-12 col-sm-12 col-xs-12");
        imageDiv.appendChild(img);
		if(j>0)
		{
			$("#" +"answerimg"+j).addClass("imgcls");
		}
		if(P6A.Data[langIndex].nodeInfo[P6A.level].gameName=="P6A" ){
		if(j<P6A.Data[langIndex].nodeInfo[P6A.level].levelData[0].option.length-4)
			    img.src = Utils.Path + "images/"+P6A.Data[langIndex].nodeInfo[P6A.level].levelData[0].option[3];
		}
		else if( P6A.Data[langIndex].nodeInfo[P6A.level].gameName=="P7A"){
			if(j<P6A.Data[langIndex].nodeInfo[P6A.level].levelData[0].option.length-1)
			        img.src = Utils.Path + "images/"+P6A.Data[langIndex].nodeInfo[P6A.level].levelData[0].option[j];
		}else if( P6A.Data[langIndex].nodeInfo[P6A.level].gameName=="P8A"){
			if(j<P6A.Data[langIndex].nodeInfo[P6A.level].levelData[0].option.length-4)
			        img.src = Utils.Path + "images/"+P6A.Data[langIndex].nodeInfo[P6A.level].levelData[0].option[0];
		}
    }
    $("#" +"answerDiv"+P6A.Counter).addClass("Blink_me");
	$('#heading').parent().css('font-weight', 'unset');
}
P6A.getAnswer=function(object)
{
	$("#" +"answerimg"+(P6A.Counter)).addClass("addimage");
    P6A.attemptFlag=true;
    P6A.answer="";
    $(P6A.currentClickId).removeClass("border");
    P6A.currentClickId=document.getElementById(object.id);
    $("#" +object.id).addClass("border");
    if(P6A.Counter==P6A.noOfBlocks)
    {
      document.getElementById("optionDiv").style.pointerEvents = "none";
    }
    P6A.answer=document.getElementById(object.id).getAttribute("data");
    P6A.answerArray.push(document.getElementById(object.id).getAttribute("Answerdata"));
	labelStr=labelStr.concat(document.getElementById(object.id).getAttribute("Answerdata"));
    document.getElementById("answerimg"+P6A.Counter).src = Utils.Path+"images/"+P6A.answer;
	$("#" +"answerimg"+P6A.Counter).addClass("imageCls");
    $("#" +"answerDiv"+P6A.Counter).removeClass("Blink_me");
    P6A.Counter++;
    $("#" +"answerDiv"+P6A.Counter).addClass("Blink_me");
	setTimeout(function () {
	if(P6A.Data[langIndex].nodeInfo[P6A.level].gameName=="P6A" || P6A.Data[langIndex].nodeInfo[P6A.level].gameName=="P8A"){
	    var elementToBeRemoved = document.getElementById(object.id);
    elementToBeRemoved.parentNode.removeChild(elementToBeRemoved);}
	}, 500);
}
P6A.NextLevel=function()
{
    //document.body.style.pointerEvents = "none";
	document.getElementById("optionDiv").style.pointerEvents = "auto";
    $(P6A.currentClickId).removeClass("border");
    var flag=true;
    if (P6A.answerArray.length == P6A.str.length) {
        for (var i = 0; i < P6A.answerArray.length; i++) {
            if (P6A.answerArray[i] != P6A.str[i]) {
                flag=false;            }
        }
    } else {
        flag=false;            }
    if(flag==true){
		label=P6A.Data[langIndex].nodeInfo[P6A.level].pattern;
        scoredmarks="2";
		//alert("correct");
	}
    else if(P6A.attemptFlag==false) 
	{		
		label="null";
        scoredmarks="0";   
	}		
    else if(flag==false){
		label=labelStr;
        scoredmarks="1";
		//alert("wrong");
	}
	P6A.scoreFunction();
    document.getElementById('answerDiv').innerHTML="";
	document.getElementById('optionDiv').innerHTML="";
    P6A.Counter;
	P6A.attemptFlag=false;
    P6A.answerArray=[];
	labelStr="";
    P6A.showAnswerDiv();
	P6A.showOptions();
}
P6A.scoreFunction = function () {
    console.log(scoredmarks,starttime, label);
    if (Utils.mobileDeviceFlag) {
		Android.gotoNextGame(scoredmarks, starttime, label);
    }
}    
P6A.resetAll=function()
{
    document.getElementById('answerDiv').innerHTML="";
	    $(P6A.currentClickId).removeClass("border");
   document.getElementById('optionDiv').innerHTML="";
	document.getElementById("optionDiv").style.pointerEvents = "auto";
    P6A.Counter;
	labelStr="";
	P6A.attemptFlag=false;
    P6A.answerArray=[];
    P6A.showAnswerDiv();
	P6A.showOptions();
}