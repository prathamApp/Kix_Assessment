N23B.exampleImg = ["img2.png" , "img1.png" ,"img3.png"];
N23B.exampleDataToGet = [2,1,3];
N23B.exampleData=[
    {//en
        
        'instr1':" <span style='color:blue'>(Point to the pictures and say)</span> Look at these carefully. Now, I will arrange these from the <b>largest to smallest</b> here <span style='color:blue'>(Tap on the butterflies one by one and arrange them from the largest to the smallest in the given empty boxes)</span>",
    },
    {//hi
       
        "instr1":"  <span style='color:blue'>(चित्रों की ओर इशारा करते हुए कहें)</span> इन्हें ध्यान से देखो। अब, मैं इन्हें <b>बड़े से छोटे</b> आकार में व्यवस्थित करूँगा <span style='color:blue'>(एक-एक कर तितलियों पर दबाएँ और इन्हें बड़े से छोटे क्रम में इन खाली डिब्बों में डालें)</span>। ",
    },
    {//ken ki
       
        'instr1':" <span style='color:blue'>(Onyesha picha na useme)</span> Ziangalie hizi kwa makini. Sasa, nitazipanga hizi kuanzia <b>kubwa zaidi hadi ndogo kabisa</b> hapa <span style='color:blue'>(Guza vipepeo mmoja baada ya mwingine na uwapange kuanzia mkubwa hadi mdogo katika masanduku tupu yaliyotolewa)</span>",
    },
    {//urdu
       
        'instr1': "  <span style='color:blue'>(تصاویر کی طرف اشارہ کریں اور بولیں)</span> ان کو غور سے دیکھیں۔ اب، میں ان کو یہاں <b>سب سے بڑے سے لے کر سب سے چھوٹے</b> تک ترتیب دوں گا/گی <span style='color:blue'>(تتلیوں پر ایک ایک کرکے کلک ٹیپ کریں اور دیے گئے خالی خانوں میں سب سے بڑے سے چھوٹے تک ترتیب دیں)</span>۔",
    },
    {//spa-nic
       
        'instr1':" <span style='color:blue'>(Señale las imágenes y diga)</span> Fíjate bien en estas imágenes de mariposas. Ahora, voy a ordenarlas <b>de la más grande a la más pequeña aquí</b> <span style='color:blue'>(toque las mariposas una por una y ordénelas de la más grande a la más pequeña en las casillas vacías dadas)</span>.",
    },
    {//span-mex
       
        'instr1':" <span style='color:blue'>(Señala las imágenes y di)</span> Obsérvalas con atención. Ahora, las ordenaré de la <b>más grande a la más pequeña</b> aquí <span style='color:blue'>(Toca las mariposas una por una y ordénalas de la más grande a la más pequeña en las casillas que se presentan)</span>.",
    },
    {//ban
        
        'instr1':" <span style='color:blue'>(ছবিগুলো দেখিয়ে বলুন)</span> এগুলি মনোযোগ দিয়ে দেখো। এখন, আমি এগুলোকে <b>বড় থেকে ছোট</b> অনুযায়ী এখানে সাজাবো। <span style='color:blue'>(একের পর এক প্রজাপতির উপর ট্যাপ করুন এবং প্রদত্ত খালি বাক্সে বড় থেকে ছোট অনুযায়ী সাজান)</span>",
     },
     {//fre-sen
       
        'instr1':" <span style='color:blue'>(Pointe les images et dis)</span> Regarde-les attentivement. Maintenant, je vais les ranger <b>du plus grand au plus petit</b> ici <span style='color:blue'>(tape sur les papillons un par un et range-les du plus grand au plus petit dans les cases vides données)</span>.",
    },
    {//ki-tan
       
        'instr1':" <span style='color:blue'>(Onesha picha na useme)</span> Angalia hapa kwa makini. Sasa nitazipanga hizi kuanzia <b>kubwa zaidi mpaka ndogo zaidi</b> hapa <span style='color:blue'>(Gusa vipepeo mmoja baada ya mwingine na uwapange kuanzia mkubwa zaidi mpaka mdogo zaidi katika maboksi yaliyo wazi)</span>",
    },
    {//nep
        
        'instr1':" <span style='color:blue'>(चित्रमा देखाउँदै हेर्नुहोस्)</span> यिनीहरुलाई ध्यान दिएर हेर्नुहोस्।अब म यिनीहरुलाई <b>ठुलोबाट सानो</b> गर्दै यहाँ मिलाएर राख्छु <span style='color:blue'>(पुतलीहरुमा ट्याप गर्दै एक एक गरि ठुलो देखि सानो आकार गर्दै दिईएको खाली कोठाहरुमा राख्नुहोस्)</span>",
    },
    {//por-moz
        
        'instr1':" <span style='color:blue'>(Aponte para as imagens e diga)</span> Olha para estas com atenção. Agora, vou organizar estes <b>a partir do maior para o menor</b> aqui <span style='color:blue'>(Toque nas borboletas uma por uma e organize-as a partir da maior para a mais pequena nas caixas vazias atribuídas)</span>",
    },
    { //fre-mali
      "instr1":"  <span style='color:blue'>(Pointe sur les images et dis)</span> Regarde-les attentivement. Maintenant, je vais les organiser du <b>plus grand au plus petit</b> ici <span style='color:blue'>(Appuie sur les papillons un à un et organise-les du plus grand au plus petit dans les boîtes vides données)</span>"
    }
]
N23B.gameNameArr =[
    {
        "lang":"English-Uganda",
        'languageFont':'fonts/Andika-Regular.ttf',
        "fontSize":"1.8vw",
        "gameData":[
            {
                  'gameName':'N23B',
                  'gameName2':'N23Eg',
                   "instr2":" <span style='color:blue'>(Point to the numbers and say)</span> Look at these carefully. Now, like I did, you also arrange these numbers from the smallest to the greatest. <span style='color:blue'>(If the child leaves the task midway, ask them to complete the task)</span>",
                   "exampleAns":[2,5,6],
                  'correctAns':[4,7,9],
                  "shuffArr":[7,9,4]
                  
            },
            {
                "gameName":"N30B",
                'gameName2':'N30Eg',
                "instr2":" <span style='color:blue'>(Point to the numbers and say)</span> Look at these carefully. Now, like I did, you also arrange these numbers from the greatest to the smallest. <span style='color:blue'>(If the child leaves the task midway, ask them to complete the task)</span>",
                "exampleAns":[2,5,6],
                'correctAns': [29, 27, 14,7],
                "shuffArr":[7,29,14,27]
            },
            {
                "gameName":"N33B",
                'gameName2':'N33Eg',
                "instr2":"<span style='color:blue'>(Point to the numbers and say)</span> Look at these carefully and arrange them from the <b>greatest to the smallest</b> here. <span style='color:blue'>(Point to the empty boxes)</span> <span style='color:blue'>(Prompt: If the child leaves the task midway, ask them to complete the task.)</span>",
                "exampleAns":[2,5,6],
                'correctAns': [96, 93, 69,36],
                "shuffArr":[69,96,93,36]
            },
            {
                "gameName":"N35B",
                'gameName2':'N35Eg',
                "instr2":" <span style='color:blue'>(Point to the numbers and say)</span> Look at these carefully and arrange them from the <b>greatest to the smallest</b> here. <span style='color:blue'>(Point to the empty boxes)</span><span style='color:blue'>(Prompt: If the child leaves the task midway, ask them to complete the task.)</span>.",
                "exampleAns":[2,5,6],
                'correctAns':[ 696, 690, 669, 629],
                "shuffArr": [629, 690, 696,669],
            }
        ]
       
    },
    {
        "lang" :"Hindi-India",
        "fontSize":"1.6vw",
        "gameData":[
            {
             "gameName":"N23B",
             'gameName2':'N23Eg',
             "exampleAns":[2,5,6],
            "instr2":" <span style='color:blue'>(अंकों की ओर इशारा करते हुए कहें)</span> इन्हें ध्यान से देखो। अब, जैसे मैंने किया, आप भी इन अंकों को छोटे से बड़े तक लगाएँ। <span style='color:blue'>(यदि बच्चा कार्य अधूरा छोड़ देता है, तो उसे कार्य को पूरा करने को कहें)</span>",
              "correctAns":[4,7,9],
              "shuffArr":[7,9,4]
            },
            {
                "gameName":"N30B",
                'gameName2':'N30Eg',
                "instr2":" <span style='color:blue'>(संख्याओं की ओर इशारा करते हुए कहें)</span> इन्हें ध्यान से देखो। अब, जैसे मैंने किया, आप भी इन संख्याओं को बड़े से छोटे तक लगाएँ। <span style='color:blue'>(यदि बच्चा कार्य अधूरा छोड़ देता है, तो उसे पूरा करने को कहें)</span>",
                "exampleAns":[2,5,6],
                'correctAns': [29, 27, 14,7],
                "shuffArr":[ 27, 7, 14, 29]
            },
            {
                "gameName":"N33B",
                'gameName2':'N33Eg',
                "instr2":"  <span style='color:blue'>(संख्याओं की ओर इशारा करते हुए कहें)</span> इन्हें ध्यान से देखो और <b>बड़े से छोटे</b> क्रम में यहाँ <span style='color:blue'>(खाली डिब्बों की और इशारा करें)</span> व्यवस्थित करो। <span style='color:blue'>(प्रांप्ट: यदि बच्चा कार्य अधुरा छोड़ देता है, तो उसे कार्य पूरा करने को कहें।)</span> ",
                "exampleAns":[2,5,6],
                'correctAns': [96, 93, 69,36],
                "shuffArr":[69,96,93,36]
            },
            {
                "gameName":"N35B",
                'gameName2':'N35Eg',
                "instr2":"  <span style='color:blue'>(संख्याओं की ओर इशारा करते हुए कहें)</span> इन्हें ध्यान से देखो और <b>बड़े से छोटे</b> क्रम में यहाँ <span style='color:blue'>(खाली डिब्बों की और इशारा करें)</span> व्यवस्थित करो।  <span style='color:blue'>(प्रांप्ट: यदि बच्चा कार्य अधुरा छोड़ देता है, तो उसे कार्य पूरा करने को कहें।)</span>",
                "exampleAns":[2,5,6],
                'correctAns':[ 696, 690, 669, 629],
                "shuffArr": [629, 690, 696,669],
            }
        ]
       
    }, 
    {
        "lang":"Kiswahili-Kenya",
        'languageFont':'fonts/Andika-Regular.ttf',
        "fontSize":"1.8vw",
       
        "gameData":[
            {
               'gameName':'N23B',
               'gameName2':'N23Eg',
              "instr2":" <span style='color:blue'>(Elekeza kidole kwenye nambari/numbers kisha useme)</span> Tazama hapa kwa makini. Sasa, kama nilivyofanya, panga nambari hizi kutoka ndogo hadi kubwa zaidi. <span style='color:blue'>(Mtoto akiachia kazi katikati, mwambie amalizie yote)</span>",
              "exampleAns":[2,5,6],
                'correctAns':[4,7,9],
                "shuffArr":[7,9,4]
            },
            {
                "gameName":"N30B",
                'gameName2':'N30Eg',
                "instr2":"  <span style='color:blue'>(Elekeza kidole kwenye nambari/numbers kisha useme)</span> Tazama hapa kwa makini. Sasa, kama nilivyofanya, panga nambari hizi kutoka kubwa hadi ndogo zaidi. <span style='color:blue'>(Mtoto akiachia kazi katikati, mwambie amalizie yote)</span>",
                "exampleAns":[2,5,6],
                'correctAns': [29, 27, 14,7],
                "shuffArr":[7,29,14,27]
            },
            {
                "gameName":"N33B",
                'gameName2':'N33Eg',
                "instr2":" <span style='color:blue'>(Onyesha nambari kisha useme)</span> Ziangalie hizi kwa makini na uzipange kuanzia <b>kubwa hadi ndogo zaidi hapa</b>. <span style='color:blue'>(Onyesha visanduku tupu)</span><span style='color:blue'>(Ushauri: Mtoto akiacha kazi katikati, mwaambie amalize kazi.)</span>.",
                "exampleAns":[2,5,6],
                'correctAns': [96, 93, 69,36],
                "shuffArr":[69,96,93,36]
            },
            {
                "gameName":"N35B",
                'gameName2':'N35Eg',
                "instr2":"<span style='color:blue'>(Onyesha nambari kisha useme)</span> Ziangalie hizi kwa makini na uzipange kuanzia <b>kubwa hadi ndogo zaidi hapa</b>. <span style='color:blue'>(Onyesha visanduku tupu)</span><span style='color:blue'>(Ushauri: Mtoto akiacha kazi katikati, mwaambie amalize kazi.)</span>.",
                "exampleAns":[2,5,6],
                'correctAns':[ 696, 690, 669, 629],
                "shuffArr": [629, 690, 696,669],
            }
        ]
       
    },
    {
        "lang" : "Urdu-Pakistan",
        "fontSize":"1.6vw",
        "gameData":[
            {
             'gameName':'N23B',
             'gameName2':'N23Eg',
             "instr2":"  ان کو <span style='color:blue'>(نمبروں کی طرف اشارہ کریں اور کہیں)</span> غور سے دیکھو۔ جیسا میں نے کیا اب آپ بھی ان نمبروں کو سب سے چھوٹے سے بڑےنمبر تک ترتیب دیں۔ <span style='color:blue'>(اگر بچہ ٹاسک کو درمیان میں چھوڑ دیتا ہے، تو اس سے ٹاسک مکمل کرنے کے لیے کہیں)</span>",
              "exampleAns":[2,5,6],
              'correctAns':[4,7,9],
              "shuffArr":[7,9,4]
            },
            {
                 "gameName":"N30B",
                 'gameName2':'N30Eg',
                "instr2":" ان کو <span style='color:blue'>(نمبروں کی طرف اشارہ کریں اور کہیں)</span> غور سے دیکھو۔ جیسا میں نے کیا اب آپ بھی ان نمبروں کو سب سے بڑے سے سب سے چھوٹے کی طرف ترتیب دیں۔<span style='color:blue'>(اگر بچہ ٹاسک کو درمیان میں چھوڑ دیتا ہے، تو اس سے ٹاسک مکمل کرنے کے لیے کہیں)</span>",
                "exampleAns":[2,5,6],
                'correctAns': [29, 27, 14,7],
                "shuffArr":[7,29,14,27]
            },
            {
                "gameName":"N33B",
                'gameName2':'N33Eg',
                "instr2":" <span style='color:blue'>(نمبروں کی طرف اشارہ کریں اور بولیں)</span> ان کو غور سے دیکھیں اور انہیں <b>سب سے بڑے سے چھوٹے</b> تک یہاں ترتیب دیں۔ <span style='color:blue'>(خالی خانوں کی طرف اشارہ کریں)</span><span style='color:blue'>( اگر بچہ کام کو درمیان میں چھوڑ دیتا ہے، تو اس سے کام کو مکمل کرنے کو کہیں۔)</span>",
                "exampleAns":[2,5,6],
                'correctAns': [96, 93, 69,36],
                "shuffArr":[69,96,93,36]
            },
            {
                "gameName":"N35B",
                'gameName2':'N35Eg',
                "instr2":"  <span style='color:blue'>(نمبروں کی طرف اشارہ کریں اور بولیں)</span> ان کو غور سے دیکھیں اور انہیں یہاں <b>سب سے بڑے سے چھوٹے</b> تک ترتیب دیں۔ <span style='color:blue'>(خالی خانوں کی طرف اشارہ کریں)</span><span style='color:blue'>( اگر بچہ کام کو درمیان میں چھوڑ دیتا ہے، تو اس سے کام کو مکمل کرنے کو کہیں۔)</span>",
                "exampleAns":[2,5,6],
                'correctAns':[ 696, 690, 669, 629],
                "shuffArr": [629, 690, 696,669],
            }
        ]
       
    },
    {
        "lang" : "Spanish-Nicaragua",
        'languageFont':'fonts/AntarcticaRegular.ttf',
        "fontSize":"1.8vw",
        "gameData":[
            {
                    'gameName':'N23B',
                    'gameName2':'N23Eg',
                  "instr2":" <span style='color:blue'>(Señala los números y explica)</span> Fíjate bien en estos. Ahora, como lo hice yo, tienes que ordenar también estos números desde el más pequeño hasta el más grande. <span style='color:blue'>(si el niño o la niña deja la tarea a medio camino, pedile que la complete)</span>.",
                "exampleAns":[2,5,6],
                'correctAns':[4,7,9],
                "shuffArr":[7,9,4]
            },
            {
                "gameName":"N30B",
                'gameName2':'N30Eg',
               "instr2":" <span style='color:blue'>(Señala los números y explica)</span> Fíjate bien en estos. Ahora, como lo hice yo, tienes que ordenar también estos números, pero desde el más grande hasta el más pequeño. <span style='color:blue'>(si el niño o la niña deja la tarea a medio camino, pedile que la complete)</span>.",
               "exampleAns":[2,5,6],
               'correctAns': [29, 27, 14,7],
               "shuffArr":[7,29,14,27]
           },
           {
            "gameName":"N33B",
            'gameName2':'N33Eg',
            "instr2":" <span style='color:blue'>(Señale los números y diga)</span> Mirá estos números cuidadosamente y ordénalos <b>del más grande al más pequeño</b> aquí. <span style='color:blue'>(Señale los cuadritos vacíos)</span> <span style='color:blue'>(Indicación: si el niño o la niña deja la tarea a mitad de camino, pídale que la complete)</span>.",
            "exampleAns":[2,5,6],
            'correctAns': [96, 93, 69,36],
                "shuffArr":[69,96,93,36]
          },
          {
            "gameName":"N35B",
            'gameName2':'N35Eg',
            "instr2":" <span style='color:blue'>(Señale los números y diga)</span> Mirá estos números cuidadosamente y ordénalos <b>del más grande al más pequeño</b> aquí. <span style='color:blue'>(Señale los cuadritos vacíos)</span> <span style='color:blue'>(Indicación: si el niño deja la tarea a mitad de camino, pídale que la complete)</span>.",
            "exampleAns":[2,5,6],
            'correctAns':[ 696, 690, 669, 629],
            "shuffArr": [629, 690, 696,669],
        }
        ]
    },
    {
        "lang" : "Spanish-Mexico",
        'languageFont':'null',
        "fontSize":"1.8vw",
        "gameData":[
            {
                    'gameName':'N23B',
                    'gameName2':'N23Eg',
                  "instr2":" <span style='color:blue'>(Señala los números y di)</span> Obsérvalos con atención. Ahora, como yo lo hice, tú también ordena estos números de menor a mayor. <span style='color:blue'>(Si el(la) niño(a) deja la tarea a medias, pídele que la complete).</span>",
                "exampleAns":[2,5,6],
                'correctAns':[4,7,9],
                "shuffArr":[7,9,4]
            },
            {
                "gameName":"N30B",
                'gameName2':'N30Eg',
               "instr2":"  <span style='color:blue'>(Señala los números y di)</span> Obsérvalos con atención. Ahora, como yo lo hice, tú también ordena estos números de mayor a menor. <span style='color:blue'>(Si el(la) niño(a) deja la tarea a medias, pídele que la complete).</span>",
               "exampleAns":[2,5,6],
               'correctAns': [29, 27, 14,7],
               "shuffArr":[7,29,14,27]
           },
           {
            "gameName":"N33B",
            'gameName2':'N33Eg',
            "instr2":" <span style='color:blue'>(Señala los números y di)</span> Obsérvalos con atención y ordénalos de <b>mayor a menor</b> aquí. <span style='color:blue'>(Señala las casillas vacías)</span><span style='color:blue'>(Instrucción: Si el(la) niño(a) deja la tarea a medias, pídele que la complete)</span>.",
            "exampleAns":[2,5,6],
            'correctAns': [96, 93, 69,36],
                "shuffArr":[69,96,93,36]
          },
          {
            "gameName":"N35B",
            'gameName2':'N35Eg',
            "instr2":" <span style='color:blue'>(Señala los números y di)</span> Obsérvalos con atención y ordénalos de <b>mayor a menor</b> aquí. <span style='color:blue'>(Señala las casillas vacías)</span><span style='color:blue'>(Instrucción: Si el(la) niño(a) deja la tarea a medias, pídele que la complete)</span>.",
            "exampleAns":[2,5,6],
            'correctAns':[ 696, 690, 669, 629],
            "shuffArr": [629, 690, 696,669],
        }
        ]
    },
    {
        "lang" : "Bangla-Bangladesh",
        'languageFont':'fonts/kalpurush.ttf',
        "fontSize":"1.8vw",
        "gameData":[
            {
            'gameName':'N23B',
            'gameName2':'N23Eg',
            "instr2":" <span style='color:blue'>(সংখ্যাগুলো দেখিয়ে বলুন)</span> এগুলো মনোযোগ দিয়ে দেখো। এখন, আমার মতো করে তুমি এই সংখ্যাগুলোকে ছোট থেকে বড় অনুসারে সাজাও। <span style='color:blue'>(উদ্দীপক: যদি শিশুটি মাঝপথে থেমে যায়, তবে তাকে কাজটি সম্পন্ন করতে বলুন)</span>",
            "exampleAns":[2,5,6],
            'correctAns':[4,7,9],
            "shuffArr":[7,9,4]
            },
            {
                "gameName":"N30B",
                'gameName2':'N30Eg',
               "instr2":" <span style='color:blue'>(সংখ্যাগুলো দেখিয়ে বলুন)</span> এগুলো মনোযোগ দিয়ে দেখো। এখন, আমার মতো করে তুমি এই সংখ্যাগুলোকে বড় থেকে ছোট অনুসারে সাজাও। <span style='color:blue'>(উদ্দীপক: যদি শিশুটি মাঝপথে থেমে যায়, তবে তাকে কাজটি সম্পন্ন করতে বলুন)</span>",
               "exampleAns":[2,5,6],
               'correctAns': [29, 27, 14,7],
               "shuffArr":[7,29,14,27]
           },
           {
            "gameName":"N33B",
            'gameName2':'N33Eg',
            "instr2":" <span style='color:blue'>(সংখ্যাগুলো দেখিয়ে বলুন)</span> এগুলো মনোযোগ দিয়ে দেখো। এখন, এগুলোকে <b>বড় থেকে ছোট</b> ক্রমানুসারে সাজাও তো এখানে <span style='color:blue'>(খালি বাক্সগুলি দেখান)</span>।<span style='color:blue'>(উদ্দীপকঃ যদি বাচ্চাটি মাঝপথে থেমে যায়, তবে তাকে কাজটি সম্পূর্ণ করতে বলুন)</span>",
            "exampleAns":[2,5,6],
            'correctAns': ['৯৬', '৯৩', '৬৯', '৩৬'],
            "shuffArr": ['৬৯', '৯৬', '৯৩', '৩৬']
          },
          {
            "gameName":"N35B",
            'gameName2':'N35Eg',
            "instr2":" <span style='color:blue'>(সংখ্যাগুলো দেখিয়ে বলুন)</span> এগুলো মনোযোগ দিয়ে দেখো। এখন, এগুলোকে <b>বড় থেকে ছোট</b> ক্রমানুসারে সাজাও তো এখানে <span style='color:blue'>(খালি বাক্সগুলি দেখান)</span>।<span style='color:blue'>(উদ্দীপকঃ যদি বাচ্চাটি মাঝপথে থেমে যায়, তবে তাকে কাজটি সম্পূর্ণ করতে বলুন)</span>",
            "exampleAns":[2,5,6],
            'correctAns':['৬৯৬', '৬৯০', '৬৬৯', '৬২৯'], // [699, 696, 692,659],
            "shuffArr": [ "৬২৯", "৬৯০", "৬৯৬", "৬৬৯"], //[ 692, 699, 696, 659] ,
        }
        ]
         
    },
    {
        "lang" : "French-Senegal",
        'languageFont':null,
        "fontSize":"1.8vw",
        "gameData":[
            {
            'gameName':'N23B',
            'gameName2':'N23Eg',
            "instr2":" <span style='color:blue'>(Pointe les chiffres et dis)</span> Regarde-les attentivement. Maintenant, comme je l'ai fait, tu dois organiser également ces nombres du plus petit au plus grand. <span style='color:blue'>(Si l'enfant quitte la tâche à mi-chemin, demande-lui de terminer la tâche)</span>",
            "exampleAns":[2,5,6],
            'correctAns':[4,7,9],
            "shuffArr":[7,9,4]
            },
            {
                "gameName":"N30B",
                'gameName2':'N30Eg',
               "instr2":" <span style='color:blue'>(Pointe les chiffres et dis)</span> Regarde-les attentivement. Maintenant, comme je l'ai fait, tu dois organiser également ces nombres du plus grand au plus petit. <span style='color:blue'>(Si l'enfant quitte la tâche à mi-chemin, demande-lui de terminer la tâche)</span>",
               "exampleAns":[2,5,6],
               'correctAns': [29, 27, 14,7],
               "shuffArr":[7,29,14,27]
           },
           {
            "gameName":"N33B",
            'gameName2':'N33Eg',
            "instr2":" <span style='color:blue'>(Pointe les chiffres et dis)</span> Regarde-les attentivement et range-les <b>du plus grand au plus petit</b> ici. <span style='color:blue'>(Pointe les cases vides)</span><span style='color:blue'>(Suggestion : si l'enfant abandonne la tâche à mi-chemin, demandez-lui de la terminer)</span>",
            "exampleAns":[2,5,6],
            'correctAns': [96, 93, 69,36],
            "shuffArr":[69,96,93,36]
          },
          {
            "gameName":"N35B",
            'gameName2':'N35Eg',
            "instr2":" <span style='color:blue'>(Pointe les chiffres et dis)</span> Regarde-les attentivement et range-les <b>du plus grand au plus petit</b> ici. <span style='color:blue'>(Montre les cases vides)</span>.<span style='color:blue'>(Suggestion : si l'enfant quitte la tâche à mi-chemin, demandez-lui de la terminer)</span>",
            "exampleAns":[2,5,6],
            'correctAns':[ 696, 690, 669, 629],
            "shuffArr": [629, 690, 696,669],
        }
        ]
    },
    {
        "lang" : "Kiswahili-Tanzania",
        'languageFont':null,
        "fontSize":"1.6vw",
        "gameData":[
            {
            'gameName':'N23B',
            'gameName2':'N23Eg',
            "instr2":" <span style='color:blue'>9Onesha namba na useme)</span> Angalia hapa kwa makini. Sasa kama nilivofanya na wewe zipange namba hizi kana kwamba namba ndogo itaanza na kuishia na namba kubwa zaidi. <span style='color:blue'>(Endapo mtoto ataacha zoezi katikati , mshawishi amalize zoezi lote)</span>",
            "exampleAns":[2,5,6],
            'correctAns':[4,7,9],
            "shuffArr":[7,9,4]
            },
            {
                "gameName":"N30B",
                'gameName2':'N30Eg',
               "instr2":" (Onesha namba na useme)3 Angalia hapa kwa makini. Sasa kama nilivofanya zipange namba hizi kuanzia kubwa mpaka ndogo. <span style='color:blue'>(Endapo mtoto ataacha zoezi katikati, mshawishi amalize zoezi)</span>",
               "exampleAns":[2,5,6],
               'correctAns': [29, 27, 14,7],
               "shuffArr":[7,29,14,27]
           },
           {
            "gameName":"N33B",
            'gameName2':'N33Eg',
            "instr2":" <span style='color:blue'>(Onesha namba na useme)</span> Angalia hapa kwa makini na uzipange kuanzia <b>kubwa zaidi mpaka ndogo zaidi</b> hapa. <span style='color:blue'>(Onesha maboksi yaliyo wazi)</span> <span style='color:blue'>(Shawishi: Endapo mtoto ataondoka kabla ya kumaliza zoezi , mshawishi amalizie)</span>",
            "exampleAns":[2,5,6],
            'correctAns': [27, 72, 79,97],
            "shuffArr":[79,72,97,27]
          },
          {
            "gameName":"N35B",
            'gameName2':'N35Eg',
            "instr2":"  <span style='color:blue'>(Onesha namba na useme)</span> Angalia hapa kwa makini na uzipange kuanzia <b>kubwa zaidi mpaka ndogo zaidi</b> hapa. <span style='color:blue'>(Onesha maboksi yaliyo wazi)</span> <span style='color:blue'>(Shawishi: Endapo mtoto ataondoka kabla ya kumaliza zoezi , mshawishi amalizie)</span>",
            "exampleAns":[2,5,6],
            'correctAns':[ 696, 690, 669, 629],
            "shuffArr": [629, 690, 696,669],
        }
        ]
    },
    {
        "lang" : "Nepali-Nepal",
        'languageFont':'fonts/MANGAL.ttf',
        "fontSize":"1.8vw",
        "gameData":[
            {
            'gameName':'N23B',
            'gameName2':'N23Eg',
            "instr2":"  <span style='color:blue'>(अंकहरुलाई देखाउनुहोस् र भन्नुहोस् )</span> यिनीहरुलाई ध्यान दिएर हेर्नुहोस्) <span style='color:blue'> अब, मैले गरेको जस्तै गरि तपाईले पनि यी अंकहरुलाई सबै भन्दा सानो देखि सबैभन्दा ठुलो सम्म मिलाउनुहोस। </span>(यदि बच्चाहरुले यो कार्य गर्दा गर्दै बिचमै छोड्छ भने , उस्लाई यो कार्य पुरा गर्न लगाउनुहोस् )<span style='color:blue'>",
            "exampleAns":[2,5,6],
            'correctAns':['९६', '९३', '६९', '३६'],
            "shuffArr": ['६९', '९६', '९३', '३६']
            },
            {
                "gameName":"N30B",
                'gameName2':'N30Eg',
               "instr2":" <span style='color:blue'>(अंकहरुलाई देखाउनुहोस् र भन्नुहोस् )</span> यिनीहरुलाई ध्यान दिएर हेर्नुहोस् । अब, मैले गरेको जस्तै गरि , तपाई पनि यी अंकहरुलाई सबै भन्दा ठुलोबाट सुरु गरि सबै भन्दा सानो आउने गरि मिलाउनुहोस् । <span style='color:blue'>(यदि बच्चाले यो कार्य गर्दा गर्दै बिचमै छोड्छ भने, उस्लाई यो कार्य पुरा गर्न लगाउनुहोस् )</span>",
               "exampleAns":[2,5,6],
               'correctAns':['९६', '९३', '६९', '३६'],
               "shuffArr":['६९', '९६', '९३', '३६']
           },
           {
            "gameName":"N33B",
            'gameName2':'N33Eg',
            "instr2":" <span style='color:blue'>(अङ्कहरुलाई देखाउँदै भन्नुहोस्)</span> यिनीहरुलाई ध्यान दिएर हेर्नुहोस् र ति अङ्कहरुलाई <b>सबै भन्दा ठुलोबाट सानो</b> गर्दै मिलाएर यहाँ राख्नुहोस् । <span style='color:blue'>(खाली कोठाहरुमा देखाउनुहोस्)</span> <span style='color:blue'>(नोट: यदि बालबालिकाहरुले यो कार्य गर्दा गर्दै बिचमै छोडे भने, यो कार्य पुरा गर्न लगाउनुहोस्)</span>",
            "exampleAns":[2,5,6],
            'correctAns':['९६', '९३', '६९', '३६'],
               "shuffArr":['६९', '९६', '९३', '३६']
          },
          {
            "gameName":"N35B",
            'gameName2':'N35Eg',
            "instr2":" <span style='color:blue'>(अङ्कहरुलाई देखाउँदै भन्नुहोस्)</span> यिनीहरुलाई ध्यान दिएर हेर्नुहोस् र <b>सबै भन्दा ठुलो अङ्कबाट सुरु गरि सानो गर्दै</b> मिलाएर यहाँ राख्नुहोस्।खाली कोठाहरुमा देखाउनुहोस्)<span style='color:blue'> ।",
            "exampleAns":[2,5,6],
            'correctAns': ['६९६', '६९०', '६६९', '६२९'],
            "shuffArr":[  '६२९', '६९०', '६९६', '६६९',]
        }
        ]
    },
    {
        "lang" : "Portuguese-Mozambique",
        "fontSize":"1.8vw",
        'languageFont':null,
        "gameData":[
            {
            'gameName':'N23B',
            'gameName2':'N23Eg',
            "instr2":" <span style='color:blue'>(Aponte para os números e diga)</span> Observe com atenção. Agora, como eu fiz, você também organiza esses números do menor para o maior. <span style='color:blue'>(Se a criança não terminar a tarefa, peça-lhe para terminar) </span>",
            "exampleAns":[2,5,6],
            'correctAns':[4,7,9],
            "shuffArr":[7,9,4]
            },
            {
                "gameName":"N30B",
                'gameName2':'N30Eg',
               "instr2":" <span style='color:blue'>(Aponte para os números e diga)</span> Observe com atenção. Agora, como eu fiz, você também organiza esses números do maior para o menor. <span style='color:blue'>(Se a criança não terminar a tarefa, peça-lhe para terminar) </span>",
               "exampleAns":[2,5,6],
               'correctAns': [29, 27, 14,7],
               "shuffArr":[7,29,14,27]
           },
           {
            "gameName":"N33B",
            'gameName2':'N33Eg',
            "instr2":"<span style='color:blue'>(Aponte os números e diga)</span> Olha para estes com atenção e organiza-os <b>a partir do maior para o menor</b> aqui. <span style='color:blue'>(Aponte para as caixas vazias)</span> <span style='color:blue'>(Prontamente: se a criança abandonar a tarefa ao meio, peça a criança para concluir a tarefa.)</span>.",
            "exampleAns":[2,5,6],
            'correctAns': [96, 93, 69,36],
             "shuffArr":[69,96,93,36]
          },
          {
            "gameName":"N35B",
            'gameName2':'N35Eg',
            "instr2":"<span style='color:blue'>(Aponte os números e diga)</span> Olha para estes com atenção e organiza-os <b>a partir do maior para o menor</b> aqui. <span style='color:blue'>(Aponte para as caixas vazias)</span> <span style='color:blue'>(Prontamente: se a criança abandonar a tarefa ao meio, peça a criança para concluir a tarefa.)</span>.",
            "exampleAns":[2,5,6],
                'correctAns':[ 696, 690, 669, 629],
                "shuffArr": [629, 690, 696,669],
        }
        ]
    },
    {
        "lang" : "French-Mali",
        'languageFont':null,
        "fontSize":"1.8vw",
        "gameData":[
            {
            'gameName':'N23B',
            'gameName2':'N23Eg',
            "instr2":" <span style='color:blue'>(Pointe les chiffres et dis)</span> Regarde-les attentivement. Maintenant, comme je l'ai fait, tu dois organiser également ces nombres du plus petit au plus grand. <span style='color:blue'>(Si l'enfant quitte la tâche à mi-chemin, demande-lui de terminer la tâche)</span>",
            "exampleAns":[2,5,6],
            'correctAns':[4,7,9],
            "shuffArr":[7,9,4]
            },
            {
                "gameName":"N30B",
                'gameName2':'N30Eg',
               "instr2":" <span style='color:blue'>(Pointe les chiffres et dis)</span> Regarde-les attentivement. Maintenant, comme je l'ai fait, tu dois organiser également ces nombres du plus grand au plus petit. <span style='color:blue'>(Si l'enfant quitte la tâche à mi-chemin, demande-lui de terminer la tâche)</span>",
               "exampleAns":[2,5,6],
               'correctAns': [29, 27, 14,7],
               "shuffArr":[7,29,14,27]
           },
           {
            "gameName":"N33B",
            'gameName2':'N33Eg',
            "instr2":" <span style='color:blue'>(Pointe sur les chiffres et dis)</span> Regarde-les attentivement et organise-les du <b>plus grand au plus petit</b> ici. <span style='color:blue'>(Pointe sur les cases vides)</span> <span style='color:blue'>(Conseil : Si l’enfant quitte la tâche à mi-chemin, demande-lui de terminer la tâche.)</span>.",
            "exampleAns":[2,5,6],
            'correctAns': [96, 93, 69,36],
             "shuffArr":[69,96,93,36]
          },
          {
            "gameName":"N35B",
            'gameName2':'N35Eg',
            "instr2":"  <span style='color:blue'>(Pointe sur les chiffres et dis)</span> Regarde-les attentivement et organise-les du <b>plus grand au plus petit</b> ici. <span style='color:blue'>(Pointe sur les cases vides)</span> <span style='color:blue'>(Conseil : Si l’enfant quitte la tâche à mi-chemin, demande-lui de terminer la tâche.)</span>.",
            "exampleAns":[2,5,6],
            'correctAns':[ 696, 690, 669, 629],
            "shuffArr": [629, 690, 696,669],
        }
        ]
    },
   
]