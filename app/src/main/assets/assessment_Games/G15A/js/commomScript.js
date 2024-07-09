
var clickOption='';
function showModal()
{
	$("#modalRoot").addClass("visible");
	$("body").addClass("overlay");
	$(".opacityClass").css("opacity","0.1");
	$(".pointerClass").css("pointer-events","none");
}
function closeModal()
{
	$("#modalRoot").removeClass("visible");
	$("body").removeClass("overlay");
	$(".opacityClass").css("opacity","1");
	//$('#answerKeyText').text('Clock / Wall clock / Watch / Points at the clock')
	$(".pointerClass").css("pointer-events","auto");
}
function clickOnCode(ele) { 	// onclick of direct coding
    $('.codeCls').css('border', '2px solid rgb(102 98 85)');
	$(ele).css('border', '6px solid #ffbe00');
	scoredmarks=clickOption = $(ele).text();
	if(scoredmarks=='0')
		label='null';
}

createNumberDivs = function(parentDiv)
{
	var i, button, buttonCnt = 1;

    for(i=0; i<4; i++)
    {
		div = document.createElement('div');
        document.getElementById(parentDiv).appendChild(div);
        div.setAttribute('id','row'+(i+1));   
        div.setAttribute('class','rowClass col-xs-12 col-sm-12 col-md-12 col-lg-12 noPadding'); 
        
        if(i==3){
            zerobutton = document.createElement('button');
			document.getElementById('row'+(i+1)).appendChild(zerobutton);
			zerobutton.setAttribute('id','zeroButton'+(i+1));   
			zerobutton.setAttribute('onclick','appendNumbertoText(this.id)');
			zerobutton.setAttribute('class','borderClass buttonClass noPadding col-sm-offset-4 col-xs-offset-4 col-lg-offset-4 col-md-offset-4 col-xs-2 col-sm-2 col-md-2 col-lg-2 nopadding'); 
			document.getElementById('zeroButton'+(i+1)).innerHTML = buttonCnt;   
        }
        else{
			for(k=0; k<3; k++)
			{		 
				button = document.createElement('button');
				document.getElementById('row'+(i+1)).appendChild(button);
				button.setAttribute('id','button'+(i+1)+(k+1));   
				button.setAttribute('onclick','appendNumbertoText(this.id)');
				button.setAttribute('class','borderClass buttonClass noPadding col-sm-offset-1 col-xs-offset-1 col-lg-offset-1 col-md-offset-1 col-xs-2 col-sm-2 col-md-2 col-lg-2 nopadding'); 
				document.getElementById('button'+(i+1)+(k+1)).innerHTML = buttonCnt;
				buttonCnt++;	
				if(buttonCnt == 10)
					buttonCnt = 0;		
			} 
        }    
    }    
}

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
/* $(document).click(function(event) {
	//if you click on anything except the modal itself close the modal
	if (!$(event.target).closest(".modal,#modalIcon").length) {
	 $("body").find("#modalRoot").removeClass("visible");
	 $("body").removeClass("overlay");
	 $(".opacityClass").css("opacity","1");
	 $(".pointerClass").css("pointer-events","auto");
	}
  }); */
  