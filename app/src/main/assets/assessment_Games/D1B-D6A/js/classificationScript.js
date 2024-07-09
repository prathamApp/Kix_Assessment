var Classification = {};
var Utils = {};
Utils.Path = '';
Utils.mobileDeviceFlag = false;
var questionId = 0, starttime = 0, scoredmarks = 0, totalMarks = "2", resId = 0, level = 1, label = "null";
Classification.randomObjectIndex = 0;
Classification.objArray = [];
Classification.ColorArray = [];
Classification.Count = 1;
Classification.cnt = 0;
Classification.randomDivs = [];
Classification.xArr1 = [];
Classification.levelCtr = 5;
Classification.questionCtr = 0;
Classification.exFlag = false;
var imageArray = [], queNo = '', jarCnt = 0, correctCnt = 0, dragCnt = 0, objCnt = 0, firstItr = 0, secondItr = 0, langCtr = 6;



$(document).ready(function () {
	$(".se-pre-con").fadeOut("slow");
	if ((navigator.userAgent.match(/Android|BlackBerry|iPhone|iPad|iPod|Opera Mini|IEMobile/i)) && !(window.location.href.includes('http')))
		Utils.mobileDeviceFlag = true;
	setTimeout(function () {
		// setFontFamilyForLang(Classification.hardcodedData.languageFont);
		Classification.init();
	}, 100);
});
Classification.init = function () {
	document.title = Classification.hardcodedData.gameTitle;
	document.body.style.backgroundColor = "white";
	document.getElementById('gamepage').style.display = "block";
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
		Classification.levelCtr = Math.floor(Math.random() * Classification.shapeImgData[langCtr].data.length);
	Classification.playGame();
	if (Classification.shapeImgData[langCtr].languageFont != null)
		setFontFamilyForLang(Classification.shapeImgData[langCtr].languageFont);

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
	if (Classification.levelCtr == 1) {
		$("#gamepage").css("display", "inline-grid");
		$("#outerDiv").css("margin-top", "-30vh");
		$(".Box").css("width", "25vw");
		$("#dropDiv").css("margin-top", 0);
		$("#heading").css("font-weight", 100);
	}
	jarCnt = Classification.shapeImgData[langCtr].data[Classification.levelCtr].jarCnt;
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
	document.getElementById("heading").style.fontSize = font;
	// document.getElementById("heading").style.fontWeight = 100;
	$('#heading').parent().css('font-weight', 'unset');

	if (langCtr == 4)
		document.getElementById("heading").style.direction = "rtl";
	if (Classification.levelCtr == 5 || Classification.levelCtr == 6) {
		document.getElementById("queNo").innerHTML = "D4Eg";
		//document.getElementById("queNo").style.fontSize = "1.5vw";
	}

	else
		if (Classification.levelCtr == 0 || Classification.levelCtr == 2) {
			document.getElementById("queNo").innerHTML = queNo + "Eg";
		}
		else {
			document.getElementById("queNo").innerHTML = queNo;
		}
}

Classification.setAllImages = function () {
	switch (Classification.levelCtr) {

		case 0: {//D1B
			correctCnt = 2;
			dragCnt = 6;
			objCnt = 3;
			firstItr = 6;
			secondItr = 6;
			$(".Box").css("width", "24vw");
			// $(".Box").css("margin-left", "-5vh");
			$(".Box").css("height", "40vh");
			$("#Box2").css("display", "none");
			$("#Box1").css("margin-left", "-5vh");
			$(".dropBox").css("height", "40vh");
			$(".dropBox").css("margin-top", 0);
			$("#dropDiv").css("margin-top", "-5vh");
			$("#outerDiv").css("margin-top", "2vh");
			// $("#outerDiv").css("margin-left", "5vw");
			document.getElementById('Box1').style.backgroundImage = "url('images/D1B_1.png')";

			//document.getElementById('Box1').style.marginLeft = "30vw";
			$("#outerDiv").removeClass("heightCls col-sm-10 col-lg-10 col-md-10 col-xs-10 col-sm-offset-1 col-lg-offset-1 col-md-offset-1 col-xs-offset-1")
			$("#outerDiv").addClass("heightCls col-sm-12 col-lg-12 col-md-12 col-xs-12")
			$("#dropBox1").removeClass("dropBox noPadding col-sm-6 col-lg-6 col-md-6 col-xs-6 col-sm-offset-3 col-lg-offset-3 col-md-offset-3 col-xs-offset-3")
			$("#dropBox1").addClass("dropBox noPadding col-sm-8 col-lg-8 col-md-8 col-xs-8 col-sm-offset-2 col-lg-offset-2 col-md-offset-2 col-xs-offset-2")
			$("#dropDiv").removeClass("Box noPadding col-sm-1 col-lg-1 col-md-1 col-xs-1")
			$("#dropDiv").addClass("Box noPadding col-sm-1 col-lg-1 col-md-1 col-xs-1 col-sm-offset-5 col-lg-offset-5 col-md-offset-5 col-xs-offset-5")

		}
			break;
		case 1: {//D1D
			$(".Box").css("margin-left", "6vh");
			correctCnt = 3;
			dragCnt = 6;
			objCnt = 3;
			firstItr = 6;
			secondItr = 6;
			$("#dropBox1").removeClass("dropBox noPadding col-sm-6 col-lg-6 col-md-6 col-xs-6 col-sm-offset-3 col-lg-offset-3 col-md-offset-3 col-xs-offset-3")
			$("#dropBox1").addClass("dropBox noPadding col-sm-12 col-lg-12 col-md-12 col-xs-12")
			//document.getElementById('Box1').style.backgroundImage = "url('images/D1A_1.png')";
			document.getElementById('dropBox1').style.backgroundColor = "yellow";
			document.getElementById('dropBox1').style.height = "30vh";
			//document.getElementById('Box1').style.marginLeft = "30vw";

		}
			break;
		case 2: {//D2B
			correctCnt = 3;
			dragCnt = 9;
			objCnt = 3;
			firstItr = 5;
			secondItr = 4;
			$(".Box").css("width", "18vw");
			$(".Box").css("height", "40vh");
			$(".dropBox").css("height", "37vh");
			$(".dropBox").css("margin-top", 0);
			$("#dropDiv").css("margin-top", "15vh");
			$(".Box").css("margin-left", "6vh");
			$("#outerDiv").removeClass("heightCls col-sm-10 col-lg-10 col-md-10 col-xs-10 col-sm-offset-1 col-lg-offset-1 col-md-offset-1 col-xs-offset-1")
			$("#outerDiv").addClass("heightCls col-sm-8 col-lg-8 col-md-8 col-xs-8 col-sm-offset-1 col-lg-offset-1 col-md-offset-1 col-xs-offset-1")
			$("#dropBox1").removeClass("dropBox noPadding col-sm-6 col-lg-6 col-md-6 col-xs-6 col-sm-offset-3 col-lg-offset-3 col-md-offset-3 col-xs-offset-3")
			$("#dropBox1").addClass("dropBox noPadding col-sm-12 col-lg-12 col-md-12 col-xs-12")
			// document.getElementById('Box1').style.backgroundImage = "url('images/D6A_1.png')";
			document.getElementById('Box1').style.backgroundColor = "lightgrey";
			//document.getElementById('Box2').style.backgroundImage = "url('images/D2A_3.png')";
			//document.getElementById('Box3').style.backgroundImage = "url('images/D2A_2.png')";
			//document.getElementById('Box1').style.marginLeft = "20vw";
			//document.getElementById('outerDiv').setAttribute("class", "heightCls col-sm-8 col-lg-8 col-md-8 col-xs-8 col-sm-offset-3 col-lg-offset-3 col-md-offset-3 col-xs-offset-3")
		}
			break;
		case 3: {//D3A
			correctCnt = 6;
			dragCnt = 6;
			objCnt = 6;
			firstItr = 3;
			secondItr = 3;
			document.getElementById('dropTitle1').innerHTML = Classification.shapeImgData[langCtr].data[Classification.levelCtr].birdText;
			document.getElementById('dropTitle2').innerHTML = Classification.shapeImgData[langCtr].data[Classification.levelCtr].animalText;
			//$(".dropBox").css("border", "3px solid black");
			// $(".Box").css("margin-left", "15vh");
			$(".Box").css("width", " ");
			$("#outerDiv").css("margin-top", "1vh");
			$("#dropDiv").css("margin-top", 0);
			$("#dropDiv").removeClass("Box noPadding col-sm-1 col-lg-1 col-md-1 col-xs-1")
			$("#dropDiv").addClass("Box noPadding col-sm-12 col-lg-12 col-md-12 col-xs-12")
			$("#Box1").removeClass("Box noPadding col-sm-12 col-lg-12 col-md-12 col-xs-12")
			$("#Box2").removeClass("Box noPadding col-sm-12 col-lg-12 col-md-12 col-xs-12")
			$("#outerDiv").addClass("Box noPadding col-sm-7 col-lg-7 col-md-7 col-xs-7 col-sm-offset-2 col-lg-offset-2 col-md-offset-2 col-xs-offset-2")
			$("#Box1").addClass("Box noPadding col-sm-3 col-lg-3 col-md-3 col-xs-3 col-sm-offset-1 col-lg-offset-1 col-md-offset-1 col-xs-offset-1")
			$("#Box2").addClass("Box noPadding col-sm-3 col-lg-3 col-md-3 col-xs-3 col-sm-offset-3 col-lg-offset-3 col-md-offset-3 col-xs-offset-3")
			$("#dropBox1").removeClass("dropBox noPadding col-sm-6 col-lg-6 col-md-6 col-xs-6 col-sm-offset-3 col-lg-offset-3 col-md-offset-3 col-xs-offset-3")
			$("#dropBox1").addClass("dropBox noPadding col-sm-12 col-lg-12 col-md-12 col-xs-12")
			$("#dropBox2").removeClass("dropBox noPadding col-sm-6 col-lg-6 col-md-6 col-xs-6 col-sm-offset-3 col-lg-offset-3 col-md-offset-3 col-xs-offset-3")
			$("#dropBox2").addClass("dropBox noPadding col-sm-12 col-lg-12 col-md-12 col-xs-12")
			$(".dropBox").css("margin-top", "0vh");
			$("#container1").css("margin-top", "0vh");
			$("#container2").css("margin-top", "0vh");
			$("#container1").css("margin-left", "7vh");
			$("#container2").css("margin-left", "7vh");
			$("#outerDiv").removeClass("heightCls col-sm-10 col-lg-10 col-md-10 col-xs-10 col-sm-offset-1 col-lg-offset-1 col-md-offset-1 col-xs-offset-1")
			$("#outerDiv").addClass("heightCls col-sm-8 col-lg-8 col-md-8 col-xs-8 col-sm-offset-2 col-lg-offset-2 col-md-offset-2 col-xs-offset-2")
			//document.getElementById('Box1').style.marginLeft = "35vw";
			//document.getElementById('outerDiv').setAttribute("class", "heightCls col-sm-8 col-lg-8 col-md-8 col-xs-8 col-sm-offset-3 col-lg-offset-3 col-md-offset-3 col-xs-offset-3")
			document.getElementById('dropBox1').style.backgroundColor = "lightgrey";
			document.getElementById('dropBox2').style.backgroundColor = "lightgrey";
		}
			break;
		case 4: {//D3B
			correctCnt = 6;
			dragCnt = 6;
			objCnt = 6;
			firstItr = 3;
			secondItr = 3;
			document.getElementById('dropTitle1').innerHTML = Classification.shapeImgData[langCtr].data[Classification.levelCtr].fruitText;
			document.getElementById('dropTitle2').innerHTML = Classification.shapeImgData[langCtr].data[Classification.levelCtr].vegText;
			//$(".dropBox").css("border", "3px solid black");
			// $(".Box").css("margin-left", "15vh");
			$(".Box").css("width", " ");
			$("#outerDiv").css("margin-top", "0.5vh");
			$("#dropDiv").css("margin-top", 0);
			$("#dropDiv").removeClass("Box noPadding col-sm-1 col-lg-1 col-md-1 col-xs-1")
			$("#dropDiv").addClass("Box noPadding col-sm-12 col-lg-12 col-md-12 col-xs-12")
			$("#Box1").removeClass("Box noPadding col-sm-12 col-lg-12 col-md-12 col-xs-12")
			$("#Box2").removeClass("Box noPadding col-sm-12 col-lg-12 col-md-12 col-xs-12")
			$("#Box1").addClass("Box noPadding col-sm-2 col-lg-2 col-md-2 col-xs-2 col-sm-offset-1 col-lg-offset-1 col-md-offset-1 col-xs-offset-1")
			$("#Box2").addClass("Box noPadding col-sm-2 col-lg-2 col-md-2 col-xs-2 col-sm-offset-5 col-lg-offset-5 col-md-offset-5 col-xs-offset-5")
			$("#dropBox1").removeClass("dropBox noPadding col-sm-6 col-lg-6 col-md-6 col-xs-6 col-sm-offset-3 col-lg-offset-3 col-md-offset-3 col-xs-offset-3")
			$("#dropBox1").addClass("dropBox noPadding col-sm-12 col-lg-12 col-md-12 col-xs-12")
			$("#dropBox2").removeClass("dropBox noPadding col-sm-6 col-lg-6 col-md-6 col-xs-6 col-sm-offset-3 col-lg-offset-3 col-md-offset-3 col-xs-offset-3")
			$("#dropBox2").addClass("dropBox noPadding col-sm-12 col-lg-12 col-md-12 col-xs-12")
			$(".dropBox").css("margin-top", "0vh");
			$("#container1").css("margin-top", "0vh");
			$("#container2").css("margin-top", "0vh");
			$("#container1").css("margin-left", "7vh");
			$("#container2").css("margin-left", "7vh");
			$("#outerDiv").removeClass("heightCls col-sm-10 col-lg-10 col-md-10 col-xs-10 col-sm-offset-1 col-lg-offset-1 col-md-offset-1 col-xs-offset-1")
			$("#outerDiv").addClass("heightCls col-sm-8 col-lg-8 col-md-8 col-xs-8 col-sm-offset-2 col-lg-offset-2 col-md-offset-2 col-xs-offset-2")
			//document.getElementById('Box1').style.marginLeft = "35vw";
			//document.getElementById('outerDiv').setAttribute("class", "heightCls col-sm-8 col-lg-8 col-md-8 col-xs-8 col-sm-offset-3 col-lg-offset-3 col-md-offset-3 col-xs-offset-3")
			document.getElementById('dropBox1').style.backgroundColor = "lightgrey";
			document.getElementById('dropBox2').style.backgroundColor = "lightgrey";
		}
			break;
		// case 5: {//D3C
		// 	correctCnt = 6;
		// 	dragCnt = 6;
		// 	objCnt = 6;
		// 	firstItr = 3;
		// 	secondItr = 3;
		// 	document.getElementById('dropTitle1').innerHTML = "Can wear";
		// 	document.getElementById('dropTitle2').innerHTML = "Cannot wear";
		// 	$(".dropBox").css("border", "1px solid black");
		// 	$(".dropBox").css("margin-top", 0);
		// 	$(".Box").css("margin-left", "15vh");
		// 	$(".Box").css("width", "15vw");
		// 	$("#outerDiv").css("margin-top", "10vh");
		// 	$("#dropDiv").css("margin-top", 0);
		// 	$("#dropBox1").removeClass("dropBox noPadding col-sm-6 col-lg-6 col-md-6 col-xs-6 col-sm-offset-3 col-lg-offset-3 col-md-offset-3 col-xs-offset-3")
		// 	$("#dropBox2").removeClass("dropBox noPadding col-sm-6 col-lg-6 col-md-6 col-xs-6 col-sm-offset-3 col-lg-offset-3 col-md-offset-3 col-xs-offset-3")
		// 	$("#dropBox1").addClass("dropBox noPadding col-sm-12 col-lg-12 col-md-12 col-xs-12")
		// 	$("#dropBox2").addClass("dropBox noPadding col-sm-12 col-lg-12 col-md-12 col-xs-12")

		// 	//document.getElementById('Box1').style.marginLeft = "35vw";
		// 	//document.getElementById('outerDiv').setAttribute("class", "heightCls col-sm-8 col-lg-8 col-md-8 col-xs-8 col-sm-offset-3 col-lg-offset-3 col-md-offset-3 col-xs-offset-3")
		// }
		// 	break;
		case 5: {//D4A
			correctCnt = 2;
			dragCnt = 8;
			objCnt = 8;
			firstItr = 4;
			secondItr = 4;
			$(".Box").css("width", "24vw");
			$("#Box1").css("margin-left", "-5vh");
			$(".Box").css("height", "40vh");
			$("#Box2").css("display", "none");
			$(".dropBox").css("height", "37vh");
			$(".dropBox").css("margin-top", 0);
			$("#dropDiv").css("margin-top", "-5vh");
			$("#outerDiv").css("margin-top", "2vh");
			// document.getElementById('Box1').style.backgroundColor = "lightgrey";
			document.getElementById('Box1').style.backgroundImage = "url('images/D1B_1.png')";
			//document.getElementById('Box1').style.marginLeft = "35vw";
			//document.getElementById('outerDiv').setAttribute("class", "heightCls col-sm-8 col-lg-8 col-md-8 col-xs-8 col-sm-offset-3 col-lg-offset-3 col-md-offset-3 col-xs-offset-3")
			$("#dropBox1").removeClass("dropBox noPadding col-sm-6 col-lg-6 col-md-6 col-xs-6 col-sm-offset-3 col-lg-offset-3 col-md-offset-3 col-xs-offset-3")
			$("#dropBox1").addClass("dropBox noPadding col-sm-8 col-lg-8 col-md-8 col-xs-8 col-sm-offset-2 col-lg-offset-2 col-md-offset-2 col-xs-offset-2")
			// $("#outerDiv").removeClass("heightCls col-sm-10 col-lg-10 col-md-10 col-xs-10 col-sm-offset-1 col-lg-offset-1 col-md-offset-1 col-xs-offset-1")
			// $("#outerDiv").addClass("noPadding heightCls col-sm-10 col-lg-10 col-md-10 col-xs-10 col-sm-offset-2 col-lg-offset-2 col-md-offset-2 col-xs-offset-2")
			$("#container1").removeClass("noPadding col-sm-11 col-lg-11 col-md-11 col-xs-11 col-sm-offset-1 col-lg-offset-1 col-md-offset-1 col-xs-offset-1")
			$("#container1").addClass("noPadding col-sm-11 col-lg-11 col-md-11 col-xs-11 col-sm-offset-1 col-lg-offset-1 col-md-offset-1 col-xs-offset-1")
			$("#container2").removeClass("noPadding col-sm-11 col-lg-11 col-md-11 col-xs-11 col-sm-offset-1 col-lg-offset-1 col-md-offset-1 col-xs-offset-1")
			$("#container2").addClass("noPadding col-sm-11 col-lg-11 col-md-11 col-xs-11 col-sm-offset-1 col-lg-offset-1 col-md-offset-1 col-xs-offset-1")
			$("#dropDiv").removeClass("Box noPadding col-sm-1 col-lg-1 col-md-1 col-xs-1")
			$("#dropDiv").addClass("Box noPadding col-sm-1 col-lg-1 col-md-1 col-xs-1 col-sm-offset-5 col-lg-offset-5 col-md-offset-5 col-xs-offset-5")

		}
			break;

		case 6: {//D4B
			correctCnt = 3;
			dragCnt = 8;
			objCnt = 8;
			firstItr = 6;
			secondItr = 6;
			$(".Box").css("width", "18vw");
			$(".Box").css("height", "40vh");
			$("#Box2").css("display", "none");
			$(".dropBox").css("height", "37vh");
			$(".dropBox").css("margin-top", 0);
			$("#dropDiv").css("margin-top", "15vh");
			$("#dropBox1").css("margin-top", 0);
			$(".Box").css("margin-left", "6vh");
			// document.getElementById('Box1').style.backgroundImage = "url('images/D2B_1.png')";
			document.getElementById('Box1').style.backgroundColor = "lightgrey";

			//document.getElementById('Box1').style.marginLeft = "35vw";
			//document.getElementById('outerDiv').setAttribute("class", "heightCls col-sm-8 col-lg-8 col-md-8 col-xs-8 col-sm-offset-3 col-lg-offset-3 col-md-offset-3 col-xs-offset-3")
			$("#outerDiv").removeClass("heightCls col-sm-10 col-lg-10 col-md-10 col-xs-10 col-sm-offset-1 col-lg-offset-1 col-md-offset-1 col-xs-offset-1")
			$("#outerDiv").addClass("heightCls col-sm-8 col-lg-8 col-md-8 col-xs-8 col-sm-offset-1 col-lg-offset-1 col-md-offset-1 col-xs-offset-1")
			$("#dropBox1").removeClass("dropBox noPadding col-sm-6 col-lg-6 col-md-6 col-xs-6 col-sm-offset-3 col-lg-offset-3 col-md-offset-3 col-xs-offset-3")
			$("#dropBox1").addClass("dropBox noPadding col-sm-12 col-lg-12 col-md-12 col-xs-12")
		}
			break;
		case 7: {//D6A
			correctCnt = 3;
			dragCnt = 6;
			objCnt = 6;
			firstItr = 2;
			secondItr = 2;
			thirdItr = 2
			$(".Box").css("width", "35vw");
			$("#dropDiv").css("margin-top", "0vh");
			$(".Box").css("height", "50vh");
			$(".Box").css("margin-left", "6vh");
			$("#Box2").css("display", "none");
			$("#Box1").css("height", "65vh");
			$(".dropBox").css("height", "47vh");
			$(".dropBox").css("margin-top", 0);
			document.getElementById('Box1').style.backgroundImage = "url('images/D6A_1.png')";
			// document.getElementById('Box1').style.backgroundColor = "lightgrey";

			$("#outerDiv").css("margin-top", "10vh");
			$("#outerDiv").removeClass("heightCls col-sm-10 col-lg-10 col-md-10 col-xs-10 col-sm-offset-1 col-lg-offset-1 col-md-offset-1 col-xs-offset-1")
			$("#outerDiv").addClass("col-sm-8 col-lg-8 col-md-8 col-xs-8 col-sm-offset-1 col-lg-offset-1 col-md-offset-1 col-xs-offset-1")
			//document.getElementById('Box1').style.marginLeft = "35vw";
			//document.getElementById('outerDiv').setAttribute("class", "heightCls col-sm-8 col-lg-8 col-md-8 col-xs-8 col-sm-offset-3 col-lg-offset-3 col-md-offset-3 col-xs-offset-3")
			$("#dropBox1").removeClass("dropBox noPadding col-sm-6 col-lg-6 col-md-6 col-xs-6 col-sm-offset-3 col-lg-offset-3 col-md-offset-3 col-xs-offset-3")
			$("#dropBox1").addClass("dropBox noPadding col-sm-12 col-lg-12 col-md-12 col-xs-12")
			$("#dropDiv").removeClass("Box noPadding col-sm-1 col-lg-1 col-md-1 col-xs-1")
			$("#dropDiv").addClass("Box noPadding col-sm-3 col-lg-3 col-md-3 col-xs-3")
			$("#outerDiv").removeClass("noPadding col-sm-8 col-lg-8 col-md-8 col-xs-8 col-sm-offset-1 col-lg-offset-1 col-md-offset-1 col-xs-offset-1")
			$("#outerDiv").addClass("noPadding col-sm-6 col-lg-6 col-md-6 col-xs-6 col-sm-offset- 1 col-lg-offset-1 col-md-offset-1 col-xs-offset-1")

		}
			break;
	}
}

//get shape or color randomly//
Classification.getRandomShapesAndColors = function () {
	var randomIndex = 0, uniqueObjArray = [], uniqueColorArray = [];
	randomIndex = Classification.levelCtr;
	for (i = 0; i < objCnt; i++) {
		Classification.objArray.push(randomIndex);
	}
	console.log(this.objArray);
	Classification.getImages();
}
// get random images//
Classification.getImages = function () {
	ctr = 0;

	for (var i = 0; i < Classification.objArray.length; i++) {
		objectIndex = Classification.objArray[i];
		colorIndex = i;
		if (Classification.levelCtr < 3) {
			imageArray.push({ data: Classification.shapeImgData[langCtr].data[objectIndex].colorObjects[colorIndex].imageName[0], imgPath: Classification.shapeImgData[langCtr].data[objectIndex].colorObjects[colorIndex].imgPath });
			imageArray.push({ data: Classification.shapeImgData[langCtr].data[objectIndex].colorObjects[colorIndex].imageName[0], imgPath: Classification.shapeImgData[langCtr].data[objectIndex].colorObjects[colorIndex].imgPath });
		}
		else
			imageArray.push({ data: Classification.shapeImgData[langCtr].data[objectIndex].colorObjects[colorIndex].imageName[0], imgPath: Classification.shapeImgData[langCtr].data[objectIndex].colorObjects[colorIndex].imgPath });
	}
	console.log(imageArray);
	Classification.setImagesToDivs();
	Classification.setImagesAtRandomPos();

}
// set images to divs//
Classification.setImagesToDivs = function () {
	{
		for (var i = 0; i < jarCnt; i++) {
			if (Classification.levelCtr < 3)
				document.getElementById('dropBox' + (i + 1)).setAttribute("jarData", imageArray[i * 2].data);
			else
				document.getElementById('dropBox' + (i + 1)).setAttribute("jarData", Classification.shapeImgData[langCtr].data[Classification.levelCtr].object[i]);
		}
	}

	console.log(imageArray);
}

Classification.createDraggableDivs = function () {
	parentDiv = document.getElementById("container1");
	if (Classification.levelCtr == 5) {
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
				// if (i == 0)
				// 	dragDiv.setAttribute("class", "dragDivs noPadding col-sm-1 col-lg-1 col-md-1 col-xs-1")
				// else
				dragDiv.setAttribute("class", "dragDivs noPadding col-sm-1 col-lg-1 col-md-1 col-xs-1 col-sm-offset-1 col-lg-offset-1 col-md-offset-1 col-xs-offset-1")
				parentDiv.appendChild(dragDiv);

				imgElement = document.createElement('img');
				imgElement.setAttribute("class", "img-responsive noPadding myclass col-sm-12 col-lg-12 col-md-12 col-xs-12");
				imgElement.setAttribute("id", "imgDrag" + ctr);
				dragDiv.appendChild(imgElement);
				ctr++;
			}
		}
		$(".dragDivs").css("height", "15vh");
		$(".dragDivs").css("width", "10vw")
	}
	else if (Classification.levelCtr == 7) {
		ctr = 0;
		for (j = 1; j <= 3; j++) {
			parentDiv = document.getElementById("container" + j);
			iterator = 2;
			for (var i = 0; i < iterator; i++) {
				dragDiv = document.createElement("DIV");
				dragDiv.setAttribute("id", "dragDiv" + ctr);
				dragDiv.setAttribute("class", "dragDivs noPadding col-sm-2 col-lg-2 col-md-2 col-xs-2 col-sm-offset-2 col-lg-offset-2 col-md-offset-2 col-xs-offset-2")
				parentDiv.appendChild(dragDiv);

				imgElement = document.createElement('img');
				imgElement.setAttribute("class", "img-responsive noPadding myclass col-sm-12 col-lg-12 col-md-12 col-xs-12");
				imgElement.setAttribute("id", "imgDrag" + ctr);
				dragDiv.appendChild(imgElement);
				ctr++;
			}
		}
	}
	else {
		for (var i = 0; i < 6; i++) {
			dragDiv = document.createElement("DIV");
			dragDiv.setAttribute("id", "dragDiv" + i);
			if ((Classification.levelCtr >= 3 && Classification.levelCtr <= 4) || Classification.levelCtr == 7) {
				dragDiv.setAttribute("class", "dragDivs noPadding col-sm-2 col-lg-2 col-md-2 col-xs-2 col-sm-offset-2 col-lg-offset-2 col-md-offset-2 col-xs-offset-2")

			}
			else {
				if (i == 0)
					dragDiv.setAttribute("class", "dragDivs noPadding col-sm-1 col-lg-1 col-md-1 col-xs-1")
				else
					dragDiv.setAttribute("class", "dragDivs noPadding col-sm-1 col-lg-1 col-md-1 col-xs-1 col-sm-offset-1 col-lg-offset-1 col-md-offset-1 col-xs-offset-1")

			}
			parentDiv.appendChild(dragDiv);

			imgElement = document.createElement('img');
			imgElement.setAttribute("class", "img-responsive noPadding myclass col-sm-12 col-lg-12 col-md-12 col-xs-12");
			imgElement.setAttribute("id", "imgDrag" + i);
			dragDiv.appendChild(imgElement);
		}
	}

	if (Classification.levelCtr == 2)
		document.getElementById('dragDiv5').style.marginLeft = "5vw";
	$('.myclass').draggable(
		{ revert: 'invalid', containment: "#gamepage" });
	$('.dropBox').droppable({
		drop: Classification.checkElements
	});
	$('#outerDiv').droppable({
		drop: Classification.checkElements
	});
	if (Classification.levelCtr == 0) {
		$(".dragDivs").css("height", "17vh");
		$(".dragDivs").css("width", "10vw");
		$(".dragDivs").css("margin-left", "5vw");
	}
}
//set Images at random position //
Classification.setImagesAtRandomPos = function () {
	var rnoArr = [];
	for (i = 0; i < dragCnt; i++) {
		rno = Math.floor(Math.random() * dragCnt);
		while (rnoArr.includes(rno))
			rno = Math.floor(Math.random() * dragCnt);
		rnoArr.push(rno);
		document.getElementById('imgDrag' + (rno)).src = "images/" + imageArray[i].imgPath;
		document.getElementById('imgDrag' + (rno)).setAttribute("data", imageArray[i].data);
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
// Classification.checkElements = function (event, ui) {
// 	Classification.attemptFlag = true;
// 	var dragData, dropData, dropid, dragId;
// 	dragId = $(ui.draggable).prop("id");
// 	dragData = document.getElementById(dragId).getAttribute("data");
// 	dropid = $(this).prop("id");
// 	dropData = document.getElementById(dropid).getAttribute("jarData");
// 	if (dragData != dropData) {
// 		//	Classification.solvedFlag = false;
// 		//ui.draggable.draggable({ revert: true });
// 		//document.getElementById("playSound").src = Utils.Path + "sounds/instructions/wrong.mp3";
// 	}
// 	else {
// 		Classification.cnt++;
// 		ui.draggable.draggable({ revert: false });
// 		$('#' + dragId).draggable({ disabled: true });
// 	}

// }

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
	if (Classification.levelCtr == 0 || Classification.levelCtr == 2 || Classification.levelCtr == 5 || Classification.levelCtr == 6) {
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
	else {
		Classification.checkAnswer();
	}
}

Classification.checkAnswer = function () {
	//$(".dragDivs").css("pointer-events", "none");
	//$("#resetDiv").css("pointer-events", "none");
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
	$("#container1").empty();
	$("#container2").empty();
	$("#container3").empty();
	Classification.createDraggableDivs();
	Classification.setImagesAtRandomPos();
	Classification.attemptFlag = false;
	Classification.cnt = 0;
	Classification.solvedFlag = true;
	if (Classification.levelCtr == 0 || Classification.levelCtr == 2 || Classification.levelCtr == 5 || Classification.levelCtr == 6) {
		if (!Classification.exFlag) {
			questionText = Classification.shapeImgData[langCtr].data[Classification.levelCtr].question;
		}
		else
			questionText = Classification.shapeImgData[langCtr].data[Classification.levelCtr].question2;
		document.getElementById("heading").innerHTML = questionText;
	} 

}

hideQuestion = function () {
	$("#myModal").hide();
	$("#questioMark").show();
}
showQues = function () {
	$("#myModal").show();
	$("#questioMark").hide();
}
