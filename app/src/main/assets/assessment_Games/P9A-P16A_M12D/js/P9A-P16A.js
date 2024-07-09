
var identifyPattern = {};
var Utils = {};
Utils.Path = "";
var scoredmarks = '0', starttime = '0', label ='', gameFlag = false, blinkImgId = '', blinkDivId='';

$(document).ready(function () {
    /* if(navigator.userAgent.match(/Android|BlackBerry|iPhone|iPad|iPod|Opera Mini|IEMobile/i))
		Utils.mobileDeviceFlag=true; */
    if((navigator.userAgent.match(/Android|BlackBerry|iPhone|iPad|iPod|Opera Mini|IEMobile/i)) && !(window.location.href.includes('http')))
        Utils.mobileDeviceFlag = true;
	else
		Utils.mobileDeviceFlag=false;
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
	var langIndex = 3, randLang = '';
	//Utils.mobileDeviceFlag = false;
    if(Utils.mobileDeviceFlag){					//For mobile device.
		randLang = Android.getGameLang();
		//randLang = 'Hindi-India';
		langIndex = identifyPattern.patternData.findIndex(obj => obj.language.toLowerCase().trim() == randLang.toLowerCase().trim());
        var gameCode = Android.getGameID();
        //var gameCode = "M12E";
        identifyPattern.randQue = identifyPattern.patternData[langIndex].gameArray.findIndex(obj => obj.gameName == gameCode);
    }
    else{ 										//For browser
		identifyPattern.randQue = Math.floor(Math.random() * identifyPattern.patternData[langIndex].gameArray.length); 
    } 
    
    if(langIndex == 10 || randLang == 'Urdu-Pakistan'){
        $("#heading").css('direction', 'rtl');
    }
	//identifyPattern.randQue = 0;
	identifyPattern.currentGame = identifyPattern.patternData[langIndex].gameArray[identifyPattern.randQue];
    document.title = identifyPattern.currentGame.gameName;   
    $('#queNo').text(identifyPattern.currentGame.gameName);
    document.getElementById("heading").innerHTML = identifyPattern.currentGame.questionText;
    $("#heading").css('font-weight', 'normal');

    switch(identifyPattern.currentGame.gameName){
        case 'P10A':
        case 'P11A':		
        case 'P12A':
        case 'P13A':
            $("#heading").css('font-size', '1.4vw');   //P10A, P11A, P12A, P13A
            break;
        case 'P9A':
        case 'P14A':
        case 'P15A':
        case 'P16A':
        case 'M12D':
        case 'M12E':
            $("#heading").css('font-size', '1.6vw');   //P9A, P14A, P15A, P16A
            break;
    }

    d = new Date();
	starttime = d.getDate() + "-" + (d.getMonth() + 1) + "-" + d.getFullYear() + " " + d.getHours() + ":" + d.getMinutes() + ":" + d.getSeconds();
    //questionId = identifyPattern.currentGame.gameName;

    if(identifyPattern.patternData[langIndex].languageFont!=null)
        setFontFamilyForLang(identifyPattern.patternData[langIndex].languageFont);

    identifyPattern.showQuestion();
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

identifyPattern.showQuestion = function(index)      //Show Question and Answer.
{
    var optionArray = [];
    
    if(identifyPattern.currentGame.gameName == 'M12D'){       //For M12D question
        $("#questionDiv").prop('class', "nopadding col-sm-3 col-lg-3 col-md-3 col-xs-3 col-xs-offset-5 col-md-offset-5 col-lg-offset-5 col-sm-offset-5")
        $("#questionDiv").css('right', '4vw');
        $("#ansOptionDiv").prop('class', "nopadding col-sm-7 col-lg-7 col-md-7 col-xs-7 col-xs-offset-3 col-md-offset-3 col-lg-offset-3 col-sm-offset-3")
        $("#ansOptionDiv").css('margin-top', '-3vh');
        $("#ansOptionDiv").css('left', '1vw');
        $("#ansOptionDiv").css('top', '3vh');
        
    }
    else if(identifyPattern.currentGame.gameName == 'M12E'){	//M12E question
        $("#ansOptionDiv").prop('class', "nopadding col-sm-6 col-lg-6 col-md-6 col-xs-6 col-xs-offset-4 col-md-offset-4 col-lg-offset-4 col-sm-offset-4");
        //$("#gamePage").css("top","4.5vh");
        $("#ansOptionDiv").css('right', '4vw');
    }
    identifyPattern.showQuePattern();   //To show question pattern with blink box
    optionArray = identifyPattern.currentGame.data;
    shuffle(optionArray);
    //console.log(optionArray);
    for(i = 0; i < optionArray.length; i++)
	{	
		div = document.createElement("div");
		document.getElementById("ansOptionDiv").appendChild(div);
        div.setAttribute("id","ansDiv"+(i+1));
        div.setAttribute('onclick','identifyPattern.selectOption(this.id)');
        
        if(identifyPattern.currentGame.gameName == 'M12D' || identifyPattern.currentGame.gameName == 'M12E')    //For M12D, M12E question
            div.setAttribute("class","nopadding divBorder col-xs-2 col-sm-2 col-md-2 col-lg-2 col-xs-offset-2 col-md-offset-2 col-lg-offset-2 col-sm-offset-2");
        else
            div.setAttribute("class","divBorder col-xs-2 col-sm-2 col-md-2 col-lg-2 col-xs-offset-1 col-md-offset-1 col-lg-offset-1 col-sm-offset-1");
		
        image = document.createElement("img");
        document.getElementById("ansDiv"+(i+1)).appendChild(image);
        image.setAttribute("id","ansImage"+(i+1));
        image.setAttribute("class","img-responsive nopadding col-xs-12 col-sm-12 col-md-12 col-lg-12"); 
        //image.setAttribute('onclick','identifyPattern.selectOption(this.id)');
        image.src = Utils.Path + "images/" + optionArray[i].ansImg + ".png";
        $("#ansDiv"+(i+1)).data('ans',optionArray[i].answer);
        $("#ansDiv"+(i+1)).data('ansData',optionArray[i].ansData);
        $("#ansDiv"+(i+1)).data('ansImg',optionArray[i].ansImg);
		
		if(identifyPattern.currentGame.gameName == 'M12D' || identifyPattern.currentGame.gameName == 'M12E')    //For M12D, M12E question
			$(div).css('padding', '0px'); 
        else
            $(div).css('padding', '12px');                                  //For P9 to P16 games.
    }    
}

identifyPattern.showQuePattern = function()
{
    switch(identifyPattern.currentGame.gameName){
        case "P9A":                 //A B A B A
        case "P11A":                //A B A B A
        case "P14A":                //A B A B A
        case "P16A":                 //A B C A B C A B C 
                    gameFlag = true;
                    break;
    }
    /* if(!gameFlag)
        document.getElementById("queImg").src = Utils.Path + "images/" + identifyPattern.currentGame.queImg + ".png";
    else{ */
        quePatternArray = identifyPattern.currentGame.patternArray;
        
        for(i=0; i < quePatternArray.length; i++)
        {
            div = document.createElement('div');
            $('#questionDiv').append(div);
            $(div).prop('id','quePattern'+(i+1));
            switch(identifyPattern.currentGame.gameName){
                case "P9A":                 //A B A B A
                case "P11A":                //A B A B A
                case "P14A":                //A B A B A
                            $('#quePattern'+(i+1)).prop('class', "nopadding rightCss col-sm-2 col-lg-2 col-md-2 col-xs-2");
                            break;
                case "P16A":                 //A B C A B C A B C 
                            $('#questionDiv').css('right', '4vw');
                            $('#questionDiv').prop('class', "nopadding centerClass col-sm-11 col-lg-11 col-md-11 col-xs-11 col-sm-offset-1 col-lg-offset-1 col-md-offset-1 col-xs-offset-1");
                            $('#quePattern'+(i+1)).prop('class', "nopadding rightCss col-sm-1 col-lg-1 col-md-1 col-xs-1");
                            break;
            }

            img = document.createElement('img');
            $('#quePattern'+(i+1)).append(img);
            $(img).prop('id','quePatternImg'+(i+1));
            $('#quePatternImg'+(i+1)).prop('class', "zoomImg rightImgCss img-responsive col-sm-12 col-lg-12 col-md-12 col-xs-12");
            if(quePatternArray[i] != '?'){
                $(img).prop('src', Utils.Path + "images/" + quePatternArray[i] + ".png");   
                $('#quePatternImg'+(i+1)).css('pointer-events', 'none');
            } 
            else{
                blinkImgId = '#quePatternImg'+(i+1);
                blinkDivId = '#quePattern'+(i+1);
                $(blinkDivId).addClass('blink_me');
                $('#quePatternImg'+(i+1)).removeClass('zoomImg');
                $('#quePatternImg'+(i+1)).css('visibility', 'hidden');
                $('#quePattern'+(i+1)).css('borderBottom','2px solid black');
                if(identifyPattern.currentGame.gameName == 'P16A'){
                    $('.zoomImg').addClass('pZoomImg');
                }
            }
        }
    //}  
}

identifyPattern.selectOption = function(optionId)
{
    var clickOptionImg = '';
    identifyPattern.attemptFlag = true;
    $("#"+ identifyPattern.previousClickedOption).css('border', '1px solid black');
    identifyPattern.clickedOptionData = $("#"+ optionId).data('ans');
    //console.log(identifyPattern.clickedOptionData); 
    if(identifyPattern.currentGame.gameName == 'M12D' || identifyPattern.currentGame.gameName == 'M12E' || identifyPattern.currentGame.gameName == 'P13A')  //identifyPattern.randQue == 4
        label =  $("#"+ optionId).data('ansData') ;
    else{  
       label = identifyPattern.currentGame.pattern + $("#"+ optionId).data('ansData') + identifyPattern.currentGame.pattern1;   
    }
    
    clickOptionImg = $("#"+ optionId).data('ansImg') ;
    $(blinkImgId).prop('src', Utils.Path + "images/"+ clickOptionImg  +'.png');  
    $(blinkImgId).css('visibility', 'visible');
    $(blinkDivId).css('borderBottom','none');
    $(blinkDivId).removeClass('blink_me');
    $(blinkImgId).addClass('zoomImg');

    /* if(identifyPattern.clickedOptionData == 'Correct'){
        switch(identifyPattern.currentGame.gameName){
            case "P9A":                 //A B A B A
                        $(blinkImgId).prop('src', Utils.Path + "images/P9A_5.png");  
                        break; 
            case "P11A":                //A B A B A
                        $(blinkImgId).prop('src', Utils.Path + "images/P11A_3.png");  
                        break;
            case "P14A":                //A B A B A
                        $(blinkImgId).prop('src', Utils.Path + "images/P14A_4.png");  
                        break;
            case "P16A":                 //A B C A B C A B C 
                        $(blinkImgId).prop('src', Utils.Path + "images/P16A_2.png");  
                        break;
        } 
   } */

    /* if(identifyPattern.currentGame.gameName == 'M12D' || identifyPattern.currentGame.gameName == 'M12E')
       $("#"+ optionId).css('border', '2px solid rgb(255, 190, 0)');
    else */
        $("#"+ optionId).css('border', '10px solid rgb(255, 190, 0)');
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
    //$(blinkImgId).removeAttr('src');  
    document.getElementById('questionDiv').innerHTML = '';
    identifyPattern.showQuePattern();
    $(blinkImgId).css('visibility', 'hidden');
    $(blinkDivId).css('borderBottom','2px solid black');
    $("#"+ identifyPattern.previousClickedOption).css('border', '1px solid black');
    label = '';
    scoredmarks = '0';
    identifyPattern.attemptFlag = false;
    identifyPattern.clickedOptionData = null;
    identifyPattern.previousClickedOption = null;
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
