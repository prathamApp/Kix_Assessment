
var identifyPattern = {};
var Utils = {};
Utils.Path = "";
var starttime = '0', scoredmarks = '0', label ='';

$(document).ready(function () {
    /* if(navigator.userAgent.match(/Android|BlackBerry|iPhone|iPad|iPod|Opera Mini|IEMobile/i))
		Utils.mobileDeviceFlag=true; */
    if((navigator.userAgent.match(/Android|BlackBerry|iPhone|iPad|iPod|Opera Mini|IEMobile/i)) && !(window.location.href.includes('http')))
        Utils.mobileDeviceFlag = true;
	else
        Utils.mobileDeviceFlag = false;

    setTimeout(function () {
        identifyPattern.init();
    });
}, 200);

identifyPattern.init = function () {
    $("#gamePage").show();
    identifyPattern.initVariables();
    identifyPattern.play();
    showQues();
}

identifyPattern.initVariables = function () 
{
    identifyPattern.randQue = 0;
    identifyPattern.imgCount = 0;
    identifyPattern.attemptFlag = false;
	identifyPattern.currentGame = null;
    identifyPattern.quePatternTimer = null;
    identifyPattern.clickedOptionData = null;
    identifyPattern.previousClickedOption = null;
}

function showQues(){
    $('#questioMark').hide();
    $('#myModal').css('display','block');
}
function hideQuestion(){
    $('#questioMark').show();
    $('#myModal').css('display','none');
}

identifyPattern.play = function()
{
	var lang = 0, randLang = '';
    //Utils.mobileDeviceFlag = true;
    if(Utils.mobileDeviceFlag){					//For mobile device.
		randLang = Android.getGameLang();
		//randLang = 'Hindi-India';
		lang = identifyPattern.patternData.findIndex(obj => obj.language.toLowerCase().trim()  == randLang.toLowerCase().trim() );
        var gameCode = Android.getGameID();
        //var gameCode = "P5A";
        identifyPattern.randQue = identifyPattern.patternData[lang].gameArray.findIndex(obj => obj.gameName == gameCode);
    }
    else{ 
        identifyPattern.randQue = Math.floor(Math.random() * identifyPattern.patternData[lang].gameArray.length);                                          //For browser
    } 

    if(lang == 10 || randLang == 'Urdu-Pakistan'){
        $("#heading").css('direction', 'rtl');
    }
    //identifyPattern.randQue = 3;
	identifyPattern.currentGame = identifyPattern.patternData[lang].gameArray[identifyPattern.randQue];
    
    if(identifyPattern.currentGame.gameName == "N8A"){      //N8A
        $("#heading").css('font-size', '1.6vw');   
        $("#questionDiv").css('border-radius', '2vh');
        $("#questionDiv").css('border', '2px solid black');
    }
    else
        $("#heading").css('font-size', identifyPattern.currentGame.fontSize);   
    document.title = identifyPattern.currentGame.gameName;   
    $('#queNo').text(identifyPattern.currentGame.gameName);
    document.getElementById("heading").innerHTML = identifyPattern.currentGame.questionText;
    $("#heading").css('font-weight', 'normal');
    
    d = new Date();
	starttime = d.getDate() + "-" + (d.getMonth() + 1) + "-" + d.getFullYear() + " " + d.getHours() + ":" + d.getMinutes() + ":" + d.getSeconds();
    questionId = identifyPattern.currentGame.gameName;

    identifyPattern.showQuestion();
}

identifyPattern.showQuestion = function()      //Show Question and Answer.
{
    var optionArray = [];

    if(identifyPattern.currentGame.gameName == "N8A"){       //For N8A question
        $("#questionDiv").prop('class', "nopadding col-sm-4 col-lg-4 col-md-4 col-xs-4 col-xs-offset-4 col-md-offset-4 col-lg-offset-4 col-sm-offset-4");
        img = document.createElement('img');
        $('#questionDiv').append(img);
        $(img).prop('id','queImg');
        $('#queImg').prop('class', "nopadding img-responsive col-sm-12 col-lg-12 col-md-12 col-xs-12");
        $('#queImg').prop('src', Utils.Path + "images/" + identifyPattern.currentGame.queImg  + ".png");

        $("#ansOptionDiv").css('right','4vw');
        $("#ansOptionDiv").prop('class', "nopadding col-sm-12 col-lg-12 col-md-12 col-xs-12")
    }
    else{
            quePatternArray = identifyPattern.currentGame.patternArray;
            
            for(i=0; i < quePatternArray.length; i++)
            {
                div = document.createElement('div');
                $('#questionDiv').append(div);
                $(div).prop('id','quePattern'+(i+1));
                switch(identifyPattern.currentGame.gameName){
                    case "P1B":                 //A B A B A
                    case "P2B":                 //A B B A B B
                    case "P3B":                 //A B A B A B
                    case "P4A":                 //A B C C B A
                                $('#quePattern'+(i+1)).prop('class', "nopadding rightCss col-sm-2 col-lg-2 col-md-2 col-xs-2");
                                break;
                    case "P4B":                 //A B C D
                    case "P5A":                 //A B C D
                    case "P5B":                 //A B C D
                                $('#quePattern'+(i+1)).prop('class', "nopadding rightCss col-sm-3 col-lg-3 col-md-3 col-xs-3");
                                break;
                }

                img = document.createElement('img');
                $('#quePattern'+(i+1)).append(img);
                $(img).prop('id','quePatternImg'+(i+1));
                $('#quePatternImg'+(i+1)).prop('class', "zoomImg nopadding img-responsive col-sm-12 col-lg-12 col-md-12 col-xs-12");
                /* if(i == 0){
                    $(img).prop('src', Utils.Path + "images/" + quePatternArray[i] + ".png");   
                    $('#quePatternImg1').css('pointer-events', 'none');
                } */
                if(i == 0){
                    identifyPattern.imgCount++;
                    $(img).prop('src', Utils.Path + "images/point_icon.png");   
                    document.getElementById('quePatternImg'+(i+1)).setAttribute('onclick','identifyPattern.showPattern()');
                }
                else{
                    document.getElementById('quePatternImg'+(i+1)).setAttribute('onclick','identifyPattern.showPattern()'); 
                    $(img).css("visibility", "hidden");
                }
            }
    }
    
    optionArray = identifyPattern.currentGame.optionData;
    shuffle(optionArray);
    //console.log(optionArray);
    for(i = 0; i < optionArray.length; i++)
	{	
		div = document.createElement("div");
		document.getElementById("ansOptionDiv").appendChild(div);
        div.setAttribute("id","ansDiv"+(i+1));
        div.setAttribute('onclick','identifyPattern.selectOption(this.id)')
        if(identifyPattern.currentGame.gameName == "N8A")    //For N8A question
            div.setAttribute("class","divBorder nopadding col-xs-2 col-sm-2 col-md-2 col-lg-2 col-xs-offset-1 col-md-offset-1 col-lg-offset-1 col-sm-offset-1");
        else
            div.setAttribute("class","optionDivCss divBorder centerClass nopadding col-xs-5 col-sm-5 col-md-5 col-lg-5");

        image = document.createElement("img");
        document.getElementById("ansDiv"+(i+1)).appendChild(image);
        image.setAttribute("id","ansImage"+(i+1));
        image.setAttribute("class","img-responsive nopadding col-xs-12 col-sm-12 col-md-12 col-lg-12"); 
        image.src = Utils.Path + "images/" + optionArray[i].ansImg + ".png";
        $("#ansDiv"+(i+1)).data('ans',optionArray[i].answer);
        $("#ansDiv"+(i+1)).data('ansImg',optionArray[i].ansImg);
        $("#ansDiv"+(i+1)).data('ansData',optionArray[i].ansData);
    }    
}

identifyPattern.showPattern = function()
{
    var quePatternArray = identifyPattern.currentGame.patternArray;
    
    if(identifyPattern.imgCount == 1){
        $('#quePatternImg1').prop('src', Utils.Path + "images/" + quePatternArray[identifyPattern.imgCount - 1] + ".png");
        $('#quePatternImg2').css("visibility", "visible");
        $('#quePatternImg2').prop('src', Utils.Path + "images/point_icon.png");
        $('#quePatternImg1').css('pointer-events', 'none');
        identifyPattern.imgCount++;
    }
    else if(identifyPattern.imgCount == 2){
        $('#quePatternImg2').prop('src', Utils.Path + "images/" + quePatternArray[identifyPattern.imgCount - 1] + ".png");
        $('#quePatternImg3').css("visibility", "visible");
        $('#quePatternImg3').prop('src', Utils.Path + "images/point_icon.png");
        $('#quePatternImg2').css('pointer-events', 'none');
        identifyPattern.imgCount++;
    }
    else if(identifyPattern.imgCount == 3){
        $('#quePatternImg3').prop('src', Utils.Path + "images/" + quePatternArray[identifyPattern.imgCount - 1] + ".png");
        $('#quePatternImg4').css("visibility", "visible");
        $('#quePatternImg4').prop('src', Utils.Path + "images/point_icon.png");
        $('#quePatternImg3').css('pointer-events', 'none');
        identifyPattern.imgCount++;
    }
    else if(identifyPattern.imgCount == 4){         //P4B, P5A, P5B: A B C D
        $('#quePatternImg4').prop('src', Utils.Path + "images/" + quePatternArray[identifyPattern.imgCount - 1] + ".png");
        $('#quePatternImg4').css('pointer-events', 'none');
        if(quePatternArray.length > 4){
            $('#quePatternImg5').css("visibility", "visible");
            $('#quePatternImg5').prop('src', Utils.Path + "images/point_icon.png");
        }
        identifyPattern.imgCount++;
    }
    else if(identifyPattern.imgCount == 5){         //P1B: A B A B A
        $('#quePatternImg5').prop('src', Utils.Path + "images/" + quePatternArray[identifyPattern.imgCount - 1] + ".png");
        $('#quePatternImg5').css('pointer-events', 'none');
        if(quePatternArray.length > 5){
            $('#quePatternImg6').css("visibility", "visible");
            $('#quePatternImg6').prop('src', Utils.Path + "images/point_icon.png");
        }
        identifyPattern.imgCount++;
    }
    else if(identifyPattern.imgCount == 6){          //P2B: A B B A B B         //P3B: A B A B A B      //P4A: A B C C B A
        $('#quePatternImg6').prop('src', Utils.Path + "images/" + quePatternArray[identifyPattern.imgCount - 1] + ".png");
        $('#quePatternImg6').css('pointer-events', 'none');
        identifyPattern.imgCount++;
    }
    else
        identifyPattern.imgCount = 0
}

identifyPattern.selectOption = function(optionId)
{
    identifyPattern.attemptFlag = true;
    $("#"+ identifyPattern.previousClickedOption).css('border', '2px solid black');
    identifyPattern.clickedOptionData = $("#"+ optionId).data('ans');
    //console.log(identifyPattern.clickedOptionData);   
    label = $("#"+ optionId).data('ansData'); 
    $("#"+ optionId).css('border', '6px solid rgb(255, 190, 0)');
    identifyPattern.previousClickedOption = optionId;
}

identifyPattern.nextQue = function()
{    
    if(identifyPattern.attemptFlag == false){
        label = "null";
        scoredmarks = '0';
    }
    else{ 
        if(identifyPattern.clickedOptionData == 'Correct'){     
            //console.log('Correct');
            scoredmarks = '2';
        }
        else{                                                   
            //console.log('Wrong');
            scoredmarks = '1';
        }
    }
    /* $("#footer").css("pointer-events", "none");
    $("#nextDiv").css("pointer-events", "none");
    $("#resetDiv").css("pointer-events", "none");
    $("#ansOptionDiv").css("pointer-events", "none"); */
    console.log(scoredmarks, starttime, label);
	if (Utils.mobileDeviceFlag)
        Android.gotoNextGame(scoredmarks, starttime, label);
        
    //alert("ScoredMarks = " + scoredmarks +","+" "+"Label = " +label);
}

identifyPattern.reset = function()
{
    $("#"+ identifyPattern.previousClickedOption).css('border', '2px solid black');
    label = 'null';
    scoredmarks = 0;
    identifyPattern.attemptFlag = false;
    identifyPattern.clickedOptionData = null;
    identifyPattern.previousClickedOption = null;

    for(index = 1; index <= identifyPattern.currentGame.patternArray.length; index++){
        $('#quePatternImg'+index).css('pointer-events', 'auto');
        if(index == 1){
            $('#quePatternImg'+index).css("visibility", "visible");
            $('#quePatternImg'+index).prop('src', Utils.Path + "images/point_icon.png");   
        }
        else{
            $('#quePatternImg'+index).prop('src', " ");   
            $('#quePatternImg'+index).css("visibility", "hidden");
        }
    } 
    identifyPattern.imgCount = 1;
}

function shuffle(randomArray) {
    var arrayLength = randomArray.length;
    var temp, random_index;
    while (arrayLength > 0) {
        random_index = Math.floor(Math.random() * arrayLength);
        arrayLength--;
        temp = randomArray[arrayLength];
        randomArray[arrayLength] = randomArray[random_index];
        randomArray[random_index] = temp;
    }
    return (randomArray);
}
