var clickOption='';
function showModal()
{
	$("#modalRoot").addClass("visible");
	$("body").addClass("overlay");
	$(".pointerClass").css("pointer-events","none");
}
function closeModal()
{
	$("#modalRoot").removeClass("visible");
	$("body").removeClass("overlay");
	$(".pointerClass").css("pointer-events","auto");
}
function clickOnCode(ele) { 	// onclick of direct coding
    $('.codeCls').css('border', '2px solid rgb(102 98 85)');
	$(ele).css('border', '6px solid #ffbe00');
	clickOption = $(ele).text();
}
createNumberDivs=function(parentDiv,buttonCount)
{
	var i = 0, j = 0, row, newbutton;
		for (i = 1; i <= 4; i++) {
			row = document.createElement('div');
			row.setAttribute("id", "row" + i);
			row.setAttribute("class", "rowClass col-xs-11 col-sm-11 col-md-11 col-lg-11 nopadding");
				for (j = 1; j <= 3; j++) {
					if (buttonCount <= 10) {
						newbutton = document.createElement('BUTTON');
						newbutton.setAttribute("id", "buttonValue" + buttonCount);
						if(buttonCount >= 9)
							newbutton.setAttribute("class", "borderClass buttonClass noPadding col-sm-offset-1 col-xs-offset-1 col-lg-offset-1 col-md-offset-1 col-xs-2 col-sm-2 col-md-2 col-lg-2 nopadding");
						else
							newbutton.setAttribute("class", "borderClass buttonClass noPadding col-sm-offset-1 col-xs-offset-1 col-lg-offset-1 col-md-offset-1 col-xs-2 col-sm-2 col-md-2 col-lg-2 nopadding");
						$(newbutton).text(buttonCount);
						if(buttonCount==10)
							$(newbutton).text(":");
						newbutton.setAttribute("onclick", "appendNumbertoText(this.id)");
					}
					row.append(newbutton);
					parentDiv.append(row);
					buttonCount++;
			}
		}
};
function appendNumbertoText (obj) {
	var givenAnswer=$('#inputText').text().trim()+''+$('#'+obj).text();
	if(givenAnswer.toString().length<=len)
		$("#inputText").text($('#inputText').text().trim()+''+$('#'+obj).text());
};
function showKeypad(){
	$('#numberSystemDiv').show();
};
function clearModal()
{
	$("#inputText").text('');
	clickOption='';
	$('.codeCls').css('border', '2px solid rgb(102 98 85)');
}
//check event to close modal
$(document).click(function(event) {
	//if you click on anything except the modal itself close the modal
	if (!$(event.target).closest(".modal,#modalIcon").length) {
	 $("body").find("#modalRoot").removeClass("visible");
	 $("body").removeClass("overlay");
	 $(".pointerClass").css("pointer-events","auto");
	}
  });
  