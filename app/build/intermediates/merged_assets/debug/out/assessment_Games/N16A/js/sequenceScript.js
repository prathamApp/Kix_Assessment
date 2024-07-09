var Sequence = {};
var Utils = {};
Utils.Path = '';
Utils.mobileDeviceFlag = false; 
var questionId = '', startTime = 0, scoredMarks = "0", resId = 0,label='';
Sequence.queCnt=0;
Sequence.attemptFlag=false;
var text;
//function for loader */
$(document).ready(function () {
	if ((navigator.userAgent.match(/Android|BlackBerry|iPhone|iPad|iPod|Opera Mini|IEMobile/i)) && !(window.location.href.includes('http')))
		Utils.mobileDeviceFlag = true;
		showQues();
	Sequence.generateQue();
});
Sequence.generateQue = function () {
	$("#queDiv").hide();
	Sequence.attemptFlag=false;
	if (Utils.mobileDeviceFlag)
	{
		 var val = Android.getGameLang();		//GET ANDROID GAME LANGUAGE
    	//var val = 'Hindi'
        var lang = Sequence.data.find(checkIndex);
        langIndex = Sequence.data.indexOf(lang);
        function checkIndex(i) {
            if (i.language.toLowerCase() == val.toLowerCase())
                return i;
       }
		var gameCode = Android.getGameID();
		Sequence.queCnt=Sequence.data[langIndex].nodeInfo.findIndex(obj=>obj.gameNode==gameCode)
	}
	else
	{
		//var val = 'Urdu-Pakistan';
		langIndex=0;
		Sequence.queCnt=Math.floor(Math.random()*Sequence.data[langIndex].nodeInfo.length);
		//var gameCode="N19B";
		//Sequence.queCnt=Sequence.data.findIndex(obj=>obj.gameNode==gameCode)
	}
	console.log(Sequence.queCnt);
	var d;
	d = new Date();
	startTime = d.getDate() + "-" + (d.getMonth() + 1) + "-" + d.getFullYear() + " " + d.getHours() + ":" + d.getMinutes() + ":" + d.getSeconds();
	$("#queNo").text(Sequence.data[langIndex].nodeInfo[Sequence.queCnt].gameNode);
	document.getElementById("heading").innerHTML=Sequence.data[langIndex].nodeInfo[Sequence.queCnt].queText;
	$("#heading").css("font-size","1.5vw");
	if(val=="Urdu-Pakistan")
		$("#heading").css("direction","rtl");
	questionId=Sequence.data[langIndex].nodeInfo[Sequence.queCnt].gameNode;
	$('#heading').parent().css('font-weight', 'unset');
	document.getElementById("optionsDiv").innerHTML="";
	shuffleArray(Sequence.data[langIndex].nodeInfo[Sequence.queCnt].optionArray);
	if(Sequence.data[langIndex].nodeInfo[Sequence.queCnt].gameNode=="N16A")
	{
		Sequence.createDivs(optionsDiv, 4, 'option', '');
	//	$("#option3,#option4").css("margin-top","17vh");
	//	$("#optionsDiv").css("margin-top","17vh");
	}
	else
		Sequence.createDivs(optionsDiv, 4, 'option', '');
	if(Sequence.data[langIndex].nodeInfo[Sequence.queCnt].gameNode=="N18A")
	{
		$("#queDiv").show();
		for(var i=0;i<4;i++)
			$("#subQueDiv"+i).text(Sequence.data[langIndex].nodeInfo[Sequence.queCnt].queNumbers[i]);
		$("#subQueDiv3").css({"backgroundColor":"white","color":"transparent"});
	}
if(Sequence.data[langIndex].languageFont!=null)
        setFontFamilyForLang(Sequence.data[langIndex].languageFont);
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
//to create no of divs
Sequence.createDivs = function (parentDiv, numberOfDivs, idName, classname) {
	var temp, optionDiv, imgDiv;
		temp = 2;
	for (var i = 1; i <= numberOfDivs; i++) {
		//Sequence.options[i-1]=Sequence.numType[i-1];
		optionDiv = document.createElement("div");
		optionDiv.setAttribute("id", "" + idName + '' + i);
		if(Sequence.differentFormat.includes(Sequence.data[langIndex].nodeInfo[Sequence.queCnt].gameNode))
		{
			optionDiv.setAttribute("class", "optionClass borderClass noPadding col-sm-4 col-lg-4 col-md-4 col-xs-4 col-sm-offset-1 col-lg-offset-1 col-md-offset-1 col-xs-offset-1");
			if((i==1)||(i==3))
			{
			$(optionDiv).css("left", "6vw");
			$("#option1","#option2","#option3","#option4").css("margin-top", "1vh")
			}
		}
		else if(Sequence.data[langIndex].nodeInfo[Sequence.queCnt].gameNode=="N16A")
		{
			optionDiv.setAttribute("class", "noPadding imgClass optionClass borderClass col-sm-5 col-lg-5 col-md-5 col-xs-5 ");
			$("#optionsDiv").addClass("flexClass");
			//$("#option2").css("right","5vw");
		}
		else
		{
			optionDiv.setAttribute("class", "noPadding optionClass borderClass " + classname + " col-xs-" + temp + " col-md-" + temp + " col-lg-" + temp + " col-sm-" + temp);
			$("#optionsDiv").addClass("flexClass");
		}
		parentDiv.appendChild(optionDiv);
		if(Sequence.data[langIndex].nodeInfo[Sequence.queCnt].gameNode=="N16A")
		{
			$(".optionClass").removeClass("borderClass");
			imgDiv = document.createElement("img");
			imgDiv.setAttribute("id",'img' + i);
			optionDiv.appendChild(imgDiv);
			imgDiv.setAttribute("class", "img-responsive optionImg optionImgBorder noPadding col-lg-12 col-md-12 col-xs-12 col-sm-12");
			$("#img" + i).prop("src", Utils.Path + "images/" + Sequence.data[langIndex].nodeInfo[Sequence.queCnt].optionArray[i-1].imgName);
			$("#img" + i).data("ansData", Sequence.data[langIndex].nodeInfo[Sequence.queCnt].optionArray[i-1].number);
			$("#img" + i).data("LData", Sequence.data[langIndex].nodeInfo[Sequence.queCnt].optionArray[i-1].imgName);
			$("#img" + i).data("checkData", "on");
			imgDiv.setAttribute("onclick","Sequence.checkAns(this.id)");
			
		}
		else
		{
			$("#option"+i).text(Sequence.data[langIndex].nodeInfo[Sequence.queCnt].optionArray[i-1]);
			//$("#option"+i).data("dataNum",i);
			$("#option"+i).data("checkData", "on");
			optionDiv.setAttribute("onclick","Sequence.checkOptionsAns(this.id)");
			$(".optionClass").css("margin-top","8vh");
			$(".optionClass").css("backgroundColor","white");
			if(Sequence.data[langIndex].nodeInfo[Sequence.queCnt].gameNode=="N42C")
			$(".optionClass").css("font-size","2.1vw");
		}
	}
}
Sequence.checkOptionsAns=function(ele)
{
	Sequence.attemptFlag=true;
	text=$("#"+ele).text();
	label=text;
	$(".optionClass").removeClass("borderClassImg");
	$(".optionClass").addClass("borderClass");
	$("#"+ele).removeClass("borderClass");
	$("#"+ele).addClass("borderClassImg");
}
Sequence.checkAns=function(element)
{	
	Sequence.attemptFlag=true;
	text=$("#"+element).data("ansData");
	if(text==5)
		label="A";
	else
		label="B";
	label=$("#"+element).data("LData");
	$(".optionImg").removeClass("selectBorder");
	$(".optionImg").addClass("optionImgBorder");
	$("#"+element).removeClass("optionImgBorder");
	$("#"+element).addClass("selectBorder");
} 
Sequence.finalAns=function(){
	if(Sequence.data[langIndex].nodeInfo[Sequence.queCnt].gameNode=="N16A")
	{
		if(text%2==0)
		scoredMarks = "1";
		else
		scoredMarks = "2";
	}
	else
	{
		if(text==Sequence.data[langIndex].nodeInfo[Sequence.queCnt].ans)
		scoredMarks = "2";
		else
		scoredMarks = "1";
	}
	
}
Sequence.nextQue=function()
{
	if(Sequence.attemptFlag)
		Sequence.finalAns();
	else
		scoredMarks = "0";
	//	$('body').css('pointer-events', 'none');
		Sequence.calculateScore();
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
function showQues(){
    $('#questioMark').hide();
    $('#myModal').css('display','block');
}
function hideQuestion(){
    $('#questioMark').show();
    $('#myModal').css('display','none');
}
Sequence.resetGame=function()
{
	Sequence.attemptFlag=false;
	label="null";
	document.getElementById("optionsDiv").innerHTML="";
	if(Sequence.data[langIndex].nodeInfo[Sequence.queCnt].gameNode=="N16A")
	{
		Sequence.createDivs(optionsDiv, 4, 'option', '');
		//$("#option3,#option4").css("top","17vh");
	}
	else
		Sequence.createDivs(optionsDiv, 4, 'option', 'optionClass borderClass ');
}
Sequence.calculateScore = function () {
	if(!Sequence.attemptFlag)
		label="null";
	console.log(scoredMarks,startTime,label);
	if (Utils.mobileDeviceFlag)
		Android.gotoNextGame(scoredMarks,startTime,label);
	//alert("ScoredMarks="+scoredMarks+","+" "+"Label = "+label);
}