function ValidateForm(){
    str = "";
    isCorrect = true;
    if(document.MainForm.sirname.value === ""){
        str += "Фамилия\n";
        isCorrect = false;
    }
    if(document.MainForm.firstname.value === ""){
        str += "Имя\n";
        isCorrect = false;
    }
    if(document.MainForm.secname.value === ""){
        str += "Отчество\n";
        isCorrect = false;
    }
    var num_group = document.MainForm.num_group.value;
    if(isNaN(parseFloat(num_group)))
        if(num_group === ""){
            str += "Номер группы\n";
            isCorrect = false;
        }
        else{
            alert("Поле номер группы должно быть числом");
            return false;
        }
    var id_kursant = document.MainForm.id_kursant.value;
    if(isNaN(parseFloat(id_kursant)))
        if(id_kursant === ""){
            str += "Личный номер\n";
            isCorrect = false;
        }
        else{
            alert("Поле личный номер должно быть числом");
            return false;
        }
    if(!isCorrect)
        alert("Поля:\n" + str + "не могут быть пустыми");
    return isCorrect;
}