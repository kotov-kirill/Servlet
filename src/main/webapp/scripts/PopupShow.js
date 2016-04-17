function PopupShow(text, state){
    document.getElementById('window').style.display = state;			
    document.getElementById('wrap').style.display = state;
    document.MainForm.save.value = text;
}

function PopupShowAddress(state){
    document.getElementById('wrap_popup_address').style.display = state;
    document.getElementById('window_popup_address').style.display = state;
}