/*-- Document Ready Starts --*/
var currentQues = 0 , gameFlag = true;
Utils= {};
var startTime = "0", scoredMarks = "0", label = "null",scoreFlag = false , code =0 ,ansFlag = false,currentLang = 4;
var imageArray=["","G22A_2.png","G22A_5.png","G22A_4.png","G22A_3.png"];
Utils.mobileDeviceFlag = false,type = 0 ;
$(document).ready(function () {
	$(".codeCls").css("font-size","2.9vw");
	if ((navigator.userAgent.match(/Android|BlackBerry|iPhone|iPad|iPod|Opera Mini|IEMobile/i))&& !(window.location.href.includes('http')))
	     Utils.mobileDeviceFlag = true;

	if(Utils.mobileDeviceFlag)
    {
		  var langName = Android.getGameLang();
           currentLang = gamedataArr.findIndex(obj => obj.lang == langName);
        var gameCode =Android.getGameID();
      currentQues = gamedataArr[currentLang].gameData.findIndex(obj => obj.Name == gameCode);
	     if(langName == "Urdu-Pakistan")
	           $("#heading").css({"text-align":"right" , "direction":"rtl"});
    }
    else{
		if(currentLang == 3)
		    $("#heading").css({"text-align":"right" , "direction":"rtl"});
		//currentLang  = Math.floor(Math.random()*gamedataArr.length);
        currentQues = 0 ;
	}
      	if(gamedataArr[currentLang].languageFont!=null)
	         setFontFamilyForLang(gamedataArr[currentLang].languageFont);

	
		document.getElementById("heading").innerHTML = gamedataArr[currentLang].gameData[currentQues].instrText;
		document.getElementById("queNo").innerHTML = gamedataArr[currentLang].gameData[currentQues].Name;
		$("#heading").css("font-size","1.6vw");
		$("#queNo").css("font-size","2.2vw");
		
	    $("#type_" + currentQues).show();
 

	$(window).resize(resizeHandler);
	resizeHandler();
	document.ontouchmove = function (e) { };
	
	showQues();
    RegisterEvents();

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
/*-- Document Ready Ends --*/
// Get all audio tag elements
var currentDragId = null;
var prevdragId = null;
var dragctr = 0;
/*-- Common Framework Functions Starts --*/

function RegisterEvents() {
    d = new Date();  //date object
	startTime = d.getDate() + "-" + (d.getMonth() + 1) + "-" + d.getFullYear() + " " + d.getHours() + ":" + d.getMinutes() + ":" + d.getSeconds();  //to get the current date

	for (var i = 0; i < gamedata["types"].length; i++) {
		$("<div/>", {
			'id': 'type_' + gamedata["types"][i],
			'class': 'answer-container'
		}).appendTo('#interactive_1');

		//if (i == 0) {
			$("<div/>", {
				'id': 'triangle_drop',
			}).appendTo('#type_' + gamedata["types"][i]);
			$("<div/>", {
				'id': 'drop-1',
				'class': 'drop_numbers',
				'num':'1',
			}).appendTo('#type_' + gamedata["types"][i]);
		//}
		if (i == 1) {
			$("<div/>", {
				'id': 'boat_drop',
			}).appendTo('#type_' + gamedata["types"][i]);
			$("<div/>", {
				'id': 'drop_t2-1',
				'class': 'drop_numbers_t2',
				'num':'1',
			}).appendTo('#type_' + gamedata["types"][i]);
		}
		if (i == 2) {
			$("<div/>", {
				'id': 'human_drop',
			}).appendTo('#type_' + gamedata["types"][i]);
			$("<div/>", {
				'id': 'drop_t3-1',
				'class': 'drop_numbers_t3',
				'num':'1',
			}).appendTo('#type_' + gamedata["types"][i]);
		}

		if (i == 3) {
			$("<div/>", {
				'id': 'animal_drop',
			}).appendTo('#type_' + gamedata["types"][i]);
			$("<div/>", {
				'id': 'drop_t4-1',
				'class': 'drop_numbers_t4',
				'num':'1',
			}).appendTo('#type_' + gamedata["types"][i]);
		}


	}

	for(var j=1; j<=4; j++){
		$("<div/>", {
			'id': 'drag-'+j,
			'class': 'drag_numbers dragItem',
			'num':''+j,
		}).appendTo('#type_' + gamedata["types"][0]);

		$("<div/>", {
			'id': 'drag_t2-'+j,
			'class': 'drag_numbers_t2 dragItem',
			'num':''+j,
		}).appendTo('#type_' + gamedata["types"][1]);

		$("<div/>", {
			'id': 'drag_t3-'+j,
			'class': 'drag_numbers_t3 dragItem',
			'num':''+j,
		}).appendTo('#type_' + gamedata["types"][2]);

		$("<div/>", {
			'id': 'drag_t4-'+j,
			'class': 'drag_numbers_t4 dragItem',
			'num':''+j,
		}).appendTo('#type_' + gamedata["types"][3]);
	}


	// var displaytype = random(1, 4);
	// $("#type_" + displaytype).show();

	$("#type_1").show();

	$("div").mousedown(function (e) { });
	$("html").mousedown(function (e) { });

	$(".drag_numbers").each(function (i) {
		$(this).attr('original-top', $(this).css('top'));
		$(this).attr('original-left', $(this).css('left'));
	});

	$(".drag_numbers_t2").each(function (i) {
		$(this).attr('original-top', $(this).css('top'));
		$(this).attr('original-left', $(this).css('left'));
	});

	$(".drag_numbers_t3").each(function (i) {
		$(this).attr('original-top', $(this).css('top'));
		$(this).attr('original-left', $(this).css('left'));
	});

	$(".drag_numbers_t4").each(function (i) {
		$(this).attr('original-top', $(this).css('top'));
		$(this).attr('original-left', $(this).css('left'));
	});

	// drag code start type1
	for (var i = 1; i <= 4; i++) {
		$('#drag-' + i).draggable({
			scroll: false,
			zIndex: 100,
			revert: function (p_bDropped) {

				if (!p_bDropped) {
					$(this).animate({ top: parseFloat($(this).attr('original-top')), left: parseFloat($(this).attr('original-left')) }, 0, function () {
					});
				} else {

				}
			},
			create: function (event, ui) {

			},
			start: function (event, ui) {
				currentDragId = $(this).attr("id");
				for (var i = 1; i <= 4; i++) {
					$("#popup-drag-" + i).hide();
					$("#drag-" + i).removeClass("popupyelowborder");
				}
			},
			drag: function (event, ui) {
				var changeLeft = ui.position.left;
				var newLeft = changeLeft / DragDropScale; //newScale u can get jquery
				var changeTop = ui.position.top;
				var newTop = changeTop / DragDropScale; //newScale u can get jquery
				ui.position.left = newLeft;
				ui.position.top = newTop;
				$('body').mouseleave(function () {
					$('body').mouseup();
				});

			},
			stop: function (event, ui) {
			}
		});
	}
	// close drag code type1
	// drop start type1
	$('.drop_numbers').droppable({
		accept: '.drag_numbers',
		activate: function (event, ui) {
			//console.log("droppable activate");
		},
		deactivate: function (event, ui) {
			//console.log("droppable deactivate");
		},
		out: function (event, ui) {
			//console.log("droppable out");

		},
		over: function (event, ui) {
			//console.log("droppable over" + $(this).attr('id'));
		},
		drop: function (ev, ui) {
			type = 1;
			var x = $(this).attr('num') ;
			var a=$(this).attr('num');
			console.log(a);
			var y = $("#" + currentDragId).attr("num");
			console.log(y);
			if (x == y) {
				scoredMarks = "2";
				label= imageArray[y];
				dragctr++;
		       $("#" + currentDragId).hide();
               /*  if (currentDragId == "drag-1") {
					$(this).addClass('dropimg_1');
					
				} */
				$("#" + currentDragId).removeClass("drag_numbers");
				$(this).append(ui.draggable);
			    $(this).droppable("disable");
				 $("#"+currentDragId).addClass("dragged");
				$("#" + currentDragId).addClass("stopdrag");
                 $("#drag-1").css({'display':'block'})

				$("#" + currentDragId).animate({ top: parseFloat($("#" + currentDragId).attr('original-top')), left: parseFloat($("#" + currentDragId).attr('original-left')) }, 0, function () {

				});
				$("#" + currentDragId).addClass("stopdrag");

			} else {
			     scoredMarks = "1";
				label= imageArray[y];
				$("#" + currentDragId).removeClass("drag_numbers");
				$(this).append(ui.draggable);
			    $(this).droppable("disable");
				 $("#"+currentDragId).addClass("dragged");
				$("#" + currentDragId).addClass("stopdrag");
			}
			prevdragId = currentDragId;
			$(".dragItem").draggable({
				disabled:true
			});
		
		}
	});
	// close drop code type1

};
function resetdragnumbers() {
	scoredMarks = "0";
	dragctr = 0;
	$(".dragged").addClass("drag_numbers");
	$(".dragged").removeClass("dragged");
   $("#drop-1").removeClass("dropimg_1");
   var removedDragDiv = $('#drop-1 div:first').remove(); 
   $('#type_1').append(removedDragDiv);
	$(".drag_numbers").each(function (i) {
		$(this).removeClass("stopdrag")
		$("#drag-" + (i + 1)).show();

		$("#drag-" + (i + 1)).animate({ top: parseFloat($("#drag-" + (i + 1)).attr('original-top')), left: parseFloat($("#drag-" + (i + 1)).attr('original-left')) }, 0, function () {
		});
		
	});
	$("#drop-1").droppable("enable");
/* //}
//type2
//else if(type == 2){
	$(".dragged1").addClass("drag_numbers_t2");
	$(".dragged1").removeClass("dragged1");
   var removedDragDiv = $('#drop_t2-1 div:first').remove(); 
   $('#type_2').append(removedDragDiv);
	$("#drop_t2-1").removeClass("dropimg_t2_1");
	$(".drag_numbers_t2").each(function (i) {
		$(this).removeClass("stopdrag");
		$("#drag_t2-" + (i + 1)).show();

		$("#drag_t2-" + (i + 1)).animate({ top: parseFloat($("#drag_t2-" + (i + 1)).attr('original-top')), left: parseFloat($("#drag_t2-" + (i + 1)).attr('original-left')) }, 0, function () {

		});
	});
	$("#drop_t2-1").droppable("enable");
//}
	//type3
	//else if(type == 3){
	$(".dragged2").addClass("drag_numbers_t3");
	$(".dragged2").removeClass("dragged2");
   $("#drop_t3-1").removeClass("dropimg_1");
   var removedDragDiv = $('#drop_t3-1 div:first').remove(); 
   $('#type_3').append(removedDragDiv);
	$("#drop_t3-1").removeClass("dropimg_t3_1");
	if(ansFlag)
	$("#human_drop").css("display","block");
	//ansFlag = false;
	$(".drag_numbers_t3").each(function (i) {
		$(this).removeClass("stopdrag");
		$("#drag_t3-" + (i + 1)).show();

		$("#drag_t3-" + (i + 1)).animate({ top: parseFloat($("#drag_t3-" + (i + 1)).attr('original-top')), left: parseFloat($("#drag_t3-" + (i + 1)).attr('original-left')) }, 0, function () {

		});
	});
	$("#drop_t3-1").droppable("enable");
	//}
	//type4
	//else{
	$(".dragged3").addClass("drag_numbers_t4");
	$(".dragged3").removeClass("dragged3");
   $("#drop_t4-1").removeClass("dropimg_1");
   var removedDragDiv = $('#drop_t4-1 div:first').remove(); 
   $('#type_4').append(removedDragDiv);
   if(ansFlag)
	$("#animal_drop").css("display","block");
	$("#drop_t4-1").removeClass("dropimg_t4_1");
    $(".drag_numbers_t4").each(function (i) {
		$(this).removeClass("stopdrag");
		$("#drag_t4-" + (i + 1)).show();

		$("#drag_t4-" + (i + 1)).animate({ top: parseFloat($("#drag_t4-" + (i + 1)).attr('original-top')), left: parseFloat($("#drag_t4-" + (i + 1)).attr('original-left')) }, 0, function () {

		});
	});
	$("#drop_t4-1").droppable("enable");
 //} */
	$(".dragItem").draggable({
		disabled:false
	});
}

showQues = function () {
	$('#questioMark').hide();
	$('#myModal').css('display', 'block');
}
hideQuestion = function () {
	$('#questioMark').show();
	$('#myModal').css('display', 'none');
}

function goToNext() {
	
		 //  label = "null";
         scoreFunction();

}
function scoreFunction(){
	console.log(scoredMarks,startTime, label);
	//alert("ScoredMarks = " + scoredMarks +","+" "+"Label = " +label);
    if (Utils.mobileDeviceFlag) {
        Android.gotoNextGame(scoredMarks,startTime, label);
    }
}


/*Game Functions Ends*/