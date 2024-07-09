
import xlrd
import json
loc = input("Enter Your Filename \n")

wb = xlrd.open_workbook(loc+'.xlsx')
sheet = wb.sheet_by_index(0)

arr = []

for i in range(1,sheet.nrows):
     arr.append({
            "queNo": sheet.cell_value(i, 0),
            "question": sheet.cell_value(i, 1),
            "lineHeight": sheet.cell_value(i, 3),
            "font": sheet.cell_value(i, 4),
            "paragraph": sheet.cell_value(i, 2),
            "title":sheet.cell_value(i,5),
            "answerKey":sheet.cell_value(i,6),
            "showInputDiv":sheet.cell_value(i,7)
    })

# Writing to sample.json
with open(loc+".json", "w", encoding="utf8") as outfile:
    json.dump(arr, outfile, indent=4, ensure_ascii=False)
