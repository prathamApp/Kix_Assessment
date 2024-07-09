
var P1A = {};
Utils={};
Utils.Path = " ";
var startTime = "0", scoredMarks = "0", label = "null",scoreFlag = false,gameFlag = false;
P1A.currentques = 0;
P1A.currentLang  = 11;
P1A.optionArray = [0,1,2,3];
$(document).ready(function () {
 $("#example18").hide();
    if ((navigator.userAgent.match(/Android|BlackBerry|iPhone|iPad|iPod|Opera Mini|IEMobile/i))&& !(window.location.href.includes('http')))
        Utils.mobileDeviceFlag = true;
      /*   $("#myModal").css("bottom","3vh"); */
       // $("#heading").css("line-height","3.5vh");
        P1A.calculation();
        P1A.showQues();
});
P1A.showQues = function(){
    $('#questioMark').hide();
    $('#myModal').css('display','block');
}
P1A.hideQuestion = function(){
    $('#questioMark').show();
    $('#myModal').css('display','none');
}
P1A.calculation = function(){ //calculate number
    if(Utils.mobileDeviceFlag)
    {
        var langName = Android.getGameLang();
        P1A.currentLang = P1A.gameName.findIndex(obj => obj.lang == langName);
        var gameCode =Android.getGameID();
        P1A.currentques = P1A.gameName[P1A.currentLang].gameData.findIndex(obj => obj.name == gameCode);
        if(langName == "Urdu-Pakistan")
           $("#heading").css({"text-align":"right" , "direction":"rtl"});
    }
    else{
        if(P1A.currentLang == 2)
             $("#heading").css({"text-align":"right" , "direction":"rtl"});
        P1A.currentques= Math.floor(Math.random()*P1A.gameName[P1A.currentLang].gameData.length);
    }
          shuffle(P1A.optionArray);
         document.title = P1A.gameName[P1A.currentLang].gameData[P1A.currentques].name;
         document.getElementById("heading").innerHTML = P1A.gameName[P1A.currentLang].gameData[P1A.currentques].instrText;
        $("#heading").css("font-size",P1A.gameName[P1A.currentLang].gameData[P1A.currentques].fontSize);
        $("#heading").css("line-height","5vh");
        document.getElementById("queNo").innerHTML = P1A.gameName[P1A.currentLang].gameData[P1A.currentques].name;
        document.getElementById("quesImgId").src=Utils.Path+"images/"+P1A.gameName[P1A.currentLang].gameData[P1A.currentques].quesImg+".png";
        $("#textQuesId").data("data","correct");

        if(P1A.gameName[P1A.currentLang].languageFont!=null)
        setFontFamilyForLang(P1A.gameName[P1A.currentLang].languageFont);

            P1A.createDiv ();
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
P1A.createDiv = function(){ // div for ques and option
    d = new Date();  //date object
	startTime = d.getDate() + "-" + (d.getMonth() + 1) + "-" + d.getFullYear() + " " + d.getHours() + ":" + d.getMinutes() + ":" + d.getSeconds();  //to get the current date
    
   var optionDiv,optionImgDiv;
     for(i=0;i<4;i++){ //questionDiv
        optionDiv = document.createElement("div");
        optionDiv.setAttribute("id","optionDivId"+i);
        optionDiv.setAttribute("class","noPadding optionClass borderClass centerClass col-sm-5 col-xs-5 col-md-5 col-lg-5");
        $(optionDiv).data("imgName",P1A.gameName[P1A.currentLang].gameData[P1A.currentques].optionData[ P1A.optionArray[i]].ansImg);
        optionDiv.setAttribute("onclick","P1A.checkAns(this.id)");
        $(optionDiv).data("data",P1A.gameName[P1A.currentLang].gameData[P1A.currentques].optionData[ P1A.optionArray[i]].data);
        $(optionDiv).data("ansData",P1A.gameName[P1A.currentLang].gameData[P1A.currentques].optionData[ P1A.optionArray[i]].ansImg)
         optionImgDiv = document.createElement("img");
         optionImgDiv.setAttribute("id","optionImgId"+i);
         optionImgDiv.setAttribute("class","noPadding imgborder heightHundred img-responsive col-sm-12 col-xs-12 col-lg-12 col-md-12");
         optionImgDiv.src = Utils.Path+"images/"+P1A.gameName[P1A.currentLang].gameData[P1A.currentques].optionData[ P1A.optionArray[i]].ansImg +".png" ;
         optionDiv.appendChild(optionImgDiv);
        document.getElementById("optionID").appendChild(optionDiv);
       }
       if(P1A.gameName[P1A.currentLang].gameData[P1A.currentques].name == "P2A")
            $(".heightHundred").css('height','100%');
       $(".optionClass , #textQuesId").css('background-color','white');
}
P1A.resetGame = function(){
    $(".optionClass").css('border',' 2px solid rgb(102 98 85)');
    scoredMarks = "0"; 
    label = "null";
}
P1A.checkAns = function(clicked_Pattern){
    scoreFlag = true;
     $(".optionClass").css('border',' 2px solid rgb(102 98 85)');
     $("#"+clicked_Pattern).css('border','10px solid rgb(255, 190, 0)');
    if(($("#"+clicked_Pattern).data("data")) == ($("#textQuesId").data("data")))
        scoredMarks = "2";
    else
      scoredMarks = "1";

      label = $("#"+clicked_Pattern).data("ansData") + '.png';

}
P1A.goNext = function(){
    if(gameFlag){
        gameFlag = false;
        document.getElementById("queNo").innerHTML = P1A.gameName[P1A.currentLang].gameData[P1A.currentques].name;
        $("#queNo").css("font-size","2.2vw");
        $("#resetDiv").css("visibility","visible");
        document.getElementById("heading").innerHTML = P1A.gameName[P1A.currentLang].gameData[P1A.currentques].instrText2;
        $("#example18").hide();
        $("#mainDiv").show();

    }
    else{
        if(!scoreFlag){
        scoredMarks = "0";
        label="null";
        }
        P1A.scoreFunction();
    }
}
P1A.scoreFunction = function () {
    console.log(scoredMarks,startTime, label);
    //alert("ScoredMarks = " + scoredMarks +","+" "+"Label = " +label);
    if (Utils.mobileDeviceFlag) {
        Android.gotoNextGame(scoredMarks,startTime, label);
    }
}