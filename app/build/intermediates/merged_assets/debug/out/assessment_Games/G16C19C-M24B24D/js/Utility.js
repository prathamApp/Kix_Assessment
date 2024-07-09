



function shuffle(sarray) {
    var arrayLength = sarray.length;
    var temp, random_index;
    while (arrayLength > 0) {
        random_index = Math.floor(Math.random() * arrayLength);
        arrayLength--;
        temp = sarray[arrayLength];
        sarray[arrayLength] = sarray[random_index];
        sarray[random_index] = temp;
    }
    return (sarray);
}

