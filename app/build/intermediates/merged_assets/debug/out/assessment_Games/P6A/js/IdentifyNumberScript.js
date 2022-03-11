//Starting Date:- 18/02/2021
var IdentifyNumber = {};
var Utils = {};
Utils.Path = '';
Utils.mobileDeviceFlag = false;
$(document).ready(function () {
	$(".se-pre-con").fadeOut("slow");
	if((navigator.userAgent.match(/Android|BlackBerry|iPhone|iPad|iPod|Opera Mini|IEMobile/i)) && !(window.location.href.includes('http')))
        Utils.mobileDeviceFlag = true;
	setTimeout(function () {
		IdentifyNumber.init();
	}, 100);
}); 

IdentifyNumber.init = function()
{
    $("#gamePage").show();
    document.body.style.backgroundImage = "url('images/skin/coverpage.jpg')";
	document.title = IdentifyNumber.hardCodeddata.NameoftheGame;
    IdentifyNumber.setAllImages();
    IdentifyNumber.playGame ();
}
IdentifyNumber.initializeVariables = function()
{
    IdentifyNumber.answer;//stored answer
    IdentifyNumber.selectUniqueNumber=[];
    IdentifyNumber.storedOption=[];
    IdentifyNumber.NoOfBlankFields=0;
}
IdentifyNumber.setAllImages = function()
{
    document.getElementById("logoImage").src = Utils.Path+"images/skin/logo.png";
    document.getElementById("nextImage").src = Utils.Path+"images/skin/Next.png";
}
IdentifyNumber.playGame = function(object)
{
    IdentifyNumber.initializeVariables();
    var counter=0;
    for(var j=1;j<10;j++)//no of image  rows
    {
        var imageDiv = document.createElement("div");
        imageDiv.setAttribute("id", "div"+j);
        imageDiv.setAttribute("class", " nopadding cls col-lg-1 col-md-1 col-sm-1 col-xs-1");
        imageDiv.setAttribute("data",IdentifyNumber.data[counter].imgName);
        imageDiv.setAttribute("onclick", "IdentifyNumber.checkAnswer(this)");
        document.getElementById('questionDiv').appendChild(imageDiv);

        var img = document.createElement("img");
        img.setAttribute("id", "img"+j);
        img.setAttribute("class", "nopadding img-responsive  col-lg-12 col-md-12 col-sm-12 col-xs-12");
        imageDiv.appendChild(img);
        img.src = Utils.Path + "images/"+IdentifyNumber.data[counter].imgName;
        if(j%3==0)
        counter=0;
        else
        counter++;
    }
    console.log(IdentifyNumber.answer);
    IdentifyNumber.hideObject();
    IdentifyNumber.showOptions();
}
IdentifyNumber.hideObject=function()
{
    IdentifyNumber.selectRandomImage=[];
    for (var j = 0; j < 3; j++) {
		var randomNumber = Math.floor(Math.random() *(10-1)+1);
		while (IdentifyNumber.selectRandomImage.includes(randomNumber)) {
			randomNumber = Math.floor(Math.random() * (10-1)+1);
		}
		IdentifyNumber.selectRandomImage.push(randomNumber);
    }
    for(var j=1;j<IdentifyNumber.selectRandomImage.length;j++)//no of image  rows
    {
       // var image=document.getElementById("img"+IdentifyNumber.selectRandomImage[j]).getAttribute("data");
       // IdentifyNumber.storedOption.push(image);
        document.getElementById("img"+IdentifyNumber.selectRandomImage[j]).style.visibility="hidden";
        document.getElementById("div"+IdentifyNumber.selectRandomImage[j]).style.borderBottom = " solid black";

    }
    console.log(IdentifyNumber.storedOption);
}
//display question and images
IdentifyNumber.showOptions=function()
{
    var counter=0;
    for(var j=1;j<4;j++)//no of image  rows
    {
        var imageDiv = document.createElement("div");
        imageDiv.setAttribute("id", "optiondiv"+j);
        imageDiv.setAttribute("class", " nopadding  col-lg-1 col-md-1 col-sm-1 col-xs-1 col-xs-offset-1 col-sm-offset-1 col-md-offset-1 col-lg-offset-1");
        document.getElementById('optionDiv').appendChild(imageDiv);

        var img = document.createElement("img");
        img.setAttribute("id", "optionimg"+j);
        img.setAttribute("class", "nopadding img-responsive  col-lg-9 col-md-9 col-sm-9 col-xs-9");
        imageDiv.appendChild(img);
        img.src = Utils.Path + "images/"+IdentifyNumber.data[counter].imgName;
        img.setAttribute("onclick", "IdentifyNumber.getAnswer(this)");
        img.setAttribute("data",IdentifyNumber.data[counter].imgName);
        counter++;
    }
}
IdentifyNumber.getAnswer=function(object)
{
    IdentifyNumber.answer="";
    IdentifyNumber.answer=document.getElementById(object.id).getAttribute("data");
}
//check Answer
IdentifyNumber.checkAnswer=function(object)
{
    if(IdentifyNumber.answer==document.getElementById(object.id).getAttribute("data"))
    {
        $("#playSound").prop("src",Utils.Path+'sounds/Right_answer__Aditi.mp3');
        document.getElementById("playSound").play();
        var str=object.id;
        var no=str.slice(3);
        document.getElementById("img"+no).style.visibility="visible";
        document.getElementById(object.id).style.borderBottom = "none";
    }
    else
    {
        $("#playSound").prop("src",Utils.Path+'sounds/wrong_answer!_Aditi.mp3');
        document.getElementById("playSound").play();
    }
    IdentifyNumber.NoOfBlankFields++;
    if(IdentifyNumber.NoOfBlankFields==2)
     document.getElementById("questionDiv").style.pointerEvents = "none";
}
