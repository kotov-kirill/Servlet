function ButtonDelete(){
    radioGroup = document.MainForm.radio_corteg;
    for(i=0; i < radioGroup.length; i++)
        if(radioGroup[i].checked)
            return confirm("Вы действительно хотите удалить запись?");
    alert("Выберите строку для удаления.");
    return false;
}