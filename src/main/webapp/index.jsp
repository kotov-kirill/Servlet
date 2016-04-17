<%@page import="kurs.Kursant"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="styles/StylePopup.css" rel="stylesheet" type="text/css">
        <link href="styles/Table.css" rel="stylesheet" type="text/css">
        <link href="styles/buttons.css" rel="stylesheet" type="text/css">
        <script src="scripts/ButtonChange.js" type="text/javascript"></script>
        <script src="scripts/ButtonDeleteValidate.js" type="text/javascript"></script>
        <script src="scripts/PopupShow.js" type="text/javascript"></script>
        <script src="scripts/ValidateForm.js" type="text/javascript"></script>
        <script src="scripts/jquery-1.7.2.min.js" type="text/javascript"></script>
        <script src="scripts/buttonAddr.js" type="text/javascript"></script>
        <script src="scripts/ValidateFormAddress.js" type="text/javascript"></script>
        <title>Курсант</title>
    </head>
    <body>
        <div style="margin: 0 auto; width: 77%;">
        <% String baseName;
           if((Integer)request.getAttribute("datasource") == 1)
               baseName = "SQLite";
           else
               baseName = "Oracle";
        %>
        <h1 style="text-align: center;"><%=baseName%>: Kursant</h1> 
        <form method="POST" action="AddressServlet" name="MainForm">
            <select name="database_select">
                <option value="1">SQLite</option>
                <option value="2">Oracle</option>
            </select>
            <input type="submit" name="connect" value="Подключиться" class="button con">
            
            <table class="address">
                <tr>
                    <th><b>Выбор</b></th>
                    <th><b>ID</b></th>
                    <th><b>Фамилия</b></th>
                    <th><b>Имя</b></th>
                    <th><b>Отчество</b></th>
                    <th><b>№ группы</b></th>
                    <th><b>Идентификатор</b></th>
                    <th><b>Адр</b></th>
                </tr>
                <% Iterator<Kursant> it = ((List)request.getAttribute("kursant_list")).iterator();
                   while(it.hasNext()){
                   Kursant kursant = it.next(); %>
                   <tr>
                       <td><input name="radio_corteg" type="radio" value="<%=kursant.getId()%>" /></td>
                       <td><%=kursant.getId() %></td>
                       <td><%=kursant.getSirname() %></td>
                       <td><%=kursant.getFirst_name() %></td>
                       <td><%=kursant.getSec_name() %></td>
                       <td><%=kursant.getNum_gr() %></td>
                       <td><%=kursant.getID_kursant() %></td>
                       <td><a href="#" onclick="buttonAddr(<%=kursant.getId()%>)"><img src="images/folder_open.png" width="20px" height="20px" /></a></td>
                   </tr>
                <%}%>
            </table> <br/>
            <input type="submit" value="Удалить" name="delete" onclick="return ButtonDelete()" class="delete"/>
            <input type="button" value="Изменить" onclick="ButtonChange()" class="button"/>
            <input type="button" value="Создать" class="button" onclick="PopupShow('Создать','block')"/>
            
            <!-- PopupMenu -->
            <div onclick="PopupShow('','none')" id="wrap"></div>
            <div class="popup reg_form" id="window">
            <a class="close" href="#" onclick="PopupShow('','none')">Close</a>
            <h2>Таблица Курсант</h2>
                    <label for="sirname">Фамилия:</label>
                    <input type="text" name="sirname" />
                    <label for="firstname">Имя:</label>
                    <input type="text" name="firstname" />
                    <label for="secname">Отчество:</label>
                    <input type="text" name="secname" />
                    <label for="num_group">Номер группы:</label>
                    <input type="text" name="num_group" />
                    <label for="id_kursant">Личный номер:</label>
                    <input type="text" name="id_kursant" />
                    <input type="submit" name="save" onClick="return ValidateForm()"/>	
            </div>
            <!-- /PopupMenu -->
            
            <!-- PopupAddress -->
            <div id="wrap_popup_address" class="popup_background"></div>
            <div class="popup reg_form" id="window_popup_address">
                <a class="close" href="#" onclick="PopupShowAddress('none')">Close</a>
                <h1>Адреса: </h1>
                <div id = "table" >
                </div><br />
                <input type="button" value="Удалить" id="address_delete" />
                <input type="button" value="Изменить" id="address_change" />
                <input type="button" value="Создать" id="address_create" />
            </div>
            <!-- /PopupAddress -->
            
            <!-- PopupAddressCreateOrChange -->
            <div id="wrap_popup_address_create_c_ch"></div>
            <div class="popup reg_form" id="window_popup_address_c_ch">
            <a class="close" href="#" id="close">Close</a>
            <h2>Таблица Адрес</h2>
                    <label for="index">Индекс:</label>
                    <input type="text" name="index" />
                    <label for="city">Город:</label>
                    <input type="text" name="city" />
                    <label for="region">Регион:</label>
                    <input type="text" name="region" />
                    <label for="street">Улица:</label>
                    <input type="text" name="street" />
                    <label for="place">Место:</label>
                    <input type="text" name="place" />
                    <label for="pone">Телефон:</label>
                    <input type="text" name="phone" />
                    <input type="button" id="save_addr" data-action="">	
            </div>
            <!-- /PopupAddressCreateOrChange -->
        </form>
        </div>
    </body>
</html>