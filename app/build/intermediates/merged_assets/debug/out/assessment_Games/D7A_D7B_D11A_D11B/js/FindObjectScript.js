var D7A = {};
var Utils = {};
Utils.Path = '';
Utils.mobileDeviceFlag = false;
var startTime = "0", scoredMarks = "0", label ="",langIndex,gameFlag=false;
$(document).ready(function () {
	$(".se-pre-con").fadeOut("slow");
	if((navigator.userAgent.match(/Android|BlackBerry|iPhone|iPad|iPod|Opera Mini|IEMobile/i)) && !(window.location.href.includes('http')))
        Utils.mobileDeviceFlag = true;
	setTimeout(function () {
       D7A.init();
	}, 100);
}); 
D7A.initializeVariables = function()
{
    D7A.answer="";//stored answer
    D7A.level;
    D7A.selectRandomImage=[];
    D7A.attemptFlag=false;
    D7A.currentClickId;
}
D7A.init = function()
{
    $('#questioMark').hide();
    D7A.initializeVariables ();
	if (Utils.mobileDeviceFlag) {
        var val = Android.getGameLang();		//GET RANDROID GAME LANGUAGE
        var lang = D7A.Data.find(checkIndex);
        langIndex = D7A.Data.indexOf(lang);
		
        function checkIndex(i) {
            if (i.language.toLowerCase() == val.toLowerCase())
                return i;
       }
	   if(val=="Urdu-Pakistan"){
		$("#heading").css("direction","rtl");
		}
	   var val1=Android.getGameID();		//GET GAME CODE
		var data=D7A.Data[langIndex].nodeInfo.find(checkIndex1);
		D7A.level=D7A.Data[langIndex].nodeInfo.indexOf(data);
		
		function checkIndex1(i){
		if(i.gameName==val1)
		return i;
		}
	  }
    else{
		langIndex =11;		//GET RANDOM GAME LANGUAGE
		D7A.level=Math.floor(Math.random()*D7A.Data[langIndex].nodeInfo.length);//GET RANDOM GAME CODE
		if(langIndex==14){
		$("#heading").css("text-align","right");    
		$("#heading").css("direction","rtl");
		}
	}
	 if(D7A.Data[langIndex].languageFont!=null)
           setFontFamilyForLang(D7A.Data[langIndex].languageFont);
  d = new Date();  //date object
    startTime = d.getDate() + "-" + (d.getMonth() + 1) + "-" + d.getFullYear() + " " + d.getHours() + ":" + d.getMinutes() + ":" + d.getSeconds();  //to get the current date
    D7A.playGame ();
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
D7A.playGame = function(object)
{
    D7A.initializeVariables();
	$("#answerKeyText").append(D7A.Data[langIndex].AnswerKeyText);
   $("#answerKeyText").append(D7A.Data[langIndex].nodeInfo[D7A.level].Answer);
   if(D7A.Data[langIndex].nodeInfo[D7A.level].gameName=="D11B")
   {
	    $('#modalIcon').css('visibility','hidden');
   }
   else{
	 $('#resetDiv').css('visibility','hidden');  
   }
   if(D7A.Data[langIndex].nodeInfo[D7A.level].gameName=="D8B" || D7A.Data[langIndex].nodeInfo[D7A.level].gameName=="D9A")
	{
		 document.getElementById("questionImage").setAttribute("class", " noPadding  col-lg-11 col-md-11 col-sm-11 col-xs-11 ");
	}
	if(D7A.Data[langIndex].nodeInfo[D7A.level].gameName=="D7B" || D7A.Data[langIndex].nodeInfo[D7A.level].gameName=="D8B" || D7A.Data[langIndex].nodeInfo[D7A.level].gameName=="D9A" || D7A.Data[langIndex].nodeInfo[D7A.level].gameName=="D11B")
	{
		gameFlag = true;
		if(D7A.Data[langIndex].nodeInfo[D7A.level].gameName=="D11B")
			D7A.showOptions();
		document.getElementById("questionImage").src = Utils.Path+"images/"+D7A.Data[langIndex].nodeInfo[D7A.level].QueImg;
	   document.getElementById("queNo").innerHTML=D7A.Data[langIndex].nodeInfo[D7A.level].gameName;
	   document.title =D7A.Data[langIndex].nodeInfo[D7A.level].gameName;
	   document.getElementById("heading").innerHTML=D7A.Data[langIndex].nodeInfo[D7A.level].Instruction;
	}
	else{
	$('#resetDiv').css('visibility','hidden');
	document.getElementById("questionImage").src = Utils.Path+"images/"+D7A.Data[langIndex].imgName;
    document.getElementById("queNo").innerHTML=D7A.Data[langIndex].Name1;
   document.title =D7A.Data[langIndex].Name1;
    document.getElementById("heading").innerHTML=D7A.Data[langIndex].instrText2;
	}
	$('#heading').parent().css('font-weight', 'unset');
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
D7A.showOptions=function()
{
	var labelArray=["A","B","C","D"];
    for(var j=0;j<D7A.Data[langIndex].nodeInfo[D7A.level].options.length;j++)//no of image  rows
    {
        var imageDiv = document.createElement("div");
        imageDiv.setAttribute("id", "optionDiv"+j);
        imageDiv.setAttribute("class", " noPadding cls col-lg-3 col-md-3 col-sm-3 col-xs-3 ");
        document.getElementById('optionDiv').appendChild(imageDiv);
        imageDiv.setAttribute("onclick", "D7A.getAnswer(this)");
        imageDiv.setAttribute("data",D7A.Data[langIndex].nodeInfo[D7A.level].options[j]);
		imageDiv.setAttribute("label",labelArray[j]);
 
        var img = document.createElement("img");
        img.setAttribute("id", "optionimg"+j);
        img.setAttribute("class", "noPadding img-responsive imageCls col-lg-12 col-md-12 col-sm-12 col-xs-12");
        imageDiv.appendChild(img);
        img.src = Utils.Path + "images/"+D7A.Data[langIndex].nodeInfo[D7A.level].options[j];
    } 
}
D7A.getAnswer=function(object)
{
    D7A.attemptFlag=true;
    D7A.answer="";
    $(D7A.currentClickId).removeClass("border");
    D7A.currentClickId=document.getElementById(object.id);
    $("#" +object.id).addClass("border");
    D7A.answer=document.getElementById(object.id).getAttribute("data");
    label=document.getElementById(object.id).getAttribute("label");
}
D7A.NextLevel=function()
{
	if(!gameFlag)
	{
        gameFlag = true;
		$('#resetDiv').css('visibility','visible');
		D7A.showOptions();
		document.getElementById("questionImage").src = Utils.Path+"images/"+D7A.Data[langIndex].nodeInfo[D7A.level].QueImg;
	   document.getElementById("queNo").innerHTML=D7A.Data[langIndex].nodeInfo[D7A.level].gameName;
	   document.title =D7A.Data[langIndex].nodeInfo[D7A.level].gameName;
	   document.getElementById("heading").innerHTML=D7A.Data[langIndex].nodeInfo[D7A.level].Instruction;
	}
	else
	{
		$(D7A.currentClickId).removeClass("border");
		if(D7A.Data[langIndex].nodeInfo[D7A.level].gameName=="D11B"){
		var flag=true;
		if (  D7A.answer == D7A.Data[langIndex].nodeInfo[D7A.level].Answer ) {
		scoredMarks="2";}
		else if(D7A.attemptFlag==false)  
		{
			label="null";
			scoredMarks="0";     
		}
		else if(D7A.attemptFlag=true && D7A.answer != D7A.Data[langIndex].nodeInfo[D7A.level].Answer){
			scoredMarks="1";
		}
		}
		//alert("ScoredMarks = " + scoredmarks +","+" "+"Label = " +label);
		if(D7A.Data[langIndex].nodeInfo[D7A.level].gameName=="D11B")
		{
			D7A.scoreFunction();
		}
		else{
			label="null";
		if(clickOption!="")
		{
			scoredMarks=clickOption;
			D7A.scoreFunction();
		}
		else
		{
			showModal();
		}}
	}
}
D7A.scoreFunction = function () {
    console.log(scoredMarks,startTime, label);
    if (Utils.mobileDeviceFlag) {
		Android.gotoNextGame(scoredMarks, startTime, label);
    }
}    
D7A.resetAll=function()
{
    document.getElementById('optionDiv').innerHTML="";
	D7A.answer="";//stored answer
    D7A.attemptFlag=false;
    D7A.showOptions();
}