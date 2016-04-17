function ValidateFormAddress(){
    str = "";
    isCorrect = true;
    var index = document.MainForm.index.value;
    if(isNaN(parseFloat(index)))
        if(index === ""){
            str += "Индекс\n";
            isCorrect = false;
        }
        else{
            alert("Поле индекс должно быть числом");
            return false;
        }
    if(document.MainForm.city.value === ""){
        str += "Город\n";
        isCorrect = false;
    }
    if(document.MainForm.region.value === ""){
        str += "Регион\n";
        isCorrect = false;
    }
    if(document.MainForm.street.value === ""){
        str += "Улица\n";
        isCorrect = false;
    }
    var place = document.MainForm.place.value;
    if(isNaN(parseFloat(place)))
        if(place === ""){
            str += "Место\n";
            isCorrect = false;
        }
        else{
            alert("Поле место должно быть числом");
            return false;
        }
        
    var phone = document.MainForm.phone.value;
    if(isNaN(parseFloat(phone)))
        if(phone === ""){
            str += "Телефон\n";
            isCorrect = false;
        }
        else{
            alert("Поле телефон должно быть числом");
            return false;
        }
    if(!isCorrect)
        alert("Поля\n" + str + "не могут быть пустыми");
    return isCorrect;
}