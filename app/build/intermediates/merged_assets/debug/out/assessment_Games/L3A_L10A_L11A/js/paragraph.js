var Paragraph = {};

var Utils = {};
Utils.Path = '';
Utils.mobileDeviceFlag = false;
var starVisible=false;
var questionId = 0, starttime = 0, scoredmarks = '0', label='null', resetVariable = true, resId = 0;
Paragraph.queCounter = 0;var langIndex=0;Paragraph.que=0;
var selectedImages = [];
var selectedLabel=[];
Paragraph.readingArray=["L3A.1","L3A.2","L3A.3","L3A.4","L3A.5","L3A.6","L3B.1","L3B.2","L3B.3","L3B.4","L3B.5","L3B.6","L3D.1","L3D.2","L3D.3","L3D.4","L3D.5","L3D.6"]
$(document).ready(function () {
    if ((navigator.userAgent.match(/Android|BlackBerry|iPhone|iPad|iPod|Opera Mini|IEMobile/i)) && !(window.location.href.includes('http')))
        Utils.mobileDeviceFlag = true;
    $('#que').hide();
    $('#speaker').prop('src','image/speaker.png');
    showQues();   
    Paragraph.setQuestion();
});

setFontFamilyForLang = function (fontFilePath) {
    var newStyle = "<style>" +
        "@font-face { " +
        "font-family: 'CustomFontFamily';" +
        "src: url('" + fontFilePath + "') format('truetype');" +
        "} </style>";
    $("head").append(newStyle);
    $("body").css("font-family", "CustomFontFamily");
}

function showQues() {
    $('#questioMark').hide();
    $('#myModal').css('display', 'block');
    
}

function hideQuestion() {
    $('#questioMark').show();
    $('#myModal').css('display', 'none');
}

Paragraph.setQuestion = function () {
    var d;
    scoredmarks = '0';
    d = new Date();
    starttime = d.getDate() + "-" + (d.getMonth() + 1) + "-" + d.getFullYear() + " " + d.getHours() + ":" + d.getMinutes() + ":" + d.getSeconds();
    // Paragraph.queCounter=Math.floor(Math.random()*data.length);
    if (Utils.mobileDeviceFlag) {
        var val = Android.getGameLang();		//GET ANDROID GAME LANGUAGE
        //var val = 'Hindi'
        var lang = data.find(checkIndex);
        if(lang.language=='Urdu-Pakistan')
        {
           $('#paragraph').css('direction','rtl');
           $('#answerKeyText').css('direction','rtl');
           $('#heading').css('direction','rtl');
        }
            
        langIndex = data.indexOf(lang);

        function checkIndex(i) {
            if (i.language.toLowerCase().trim() == val.toLowerCase().trim())
                return i;
        }
       
    }
    else
    {
        langIndex = 5;//Math.floor(Math.random() * data.length);			//GET RANDOM GAME LANGUAGE
        if(langIndex==11)
        {
            $('#paragraph').css('direction','rtl');
            $('#heading').css('direction','rtl');
            $('#answerKeyText').css('direction','rtl');
        }
    }
    if(data[langIndex].languageFont!=null)
        setFontFamilyForLang(data[langIndex].languageFont);

    if (Utils.mobileDeviceFlag) {
        var val = Android.getGameID();
        
        var index = data[langIndex].nodeInfo.find(checkIndex);
        Paragraph.queCounter = data[langIndex].nodeInfo.indexOf(index);

        function checkIndex(i) {
            if (i.queNo == val)
                return i;
        }
    }
    else
       Paragraph.queCounter =Math.floor(Math.random() * (data[langIndex].nodeInfo.length ));
       // Paragraph.queCounter =33; 
    document.getElementById('heading').innerHTML = data[langIndex].nodeInfo[Paragraph.queCounter].question;
   
    if(data[langIndex].nodeInfo[Paragraph.queCounter].title=='')
        $('#title').hide();
    else{
        $('#title').text(data[langIndex].nodeInfo[Paragraph.queCounter].title);
        $('#title').show();
    }
    if(data[langIndex].nodeInfo[Paragraph.queCounter].queNo=='L3A' || 
        data[langIndex].nodeInfo[Paragraph.queCounter].queNo=='L3B' || 
        data[langIndex].nodeInfo[Paragraph.queCounter].queNo=='L3C' || 
        data[langIndex].nodeInfo[Paragraph.queCounter].queNo=='L3D' || 
        data[langIndex].nodeInfo[Paragraph.queCounter].queNo=='L10A' || 
        data[langIndex].nodeInfo[Paragraph.queCounter].queNo=='L10B' || 
        data[langIndex].nodeInfo[Paragraph.queCounter].queNo=='L10C' || 
        data[langIndex].nodeInfo[Paragraph.queCounter].queNo=='L10D' || 
        data[langIndex].nodeInfo[Paragraph.queCounter].queNo=='L11A' ||
        data[langIndex].nodeInfo[Paragraph.queCounter].queNo=='L11B' ||
        data[langIndex].nodeInfo[Paragraph.queCounter].queNo=='L11C' ||
        data[langIndex].nodeInfo[Paragraph.queCounter].queNo=='L11D'||
        data[langIndex].nodeInfo[Paragraph.queCounter].queNo=='L12A' ||
        data[langIndex].nodeInfo[Paragraph.queCounter].queNo=='L12B' ||
        data[langIndex].nodeInfo[Paragraph.queCounter].queNo=='L12C' )
    {
        $('#queNo').text(data[langIndex].nodeInfo[Paragraph.queCounter].queNo);
        Paragraph.nextPage('prev');
        //$('#paragraph').html(data[langIndex].nodeInfo[Paragraph.queCounter].paragraph);       
        $('#modalIcon').css('visibility','hidden');
    }
    else
    {
        starVisible=true;
        Paragraph.showNextQuestion();
    }
    if(!data[langIndex].nodeInfo[Paragraph.queCounter].showInputDiv)
        $('#inputDiv').hide();
    else{
        if(data[langIndex].nodeInfo[Paragraph.queCounter].queNo=='L10A' || 
        data[langIndex].nodeInfo[Paragraph.queCounter].queNo=='L10B' || 
        data[langIndex].nodeInfo[Paragraph.queCounter].queNo=='L10C' || 
        data[langIndex].nodeInfo[Paragraph.queCounter].queNo=='L10D' || 
        data[langIndex].nodeInfo[Paragraph.queCounter].queNo=='L11A' ||
        data[langIndex].nodeInfo[Paragraph.queCounter].queNo=='L11B' ||
        data[langIndex].nodeInfo[Paragraph.queCounter].queNo=='L11C' ||
        data[langIndex].nodeInfo[Paragraph.queCounter].queNo=='L11D'||
        data[langIndex].nodeInfo[Paragraph.queCounter].queNo=='L12A' ||
        data[langIndex].nodeInfo[Paragraph.queCounter].queNo=='L12B' ||
        data[langIndex].nodeInfo[Paragraph.queCounter].queNo=='L12C')
        {
           // starVisible=true;
            $('#modalIcon').css('visibility','hidden');
            $('#inputDiv').show();
            $('#didChildRead').text(data[langIndex].DidChildRead);
            $('#noOfMistaketext').text(data[langIndex].noOfMistakes);
            $('#yesLabel').text(data[langIndex].yesNo[0]);
            $('#noLabel').text(data[langIndex].yesNo[1]);
        }
        else
        {
            $('#inputDiv').hide();
            $('.directCoding').show();
        }
    }
        
    $('#paragraph').css('line-height',data[langIndex].nodeInfo[Paragraph.queCounter].lineHeight);
    $('#paragraph').css('font-size',data[langIndex].nodeInfo[Paragraph.queCounter].font+'vw');
}

Paragraph.nextPage=function(id){
    if(Paragraph.readingArray.includes(data[langIndex].nodeInfo[Paragraph.queCounter].queNo))
    {
        var i=0;
        for(i=0;i<data[langIndex].nodeInfo.length;i++)
        {
            if(data[langIndex].nodeInfo[Paragraph.queCounter].queNo.split(".")[0]==data[langIndex].nodeInfo[i].queNo)
            {
           // console.log(i);
            break;
            }
        }
        $('#modalInstn').html(data[langIndex].nodeInfo[i].question);
        $("#modalInstruction").css("visibility","visible");
        $("body").addClass("overlay");
        document.getElementById('paragraph').innerHTML=data[langIndex].nodeInfo[Paragraph.queCounter].paragraph;
        $("#headerId,#close").css("pointer-events","none");
    }
    else
    {
        document.getElementById('paragraph').innerHTML=data[langIndex].nodeInfo[Paragraph.queCounter].paragraph;
        $("#modalInstruction").css("visibility","hidden");
    }
}

Paragraph.showNextQuestion=function(){
    //$('#paragraphDiv').hide();
    $('#modalIcon').css('visibility','visible');
    //$('#que').show(); 
    Paragraph.nextPage('prev');
    //document.getElementById('paragraph').innerHTML=data[langIndex].nodeInfo[Paragraph.queCounter].paragraph;
    $('#queNo').text(data[langIndex].nodeInfo[Paragraph.queCounter].queNo);
    $('#heading').css('font-size','2vw');
    $('#heading').html(data[langIndex].nodeInfo[Paragraph.queCounter].question);
    if(data[langIndex].nodeInfo[Paragraph.queCounter].answerKey!='')
    {
        $('#answerKeyText').css('visibility','visible');
        $('#answerKeyText').text(data[langIndex].answer+" "+data[langIndex].nodeInfo[Paragraph.queCounter].answerKey);
    }
    else
        $('#answerKeyText').css('visibility','hidden');
        
}
function closeModalInstruction()
{
    $("#modalInstruction").css('visibility','hidden');
    $("body").removeClass("overlay");
    $("#headerId,#close").css("pointer-events","auto");
}
Paragraph.nextQuestion=function(){
    if(clickOption !=="" || !(starVisible))
	{
		scoredMarks=clickOption;
		Paragraph.calculateScore();
	}
	else
	    showModal()
}

Paragraph.calculateScore = function () {
    label = 'null';
    if(Utils.mobileDeviceFlag)
        Android.gotoNextGame(scoredmarks,starttime,label);
    console.log(scoredmarks,starttime,label);
}

function shuffleArray(array) {
    var i, j, temp;
    for (i = array.length - 1; i > 0; i--) {
        j = Math.floor(Math.random() * (i + 1));
        temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    return array;
}
