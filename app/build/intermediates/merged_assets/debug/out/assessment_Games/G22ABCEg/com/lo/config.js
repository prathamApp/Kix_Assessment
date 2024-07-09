/*Config Data File Starts*/
/*-- Scaling Functions Starts ---*/
var DragDropScale; //For Drag and Drop Scaling
var click = { x: 0, y: 0 };
var zoomFactor = 1;

function resizeHandler() {

	var stageRef = $("#DvMainCont");

	//var _window = window.nativeWindow();
    var stageWidth = 1280;
    var stageHeight = 720;

    var newWidth = 0;
    var newLeft = 0;

    var scale = { x: 0, y: 0 };

    var x = Number(window.innerWidth) / stageWidth;
    var y = Number(window.innerHeight) / stageHeight;
    // x = 1;
    // y = 1;
    if (x < y) {
      scale = { x: x, y: x };
    } else {
      scale = { x: y, y: y };
    }

    //window.scaleFactor = scale.x;
    newWidth = Number(scale.x) * stageWidth;
    newLeft = (window.innerWidth - newWidth) / 2;
	
	//DragDropScale = scale;

	var stageScaling = "-webkit-transform: scale(" + scale.x + "," + scale.y + "); -moz-transform: scale(" + scale.x + "," + scale.y + "); -ms-transform: scale(" + scale.x + "," + scale.y + "); -o-transform: scale(" + scale.x + "," + scale.y + "); transform: scale(" + scale.x + "," + scale.y + "); -webkit-transform-origin: left top; -moz-transform-origin: left top; -ms-transform-origin: left top; -o-transform-origin: left top; transform-origin: left top; position: absolute; top: 0px; left:" + newLeft + "px";

	

	
    //this.el.nativeElement.parentElement.setAttribute("style", this.stageScaling);
	//$("#DvMainCont").attr("style", this.stageScaling);
  document.getElementById("DvMainCont").setAttribute("style", stageScaling);

  DragDropScale = scale.y;
  
}

$(window).resize(function(){
	//$(window).scrollTop(0,0);
});

/*-- Scaling Functions Ends ---*/