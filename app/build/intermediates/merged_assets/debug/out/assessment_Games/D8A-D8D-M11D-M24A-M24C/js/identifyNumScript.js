var D8A = {};
Utils={};
Utils.Path = " ";
Utils.mobileDeviceFlag = false;
var startTime = "0", scoredMarks = "0", label = "",scoreFlag = false,gameFlag=false,G19AFlag = false;
D8A.currentQues = 1,D8A.optionArray = [],D8A.currentLang=4;
$(document).ready(function () {
    if ((navigator.userAgent.match(/Android|BlackBerry|iPhone|iPad|iPod|Opera Mini|IEMobile/i))&& !(window.location.href.includes('http')))
        Utils.mobileDeviceFlag = true;
     
        $("#inputText").text('');
       D8A.calculation();
        showQues();
});
D8A.calculation = function(){
    d = new Date();  //date object
	startTime = d.getDate() + "-" + (d.getMonth() + 1) + "-" + d.getFullYear() + " " + d.getHours() + ":" + d.getMinutes() + ":" + d.getSeconds();  //to get the current date

    if(Utils.mobileDeviceFlag)
    {
          var langName = Android.getGameLang();
          D8A.currentLang =D8A.gameNameArr.findIndex(obj => obj.lang == langName);
        var gameCode =Android.getGameID();
        D8A.currentQues = D8A.gameNameArr[ D8A.currentLang].gameData.findIndex(obj => obj.Name == gameCode);
        if(langName == "Urdu-Pakistan")
            $("#heading").css({"direction":"rtl" , "text-align":"right"});
        
    }
    else{
        //D8A.currentLang = Math.floor(Math.random()*D8A.gameNameArr.length);
        if(D8A.currentLang == 3)
              $("#heading").css({"direction":"rtl" , "text-align":"right"});
        D8A.currentQues = Math.floor(Math.random()*D8A.gameNameArr[D8A.currentLang].gameData.length);
    }
    if(D8A.gameNameArr[D8A.currentLang].languageFont!=null)
        setFontFamilyForLang(D8A.gameNameArr[D8A.currentLang].languageFont);

     D8A.createDiv();
     D8A.setData(); //function that set all the images 
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
D8A.setData = function() //set all images
{       document.title =   questionId = D8A.gameNameArr[ D8A.currentLang].gameData[D8A.currentQues].Name;
       
        document.getElementById("heading").innerHTML=D8A.gameNameArr[ D8A.currentLang].gameData[D8A.currentQues].instrText;
        document.getElementById("queNo").innerHTML = D8A.gameNameArr[ D8A.currentLang].gameData[D8A.currentQues].Name;
        $("#heading").css("font-size",D8A.gameNameArr[ D8A.currentLang].gameData[D8A.currentQues].fontSize);
        $("#ansTextId").text(D8A.gameNameArr[ D8A.currentLang].ansText);
       // $("#answerKeyText").append(D8A.gameNameArr[ D8A.currentLang].gameData[D8A.currentQues].Ans);

        numberSystemDiv = document.createElement('div');
		$(numberSystemDiv).prop('id', 'numberSystemDiv');
		$(numberSystemDiv).prop('class', 'col-lg-12 col-md-12 col-xs-12 col-sm-12 ');
		$(".keyPad").append(numberSystemDiv);
	
		createNumberDivs("numberSystemDiv")
}
D8A.createDiv = function(){
    
     if(D8A.gameNameArr[ D8A.currentLang].gameData[D8A.currentQues].Name == "M11D"){ //M11D
        $("#questionAnsMainDiv").hide();
        document.getElementById("bagImg").src=Utils.Path+"images/"+D8A.gameNameArr[ D8A.currentLang].gameData[D8A.currentQues].imgName[0];
        document.getElementById("weightImg").src=Utils.Path+"images/"+D8A.gameNameArr[ D8A.currentLang].gameData[D8A.currentQues].imgName[1];
        $("#M11DID").css("display","block");
     }
    else{
        var quesBlock = document.createElement("div");
        quesBlock.setAttribute("id","NumberBlock");
        quesBlock.setAttribute("class","noPadding col-sm-12 col-xs-12 col-lg-12 col-md-12");
        document.getElementById("questionAnsMainDiv").appendChild(quesBlock);
        var quesBlockImg = document.createElement("Img");
        quesBlockImg.setAttribute("id","blockImgId");
       quesBlock.appendChild(quesBlockImg);
        if(D8A.gameNameArr[ D8A.currentLang].gameData[D8A.currentQues].data == 1 ) {//M24A,M24C
            quesBlock.setAttribute("class","noPadding col-sm-6 col-xs-6 col-lg-6 col-md-6 col-sm-offset-3 col-xs-offset-3 col-lg-offset-3 col-md-offset-3");
            quesBlockImg.setAttribute("class","noPadding img-responsive col-sm-9 col-xs-9 col-md-9 col-lg-9 col-sm-offset-1 col-xs-offset-1 col-md-offset-1 col-lg-offset-1");
            $("#NumberBlock").css({"height":"50vh" , "top":"5vh"});
            document.getElementById("blockImgId").src=Utils.Path+"images/speaker.png";
         }
         else 
         {
            document.getElementById("blockImgId").src=Utils.Path+"images/"+D8A.gameNameArr[ D8A.currentLang].gameData[D8A.currentQues].imgName;
             $("#answerKeyText").css({'visibility':'visible'});
            if(D8A.gameNameArr[ D8A.currentLang].gameData[D8A.currentQues].Name == 'D8D'||D8A.gameNameArr[ D8A.currentLang].gameData[D8A.currentQues].Name == 'D8C'||D8A.gameNameArr[ D8A.currentLang].gameData[D8A.currentQues].Name == 'D9C'){
                quesBlockImg.setAttribute("class","noPadding img-responsive col-sm-9 col-xs-9 col-md-9 col-lg-9 col-sm-offset-1 col-xs-offset-1 col-md-offset-1 col-lg-offset-1");
            }
            else{
                quesBlockImg.setAttribute("class","noPadding img-responsive col-sm-12 col-xs-12 col-md-12 col-lg-12 col-sm-offset-0 col-xs-offset-0 col-md-offset-0 col-lg-offset-0");
            }
            $("#answerKeyText").text(" "+D8A.gameNameArr[D8A.currentLang].ansText);
            $("#answerKeyText").append(" "+D8A.gameNameArr[ D8A.currentLang].gameData[D8A.currentQues].Ans);
        }
        $("#questionAnsMainDiv").show();
     }
}
showQues = function(){
    $('#questioMark').hide();
    $('#myModal').css('display','block');
}
hideQuestion = function(){
    $('#questioMark').show();
    $('#myModal').css('display','none');
}
D8A.goNext = function(){
    if(clickOption.length !== 0){
		scoredMarks=clickOption;	
		label='null';
		D8A.scoreFunction();
	}else{
		$("#modalRoot").addClass("visible");
		$("body").addClass("overlay");
		$(".opacityClass").css("opacity","0.1");
		$(".pointerClass").css("pointer-events","none");
	}
}
D8A.scoreFunction = function () {
    console.log(scoredMarks,startTime, label);
   // alert("scoredMarks = " + scoredMarks +","+" "+"Label = " +label);
    if (Utils.mobileDeviceFlag) {
        Android.gotoNextGame(scoredMarks,startTime, label);
    }
}