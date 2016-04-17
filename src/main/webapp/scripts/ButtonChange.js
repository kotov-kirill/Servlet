function ButtonChange(){
    radioGroup = document.MainForm.radio_corteg;
    for(i=0; i < radioGroup.length; i++)
        if(radioGroup[i].checked){
            PopupShow('Изменить','block');
            return;
        }
    alert("Выберите строку для изменения.");
}