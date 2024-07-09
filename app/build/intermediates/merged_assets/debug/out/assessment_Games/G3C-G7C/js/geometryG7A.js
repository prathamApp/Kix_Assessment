var G7A = {};

var Utils = {};
Utils.Path = '';
Utils.mobileDeviceFlag = false;
var questionId = 0, starttime = 0, scoredmarks = 0, label='null', resetVariable = true, resId = 0;
G7A.queCounter = 0;var langIndex=0;
var selectedImages = [];
var selectedLabel=[];
$(document).ready(function () {
    $('.pattern2').hide();
    if ((navigator.userAgent.match(/Android|BlackBerry|iPhone|iPad|iPod|Opera Mini|IEMobile/i)) && !(window.location.href.includes('http')))
        Utils.mobileDeviceFlag = true;
    showQues();
    G7A.createDiv();
    G7A.showImages();
    // G7A.getGameCode();  
    // G7A.setQuestion();      
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

function resetGame() {
    $('.imgDiv').removeClass('border');
    resetVariable = true;
    selectedImages = [];
    selectedLabel=[];
    label='null';
}

G7A.createDiv = function () {
    var count = 1;
    for (var row = 0; row < 3; row++) {
        var outerDiv = document.createElement('div');
        $(outerDiv).prop('class', 'imgContainer col-xs-12 col-sm-12 col-lg-12 col-md-12 noPadding');
        $('#imgDiv').append(outerDiv);
        for (var col = 0; col < 4; col++) {
            var div = document.createElement('div');
            $(div).prop('id', 'div' + count);
            $(div).prop('class', 'imgDiv col-xs-2 col-sm-2 col-lg-2 col-md-2 noPadding');
            $(div).css({'pointer-events': 'none','visibility':'hidden'});
            $(div).on('click', function () {
                G7A.selectImages(this.id);
            });

            var img = document.createElement('img');
            $(img).prop('id', 'image' + count);
            $(img).prop('class', 'img-responsive noPadding col-xs-10 col-sm-10 col-lg-10 col-md-10 col-xs-offset-1 col-sm-offset-1 col-lg-offset-1 col-md-offset-1');
            $(div).append(img);

            $(outerDiv).append(div);
            count++;
        }
    }
   
}
G7A.showImages = function () {
    var d;
    scoredmarks = 0;
    d = new Date();
    starttime = d.getDate() + "-" + (d.getMonth() + 1) + "-" + d.getFullYear() + " " + d.getHours() + ":" + d.getMinutes() + ":" + d.getSeconds();
    // G7A.queCounter=Math.floor(Math.random()*data.length);
    if (Utils.mobileDeviceFlag) {
        var val = Android.getGameLang();		//GET ANDROID GAME LANGUAGE
        //var val = 'Hindi'
        var lang = data.find(checkIndex);
        if(lang.language=='Urdu-Pakistan')
        {
            $('#heading').css('direction','rtl');
        }
        langIndex = data.indexOf(lang);

        function checkIndex(i) {
            if (i.language.toLowerCase().trim() == val.toLowerCase().trim())
                return i;
        }
    }
    else
        langIndex = 0;//Math.floor(Math.random() * data.length);			//GET RANDOM GAME LANGUAGE

    if (Utils.mobileDeviceFlag) {
        var val = Android.getGameID();
        /*  val='G7C'; */
        var index = data[langIndex].nodeInfo.find(checkIndex);
        G7A.queCounter = data[langIndex].nodeInfo.indexOf(index);

        function checkIndex(i) {
            if (i.queNo == val)
                return i;
        }
    }
    else
        G7A.queCounter = Math.floor(Math.random() * (data[langIndex].nodeInfo.length ));

    if(data[langIndex].languageFont!=null)
        setFontFamilyForLang( data[langIndex].languageFont);
        
    questionId = data[langIndex].nodeInfo[G7A.queCounter].queNo;
    //$('#heading').text(data[G7A.queCounter].question);
    document.getElementById('heading').innerHTML = data[langIndex].nodeInfo[G7A.queCounter].question;
    $('#queNo').text(data[langIndex].nodeInfo[G7A.queCounter].queNo);
    G7A.setImages(data[langIndex].nodeInfo[G7A.queCounter].imgArray);
}

G7A.setImages = function (imgArr) {
    var filledDivArr=[];var asciiVal=65;
    for (var i = 0; i < imgArr.length; i++) {
        var random = Math.floor(Math.random() * 11) + 1;
        if (filledDivArr.includes(random)) {
            i--;
            continue;
        }
        else {
            filledDivArr.push(random);
            $('#image' + random).prop('src', 'images/' + imgArr[i] + '.png');
            $('#div' + random).data('imgName', imgArr[i]);
			$('#div'+random).data('labelName',String.fromCharCode(asciiVal));
            $('#div' + random).css({'pointer-events':'auto','visibility':'visible'});
        }
		 asciiVal++;
    }
    
    /* for(i=0;i<data[langIndex].nodeInfo[G7A.queCounter].imgArray.length;i++){
        $('#div'+(i+1)).data('labelName',String.fromCharCode(asciiVal));//to set A B C D
       
    } */
    
}

G7A.selectImages = function (id) {
	
    resetVariable = false;
    if($('#'+id).hasClass('border'))
    {
        var selectedEleIdx=selectedImages.indexOf($('#' + id).data('imgName'));
        var labelIdx=selectedLabel.indexOf($('#'+id).data('imgName'));
        $('#' + id).removeClass('border');
        selectedImages.splice(selectedEleIdx,1);
        selectedLabel.splice(labelIdx,1);
    }
    else
    {
        $('#' + id).addClass('border');
        selectedImages.push($('#' + id).data('imgName'));
        selectedLabel.push($('#'+id).data('imgName') + '.png');
       
    }   
    
}


G7A.nextQuestion = function () {
    /*  $('body').css('pointer-events','none'); */
    var correctCount = 0;
    label=selectedLabel.join();
    for (var i = 0; i < selectedImages.length; i++) {
        if (data[langIndex].nodeInfo[G7A.queCounter].ansArr.includes(selectedImages[i]))
            correctCount++;
        else {
            correctCount = 0;
            break;
        }
    }
    if (correctCount == data[langIndex].nodeInfo[G7A.queCounter].ansArr.length)
        scoredmarks = '2';
    else if (resetVariable)
	{
		label='null';
        scoredmarks = '0';
	}
    else
        scoredmarks = '1';
    if (Utils.mobileDeviceFlag)
        Android.gotoNextGame(scoredmarks, starttime, label);
    console.log(scoredmarks, starttime, label);
	//alert("ScoredMarks = " + scoredmarks +","+" "+"Label = " +label);
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
