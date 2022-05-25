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
		"data": [
			{
				"queNo": "D1B",
				"question": "<span style='color:blue'>(Point to the green balls and say)</span> Look, I am putting all the <b>green balls</b> here <span style='color:blue'>(Drag and drop all the green balls one by one into the jar)</span>.",
				"question2": " Now, put all the <b>yellow balls</b> here <span style='color:blue'>(point to the jar)</span>. </span>(Prompt: If the child leaves the task midway, ask them to complete the task)<span style='color:blue'>",
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
				"question": " <span style='color:blue'>(Point to the blue triangles and say)</span> Look, I am putting all the <b>blue triangles</b> here <span style='color:blue'>(Drag and drop all the blue triangles one by one into the jar)</span>.",
				"question2": "  Now, as I did you have to put all the <b>red circles</b> here <span style='color:blue'>(Point to the jar)</span> </span>(Prompt: If the child leaves the task midway, ask them to complete the task)<span style='color:blue'>",
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
				"question": " <span style='color:blue'>(हरे रंग के गोलों की ओर इशारा करते हुए कहें)</span> देखो, मैं हरे रंग के सभी गोलों को यहाँ डाल रहा हूँ <span style='color:blue'>(हरे रंग के गोलों को एक-एक करके ले जाकर डिब्बे में डाल दें)</span>| ",
				"question2": " अब, जैसे मैंने किया आप भी वैसे ही पीले रंग के सभी गोलों को यहाँ  <span style='color:blue'>(डिब्बे की ओर इशारा करें)</span> डाल दो| <span style='color:blue'>(प्रॉम्प्ट: यदि बच्चा कार्य अधूरा छोड़ देता है, तो उसे कार्य पूरा करने को कहें)</span>",
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
				"question": " <span style='color:blue'>(नीले रंग के त्रिकोण की ओर इशारा करते हुए कहें)</span> देखो, मैं नीले रंग के सभी त्रिकोणों को यहाँ डाल रहा हूँ  <span style='color:blue'>(नीले रंग के सभी त्रिकोणों को एक-एक करके ले जाकर डिब्बे में डाल दें)</span> |",
				"question2": " अब, जैसे मैंने किया आप भी वैसे ही लाल रंग के सभी गोलों को यहाँ  <span style='color:blue'>(डिब्बे की ओर इशारा करें)</span> डाल दो| <span style='color:blue'>(प्रॉम्प्ट: यदि बच्चा कार्य अधूरा छोड़ देता है, तो उसे कार्य पूरा करने को कहें)</span>",
				"font": "1.6vw",
				"data": "",
				"object": ["circle-red"],
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
						"imageName": ["one-leg", "lamp"],
						"imgPath": "D6A_2.png"
					},
					{
						"imageName": ["three-leg", "stool"],
						"imgPath": "D6A_3.png"
					},
					{
						"imageName": ["four-leg", "chair"],
						"imgPath": "D6A_4.png"
					},
					{
						"imageName": ["four-leg", "table"],
						"imgPath": "D6A_5.png"
					},
					{
						"imageName": ["four-leg", "stretcher"],
						"imgPath": "D6A_6.png"
					},
					{
						"imageName": ["three-leg", "tripad"],
						"imgPath": "D6A_7.png"
					},
				],
			},
		]
	}, {
		"lang": "Kiswahili-Kenya",
		"data": [
			{
				"queNo": "D1B",
				"question": " <span style='color:blue'>(Elekeza kidole kwenye duara/circle za kijani/green kisha useme)</span> Tazama, ninaweka duara/circle zote za kijani/green kwenye saduku/box hii ya kijani/green <span style='color:blue'>(vuruta kisha udondoshe duara/circle zote za kijani/green, moja baada ya nyingine kwenye saduku/box ya kijani/green)</span>.",
				"question2": " Sasa, kama nilivyofanya, wewe pia utaweka duara/circles zote za manjano/yellow kwenye saduku/box hii. <span style='color:blue'>(Hoji zaidi: Mtoto akiachia katikati, muulize alikamilishe zoezi)</span>.",
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
				"question": " <span style='color:blue'>(Elekeza kidole kwenye pembetatu/triangle za buluu/blue kisha useme)</span> Tazama, ninaweka pembetatu/triangles zote za buluu/blue katika sanduku hili <span style='color:blue'>(vuruta kisha udondoshe pembetatu/triangles zote za buluu/blue, moja baada ya nyingine ndani ya sanduku)</span>.",
				"question2": "  Sasa, kama nilivyofanya, wewe pia utaweka duara/circles zote nyekundu/red ndani ya sanduku/box hili <span style='color:blue'>(onyesha sanduku/box lenyewe kwa kidole)</span>. <span style='color:blue'>(Hoji zaidi: Mtoto akiachia katikati, muulize alikamilishe zoezi)</span>.",
				"font": "1.6vw",
				"data": "",
				"object": ["circle-red"],
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
				"question": " <span style='color:blue'>(Elekeza kidole kwenye picha/picture kisha useme)</span> Tazama hapa kwa makini kisha uweke vifaa vyote vilivyo na miguu minne ndani ya sanduku/box hili <span style='color:blue'>(onyesha sanduku/box lenyewe kwa kidole)</span>.",
				"font": "1.6vw",
				"data": "",
				"object": ["four-leg"],
				"img": "",
				"jarCnt": 1,
				"colorObjects": [
					{
						"imageName": ["one-leg", "lamp"],
						"imgPath": "D6A_2.png"
					},
					{
						"imageName": ["three-leg", "stool"],
						"imgPath": "D6A_3.png"
					},
					{
						"imageName": ["four-leg", "chair"],
						"imgPath": "D6A_4.png"
					},
					{
						"imageName": ["four-leg", "table"],
						"imgPath": "D6A_5.png"
					},
					{
						"imageName": ["four-leg", "stretcher"],
						"imgPath": "D6A_6.png"
					},
					{
						"imageName": ["three-leg", "tripad"],
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
				"question": " <span style='color:blue'>(Onesha kwenye maduara ya rangi ya kijani na useme)</span> Angalia, Ninaweka maduara yote ya rangi ya kijani humu. <span style='color:blue'>(Hamisha maduara yote ya rangi ya kijani , moja baada ya lingine kwenye sanduku/box)</span>.",
				"question2": " Sasa, kama nilivofanya, Inabidi uweke maduara yote ya rangi ya njano humu <span style='color:blue'>(onesha kwenye sanduku/box)</span>. <span style='color:blue'>(Shawishi: Endapo mtoto ataacha zoezi kabla ya kumaliza, mshawishi amalize zoezi)</span>",
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
				"question": " <span style='color:blue'>(Onesha kwenye pembetatu za rangi ya blu na useme)</span> Angalia ninawela pembetatu za rangi ya blu zote humu <span style='color:blue'>(hamisha pembetatu za rangi ya blu zote , moja baada ya nyingine kwenye sanduku)</span>",
				"question2": " Sasa, Kama nilivofanya, inakubidi uweke maduara ya rangi nyekundu yote humu <span style='color:blue'>(onesha kwenye sanduku/box)</span>. <span style='color:blue'>(Shawish:Endapo mtoto ataacha zoezi katikati, mshawishi amalize zoezi)</span>.",
				"font": "1.6vw",
				"data": "",
				"object": ["circle-red"],
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
				"question": " <span style='color:blue'>(Onesha picha na useme)</span> Angalia hapa kwa makini na uweke vitu vyote vyenye miguu minne(4) humu <span style='color:blue'>(onesha kwenye sanduku/box)</span>",
				"font": "1.6vw",
				"data": "",
				"object": ["four-leg"],
				"img": "",
				"jarCnt": 1,
				"colorObjects": [
					{
						"imageName": ["one-leg", "lamp"],
						"imgPath": "D6A_2.png"
					},
					{
						"imageName": ["three-leg", "stool"],
						"imgPath": "D6A_3.png"
					},
					{
						"imageName": ["four-leg", "chair"],
						"imgPath": "D6A_4.png"
					},
					{
						"imageName": ["four-leg", "table"],
						"imgPath": "D6A_5.png"
					},
					{
						"imageName": ["four-leg", "stretcher"],
						"imgPath": "D6A_6.png"
					},
					{
						"imageName": ["three-leg", "tripad"],
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
				"question": " <span style='color:blue'>( سبز رنگ کے دائروں کی طرف اشارہ کریں اور کہیں)</span> یہ دیکھو، میں سبز رنگ کے تمام دائرے اس ڈبے میں ڈال رہا/رہی ہوں۔<span style='color:blue'>(ایک ایک کر کے سبز رنگ کے دائرے ڈبے میں ڈالیں)</span>",
				"question2": " جیسے میں نے کیا اب آپ اسی طرح پیلے رنگ کے تمام دائروں کو اس ڈبے <span style='color:blue'>( ڈبے کی طرف اشارہ کریں)</span>میں ڈالیں۔<span style='color:blue'>(ہدایت: اگر بچہ کہیں درمیان میں یہ ٹاسک چھوڑ دیتا ہے تو اسے ٹاسک مکمل کرنے کو کہیں)</span>",
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
				"question": " <span style='color:blue'>(دی گئی نیلے رنگ کی مثلثوں کی طرف اشارہ کریں اور کہیں)</span> دیکھو میں نیلے رنگ کی تمام مثلثیں یہاں ڈال رہا/رہی ہوں <span style='color:blue'>(ایک ایک کر کے نیلے رنگ کی تمام مثلثوں کو دیے گئے ڈبہ میں ڈالیں)</span> ۔",
				"question2": " جیسے میں نے کیا اب آپ اسی طرح لال رنگ کے تمام دائروں کو اس ڈبے <span style='color:blue'>( ڈبے کی طرف اشارہ کریں)</span>میں ڈالیں۔<span style='color:blue'>( ہدایت: اگر بچہ کہیں درمیان میں یہ ٹاسک چھوڑ دیتا ہے تو اسے ٹاسک مکمل کرنے کو کہیں)</span>",
				"font": "1.6vw",
				"data": "",
				"object": ["circle-red"],
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
				"question": " <span style='color:blue'>(تصویر کی طرف اشارہ کریں اور کہیں)</span> انہیں غور سے دیکھو اور چار ٹانگوں والی تمام چیزوں کو یہاں <span style='color:blue'>(ڈبے کی طرف اشارہ کریں)</span> رکھو۔",
				"font": "1.6vw",
				"data": "",
				"object": ["four-leg"],
				"img": "",
				"jarCnt": 1,
				"colorObjects": [
					{
						"imageName": ["one-leg", "lamp"],
						"imgPath": "D6A_2.png"
					},
					{
						"imageName": ["three-leg", "stool"],
						"imgPath": "D6A_3.png"
					},
					{
						"imageName": ["four-leg", "chair"],
						"imgPath": "D6A_4.png"
					},
					{
						"imageName": ["four-leg", "table"],
						"imgPath": "D6A_5.png"
					},
					{
						"imageName": ["four-leg", "stretcher"],
						"imgPath": "D6A_6.png"
					},
					{
						"imageName": ["three-leg", "tripad"],
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
				"question": " <span style='color:blue'>(Señala los círculos de color verde y di)</span> Mira, estoy poniendo todos los círculos de color verde aquí <span style='color:blue'>(arrastra y coloca los círculos verdes uno por uno dentro del cuadro).</span>",
				"question2": " Ahora, como yo lo hice, tienes que poner todos los círculos de color amarillo aquí <span style='color:blue'>(señala el cuadro)</span>. <span style='color:blue'>(Intrucción: Si el(la) niño(a) deja la tarea a medias, pídele que la complete).</span>",
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
				"question": " <span style='color:blue'> (Señala los animales y las aves y di)</span> Obsérvalos con atención. Ahora, pon todas las aves aquí <span style='color:blue'>(señala la sección de aves)</span> y todos los animales aquí <span style='color:blue'>(señala la sección de animales). </span> <span style='color:blue'>(Instrucción: Si el(la) niño(a) deja la tarea a medias, pídele que la complete).</span>",
				"font": "1.6vw",
				"data": "",
				"object": ["bird", "animal"],
				"img": "",
				"jarCnt": 2,
				"animalText": "Animales",
				"birdText": "Aves",
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
				"vegText": "Vegetales",
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
				"question": " <span style='color:blue'>(Señala los triángulos color azul y di)</span> Mira, estoy poniendo todos los triángulos color azul aquí <span style='color:blue'>(arrastra y coloca todos los triángulos de color azul uno por uno dentro del cuadro).</span>",
				"question2": " Ahora, como yo lo hice, tienes que poner todos los círculos de color rojo aquí <span style='color:blue'>(señala el cuadro).</span> <span style='color:blue'>(Instrucción: Si el(la) niño(a) deja la tarea a medias, pídele que la complete).</span>",
				"font": "1.6vw",
				"data": "",
				"object": ["circle-red"],
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
				"queNo": "D4B",
				"question": " <span style='color:blue'>(Señala los triángulos color azul y di)</span> Mira, estoy poniendo todos los triángulos color azul aquí <span style='color:blue'>(arrastra y coloca todos los triángulos de color azul uno por uno dentro del cuadro).</span>",
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
				"question": " <span style='color:blue'>(Señala las imágenes y di)</span> Obsérvalos con atención y pon todo los objetos que tengan 4 patas aquí <span style='color:blue'>(señala la caja).</span>",
				"font": "1.6vw",
				"data": "",
				"object": ["four-leg"],
				"img": "",
				"jarCnt": 1,
				"colorObjects": [
					{
						"imageName": ["one-leg", "lamp"],
						"imgPath": "D6A_2.png"
					},
					{
						"imageName": ["three-leg", "stool"],
						"imgPath": "D6A_3.png"
					},
					{
						"imageName": ["four-leg", "chair"],
						"imgPath": "D6A_4.png"
					},
					{
						"imageName": ["four-leg", "table"],
						"imgPath": "D6A_5.png"
					},
					{
						"imageName": ["four-leg", "stretcher"],
						"imgPath": "D6A_6.png"
					},
					{
						"imageName": ["three-leg", "tripad"],
						"imgPath": "D6A_7.png"
					},
				],
			},
		]
	}, {
		"lang": "Spanish-Nicaragua",
		"data": [
			{
				"queNo": "D1B",
				"question": "<span style='color:blue'>(Señala los círculos de color verde y explica)</span> Mira, estoy poniendo todos los círculos de color verde aquí <span style='color:blue'>(arrastra y suelta todos los círculos verdes uno por uno en el cuadro)</span>.",
				"question2": " Ahora, como lo hice yo, tienes que poner todos los círculos de color amarillo aquí <span style='color:blue'>(Señala el cuadro)</span>. <span style='color:blue'>(Indicación: Si el niño o la niña deja la tarea a mitad de camino, pedirle que la complete)</span>",
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
				"question": " <span style='color:blue'>(Señala los animales y aves y explica)</span> Mira estos con atención. Ahora, pon todos los aves aquí <span style='color:blue'>(señala el cuadro de los animales)</span> y todos los animales aquí <span style='color:blue'>(señala el cuadro de los animales)</span>. <span style='color:blue'>(Indicación: Si el niño o la niña deja la tarea a mitad de camino, pedirle que la complete)</span>",
				"font": "1.6vw",
				"data": "",
				"object": ["bird", "animal"],
				"img": "",
				"jarCnt": 2,
				"animalText": "animales",
				"birdText": "aves",
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
				"question": " <span style='color:blue'>(Señala los dibujos y explica)</span> Mira estos con atención. Ahora, pon todas las frutas aquí <span style='color:blue'>(señala el cuadro de las frutas)</span> y todas las verduras aquí <span style='color:blue'>(señala el cuadro de las verduras)</span>. <span style='color:blue'>(Indicación: Si el niño o la niña deja la tarea a mitad de camino, pedirle que la complete)</span>",
				"font": "1.6vw",
				"data": "",
				"object": ["fruit", "vegetable"],
				"img": "",
				"jarCnt": 2,
				"fruitText": "Frutas",
				"vegText": "Verduras",
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
				"question": "<span style='color:blue'>(Señala los triángulos de color azul y explica)</span> Mira, estoy poniendo todos los triángulos de color azul aquí <span style='color:blue'>(arrastra y suelta los triángulos de color azul uno por uno en el cuadro)</span>.",
				"question2": " Ahora, como lo hice yo, tienes que poner todos los triángulos de color rojo aquí <span style='color:blue'>(señala el cuadro)</span>. <span style='color:blue'>(Indicación: Si el niño o la niña deja la tarea a mitad de camino, pedirle que la complete)</span>",
				"font": "1.6vw",
				"data": "",
				"object": ["circle-red"],
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
				"queNo": "D4B",
				"question": "<span style='color:blue'>Point to the blue coloured triangles and say</span> Look I am putting all the blue-coloured triangles here <span style='color:blue'>drag and drop all blue coloured triangles one by one into the box</span>.",
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
				"question": " <span style='color:blue'>(Señala los dibujos y explica)</span> Mira con atención estos dibujos y pon todos los objetos de 4 patas aquí <span style='color:blue'>(señala el cuadro.)</span>",
				"font": "1.6vw",
				"data": "",
				"object": ["four-leg"],
				"img": "",
				"jarCnt": 1,
				"colorObjects": [
					{
						"imageName": ["one-leg", "lamp"],
						"imgPath": "D6A_2.png"
					},
					{
						"imageName": ["three-leg", "stool"],
						"imgPath": "D6A_3.png"
					},
					{
						"imageName": ["four-leg", "chair"],
						"imgPath": "D6A_4.png"
					},
					{
						"imageName": ["four-leg", "table"],
						"imgPath": "D6A_5.png"
					},
					{
						"imageName": ["four-leg", "stretcher"],
						"imgPath": "D6A_6.png"
					},
					{
						"imageName": ["three-leg", "tripad"],
						"imgPath": "D6A_7.png"
					},
				],
			},
		]
	},
	{
		"lang": "Bangla-Bangladesh",
		"data": [
			{
				"queNo": "D1B",
				"question": " <span style='color:blue'>(সবুজ রঙের বৃত্তগুলো কে দেখিয়ে বলুন)</span> দেখো, আমি সব সবুজ রঙের বৃত্তগুলো এইখানে রাখছি। <span style='color:blue'>(আঙ্গুল দিয়ে টেনে এক এক করে সবগুলো সবুজ বৃত্ত বাক্সতে রাখুন)</span>",
				"question2": " যেভাবে আমি করলাম, সেভাবে তুমিও এখন সব হলুদ রঙের বৃত্তগুলো এইখানে <span style='color:blue'>(বাক্সটি দেখান)</span> রাখো। <span style='color:blue'>(উদ্দীপক: যদি বাচ্চাটি মাঝপথে থেমে যায়, তবে তাকে কাজটি সম্পূর্ণ করতে বলুন)</span>",
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
				"question": " <span style='color:blue'>(নীল রঙের ত্রিভুজগুলো দেখিয়ে বলুন)</span> দেখো, আমি সব নীল রঙের ত্রিভুজগুলো এখানে রাখছি <span style='color:blue'>(আঙ্গুল দিয়ে টেনে এক এক করে সবগুলো নীল রঙের ত্রিভুজ বাক্সতে রাখুন)</span>",
				"question2": " যেভাবে আমি করলাম, সেভাবে তুমিও এখন সব লাল রঙের বৃত্তগুলো এখানে রাখো <span style='color:blue'>(বাক্সটি দেখান)</span>। <span style='color:blue'>(উদ্দীপক: যদি বাচ্চাটি মাঝপথে থেমে যায়, তবে তাকে কাজটি সম্পূর্ণ করতে বলুন)</span>",
				"font": "1.6vw",
				"data": "",
				"object": ["circle-red"],
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
				"question": " <span style='color:blue'>(ছবিগুলো দেখিয়ে বলুন)</span> মনোযোগ দিয়ে এগুলো দেখো এবং এখানের যেসব বস্তুর ৪টি পা আছে, সেগুলোকে এখানে রাখো <span style='color:blue'>(বাক্সটি দেখান)</span>",
				"font": "1.6vw",
				"data": "",
				"object": ["four-leg"],
				"img": "",
				"jarCnt": 1,
				"colorObjects": [
					{
						"imageName": ["one-leg", "lamp"],
						"imgPath": "D6A_2.png"
					},
					{
						"imageName": ["three-leg", "stool"],
						"imgPath": "D6A_3.png"
					},
					{
						"imageName": ["four-leg", "chair"],
						"imgPath": "D6A_4.png"
					},
					{
						"imageName": ["four-leg", "table"],
						"imgPath": "D6A_5.png"
					},
					{
						"imageName": ["four-leg", "stretcher"],
						"imgPath": "D6A_6.png"
					},
					{
						"imageName": ["three-leg", "tripad"],
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
				"question": " <span style='color:blue'>(Regarde les cercles de couleur verte et dis)</span> Regarde, je mets tous les cercles de couleur verte ici <span style='color:blue'>(glisse et dépose les cercles verts un à un dans la boîte)</span>.",
				"question2": " Maintenant, comme je l'ai fait, tu dois mettre tous les cercles de couleur jaune ici <span style='color:blue'>(montre la boite)</span>. <span style='color:blue'>(Invite : Si l'enfant quitte la tâche à mi-chemin, demandes-lui de terminer la tâche)</span>",
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
				"question": " <span style='color:blue'>(Regarde les triangles bleus et dis)</span> Regarde, je mets tous les triangles bleus ici <span style='color:blue'>(glisse-dépose tous les triangles bleus un à un dans la boite)</span>.",
				"question2": "  Maintenant, comme je l'ai fait, tu dois mettre tous les cercles de couleur rouge ici <span style='color:blue'>(pointe sur la boite)</span>. <span style='color:blue'>(Invite : Si l'enfant quitte la tâche à mi-chemin, demande-lui de terminer la tâche)</span>",
				"font": "1.6vw",
				"data": "",
				"object": ["circle-red"],
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
				"question": " <span style='color:blue'>(Regarde les images et dis)</span> Regarde-les attentivement et place tous les objets à 4 pattes ici <span style='color:blue'>(pointe sur la boîte.)</span>",
				"font": "1.6vw",
				"data": "",
				"object": ["four-leg"],
				"img": "",
				"jarCnt": 1,
				"colorObjects": [
					{
						"imageName": ["one-leg", "lamp"],
						"imgPath": "D6A_2.png"
					},
					{
						"imageName": ["three-leg", "stool"],
						"imgPath": "D6A_3.png"
					},
					{
						"imageName": ["four-leg", "chair"],
						"imgPath": "D6A_4.png"
					},
					{
						"imageName": ["four-leg", "table"],
						"imgPath": "D6A_5.png"
					},
					{
						"imageName": ["four-leg", "stretcher"],
						"imgPath": "D6A_6.png"
					},
					{
						"imageName": ["three-leg", "tripad"],
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
				"question": " <span style='color:blue'>(Regarde les cercles de couleur verte et dis)</span> Regarde, je mets tous les cercles de couleur verte ici <span style='color:blue'>(glisse et dépose les cercles verts un à un dans la boîte)</span>.",
				"question2": " Maintenant, comme je l'ai fait, tu dois mettre tous les cercles de couleur jaune ici <span style='color:blue'>(montre la boite)</span>. <span style='color:blue'>(Invite : Si l'enfant quitte la tâche à mi-chemin, demandes-lui de terminer la tâche)</span>",
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
				"question": " <span style='color:blue'>(Regarde les triangles bleus et dis)</span> Regarde, je mets tous les triangles bleus ici <span style='color:blue'>(glisse-dépose tous les triangles bleus un à un dans la boite)</span>.",
				"question2": " Maintenant, comme je l'ai fait, tu dois mettre tous les cercles de couleur rouge ici <span style='color:blue'>(pointe sur la boite)</span>. <span style='color:blue'>(Invite : Si l'enfant quitte la tâche à mi-chemin, demande-lui de terminer la tâche)</span>",
				"font": "1.6vw",
				"data": "",
				"object": ["circle-red"],
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
				"question": " <span style='color:blue'>(Regarde les images et dis)</span> Regarde-les attentivement et place tous les objets à 4 pattes ici <span style='color:blue'>(pointe sur la boîte.)</span>",
				"font": "1.6vw",
				"data": "",
				"object": ["four-leg"],
				"img": "",
				"jarCnt": 1,
				"colorObjects": [
					{
						"imageName": ["one-leg", "lamp"],
						"imgPath": "D6A_2.png"
					},
					{
						"imageName": ["three-leg", "stool"],
						"imgPath": "D6A_3.png"
					},
					{
						"imageName": ["four-leg", "chair"],
						"imgPath": "D6A_4.png"
					},
					{
						"imageName": ["four-leg", "table"],
						"imgPath": "D6A_5.png"
					},
					{
						"imageName": ["four-leg", "stretcher"],
						"imgPath": "D6A_6.png"
					},
					{
						"imageName": ["three-leg", "tripad"],
						"imgPath": "D6A_7.png"
					},
				],
			},
		]
	},
	{
		"lang": "Nepali-Nepal",
		"data": [
			{
				"queNo": "D1B",
				"question": " <span style='color:blue'>(हरियो रंगको वृत्तहरुलाई देखाउनुहोस् र भन्नुहोस् )</span> हेर्नुहोस् मैले हरियो रङ्गको सबै वृत्तलाई यो यहाँ राखिरहेको छु <span style='color:blue'>(हरियो रंगको सबै वृत्तहरुलाई एक एक गर्दै तानेर बाकसमा राख्नुहोस् </span> ।",
				"question2": " अब, तपाईले पंहेलो रंगको सबै वृत्तहरुलाई मैले गरेको जस्तै गरि यहाँ राख्नुहोस । <span style='color:blue'>(नोट: यदि बच्चाले यो कार्य गर्दै गर्दा बिचमै छोड्छ भने, उस्लाई यो कार्य पुरा गर्न लगाउनुहोस् )</span>",
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
				"question": " <span style='color:blue'>(नीलो रंगको त्रिकोणहरुलाई देखाउनुहोस् र भन्नुहोस् )</span> हेर्नुहोस् त म नीलो रंगको सबै त्रिकोणहरुलाई यहाँ राख्दै छु <span style='color:blue'>(नीलो रंगको सबै त्रिकोणलाई एक एक गरि तान्दै बाकस भित्र राख्नुहोस् )</span>।",
				"question2": " अब, मैले गरेको जस्तै गरि रातो रंगको सबै वृत्तहरुलाई तपाइले यहाँ राख्नु पर्नेछ <span style='color:blue'>(बाकसलाई देखाउनुहोस् )</span>। <span style='color:blue'>(नोट: यदि बच्चाले यो कार्य गर्दा गर्दा बिचमै छोड्छ भने, उस्लाई यो कार्य पुरा गर्न लगाउनुहोस् )</span>",
				"font": "1.6vw",
				"data": "",
				"object": ["circle-red"],
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
				"question": " <span style='color:blue'>(चित्रलाई देखाउनुहोस् र भन्नुहोस् )</span> यी वस्तुहरुलाई ध्यान दिएर हेर्नुहोस् र ४ ओटा खुट्टा भएका सबै वस्तुहरुलाई यहाँ राख्नुहोस् <span style='color:blue'>( बाकसलाई देखाउनुहोस् । )</span>",
				"font": "1.6vw",
				"data": "",
				"object": ["four-leg"],
				"img": "",
				"jarCnt": 1,
				"colorObjects": [
					{
						"imageName": ["one-leg", "lamp"],
						"imgPath": "D6A_2.png"
					},
					{
						"imageName": ["three-leg", "stool"],
						"imgPath": "D6A_3.png"
					},
					{
						"imageName": ["four-leg", "chair"],
						"imgPath": "D6A_4.png"
					},
					{
						"imageName": ["four-leg", "table"],
						"imgPath": "D6A_5.png"
					},
					{
						"imageName": ["four-leg", "stretcher"],
						"imgPath": "D6A_6.png"
					},
					{
						"imageName": ["three-leg", "tripad"],
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
				"question": " <span style='color:blue'>(Aponte para os círculos de cor verde e diga)</span> Olha, estou colocando todos os círculos de cor verde aqui <span style='color:blue'>(arraste e solte os círculos verdes um a um na caixa)</span>.",
				"question2": " Agora, como eu fiz, você tem que colocar todos os círculos de cor amarela aqui <span style='color:blue'>(aponte para a caixa)</span>. <span style='color:blue'>(Aviso: Se a criança não terminar a tarefa, peça-lhe para terminar)</span>",
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
				"question": " <span style='color:blue'>(Aponte para os triângulos de cor azul e diga)</span> Olha, estou colocando todos os triângulos de cor azul aqui <span style='color:blue'>(arraste e solte todos os triângulos coloridos azuis um a um para a caixa)</span>.",
				"question2": " Agora, como eu fiz, você tem que colocar todos os círculos de cor vermelha aqui <span style='color:blue'>(ponto para a caixa)</span>. <span style='color:blue'>(Aviso: Se a criança não terminar a tarefa, peça-lhe para terminar) </span>",
				"font": "1.6vw",
				"data": "",
				"object": ["circle-red"],
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
				"question": " <span style='color:blue'>(Aponte para as fotos e diga)</span> Observe com atenção e coloque todos os objetos com 4 pernas aqui <span style='color:blue'>(aponte para a caixa.) </span>",
				"font": "1.6vw",
				"data": "",
				"object": ["four-leg"],
				"img": "",
				"jarCnt": 1,
				"colorObjects": [
					{
						"imageName": ["one-leg", "lamp"],
						"imgPath": "D6A_2.png"
					},
					{
						"imageName": ["three-leg", "stool"],
						"imgPath": "D6A_3.png"
					},
					{
						"imageName": ["four-leg", "chair"],
						"imgPath": "D6A_4.png"
					},
					{
						"imageName": ["four-leg", "table"],
						"imgPath": "D6A_5.png"
					},
					{
						"imageName": ["four-leg", "stretcher"],
						"imgPath": "D6A_6.png"
					},
					{
						"imageName": ["three-leg", "tripad"],
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
