var G16C = {};
Utils={};
Utils.Path = " ";
Utils.mobileDeviceFlag = false;
var startTime = "0", scoredMarks = "0", label = "null",scoreFlag = false,G19AFlag = false;
G16C.currentQues = 0,G16C.optionArray = [], G16C.currentLang=5;
$(document).ready(function () {
    if ((navigator.userAgent.match(/Android|BlackBerry|iPhone|iPad|iPod|Opera Mini|IEMobile/i))&& !(window.location.href.includes('http')))
        Utils.mobileDeviceFlag = true;
      $("#myModal").css("bottom","1vh");
        G16C.calculation();
        showQues();
});
  
G16C.calculation = function(){
    d = new Date();  //date object
	startTime = d.getDate() + "-" + (d.getMonth() + 1) + "-" + d.getFullYear() + " " + d.getHours() + ":" + d.getMinutes() + ":" + d.getSeconds();  //to get the current date

    if(Utils.mobileDeviceFlag)
    {
          var langName = Android.getGameLang();
                  G16C.currentLang = G16C.gameNameArr.findIndex(obj => obj.lang == langName);
        var gameCode = Android.getGameID();
        G16C.currentQues = G16C.gameNameArr[G16C.currentLang].gameData.findIndex(obj => obj.Name == gameCode);
        if(langName == "Urdu-Pakistan")
            $("#heading").css({"text-align":"right" , "direction":"rtl"});
    }
    else{  
        if(G16C.currentLang == 3)
             $("#heading").css({"text-align":"right" , "direction":"rtl"});
          G16C.currentQues = Math.floor(Math.random()*  G16C.gameNameArr[G16C.currentLang].gameData.length);
    }
    if(G16C.gameNameArr[G16C.currentLang].languageFont!=null)
       setFontFamilyForLang(G16C.gameNameArr[G16C.currentLang].languageFont);

     G16C.createDiv();
     G16C.setData();   //function that set all the images 
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
G16C.setData = function() //set all images
{       document.title =   questionId =   G16C.gameNameArr[G16C.currentLang].gameData[G16C.currentQues].Name;
       
        document.getElementById("heading").innerHTML=  G16C.gameNameArr[G16C.currentLang].gameData[G16C.currentQues].instrText;
     
          document.getElementById("queNo").innerHTML =   G16C.gameNameArr[G16C.currentLang].gameData[G16C.currentQues].Name;
        $("#heading").css("font-size",  G16C.gameNameArr[G16C.currentLang].gameData[G16C.currentQues].fontSize);
        $("#answerKeyText").text(" "+G16C.gameNameArr[G16C.currentLang].ans);
        $("#answerKeyText").append(G16C.gameNameArr[G16C.currentLang].gameData[G16C.currentQues].Ans);

         if(  G16C.gameNameArr[G16C.currentLang].gameData[G16C.currentQues].ansKey == 1)
            $("#answerKeyText").css('visibility','hidden');
}
G16C.createDiv = function(){
 
        var quesBlock = document.createElement("div");
        quesBlock.setAttribute("id","NumberBlock");
        quesBlock.setAttribute("class","noPadding col-sm-9 col-xs-9 col-md-9 col-lg-9 col-sm-offset-2 col-xs-offset-2 col-md-offset-2 col-lg-offset-2");
        document.getElementById("questionAnsMainDiv").appendChild(quesBlock);
        var quesBlockImg = document.createElement("Img");
        quesBlockImg.setAttribute("id","blockImgId");
        quesBlockImg.setAttribute("class","noPadding img-responsive col-sm-10 col-xs-10 col-md-10 col-lg-10 col-sm-offset-1 col-xs-offset-1 col-md-offset-1 col-lg-offset-1");
        quesBlock.appendChild(quesBlockImg);
        document.getElementById("blockImgId").src=Utils.Path+"images/"+  G16C.gameNameArr[G16C.currentLang].gameData[G16C.currentQues].imgName;
        if(  G16C.gameNameArr[G16C.currentLang].gameData[G16C.currentQues].data == 3){ //G18A,G18B
            $("#NumberBlock").css({"height":"65%" , "top":"-5vh"});
            
        }
        if(  G16C.gameNameArr[G16C.currentLang].gameData[G16C.currentQues].data == 6)//M24B ,M24D,G16C
        {
          quesBlock.setAttribute("class","noPadding col-sm-6 col-xs-6 col-md-6 col-lg-6 col-sm-offset-3 col-xs-offset-3 col-md-offset-3 col-lg-offset-3");
          quesBlockImg.setAttribute("class","noPadding img-responsive col-sm-10 col-xs-10 col-md-10 col-lg-10 col-sm-offset-1 col-xs-offset-1 col-md-offset-1 col-lg-offset-1");
          $("#NumberBlock").css({"height":"50vh" , "top":"5vh"});
       
        }
        $("#questionAnsMainDiv").show();
     //}
}
showQues = function(){
    $('#questioMark').hide();
    $('#myModal').css('display','block');
}
hideQuestion = function(){
    $('#questioMark').show();
    $('#myModal').css('display','none');
}
G16C.goNext = function(){
 
     if(clickOption !== ''){
       scoredMarks = clickOption;
       label = "null";
       G16C.scoreFunction();
     }
    else {
        $("#modalRoot").addClass("visible");
		$("body").addClass("overlay");
		$(".opacityClass").css("opacity","0.1");
		$(".pointerClass").css("pointer-events","none");
    }
}
G16C.scoreFunction = function () {
    console.log(scoredMarks,startTime, label);
  //  alert("scoredMarks = " + scoredMarks +","+" "+"Label = " +label);
    if (Utils.mobileDeviceFlag) {
        Android.gotoNextGame(scoredMarks,startTime, label);
    }
}