var Classification = {};
var Utils = {};
Utils.Path = '';
Utils.mobileDeviceFlag = false;
var questionId = 0, starttime = 0, scoredmarks = 0, totalMarks = "2", resId = 0, level = 1, label = "null";
Classification.randomObjectIndex = 0;
Classification.objArray = [];
Classification.ColorArray = [];
Classification.Count = 1;
Classification.cnt = 1;
Classification.randomDivs = [];
Classification.xArr1 = [];
Classification.levelCtr = 0;
Classification.questionCtr = 0;
Classification.exFlag = false;
var imageArray = [], queNo = '', jarCnt = 0, correctCnt = 0, dragCnt = 0, objCnt = 0, firstItr = 0, secondItr = 0, langCtr = 0;



$(document).ready(function () {
	$(".se-pre-con").fadeOut("slow");
	if ((navigator.userAgent.match(/Android|BlackBerry|iPhone|iPad|iPod|Opera Mini|IEMobile/i)) && !(window.location.href.includes('http')))
		Utils.mobileDeviceFlag = true;
	setTimeout(function () {
		Classification.init();
	}, 100);
});
Classification.init = function () {
	document.title = Classification.hardcodedData.gameTitle;
	document.body.style.backgroundColor = "#EFF1F4";
	document.getElementById('gamapage').style.display = "block";
	Classification.initializeVariables();
	if (Utils.mobileDeviceFlag) {
		var val = Android.getGameLang();		//GET ANDROID GAME LANGUAGE
		/*  var val = 'ENGLISH' */
		var lang = Classification.shapeImgData.find(checkLang);
		langCtr = Classification.shapeImgData.indexOf(lang);
		function checkLang(i) {
			if (i.lang.toLowerCase() == val.toLowerCase())
				return i;
		}
		var val = Android.getGameID();
		data = Classification.shapeImgData[langCtr].data.find(checkIndex);
		Classification.levelCtr = Classification.shapeImgData[langCtr].data.indexOf(data);

		function checkIndex(i) {
			if (i.queNo == val)
				return i;
		}
	}
	else
		Classification.levelCtr = 1//Math.floor(Math.random() * Classification.shapeImgData[langCtr].data.length);
	Classification.playGame();

}
Classification.initializeVariables = function () {

	Classification.dropCtr = 1;
	Classification.solvedFlag = true;
	Classification.objArray = [];
	Classification.randomDivs = [];
	Classification.xArr1 = [];
	Classification.Count = 1;
	Classification.cnt = 0;
}
Classification.playGame = function () {
	d = new Date();
	starttime = d.getDate() + "-" + (d.getMonth() + 1) + "-" + d.getFullYear() + " " + d.getHours() + ":" + d.getMinutes() + ":" + d.getSeconds();
	jarCnt = Classification.shapeImgData[langCtr].data[Classification.levelCtr].jarCnt;

	//Classification.createDropBoxes();
	Classification.setAllImages();
	Classification.createDraggableDivs();
	Classification.setQuestion();
	Classification.getRandomShapesAndColors();
	Classification.Count = 1;
}

Classification.createDropBoxes = function () {
	var parentDiv;
	parentDiv = document.getElementById("jarDiv");
	for (i = 1; i <= jarCnt; i++) {
		BoxDiv = document.createElement("DIV");
		BoxDiv.setAttribute("id", "Box" + i);
		BoxDiv.setAttribute("class", "Box noPadding col-sm-1 col-lg-1 col-md-1 col-xs-1");
		parentDiv.appendChild(BoxDiv);
		dropBox = document.createElement("DIV");
		dropBox.setAttribute("id", "dropBox" + i);
		dropBox.setAttribute("class", "dropBox noPadding col-sm-6 col-lg-6 col-md-6 col-xs-6 col-sm-offset-3 col-lg-offset-3 col-md-offset-3 col-xs-offset-3");
		BoxDiv.appendChild(dropBox);
	}
}


Classification.setQuestion = function () {
	questionText = Classification.shapeImgData[langCtr].data[Classification.levelCtr].question;
	queNo = Classification.shapeImgData[langCtr].data[Classification.levelCtr].queNo;
	font = Classification.shapeImgData[langCtr].data[Classification.levelCtr].font;
	document.getElementById("heading").innerHTML = questionText;
	document.getElementById("queNo").innerHTML = "D5Eg";
	document.getElementById("queNo").style.fontSize = "1.8vw";
	document.getElementById("heading").style.fontSize = font;
	// document.getElementById("heading").style.fontWeight = 100;
	$('#heading').parent().css('font-weight', 'unset');

	if (langCtr == 4) {
		document.getElementById("heading").style.direction = "rtl";
	}
}

Classification.setAllImages = function () {
	switch (Classification.levelCtr) {

		case 0: {
			correctCnt = 2;
			dragCnt = 10;
			objCnt = 10;
			firstItr = 5;
			secondItr = 5;
			document.getElementById('Box1').style.backgroundImage = "url('images/D5B_1.png')";
			//document.getElementById('Box1').style.backgroundColor = "lightgrey";

			//document.getElementById('Box1').style.marginLeft = "30vw";
		}
			break;
		case 1: {
			correctCnt = 2;
			dragCnt = 10;
			objCnt = 10;
			firstItr = 5;
			secondItr = 5;
			// document.getElementById('Box1').style.backgroundColor = "lightgrey";
			document.getElementById('Box1').style.backgroundImage = "url('images/D5B_1.png')";
			//document.getElementById('Box1').style.marginLeft = "30vw";

		}
			break;
	}
}
//get shape or color randomly//
Classification.getRandomShapesAndColors = function () {
	//Classification.levelCtr = 1;
	var randomIndex = 0, uniqueObjArray = [], uniqueColorArray = [];
	randomIndex = Classification.levelCtr;
	for (i = 0; i < objCnt; i++) {
		Classification.objArray.push(randomIndex);
		// Classification.objArray.push(randomIndex);
		// Classification.objArray.push(randomIndex);
		// Classification.objArray.push(randomIndex);
	}
	Classification.getImages();
}
// get random images//
Classification.getImages = function () {
	ctr = 0;
	for (var i = 0; i < Classification.objArray.length; i++) {
		objectIndex = Classification.objArray[i];
		colorIndex = i;
		imageArray.push({ data: Classification.shapeImgData[langCtr].data[objectIndex].colorObjects[colorIndex].imageName[0], imgPath: Classification.shapeImgData[langCtr].data[objectIndex].colorObjects[colorIndex].imgPath });
		// imageArray.push({ data: Classification.shapeImgData[objectIndex].colorObjects[colorIndex].imageName[0], imgPath: Classification.shapeImgData[objectIndex].colorObjects[colorIndex].imgPath });
		// imageArray.push({ data: Classification.shapeImgData[objectIndex].colorObjects[colorIndex].imageName[0], imgPath: Classification.shapeImgData[objectIndex].colorObjects[colorIndex].imgPath });
	}
	console.log(imageArray);
	Classification.setImagesToDivs();
	Classification.setImagesAtRandomPos();

}
// set images to divs//
Classification.setImagesToDivs = function () {
	for (var i = 0; i < jarCnt; i++) {
		document.getElementById('dropBox' + (i + 1)).setAttribute("jarData", Classification.shapeImgData[langCtr].data[Classification.levelCtr].object[i]);
	}
	console.log(imageArray);
}

Classification.createDraggableDivs = function () {
	ctr = 0;
	for (j = 1; j <= 2; j++) {
		parentDiv = document.getElementById("container" + j);
		if (j == 1)
			iterator = firstItr;
		else
			iterator = secondItr
		for (var i = 0; i < iterator; i++) {
			dragDiv = document.createElement("DIV");
			dragDiv.setAttribute("id", "dragDiv" + ctr);
			if (i == 0)
				dragDiv.setAttribute("class", "dragDivs noPadding col-sm-1 col-lg-1 col-md-1 col-xs-1")
			else
				dragDiv.setAttribute("class", "dragDivs noPadding col-sm-1 col-lg-1 col-md-1 col-xs-1 col-sm-offset-1 col-lg-offset-1 col-md-offset-1 col-xs-offset-1")
			parentDiv.appendChild(dragDiv);

			imgElement = document.createElement('img');
			imgElement.setAttribute("class", "img-responsive noPadding myclass col-sm-12 col-lg-12 col-md-12 col-xs-12");
			imgElement.setAttribute("id", "imgDrag" + ctr);
			dragDiv.appendChild(imgElement);
			ctr++;
		}
	}
	$('.myclass').draggable(
		{ revert: 'invalid', containment: "#gamapage" });
	$('.dropBox').droppable({
		drop: Classification.checkElements
	});
	$('#outerDiv').droppable({
		drop: Classification.checkElements
	});
}
//set Images at random position //
Classification.setImagesAtRandomPos = function () {
	var rnoArr = [];
	for (i = 0; i < dragCnt; i++) {
		// rno = Math.floor(Math.random() * dragCnt);
		// while (rnoArr.includes(rno))
		// 	rno = Math.floor(Math.random() * dragCnt);
		// rnoArr.push(rno);
		document.getElementById('imgDrag' + (i)).src = "images/" + imageArray[i].imgPath;
		document.getElementById('imgDrag' + (i)).setAttribute("data", imageArray[i].data);
	}

}

Classification.hilightDiv = function () {
	var randomVar = 0
	randomVar = (Math.floor(Math.random() * 6) + 1);
	while ($.inArray(randomVar, Classification.randomDivs) != -1) {
		randomVar = (Math.floor(Math.random() * 6) + 1);
	}
	Classification.randomDivs.push(randomVar);
	$('#imgdrag' + randomVar).addClass('blink');
	$('#imgdrag' + randomVar).draggable(
		{ revert: 'invalid' });
}
//checkAnswer
Classification.checkElements = function (event, ui) {
	Classification.attemptFlag = true;
	var dragData, dropData, dropid, dragId;
	dragId = $(ui.draggable).prop("id");
	parentDiv = $(ui.draggable).parent();
	dropid = $(this).prop("id");
	dropData = document.getElementById(dropid).getAttribute("jarData");
	dragData = document.getElementById(dragId).getAttribute("data");
	prevDiv = document.getElementById(dragId).getAttribute("prev");
	if ($("#" + prevDiv).hasClass("dropBox")) {
		if (document.getElementById(prevDiv).getAttribute("jarData") == dragData)
			Classification.cnt--;
	}
	if (dragData != dropData) {
		Classification.solvedFlag = false;
		//ui.draggable.draggable({ revert: true });
		//document.getElementById("playSound").src = Utils.Path + "sounds/instructions/wrong.mp3";
	}
	else {
		Classification.cnt++;
	}
	ui.draggable.draggable({ revert: false });

	document.getElementById(dragId).setAttribute("prev", dropid);
	//$('#' + dragId).draggable({ disabled: true });
}

Classification.makeChoice = function () {
	if (!Classification.exFlag) {
		Classification.exFlag = true;
		//resetGame();
		$("#container1").empty();
		$("#container2").empty();
		Classification.createDraggableDivs();
		Classification.setImagesAtRandomPos();

		questionText = Classification.shapeImgData[langCtr].data[Classification.levelCtr].question2;
		document.getElementById("heading").innerHTML = questionText;
		queNo = Classification.shapeImgData[langCtr].data[Classification.levelCtr].queNo;
		document.getElementById("queNo").innerHTML = queNo;
		document.getElementById("queNo").style.fontSize = "2.2vw";


	}
	else {
		Classification.checkAnswer();
	}
}

Classification.checkAnswer = function () {
	//$(".dragDivs").css("pointer-events", "none");
	//document.getElementById("playSound").play();
	if (Classification.attemptFlag) {

		if (Classification.cnt == correctCnt) {
			scoredmarks = "2";
		}
		else {
			scoredmarks = "1";
		}
	}
	else {
		scoredmarks = "0";
	}
	console.log(scoredmarks, starttime, label);
	// alert("ScoredMarks = " + scoredmarks + "," + " " + "Label = " + label);

	if (Utils.mobileDeviceFlag)
		Android.gotoNextGame(scoredmarks, starttime, label);

}

resetGame = function () {
	$("#outerDiv").empty();
	Classification.createDraggableDivs();
	Classification.setImagesAtRandomPos();
	Classification.attemptFlag = false;
	Classification.cnt = 0;
	Classification.solvedFlag = true;
	if (!Classification.exFlag) {
		questionText = Classification.shapeImgData[langCtr].data[Classification.levelCtr].question;
	}
	else
		questionText = Classification.shapeImgData[langCtr].data[Classification.levelCtr].question2;
	document.getElementById("heading").innerHTML = questionText;
}

hideQuestion = function () {
	$("#myModal").hide();
	$("#questioMark").show();
}
showQues = function () {
	$("#myModal").show();
	$("#questioMark").hide();
}
