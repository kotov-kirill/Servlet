var id_kursant;
//Метод для кнопки показа Адреса
function buttonAddr(id){
    id_kursant = id;
    PopupShowAddress('block');
    addressRequest(id);
}

//Метод запроса на сервер списка адресов
function addressRequest(id){
       $.ajax({
        url: 'AddressServlet',
        data: {
           id: id
        },
        dataType: 'json',
        success: function(data) {
            $("#table").html("")
                .append("<table>")
                .append("<tr>" + 
                        "<th>Выбор</th>" +
                        "<th>ID</th>" +
                        "<th>Индекс</th>" +
                        "<th>Регион</th>" + 
                        "<th>Город</th>" + 
                        "<th>Улица</th>" + 
                        "<th>Место</th>" + 
                        "<th>Телефон</th>" + 
                    "</tr>");
            $.each(data, function(i, valI) {
                $('#table').append('<tr>');
                $('#table').append('<td><input name="radio_address" type="radio" value="' + valI.id + '" /></td>');
                $.each(valI, function (j, valJ){
                    $('#table').append('<td>' + valJ + '</td>');
                });
                $('#table').append('</tr>');
            });
            $("#table").append("</table>");
        },
        error: function (error){
            alert(error);
        }
    });
}

$(document).ready(function (){
    //Кнопка удаления адреса
    $('#address_delete').click(function (){
        var id_address = $('input:checked[name=radio_address]').val();
        if(id_address === undefined){
            alert('Выберите строку для удаления');
            return;
        }
        $.ajax({
            url: 'AddressServlet',
            data: {
                id_address: id_address,
                operation: 'delete'
            },
            success: function() {
                addressRequest(id_kursant);
            }
        });
    });
    
    //Кнопка создания адреса
    $('#address_create').click(function (){
        $('#wrap_popup_address_create_c_ch').css('display', 'block');
        $('#window_popup_address_c_ch').css('display', 'block');
        $('#save_addr').val('Создать');
        $('#save_addr').data('action', 'create');
    });
    
    //Кнопка изменения адреса
    $('#address_change').click(function (){
        var id_address = $('input:checked[name=radio_address]').val();
        if(id_address === undefined){
            alert('Выберите строку для изменения');
            return;
        }
        $('#wrap_popup_address_create_c_ch').css('display', 'block');
        $('#window_popup_address_c_ch').css('display', 'block');
        $('#save_addr').val('Изменить');
        $('#save_addr').data('action', 'change');
    });
    
    //Кнопка запроса для создания или изменения адреса
    $('#save_addr').click(function (){
        var index = $('[name = index]').val();
        var city = $('[name = city]').val();
        var region = $('[name = region]').val();
        var street = $('[name = street]').val();
        var place = $('[name = place]').val();
        var phone = $('[name = phone]').val();
        if(!ValidateFormAddress())
            return;
        if($('#save_addr').data('action') === 'create'){
            $.ajax({
                url: 'AddressServlet',
                data: {
                    operation: 'create',
                    id_kursant: id_kursant,
                    index: index,
                    city: city,
                    region: region,
                    street: street,
                    place: place,
                    phone: phone
                },
                success: function() {
                    close();
                    addressRequest(id_kursant);
                }
            });
        }
        else{
            var id_address = $('input:checked[name=radio_address]').val();
            $.ajax({
                url: 'AddressServlet',
                data: {
                    operation: 'change',
                    id_address: id_address,
                    index: index,
                    city: city,
                    region: region,
                    street: street,
                    place: place,
                    phone: phone
                },
                success: function() {
                    close();
                    addressRequest(id_kursant);
                }
            });
        }
    });
    
    //Кнопка закрытия всплывающего окна
    $('#close').click(close);
});

function close(){
    $('#wrap_popup_address_create_c_ch').css('display', 'none');
    $('#window_popup_address_c_ch').css('display', 'none');
    clearInputAddress();
}

function clearInputAddress(){
    $('[name = index]').val('');
    $('[name = city]').val('');
    $('[name = region]').val('');
    $('[name = street]').val('');
    $('[name = place]').val('');
    $('[name = phone]').val('');
}