
Jigsaw={};
var Utils={};
Utils.Path='';
Utils.mobileDeviceFlag = false;
Jigsaw.attemptFlag = false;
var img;
nodeIndex=0;					//first demo Que
var startTime = '', scoredMarks = '0', label='null',langIndex;
var numColsToCut = 3, numRowsToCut = 2;
$(document).ready(function()
{
	if((navigator.userAgent.match(/Android|BlackBerry|iPhone|iPad|iPod|Opera Mini|IEMobile/i)) && !(window.location.href.includes('http')))
		Utils.mobileDeviceFlag=true;
	
	$('.modal').css('padding', '0');
	showQues();
	if (Utils.mobileDeviceFlag) {
		var val = Android.getGameLang();		//GET ANDROID GAME LANGUAGE
		//var val = 'Urdu-Pakistan'
		var lang = Jigsaw.Data.find(checkIndex);
		langIndex = Jigsaw.Data.indexOf(lang);
		if (lang.language == 'Urdu-Pakistan')
			$('#heading').css('direction','rtl')
		function checkIndex(i) {
			if (i.language.toLowerCase().trim() == val.toLowerCase().trim())
				return i;
		}
	}
	else
		langIndex = 5;/* Math.floor(Math.random() * Jigsaw.Data.length);		//GET RANDOM GAME LANGUAGE */
	/* var val = 'Urdu-Pakistan'
		if (val == 'Urdu-Pakistan')
		$('#heading').css('direction','rtl') */
	Jigsaw.setImage();
	Jigsaw.init();
});
Jigsaw.setImage=function()
{
	$('#originalImg').prop('src',Utils.Path+"images/"+Jigsaw.Data[langIndex].nodeInfo[nodeIndex].img+".png");
if(Jigsaw.Data[langIndex].languageFont!=null)
        setFontFamilyForLang(Jigsaw.Data[langIndex].languageFont);
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
function showQues(){
    $('#questioMark').hide();
    $('#myModal').css('display','block');
}
function hideQuestion(){
    $('#questioMark').show();
    $('#myModal').css('display','none');
}
Jigsaw.init=function()
{
	var d;
	d = new Date();
	startTime = d.getDate() + "-" + (d.getMonth() + 1) + "-" + d.getFullYear() + " " + d.getHours() + ":" + d.getMinutes() + ":" + d.getSeconds();
	//nodeIndex = Android.getGameID();		//get game code
	Jigsaw.createImageParts();
}
Jigsaw.createImageParts=function()
{
	Jigsaw.imgCutArr=[];			//cut images
	Jigsaw.positionArray = [];		//position of cut images
	Jigsaw.attemptFlag = false;
	document.getElementById("jigsawDiv").innerHTML = "";
	document.getElementById("heading").innerHTML =Jigsaw.Data[langIndex].nodeInfo[nodeIndex].instruction
	$('#queNo').text(Jigsaw.Data[langIndex].nodeInfo[nodeIndex].gameCode);
	img=new Image();
	img.onload = Jigsaw.drawImg;
	if (nodeIndex==0)
	{
		$('#heading').css('font-size', '1.8vw');
		img.src = Utils.Path + "images/"+Jigsaw.Data[langIndex].nodeInfo[nodeIndex].img+".png";
	}
	else
	{
		$('#heading').css('font-size', '1.6vw');
		document.getElementById('originalImg').src = Utils.Path + "images/"+Jigsaw.Data[langIndex].nodeInfo[nodeIndex].img+".png";
		img.src = Utils.Path + "images/"+Jigsaw.Data[langIndex].nodeInfo[nodeIndex].img+".png";
	}
	$('#heading').parent().css('font-weight', 'unset');
	label=Jigsaw.Data[langIndex].nodeInfo[nodeIndex].imgName;
}
Jigsaw.drawImg=function()
{
	var jigsawDiv,index=0,ans=1,tempArr=[];
	document.getElementById("jigsawDiv").innerHTML="";
	var imgX = 0, imgY = 0, imgHeight = Math.floor(img.height / numRowsToCut), imgWidth = Math.floor(img.width / numColsToCut), dheight = 100, dwidth = 100;
	Jigsaw.imgCutArr=[];
	jigsawDiv=document.getElementById("jigsawDiv");
	
    for(var x = 0; x < numRowsToCut; ++x)
	{
		var outerDiv,mainDiv,div;
		outerDiv=document.createElement("div");
		outerDiv.id="outerDiv"+x;
		outerDiv.className="outerDivClass col-sm-12 col-lg-12 col-md-12 col-xs-12 noPadding";
		outerDiv.style.height=(100/numRowsToCut)+"%";
		jigsawDiv.append(outerDiv);
		for(var y = 0; y < numColsToCut; ++y)
		{
			mainDiv=document.createElement('div');
			mainDiv.id="mainDiv"+x+""+y;
			// mainDiv.className=" noPadding ";
			mainDiv.style.width = (100 / numColsToCut) + "%";
			$(mainDiv).css('padding', '0.1vw');
			div=document.createElement('div');
			div.id="div"+x+""+y;
			div.className="dragClass noPadding ";
			
			this.subCanvas=document.createElement("canvas");
			this.subContext=this.subCanvas.getContext("2d");
			this.subCanvas.className="jigsawCanvas";
			$(div).append(this.subCanvas);
			this.subCanvas.id=x+""+y;
			dheight=this.subCanvas.height;
			dwidth = this.subCanvas.width;
			this.subContext.drawImage(img,imgX,imgY,imgWidth,imgHeight,0,0,dwidth,dheight );
			imgX=imgX+imgWidth;
			$(div).data("value",ans);
			$(mainDiv).data("value",ans);
			ans++;
			tempArr.push(div);
			$("#outerDiv"+x).append(mainDiv);
		}
		dx=0;
		imgX=0;
		imgY=imgY+imgHeight;
	}
	for (var i = 0; i < Jigsaw.Data[langIndex].nodeInfo[nodeIndex].position.length; i++)
		Jigsaw.imgCutArr.push(tempArr[Jigsaw.Data[langIndex].nodeInfo[nodeIndex].position[i]])
	for(var x = 0; x < numRowsToCut; ++x)
	{
		for(var y = 0; y < numColsToCut; ++y)
		{
			$("#mainDiv"+x+""+y).droppable({drop :Jigsaw.onDrop,dragover:allowDrop,});
			$("#mainDiv"+x+""+y).append(Jigsaw.imgCutArr[index]);
			index++;
		}
	}
	for(var i=0;i<Jigsaw.imgCutArr.length;i++)
	{
		if( $(Jigsaw.imgCutArr[i]).data("value")==$(Jigsaw.imgCutArr[i]).parent().data("value"))
			Jigsaw.positionArray.push($(Jigsaw.imgCutArr[i]).data("value"));
	}
	 $('.dragClass').draggable({
		zIndex:900,
		revert:"invalid"
		});
}
Jigsaw.onDrop=function(event,ui)
{
	var src, srcDiv, dst, dstDiv;
	Jigsaw.attemptFlag = true;
	src=ui.draggable;
	srcDiv=$(src).parent();
	dstDiv=$(this);
	dst=$(dstDiv).children();
	$(dstDiv).append(src);
	$(srcDiv).append(dst);
	$(src).width('100%');
	$(src).css({'height':'100%','top':'0px','left':'0px'});
	Jigsaw.checkPieces(src,srcDiv,dst,dstDiv);
	
}
Jigsaw.checkPieces=function(src,srcDiv,dst,dstDiv)
{
	var srcData=0,srcDivData=0,dstData=0,dstDivData=0;
	srcData=$(src).data("value");
	srcDivData=$(srcDiv).data("value");
	dstData=$(dst).data("value");
	dstDivData=$(dstDiv).data("value");
	
	if(srcData==dstDivData)
	{
		if(!Jigsaw.positionArray.includes(srcData))
			Jigsaw.positionArray.push(srcData);
	}
	else
	{
		if(Jigsaw.positionArray.includes(srcData))
			Jigsaw.positionArray.splice(Jigsaw.positionArray.indexOf(srcData),1);
	}
	if(srcDivData==dstData)
	{
		if(!Jigsaw.positionArray.includes(srcDivData))
			Jigsaw.positionArray.push(srcDivData);
	}
	else
	{
		if(Jigsaw.positionArray.includes(srcDivData))
			Jigsaw.positionArray.splice(Jigsaw.positionArray.indexOf(srcDivData),1);
	}
}
Jigsaw.checkAnswer = function ()
{
	if(Jigsaw.positionArray.length==Jigsaw.imgCutArr.length)
		scoredMarks='2';
	else
	{
		if (Jigsaw.attemptFlag)
			scoredMarks='1';
			else
			scoredMarks='0';
	}
		
}
function allowDrop(event)
{
	event.preventDefault();
}
Jigsaw.nextQue=function()
{
	nodeIndex++;
	if(nodeIndex==1)
		Jigsaw.createImageParts();
	if (nodeIndex > 1)
	{nodeIndex--;
		Jigsaw.checkAnswer();
		console.log(scoredMarks, startTime, label)
		//alert("ScoredMarks = " + scoredMarks +","+" "+"Label = " +label);
		if(Utils.mobileDeviceFlag)
		Android.gotoNextGame(scoredMarks, startTime, label);
	}
}
resetGame = function ()
{
	Jigsaw.createImageParts();
}
