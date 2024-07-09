var Sequence = {};
var Utils = {};
Utils.Path = '';
Utils.mobileDeviceFlag = false;
Sequence.attemptFlag=false;
var questionId = 0, startTime = 0, scoredMarks = "0", totalMarks = 10, label="";
Sequence.dataText="";
Sequence.randomIndex=0;
Sequence.attemptFlag=false;
//function for loader */
$(document).ready(function () {
	if ((navigator.userAgent.match(/Android|BlackBerry|iPhone|iPad|iPod|Opera Mini|IEMobile/i)) && !(window.location.href.includes('http')))
		Utils.mobileDeviceFlag = true;
		showQues();
	Sequence.generateQue();
});
Sequence.generateQue = function () {
	if (Utils.mobileDeviceFlag) {
       var val = Android.getGameLang();		//GET ANDROID GAME LANGUAGE
    	//var val = 'Hindi'
        var lang = Sequence.data.find(checkIndex);
        langIndex = Sequence.data.indexOf(lang);
        function checkIndex(i) {
            if (i.language.toLowerCase() == val.toLowerCase())
                return i;
       }
    }
	else
		langIndex=1;
	if (Utils.mobileDeviceFlag)
	{
		var gameCode = Android.getGameID();
		Sequence.randomIndex=Sequence.data[langIndex].nodeInfo.findIndex(obj=>obj.gameName==gameCode)
	}
	else
	{
		//var val = 'Urdu-Pakistan'; //8 mozambic 5 kenya
		langIndex=10;
		Sequence.randomIndex=Math.floor(Math.random()*Sequence.data[langIndex].nodeInfo.length);
		/* var gameCode="M32A";
		Sequence.randomIndex=Sequence.data.findIndex(obj=>obj.gameName==gameCode) */
	}
	console.log(Sequence.randomIndex);
	Sequence.attemptFlag=false;
//	Sequence.randomIndex=Math.floor(Math.random()*Sequence.data[langIndex].nodeInfo.length);
	var d;
	d = new Date();
	startTime = d.getDate() + "-" + (d.getMonth() + 1) + "-" + d.getFullYear() + " " + d.getHours() + ":" + d.getMinutes() + ":" + d.getSeconds();
	document.getElementById("heading").innerHTML=Sequence.data[langIndex].nodeInfo[Sequence.randomIndex].queText;
	$("#heading").css("font-size","1.8vw");
	if(val=="Urdu-Pakistan")
		$("#heading").css("direction","rtl");
	$("#queNo").text(Sequence.data[langIndex].nodeInfo[Sequence.randomIndex].gameName);
	questionId=Sequence.data[langIndex].nodeInfo[Sequence.randomIndex].gameName;
	$('#heading').parent().css('font-weight', 'unset');
	$(".directCoding").show();
	$("#answerKeyText").append(Sequence.data[langIndex].ansText+" : "+Sequence.data[langIndex].nodeInfo[Sequence.randomIndex].ans);
	Sequence.createDivs(optionDiv, Sequence.data[langIndex].nodeInfo[Sequence.randomIndex].queImage.length, 'option', '');
	if(Sequence.data[langIndex].nodeInfo[Sequence.randomIndex].gameName=="G16A")
		$("#option3").css("display","none");
	if(Sequence.data[langIndex].nodeInfo[Sequence.randomIndex].gameName=="G15B")
		$("#option1").css("pointer-events","none");
	if(Sequence.data[langIndex].nodeInfo[Sequence.randomIndex].gameName=="G16B")
		$("#optionDiv").css("margin-top","5.5vh");
	if(Sequence.data[langIndex].nodeInfo[Sequence.randomIndex].gameName=="G16D")
		$("#img1").css("pointer-events","none");
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
Sequence.checkAns=function(ele)
{
	Sequence.attemptFlag=true;
	Sequence.dataText=$("#"+ele).data("ansData");
	if(Sequence.data[langIndex].nodeInfo[Sequence.randomIndex].gameName=="G16A")
		$(".optionImg").addClass("optionImgBorder");
	$("#"+ele).removeClass("optionImgBorder");
	$(".optionImg").removeClass("selectBorder");
	$("#"+ele).addClass("selectBorder");
	Sequence.attemptFlag=true;
}
Sequence.nextQue=function()
{
	if(Sequence.data[langIndex].nodeInfo[Sequence.randomIndex].gameName!="G16A" && Sequence.data[langIndex].nodeInfo[Sequence.randomIndex].gameName!="G16D")
	{
	if(Sequence.attemptFlag)
	{
	if(Sequence.dataText==Sequence.data[langIndex].nodeInfo[Sequence.randomIndex].ans)
		scoredMarks = "2";
	else
		scoredMarks = "1";
	}
	else
		scoredMarks = "0";
	//	$('body').css('pointer-events', 'none');
		Sequence.calculateScore();
}
else{
	if(clickOption!="")
	{
		scoredMarks=clickOption;
		Sequence.calculateScore();
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
}
Sequence.createDivs = function (parentDiv, numberOfDivs, idName, classname) {
	var temp, optionDiv, imgDiv;
		temp = 3;
	for (var i = 1; i <= numberOfDivs; i++) {
		optionDiv = document.createElement("div");
		optionDiv.setAttribute("id", "" + idName + '' + i);
		if(Sequence.data[langIndex].nodeInfo[Sequence.randomIndex].gameName=="G16A")
		{
			optionDiv.setAttribute("class", "noPadding col-sm-6 col-lg-6 col-md-6 col-xs-6 col-sm-offset-3 col-lg-offset-3 col-md-offset-3 col-xs-offset-3");
			$(optionDiv).css("top", "3vh");
			$("#option2").css("display","none");
		}
		else if(Sequence.data[langIndex].nodeInfo[Sequence.randomIndex].gameName=="G16B")
		{
			optionDiv.setAttribute("class", "noPadding col-sm-3 col-lg-3 col-md-3 col-xs-3 col-sm-offset-2 col-lg-offset-2 col-md-offset-2 col-xs-offset-2");
			if((i==1)||(i==3))
			$(optionDiv).css("left", "6vw");
		}
		else if(Sequence.data[langIndex].nodeInfo[Sequence.randomIndex].gameName=="G16D")
		{
			optionDiv.setAttribute("class", "noPadding col-lg-12 col-md-12 col-xs-12 col-sm-12");
			$(optionDiv).css("top", "5vh");
		}
		else
		{
			optionDiv.setAttribute("class", "noPadding " + classname + " col-xs-" + temp + " col-md-" + temp + " col-lg-" + temp + " col-sm-" + temp);
			$("#optionDiv").addClass("flexClass");
		}
		parentDiv.appendChild(optionDiv);

		imgDiv = document.createElement("img");
		imgDiv.setAttribute("id",'img' + i);
		optionDiv.appendChild(imgDiv);
		if(Sequence.data[langIndex].nodeInfo[Sequence.randomIndex].gameName=="G16B")
			imgDiv.setAttribute("class", "img-responsive optionImg noPadding col-lg-10 col-md-10 col-xs-10 col-sm-10 ");
		else if(Sequence.data[langIndex].nodeInfo[Sequence.randomIndex].gameName=="G16A" || Sequence.data[langIndex].nodeInfo[Sequence.randomIndex].gameName=="G16D")
			imgDiv.setAttribute("class", "img-responsive optionImg  noPadding col-lg-10 col-md-10 col-xs-10 col-sm-10 col-sm-offset-1 col-lg-offset-1 col-xs-offset-1 col-md-offset-1");
		else
			imgDiv.setAttribute("class", "img-responsive optionImg noPadding col-lg-12 col-md-12 col-xs-12 col-sm-12");
		$("#img" + i).prop("src", Utils.Path + "images/" + Sequence.data[langIndex].nodeInfo[Sequence.randomIndex].queImage[i-1]);
		$("#img" + i).data("ansData",Sequence.data[langIndex].nodeInfo[Sequence.randomIndex].ansDataArray[i-1]);
		if(Sequence.data[langIndex].nodeInfo[Sequence.randomIndex].gameName!="G16A")
			imgDiv.setAttribute("onclick","Sequence.checkAns(this.id)");
	}
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
	$(".optionImg").removeClass("selectBorder");
	if(Sequence.data[langIndex].nodeInfo[Sequence.randomIndex].gameName=="G16A" || Sequence.data[langIndex].nodeInfo[Sequence.randomIndex].gameName=="G16D")
		$(".optionImg").addClass("optionImgBorder");
	Sequence.dataText="";
	label="null";
}
Sequence.calculateScore = function () {
	if(Sequence.attemptFlag)
		label=Sequence.dataText;
	else
		label="null";
	console.log(scoredMarks,startTime,label);
	if (Utils.mobileDeviceFlag)
		Android.gotoNextGame(scoredMarks,startTime,label);
	//alert("ScoredMarks="+scoredMarks+","+" "+"Label = "+label);
}