Classification.sampleColor = ['yellow', 'blue', 'green', 'red'];
Classification.specialShapeArr = ['circle', 'star', 'rectangle', 'triangle'];

Classification.hardcodedData =
{
	"question": "Separate Out Images By",
	"gameOver": "खेल समाप्त",
	"createdOn": "July 2020",
	"gameTitle": "D1B-D1D-D2B-D3A-D3B-D3C-D4A-D4B-D6A",
	"languageFont": "fonts/NotoNaskhArabic-VariableFont_wght.ttf"
};

Classification.shapeImgData = [
	{
		"lang": "English-Uganda",
		'languageFont': 'fonts/Andika-Regular.ttf',
		"data": [
			{
				"queNo": "D1B",
				"question": " <span style='color:blue'>(Point to the green balls and say)</span> Look, I am putting all the <b>green balls</b> here <span style='color:blue'>(Drag and drop all the green balls one by one into the jar)</span>.",
				"question2": " Now, put all the <b>yellow balls</b> here <span style='color:blue'>(point to the jar)</span>. <span style='color:blue'>(Prompt: If the child leaves the task midway, ask them to complete the task)</span>",
				"font": "1.6vw",
				"data": "",
				"object": ["circle"],
				"img": "",
				"jarCnt": 1,
				"colorObjects": [
					{
						"imageName": ["yellow", "circle"],
						"imgPath": "D1B_4.png"
					},
					{
						"imageName": ["blue", "circle"],
						"imgPath": "D1B_3.png"
					},
					{
						"imageName": ["green", "circle"],
						"imgPath": "D1B_2.png"
					},
				],
			},
			{
				"queNo": "D1D",
				"question": "<span style='color:blue'>(Point to the box and say)</span> Look at this carefully. Now, put all those circles <span style='color:blue'>(point to all the circles)</span> that are of the same colour as the box, one by one into the box <span style='color:blue'>(point to the box)</span>.<span style='color:blue'>(Prompt: If the child leaves the task midway, ask them to complete the task.)</span>.",
				"font": "1.6vw",
				"data": "",
				"object": ["circle"],
				"img": "",
				"jarCnt": 1,
				"colorObjects": [
					{
						"imageName": ["yellow", "circle"],
						"imgPath": "D1A_6.png"
					},
					{
						"imageName": ["blue", "circle"],
						"imgPath": "D1A_7.png"
					},
					{
						"imageName": ["green", "circle"],
						"imgPath": "D1A_5.png"
					},
					{
						"imageName": ["red", "circle"],
						"imgPath": "D1A_8.png"
					},
				],
			},
			{
				"queNo": "D2B",
				"question": "<span style='color:blue'>(Point to the different shapes and say)</span> Look, I am putting all the circles <span style='color:blue'>(point to the circles)</span> in this box <span style='color:blue'>(drag and drop all the circles one by one inside the box)</span>.",
				"question2": "Now, like I did, you have to put all the triangles in this box <span style='color:blue'>(point to the box)</span>. <span style='color:blue'>(Prompt: If the child leaves the task midway, ask them to complete the task)</span>.",
				"font": "1.6vw",
				"data": "",
				"object": ["circle"],
				"img": "",
				"jarCnt": 1,
				"colorObjects": [
					{
						"imageName": ["triange", "triangle"],
						"imgPath": "D2B_4.png"
					},
					{
						"imageName": ["rectangle", "rectangle"],
						"imgPath": "D2B_2.png"
					},
					{
						"imageName": ["circle", "circle"],
						"imgPath": "D2B_3.png"
					},
				],
			},
			{
				"queNo": "D3A",
				"question": " <span style='color:blue'>(Point to the animals and birds and say)</span> Look at these carefully. Now, put all the birds here <span style='color:blue'>(point to the birds section)</span> and all the animals here <span style='color:blue'>(point to the animals section)</span>. <span style='color:blue'>(Prompt: If the child leaves the task midway, ask them to complete the task)</span>",
				"font": "1.6vw",
				"data": "",
				"object": ["bird", "animal"],
				"img": "",
				"jarCnt": 2,
				"animalText": "Animals",
				"birdText": "Birds",
				"colorObjects": [
					{
						"imageName": ["animal", "cow"],
						"imgPath": "D3A_1.png"
					},
					{
						"imageName": ["bird", "cock"],
						"imgPath": "D3A_2.png"
					},
					{
						"imageName": ["animal", "elephant"],
						"imgPath": "D3A_3.png"
					},
					{
						"imageName": ["bird", "crow"],
						"imgPath": "D3A_4.png"
					},
					{
						"imageName": ["animal", "cat"],
						"imgPath": "D3A_5.png"
					},
					{
						"imageName": ["bird", "pigon"],
						"imgPath": "D3A_6.png"
					},
				],
			},
			{
				"queNo": "D3B",
				"question": " <span style='color:blue'>(Point to the objects and say)</span> Look at these carefully. Now, put all the fruits here <span style='color:blue'>(point to the fruits section)</span> and all the vegetables here <span style='color:blue'>(point to the vegetables section)</span>. <span style='color:blue'>(Prompt: If the child leaves the task midway, ask them to complete the task.)</span>",
				"font": "1.6vw",
				"data": "",
				"object": ["fruit", "vegetable"],
				"img": "",
				"jarCnt": 2,
				"fruitText": "Fruits",
				"vegText": "Vegetables",
				"colorObjects": [
					{
						"imageName": ["fruit", "orange"],
						"imgPath": "D3B_4.png"
					},
					{
						"imageName": ["fruit", "banana"],
						"imgPath": "D3B_5.png"
					},
					{
						"imageName": ["fruit", "mango"],
						"imgPath": "D3B_6.png"
					},
					{
						"imageName": ["vegetable", "carrot"],
						"imgPath": "D3B_2.png"
					},
					{
						"imageName": ["vegetable", "potato"],
						"imgPath": "D3B_7.png"
					},
					{
						"imageName": ["vegetable", "bringal"],
						"imgPath": "D3B_9.png"
					},
				],
			},
			// {
			// 	"queNo": "D3C",
			// 	"question": 'Look at these <span style="color:blue">(point to the objects)</span>. Put all the items that can be worn here <span style="color:blue">(point to the ‘things that can be worn’ section)</span>and all the items that cannot be worn here <span style="color:blue">(point to the ‘things that cannot be worn’ section)</span>.<span style="color:blue">(Prompt: If the child stops after sorting some objects, ask her to do the same for all objects).</span>',
			// 	"font": "1.6vw",
			// 	"data": "",
			// 	"object": ["worn", "notWorn"],
			// 	"img": "",
			// 	"jarCnt": 2,
			// 	"colorObjects": [
			// 		{
			// 			"imageName": ["worn", "cap"],
			// 			"imgPath": "D3C_2.png"
			// 		},
			// 		{
			// 			"imageName": ["worn", "dress"],
			// 			"imgPath": "D3C_6.png"
			// 		},
			// 		{
			// 			"imageName": ["worn", "shirt"],
			// 			"imgPath": "D3C_5.png"
			// 		},
			// 		{
			// 			"imageName": ["notWorn", "pillow"],
			// 			"imgPath": "D3C_4.png"
			// 		},
			// 		{
			// 			"imageName": ["notWorn", "mat"],
			// 			"imgPath": "D3C_7.png"
			// 		},
			// 		{
			// 			"imageName": ["notWorn", "curtain"],
			// 			"imgPath": "D3C_8.png"
			// 		},
			// 	],
			// },
			{
				"queNo": "D4A",
				"question": "Now, put all the <b>red circles</b> here <span style='color:blue'>(Point to the jar)</span><span style='color:blue'>(Prompt: If the child leaves the task midway, ask them to complete the task)</span>.",
				"question2": "  Now, as I did you have to put all the <b>red circles</b> here <span style='color:blue'>(Point to the jar)</span> <span style='color:blue'>(Prompt: If the child leaves the task midway, ask them to complete the task)</span>",
				"font": "1.6vw",
				"data": "",
				"object": ["circle-red"],
				"img": "",
				"jarCnt": 1,
				"colorObjects": [
					{
						"imageName": ["triange-yellow", "triangle"],
						"imgPath": "D4A_3.png"
					},
					{
						"imageName": ["triange-blue", "triangle"],
						"imgPath": "D4A_4.png"
					},
					{
						"imageName": ["triange-blue", "triangle"],
						"imgPath": "D4A_4.png"
					},
					{
						"imageName": ["triange-red", "triangle"],
						"imgPath": "D4A_5.png"
					},
					{
						"imageName": ["circle-red", "circle"],
						"imgPath": "D4A_2.png"
					},
					{
						"imageName": ["circle-red", "circle"],
						"imgPath": "D4A_2.png"
					},
					{
						"imageName": ["circle-blue", "circle"],
						"imgPath": "D4A_6.png"
					},
					{
						"imageName": ["circle-yellow", "circle"],
						"imgPath": "D4A_7.png"
					},
				],
			},
			{
				"queNo": "D4B",
				"question": "<span style='color:blue'>(Point to the blue triangles and say)</span> Look, I am putting all the <b>blue triangles</b> here <span style='color:blue'>(Drag and drop all the blue triangles one by one into the jar)</span>.",
				"question2": " Now, put all the <b>red circles</b> here <span style='color:blue'>(Point to the jar)</span> </span>(Prompt: If the child leaves the task midway, ask them to complete the task)<span style='color:blue'>.",
				"font": "1.6vw",
				"data": "",
				"object": ["rectangle-yellow"],
				"img": "",
				"jarCnt": 1,
				"colorObjects": [
					{
						"imageName": ["triange-yellow", "triangle"],
						"imgPath": "D4B_3.png"
					},
					{
						"imageName": ["triange-yellow", "triangle"],
						"imgPath": "D4B_3.png"
					},
					{
						"imageName": ["triange-blue", "triangle"],
						"imgPath": "D4B_6.png"
					},
					{
						"imageName": ["rectangle-yellow", "rectangle"],
						"imgPath": "D4B_7.png"
					},
					{
						"imageName": ["rectangle-yellow", "rectangle"],
						"imgPath": "D4B_7.png"
					},
					{
						"imageName": ["rectangle-yellow", "rectangle"],
						"imgPath": "D4B_7.png"
					},
					{
						"imageName": ["rectangle-red", "rectangle"],
						"imgPath": "D4B_4.png"
					},
					{
						"imageName": ["circle-red", "circle"],
						"imgPath": "D4B_5.png"
					},
					{
						"imageName": ["circle-red", "circle"],
						"imgPath": "D4B_5.png"
					}, {
						"imageName": ["circle-red", "circle"],
						"imgPath": "D4B_5.png"
					},
					{
						"imageName": ["circle-blue", "circle"],
						"imgPath": "D4B_8.png"
					},
					{
						"imageName": ["circle-yellow", "circle"],
						"imgPath": "D4B_1.png"
					},

				],
			},
			{
				"queNo": "D6A",
				"question": " <span style='color:blue'>(Point to the animals and say)</span> Look at these carefully. Now, put all the animals that have <b>four legs</b> here <span style='color:blue'>(point to the fenced area)</span> <span style='color:blue'>(Prompt: If the child leaves the task midway, ask them to complete the task)</span>",
				"font": "1.6vw",
				"data": "",
				"object": ["four-leg"],
				"img": "",
				"jarCnt": 1,
				"colorObjects": [
					{
						"imageName": ["two-leg", "lamp"],
						"imgPath": "D6A_5.png"
					},
					{
						"imageName": ["two-leg", "stool"],
						"imgPath": "D6A_6.png"
					},
					{
						"imageName": ["four-leg", "chair"],
						"imgPath": "D6A_2.png"
					},
					{
						"imageName": ["four-leg", "table"],
						"imgPath": "D6A_3.png"
					},
					{
						"imageName": ["four-leg", "stretcher"],
						"imgPath": "D6A_4.png"
					},
					{
						"imageName": ["two-leg", "tripad"],
						"imgPath": "D6A_7.png"
					},
				],
			},
		]
	},
	{
		"lang": "Hindi-India",
		"data": [
			{
				"queNo": "D1B",
				"question": " <span style='color:blue'>(हरी गेंदों की ओर इशारा करते हुए कहें)</span> देखो, मैं इन सभी <b>हरी गेंदों</b> को यहाँ डाल रहा हूँ <span style='color:blue'>(सभी हरी गेंदों को एक-एक करके जार में डालें)</span>। ",
				"question2": " अब, तुम सभी <b>पीली गेंदों</b> को यहाँ डालो <span style='color:blue'>(जार की ओर इशारा करें)</span>। <span style='color:blue'>(प्रांप्ट: यदि बच्चा कार्य अधूरा छोड़ देता है, तो उसे कार्य पूरा करने को कहें।)</span>",
				"font": "1.6vw",
				"data": "",
				"object": ["circle"],
				"img": "",
				"jarCnt": 1,
				"colorObjects": [
					{
						"imageName": ["yellow", "circle"],
						"imgPath": "D1B_4.png"
					},
					{
						"imageName": ["blue", "circle"],
						"imgPath": "D1B_3.png"
					},
					{
						"imageName": ["green", "circle"],
						"imgPath": "D1B_2.png"
					},
				],
			},
			{
				"queNo": "D1D",
				"question": "<span style='color:blue'>(डिब्बे की ओर इशारा करें और कहें)</span> इसे ध्यान से देखो| जिस रंग का यह डिब्बा है, उस रंग के सभी गोलों को <span style='color:blue'>(सभी गोलों की ओर इशारा करें)</span> एक - एक करके इस डिब्बे में डाल दो।(प्रॉम्प्ट: यदि बच्चा कार्य अधूरा छोड़ देता है, तो उसे कार्य पूरा करने को कहें।)",
				"font": "1.6vw",
				"data": "",
				"object": ["circle"],
				"img": "",
				"jarCnt": 1,
				"colorObjects": [
					{
						"imageName": ["yellow", "circle"],
						"imgPath": "D1A_6.png"
					},
					{
						"imageName": ["blue", "circle"],
						"imgPath": "D1A_7.png"
					},
					{
						"imageName": ["green", "circle"],
						"imgPath": "D1A_5.png"
					},
					{
						"imageName": ["red", "circle"],
						"imgPath": "D1A_8.png"
					},
				],
			},
			{
				"queNo": "D2B",
				"question": " <span style='color:blue'>(आकारों की ओर इशारा करते हुए कहें)</span> देखो, मैं सभी गोलों <span style='color:blue'>(गोलों की ओर इशारा करें)</span> को यहाँ <span style='color:blue'>(गोलों को एक-एक करके ले जाकर खाली डिब्बे में डाल दें)</span> डाल रहा हूँ |",
				"question2": " अब तुम भी ऐसे ही सभी त्रिकोण को यहाँ <span style='color:blue'>(खाली डिब्बे की ओर इशारा करे)</span> डाल दो| <span style='color:blue'>(प्रॉम्प्ट: यदि बच्चा कार्य अधूरा छोड़ देता है, तो उसे कार्य पूरा करने को कहें।)</span>",
				"font": "1.6vw",
				"data": "",
				"object": ["circle"],
				"img": "",
				"jarCnt": 1,
				"colorObjects": [
					{
						"imageName": ["triange", "triangle"],
						"imgPath": "D2B_4.png"
					},
					{
						"imageName": ["rectangle", "rectangle"],
						"imgPath": "D2B_2.png"
					},
					{
						"imageName": ["circle", "circle"],
						"imgPath": "D2B_3.png"
					},
				],
			},
			{
				"queNo": "D3A",
				"question": " <span style='color:blue'>(जानवरों और पक्षियों की ओर इशारा करते हुए कहें)</span> इन्हें ध्यान से देखो | अब, सभी पक्षियों को यहाँ <span style='color:blue'>(पक्षियों के भाग की ओर इशारा करें)</span> और सभी जानवरों को यहाँ <span style='color:blue'>(जानवरों के भाग की ओर इशारा करें)</span> डाल दो। <span style='color:blue'>(प्रॉम्प्ट: यदि बच्चा कार्य अधूरा छोड़ देता है, तो उसे कार्य पूरा करने को कहें।)</span>",
				"font": "1.6vw",
				"data": "",
				"object": ["bird", "animal"],
				"img": "",
				"jarCnt": 2,
				"animalText": "जानवर",
				"birdText": "पक्षी",
				"colorObjects": [
					{
						"imageName": ["animal", "cow"],
						"imgPath": "D3A_1.png"
					},
					{
						"imageName": ["bird", "cock"],
						"imgPath": "D3A_2.png"
					},
					{
						"imageName": ["animal", "elephant"],
						"imgPath": "D3A_3.png"
					},
					{
						"imageName": ["bird", "crow"],
						"imgPath": "D3A_4.png"
					},
					{
						"imageName": ["animal", "cat"],
						"imgPath": "D3A_5.png"
					},
					{
						"imageName": ["bird", "pigon"],
						"imgPath": "D3A_6.png"
					},
				],
			},
			{
				"queNo": "D3B",
				"question": " <span style='color:blue'>(सब्जियों और फलों की ओर इशारा करते हुए कहें)</span> इन्हें ध्यान से देखो| अब, सभी फलों को यहाँ <span style='color:blue'>(फलों के भाग की ओर इशारा करें)</span> और सभी सब्जियों को यहाँ <span style='color:blue'>(सब्जियों के भाग की ओर इशारा करें)</span> डाल दो। <span style='color:blue'>(प्रॉम्प्ट: यदि बच्चा कार्य अधूरा छोड़ देता है, तो उसे कार्य पूरा करने को कहें।)</span>",
				"font": "1.6vw",
				"data": "",
				"object": ["fruit", "vegetable"],
				"img": "",
				"jarCnt": 2,
				"fruitText": "फल",
				"vegText": "सब्जियां ",
				"colorObjects": [
					{
						"imageName": ["fruit", "orange"],
						"imgPath": "D3B_4.png"
					},
					{
						"imageName": ["fruit", "banana"],
						"imgPath": "D3B_5.png"
					},
					{
						"imageName": ["fruit", "mango"],
						"imgPath": "D3B_6.png"
					},
					{
						"imageName": ["vegetable", "carrot"],
						"imgPath": "D3B_2.png"
					},
					{
						"imageName": ["vegetable", "potato"],
						"imgPath": "D3B_7.png"
					},
					{
						"imageName": ["vegetable", "bringal"],
						"imgPath": "D3B_9.png"
					},
				],
			},
			// {
			// 	"queNo": "D3C",
			// 	"question": 'Look at these <span style="color:blue">(point to the objects)</span>. Put all the items that can be worn here <span style="color:blue">(point to the ‘things that can be worn’ section)</span>and all the items that cannot be worn here <span style="color:blue">(point to the ‘things that cannot be worn’ section)</span>.<span style="color:blue">(Prompt: If the child stops after sorting some objects, ask her to do the same for all objects).</span>',
			// 	"font": "1.6vw",
			// 	"data": "",
			// 	"object": ["worn", "notWorn"],
			// 	"img": "",
			// 	"jarCnt": 2,
			// 	"colorObjects": [
			// 		{
			// 			"imageName": ["worn", "cap"],
			// 			"imgPath": "D3C_2.png"
			// 		},
			// 		{
			// 			"imageName": ["worn", "dress"],
			// 			"imgPath": "D3C_6.png"
			// 		},
			// 		{
			// 			"imageName": ["worn", "shirt"],
			// 			"imgPath": "D3C_5.png"
			// 		},
			// 		{
			// 			"imageName": ["notWorn", "pillow"],
			// 			"imgPath": "D3C_4.png"
			// 		},
			// 		{
			// 			"imageName": ["notWorn", "mat"],
			// 			"imgPath": "D3C_7.png"
			// 		},
			// 		{
			// 			"imageName": ["notWorn", "curtain"],
			// 			"imgPath": "D3C_8.png"
			// 		},
			// 	],
			// },
			{
				"queNo": "D4A",
				"question": " <span style='color:blue'>(नीले त्रिकोणों की ओर इशारा करते हुए कहें)</span> देखो, मैं इन सभी <b>नीले त्रिकोणों</b> को यहाँ डाल रहा हूँ <span style='color:blue'>(सभी नीले त्रिकोणों को एक-एक करके जार में डालें)</span>। ",
				"question2": " अब, तुम सभी <b>लाल गोलों</b> को यहाँ डालो <span style='color:blue'>(जार की ओर इशारा करें)</span>। <span style='color:blue'>(प्रांप्ट: यदि बच्चा कार्य अधूरा छोड़ देता है, तो उसे कार्य पूरा करने को कहें।)</span>",
				"font": "1.6vw",
				"data": "",
				"object": ["circle-red"],
				"img": "",
				"jarCnt": 1,
				"colorObjects": [
					{
						"imageName": ["triange-yellow", "triangle"],
						"imgPath": "D4A_3.png"
					},
					{
						"imageName": ["triange-blue", "triangle"],
						"imgPath": "D4A_4.png"
					},
					{
						"imageName": ["triange-blue", "triangle"],
						"imgPath": "D4A_4.png"
					},
					{
						"imageName": ["triange-red", "triangle"],
						"imgPath": "D4A_5.png"
					},
					{
						"imageName": ["circle-red", "circle"],
						"imgPath": "D4A_2.png"
					},
					{
						"imageName": ["circle-red", "circle"],
						"imgPath": "D4A_2.png"
					},
					{
						"imageName": ["circle-blue", "circle"],
						"imgPath": "D4A_6.png"
					},
					{
						"imageName": ["circle-yellow", "circle"],
						"imgPath": "D4A_7.png"
					},

				],
			},
			{
				"queNo": "D4B",
				"question": "<span style='color:blue'>नीले रंग के त्रिकोण की ओर इशारा करते हुए कहें</span> देखो, मैं नीले रंग के सभी त्रिकोणों को यहाँ डाल रहा हूँ <span style='color:blue'>नीले रंग के सभी त्रिकोणों को एक-एक करके ले जाकर डिब्बे में डाल दें</span> |",
				"question2": "अब, जैसे मैंने किया आप भी वैसे ही लाल रंग के सभी गोलों को यहाँ <span style='color:blue'>डिब्बे की ओर इशारा करें</span> डाल दो|<span style='color:blue'>प्रॉम्प्ट: यदि बच्चा कार्य अधूरा छोड़ देता है, तो उसे कार्य पूरा करने को कहें</span>",
				"font": "1.6vw",
				"data": "",
				"object": ["rectangle-yellow"],
				"img": "",
				"jarCnt": 1,
				"colorObjects": [
					{
						"imageName": ["triange-yellow", "triangle"],
						"imgPath": "D4B_3.png"
					},
					{
						"imageName": ["triange-yellow", "triangle"],
						"imgPath": "D4B_3.png"
					},
					{
						"imageName": ["triange-blue", "triangle"],
						"imgPath": "D4B_6.png"
					},
					{
						"imageName": ["rectangle-yellow", "rectangle"],
						"imgPath": "D4B_7.png"
					},
					{
						"imageName": ["rectangle-yellow", "rectangle"],
						"imgPath": "D4B_7.png"
					},
					{
						"imageName": ["rectangle-yellow", "rectangle"],
						"imgPath": "D4B_7.png"
					},
					{
						"imageName": ["rectangle-red", "rectangle"],
						"imgPath": "D4B_4.png"
					},
					{
						"imageName": ["circle-red", "circle"],
						"imgPath": "D4B_5.png"
					},
					{
						"imageName": ["circle-red", "circle"],
						"imgPath": "D4B_5.png"
					}, {
						"imageName": ["circle-red", "circle"],
						"imgPath": "D4B_5.png"
					},
					{
						"imageName": ["circle-blue", "circle"],
						"imgPath": "D4B_8.png"
					},
					{
						"imageName": ["circle-yellow", "circle"],
						"imgPath": "D4B_1.png"
					},

				],
			},
			{
				"queNo": "D6A",
				"question": " <span style='color:blue'>(चित्रों की ओर इशारा करते हुए कहें)</span> इन्हें ध्यान से देखो और उन सभी वस्तु, जिनके चार पैर हैं, उन्हें यहाँ <span style='color:blue'>(डिब्बे की ओर इशारा करें)</span> डाल दो।",
				"font": "1.6vw",
				"data": "",
				"object": ["four-leg"],
				"img": "",
				"jarCnt": 1,
				"colorObjects": [
					{
						"imageName": ["two-leg", "lamp"],
						"imgPath": "D6A_5.png"
					},
					{
						"imageName": ["two-leg", "stool"],
						"imgPath": "D6A_6.png"
					},
					{
						"imageName": ["four-leg", "chair"],
						"imgPath": "D6A_2.png"
					},
					{
						"imageName": ["four-leg", "table"],
						"imgPath": "D6A_3.png"
					},
					{
						"imageName": ["four-leg", "stretcher"],
						"imgPath": "D6A_4.png"
					},
					{
						"imageName": ["two-leg", "tripad"],
						"imgPath": "D6A_7.png"
					},
				],
			},
		]
	}, {
		"lang": "Kiswahili-Kenya",
		'languageFont': 'fonts/Andika-Regular.ttf',
		"data": [
			{
				"queNo": "D1B",
				"question": "<span style='color:blue'>(Onyesha kwenye mipira ya kijani kibichi na useme)</span> Tazama, naweka <b>mipira yote ya kijani kibichi/green</b> hapa <span style='color:blue'>(Vuta na uangushe mipira yote ya kijani moja baada ya nyingine kwenye mtungi)</span>.",
				"question2": "Sasa, weka <b>mipira yote ya manjano/yellow hapa</b> <span style='color:blue'>(elekeza kwenye chupa)</span>.",
				"font": "1.6vw",
				"data": "",
				"object": ["circle"],
				"img": "",
				"jarCnt": 1,
				"colorObjects": [
					{
						"imageName": ["yellow", "circle"],
						"imgPath": "D1B_4.png"
					},
					{
						"imageName": ["blue", "circle"],
						"imgPath": "D1B_3.png"
					},
					{
						"imageName": ["green", "circle"],
						"imgPath": "D1B_2.png"
					},
				],
			},
			{
				"queNo": "D1D",
				"question": " <span style='color:blue'>(Elekeza kidole kwenye sanduku kisha useme)</span> Tazama hapa kwa makini. Sasa, weka duara zote <span style='color:blue'>(onyesha kwa kidole duara zenyewe)</span> za rangi sawa na rangi ya sanduku, moja baada ya nyingine kwenye sanduku hili <span style='color:blue'>(onyesha sanduku lenyewe kwa kidole)</span>. <span style='color:blue'>(Hoji zaidi: Mtoto akiachia katikati, muulize alikamilishe zoezi)</span>.",
				"font": "1.6vw",
				"data": "",
				"object": ["circle"],
				"img": "",
				"jarCnt": 1,
				"colorObjects": [
					{
						"imageName": ["yellow", "circle"],
						"imgPath": "D1A_6.png"
					},
					{
						"imageName": ["blue", "circle"],
						"imgPath": "D1A_7.png"
					},
					{
						"imageName": ["green", "circle"],
						"imgPath": "D1A_5.png"
					},
					{
						"imageName": ["red", "circle"],
						"imgPath": "D1A_8.png"
					},
				],
			},
			{
				"queNo": "D2B",
				"question": " <span style='color:blue'>(Elekeza kidole kwenye maumbo tofautitofauti kisha useme)</span> Tazama, ninaweka duara zote <span style='color:blue'>(onyesha duara zenyewe kwa kidole)</span> ndani ya sanduku hili <span style='color:blue'>(vuruta kisha udondoshe duara zote, moja baada ya nyingine ndani ya sanduku)</span>.",
				"question2": " Sasa, kama nilivyofanya, wewe pia utaweka maumbo yote ya pembetatu ndani ya sanduku hili <span style='color:blue'>(onyesha sanduku lenyewe kwa kidole)</span>. <span style='color:blue'>(Hoji zaidi: Mtoto akiachia katikati, muulize alikamilishe zoezi)</span>.",
				"font": "1.6vw",
				"data": "",
				"object": ["circle"],
				"img": "",
				"jarCnt": 1,
				"colorObjects": [
					{
						"imageName": ["triange", "triangle"],
						"imgPath": "D2B_4.png"
					},
					{
						"imageName": ["rectangle", "rectangle"],
						"imgPath": "D2B_2.png"
					},
					{
						"imageName": ["circle", "circle"],
						"imgPath": "D2B_3.png"
					},
				],
			},
			{
				"queNo": "D3A",
				"question": "<span style='color:blue'>(Elekeza kidole kwa wanyama/animals na ndege/birds tofautitofauti kisha useme)</span> Tazama hapa kwa makini kisha uweke ndege/birds wote hapa <span style='color:blue'>(onyesha kwa kidole sehemu ya kuweka ndege/birds)</span> na wanyama/animals wote hapa <span style='color:blue'>(onyesha kwa kidole sehemu ya kuweka wanyama/animals)</span>. <span style='color:blue'>(Hoji zaidi: Mtoto akiachia katikakati, muulize alikamilishe zoezi.)</span>.",
				"font": "1.6vw",
				"data": "",
				"object": ["bird", "animal"],
				"img": "",
				"jarCnt": 2,
				"animalText": "Wanyama",
				"birdText": "Ndege",
				"colorObjects": [
					{
						"imageName": ["animal", "cow"],
						"imgPath": "D3A_1.png"
					},
					{
						"imageName": ["bird", "cock"],
						"imgPath": "D3A_2.png"
					},
					{
						"imageName": ["animal", "elephant"],
						"imgPath": "D3A_3.png"
					},
					{
						"imageName": ["bird", "crow"],
						"imgPath": "D3A_4.png"
					},
					{
						"imageName": ["animal", "cat"],
						"imgPath": "D3A_5.png"
					},
					{
						"imageName": ["bird", "pigon"],
						"imgPath": "D3A_6.png"
					},
				],
			},
			{
				"queNo": "D3B",
				"question": "  <span style='color:blue'>(Elekeza kidole kwenye vifaa tofauti tofauti kisha useme)</span> Tazama hapa kwa makini kisha uweke matunda/fruits yote hapa <span style='color:blue'>(onyesha kwa kidole sehemu ya kuweka matunda/fruits)</span> na mboga/vegetables zote hapa <span style='color:blue'>(onyesha kwa kidole sehemu ya kuweka mboga/vegetables)</span>. <span style='color:blue'>(Hoji zaidi: Mtoto akiachia katikakati, muulize alikamilishe zoezi.)</span>.",
				"font": "1.6vw",
				"data": "",
				"object": ["fruit", "vegetable"],
				"img": "",
				"jarCnt": 2,
				"fruitText": "Matunda",
				"vegText": "Mboga",
				"colorObjects": [
					{
						"imageName": ["fruit", "orange"],
						"imgPath": "D3B_4.png"
					},
					{
						"imageName": ["fruit", "banana"],
						"imgPath": "D3B_5.png"
					},
					{
						"imageName": ["fruit", "mango"],
						"imgPath": "D3B_6.png"
					},
					{
						"imageName": ["vegetable", "carrot"],
						"imgPath": "D3B_2.png"
					},
					{
						"imageName": ["vegetable", "potato"],
						"imgPath": "D3B_7.png"
					},
					{
						"imageName": ["vegetable", "bringal"],
						"imgPath": "D3B_9.png"
					},
				],
			},
			{
				"queNo": "D4A",
				"question": "<span style='color:blue'>(Onyesha kwenye pembe tatu/triangles za bluu/blue na useme)</span> Tazama, naweka <b>pembe tatu/triangles zote za bluu/blue</b> hapa <span style='color:blue'>(Vuta na uangushe pembe tatu/triangles za bluu/blue moja baada ya nyingine kwenye mtungi)</span>.",
				"question2": "Sasa, weka <b>duara nyekundu/red circles</b> hapa <span style='color:blue'>(Elekeza kidole kwenye mtungi)</span> <span style='color:blue'>(Ushauri: Mtoto akiacha kazi katikati, mwaambie amalize kazi)</span>",
				"font": "1.6vw",
				"data": "",
				"object": ["circle-red"],
				"img": "",
				"jarCnt": 1,
				"colorObjects": [
					{
						"imageName": ["triange-yellow", "triangle"],
						"imgPath": "D4A_3.png"
					},
					{
						"imageName": ["triange-blue", "triangle"],
						"imgPath": "D4A_4.png"
					},
					{
						"imageName": ["triange-blue", "triangle"],
						"imgPath": "D4A_4.png"
					},
					{
						"imageName": ["triange-red", "triangle"],
						"imgPath": "D4A_5.png"
					},
					{
						"imageName": ["circle-red", "circle"],
						"imgPath": "D4A_2.png"
					},
					{
						"imageName": ["circle-red", "circle"],
						"imgPath": "D4A_2.png"
					},
					{
						"imageName": ["circle-blue", "circle"],
						"imgPath": "D4A_6.png"
					},
					{
						"imageName": ["circle-yellow", "circle"],
						"imgPath": "D4A_7.png"
					},
				],
			},
			{
				"queNo": "D4B",
				"question": " <span style='color:blue'>(Elekeza kidole kwenye pembetatu za buluu kisha useme)</span> Tazama, ninaweka pembetatu zote za buluu katika sanduku hili <span style='color:blue'>(vuruta kisha udondoshe pembetatu zote za buluu, moja baada ya nyingine ndani ya sanduku)</span>.",
				"question2": " Sasa, kama nilivyofanya, wewe pia utaweka miraba yote ya manjano ndani ya sanduku hili <span style='color:blue'>(onyesha sanduku lenyewe kwa kidole)</span>. <span style='color:blue'>(Hoji zaidi: Mtoto akiachia katikati, muulize alikamilishe zoezi)</span>.",
				"font": "1.6vw",
				"data": "",
				"object": ["rectangle-yellow"],
				"img": "",
				"jarCnt": 1,
				"colorObjects": [
					{
						"imageName": ["triange-yellow", "triangle"],
						"imgPath": "D4B_3.png"
					},
					{
						"imageName": ["triange-yellow", "triangle"],
						"imgPath": "D4B_3.png"
					},
					{
						"imageName": ["triange-blue", "triangle"],
						"imgPath": "D4B_6.png"
					},
					{
						"imageName": ["rectangle-yellow", "rectangle"],
						"imgPath": "D4B_7.png"
					},
					{
						"imageName": ["rectangle-yellow", "rectangle"],
						"imgPath": "D4B_7.png"
					},
					{
						"imageName": ["rectangle-yellow", "rectangle"],
						"imgPath": "D4B_7.png"
					},
					{
						"imageName": ["rectangle-red", "rectangle"],
						"imgPath": "D4B_4.png"
					},
					{
						"imageName": ["circle-red", "circle"],
						"imgPath": "D4B_5.png"
					},
					{
						"imageName": ["circle-red", "circle"],
						"imgPath": "D4B_5.png"
					}, {
						"imageName": ["circle-red", "circle"],
						"imgPath": "D4B_5.png"
					},
					{
						"imageName": ["circle-blue", "circle"],
						"imgPath": "D4B_8.png"
					},
					{
						"imageName": ["circle-yellow", "circle"],
						"imgPath": "D4B_1.png"
					},

				],
			},
			{
				"queNo": "D6A",
				"question": "<span style='color:blue'>(Onyesha kwa wanyama kisha useme)</span> Angalia hawa kwa makini. Sasa, weka wanyama wote walio na miguu <b>minne</b> hapa <span style='color:blue'>(onyesha eneo lililozungushiwa uzio)</span> <span style='color:blue'>(Ushauri: Mtoto akiacha kazi katikati, mwaambie amalize kazi)</span>",
				"font": "1.6vw",
				"data": "",
				"object": ["four-leg"],
				"img": "",
				"jarCnt": 1,
				"colorObjects": [
					{
						"imageName": ["two-leg", "lamp"],
						"imgPath": "D6A_5.png"
					},
					{
						"imageName": ["two-leg", "stool"],
						"imgPath": "D6A_6.png"
					},
					{
						"imageName": ["four-leg", "chair"],
						"imgPath": "D6A_2.png"
					},
					{
						"imageName": ["four-leg", "table"],
						"imgPath": "D6A_3.png"
					},
					{
						"imageName": ["four-leg", "stretcher"],
						"imgPath": "D6A_4.png"
					},
					{
						"imageName": ["two-leg", "tripad"],
						"imgPath": "D6A_7.png"
					},
				],
			},
		]
	},
	{
		"lang": "Kiswahili-Tanzania",
		"data": [
			{
				"queNo": "D1B",
				"question": " <span style='color:blue'>(Onesha kwa kidole mipira ya kijani na useme)</span> Angalia, ninaweka <b>mipira yota ya kijani</b> humu <span style='color:blue'>(Vuta na uingize mipira yote ya kijani kwenye kopo, mmoja baada ya mwingine )</span>",
				"question2": " Sasa weka <b>mipira yote yenye rangi ya njano</b> humu <span style='color:blue'>(Onesha kwenye kopo)</span> <span style='color:blue'>(Shawishi: Endapo mtoto ataacha zoezi hili kabla halijakamilika, mshawishi amalizie zoezi)</span>",
				"font": "1.6vw",
				"data": "",
				"object": ["circle"],
				"img": "",
				"jarCnt": 1,
				"colorObjects": [
					{
						"imageName": ["yellow", "circle"],
						"imgPath": "D1B_4.png"
					},
					{
						"imageName": ["blue", "circle"],
						"imgPath": "D1B_3.png"
					},
					{
						"imageName": ["green", "circle"],
						"imgPath": "D1B_2.png"
					},
				],
			},
			{
				"queNo": "D1D",
				"question": "<span style='color:blue'>(Point to the box and say)</span> Look at this carefully. Now, put all those circles <span style='color:blue'>(point to all the circles)</span> that are of the same colour as the box, one by one into the box <span style='color:blue'>(point to the box)</span>.<span style='color:blue'>(Prompt: If the child leaves the task midway, ask them to complete the task.)</span>.",
				"font": "1.6vw",
				"data": "",
				"object": ["circle"],
				"img": "",
				"jarCnt": 1,
				"colorObjects": [
					{
						"imageName": ["yellow", "circle"],
						"imgPath": "D1A_6.png"
					},
					{
						"imageName": ["blue", "circle"],
						"imgPath": "D1A_7.png"
					},
					{
						"imageName": ["green", "circle"],
						"imgPath": "D1A_5.png"
					},
					{
						"imageName": ["red", "circle"],
						"imgPath": "D1A_8.png"
					},
				],
			},
			{
				"queNo": "D2B",
				"question": "<span style='color:blue'>(Point to the different shapes and say)</span> Look, I am putting all the circles <span style='color:blue'>(point to the circles)</span> in this box <span style='color:blue'>(drag and drop all the circles one by one inside the box)</span>.",
				"question2": "Now, like I did, you have to put all the triangles in this box <span style='color:blue'>(point to the box)</span>. <span style='color:blue'>(Prompt: If the child leaves the task midway, ask them to complete the task)</span>.",
				"font": "1.6vw",
				"data": "",
				"object": ["circle"],
				"img": "",
				"jarCnt": 1,
				"colorObjects": [
					{
						"imageName": ["triange", "triangle"],
						"imgPath": "D2B_4.png"
					},
					{
						"imageName": ["rectangle", "rectangle"],
						"imgPath": "D2B_2.png"
					},
					{
						"imageName": ["circle", "circle"],
						"imgPath": "D2B_3.png"
					},
				],
			},
			{
				"queNo": "D3A",
				"question": " <span style='color:blue'>(Onesha wanyama na ndege na useme)</span> Angalia Angalia hapa kwa makini.Sasa, weka ndege wote humu <span style='color:blue'>(onesha sehemu ya ndege)</span> na wanyama wote humu <span style='color:blue'>(Onesha sehemu ya wanyama)</span>. <span style='color:blue'>(Shawishi: Endapo mtoto ataacha zoezi bila kumaliza, mshawishi amalize zoezi)</span>",
				"font": "1.6vw",
				"data": "",
				"object": ["bird", "animal"],
				"img": "",
				"jarCnt": 2,
				"animalText": "Wanyama",
				"birdText": "Ndege",
				"colorObjects": [
					{
						"imageName": ["animal", "cow"],
						"imgPath": "D3A_1.png"
					},
					{
						"imageName": ["bird", "cock"],
						"imgPath": "D3A_2.png"
					},
					{
						"imageName": ["animal", "elephant"],
						"imgPath": "D3A_3.png"
					},
					{
						"imageName": ["bird", "crow"],
						"imgPath": "D3A_4.png"
					},
					{
						"imageName": ["animal", "cat"],
						"imgPath": "D3A_5.png"
					},
					{
						"imageName": ["bird", "pigon"],
						"imgPath": "D3A_6.png"
					},
				],
			},
			{
				"queNo": "D3B",
				"question": "<span style='color:blue'>(Onesha vitu na useme)</span> Angalia hivi vitu kwa makini. Sasa, weka matunda yote humu <span style='color:blue'>(onesha kwenye sehemu ya matunda )</span> na mboga zote humu <span style='color:blue'>(Onesha sehemu ya mbogamboga)</span>. <span style='color:blue'>(Shawishi: Endapo mtoto ataacha zoezi katikati, mshawishi amalize zoezi.)</span>",
				"font": "1.6vw",
				"data": "",
				"object": ["fruit", "vegetable"],
				"img": "",
				"jarCnt": 2,
				"fruitText": "Matunda",
				"vegText": "Mboga",
				"colorObjects": [
					{
						"imageName": ["fruit", "orange"],
						"imgPath": "D3B_4.png"
					},
					{
						"imageName": ["fruit", "banana"],
						"imgPath": "D3B_5.png"
					},
					{
						"imageName": ["fruit", "mango"],
						"imgPath": "D3B_6.png"
					},
					{
						"imageName": ["vegetable", "carrot"],
						"imgPath": "D3B_2.png"
					},
					{
						"imageName": ["vegetable", "potato"],
						"imgPath": "D3B_7.png"
					},
					{
						"imageName": ["vegetable", "bringal"],
						"imgPath": "D3B_9.png"
					},
				],
			},
			// {
			// 	"queNo": "D3C",
			// 	"question": 'Look at these <span style="color:blue">(point to the objects)</span>. Put all the items that can be worn here <span style="color:blue">(point to the ‘things that can be worn’ section)</span>and all the items that cannot be worn here <span style="color:blue">(point to the ‘things that cannot be worn’ section)</span>.<span style="color:blue">(Prompt: If the child stops after sorting some objects, ask her to do the same for all objects).</span>',
			// 	"font": "1.6vw",
			// 	"data": "",
			// 	"object": ["worn", "notWorn"],
			// 	"img": "",
			// 	"jarCnt": 2,
			// 	"colorObjects": [
			// 		{
			// 			"imageName": ["worn", "cap"],
			// 			"imgPath": "D3C_2.png"
			// 		},
			// 		{
			// 			"imageName": ["worn", "dress"],
			// 			"imgPath": "D3C_6.png"
			// 		},
			// 		{
			// 			"imageName": ["worn", "shirt"],
			// 			"imgPath": "D3C_5.png"
			// 		},
			// 		{
			// 			"imageName": ["notWorn", "pillow"],
			// 			"imgPath": "D3C_4.png"
			// 		},
			// 		{
			// 			"imageName": ["notWorn", "mat"],
			// 			"imgPath": "D3C_7.png"
			// 		},
			// 		{
			// 			"imageName": ["notWorn", "curtain"],
			// 			"imgPath": "D3C_8.png"
			// 		},
			// 	],
			// },
			{
				"queNo": "D4A",
				"question": " <span style='color:blue'>(Onesha kwa kidole pembe tatu za rangi ya bluu na useme)</span> Angalia, ninaweka pembetatu zote za rangi ya bluu humu <span style='color:blue'>(Vuta na uingize pembetatu zote za bluu kwenye kopo, moja baada ya nyingine)</span>",
				"question2": " Sasa weka <b>maduara yote ya rangi nyekundu</b> humu <span style='color:blue'>(Onesha kwenye kopo)</span> <span style='color:blue'>(Shawishi: Endapo mtoto ataacha zoezi kabla hajamaliza, mshawishi amalizie zoezi)</span>",
				"font": "1.6vw",
				"data": "",
				"object": ["circle-red"],
				"img": "",
				"jarCnt": 1,
				"colorObjects": [
					{
						"imageName": ["triange-yellow", "triangle"],
						"imgPath": "D4A_3.png"
					},
					{
						"imageName": ["triange-blue", "triangle"],
						"imgPath": "D4A_4.png"
					},
					{
						"imageName": ["triange-blue", "triangle"],
						"imgPath": "D4A_4.png"
					},
					{
						"imageName": ["triange-red", "triangle"],
						"imgPath": "D4A_5.png"
					},
					{
						"imageName": ["circle-red", "circle"],
						"imgPath": "D4A_2.png"
					},
					{
						"imageName": ["circle-red", "circle"],
						"imgPath": "D4A_2.png"
					},
					{
						"imageName": ["circle-blue", "circle"],
						"imgPath": "D4A_6.png"
					},
					{
						"imageName": ["circle-yellow", "circle"],
						"imgPath": "D4A_7.png"
					},
				],
			},
			{
				"queNo": "D4B",
				"question": " <span style='color:blue'>(Point to the blue coloured triangles and say)</span> Look I am putting all the blue-coloured triangles here <span style='color:blue'>(drag and drop all blue coloured triangles one by one into the box)</span>.",
				"question2": "Now, like I did, you have to put all the yellow-coloured squares in this box <span style='color:blue'>(point to the box)</span>.<span style='color:blue'>(Prompt: If the child leaves the task midway, ask them to complete the task.)</span>.",
				"font": "1.6vw",
				"data": "",
				"object": ["rectangle-yellow"],
				"img": "",
				"jarCnt": 1,
				"colorObjects": [
					{
						"imageName": ["triange-yellow", "triangle"],
						"imgPath": "D4B_3.png"
					},
					{
						"imageName": ["triange-yellow", "triangle"],
						"imgPath": "D4B_3.png"
					},
					{
						"imageName": ["triange-blue", "triangle"],
						"imgPath": "D4B_6.png"
					},
					{
						"imageName": ["rectangle-yellow", "rectangle"],
						"imgPath": "D4B_7.png"
					},
					{
						"imageName": ["rectangle-yellow", "rectangle"],
						"imgPath": "D4B_7.png"
					},
					{
						"imageName": ["rectangle-yellow", "rectangle"],
						"imgPath": "D4B_7.png"
					},
					{
						"imageName": ["rectangle-red", "rectangle"],
						"imgPath": "D4B_4.png"
					},
					{
						"imageName": ["circle-red", "circle"],
						"imgPath": "D4B_5.png"
					},
					{
						"imageName": ["circle-red", "circle"],
						"imgPath": "D4B_5.png"
					}, {
						"imageName": ["circle-red", "circle"],
						"imgPath": "D4B_5.png"
					},
					{
						"imageName": ["circle-blue", "circle"],
						"imgPath": "D4B_8.png"
					},
					{
						"imageName": ["circle-yellow", "circle"],
						"imgPath": "D4B_1.png"
					},

				],
			},
			{
				"queNo": "D6A",
				"question": " <span style='color:blue'>(Onesha kwa kidole wanyamana useme)</span> Angalia hapa kwa makini. Sasa weka wanyama wote wenye <b>miguu minne</b> humu <span style='color:blue'>(Onesha eneo lililozungushiwa uzio)</span> <span style='color:blue'>(Shawishi: endapo mtoto ataacha zoezi bila kumaliza, mshawishi amalizie)</span>",
				"font": "1.6vw",
				"data": "",
				"object": ["four-leg"],
				"img": "",
				"jarCnt": 1,
				"colorObjects": [
					{
						"imageName": ["two-leg", "lamp"],
						"imgPath": "D6A_5.png"
					},
					{
						"imageName": ["two-leg", "stool"],
						"imgPath": "D6A_6.png"
					},
					{
						"imageName": ["four-leg", "chair"],
						"imgPath": "D6A_2.png"
					},
					{
						"imageName": ["four-leg", "table"],
						"imgPath": "D6A_3.png"
					},
					{
						"imageName": ["four-leg", "stretcher"],
						"imgPath": "D6A_4.png"
					},
					{
						"imageName": ["two-leg", "tripad"],
						"imgPath": "D6A_7.png"
					},
				],
			},
		]
	},
	{
		"lang": "Urdu-Pakistan",
		"data": [
			{
				"queNo": "D1B",
				"question": " <span style='color:blue'>(سبز گیندوں کی طرف اشارہ کریں اور بولیں)</span> دیکھو، میں تمام <b>ہری گیندیں</b> یہاں ڈال رہا / رہی ہوں <span style='color:blue'>(سب سبز گیندوں کو ایک ایک کرکے جار میں ڈال دیں)</span>۔",
				"question2": " اب، تمام <b>پیلے رنگ کی گیندوں</b> کو یہاں <span style='color:blue'>(جار کی طرف اشارہ کریں)</span> رکھ دیں۔<span style='color:blue'>( اگر بچہ کام کو درمیان میں چھوڑ دیتا ہے، تو اس سے کام مکمل کرنے کو کہیں)</span>",
				"font": "1.6vw",
				"data": "",
				"object": ["circle"],
				"img": "",
				"jarCnt": 1,
				"colorObjects": [
					{
						"imageName": ["yellow", "circle"],
						"imgPath": "D1B_4.png"
					},
					{
						"imageName": ["blue", "circle"],
						"imgPath": "D1B_3.png"
					},
					{
						"imageName": ["green", "circle"],
						"imgPath": "D1B_2.png"
					},
				],
			},
			{
				"queNo": "D1D",
				"question": " <span style='color:blue'>(ڈبے کی طرف اشارہ کریں اور کہیں)</span>اسے غور سے دیکھو اور اب وہ تمام دائرے <span style='color:blue'>(دائروں کی طرف اشارہ کرتے ہوئے)</span> جو ڈبے کے رنگ کی طرح ہیں ایک ایک کر کے ڈبے<span style='color:blue'>(ڈبے کی طرف اشارہ کریں)</span> میں ڈالیں<span style='color:blue'>(اشارہ: اگر بچہ کہیں دارمیان میں یہ کام چھوڑ دیتا ہے تو اسے کام مکمل کرنے کو کہیں)</span>",
				"font": "1.6vw",
				"data": "",
				"object": ["circle"],
				"img": "",
				"jarCnt": 1,
				"colorObjects": [
					{
						"imageName": ["yellow", "circle"],
						"imgPath": "D1A_6.png"
					},
					{
						"imageName": ["blue", "circle"],
						"imgPath": "D1A_7.png"
					},
					{
						"imageName": ["green", "circle"],
						"imgPath": "D1A_5.png"
					},
					{
						"imageName": ["red", "circle"],
						"imgPath": "D1A_8.png"
					},
				],
			},
			{
				"queNo": "D2B",
				"question": "<span style='color:blue'>(مختلف اشکال کی طرف اشارہ کریں اور کہیں)</span> دیکھو، میں تمام دائرے <span style='color:blue'>(دائروں کی طرف اشارہ کریں)</span> اس ڈبے میں ڈال رہا/رہی ہوں <span style='color:blue'>(ایک ایک کر کے تمام دائرے پکڑ کر ڈبے میں ڈالیں)</span>۔",
				"question2": " جیسے میں نے کیا اسی طرح اب آپ تمام مثلثوں کو اس ڈبے <span style='color:blue'>(ڈبے کی طرف اشارہ کریں)</span> میں ڈالیں۔ <span style='color:blue'>(اشارہ: اگر بچہ کہیں دارمیان میں یہ کام چھوڑ دیتا ہے تو اسے کام مکمل کرنے کو کہیں)</span>",
				"font": "1.6vw",
				"data": "",
				"object": ["circle"],
				"img": "",
				"jarCnt": 1,
				"colorObjects": [
					{
						"imageName": ["triange", "triangle"],
						"imgPath": "D2B_4.png"
					},
					{
						"imageName": ["rectangle", "rectangle"],
						"imgPath": "D2B_2.png"
					},
					{
						"imageName": ["circle", "circle"],
						"imgPath": "D2B_3.png"
					},
				],
			},
			{
				"queNo": "D3A",
				"question": " <span style='color:blue'>( جانوروں اور پرندوں کی طرف اشارہ کریں اور کہیں)</span> انہیں غور سے دیکھو اور تمام پرندوں کو یہاں <span style='color:blue'>( پرندوں والے حصہ کی طرف اشارہ کرتے ہوئے)</span> رکھو اور تمام جانوروں کو یہاں <span style='color:blue'>( جانوروں والے حصہ کی طرف اشارہ کرتے ہوئے)</span>۔</span>(ہدایت: اگر بچہ کہیں درمیان میں یہ ٹاسک چھوڑ دیتا ہے تو اسے ٹاسک مکمل کرنے کو کہیں)<span style='color:blue'>",
				"font": "1.6vw",
				"data": "",
				"object": ["bird", "animal"],
				"img": "",
				"jarCnt": 2,
				"animalText": "جانور",
				"birdText": "پرندے",
				"colorObjects": [
					{
						"imageName": ["animal", "cow"],
						"imgPath": "D3A_1.png"
					},
					{
						"imageName": ["bird", "cock"],
						"imgPath": "D3A_2.png"
					},
					{
						"imageName": ["animal", "elephant"],
						"imgPath": "D3A_3.png"
					},
					{
						"imageName": ["bird", "crow"],
						"imgPath": "D3A_4.png"
					},
					{
						"imageName": ["animal", "cat"],
						"imgPath": "D3A_5.png"
					},
					{
						"imageName": ["bird", "pigon"],
						"imgPath": "D3A_6.png"
					},
				],
			},
			{
				"queNo": "D3B",
				"question": " <span style='color:blue'>(دی گئی چیزوں کی طرف اشارہ کریں اور کہیں)</span> انہیں غور سے دیکھو اور تمام پھلوں کو یہاں رکھو <span style='color:blue'>(پھلوں والے حصہ کی طرف اشارہ کرتے ہوئے)</span> اور تمام سبزیوں کو یہاں <span style='color:blue'>(سبزیوں والے حصہ کی طرف اشارہ کرتے ہوئے)</span>۔<span style='color:blue'>(ہدایت: اگر بچہ کہیں درمیان میں یہ ٹاسک چھوڑ دیتا ہے تو اسے ٹاسک مکمل کرنے کو کہیں)</span>",
				"font": "1.6vw",
				"data": "",
				"object": ["fruit", "vegetable"],
				"img": "",
				"jarCnt": 2,
				"fruitText": "پھل",
				"vegText": "سبزیاں",
				"colorObjects": [
					{
						"imageName": ["fruit", "orange"],
						"imgPath": "D3B_4.png"
					},
					{
						"imageName": ["fruit", "banana"],
						"imgPath": "D3B_5.png"
					},
					{
						"imageName": ["fruit", "mango"],
						"imgPath": "D3B_6.png"
					},
					{
						"imageName": ["vegetable", "carrot"],
						"imgPath": "D3B_2.png"
					},
					{
						"imageName": ["vegetable", "potato"],
						"imgPath": "D3B_7.png"
					},
					{
						"imageName": ["vegetable", "bringal"],
						"imgPath": "D3B_9.png"
					},
				],
			},
			{
				"queNo": "D4A",
				"question": " <span style='color:blue'>(نیلے مثلث کی طرف اشارہ کریں اور بولیں)</span> دیکھو، میں تمام <b>نیلے مثلث</b> یہاں ڈال رہا / رہی ہوں <span style='color:blue'>(تمام نیلے مثلثوں کو ایک ایک کر کے دیے گئے جار میں ڈال دیں)</span>",
				"question2": " 'اب آپ تمام <b>سرخ دائروں</b> کو یہاں <span style='color:blue'>(جار کی طرف اشارہ کریں)</span> رکھ دیں۔ <span style='color:blue'>(اگر بچہ کام کو درمیان میں چھوڑ دیتا ہے، تو اس سے کام مکمل کرنے کو کہیں)</span>'",
				"font": "1.6vw",
				"data": "",
				"object": ["circle-red"],
				"img": "",
				"jarCnt": 1,
				"colorObjects": [
					{
						"imageName": ["triange-yellow", "triangle"],
						"imgPath": "D4A_3.png"
					},
					{
						"imageName": ["triange-blue", "triangle"],
						"imgPath": "D4A_4.png"
					},
					{
						"imageName": ["triange-blue", "triangle"],
						"imgPath": "D4A_4.png"
					},
					{
						"imageName": ["triange-red", "triangle"],
						"imgPath": "D4A_5.png"
					},
					{
						"imageName": ["circle-red", "circle"],
						"imgPath": "D4A_2.png"
					},
					{
						"imageName": ["circle-red", "circle"],
						"imgPath": "D4A_2.png"
					},
					{
						"imageName": ["circle-blue", "circle"],
						"imgPath": "D4A_6.png"
					},
					{
						"imageName": ["circle-yellow", "circle"],
						"imgPath": "D4A_7.png"
					},
				],
			},
			{
				"queNo": "D4B",
				"question": " <span style='color:blue'>(نیلے رنگ کی مثلثوں کی طراف اشارہ کریں اور کہیں)</span>دیکھو، میں نیلے رنگ کی تمام مثلثوں کو اس ڈبے میں ڈال رہا/رہی ہوں۔ <span style='color:blue'>(نیلے رنگ کی تمام مثلثوں کو ایک ایک کر کے پکڑ کر ڈبے کے اندر ڈالیں)</span>",
				"question2": " جس طرح میں نے کیا اب آپ پیلے رنگ کے تمام مربعوں کو کو اس ڈبے <span style='color:blue'>(ڈبے کی طرف اشارہ کریں)</span> میں ڈالیں۔ <span style='color:blue'>(اشارہ: اگر بچہ کہیں دارمیان میں یہ کام چھوڑ دیتا ہے تو اسے کام مکمل کرنے کو کہیں)</span>",
				"font": "1.6vw",
				"data": "",
				"object": ["rectangle-yellow"],
				"img": "",
				"jarCnt": 1,
				"colorObjects": [
					{
						"imageName": ["triange-yellow", "triangle"],
						"imgPath": "D4B_3.png"
					},
					{
						"imageName": ["triange-yellow", "triangle"],
						"imgPath": "D4B_3.png"
					},
					{
						"imageName": ["triange-blue", "triangle"],
						"imgPath": "D4B_6.png"
					},
					{
						"imageName": ["rectangle-yellow", "rectangle"],
						"imgPath": "D4B_7.png"
					},
					{
						"imageName": ["rectangle-yellow", "rectangle"],
						"imgPath": "D4B_7.png"
					},
					{
						"imageName": ["rectangle-yellow", "rectangle"],
						"imgPath": "D4B_7.png"
					},
					{
						"imageName": ["rectangle-red", "rectangle"],
						"imgPath": "D4B_4.png"
					},
					{
						"imageName": ["circle-red", "circle"],
						"imgPath": "D4B_5.png"
					},
					{
						"imageName": ["circle-red", "circle"],
						"imgPath": "D4B_5.png"
					}, {
						"imageName": ["circle-red", "circle"],
						"imgPath": "D4B_5.png"
					},
					{
						"imageName": ["circle-blue", "circle"],
						"imgPath": "D4B_8.png"
					},
					{
						"imageName": ["circle-yellow", "circle"],
						"imgPath": "D4B_1.png"
					},

				],
			},
			{
				"queNo": "D6A",
				"question": " <span style='color:blue'>(جانوروں کی طرف اشارہ کر کے بولیں)</span> ان کو غور سے دیکھو، اب ان تمام جانوروں کو جن کی <b> چار ٹانگیں </b> ہیں یہاں <span style='color:blue'>(باڑ والے حصے کی طرف اشارہ کریں)</span> رکھ دیں۔ <span style='color:blue'>(اگر بچہ کام کو درمیان میں چھوڑ دیتا ہے، تو اس سے ٹاسک مکمل کرنے کو کہیں)</span>",
				"font": "1.6vw",
				"data": "",
				"object": ["four-leg"],
				"img": "",
				"jarCnt": 1,
				"colorObjects": [
					{
						"imageName": ["two-leg", "lamp"],
						"imgPath": "D6A_5.png"
					},
					{
						"imageName": ["two-leg", "stool"],
						"imgPath": "D6A_6.png"
					},
					{
						"imageName": ["four-leg", "chair"],
						"imgPath": "D6A_2.png"
					},
					{
						"imageName": ["four-leg", "table"],
						"imgPath": "D6A_3.png"
					},
					{
						"imageName": ["four-leg", "stretcher"],
						"imgPath": "D6A_4.png"
					},
					{
						"imageName": ["two-leg", "tripad"],
						"imgPath": "D6A_7.png"
					},
				],
			},
		]
	},
	{
		"lang": "Spanish-Mexico",
		"data": [
			{
				"queNo": "D1B",
				"question": " <span style='color:blue'>(Señala las pelotas verdes y di)</span> Mira, estoy poniendo todas las <b>pelotas verdes</b> aquí <span style='color:blue'>(Arrastra y suelta todas las pelotas verdes, una por una, en el frasco)</span>.",
				"question2": " Ahora, pon todas las <b>pelotas amarillas</b> aquí <span style='color:blue'>(señala el frasco)</span>.<span style='color:blue'>.(Instrucción: Si el(la) niño(a) deja la tarea a medias, pídele que la complete)</span>",
				"font": "1.6vw",
				"data": "",
				"object": ["circle"],
				"img": "",
				"jarCnt": 1,
				"colorObjects": [
					{
						"imageName": ["yellow", "circle"],
						"imgPath": "D1B_4.png"
					},
					{
						"imageName": ["blue", "circle"],
						"imgPath": "D1B_3.png"
					},
					{
						"imageName": ["green", "circle"],
						"imgPath": "D1B_2.png"
					},
				],
			},
			{
				"queNo": "D1D",
				"question": "<span style='color:blue'>(Point to the box and say)</span> Look at this carefully. Now, put all those circles <span style='color:blue'>(point to all the circles)</span> that are of the same colour as the box, one by one into the box <span style='color:blue'>(point to the box)</span>.<span style='color:blue'>(Prompt: If the child leaves the task midway, ask them to complete the task.)</span>.",
				"font": "1.6vw",
				"data": "",
				"object": ["circle"],
				"img": "",
				"jarCnt": 1,
				"colorObjects": [
					{
						"imageName": ["yellow", "circle"],
						"imgPath": "D1A_6.png"
					},
					{
						"imageName": ["blue", "circle"],
						"imgPath": "D1A_7.png"
					},
					{
						"imageName": ["green", "circle"],
						"imgPath": "D1A_5.png"
					},
					{
						"imageName": ["red", "circle"],
						"imgPath": "D1A_8.png"
					},
				],
			},
			{
				"queNo": "D2B",
				"question": "<span style='color:blue'>(Point to the different shapes and say)</span> Look, I am putting all the circles <span style='color:blue'>(point to the circles)</span> in this box <span style='color:blue'>(drag and drop all the circles one by one inside the box)</span>.",
				"question2": "Now, like I did, you have to put all the triangles in this box <span style='color:blue'>(point to the box)</span>. <span style='color:blue'>(Prompt: If the child leaves the task midway, ask them to complete the task)</span>.",
				"font": "1.6vw",
				"data": "",
				"object": ["circle"],
				"img": "",
				"jarCnt": 1,
				"colorObjects": [
					{
						"imageName": ["triange", "triangle"],
						"imgPath": "D2B_4.png"
					},
					{
						"imageName": ["rectangle", "rectangle"],
						"imgPath": "D2B_2.png"
					},
					{
						"imageName": ["circle", "circle"],
						"imgPath": "D2B_3.png"
					},
				],
			},
			{
				"queNo": "D3A",
				"question": " <span style='color:blue'>(Point to the animals and birds and say)</span> Look at these carefully. Now, put all the birds here <span style='color:blue'>(point to the birds section)</span> and all the animals here <span style='color:blue'>(point to the animals section)</span>. <span style='color:blue'>(Prompt: If the child leaves the task midway, ask them to complete the task)</span>",
				"font": "1.6vw",
				"data": "",
				"object": ["bird", "animal"],
				"img": "",
				"jarCnt": 2,
				"animalText": "Animals",
				"birdText": "Birds",
				"colorObjects": [
					{
						"imageName": ["animal", "cow"],
						"imgPath": "D3A_1.png"
					},
					{
						"imageName": ["bird", "cock"],
						"imgPath": "D3A_2.png"
					},
					{
						"imageName": ["animal", "elephant"],
						"imgPath": "D3A_3.png"
					},
					{
						"imageName": ["bird", "crow"],
						"imgPath": "D3A_4.png"
					},
					{
						"imageName": ["animal", "cat"],
						"imgPath": "D3A_5.png"
					},
					{
						"imageName": ["bird", "pigon"],
						"imgPath": "D3A_6.png"
					},
				],
			},
			{
				"queNo": "D3B",
				"question": " <span style='color:blue'>(Point to the objects and say)</span> Look at these carefully. Now, put all the fruits here <span style='color:blue'>(point to the fruits section)</span> and all the vegetables here <span style='color:blue'>(point to the vegetables section)</span>. <span style='color:blue'>(Prompt: If the child leaves the task midway, ask them to complete the task.)</span>",
				"font": "1.6vw",
				"data": "",
				"object": ["fruit", "vegetable"],
				"img": "",
				"jarCnt": 2,
				"fruitText": "Fruits",
				"vegText": "Vegetables",
				"colorObjects": [
					{
						"imageName": ["fruit", "orange"],
						"imgPath": "D3B_4.png"
					},
					{
						"imageName": ["fruit", "banana"],
						"imgPath": "D3B_5.png"
					},
					{
						"imageName": ["fruit", "mango"],
						"imgPath": "D3B_6.png"
					},
					{
						"imageName": ["vegetable", "carrot"],
						"imgPath": "D3B_2.png"
					},
					{
						"imageName": ["vegetable", "potato"],
						"imgPath": "D3B_7.png"
					},
					{
						"imageName": ["vegetable", "bringal"],
						"imgPath": "D3B_9.png"
					},
				],
			},
			{
				"queNo": "D4A",
				"question": " <span style='color:blue'>(Señala los triángulos azules y di)</span> Mira, estoy poniendo todos los <b>triángulos azules</b> aquí <span style='color:blue'>(Arrastra y suelta todos los triángulos azules, uno por uno, en  el frasco)</span>.",
				"question2": " Ahora, pon todos los <b>círculos rojos</b> aquí <span style='color:blue'>(señala el frasco)</span>. <span style='color:blue'>(Instrucción: Si el(la) niño(a) deja la tarea a medias, pídele que la complete)</span>.",
				"font": "1.6vw",
				"data": "",
				"object": ["circle-red"],
				"img": "",
				"jarCnt": 1,
				"colorObjects": [
					{
						"imageName": ["triange-yellow", "triangle"],
						"imgPath": "D4A_3.png"
					},
					{
						"imageName": ["triange-blue", "triangle"],
						"imgPath": "D4A_4.png"
					},
					{
						"imageName": ["triange-blue", "triangle"],
						"imgPath": "D4A_4.png"
					},
					{
						"imageName": ["triange-red", "triangle"],
						"imgPath": "D4A_5.png"
					},
					{
						"imageName": ["circle-red", "circle"],
						"imgPath": "D4A_2.png"
					},
					{
						"imageName": ["circle-red", "circle"],
						"imgPath": "D4A_2.png"
					},
					{
						"imageName": ["circle-blue", "circle"],
						"imgPath": "D4A_6.png"
					},
					{
						"imageName": ["circle-yellow", "circle"],
						"imgPath": "D4A_7.png"
					},
				],
			},
			{
				"queNo": "D4B",
				"question": "<span style='color:blue'>(Point to the blue triangles and say)</span> Look, I am putting all the <b>blue triangles</b> here <span style='color:blue'>(Drag and drop all the blue triangles one by one into the jar)</span>.",
				"question2": " Now, put all the <b>red circles</b> here <span style='color:blue'>(Point to the jar)</span> </span>(Prompt: If the child leaves the task midway, ask them to complete the task)<span style='color:blue'>.",
				"font": "1.6vw",
				"data": "",
				"object": ["rectangle-yellow"],
				"img": "",
				"jarCnt": 1,
				"colorObjects": [
					{
						"imageName": ["triange-yellow", "triangle"],
						"imgPath": "D4B_3.png"
					},
					{
						"imageName": ["triange-yellow", "triangle"],
						"imgPath": "D4B_3.png"
					},
					{
						"imageName": ["triange-blue", "triangle"],
						"imgPath": "D4B_6.png"
					},
					{
						"imageName": ["rectangle-yellow", "rectangle"],
						"imgPath": "D4B_7.png"
					},
					{
						"imageName": ["rectangle-yellow", "rectangle"],
						"imgPath": "D4B_7.png"
					},
					{
						"imageName": ["rectangle-yellow", "rectangle"],
						"imgPath": "D4B_7.png"
					},
					{
						"imageName": ["rectangle-red", "rectangle"],
						"imgPath": "D4B_4.png"
					},
					{
						"imageName": ["circle-red", "circle"],
						"imgPath": "D4B_5.png"
					},
					{
						"imageName": ["circle-red", "circle"],
						"imgPath": "D4B_5.png"
					}, {
						"imageName": ["circle-red", "circle"],
						"imgPath": "D4B_5.png"
					},
					{
						"imageName": ["circle-blue", "circle"],
						"imgPath": "D4B_8.png"
					},
					{
						"imageName": ["circle-yellow", "circle"],
						"imgPath": "D4B_1.png"
					},

				],
			},
			{
				"queNo": "D6A",
				"question": " <span style='color:blue'>(Señala los animales y di)</span> Obsérvalos con atención. Ahora, pon a todos los animales que tengan <b>cuatro patas</b> aquí <span style='color:blue'>(señala la zona cercada)</span>. <span style='color:blue'>(Instrucción: Si el(la) niño(a) deja la tarea a medias, pídele que la complete)</span>.",
				"font": "1.6vw",
				"data": "",
				"object": ["four-leg"],
				"img": "",
				"jarCnt": 1,
				"colorObjects": [
					{
						"imageName": ["two-leg", "lamp"],
						"imgPath": "D6A_5.png"
					},
					{
						"imageName": ["two-leg", "stool"],
						"imgPath": "D6A_6.png"
					},
					{
						"imageName": ["four-leg", "chair"],
						"imgPath": "D6A_2.png"
					},
					{
						"imageName": ["four-leg", "table"],
						"imgPath": "D6A_3.png"
					},
					{
						"imageName": ["four-leg", "stretcher"],
						"imgPath": "D6A_4.png"
					},
					{
						"imageName": ["two-leg", "tripad"],
						"imgPath": "D6A_7.png"
					},
				],
			},
		]
	}, {
		"lang": "Spanish-Nicaragua",
		'languageFont': 'fonts/AntarcticaRegular.ttf',
		"data": [
			{
				"queNo": "D1B",
				"question": " <span style='color:blue'>(Señale las bolas verdes y diga)</span> Mirá, voy a poner todas las <b>bolas verdes</b> aquí <span style='color:blue'>(Arrastre y suelte todas las bolas verdes una por una en el tarro)</span>.",
				"question2": " Ahora, poné todas las <b>bolas amarillas</b> aquí <span style='color:blue'>(señale el frasco)</span>. <span style='color:blue'>(Indicación: Si el niño o la niña deja la tarea a mitad de camino, pídale que la complete)</span>.",
				"font": "1.6vw",
				"data": "",
				"object": ["circle"],
				"img": "",
				"jarCnt": 1,
				"colorObjects": [
					{
						"imageName": ["yellow", "circle"],
						"imgPath": "D1B_4.png"
					},
					{
						"imageName": ["blue", "circle"],
						"imgPath": "D1B_3.png"
					},
					{
						"imageName": ["green", "circle"],
						"imgPath": "D1B_2.png"
					},
				],
			},
			{
				"queNo": "D1D",
				"question": "<span style='color:blue'>(Point to the box and say)</span> Look at this carefully. Now, put all those circles <span style='color:blue'>(point to all the circles)</span> that are of the same colour as the box, one by one into the box <span style='color:blue'>(point to the box)</span>.<span style='color:blue'>(Prompt: If the child leaves the task midway, ask them to complete the task.)</span>.",
				"font": "1.6vw",
				"data": "",
				"object": ["circle"],
				"img": "",
				"jarCnt": 1,
				"colorObjects": [
					{
						"imageName": ["yellow", "circle"],
						"imgPath": "D1A_6.png"
					},
					{
						"imageName": ["blue", "circle"],
						"imgPath": "D1A_7.png"
					},
					{
						"imageName": ["green", "circle"],
						"imgPath": "D1A_5.png"
					},
					{
						"imageName": ["red", "circle"],
						"imgPath": "D1A_8.png"
					},
				],
			},
			{
				"queNo": "D2B",
				"question": "<span style='color:blue'>(Point to the different shapes and say)</span> Look, I am putting all the circles <span style='color:blue'>(point to the circles)</span> in this box <span style='color:blue'>(drag and drop all the circles one by one inside the box)</span>.",
				"question2": "Now, like I did, you have to put all the triangles in this box <span style='color:blue'>(point to the box)</span>. <span style='color:blue'>(Prompt: If the child leaves the task midway, ask them to complete the task)</span>.",
				"font": "1.6vw",
				"data": "",
				"object": ["circle"],
				"img": "",
				"jarCnt": 1,
				"colorObjects": [
					{
						"imageName": ["triange", "triangle"],
						"imgPath": "D2B_4.png"
					},
					{
						"imageName": ["rectangle", "rectangle"],
						"imgPath": "D2B_2.png"
					},
					{
						"imageName": ["circle", "circle"],
						"imgPath": "D2B_3.png"
					},
				],
			},
			{
				"queNo": "D3A",
				"question": " <span style='color:blue'>(Point to the animals and birds and say)</span> Look at these carefully. Now, put all the birds here <span style='color:blue'>(point to the birds section)</span> and all the animals here <span style='color:blue'>(point to the animals section)</span>. <span style='color:blue'>(Prompt: If the child leaves the task midway, ask them to complete the task)</span>",
				"font": "1.6vw",
				"data": "",
				"object": ["bird", "animal"],
				"img": "",
				"jarCnt": 2,
				"animalText": "Animals",
				"birdText": "Birds",
				"colorObjects": [
					{
						"imageName": ["animal", "cow"],
						"imgPath": "D3A_1.png"
					},
					{
						"imageName": ["bird", "cock"],
						"imgPath": "D3A_2.png"
					},
					{
						"imageName": ["animal", "elephant"],
						"imgPath": "D3A_3.png"
					},
					{
						"imageName": ["bird", "crow"],
						"imgPath": "D3A_4.png"
					},
					{
						"imageName": ["animal", "cat"],
						"imgPath": "D3A_5.png"
					},
					{
						"imageName": ["bird", "pigon"],
						"imgPath": "D3A_6.png"
					},
				],
			},
			{
				"queNo": "D3B",
				"question": " <span style='color:blue'>(Point to the objects and say)</span> Look at these carefully. Now, put all the fruits here <span style='color:blue'>(point to the fruits section)</span> and all the vegetables here <span style='color:blue'>(point to the vegetables section)</span>. <span style='color:blue'>(Prompt: If the child leaves the task midway, ask them to complete the task.)</span>",
				"font": "1.6vw",
				"data": "",
				"object": ["fruit", "vegetable"],
				"img": "",
				"jarCnt": 2,
				"fruitText": "Fruits",
				"vegText": "Vegetables",
				"colorObjects": [
					{
						"imageName": ["fruit", "orange"],
						"imgPath": "D3B_4.png"
					},
					{
						"imageName": ["fruit", "banana"],
						"imgPath": "D3B_5.png"
					},
					{
						"imageName": ["fruit", "mango"],
						"imgPath": "D3B_6.png"
					},
					{
						"imageName": ["vegetable", "carrot"],
						"imgPath": "D3B_2.png"
					},
					{
						"imageName": ["vegetable", "potato"],
						"imgPath": "D3B_7.png"
					},
					{
						"imageName": ["vegetable", "bringal"],
						"imgPath": "D3B_9.png"
					},
				],
			},
			{
				"queNo": "D4A",
				"question": " <span style='color:blue'>(Señale los triángulos azules y diga)</span> Mirá, estoy poniendo todos los <b>triángulos azules</b> aquí <span style='color:blue'>(Arrastre y suelte todos los triángulos azules uno por uno en el tarro)</span>",
				"question2": " Ahora, poné todos los <b>círculos rojos</b> aquí <span style='color:blue'>(Señale el frasco)</span> <span style='color:blue'>(Indicación: Si el niño o la niña deja la tarea a mitad de camino, pídale que la complete)</span>",
				"font": "1.6vw",
				"data": "",
				"object": ["circle-red"],
				"img": "",
				"jarCnt": 1,
				"colorObjects": [
					{
						"imageName": ["triange-yellow", "triangle"],
						"imgPath": "D4A_3.png"
					},
					{
						"imageName": ["triange-blue", "triangle"],
						"imgPath": "D4A_4.png"
					},
					{
						"imageName": ["triange-blue", "triangle"],
						"imgPath": "D4A_4.png"
					},
					{
						"imageName": ["triange-red", "triangle"],
						"imgPath": "D4A_5.png"
					},
					{
						"imageName": ["circle-red", "circle"],
						"imgPath": "D4A_2.png"
					},
					{
						"imageName": ["circle-red", "circle"],
						"imgPath": "D4A_2.png"
					},
					{
						"imageName": ["circle-blue", "circle"],
						"imgPath": "D4A_6.png"
					},
					{
						"imageName": ["circle-yellow", "circle"],
						"imgPath": "D4A_7.png"
					},
				],
			},
			{
				"queNo": "D4B",
				"question": "<span style='color:blue'>(Point to the blue triangles and say)</span> Look, I am putting all the <b>blue triangles</b> here <span style='color:blue'>(Drag and drop all the blue triangles one by one into the jar)</span>.",
				"question2": " Now, put all the <b>red circles</b> here <span style='color:blue'>(Point to the jar)</span> </span>(Prompt: If the child leaves the task midway, ask them to complete the task)<span style='color:blue'>.",
				"font": "1.6vw",
				"data": "",
				"object": ["rectangle-yellow"],
				"img": "",
				"jarCnt": 1,
				"colorObjects": [
					{
						"imageName": ["triange-yellow", "triangle"],
						"imgPath": "D4B_3.png"
					},
					{
						"imageName": ["triange-yellow", "triangle"],
						"imgPath": "D4B_3.png"
					},
					{
						"imageName": ["triange-blue", "triangle"],
						"imgPath": "D4B_6.png"
					},
					{
						"imageName": ["rectangle-yellow", "rectangle"],
						"imgPath": "D4B_7.png"
					},
					{
						"imageName": ["rectangle-yellow", "rectangle"],
						"imgPath": "D4B_7.png"
					},
					{
						"imageName": ["rectangle-yellow", "rectangle"],
						"imgPath": "D4B_7.png"
					},
					{
						"imageName": ["rectangle-red", "rectangle"],
						"imgPath": "D4B_4.png"
					},
					{
						"imageName": ["circle-red", "circle"],
						"imgPath": "D4B_5.png"
					},
					{
						"imageName": ["circle-red", "circle"],
						"imgPath": "D4B_5.png"
					}, {
						"imageName": ["circle-red", "circle"],
						"imgPath": "D4B_5.png"
					},
					{
						"imageName": ["circle-blue", "circle"],
						"imgPath": "D4B_8.png"
					},
					{
						"imageName": ["circle-yellow", "circle"],
						"imgPath": "D4B_1.png"
					},

				],
			},
			{
				"queNo": "D6A",
				"question": "<span style='color:blue'>(Señale los animales y diga)</span> Fijate bien en los animalitos. Ahora, poné todos los animales que tienen <b>cuatro patas</b> aquí <span style='color:blue'>(señale la zona cercada)</span>. <span style='color:blue'>(Indicación: si el niño o la niña deja la tarea a mitad de camino, pídale que la complete)</span>",
				"font": "1.6vw",
				"data": "",
				"object": ["four-leg"],
				"img": "",
				"jarCnt": 1,
				"colorObjects": [
					{
						"imageName": ["two-leg", "lamp"],
						"imgPath": "D6A_5.png"
					},
					{
						"imageName": ["two-leg", "stool"],
						"imgPath": "D6A_6.png"
					},
					{
						"imageName": ["four-leg", "chair"],
						"imgPath": "D6A_2.png"
					},
					{
						"imageName": ["four-leg", "table"],
						"imgPath": "D6A_3.png"
					},
					{
						"imageName": ["four-leg", "stretcher"],
						"imgPath": "D6A_4.png"
					},
					{
						"imageName": ["two-leg", "tripad"],
						"imgPath": "D6A_7.png"
					},
				],
			},
		]
	},
	{
		"lang": "Bangla-Bangladesh",
		'languageFont': 'fonts/kalpurush.ttf',
		"data": [
			{
				"queNo": "D1B",
				"question": " <span style='color:blue'>(সবুজ বলগুলোকে দেখিয়ে বলুন)</span> দেখো, আমি সবগুলো <b>সবুজ বল</b> এখানে এনে রাখছি <span style='color:blue'>(সবগুলো সবুজ বল এক এক করে টেনে এনে পাত্রের ভেতরে রাখুন)</span>।",
				"question2": " এখন, তুমিও সবগুলো <b>হলুদ বল</b> এখানে <span style='color:blue'>(পাত্রটি দেখান)</span> এনে রাখো। <span style='color:blue'>(উদ্দীপকঃ বাচ্চাটি যদি মাঝপথে থেমে যায়, তাহলে তাকে কাজটি সম্পূর্ণ করতে বলুন)</span>",
				"font": "1.6vw",
				"data": "",
				"object": ["circle"],
				"img": "",
				"jarCnt": 1,
				"colorObjects": [
					{
						"imageName": ["yellow", "circle"],
						"imgPath": "D1B_4.png"
					},
					{
						"imageName": ["blue", "circle"],
						"imgPath": "D1B_3.png"
					},
					{
						"imageName": ["green", "circle"],
						"imgPath": "D1B_2.png"
					},
				],
			},
			{
				"queNo": "D1D",
				"question": "<span style='color:blue'>(Point to the box and say)</span> Look at this carefully. Now, put all those circles <span style='color:blue'>(point to all the circles)</span> that are of the same colour as the box, one by one into the box <span style='color:blue'>(point to the box)</span>.<span style='color:blue'>(Prompt: If the child leaves the task midway, ask them to complete the task.)</span>.",
				"font": "1.6vw",
				"data": "",
				"object": ["circle"],
				"img": "",
				"jarCnt": 1,
				"colorObjects": [
					{
						"imageName": ["yellow", "circle"],
						"imgPath": "D1A_6.png"
					},
					{
						"imageName": ["blue", "circle"],
						"imgPath": "D1A_7.png"
					},
					{
						"imageName": ["green", "circle"],
						"imgPath": "D1A_5.png"
					},
					{
						"imageName": ["red", "circle"],
						"imgPath": "D1A_8.png"
					},
				],
			},
			{
				"queNo": "D2B",
				"question": "<span style='color:blue'>(Point to the different shapes and say)</span> Look, I am putting all the circles <span style='color:blue'>(point to the circles)</span> in this box <span style='color:blue'>(drag and drop all the circles one by one inside the box)</span>.",
				"question2": "Now, like I did, you have to put all the triangles in this box <span style='color:blue'>(point to the box)</span>. <span style='color:blue'>(Prompt: If the child leaves the task midway, ask them to complete the task)</span>.",
				"font": "1.6vw",
				"data": "",
				"object": ["circle"],
				"img": "",
				"jarCnt": 1,
				"colorObjects": [
					{
						"imageName": ["triange", "triangle"],
						"imgPath": "D2B_4.png"
					},
					{
						"imageName": ["rectangle", "rectangle"],
						"imgPath": "D2B_2.png"
					},
					{
						"imageName": ["circle", "circle"],
						"imgPath": "D2B_3.png"
					},
				],
			},
			{
				"queNo": "D3A",
				"question": " <span style='color:blue'>(পশু এবং পাখিগুলো দেখিয়ে বলুন)</span> মনোযোগ দিয়ে এগুলো দেখো। এখন, সব পাখিগুলো এখানে রাখো <span style='color:blue'>(পাখির ঘরটিকে দেখিয়ে বলুন)</span> এবং সব পশুগুলো এখানে রাখো <span style='color:blue'>(পশুর ঘরটিকে দেখিয়ে বলুন)</span>। <span style='color:blue'>(উদ্দীপক: যদি বাচ্চাটি মাঝপথে থেমে যায়, তবে তাকে কাজটি সম্পূর্ণ করতে বলুন)</span>",
				"font": "1.6vw",
				"data": "",
				"object": ["bird", "animal"],
				"img": "",
				"jarCnt": 2,
				"animalText": "পশু",
				"birdText": "পাখি",
				"colorObjects": [
					{
						"imageName": ["animal", "cow"],
						"imgPath": "D3A_1.png"
					},
					{
						"imageName": ["bird", "cock"],
						"imgPath": "D3A_2.png"
					},
					{
						"imageName": ["animal", "elephant"],
						"imgPath": "D3A_3.png"
					},
					{
						"imageName": ["bird", "crow"],
						"imgPath": "D3A_4.png"
					},
					{
						"imageName": ["animal", "cat"],
						"imgPath": "D3A_5.png"
					},
					{
						"imageName": ["bird", "pigon"],
						"imgPath": "D3A_6.png"
					},
				],
			},
			{
				"queNo": "D3B",
				"question": " <span style='color:blue'>(বস্তুগুলো দেখিয়ে বলুন)</span> মনোযোগ দিয়ে এগুলো দেখো। এখন, সব ফলগুলো এখানে রাখো <span style='color:blue'>(ফলের ঘরটিকে দেখিয়ে বলুন)</span> এবং সব সবজিগুলো এখানে রাখো <span style='color:blue'>(সবজির ঘরটিকে দেখিয়ে বলুন)</span>। <span style='color:blue'>(উদ্দীপক: যদি বাচ্চাটি মাঝপথে থেমে যায়, তবে তাকে কাজটি সম্পূর্ণ করতে বলুন)</span>",
				"font": "1.6vw",
				"data": "",
				"object": ["fruit", "vegetable"],
				"img": "",
				"jarCnt": 2,
				"fruitText": "ফল",
				"vegText": "সবজি",
				"colorObjects": [
					{
						"imageName": ["fruit", "orange"],
						"imgPath": "D3B_4.png"
					},
					{
						"imageName": ["fruit", "banana"],
						"imgPath": "D3B_5.png"
					},
					{
						"imageName": ["fruit", "mango"],
						"imgPath": "D3B_6.png"
					},
					{
						"imageName": ["vegetable", "carrot"],
						"imgPath": "D3B_2.png"
					},
					{
						"imageName": ["vegetable", "potato"],
						"imgPath": "D3B_7.png"
					},
					{
						"imageName": ["vegetable", "bringal"],
						"imgPath": "D3B_9.png"
					},
				],
			},
			// {
			// 	"queNo": "D3C",
			// 	"question": 'Look at these <span style="color:blue">(point to the objects)</span>. Put all the items that can be worn here <span style="color:blue">(point to the ‘things that can be worn’ section)</span>and all the items that cannot be worn here <span style="color:blue">(point to the ‘things that cannot be worn’ section)</span>.<span style="color:blue">(Prompt: If the child stops after sorting some objects, ask her to do the same for all objects).</span>',
			// 	"font": "1.6vw",
			// 	"data": "",
			// 	"object": ["worn", "notWorn"],
			// 	"img": "",
			// 	"jarCnt": 2,
			// 	"colorObjects": [
			// 		{
			// 			"imageName": ["worn", "cap"],
			// 			"imgPath": "D3C_2.png"
			// 		},
			// 		{
			// 			"imageName": ["worn", "dress"],
			// 			"imgPath": "D3C_6.png"
			// 		},
			// 		{
			// 			"imageName": ["worn", "shirt"],
			// 			"imgPath": "D3C_5.png"
			// 		},
			// 		{
			// 			"imageName": ["notWorn", "pillow"],
			// 			"imgPath": "D3C_4.png"
			// 		},
			// 		{
			// 			"imageName": ["notWorn", "mat"],
			// 			"imgPath": "D3C_7.png"
			// 		},
			// 		{
			// 			"imageName": ["notWorn", "curtain"],
			// 			"imgPath": "D3C_8.png"
			// 		},
			// 	],
			// },
			{
				"queNo": "D4A",
				"question": " <span style='color:blue'>(নীল ত্রিভুজগুলোকে দেখিয়ে বলুন)</span> দেখো, আমি সবগুলো <b>নীল ত্রিভুজ</b> এখানে এনে রাখছি <span style='color:blue'>(সবগুলো নীল ত্রিভুজ এক এক করে টেনে এনে পাত্রের ভেতরে রাখুন)</span>।",
				"question2": " এখন, তুমিও সবগুলো <b>লাল বৃত্ত</b> এখানে <span style='color:blue'>(পাত্রটি দেখান)</span> এনে রাখো। <span style='color:blue'>(উদ্দীপকঃ বাচ্চাটি যদি মাঝপথে থেমে যায়, তাহলে তাকে কাজটি সম্পূর্ণ করতে বলুন)</span>",
				"font": "1.6vw",
				"data": "",
				"object": ["circle-red"],
				"img": "",
				"jarCnt": 1,
				"colorObjects": [
					{
						"imageName": ["triange-yellow", "triangle"],
						"imgPath": "D4A_3.png"
					},
					{
						"imageName": ["triange-blue", "triangle"],
						"imgPath": "D4A_4.png"
					},
					{
						"imageName": ["triange-blue", "triangle"],
						"imgPath": "D4A_4.png"
					},
					{
						"imageName": ["triange-red", "triangle"],
						"imgPath": "D4A_5.png"
					},
					{
						"imageName": ["circle-red", "circle"],
						"imgPath": "D4A_2.png"
					},
					{
						"imageName": ["circle-red", "circle"],
						"imgPath": "D4A_2.png"
					},
					{
						"imageName": ["circle-blue", "circle"],
						"imgPath": "D4A_6.png"
					},
					{
						"imageName": ["circle-yellow", "circle"],
						"imgPath": "D4A_7.png"
					},
				],
			},
			{
				"queNo": "D4B",
				"question": " <span style='color:blue'>(Point to the blue coloured triangles and say)</span> Look I am putting all the blue-coloured triangles here <span style='color:blue'>(drag and drop all blue coloured triangles one by one into the box)</span>.",
				"question2": "Now, like I did, you have to put all the yellow-coloured squares in this box <span style='color:blue'>(point to the box)</span>.<span style='color:blue'>(Prompt: If the child leaves the task midway, ask them to complete the task.)</span>.",
				"font": "1.6vw",
				"data": "",
				"object": ["rectangle-yellow"],
				"img": "",
				"jarCnt": 1,
				"colorObjects": [
					{
						"imageName": ["triange-yellow", "triangle"],
						"imgPath": "D4B_3.png"
					},
					{
						"imageName": ["triange-yellow", "triangle"],
						"imgPath": "D4B_3.png"
					},
					{
						"imageName": ["triange-blue", "triangle"],
						"imgPath": "D4B_6.png"
					},
					{
						"imageName": ["rectangle-yellow", "rectangle"],
						"imgPath": "D4B_7.png"
					},
					{
						"imageName": ["rectangle-yellow", "rectangle"],
						"imgPath": "D4B_7.png"
					},
					{
						"imageName": ["rectangle-yellow", "rectangle"],
						"imgPath": "D4B_7.png"
					},
					{
						"imageName": ["rectangle-red", "rectangle"],
						"imgPath": "D4B_4.png"
					},
					{
						"imageName": ["circle-red", "circle"],
						"imgPath": "D4B_5.png"
					},
					{
						"imageName": ["circle-red", "circle"],
						"imgPath": "D4B_5.png"
					}, {
						"imageName": ["circle-red", "circle"],
						"imgPath": "D4B_5.png"
					},
					{
						"imageName": ["circle-blue", "circle"],
						"imgPath": "D4B_8.png"
					},
					{
						"imageName": ["circle-yellow", "circle"],
						"imgPath": "D4B_1.png"
					},

				],
			},
			{
				"queNo": "D6A",
				"question": " <span style='color:blue'>(প্রাণীগুলো দেখিয়ে বলুন)</span> এগুলো মনোযোগ দিয়ে দেখোতো। এখন, যেই প্রাণীগুলোর <b>চারটি পা</b> আছে সেই সবগুলোকে এখানে <span style='color:blue'>(বেষ্টিত এলাকাটি দেখান)</span> এনে রাখো। <span style='color:blue'>(উদ্দীপকঃ বাচ্চাটি যদি মাঝপথে থেমে যায়, তাহলে তাকে কাজটি সম্পূর্ণ করতে বলুন)</span>",
				"font": "1.6vw",
				"data": "",
				"object": ["four-leg"],
				"img": "",
				"jarCnt": 1,
				"colorObjects": [
					{
						"imageName": ["two-leg", "lamp"],
						"imgPath": "D6A_5.png"
					},
					{
						"imageName": ["two-leg", "stool"],
						"imgPath": "D6A_6.png"
					},
					{
						"imageName": ["four-leg", "chair"],
						"imgPath": "D6A_2.png"
					},
					{
						"imageName": ["four-leg", "table"],
						"imgPath": "D6A_3.png"
					},
					{
						"imageName": ["four-leg", "stretcher"],
						"imgPath": "D6A_4.png"
					},
					{
						"imageName": ["two-leg", "tripad"],
						"imgPath": "D6A_7.png"
					},
				],
			},
		]
	},
	{
		"lang": "French-Mali",
		"data": [
			{
				"queNo": "D1B",
				"question": " <span style='color:blue'>(Montre les boules vertes et dis)</span> Regarde, je mets toutes les <b>boules vertes</b> ici <span style='color:blue'>(Fais glisser et dépose toutes les boules vertes une à dans le bocal)</span>.",
				"question2": " Maintenant, mets toutes les <b>boules jaunes</b> ici <span style='color:blue'>(pointe sur le bocal)</span>.<span style='color:blue'> (Conseil : Si l’enfant quitte la tâche à mi-chemin, demande-lui de terminer la tâche)</span>",
				"font": "1.6vw",
				"data": "",
				"object": ["circle"],
				"img": "",
				"jarCnt": 1,
				"colorObjects": [
					{
						"imageName": ["yellow", "circle"],
						"imgPath": "D1B_4.png"
					},
					{
						"imageName": ["blue", "circle"],
						"imgPath": "D1B_3.png"
					},
					{
						"imageName": ["green", "circle"],
						"imgPath": "D1B_2.png"
					},
				],
			},
			{
				"queNo": "D1D",
				"question": "<span style='color:blue'>(Point to the box and say)</span> Look at this carefully. Now, put all those circles <span style='color:blue'>(point to all the circles)</span> that are of the same colour as the box, one by one into the box <span style='color:blue'>(point to the box)</span>.<span style='color:blue'>(Prompt: If the child leaves the task midway, ask them to complete the task.)</span>.",
				"font": "1.6vw",
				"data": "",
				"object": ["circle"],
				"img": "",
				"jarCnt": 1,
				"colorObjects": [
					{
						"imageName": ["yellow", "circle"],
						"imgPath": "D1A_6.png"
					},
					{
						"imageName": ["blue", "circle"],
						"imgPath": "D1A_7.png"
					},
					{
						"imageName": ["green", "circle"],
						"imgPath": "D1A_5.png"
					},
					{
						"imageName": ["red", "circle"],
						"imgPath": "D1A_8.png"
					},
				],
			},
			{
				"queNo": "D2B",
				"question": "<span style='color:blue'>(Point to the different shapes and say)</span> Look, I am putting all the circles <span style='color:blue'>(point to the circles)</span> in this box <span style='color:blue'>(drag and drop all the circles one by one inside the box)</span>.",
				"question2": "Now, like I did, you have to put all the triangles in this box <span style='color:blue'>(point to the box)</span>. <span style='color:blue'>(Prompt: If the child leaves the task midway, ask them to complete the task)</span>.",
				"font": "1.6vw",
				"data": "",
				"object": ["circle"],
				"img": "",
				"jarCnt": 1,
				"colorObjects": [
					{
						"imageName": ["triange", "triangle"],
						"imgPath": "D2B_4.png"
					},
					{
						"imageName": ["rectangle", "rectangle"],
						"imgPath": "D2B_2.png"
					},
					{
						"imageName": ["circle", "circle"],
						"imgPath": "D2B_3.png"
					},
				],
			},
			{
				"queNo": "D3A",
				"question": " <span style='color:blue'>(Regarde les animaux et les oiseaux et dis)</span> Regardez-les attentivement. Maintenant, placez tous les oiseaux ici <span style='color:blue'>(pointez sur la section des oiseaux)</span> et tous les animaux ici <span style='color:blue'>(pointez sur la section des animaux)</span>. <span style='color:blue'>(Invite : Si l'enfant quitte la tâche à mi-chemin, demandez-lui de terminer la tâche)</span>",
				"font": "1.6vw",
				"data": "",
				"object": ["bird", "animal"],
				"img": "",
				"jarCnt": 2,
				"animalText": "Animaux",
				"birdText": "Oiseaux",
				"colorObjects": [
					{
						"imageName": ["animal", "cow"],
						"imgPath": "D3A_1.png"
					},
					{
						"imageName": ["bird", "cock"],
						"imgPath": "D3A_2.png"
					},
					{
						"imageName": ["animal", "elephant"],
						"imgPath": "D3A_3.png"
					},
					{
						"imageName": ["bird", "crow"],
						"imgPath": "D3A_4.png"
					},
					{
						"imageName": ["animal", "cat"],
						"imgPath": "D3A_5.png"
					},
					{
						"imageName": ["bird", "pigon"],
						"imgPath": "D3A_6.png"
					},
				],
			},
			{
				"queNo": "D3B",
				"question": " <span style='color:blue'>(Regarde les objets et dis)</span> Regarde-les attentivement. Maintenant, place tous les fruits ici <span style='color:blue'>(pointe sur la section des fruits)</span> et tous les légumes ici <span style='color:blue'>(pointe sur la section des légumes)</span>.<span style='color:blue'>(Invite : Si l'enfant quitte la tâche à mi-chemin, demande-lui de terminer la tâche.)</span>",
				"font": "1.6vw",
				"data": "",
				"object": ["fruit", "vegetable"],
				"img": "",
				"jarCnt": 2,
				"fruitText": "Fruits",
				"vegText": "Légumes",
				"colorObjects": [
					{
						"imageName": ["fruit", "orange"],
						"imgPath": "D3B_4.png"
					},
					{
						"imageName": ["fruit", "banana"],
						"imgPath": "D3B_5.png"
					},
					{
						"imageName": ["fruit", "mango"],
						"imgPath": "D3B_6.png"
					},
					{
						"imageName": ["vegetable", "carrot"],
						"imgPath": "D3B_2.png"
					},
					{
						"imageName": ["vegetable", "potato"],
						"imgPath": "D3B_7.png"
					},
					{
						"imageName": ["vegetable", "bringal"],
						"imgPath": "D3B_9.png"
					},
				],
			},
			// {
			// 	"queNo": "D3C",
			// 	"question": 'Look at these <span style="color:blue">(point to the objects)</span>. Put all the items that can be worn here <span style="color:blue">(point to the ‘things that can be worn’ section)</span>and all the items that cannot be worn here <span style="color:blue">(point to the ‘things that cannot be worn’ section)</span>.<span style="color:blue">(Prompt: If the child stops after sorting some objects, ask her to do the same for all objects).</span>',
			// 	"font": "1.6vw",
			// 	"data": "",
			// 	"object": ["worn", "notWorn"],
			// 	"img": "",
			// 	"jarCnt": 2,
			// 	"colorObjects": [
			// 		{
			// 			"imageName": ["worn", "cap"],
			// 			"imgPath": "D3C_2.png"
			// 		},
			// 		{
			// 			"imageName": ["worn", "dress"],
			// 			"imgPath": "D3C_6.png"
			// 		},
			// 		{
			// 			"imageName": ["worn", "shirt"],
			// 			"imgPath": "D3C_5.png"
			// 		},
			// 		{
			// 			"imageName": ["notWorn", "pillow"],
			// 			"imgPath": "D3C_4.png"
			// 		},
			// 		{
			// 			"imageName": ["notWorn", "mat"],
			// 			"imgPath": "D3C_7.png"
			// 		},
			// 		{
			// 			"imageName": ["notWorn", "curtain"],
			// 			"imgPath": "D3C_8.png"
			// 		},
			// 	],
			// },
			{
				"queNo": "D4A",
				"question": " <span style='color:blue'>(Pointe sur les triangles bleus et dis)</span> Regarde, je mets tous les <b>triangles bleus</b> ici <span style='color:blue'>(Fais glisser et dépose tous les triangles bleus un à un dans le bocal)</span>",
				"question2": " Maintenant, mets tous les <b>cercles rouges</b> ici <span style='color:blue'>(Pointe sur le bocal) <span style='color:blue'>(Conseil: Si l’enfant quitte la tâche à mi-chemin, demande-lui de terminer la tâche)</span>",
				"font": "1.6vw",
				"data": "",
				"object": ["circle-red"],
				"img": "",
				"jarCnt": 1,
				"colorObjects": [
					{
						"imageName": ["triange-yellow", "triangle"],
						"imgPath": "D4A_3.png"
					},
					{
						"imageName": ["triange-blue", "triangle"],
						"imgPath": "D4A_4.png"
					},
					{
						"imageName": ["triange-blue", "triangle"],
						"imgPath": "D4A_4.png"
					},
					{
						"imageName": ["triange-red", "triangle"],
						"imgPath": "D4A_5.png"
					},
					{
						"imageName": ["circle-red", "circle"],
						"imgPath": "D4A_2.png"
					},
					{
						"imageName": ["circle-red", "circle"],
						"imgPath": "D4A_2.png"
					},
					{
						"imageName": ["circle-blue", "circle"],
						"imgPath": "D4A_6.png"
					},
					{
						"imageName": ["circle-yellow", "circle"],
						"imgPath": "D4A_7.png"
					},
				],
			},
			{
				"queNo": "D4B",
				"question": " <span style='color:blue'>(Point to the blue coloured triangles and say)</span> Look I am putting all the blue-coloured triangles here <span style='color:blue'>(drag and drop all blue coloured triangles one by one into the box)</span>.",
				"question2": "Now, like I did, you have to put all the yellow-coloured squares in this box <span style='color:blue'>(point to the box)</span>.<span style='color:blue'>(Prompt: If the child leaves the task midway, ask them to complete the task.)</span>.",
				"font": "1.6vw",
				"data": "",
				"object": ["rectangle-yellow"],
				"img": "",
				"jarCnt": 1,
				"colorObjects": [
					{
						"imageName": ["triange-yellow", "triangle"],
						"imgPath": "D4B_3.png"
					},
					{
						"imageName": ["triange-yellow", "triangle"],
						"imgPath": "D4B_3.png"
					},
					{
						"imageName": ["triange-blue", "triangle"],
						"imgPath": "D4B_6.png"
					},
					{
						"imageName": ["rectangle-yellow", "rectangle"],
						"imgPath": "D4B_7.png"
					},
					{
						"imageName": ["rectangle-yellow", "rectangle"],
						"imgPath": "D4B_7.png"
					},
					{
						"imageName": ["rectangle-yellow", "rectangle"],
						"imgPath": "D4B_7.png"
					},
					{
						"imageName": ["rectangle-red", "rectangle"],
						"imgPath": "D4B_4.png"
					},
					{
						"imageName": ["circle-red", "circle"],
						"imgPath": "D4B_5.png"
					},
					{
						"imageName": ["circle-red", "circle"],
						"imgPath": "D4B_5.png"
					}, {
						"imageName": ["circle-red", "circle"],
						"imgPath": "D4B_5.png"
					},
					{
						"imageName": ["circle-blue", "circle"],
						"imgPath": "D4B_8.png"
					},
					{
						"imageName": ["circle-yellow", "circle"],
						"imgPath": "D4B_1.png"
					},

				],
			},
			{
				"queNo": "D6A",
				"question": " <span style='color:blue'>(Pointe du doigt vers les animaux et dis)</span> Regarde-les attentivement. Maintenant, mets tous les animaux qui ont <b>quatre pattes</b> ici <span style='color:blue'>(pointe sur la zone clôturée)</span> <span style='color:blue'>(Conseil : Si l’enfant quitte la tâche à mi-chemin, demandez-lui de terminer la tâche)</span>",
				"font": "1.6vw",
				"data": "",
				"object": ["four-leg"],
				"img": "",
				"jarCnt": 1,
				"colorObjects": [
					{
						"imageName": ["two-leg", "lamp"],
						"imgPath": "D6A_5.png"
					},
					{
						"imageName": ["two-leg", "stool"],
						"imgPath": "D6A_6.png"
					},
					{
						"imageName": ["four-leg", "chair"],
						"imgPath": "D6A_2.png"
					},
					{
						"imageName": ["four-leg", "table"],
						"imgPath": "D6A_3.png"
					},
					{
						"imageName": ["four-leg", "stretcher"],
						"imgPath": "D6A_4.png"
					},
					{
						"imageName": ["two-leg", "tripad"],
						"imgPath": "D6A_7.png"
					},
				],
			},
		]
	},
	{
		"lang": "French-Senegal",
		"data": [
			{
				"queNo": "D1B",
				"question": " <span style='color:blue'>(Pointe les boules vertes et dis)</span> Regarde, je mets toutes les <b>boules vertes</b> ici <span style='color:blue'>(Fais glisser et déposer toutes les boules vertes une par une dans le bocal)</span>. ",
				"question2": " Maintenant, mets toutes les <b>boules jaunes</b> ici <span style='color:blue'>(montre le bocal)</span>. <span style='color:blue'>(Indication : si l'enfant abandonne la tâche à mi-chemin, demandez-lui de la terminer)</span>",
				"font": "1.6vw",
				"data": "",
				"object": ["circle"],
				"img": "",
				"jarCnt": 1,
				"colorObjects": [
					{
						"imageName": ["yellow", "circle"],
						"imgPath": "D1B_4.png"
					},
					{
						"imageName": ["blue", "circle"],
						"imgPath": "D1B_3.png"
					},
					{
						"imageName": ["green", "circle"],
						"imgPath": "D1B_2.png"
					},
				],
			},
			{
				"queNo": "D1D",
				"question": "<span style='color:blue'>(Point to the box and say)</span> Look at this carefully. Now, put all those circles <span style='color:blue'>(point to all the circles)</span> that are of the same colour as the box, one by one into the box <span style='color:blue'>(point to the box)</span>.<span style='color:blue'>(Prompt: If the child leaves the task midway, ask them to complete the task.)</span>.",
				"font": "1.6vw",
				"data": "",
				"object": ["circle"],
				"img": "",
				"jarCnt": 1,
				"colorObjects": [
					{
						"imageName": ["yellow", "circle"],
						"imgPath": "D1A_6.png"
					},
					{
						"imageName": ["blue", "circle"],
						"imgPath": "D1A_7.png"
					},
					{
						"imageName": ["green", "circle"],
						"imgPath": "D1A_5.png"
					},
					{
						"imageName": ["red", "circle"],
						"imgPath": "D1A_8.png"
					},
				],
			},
			{
				"queNo": "D2B",
				"question": "<span style='color:blue'>(Point to the different shapes and say)</span> Look, I am putting all the circles <span style='color:blue'>(point to the circles)</span> in this box <span style='color:blue'>(drag and drop all the circles one by one inside the box)</span>.",
				"question2": "Now, like I did, you have to put all the triangles in this box <span style='color:blue'>(point to the box)</span>. <span style='color:blue'>(Prompt: If the child leaves the task midway, ask them to complete the task)</span>.",
				"font": "1.6vw",
				"data": "",
				"object": ["circle"],
				"img": "",
				"jarCnt": 1,
				"colorObjects": [
					{
						"imageName": ["triange", "triangle"],
						"imgPath": "D2B_4.png"
					},
					{
						"imageName": ["rectangle", "rectangle"],
						"imgPath": "D2B_2.png"
					},
					{
						"imageName": ["circle", "circle"],
						"imgPath": "D2B_3.png"
					},
				],
			},
			{
				"queNo": "D3A",
				"question": " <span style='color:blue'>(Regarde les animaux et les oiseaux et dis)</span> Regardez-les attentivement. Maintenant, placez tous les oiseaux ici <span style='color:blue'>(pointez sur la section des oiseaux)</span> et tous les animaux ici <span style='color:blue'>(pointez sur la section des animaux)</span>. <span style='color:blue'>(Invite : Si l'enfant quitte la tâche à mi-chemin, demandez-lui de terminer la tâche)</span>",
				"font": "1.6vw",
				"data": "",
				"object": ["bird", "animal"],
				"img": "",
				"jarCnt": 2,
				"animalText": "Animaux",
				"birdText": "Oiseaux",
				"colorObjects": [
					{
						"imageName": ["animal", "cow"],
						"imgPath": "D3A_1.png"
					},
					{
						"imageName": ["bird", "cock"],
						"imgPath": "D3A_2.png"
					},
					{
						"imageName": ["animal", "elephant"],
						"imgPath": "D3A_3.png"
					},
					{
						"imageName": ["bird", "crow"],
						"imgPath": "D3A_4.png"
					},
					{
						"imageName": ["animal", "cat"],
						"imgPath": "D3A_5.png"
					},
					{
						"imageName": ["bird", "pigon"],
						"imgPath": "D3A_6.png"
					},
				],
			},
			{
				"queNo": "D3B",
				"question": " <span style='color:blue'>(Regarde les objets et dis)</span> Regarde-les attentivement. Maintenant, place tous les fruits ici <span style='color:blue'>(pointe sur la section des fruits)</span> et tous les légumes ici <span style='color:blue'>(pointe sur la section des légumes)</span>. <span style='color:blue'>(Invite : Si l'enfant quitte la tâche à mi-chemin, demande-lui de terminer la tâche.)</span>",
				"font": "1.6vw",
				"data": "",
				"object": ["fruit", "vegetable"],
				"img": "",
				"jarCnt": 2,
				"fruitText": "Fruits",
				"vegText": "Légumes",
				"colorObjects": [
					{
						"imageName": ["fruit", "orange"],
						"imgPath": "D3B_4.png"
					},
					{
						"imageName": ["fruit", "banana"],
						"imgPath": "D3B_5.png"
					},
					{
						"imageName": ["fruit", "mango"],
						"imgPath": "D3B_6.png"
					},
					{
						"imageName": ["vegetable", "carrot"],
						"imgPath": "D3B_2.png"
					},
					{
						"imageName": ["vegetable", "potato"],
						"imgPath": "D3B_7.png"
					},
					{
						"imageName": ["vegetable", "bringal"],
						"imgPath": "D3B_9.png"
					},
				],
			},
			// {
			// 	"queNo": "D3C",
			// 	"question": 'Look at these <span style="color:blue">(point to the objects)</span>. Put all the items that can be worn here <span style="color:blue">(point to the ‘things that can be worn’ section)</span>and all the items that cannot be worn here <span style="color:blue">(point to the ‘things that cannot be worn’ section)</span>.<span style="color:blue">(Prompt: If the child stops after sorting some objects, ask her to do the same for all objects).</span>',
			// 	"font": "1.6vw",
			// 	"data": "",
			// 	"object": ["worn", "notWorn"],
			// 	"img": "",
			// 	"jarCnt": 2,
			// 	"colorObjects": [
			// 		{
			// 			"imageName": ["worn", "cap"],
			// 			"imgPath": "D3C_2.png"
			// 		},
			// 		{
			// 			"imageName": ["worn", "dress"],
			// 			"imgPath": "D3C_6.png"
			// 		},
			// 		{
			// 			"imageName": ["worn", "shirt"],
			// 			"imgPath": "D3C_5.png"
			// 		},
			// 		{
			// 			"imageName": ["notWorn", "pillow"],
			// 			"imgPath": "D3C_4.png"
			// 		},
			// 		{
			// 			"imageName": ["notWorn", "mat"],
			// 			"imgPath": "D3C_7.png"
			// 		},
			// 		{
			// 			"imageName": ["notWorn", "curtain"],
			// 			"imgPath": "D3C_8.png"
			// 		},
			// 	],
			// },
			{
				"queNo": "D4A",
				"question": " <span style='color:blue'>(Montrer les triangles bleus et dis)</span> Regarde, je mets tous les <b>triangles bleus</b> ici <span style='color:blue'>(Faire glisser et déposer tous les triangles bleus un par un dans le bocal)</span>",
				"question2": " Maintenant, mets tous les <b>cercles rouges</b> ici <span style='color:blue'>(pointer vers le bocal)</span> <span style='color:blue'>(Indication : si l'enfant abandonne la tâche à mi-chemin, demandez-lui de la terminer)</span>",
				"font": "1.6vw",
				"data": "",
				"object": ["circle-red"],
				"img": "",
				"jarCnt": 1,
				"colorObjects": [
					{
						"imageName": ["triange-yellow", "triangle"],
						"imgPath": "D4A_3.png"
					},
					{
						"imageName": ["triange-blue", "triangle"],
						"imgPath": "D4A_4.png"
					},
					{
						"imageName": ["triange-blue", "triangle"],
						"imgPath": "D4A_4.png"
					},
					{
						"imageName": ["triange-red", "triangle"],
						"imgPath": "D4A_5.png"
					},
					{
						"imageName": ["circle-red", "circle"],
						"imgPath": "D4A_2.png"
					},
					{
						"imageName": ["circle-red", "circle"],
						"imgPath": "D4A_2.png"
					},
					{
						"imageName": ["circle-blue", "circle"],
						"imgPath": "D4A_6.png"
					},
					{
						"imageName": ["circle-yellow", "circle"],
						"imgPath": "D4A_7.png"
					},
				],
			},
			{
				"queNo": "D4B",
				"question": " <span style='color:blue'>(Point to the blue coloured triangles and say)</span> Look I am putting all the blue-coloured triangles here <span style='color:blue'>(drag and drop all blue coloured triangles one by one into the box)</span>.",
				"question2": "Now, like I did, you have to put all the yellow-coloured squares in this box <span style='color:blue'>(point to the box)</span>.<span style='color:blue'>(Prompt: If the child leaves the task midway, ask them to complete the task.)</span>.",
				"font": "1.6vw",
				"data": "",
				"object": ["rectangle-yellow"],
				"img": "",
				"jarCnt": 1,
				"colorObjects": [
					{
						"imageName": ["triange-yellow", "triangle"],
						"imgPath": "D4B_3.png"
					},
					{
						"imageName": ["triange-yellow", "triangle"],
						"imgPath": "D4B_3.png"
					},
					{
						"imageName": ["triange-blue", "triangle"],
						"imgPath": "D4B_6.png"
					},
					{
						"imageName": ["rectangle-yellow", "rectangle"],
						"imgPath": "D4B_7.png"
					},
					{
						"imageName": ["rectangle-yellow", "rectangle"],
						"imgPath": "D4B_7.png"
					},
					{
						"imageName": ["rectangle-yellow", "rectangle"],
						"imgPath": "D4B_7.png"
					},
					{
						"imageName": ["rectangle-red", "rectangle"],
						"imgPath": "D4B_4.png"
					},
					{
						"imageName": ["circle-red", "circle"],
						"imgPath": "D4B_5.png"
					},
					{
						"imageName": ["circle-red", "circle"],
						"imgPath": "D4B_5.png"
					}, {
						"imageName": ["circle-red", "circle"],
						"imgPath": "D4B_5.png"
					},
					{
						"imageName": ["circle-blue", "circle"],
						"imgPath": "D4B_8.png"
					},
					{
						"imageName": ["circle-yellow", "circle"],
						"imgPath": "D4B_1.png"
					},

				],
			},
			{
				"queNo": "D6A",
				"question": " <span style='color:blue'>(Montre les animaux et dis)</span> Regarde-les attentivement. Maintenant, mets tous les animaux qui ont <b>quatre pattes</b> ici <span style='color:blue'>(montre la zone clôturée)</span>. <span style='color:blue'>(Indication : si l'enfant abandonne la tâche à mi-chemin, demandez-lui de la terminer)</span>",
				"font": "1.6vw",
				"data": "",
				"object": ["four-leg"],
				"img": "",
				"jarCnt": 1,
				"colorObjects": [
					{
						"imageName": ["two-leg", "lamp"],
						"imgPath": "D6A_5.png"
					},
					{
						"imageName": ["two-leg", "stool"],
						"imgPath": "D6A_6.png"
					},
					{
						"imageName": ["four-leg", "chair"],
						"imgPath": "D6A_2.png"
					},
					{
						"imageName": ["four-leg", "table"],
						"imgPath": "D6A_3.png"
					},
					{
						"imageName": ["four-leg", "stretcher"],
						"imgPath": "D6A_4.png"
					},
					{
						"imageName": ["two-leg", "tripad"],
						"imgPath": "D6A_7.png"
					},
				],
			},
		]
	},
	{
		"lang": "Nepali-Nepal",
		'languageFont': 'fonts/MANGAL.TTF',
		"data": [
			{
				"queNo": "D1B",
				"question": " <span style='color:blue'>(हरियो बलहरुलाई देखाउनुहोस् र भन्नुहोस् )</span> हेर्नुहोस्, म यी सबै <b>हरियो बलहरुलाई</b> यहाँ <span style='color:blue'>(हरियो बलहरु सबैलाई एक एक गर्दै तानेर बट्टामा राख्नुहोस्)</span> राख्दै छु ।",
				"question2": " अब, सबै <b>पहेँलो बलहरुलाई</b> यहाँ <span style='color:blue'>(बट्टामा देखाउनुहोस्)</span> राख्नुहोस्। <span style='color:blue'>(नोट: यदि बालबालिकाहरुले यो कार्य गर्दा गर्दै बिचमै छोडे भने, उनीहरुलाई यो कार्य पुरा गर्न लगाउनुहोस् )</span>",
				"font": "1.6vw",
				"data": "",
				"object": ["circle"],
				"img": "",
				"jarCnt": 1,
				"colorObjects": [
					{
						"imageName": ["yellow", "circle"],
						"imgPath": "D1B_4.png"
					},
					{
						"imageName": ["blue", "circle"],
						"imgPath": "D1B_3.png"
					},
					{
						"imageName": ["green", "circle"],
						"imgPath": "D1B_2.png"
					},
				],
			},
			{
				"queNo": "D1D",
				"question": "<span style='color:blue'>(Point to the box and say)</span> Look at this carefully. Now, put all those circles <span style='color:blue'>(point to all the circles)</span> that are of the same colour as the box, one by one into the box <span style='color:blue'>(point to the box)</span>.<span style='color:blue'>(Prompt: If the child leaves the task midway, ask them to complete the task.)</span>.",
				"font": "1.6vw",
				"data": "",
				"object": ["circle"],
				"img": "",
				"jarCnt": 1,
				"colorObjects": [
					{
						"imageName": ["yellow", "circle"],
						"imgPath": "D1A_6.png"
					},
					{
						"imageName": ["blue", "circle"],
						"imgPath": "D1A_7.png"
					},
					{
						"imageName": ["green", "circle"],
						"imgPath": "D1A_5.png"
					},
					{
						"imageName": ["red", "circle"],
						"imgPath": "D1A_8.png"
					},
				],
			},
			{
				"queNo": "D2B",
				"question": "<span style='color:blue'>(Point to the different shapes and say)</span> Look, I am putting all the circles <span style='color:blue'>(point to the circles)</span> in this box <span style='color:blue'>(drag and drop all the circles one by one inside the box)</span>.",
				"question2": "Now, like I did, you have to put all the triangles in this box <span style='color:blue'>(point to the box)</span>. <span style='color:blue'>(Prompt: If the child leaves the task midway, ask them to complete the task)</span>.",
				"font": "1.6vw",
				"data": "",
				"object": ["circle"],
				"img": "",
				"jarCnt": 1,
				"colorObjects": [
					{
						"imageName": ["triange", "triangle"],
						"imgPath": "D2B_4.png"
					},
					{
						"imageName": ["rectangle", "rectangle"],
						"imgPath": "D2B_2.png"
					},
					{
						"imageName": ["circle", "circle"],
						"imgPath": "D2B_3.png"
					},
				],
			},
			{
				"queNo": "D3A",
				"question": " <span style='color:blue'>(जनावर र चराहरूलाई देखाउनुहोस् र भन्नुहोस् )</span> यीनीहरुलाई ध्यान दिएर हेर्नुहोस्. अब सबै चराहरुलाई यहाँ राख्नुहोस् <span style='color:blue'>( चराहरु भएको भागमा देखाउनुहोस् )</span> र सबै जनावरहरुलाई यहाँ राख्नुहोस् <span style='color:blue'>(जनावरहरु भएको भागमा देखाउनुहोस् )</span>। <span style='color:blue'>(नोट: यदि बच्चाले यो कार्य गर्दा गर्दै बिचमै छोड्छ भने, उस्लाई यो कार्य पुरा गर्न लगाउनुहोस् )</span>",
				"font": "1.6vw",
				"data": "",
				"object": ["bird", "animal"],
				"img": "",
				"jarCnt": 2,
				"animalText": "जनावर",
				"birdText": "चराहरु",
				"colorObjects": [
					{
						"imageName": ["animal", "cow"],
						"imgPath": "D3A_1.png"
					},
					{
						"imageName": ["bird", "cock"],
						"imgPath": "D3A_2.png"
					},
					{
						"imageName": ["animal", "elephant"],
						"imgPath": "D3A_3.png"
					},
					{
						"imageName": ["bird", "crow"],
						"imgPath": "D3A_4.png"
					},
					{
						"imageName": ["animal", "cat"],
						"imgPath": "D3A_5.png"
					},
					{
						"imageName": ["bird", "pigon"],
						"imgPath": "D3A_6.png"
					},
				],
			},
			{
				"queNo": "D3B",
				"question": " <span style='color:blue'>(वस्तुहरुलाई देखाउनुहोस् र भन्नुहोस्) </span> यसलाई ध्यान दिएर हेर्नुहोस्। अब सबै फलफूलहरुलाई यहाँ राख्नुहोस् <span style='color:blue'>(फलफूल भएको भागलाई देखाउनुहोस् )</span>र सबै तरकारीहरूलाई यहाँ राख्नुहोस <span style='color:blue'>(तरकारीहरू भएको भागलाई देखाउनुहोस् )</span>। <span style='color:blue'>(नोट: यदि बच्चाले यो कार्य गर्दा गर्दै बिचमै छोड्छ भने, उसलाई यो कार्य पुरा गर्न लगाउनुहोस् । )</span>",
				"font": "1.6vw",
				"data": "",
				"object": ["fruit", "vegetable"],
				"img": "",
				"jarCnt": 2,
				"fruitText": "फलफूल",
				"vegText": "तरकारीहरू",
				"colorObjects": [
					{
						"imageName": ["fruit", "orange"],
						"imgPath": "D3B_4.png"
					},
					{
						"imageName": ["fruit", "banana"],
						"imgPath": "D3B_5.png"
					},
					{
						"imageName": ["fruit", "mango"],
						"imgPath": "D3B_6.png"
					},
					{
						"imageName": ["vegetable", "carrot"],
						"imgPath": "D3B_2.png"
					},
					{
						"imageName": ["vegetable", "potato"],
						"imgPath": "D3B_7.png"
					},
					{
						"imageName": ["vegetable", "bringal"],
						"imgPath": "D3B_9.png"
					},
				],
			},
			// {
			// 	"queNo": "D3C",
			// 	"question": 'Look at these <span style="color:blue">(point to the objects)</span>. Put all the items that can be worn here <span style="color:blue">(point to the ‘things that can be worn’ section)</span>and all the items that cannot be worn here <span style="color:blue">(point to the ‘things that cannot be worn’ section)</span>.<span style="color:blue">(Prompt: If the child stops after sorting some objects, ask her to do the same for all objects).</span>',
			// 	"font": "1.6vw",
			// 	"data": "",
			// 	"object": ["worn", "notWorn"],
			// 	"img": "",
			// 	"jarCnt": 2,
			// 	"colorObjects": [
			// 		{
			// 			"imageName": ["worn", "cap"],
			// 			"imgPath": "D3C_2.png"
			// 		},
			// 		{
			// 			"imageName": ["worn", "dress"],
			// 			"imgPath": "D3C_6.png"
			// 		},
			// 		{
			// 			"imageName": ["worn", "shirt"],
			// 			"imgPath": "D3C_5.png"
			// 		},
			// 		{
			// 			"imageName": ["notWorn", "pillow"],
			// 			"imgPath": "D3C_4.png"
			// 		},
			// 		{
			// 			"imageName": ["notWorn", "mat"],
			// 			"imgPath": "D3C_7.png"
			// 		},
			// 		{
			// 			"imageName": ["notWorn", "curtain"],
			// 			"imgPath": "D3C_8.png"
			// 		},
			// 	],
			// },
			{
				"queNo": "D4A",
				"question": " <span style='color:blue'>(नीलो रंगको त्रिकोणहरुलाई देखाउनुहोस् र भन्नुहोस् )</span> हेर्नुहोस् त म नीलो <span style='color:blue'>(नीलो त्रिभुजहरु /triangles लाई देखाउँदै भन्नुहोस्)</span> हेर्नुहोस्, म <b>नीलो त्रिभुजहरुलाई /triangles</b> यहाँ राख्दै छु <span style='color:blue'>(सबै नीलो त्रिभुजहरुलाई एक एक गर्दै बट्टामा खसाल्नुहोस्) </span> रंगको सबै त्रिकोणहरुलाई यहाँ राख्दै छु <span style='color:blue'>(नीलो रंगको सबै त्रिकोणलाई एक एक गरि तान्दै बाकस भित्र राख्नुहोस् )</span>।",
				"question2": " अब, सबै <b>रातो वृत्तहरु/circles</b> लाई यहाँ <span style='color:blue'>(बट्टामा देखाउनुहोस्)</span> राख्नुहोस्। <span style='color:blue'>(नोट : यदि बालबालिकाहरुले यो कार्य गर्दा गर्दै बिचमै छोडे भने, उनीहरुलाई यो कार्य पुरा गर्न लगाउनुहोस्)</span>",
				"font": "1.6vw",
				"data": "",
				"object": ["circle-red"],
				"img": "",
				"jarCnt": 1,
				"colorObjects": [
					{
						"imageName": ["triange-yellow", "triangle"],
						"imgPath": "D4A_3.png"
					},
					{
						"imageName": ["triange-blue", "triangle"],
						"imgPath": "D4A_4.png"
					},
					{
						"imageName": ["triange-blue", "triangle"],
						"imgPath": "D4A_4.png"
					},
					{
						"imageName": ["triange-red", "triangle"],
						"imgPath": "D4A_5.png"
					},
					{
						"imageName": ["circle-red", "circle"],
						"imgPath": "D4A_2.png"
					},
					{
						"imageName": ["circle-red", "circle"],
						"imgPath": "D4A_2.png"
					},
					{
						"imageName": ["circle-blue", "circle"],
						"imgPath": "D4A_6.png"
					},
					{
						"imageName": ["circle-yellow", "circle"],
						"imgPath": "D4A_7.png"
					},
				],
			},
			{
				"queNo": "D4B",
				"question": " <span style='color:blue'>(Point to the blue coloured triangles and say)</span> Look I am putting all the blue-coloured triangles here <span style='color:blue'>(drag and drop all blue coloured triangles one by one into the box)</span>.",
				"question2": "Now, like I did, you have to put all the yellow-coloured squares in this box <span style='color:blue'>(point to the box)</span>.<span style='color:blue'>(Prompt: If the child leaves the task midway, ask them to complete the task.)</span>.",
				"font": "1.6vw",
				"data": "",
				"object": ["rectangle-yellow"],
				"img": "",
				"jarCnt": 1,
				"colorObjects": [
					{
						"imageName": ["triange-yellow", "triangle"],
						"imgPath": "D4B_3.png"
					},
					{
						"imageName": ["triange-yellow", "triangle"],
						"imgPath": "D4B_3.png"
					},
					{
						"imageName": ["triange-blue", "triangle"],
						"imgPath": "D4B_6.png"
					},
					{
						"imageName": ["rectangle-yellow", "rectangle"],
						"imgPath": "D4B_7.png"
					},
					{
						"imageName": ["rectangle-yellow", "rectangle"],
						"imgPath": "D4B_7.png"
					},
					{
						"imageName": ["rectangle-yellow", "rectangle"],
						"imgPath": "D4B_7.png"
					},
					{
						"imageName": ["rectangle-red", "rectangle"],
						"imgPath": "D4B_4.png"
					},
					{
						"imageName": ["circle-red", "circle"],
						"imgPath": "D4B_5.png"
					},
					{
						"imageName": ["circle-red", "circle"],
						"imgPath": "D4B_5.png"
					}, {
						"imageName": ["circle-red", "circle"],
						"imgPath": "D4B_5.png"
					},
					{
						"imageName": ["circle-blue", "circle"],
						"imgPath": "D4B_8.png"
					},
					{
						"imageName": ["circle-yellow", "circle"],
						"imgPath": "D4B_1.png"
					},

				],
			},
			{
				"queNo": "D6A",
				"question": " <span style='color:blue'>(जनावरहरुलाई देखाउँदै भन्नुहोस्)</span> यिनीहरुलाई ध्यान दिएर हेर्नुहोस्।अब, <b>चार ओटा खुट्टा</b> भएका सबै जनावरहरुलाई यहाँ <span style='color:blue'>(बारले घेरेको ठाउँमा देखाउनुहोस्)</span> राख्नुहोस् <span style='color:blue'>(नोट: यदि बालबालिकाहरुले यो कार्य गर्दा गर्दै बिचमै छोडे भने , उनीहरुलाई यो कार्य पुरा गर्न लगाउनुहोस्)</span>।",
				"font": "1.6vw",
				"data": "",
				"object": ["four-leg"],
				"img": "",
				"jarCnt": 1,
				"colorObjects": [
					{
						"imageName": ["two-leg", "lamp"],
						"imgPath": "D6A_5.png"
					},
					{
						"imageName": ["two-leg", "stool"],
						"imgPath": "D6A_6.png"
					},
					{
						"imageName": ["four-leg", "chair"],
						"imgPath": "D6A_2.png"
					},
					{
						"imageName": ["four-leg", "table"],
						"imgPath": "D6A_3.png"
					},
					{
						"imageName": ["four-leg", "stretcher"],
						"imgPath": "D6A_4.png"
					},
					{
						"imageName": ["two-leg", "tripad"],
						"imgPath": "D6A_7.png"
					},
				],
			},
		]
	},
	{
		"lang": "Portuguese-Mozambique",
		"data": [
			{
				"queNo": "D1B",
				"question": "<span style='color:blue'>(Aponta para as bolas verdes e diz)</span> Olha, estou a pôr todas as bolas verdes aqui <span style='color:blue'>(Arrasta e larga todas as bolas verdes, uma a uma, no frasco)</span>.",
				"question2": "Agora, ponha todas as bolas amarelas aqui <span style='color:blue'>(aponta para o frasco)</span>. <span style='color:blue'>(Sugestão: se a criança abandonar a tarefa a meio, peça-lhe que a complete)</span>",
				"font": "1.6vw",
				"data": "",
				"object": ["circle"],
				"img": "",
				"jarCnt": 1,
				"colorObjects": [
					{
						"imageName": ["yellow", "circle"],
						"imgPath": "D1B_4.png"
					},
					{
						"imageName": ["blue", "circle"],
						"imgPath": "D1B_3.png"
					},
					{
						"imageName": ["green", "circle"],
						"imgPath": "D1B_2.png"
					},
				],
			},
			{
				"queNo": "D1D",
				"question": "<span style='color:blue'>(Point to the box and say)</span> Look at this carefully. Now, put all those circles <span style='color:blue'>(point to all the circles)</span> that are of the same colour as the box, one by one into the box <span style='color:blue'>(point to the box)</span>.<span style='color:blue'>(Prompt: If the child leaves the task midway, ask them to complete the task.)</span>.",
				"font": "1.6vw",
				"data": "",
				"object": ["circle"],
				"img": "",
				"jarCnt": 1,
				"colorObjects": [
					{
						"imageName": ["yellow", "circle"],
						"imgPath": "D1A_6.png"
					},
					{
						"imageName": ["blue", "circle"],
						"imgPath": "D1A_7.png"
					},
					{
						"imageName": ["green", "circle"],
						"imgPath": "D1A_5.png"
					},
					{
						"imageName": ["red", "circle"],
						"imgPath": "D1A_8.png"
					},
				],
			},
			{
				"queNo": "D2B",
				"question": "<span style='color:blue'>(Point to the different shapes and say)</span> Look, I am putting all the circles <span style='color:blue'>(point to the circles)</span> in this box <span style='color:blue'>(drag and drop all the circles one by one inside the box)</span>.",
				"question2": "Now, like I did, you have to put all the triangles in this box <span style='color:blue'>(point to the box)</span>. <span style='color:blue'>(Prompt: If the child leaves the task midway, ask them to complete the task)</span>.",
				"font": "1.6vw",
				"data": "",
				"object": ["circle"],
				"img": "",
				"jarCnt": 1,
				"colorObjects": [
					{
						"imageName": ["triange", "triangle"],
						"imgPath": "D2B_4.png"
					},
					{
						"imageName": ["rectangle", "rectangle"],
						"imgPath": "D2B_2.png"
					},
					{
						"imageName": ["circle", "circle"],
						"imgPath": "D2B_3.png"
					},
				],
			},
			{
				"queNo": "D3A",
				"question": " <span style='color:blue'>(Aponte para os animais e pássaros e diga)</span> Observe com atenção. Agora, coloque todos os pássaros aqui <span style='color:blue'>(aponte para a seção de pássaros)</span> e todos os animais aqui <span style='color:blue'>(aponte para a seção de animais)</span>. <span style='color:blue'>(Aviso: Se a criança não terminar a tarefa, peça-lhe para terminar) </span>",
				"font": "1.6vw",
				"data": "",
				"object": ["bird", "animal"],
				"img": "",
				"jarCnt": 2,
				"animalText": "Animais",
				"birdText": "Pássaros",
				"colorObjects": [
					{
						"imageName": ["animal", "cow"],
						"imgPath": "D3A_1.png"
					},
					{
						"imageName": ["bird", "cock"],
						"imgPath": "D3A_2.png"
					},
					{
						"imageName": ["animal", "elephant"],
						"imgPath": "D3A_3.png"
					},
					{
						"imageName": ["bird", "crow"],
						"imgPath": "D3A_4.png"
					},
					{
						"imageName": ["animal", "cat"],
						"imgPath": "D3A_5.png"
					},
					{
						"imageName": ["bird", "pigon"],
						"imgPath": "D3A_6.png"
					},
				],
			},
			{
				"queNo": "D3B",
				"question": " <span style='color:blue'>(Aponte para os objetos e diga)</span> Olhe para eles com cuidado. Agora, coloque todas as frutas aqui <span style='color:blue'>(aponte para a secção de frutas)</span> e todos os legumes aqui <span style='color:blue'>(aponte para a seção de legumes)</span>. <span style='color:blue'>(Aviso: Se a criança não terminar a tarefa, peça-lhe para terminar) </span>",
				"font": "1.6vw",
				"data": "",
				"object": ["fruit", "vegetable"],
				"img": "",
				"jarCnt": 2,
				"fruitText": "Frutas",
				"vegText": "Legumes",
				"colorObjects": [
					{
						"imageName": ["fruit", "orange"],
						"imgPath": "D3B_4.png"
					},
					{
						"imageName": ["fruit", "banana"],
						"imgPath": "D3B_5.png"
					},
					{
						"imageName": ["fruit", "mango"],
						"imgPath": "D3B_6.png"
					},
					{
						"imageName": ["vegetable", "carrot"],
						"imgPath": "D3B_2.png"
					},
					{
						"imageName": ["vegetable", "potato"],
						"imgPath": "D3B_7.png"
					},
					{
						"imageName": ["vegetable", "bringal"],
						"imgPath": "D3B_9.png"
					},
				],
			},
			// {
			// 	"queNo": "D3C",
			// 	"question": 'Look at these <span style="color:blue">(point to the objects)</span>. Put all the items that can be worn here <span style="color:blue">(point to the ‘things that can be worn’ section)</span>and all the items that cannot be worn here <span style="color:blue">(point to the ‘things that cannot be worn’ section)</span>.<span style="color:blue">(Prompt: If the child stops after sorting some objects, ask her to do the same for all objects).</span>',
			// 	"font": "1.6vw",
			// 	"data": "",
			// 	"object": ["worn", "notWorn"],
			// 	"img": "",
			// 	"jarCnt": 2,
			// 	"colorObjects": [
			// 		{
			// 			"imageName": ["worn", "cap"],
			// 			"imgPath": "D3C_2.png"
			// 		},
			// 		{
			// 			"imageName": ["worn", "dress"],
			// 			"imgPath": "D3C_6.png"
			// 		},
			// 		{
			// 			"imageName": ["worn", "shirt"],
			// 			"imgPath": "D3C_5.png"
			// 		},
			// 		{
			// 			"imageName": ["notWorn", "pillow"],
			// 			"imgPath": "D3C_4.png"
			// 		},
			// 		{
			// 			"imageName": ["notWorn", "mat"],
			// 			"imgPath": "D3C_7.png"
			// 		},
			// 		{
			// 			"imageName": ["notWorn", "curtain"],
			// 			"imgPath": "D3C_8.png"
			// 		},
			// 	],
			// },
			{
				"queNo": "D4A",
				"question": " <span style='color:blue'>(Aponte para os triângulos azuis e diga)</span> Olha, estou a colocar todos os <b>triângulos azuis</b> aqui <span style='color:blue'>(Araste e largue todos os triângulos azuis um por um na jara)</span>",
				"question2": " Agora coloca todos os <b>circulos vermelhos</b> aqui <span style='color:blue'>(Aponte para a jara)</span> <span style='color:blue'>(Indicação: se a criança abandonar a tarefa ao meio, peça a criança para concluir a tarefa)</span>",
				"font": "1.6vw",
				"data": "",
				"object": ["circle-red"],
				"img": "",
				"jarCnt": 1,
				"colorObjects": [
					{
						"imageName": ["triange-yellow", "triangle"],
						"imgPath": "D4A_3.png"
					},
					{
						"imageName": ["triange-blue", "triangle"],
						"imgPath": "D4A_4.png"
					},
					{
						"imageName": ["triange-blue", "triangle"],
						"imgPath": "D4A_4.png"
					},
					{
						"imageName": ["triange-red", "triangle"],
						"imgPath": "D4A_5.png"
					},
					{
						"imageName": ["circle-red", "circle"],
						"imgPath": "D4A_2.png"
					},
					{
						"imageName": ["circle-red", "circle"],
						"imgPath": "D4A_2.png"
					},
					{
						"imageName": ["circle-blue", "circle"],
						"imgPath": "D4A_6.png"
					},
					{
						"imageName": ["circle-yellow", "circle"],
						"imgPath": "D4A_7.png"
					},
				],
			},
			{
				"queNo": "D4B",
				"question": " <span style='color:blue'>(Point to the blue coloured triangles and say)</span> Look I am putting all the blue-coloured triangles here <span style='color:blue'>(drag and drop all blue coloured triangles one by one into the box)</span>.",
				"question2": "Now, like I did, you have to put all the yellow-coloured squares in this box <span style='color:blue'>(point to the box)</span>.<span style='color:blue'>(Prompt: If the child leaves the task midway, ask them to complete the task.)</span>.",
				"font": "1.6vw",
				"data": "",
				"object": ["rectangle-yellow"],
				"img": "",
				"jarCnt": 1,
				"colorObjects": [
					{
						"imageName": ["triange-yellow", "triangle"],
						"imgPath": "D4B_3.png"
					},
					{
						"imageName": ["triange-yellow", "triangle"],
						"imgPath": "D4B_3.png"
					},
					{
						"imageName": ["triange-blue", "triangle"],
						"imgPath": "D4B_6.png"
					},
					{
						"imageName": ["rectangle-yellow", "rectangle"],
						"imgPath": "D4B_7.png"
					},
					{
						"imageName": ["rectangle-yellow", "rectangle"],
						"imgPath": "D4B_7.png"
					},
					{
						"imageName": ["rectangle-yellow", "rectangle"],
						"imgPath": "D4B_7.png"
					},
					{
						"imageName": ["rectangle-red", "rectangle"],
						"imgPath": "D4B_4.png"
					},
					{
						"imageName": ["circle-red", "circle"],
						"imgPath": "D4B_5.png"
					},
					{
						"imageName": ["circle-red", "circle"],
						"imgPath": "D4B_5.png"
					}, {
						"imageName": ["circle-red", "circle"],
						"imgPath": "D4B_5.png"
					},
					{
						"imageName": ["circle-blue", "circle"],
						"imgPath": "D4B_8.png"
					},
					{
						"imageName": ["circle-yellow", "circle"],
						"imgPath": "D4B_1.png"
					},

				],
			},
			{
				"queNo": "D6A",
				"question": " <span style='color:blue'>(Aponte para os animais e diga)</span> Olha para isto com atenção. Agora, coloca todos os animais que têm <b>quatro patas</b> aqui <span style='color:blue'>(aponte para a área cercada)</span> <span style='color:blue'>(Indicação: se a criança abandonar a tarefa ao meio, peça a criança para concluir a tarefa)</span>",
				"font": "1.6vw",
				"data": "",
				"object": ["four-leg"],
				"img": "",
				"jarCnt": 1,
				"colorObjects": [
					{
						"imageName": ["two-leg", "lamp"],
						"imgPath": "D6A_5.png"
					},
					{
						"imageName": ["two-leg", "stool"],
						"imgPath": "D6A_6.png"
					},
					{
						"imageName": ["four-leg", "chair"],
						"imgPath": "D6A_2.png"
					},
					{
						"imageName": ["four-leg", "table"],
						"imgPath": "D6A_3.png"
					},
					{
						"imageName": ["four-leg", "stretcher"],
						"imgPath": "D6A_4.png"
					},
					{
						"imageName": ["two-leg", "tripad"],
						"imgPath": "D6A_7.png"
					},
				],
			},
		]
	},
];


Classification.shapeAndColor =
	[
		{
			"colorCnt": 4,
			"objectCnt": 1
		},
		{
			"colorCnt": 4,
			"objectCnt": 1
		},
		{
			"colorCnt": 3,
			"objectCnt": 3
		}, {
			"colorCnt": 3,
			"objectCnt": 6
		},
		{
			"colorCnt": 6,
			"objectCnt": 3
		},
	];
