
var IdentifyMoreLess={};
var Utils={};
Utils.Path='';
IdentifyMoreLess.limit=10;
IdentifyMoreLess.greaterNumber=0;
IdentifyMoreLess.smallerNumber=0;
IdentifyMoreLess.question=0;
IdentifyMoreLess.randomNoArr=[];	
IdentifyMoreLess.slotsArray=[];
IdentifyMoreLess.randomObject=0;
IdentifyMoreLess.sectionNames=['section1','section2']
IdentifyMoreLess.gameTypes=['more','less'];
IdentifyMoreLess.gameNames=['N2A','N3A','N5A'];
IdentifyMoreLess.randomGame = '';
IdentifyMoreLess.attemptFlag=false;
IdentifyMoreLess.sequentialSlots=[1,2,3,4,5,6,7,8,9,10];
Utils.mobileDeviceFlag=false;
IdentifyMoreLess.counter =0;

var startTime='',label='null';

$(document).ready(function()
{
	if((navigator.userAgent.match(/Android|BlackBerry|iPhone|iPad|iPod|Opera Mini|IEMobile/i)) && !(window.location.href.includes('http')))
		Utils.mobileDeviceFlag=true;
	else
		Utils.mobileDeviceFlag=false;

	setTimeout(function()
	{
		$('#coverPage,#homeAndLogoDiv').show();
		$('#questioMark').hide();
		$('#myModal').css('display','block');
		IdentifyMoreLess.init();
	},200);
});

function showQues(){
    $('#questioMark').hide();
    $('#myModal').css('display','block');
}

function hideQuestion(){
    $('#questioMark').show();
    $('#myModal').css('display','none');
}

IdentifyMoreLess.init=function()
{
	$(document).prop("title",IdentifyMoreLess.hardcodedata.NameoftheGame);
	$('#check').css({'pointer-events':'none'});
	IdentifyMoreLess.setLabels();
	IdentifyMoreLess.randomNoArr=IdentifyMoreLess.createRandomNoArray(IdentifyMoreLess.randomNoArr,IdentifyMoreLess.cnt);
	IdentifyMoreLess.playGame();
	console.log(IdentifyMoreLess.randomNoArr);
}

IdentifyMoreLess.setLabels=function(){
	for(let i=0;i<2;i++)
		$('#section'+(i+1)).data('option',String.fromCharCode(65+i));
		
	for(let i=0;i<4;i++)
		$('#option'+(i+1)).data('option',String.fromCharCode(65+i));
	
}

IdentifyMoreLess.getImages=function()
{
	var imagesArr = IdentifyMoreLess.currentNode.images;
	shuffleArray(imagesArr)
	$('#game1').hide();
	$('#game2').show();
	for(var i=0;i<4;i++){
		$('#option'+(i+1)).prop('src',Utils.Path+"images/"+imagesArr[i]);
		$('#option'+(i+1)).data('image',imagesArr[i]);
		if( imagesArr[i] == 'N5A_1.png')
			$('#option'+(i+1)).data('value','more');
		else
			$('#option'+(i+1)).data('value','less');
	}
	document.getElementById('heading').innerHTML = IdentifyMoreLess.currentNode.instruction;
	$('#queNo').text(IdentifyMoreLess.currentNode.gameCode);
}
IdentifyMoreLess.createRandomNoArray=function(array,arrlength){
	var i=0,randomNumber;
	while(i<arrlength)
	{	
			randomNumber=Math.floor(Math.random() * arrlength) + 1;
			while($.inArray(randomNumber,array)>=0)
			{
				randomNumber=Math.floor(Math.random() * arrlength) + 1;
			}
			array.push(randomNumber);	
			i++;
	}
	return array;
}
IdentifyMoreLess.playGame=function(){
	var d=new Date();
	startTime=d.getDate()+"-"+(d.getMonth()+1)+"-"+d.getFullYear()+" "+d.getHours()+":"+d.getMinutes()+":"+d.getSeconds();
	$('#gamePage,#nextDiv').show();//call reset function
if (Utils.mobileDeviceFlag) {
		var val = Android.getGameLang();		//GET ANDROID GAME LANGUAGE
		// var val = 'Urdu-Pakistan'
		var lang = IdentifyMoreLess.type.find(checkIndex);
		langIndex = IdentifyMoreLess.type.indexOf(lang);
		if (lang.language == 'Urdu-Pakistan')
			$('#heading').css('direction','rtl')
		function checkIndex(i) {
			if (i.language.toLowerCase().trim() == val.toLowerCase().trim())
				return i;
		}
	}
	else
	langIndex = 1; /* Math.floor(Math.random() * IdentifyMoreLess.type.length);		//GET RANDOM GAME LANGUAGE */
	
	if (Utils.mobileDeviceFlag)
	{
		var val=Android.getGameID();		//GET GAME CODE
		//val = 'N7A'
		var data=IdentifyMoreLess.type[langIndex].gamedata.find(checkIndex);
		nodeIndex=IdentifyMoreLess.type[langIndex].gamedata.indexOf(data);
		
		function checkIndex(i){
		if(i.gameCode==val)
		return i;
		}
	}
	else
		nodeIndex = Math.floor(Math.random() * IdentifyMoreLess.type[langIndex].gamedata.length);



	// IdentifyMoreLess.data = IdentifyMoreLess.type.find(el => el.language == "Hindi")
	IdentifyMoreLess.data = IdentifyMoreLess.type[langIndex];	//language node
	IdentifyMoreLess.randomGame = nodeIndex;		//current node index
	IdentifyMoreLess.currentNode=IdentifyMoreLess.type[langIndex].gamedata[nodeIndex];	//current node object
	if(IdentifyMoreLess.currentNode.gameCode == 'N3A'){
		$('.section').addClass('border');
		IdentifyMoreLess.sequentialData();		
	}
	else if(IdentifyMoreLess.currentNode.gameCode == 'N2A')
		IdentifyMoreLess.sequentialData();
	else
		IdentifyMoreLess.getImages();
	
	/* if(Utils.mobileDeviceFlag){
		IdentifyMoreLess.randomGame= Android.getGameID();
		IdentifyMoreLess.currentNode = IdentifyMoreLess.data.gamedata.find(el => el.gameCode === IdentifyMoreLess.randomGame)
		//IdentifyMoreLess.data=eval('IdentifyMoreLess.type.'+IdentifyMoreLess.randomGame);
		if(IdentifyMoreLess.randomGame == 'N3A'){
			$('.section').addClass('border');
			IdentifyMoreLess.sequentialData();		
		}
		else if(IdentifyMoreLess.randomGame == 'N2A')
			IdentifyMoreLess.sequentialData();
		else
			IdentifyMoreLess.getImages();
	}else{
		IdentifyMoreLess.randomGame= Math.floor(1+Math.random() * IdentifyMoreLess.gameNames.length-1);
		IdentifyMoreLess.currentNode = IdentifyMoreLess.data.gamedata.find(el => el.gameCode === IdentifyMoreLess.gameNames[IdentifyMoreLess.randomGame]);
		//IdentifyMoreLess.data=eval('IdentifyMoreLess.type.'+IdentifyMoreLess.gameNames[IdentifyMoreLess.randomGame]);
		if(IdentifyMoreLess.gameNames[IdentifyMoreLess.randomGame] == 'N3A'){
			$('.section').addClass('border');
			IdentifyMoreLess.sequentialData();
		}	
		else if(IdentifyMoreLess.gameNames[IdentifyMoreLess.randomGame] == 'N2A')
			IdentifyMoreLess.sequentialData();
		else
			IdentifyMoreLess.getImages();
	} */
} 
// IdentifyMoreLess.showDefaultData=function()
// {
// 	shuffleArray(IdentifyMoreLess.sectionNames);
// 	IdentifyMoreLess.randomObject=4;
// 	IdentifyMoreLess.greaterNumber=6;
// 	IdentifyMoreLess.smallerNumber=4;
// 	IdentifyMoreLess.createObjectsSlots('slotDiv',IdentifyMoreLess.sectionNames[0],1,25);
// 	IdentifyMoreLess.getRandomSlots(1,25);
// 	IdentifyMoreLess.placeObjectsRandomly('slotDiv',IdentifyMoreLess.greaterNumber,IdentifyMoreLess.slotsArray);
// 	IdentifyMoreLess.createObjectsSlots('slotDiv',IdentifyMoreLess.sectionNames[1],26,50);
// 	IdentifyMoreLess.getRandomSlots(26,50);	
// 	IdentifyMoreLess.placeObjectsRandomly('slotDiv',IdentifyMoreLess.smallerNumber,IdentifyMoreLess.slotsArray);

// 	 $('#'+IdentifyMoreLess.sectionNames[0]).data('value','more');
// 	 $('#'+IdentifyMoreLess.sectionNames[1]).data('value','less');

// 	document.getElementById('heading').innerHTML = IdentifyMoreLess.currentNode.instruction;
// 	$('#queNo').text(IdentifyMoreLess.currentNode.gameCode);
// 	$('.section').addClass('border');
// 	$('#game1').show();
// 	$('#game2').hide();
// }

IdentifyMoreLess.sequentialData=function(){
	shuffleArray(IdentifyMoreLess.sectionNames);
	$('#'+IdentifyMoreLess.sectionNames[0]).css({'background-image':'url(images/'+IdentifyMoreLess.currentNode.more+')'});
	$('#'+IdentifyMoreLess.sectionNames[1]).css({'background-image':'url(images/'+IdentifyMoreLess.currentNode.less+')'});
	$('#'+IdentifyMoreLess.sectionNames[0]).data('image',IdentifyMoreLess.currentNode.more);
	$('#'+IdentifyMoreLess.sectionNames[1]).data('image',IdentifyMoreLess.currentNode.less);
	$('#'+IdentifyMoreLess.sectionNames[0]).data('value','more');
	$('#'+IdentifyMoreLess.sectionNames[1]).data('value','less');
	document.getElementById('heading').innerHTML = IdentifyMoreLess.currentNode.instruction;
	$('#queNo').text(IdentifyMoreLess.currentNode.gameCode);
	$('.section').addClass('background');
	$('#game1').show();
	$('#game2').hide();
}

//slots are created to put objects in it
IdentifyMoreLess.createObjectsSlots=function(label,parentElement,start,end){
	var slotDiv;
	for(var i=start;i<=end;i++)
	{
		slotDiv=document.createElement('div'); //numberdivs created
		slotDiv.id=label+i;	
		slotDiv.className='nopadding slot col-xs-3 col-md-3 col-lg-3 col-sm-3';
		document.getElementById(parentElement).appendChild(slotDiv);//change name 
	}	
}

IdentifyMoreLess.getRandomSlots=function(start,end){
	var i=0,randomNumber;
	IdentifyMoreLess.slotsArray=[];
	while(i<10)
	{	
			randomNumber=Math.floor(Math.random()  * (end - start + 1)) + start;
			while($.inArray(randomNumber,IdentifyMoreLess.slotsArray)>=0)
			{
				randomNumber=Math.floor(Math.random()  * (end - start + 1)) + start;
			}
			IdentifyMoreLess.slotsArray.push(randomNumber);	
			i++;
	}
	console.log('slots'+IdentifyMoreLess.slotsArray);
}

IdentifyMoreLess.placeObjectsRandomly=function(label,cnt,slotArray)
{
	var objectImg;
	for(var i=0;i<cnt;i++)
	{	
			
			objectDiv=document.createElement('div');  
			objectDiv.id='objectDiv'+i;
			objectDiv.className='objectsOnSlots col-xs-12 col-md-12 col-lg-12 col-sm-12';
			
			objectImg=document.createElement('img'); 
			objectImg.id='objectImg'+i;
			objectImg.src=Utils.Path+"images/"+IdentifyMoreLess.json[0].objectImg;	
			objectImg.className='noPadding img-responsive objectImg col-xs-12 col-md-12 col-lg-12 col-sm-12';	
			objectDiv.appendChild(objectImg);
			
			document.getElementById(label+slotArray[i]).appendChild(objectDiv);
				
	}
}	

IdentifyMoreLess.selectSection=function(element){

	IdentifyMoreLess.attemptFlag=true;
	$('.selection').removeClass('selection');
	$('#'+element).addClass('selection');
	$('#Check').css({'pointer-events':'auto'});
	IdentifyMoreLess.givenAnswer=$('#'+element).data('value');	
	//label = $('#'+element).data('image').split('.')[0];
	label = $('#'+element).data('option');
};

IdentifyMoreLess.resetGame=function(){
	IdentifyMoreLess.attemptFlag=false;
	$('.selection').removeClass('selection');
	IdentifyMoreLess.givenAnswer='';
	label ='null';
};

IdentifyMoreLess.checkAnswer=function(){
	if(IdentifyMoreLess.attemptFlag){
		if(IdentifyMoreLess.currentNode.answer == IdentifyMoreLess.givenAnswer){
			console.log('correct');
			IdentifyMoreLess.score = '2';
		}
		else{
			IdentifyMoreLess.score = '1';
			console.log('wrong');
		}		
	}else
		IdentifyMoreLess.score = '0';

	//alert("ScoredMarks = " + IdentifyMoreLess.score +","+" "+"Label = " +label);
	console.log(IdentifyMoreLess.score,startTime,label);
	if(Utils.mobileDeviceFlag)
		Android.gotoNextGame(IdentifyMoreLess.score,startTime,label);

	// if(Utils.mobileDeviceFlag)
	// 	Android.addScore(resId,parseInt(questionId),IdentifyMoreLess.score,startTime); 
};

IdentifyMoreLess.showNextGame=function(){
	IdentifyMoreLess.checkAnswer();
	$('body').css('pointer-events','auto');	
};





