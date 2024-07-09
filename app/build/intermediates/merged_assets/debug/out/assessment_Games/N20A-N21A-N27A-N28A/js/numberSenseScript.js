var N20A = {};
Utils={};
Utils.Path = " ";
Utils.mobileDeviceFlag = false;
var rightAnsCnt =0,wrongAnsCnt=0, startTime = "0", scoredMarks = "0", label = "null",scoreFlag = false;
N20A.blinkNumberDiv=0,click=0;
N20A.currentques=0;
N20A.blinkId;
N20A.currentLang = 6;
$(document).ready(function () {
    document.title = N20A.hardcodedData.title;
   if ((navigator.userAgent.match(/Android|BlackBerry|iPhone|iPad|iPod|Opera Mini|IEMobile/i))&& !(window.location.href.includes('http')))
      Utils.mobileDeviceFlag = true;
   $("#myModal").css("bottom","2vh");
    $("#keyPad").hide();
       N20A.calculation();
        N20A.showQues();
    
});

N20A.showQues = function(){
    $('#questioMark').hide();
    $('#myModal').css('display','block');
}
N20A.hideQuestion = function(){
    $('#questioMark').show();
    $('#myModal').css('display','none');
}
N20A.calculation = function()
{
    if(Utils.mobileDeviceFlag)
    {
         var langName = Android.getGameLang();
          N20A.currentLang =   N20A.gameNameArr.findIndex(obj => obj.Lang == langName);
        var gameCode =Android.getGameID();
        N20A.currentques = N20A.gameNameArr[ N20A.currentLang].gameData.findIndex(obj => obj.name == gameCode);
        if(langName == "Urdu-Pakistan")
           $("#heading").css({"text-align":"right" , "direction":"rtl"});
    }
    else{
        //N20A.currentLang= Math.floor(Math.random()* N20A.gameNameArr.length);
       N20A.currentques= Math.floor(Math.random()* N20A.gameNameArr[  N20A.currentLang].gameData.length);
       if(N20A.currentLang== 3)
            $("#heading").css({"text-align":"right" , "direction":"rtl"});
    }
   
    document.getElementById("heading").innerHTML =  N20A.gameNameArr[  N20A.currentLang].gameData[N20A.currentques].instrText;
    $("#heading").css("font-size", N20A.gameNameArr[N20A.currentLang].gameData[N20A.currentques].fontSize);
    $("#answerKeyText").text(" "+N20A.gameNameArr[N20A.currentLang].ans);
    $("#answerKeyText").append( N20A.gameNameArr[  N20A.currentLang].gameData[N20A.currentques].ans);
    document.getElementById("queNo").innerHTML =  N20A.gameNameArr[  N20A.currentLang].gameData[N20A.currentques].name;
 
    if(N20A.gameNameArr[N20A.currentLang].languageFont!=null)
           setFontFamilyForLang(N20A.gameNameArr[N20A.currentLang].languageFont);

     N20A.createDiv ();
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
N20A.createDiv = function(){ // div for ques and option
    d = new Date();  //date object
	startTime = d.getDate() + "-" + (d.getMonth() + 1) + "-" + d.getFullYear() + " " + d.getHours() + ":" + d.getMinutes() + ":" + d.getSeconds();  //to get the current date

    var quesNumblock , optionNumBlock , i,j ; 
    var questionData =  N20A.gameNameArr[  N20A.currentLang].gameData[N20A.currentques].firstDigit;
   
    for(i=0;i<5;i++){ //questionDiv
        quesNumblock = document.createElement("div");
        quesNumblock.setAttribute("id","quesNumBlock"+i);
        quesNumblock.setAttribute("class","noPadding quesNumClass borderClass centerClass col-sm-2 col-xs-2 col-lg-2 col-md-2 col-sm-offset-1 col-lg-offset-1 col-md-offset-1 col-xs-offset-1");
        document.getElementById("digitQuesId").appendChild(quesNumblock);
        $(quesNumblock).data("data",questionData);
        if(i%2 == 0){
            if(i==0){
               
                if( N20A.gameNameArr[N20A.currentLang].gameData[N20A.currentques].name == "N21A")
                    quesNumblock.setAttribute("class","noPadding quesNumClass centerClass col-sm-1 col-xs-1   col-lg-0 col-md-0 col-sm-offset-1 col-xs-offset-1 col-lg-offset-1 col-md-offset-1");

                 
                else{
                   quesNumblock.setAttribute("class","noPadding quesNumClass  centerClass col-sm-1 col-xs-1 col-lg-1 col-md-1 col-sm-offset-1 col-xs-offset-1 col-lg-offset-1 col-md-offset-1");
                   $("#quesNumBlock"+i).text(questionData);}
            }
            else{
                quesNumblock.setAttribute("class","noPadding quesNumClass quesClass clearBox borderClass centerClass col-sm-2 col-xs-2 col-lg-2 col-md-2 ");
            }
            if(N20A.currentques == 0 || N20A.currentques==2)
                 questionData++;
            else
               questionData--; 
        }
        else{
           
            if( N20A.gameNameArr[  N20A.currentLang].gameData[N20A.currentques].name == "N21A" && i==1){
               quesNumblock.setAttribute("class","noPadding quesNumClass centerClass col-sm-0 col-xs-0 col-lg-0  col-md-0");
               $(quesNumblock).css("display","none");
            }
            else{
                 quesNumblock.setAttribute("class","noPadding quesNumClass centerClass col-sm-1 col-xs-1 col-lg-1 col-md-1");
                $("#quesNumBlock"+i).text(",");
            }
        }
        }
        
        $(".quesClass").css("background-color","rgba(177, 195, 220, 0.85);"); 
}
N20A.resetGame = function(){
    scoreFlag = false;
    $("#keyPad").hide();
    $(".optionClass").css('pointer-events','auto');
    $(".optionClass , .quesClass").css('border',' 2px solid rgb(102 98 85)');
    $(".quesClass").css("background-color","rgb(177 195 220 / 85%)");
    $(".clearBox").text("");
    if( N20A.gameNameArr[  N20A.currentLang].gameData[N20A.currentques].data != 1)
        $("#quesNumBlock2").addClass("blink_me");
    rightAnsCnt=0;
    wrongAnsCnt=0;
    label = "null",
    N20A.blinkNumberDiv = 0;
    scoredMarks = "0"; 
}
N20A.goNext = function(){
   
      if(clickOption.length !== 0){
		scoredMarks=clickOption;
          label= "null" ; 
		N20A.scoreFunction();
	}else{
		$("#modalRoot").addClass("visible");
		$("body").addClass("overlay");
		$(".opacityClass").css("opacity","0.1");
		$(".pointerClass").css("pointer-events","none");
	}
	
}
N20A.scoreFunction = function () {
    console.log(scoredMarks,startTime, label);
   // alert("ScoredMarks = " + scoredMarks +","+" "+"Label = " +label);
    if (Utils.mobileDeviceFlag) {
        Android.gotoNextGame(scoredMarks,startTime, label);
    }
}