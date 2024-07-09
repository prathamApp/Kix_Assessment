
Measurement.hardcodedData = { 
    'surveyorInstr':'Could the child recognize this ?',
    'yes':'Yes',
    'no':'No',
}

Measurement.imageData = [
	{
		'language': 'English-Uganda',		//0
		'languageFont':'fonts/Andika-Regular.ttf',
		'ansText':'Answer :',
		'gameArray':[
			{
				'gameName': 'M11B',
				"questionText": "<span style='color:blue'>(Point to the picture and say)</span> Look at this carefully and tell me, the <b>length</b> of the key in <b>centimetres</b> <span style='color:blue'>(point to the key)</span>.",
				'data': [
					{
						'questionId': 1,
						'ansImg': 'M11B',
						'answer': '4',
					},
				]
			},
			/* {
				'gameName': 'M11C',
				"questionText": "<span style='color:blue'>(Point to the picture and say)</span> Look at this carefully and tell me how many centimeters long is this <span style='color:blue'>(point to the pencil)</span> pencil?",
				'data': [
					{
						'questionId': 2,
						'ansImg': 'M11C',
						'answer': '6',
					},
				]
			}, */
			{
				'gameName': 'M12A',
				'answer': '1',
				'questionText': "<span style='color:blue'>(Point to the pictures and say)</span> Look at this carefully and tell me, by how many <b>centimetres</b> is one key <b>shorter</b> than the other?",
				'data': [
					{
						'questionId': 3,
						'ansImg': 'M12A_1',
						'answer': '2',
					},
					{
						'questionId': 4,
						'ansImg': 'M12A_2',
						'answer': '',
					},
				]
			},
			/* {
				'gameName': 'M12B',
				'answer':'1',
				'questionText': "<span style='color:blue'>(Point to the picture and say)</span> Look at this carefully. Tell me by how many centimetres is one pencil <span style='color:blue'>(point to both the pencils)</span> longer than the other?",
				'data': [
					{
						'questionId': 5,
						'ansImg': 'M12B',
						'answer': '1',
					},
				]
			},
			{
				'gameName': 'M12C',
				'questionText': "<span style='color:blue'>(Point to the options and say)</span> Look at these carefully. Place your finger and tell me which set of weights is heavier?",
				'data': [
					{
						'questionId': 6,
						'ansImg': 'M12C_1',
						'answer': 'Correct',
						"ansData":"A"
					},
					{
						'questionId': 7,
						'ansImg': 'M12C_2',
						'answer': 'Wrong',
						"ansData":"B"
					},
				]
			}, */
		]
	},
	{
		'language': 'Hindi-India',			//1
		'languageFont':'',
		'ansText':'उत्तर :',
		'gameArray':[
			{
				'gameName': 'M11B',
				"questionText": "<span style='color:blue'>(चित्र की ओर इशारा करते हुए कहें)</span> इसे ध्यान से देखो और मुझे इस चाबी <span style='color:blue'>(चाबी की ओर इशारा करें)</span> की <b>लम्बाई</b> <b>सेंटीमीटर</b> में बताओ। ",
				'data': [
					{
						'questionId': 1,
						'ansImg': 'M11B',
						'answer': '4',
					},
				]
			},
			/* {
				'gameName': 'M11C',
				"questionText": "<span style='color:blue'>(Point to the picture and say)</span> Look at this carefully and tell me how many centimeters long is this <span style='color:blue'>(point to the pencil)</span> pencil?",
				'data': [
					{
						'questionId': 2,
						'ansImg': 'M11C',
						'answer': '6',
					},
				]
			}, */
			{
				'gameName': 'M12A',
				'answer': '1',
				'questionText': "<span style='color:blue'>(चित्रों की ओर इशारा करते हुए कहें)</span> इन्हें ध्यान से देखो और मुझे बताओ की एक चाबी दूसरे से कितनी <b>सेंटीमीटर</b> <b>छोटी</b> है?",
				'data': [
					{
						'questionId': 3,
						'ansImg': 'M12A_1',
						'answer': '2',
					},
					{
						'questionId': 4,
						'ansImg': 'M12A_2',
						'answer': '',
					},
				]
			},
			/* {
				'gameName': 'M12B',
				'answer':'1',
				'questionText': "<span style='color:blue'>(Point to the picture and say)</span> Look at this carefully. Tell me by how many centimetres is one pencil <span style='color:blue'>(point to both the pencils)</span> longer than the other?",
				'data': [
					{
						'questionId': 5,
						'ansImg': 'M12B',
						'answer': '1',
					},
				]
			},
			{
				'gameName': 'M12C',
				'questionText': "<span style='color:blue'>(Point to the options and say)</span> Look at these carefully. Place your finger and tell me which set of weights is heavier?",
				'data': [
					{
						'questionId': 6,
						'ansImg': 'M12C_1',
						'answer': 'Correct',
						"ansData":"A"
					},
					{
						'questionId': 7,
						'ansImg': 'M12C_2',
						'answer': 'Wrong',
						"ansData":"B"
					},
				]
			}, */
		]
	},
	{
		'language': 'Spanish-Mexico',		//2
		'languageFont':'',
		'ansText':'Respuesta :',
		'gameArray':[
			{
				'gameName': 'M11B',
				'questionText': "<span style='color:blue'>(Señala la imagen y di)</span> Obsérvala con atención y dime el <b>largo</b> de la llave en <b>centímetros</b> <span style='color:blue'>(señala la llave)</span>.",
				'data': [
					{
						'questionId': 1,
						'ansImg': 'M11B',
						'answer': '4',
					},
				]
			}, 
			/* {
				'gameName': 'M11C',
				'questionText': "<span style='color:blue'>(Señala la imagen y di)</span> Observa con atención y dime, ¿cuántos centímetros mide este <span style='color:blue'>(señala el lápiz)</span> lápiz?",
				'data': [
					{
						'questionId': 2,
						'ansImg': 'M11C',
						'answer': '6',
					},
				]
			}, */
			{
				'gameName': 'M12A',
				'answer': '1',
				'questionText': "<span style='color:blue'>(Señala las imágenes y di)</span> Observa con atención y dime, ¿por cuántos <b>centímetros</b> es  <b>más corta</b> una llave que la otra?",
				'data': [
					{
						'questionId': 3,
						'ansImg': 'M12A_1',
						'answer': '2',
					},
					{
						'questionId': 4,
						'ansImg': 'M12A_2',
						'answer': '',
					},
				]
			},
			/* {
				'gameName': 'M12B',
				'questionText': "<span style='color:blue'>(Señala la imagen y di)</span> Obsérvalos con atención. Dime, ¿por cuántos centímetros es más largo <span style='color:blue'>(señala ambos lápices)</span> un lápiz que el otro?",
				'data': [
					{
						'questionId': 5,
						'ansImg': 'M12B',
						'answer': '1',
					},
				]
			},
			{
				'gameName': 'M12C',
				'questionText': "",
				'data': [
					{
						'questionId': 6,
						'ansImg': 'M12C_1',
						'answer': 'Correct',
						"ansData":"A"
					},
					{
						'questionId': 7,
						'ansImg': 'M12C_2',
						'answer': 'Wrong',
						"ansData":"B"
					},
				]
			}, */
		]
	},
	{
		'language': 'Spanish-Nicaragua',	//3
		'languageFont':'fonts/AntarcticaRegular.ttf',
		'ansText':'Respuesta :',
		'gameArray':[
			{
				'gameName': 'M11B',
				'questionText': "<span style='color:blue'>(Señale el dibujo y diga)</span> Mirá esto con atención y decime la <b>longitud</b> de la llave en <b>centímetros</b> <span style='color:blue'>(señale la llave)</span>.",
				'data': [
					{
						'questionId': 1,
						'ansImg': 'M11B',
						'answer': '4',
					},
				]
			}, 
			/* {
				'gameName': 'M11C',
				'questionText': "<span style='color:blue'>(Señala el dibujo y explica)</span> Mira este con atención y dime: ¿cuántos centímetros mide este <span style='color:blue'>(señala el lápiz)</span> lápiz?",
				'data': [
					{
						'questionId': 2,
						'ansImg': 'M11C',
						'answer': '6',
					},
				]
			}, */
			{
				'gameName': 'M12A',
				'answer': '1',
				'questionText': "<span style='color:blue'>(Señale las imágenes y diga)</span> Mirá esto con atención y decime, ¿por cuántos <b>centímetros</b> es una llave <b>más corta</b> que la otra?",
				'data': [
					{
						'questionId': 3,
						'ansImg': 'M12A_1',
						'answer': '2',
					},
					{
						'questionId': 4,
						'ansImg': 'M12A_2',
						'answer': '',
					},
				]
			},
			/* {
				'gameName': 'M12B',
				'questionText': "<span style='color:blue'>(Señala la imagen y explica)</span> Mira esta con atención. Dime en cuántos centímetros es un lápiz <span style='color:blue'> (señala los dos lápices)</span> más largo que el otro.",
				'data': [
					{
						'questionId': 5,
						'ansImg': 'M12B',
						'answer': '1',
					},
				]
			},
			{
				'gameName': 'M12C',
				'questionText': "",
				'data': [
					{
						'questionId': 6,
						'ansImg': 'M12C_1',
						'answer': 'Correct',
						"ansData":"A"
					},
					{
						'questionId': 7,
						'ansImg': 'M12C_2',
						'answer': 'Wrong',
						"ansData":"B"
					},
				]
			}, */
		]
	},
	{
		'language': 'Kiswahili-Kenya',		//4
		'languageFont':'fonts/Andika-Regular.ttf',
		'ansText':'Jawabu :',
		'gameArray':[
			{
				'gameName': 'M11B',
				'questionText': "<span style='color:blue'>(Onyesha kwenye picha na useme)</span> Angalia hili kwa makini na uniambie, <b>urefu</b> wa ufunguo katika <b>sentimita</b> <span style='color:blue'>(onyesha ufunguo)</span>.",
				'data': [
					{
						'questionId': 1,
						'ansImg': 'M11B',
						'answer': '4',
					},
				]
			}, 
			/* {
				'gameName': 'M11C',
				'questionText': "<span style='color:blue'>(Señala la imagen y di)</span> Observa con atención y dime, ¿cuántos centímetros mide este <span style='color:blue'>(señala el lápiz)</span> lápiz?",
				'data': [
					{
						'questionId': 2,
						'ansImg': 'M11C',
						'answer': '6',
					},
				]
			}, */
			{
				'gameName': 'M12A',
				'answer': '1',
				'questionText': "<span style='color:blue'>(Onyesha picha na useme)</span> Angalia hili kwa makini na uniambie, ufunguo mmoja una <b>ufupi</b> wa <b>sentimita</b> ngapi sentimeta ngapi kuliko ufunguo mwingine?",
				'data': [
					{
						'questionId': 3,
						'ansImg': 'M12A_1',
						'answer': '2',
					},
					{
						'questionId': 4,
						'ansImg': 'M12A_2',
						'answer': '',
					},
				]
			},
			/* {
				'gameName': 'M12B',
				'questionText': "<span style='color:blue'>(Señala la imagen y di)</span> Obsérvalos con atención. Dime, ¿por cuántos centímetros es más largo <span style='color:blue'>(señala ambos lápices)</span> un lápiz que el otro?",
				'data': [
					{
						'questionId': 5,
						'ansImg': 'M12B',
						'answer': '1',
					},
				]
			},
			{
				'gameName': 'M12C',
				'questionText': "",
				'data': [
					{
						'questionId': 6,
						'ansImg': 'M12C_1',
						'answer': 'Correct',
						"ansData":"A"
					},
					{
						'questionId': 7,
						'ansImg': 'M12C_2',
						'answer': 'Wrong',
						"ansData":"B"
					},
				]
			}, */
		]
	},
	{
		'language': 'French-Senegal',		//5
		'languageFont':'',
		'ansText':'Réponse :',
		'gameArray':[
			{
				'gameName': 'M11B',
				'questionText': "<span style='color:blue'>(Pointe l'image et dis)</span> Regarde attentivement et dis-moi, la <b>longueur</b> de la clé en <b>centimètres</b> <span style='color:blue'>(pointe la clé)</span>.   ",
				'data': [
					{
						'questionId': 1,
						'ansImg': 'M11B',
						'answer': '4',
					},
				]
			}, 
			/* {
				'gameName': 'M11C',
				'questionText': "<span style='color:blue'>(Regarde l'image et dis)</span> Regarde celle-ci attentivement et dis-moi combien de centimètres de long ce <span style='color:blue'>(montre le crayon)</span> crayon ?",
				'data': [
					{
						'questionId': 2,
						'ansImg': 'M11C',
						'answer': '6',
					},
				]
			}, */
			{
				'gameName': 'M12A',
				'answer': '1',
				'questionText': "<span style='color:blue'>(Montre les images et dit)</span> Regarde attentivement et dis-moi, de combien de <b>centimètres</b> une clé est-elle <b>plus courte</b> que l'autre ?",
				'data': [
					{
						'questionId': 3,
						'ansImg': 'M12A_1',
						'answer': '2',
					},
					{
						'questionId': 4,
						'ansImg': 'M12A_2',
						'answer': '',
					},
				]
			},
			/* {
				'gameName': 'M12B',
				'questionText': "<span style='color:blue'>(Regarde l'image et dis)</span> Regarde celle-ci attentivement. Dis-moi de combien de centimètres un crayon <span style='color:blue'>(pointe vers les deux crayons)</span> est plus long que l'autre ?",
				'data': [
					{
						'questionId': 5,
						'ansImg': 'M12B',
						'answer': '1',
					},
				]
			},
			{
				'gameName': 'M12C',
				'questionText': "",
				'data': [
					{
						'questionId': 6,
						'ansImg': 'M12C_1',
						'answer': 'Correct',
						"ansData":"A"
					},
					{
						'questionId': 7,
						'ansImg': 'M12C_2',
						'answer': 'Wrong',
						"ansData":"B"
					},
				]
			},  */
		]
	},
	{
		'language': 'Bangla-Bangladesh',	//6
		'languageFont':'fonts/kalpurush.ttf',
		'ansText':'উত্তর :',
		'gameArray':[
			{
				'gameName': 'M11B',
				'questionText': "<span style='color:blue'>(ছবিটি দেখিয়ে বলুন)</span> এটা মনোযোগ দিয়ে দেখে আমাকে বলতো এই চাবিটি <span style='color:blue'>(চাবিটি দেখান)</span> <b>দৈর্ঘ্যে</b> কত <b>সেন্টিমিটার</b> লম্বা?",
				'data': [
					{
						'questionId': 1,
						'ansImg': 'M11B',
						'answer': '4',
					},
				]
			}, 
			/* {
				'gameName': 'M11C',
				'questionText': "<span style='color:blue'>(ছবিটি দেখিয়ে বলুন)</span> এটি মনোযোগ দিয়ে দেখে আমাকে বলো এই পেন্সিলটি <span style='color:blue'>(পেন্সিলটিকে দেখিয়ে বলুন)</span> কত সেন্টিমিটার লম্বা?",
				'data': [
					{
						'questionId': 2,
						'ansImg': 'M11C',
						'answer': '6',
					},
				]
			}, */
			{
				'gameName': 'M12A',
				'answer': '1',
				'questionText': "<span style='color:blue'>(ছবিগুলো দেখিয়ে বলুন)</span> এগুলো মনোযোগ দিয়ে দেখে আমাকে বলো তো, এখানের একটা চাবি থেকে আরেকটা চাবি কত <b>সেন্টিমিটার</b> <b>খাটো/ছোট</b>?",
				'data': [
					{
						'questionId': 3,
						'ansImg': 'M12A_1',
						'answer': '2',
					},
					{
						'questionId': 4,
						'ansImg': 'M12A_2',
						'answer': '',
					},
				]
			},
			/* {
				'gameName': 'M12B',
				'questionText': "<span style='color:blue'>(ছবিটি দেখিয়ে বলুন)</span> এটি মনোযোগ দিয়ে দেখো। আমাকে বল তো এখানের একটা পেন্সিল থেকে আরেকটা পেন্সিল <span style='color:blue'>(দুটি পেন্সিলই দেখিয়ে বলুন)</span> কত সেন্টিমিটার লম্বা?",
				'data': [
					{
						'questionId': 5,
						'ansImg': 'M12B',
						'answer': '1',
					},
				]
			},
			{
				'gameName': 'M12C',
				'questionText': "",
				'data': [
					{
						'questionId': 6,
						'ansImg': 'M12C_1',
						'answer': 'Correct',
						"ansData":"A"
					},
					{
						'questionId': 7,
						'ansImg': 'M12C_2',
						'answer': 'Wrong',
						"ansData":"B"
					},
				]
			},  */
		]
	},
	{	
		'language': 'Nepali-Nepal',			//7
		'languageFont':'fonts/MANGAL.ttf',
		'ansText':'जवाफ :',
		'gameArray':[
			{
				'gameName': 'M11B',
				'questionText': "<span style='color:blue'>(चित्रमा देखाउँदै भन्नुहोस् )</span> यसलाई ध्यान दिएर हेर्नुहोस् र यो साँचोको <span style='color:blue'>(साँचोलाई देखाउनुहोस्)</span> <b>लम्बाई</b> कति <b>सेन्टिमिटर</b> छ भन्नुहोस् |",
				'data': [
					{
						'questionId': 1,
						'ansImg': 'M11B',
						'answer': '४',
					},
				]
			}, 
			/* {
				'gameName': 'M11C',
				'questionText': "<span style='color:blue'>(Regarde l'image et dis)</span> Regarde celle-ci attentivement et dis-moi combien de centimètres de long ce <span style='color:blue'>(montre le crayon)</span> crayon ?",
				'data': [
					{
						'questionId': 2,
						'ansImg': 'M11C',
						'answer': '6',
					},
				]
			}, */
			{
				'gameName': 'M12A',
				'answer': '1',
				'questionText': "<span style='color:blue'>(चित्रमा देखाउँदै भन्नुहोस्)</span> यसलाई ध्यान दिएर हेर्नुहोस् र भन्नुहोस् एउटा साँचो अर्को साँचो भन्दा कति <b>सेन्टिमिटर</b> ले <b>छोटो</b> छ ?",
				'data': [
					{
						'questionId': 3,
						'ansImg': 'M12A_1',
						'answer': '२',
					},
					{
						'questionId': 4,
						'ansImg': 'M12A_2',
						'answer': '',
					},
				]
			},
			/* {
				'gameName': 'M12B',
				'questionText': "<span style='color:blue'>(Regarde l'image et dis)</span> Regarde celle-ci attentivement. Dis-moi de combien de centimètres un crayon <span style='color:blue'>(pointe vers les deux crayons)</span> est plus long que l'autre ?",
				'data': [
					{
						'questionId': 5,
						'ansImg': 'M12B',
						'answer': '1',
					},
				]
			},
			{
				'gameName': 'M12C',
				'questionText': "",
				'data': [
					{
						'questionId': 6,
						'ansImg': 'M12C_1',
						'answer': 'Correct',
						"ansData":"A"
					},
					{
						'questionId': 7,
						'ansImg': 'M12C_2',
						'answer': 'Wrong',
						"ansData":"B"
					},
				]
			},  */
		]
	},
	{
		'language': 'French-Mali',			//8
		'languageFont':'',
		'ansText':'Réponse :',
		'gameArray':[
			{
				'gameName': 'M11B',
				"questionText": "<span style='color:blue'>(Pointe sur l’image et dis)</span> Regarde cela attentivement et dis-moi, la <b>longueur</b> de la clé en <b>centimetres</b> <span style='color:blue'>(pointe sur la clé)</span>.",
				'data': [
					{
						'questionId': 1,
						'ansImg': 'M11B',
						'answer': '4',
					},
				]
			},
			/* {
				'gameName': 'M11C',
				"questionText": "<span style='color:blue'>(Regarde l'image et dis)</span> Regarde celle-ci attentivement et dis-moi combien de centimètres de long ce <span style='color:blue'>(montre le crayon)</span> crayon ?",
				'data': [
					{
						'questionId': 2,
						'ansImg': 'M11C',
						'answer': '6',
					},
				]
			}, */
			{
				'gameName': 'M12A',
				'answer': '1',
				'questionText': "<span style='color:blue'>(Pointe sur les photos et dis)</span> Regarde cela attentivement et dis-moi, par combien de <b>centimetres</b> une clé est <b>plus courte</b> que l’autre?",
				'data': [
					{
						'questionId': 3,
						'ansImg': 'M12A_1',
						'answer': '2',
					},
					{
						'questionId': 4,
						'ansImg': 'M12A_2',
						'answer': '',
					},
				]
			},
			/* {
				'gameName': 'M12B',
				'answer':'1',
				'questionText': "<span style='color:blue'>(Regarde l'image et dis)</span> Regarde celle-ci attentivement. Dis-moi de combien de centimètres un crayon <span style='color:blue'>(pointe vers les deux crayons)</span> est plus long que l'autre ?",
				'data': [
					{
						'questionId': 5,
						'ansImg': 'M12B',
						'answer': '1',
					},
				]
			},
			{
				'gameName': 'M12C',
				'questionText': " <span style='color:blue'>(Elekeza kidole kwenye viteuzi kisha useme)</span> Tazama hapa kwa makini. Nionyeshe kwa kidole chako ni seti gani ya uzani ni nzito zaidi ya nyingine?",
				'data': [
					{
						'questionId': 6,
						'ansImg': 'M12C_1',
						'answer': 'Correct',
						"ansData":"A"
					},
					{
						'questionId': 7,
						'ansImg': 'M12C_2',
						'answer': 'Wrong',
						"ansData":"B"
					},
				]
			}, */
		]
	},
	{
		'language': 'Kiswahili-Tanzania',	//9
		'languageFont':'',
		'ansText':'Jawabu :',
		'gameArray':[
			{
				'gameName': 'M11B',
				'questionText': "<span style='color:blue'>(Onesha kwa kidole chako picha na useme)</span> Angalia hii kwa makini na uniambie, <b>urefu</b> wa funguo katika <b>sentimita</b> <span style='color:blue'>(onesha funguo)</span>",
				'data': [
					{
						'questionId': 1,
						'ansImg': 'M11B',
						'answer': '4',
					},
				]
			}, 
			/* {
				'gameName': 'M11C',
				'questionText': "<span style='color:blue'>(Señala la imagen y di)</span> Observa con atención y dime, ¿cuántos centímetros mide este <span style='color:blue'>(señala el lápiz)</span> lápiz?",
				'data': [
					{
						'questionId': 2,
						'ansImg': 'M11C',
						'answer': '6',
					},
				]
			}, */
			{
				'gameName': 'M12A',
				'answer': '1',
				'questionText': "<span style='color:blue'>(Onesha kwa kidole chako picha na useme)</span> Angalia hii kwa makini na uniambie, ni kwa <b>sentimita</b> ngapi funguo moja ni <b>fupi</b> kuliko funguo nyingine?",
				'data': [
					{
						'questionId': 3,
						'ansImg': 'M12A_1',
						'answer': '2',
					},
					{
						'questionId': 4,
						'ansImg': 'M12A_2',
						'answer': '',
					},
				]
			},
			/* {
				'gameName': 'M12B',
				'questionText': "<span style='color:blue'>(Señala la imagen y di)</span> Obsérvalos con atención. Dime, ¿por cuántos centímetros es más largo <span style='color:blue'>(señala ambos lápices)</span> un lápiz que el otro?",
				'data': [
					{
						'questionId': 5,
						'ansImg': 'M12B',
						'answer': '1',
					},
				]
			},
			{
				'gameName': 'M12C',
				'questionText': "",
				'data': [
					{
						'questionId': 6,
						'ansImg': 'M12C_1',
						'answer': 'Correct',
						"ansData":"A"
					},
					{
						'questionId': 7,
						'ansImg': 'M12C_2',
						'answer': 'Wrong',
						"ansData":"B"
					},
				]
			}, */
		]
	},
	{
		'language': 'Urdu-Pakistan',	//10
		'languageFont':'',
		'ansText':'جواب :',
		'gameArray':[
			{
				'gameName': 'M11B',
				'questionText': " <span style='color:blue'>(تصویر کی طرف اشارہ کریں اور بولیں)</span> اسے غور سے دیکھیں اور مجھے چابی کی <b>لمبائی سینٹی میٹر</b> میں بتائیں <span style='color:blue'>(چابی کی طرف اشارہ کریں)</span>۔",
				'data': [
					{
						'questionId': 1,
						'ansImg': 'M11B',
						'answer': '4',
					},
				]
			}, 
			/* {
				'gameName': 'M11C',
				'questionText': "<span style='color:blue'>(Señala la imagen y di)</span> Observa con atención y dime, ¿cuántos centímetros mide este <span style='color:blue'>(señala el lápiz)</span> lápiz?",
				'data': [
					{
						'questionId': 2,
						'ansImg': 'M11C',
						'answer': '6',
					},
				]
			}, */
			{
				'gameName': 'M12A',
				'answer': '1',
				'questionText': " <span style='color:blue'>(تصاویر کی طرف اشارہ کریں اور بولیں)</span> اسے غور سے دیکھیں اور بتائیں، کتنے <b>سینٹی میٹر</b> ایک چابی دوسرے چابی سے <b>چھوٹی</b> ہے؟",
				'data': [
					{
						'questionId': 3,
						'ansImg': 'M12A_1',
						'answer': '2',
					},
					{
						'questionId': 4,
						'ansImg': 'M12A_2',
						'answer': '',
					},
				]
			},
			/* {
				'gameName': 'M12B',
				'questionText': "<span style='color:blue'>(Señala la imagen y di)</span> Obsérvalos con atención. Dime, ¿por cuántos centímetros es más largo <span style='color:blue'>(señala ambos lápices)</span> un lápiz que el otro?",
				'data': [
					{
						'questionId': 5,
						'ansImg': 'M12B',
						'answer': '1',
					},
				]
			},
			{
				'gameName': 'M12C',
				'questionText': "",
				'data': [
					{
						'questionId': 6,
						'ansImg': 'M12C_1',
						'answer': 'Correct',
						"ansData":"A"
					},
					{
						'questionId': 7,
						'ansImg': 'M12C_2',
						'answer': 'Wrong',
						"ansData":"B"
					},
				]
			}, */
		]
	},
	{
		'language': 'Portuguese-Mozambique',//11
		'languageFont':'',
		'ansText':'Resposta :',
		'gameArray':[
			{
				'gameName': 'M11B',
				'questionText': "<span style='color:blue'>(Aponte para a figura e diga)</span> olha para isto com atenção e diga-me, o <b>comprimento</b> da chave em <b>centimetros</b> <span style='color:blue'>(aponte para a chave)</span>.",
				'data': [
					{
						'questionId': 1,
						'ansImg': 'M11B',
						'answer': '4',
					},
				]
			}, 
			/* {
				'gameName': 'M11C',
				'questionText': "<span style='color:blue'>(Señala la imagen y di)</span> Observa con atención y dime, ¿cuántos centímetros mide este <span style='color:blue'>(señala el lápiz)</span> lápiz?",
				'data': [
					{
						'questionId': 2,
						'ansImg': 'M11C',
						'answer': '6',
					},
				]
			}, */
			{
				'gameName': 'M12A',
				'answer': '1',
				'questionText': "<span style='color:blue'>(Aponte para as imagens e diga)</span> Olha para isto com atenção e diga-me, por quantos <b>centimetros</b> é que uma chave é <b>mais curta</b> em relação a outra?",
				'data': [
					{
						'questionId': 3,
						'ansImg': 'M12A_1',
						'answer': '2',
					},
					{
						'questionId': 4,
						'ansImg': 'M12A_2',
						'answer': '',
					},
				]
			},
			/* {
				'gameName': 'M12B',
				'questionText': "<span style='color:blue'>(Señala la imagen y di)</span> Obsérvalos con atención. Dime, ¿por cuántos centímetros es más largo <span style='color:blue'>(señala ambos lápices)</span> un lápiz que el otro?",
				'data': [
					{
						'questionId': 5,
						'ansImg': 'M12B',
						'answer': '1',
					},
				]
			},
			{
				'gameName': 'M12C',
				'questionText': "",
				'data': [
					{
						'questionId': 6,
						'ansImg': 'M12C_1',
						'answer': 'Correct',
						"ansData":"A"
					},
					{
						'questionId': 7,
						'ansImg': 'M12C_2',
						'answer': 'Wrong',
						"ansData":"B"
					},
				]
			}, */
		]
	},
];

