var N23B ={};
var Utils = {};
Utils.Path = '';
Utils.mobileDeviceFlag = false;
var questionId = '', startTime = 0, scoredMarks = "0", resId = 0,label='null',scoreFlag = false ,gameFlag = false;
N23B.currentLang = 4, flag= false,N=0,count=0;

//function for loader
$(document).ready(function () {
	if ((navigator.userAgent.match(/Android|BlackBerry|iPhone|iPad|iPod|Opera Mini|IEMobile/i)) && !(window.location.href.includes('http')))
		Utils.mobileDeviceFlag = true;
	setTimeout(function () {
		showQues();
		N23B.initVariables();
		N23B.arrangeN23B();
	}, 300);
});
function showQues(){
    $('#questioMark').hide();
    $('#myModal').css('display','block');
}
function hideQuestion(){
    $('#questioMark').show();
    $('#myModal').css('display','none');
}
N23B.initVariables = function(){
    N23B.currentSet='';
    N23B.correctCount=0;
    N23B.randomType=0;
    N23B.counter=0;
    N23B.data;
    N23B.question=[];
    N23B.resetFlag=false;
    N23B.attemptFlag=false;
    N23B.givenAnswer = '';
    N23B.idArray = ["parentId0","parentId1","parentId2","parentId3"];
    N23B.cnt = 0;
    N23B.rightAns = 0;
   N23B.shuffledArray =[];
  N23B.labelArray =[];
}
N23B.arrangeN23B = function(){
    if(Utils.mobileDeviceFlag)
    {
          var langName = Android.getGameLang();
         N23B.currentLang =  N23B.gameNameArr.findIndex(obj => obj.lang == langName);
         gameCode = Android.getGameID();
         N23B.currentGame=N23B.gameNameArr[N23B.currentLang ].gameData.findIndex(el => el.gameName === gameCode);
         if(langName == "Urdu-Pakistan")
             $("#heading").css({"direction":"rtl" , "text-align":"right"});
    }
    else{
        N23B.currentGame = Math.floor(Math.random()* N23B.gameNameArr[N23B.currentLang].gameData.length);
        if(N23B.currentLang == 3)
            $("#heading").css({"direction":"rtl" , "text-align":"right"});
    }
    d = new Date();
	startTime = d.getDate() + "-" + (d.getMonth() + 1) + "-" + d.getFullYear() + " " + d.getHours() + ":" + d.getMinutes() + ":" + d.getSeconds();
	
    if(N23B.gameNameArr[N23B.currentLang].languageFont!=null)
	          setFontFamilyForLang(N23B.gameNameArr[N23B.currentLang].languageFont);

    $("#queNo").css("font-size","1.9vw");
    document.title =  N23B.gameNameArr[N23B.currentLang].gameData[N23B.currentGame ].gameName;
    document.getElementById("heading").innerHTML=N23B.exampleData[N23B.currentLang].instr1;
    document.getElementById("queNo").innerHTML =N23B.gameNameArr[N23B.currentLang].gameData[N23B.currentGame ].gameName2;
    $("#heading").css("font-size",N23B.gameNameArr[ N23B.currentLang ].fontSize);
    N23B.shuffledArray = [6,2,5];
    N23B.exampleGrid();
   // N23B.createDiv();
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

N23B.exampleGrid = function(){
    var exampleDiv,exampleImg ;
    for(var i=0;i<3;i++){
        exampleDiv = document.createElement("div");
        exampleDiv.setAttribute("id","parentId"+i);
        exampleDiv.setAttribute("class","noPadding numberStyle numberStylechild col-sm-2 col-xs-2 col-lg-2 col-md-2 col-sm-offset-1 col-xs-offset-1 col-lg-offset-1 col-md-offset-1");
        exampleDiv.setAttribute("Ansdata",i+1);
        $(exampleDiv).css({'height':'27vh'});
        exampleImg = document.createElement("img");
        exampleImg.setAttribute("id","parentImgId"+i);
        exampleImg.setAttribute("class","noPadding img-responsive col-sm-12 col-xs-12 col-lg-12 col-md-12");
        exampleDiv.append(exampleImg);
        document.getElementById("answerDiv").append(exampleDiv);
    }
    $("#"+N23B.idArray[N23B.cnt]).addClass("Blink_me");
    for(var i=0;i<3;i++){
        exampleDiv2 = document.createElement("div");
        exampleDiv2.setAttribute("id","parentIdop"+i);
        exampleDiv2.setAttribute("class","noPadding numberStyle numberStylechild col-sm-2 col-xs-2 col-lg-2 col-md-2 col-sm-offset-1 col-xs-offset-1 col-lg-offset-1 col-md-offset-1");
        $(exampleDiv2).data("data",N23B.exampleDataToGet[i]);
        $(exampleDiv2).css({'height':'27vh' , "border":"unset"});
        exampleImg2 = document.createElement("img");
        exampleImg2.setAttribute("id","parentImgIdop"+i);
        exampleImg2.setAttribute("class","noPadding img-responsive col-sm-12 col-xs-12 col-lg-12 col-md-12");
        exampleImg2.setAttribute("onclick" , "N23B.getOptionImg(this.id)");
       
        exampleImg2.src = "images/"+N23B.exampleImg[i];
        exampleDiv2.append(exampleImg2);
        document.getElementById("optionDivId").append(exampleDiv2);
    }
    $("#answerDiv ,#optionDivId").css({"left":"6vw"});
}
N23B.getOptionImg = function(clicked_div){
  //  var i = 0;
    $(".Blink_me").removeClass("Blink_me");
    optionImgData = $("#"+clicked_div).parent().data("data");
    ansDivData = $("#parentId"+count).data("Ansdata");
    $("#"+clicked_div).css({"visibility":"hidden"});
    $("#parentId"+count).children().prop("src",Utils.Path+"images/"+"img"+optionImgData+".png");
    count++;
    $("#parentId"+count).addClass("Blink_me");

}
N23B.createDiv = function(){
    
    if(gameFlag){
    if(N23B.currentGame == 0)
         N = 3 ;
    else
         N = 4 ;
    }

    var parentDiv,childDiv ; 

    for( i=0;i<N;i++){
     parentDiv = document.createElement("div");
     parentDiv.setAttribute("id","parentId"+i);
     parentDiv.setAttribute("class","noPadding numberStyle numberStylechild col-sm-2 col-xs-2 col-lg-2 col-md-2 col-sm-offset-1 col-xs-offset-1 col-lg-offset-1 col-md-offset-1");
    
    /* if(!gameFlag){
             $(parentDiv).data("data",N23B.gameNameArr[N23B.currentLang].gameData[N23B.currentGame].exampleAns[i]);
             $("#answerDiv , #optionDivId").css("left","6vw");
        }
        else{ */
             $(parentDiv).data("data",N23B.gameNameArr[N23B.currentLang].gameData[N23B.currentGame].correctAns[i]); 
             if(N==4)
               $("#answerDiv , #optionDivId").css("left","0vw");
             else
               $("#answerDiv , #optionDivId").css("left","6vw"); 
        
     $("#"+N23B.idArray[N23B.cnt]).addClass("Blink_me");
     document.getElementById("answerDiv").append(parentDiv);
}
     for(var i=0;i<N;i++){
     childDiv = document.createElement("div");
      childDiv.setAttribute("id","childId"+i);
      childDiv.setAttribute("class","noPadding  numberStyle numberStylechild optionclass col-sm-2 col-xs-2 col-lg-2 col-md-2 col-sm-offset-1 col-xs-offset-1 col-lg-offset-1 col-md-offset-1");
      childDiv.setAttribute("onclick","N23B.getText(this.id);")
      childDiv.innerHTML = N23B.shuffledArray[i];
     document.getElementById("optionDivId").append(childDiv);
    }
}

N23B.getText = function(clicked_Div){
  
   scoreFlag = true;
    var blinkedID = $(".Blink_me").attr("id");
    $("#"+blinkedID).text($("#" + clicked_Div).text());
    $("#"+clicked_Div).text("");
    $("#"+clicked_Div).css("pointer-events","none");
    N23B.cnt++;
    $(".Blink_me").removeClass("Blink_me");
    $("#"+N23B.idArray[N23B.cnt]).addClass("Blink_me");
} 

resetGame=function()
{
	N23B.attemptFlag=false;
    scoreFlag = false;
	document.getElementById('answerDiv').innerHTML = "";
    document.getElementById('optionDivId').innerHTML = "";
    $(".optionclass").css("pointer-events","auto");
    if(!flag){
        count = 0 ;
       N23B.exampleGrid();
    }
    else
        N23B.shuffledArray = N23B.gameNameArr[N23B.currentLang].gameData[N23B.currentGame].shuffArr; 
        N23B.labelArray = [];
        N23B.correctCount = 0 ;
        N23B.cnt = 0 ;
        $("#"+N23B.idArray[N23B.cnt]).addClass("Blink_me");
   
	N23B.createDiv();
}
N23B.goNext = function(){
  
    if(!gameFlag){
        gameFlag = true;
        flag=true;
       // N23B.correctCount = 0 ;
        $(".optionclass").css("pointer-events","auto");
        N23B.cnt = 0 ;
        $("#queNo").css("font-size","2vw");
       document.getElementById("heading").innerHTML=N23B.gameNameArr[N23B.currentLang].gameData[N23B.currentGame].instr2;
        document.getElementById("queNo").innerHTML = N23B.gameNameArr[N23B.currentLang].gameData[N23B.currentGame].gameName;
       
        N23B.shuffledArray = N23B.gameNameArr[N23B.currentLang].gameData[N23B.currentGame].shuffArr;
      //  N23B.shuffledArray = shuffle(N23B.shuffledArray);
       // N23B.shuffledArray = shuffle(N23B.shuffledArray);
        document.getElementById('answerDiv').innerHTML = "";
        document.getElementById('optionDivId').innerHTML = "";
        N23B.createDiv();
    }
    else{
       
        N23B.checkAns();
        if(scoreFlag){
        if(N23B.correctCount == 3 || N23B.correctCount == 4 ){
             scoredMarks = "2";
             for(var i=0;i<N23B.labelArray.length;i++){
                 if(i==0)
                    label=N23B.labelArray[i];
                 else
                   label=label+","+N23B.labelArray[i];
             }
        }
        else {
           scoredMarks = "1";
          
           for(var i=0;i<N23B.cnt;i++){
            if(i==0)
               label=N23B.labelArray[i];
            else
              label=label+","+N23B.labelArray[i];
        }
          }
        }
        else{
            scoredMarks  = "0";
            label = "null";
        }
        N23B.scoreFunction();
    }
   
}
N23B.scoreFunction = function () {
    console.log(scoredMarks,startTime, label);
   // alert("ScoredMarks = " + scoredMarks +","+" "+"Label = " +label);
    if (Utils.mobileDeviceFlag) {
        Android.gotoNextGame(scoredMarks,startTime, label);
    }
}
N23B.checkAns = function(){
    N23B.labelArray=[];
    N23B.correctCount=0;
    for(var i = 0 ; i<N;i++){
        //console.log(($("#parentId"+i).children()).text());
        if(($("#parentId"+i)).text()== (N23B.gameNameArr[N23B.currentLang].gameData[N23B.currentGame].correctAns[i]).toString())
             N23B.correctCount++;
             N23B.labelArray.push($("#parentId"+i).text());
        
    }
}
//shuffle the options
function shuffle(sarray) {

    var arrayLength = sarray.length;
    var temp, random_index;
    while (arrayLength > 0) {
        random_index = Math.floor(Math.random() * arrayLength);
        arrayLength--;
        temp = sarray[arrayLength];
        sarray[arrayLength] = sarray[random_index];
        sarray[random_index] = temp;
    }

    return (sarray);
}