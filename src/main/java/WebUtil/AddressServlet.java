package WebUtil;

import DAO.DAO1;
import DAO.DAO2;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kurs.Address;
import kurs.Kursant;

/**
 *
 * @author Rakov Kirill
 */

@WebServlet("/AddressServlet")
public class AddressServlet extends HttpServlet {
    private static int baseId = 1;
    private String page = "index.jsp";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        if(request.getParameter("connect") != null){
            baseId = Integer.valueOf(request.getParameter("database_select"));
        }
        request.setAttribute("datasource", baseId);

        String id = request.getParameter("id");
        if(id != null){
            Long idL = Long.valueOf(id);
            Kursant kursant;
            if(baseId == 1)
                kursant = (Kursant) DAO1.getObjectById(idL, Kursant.class);
            else
                kursant = (Kursant) DAO2.getObjectById(idL, Kursant.class);
            List<Address> lst = kursant.getAddresses();
            Iterator<Address> it = lst.iterator();
            while(it.hasNext())
                it.next().setKursant(null);
            response.getWriter().write(new Gson().toJson(lst));
            DAO1.closeOpenedSession();
            DAO2.closeOpenedSession();
            return;
        }

        String id_address = request.getParameter("id_address");
        if(id_address != null && request.getParameter("operation").equals("delete")){
            Long idL = Long.valueOf(id_address);
            if(baseId == 1){
                Address address = (Address) DAO1.getObjectById(idL, Address.class);
                DAO1.closeOpenedSession();
                if(address != null)
                    DAO1.deleteObject(address);
                return;
            }
            else{
                Address address = (Address) DAO2.getObjectById(idL, Address.class);
                DAO2.closeOpenedSession();
                if(address != null)
                    DAO2.deleteObject(address);
                return;
            }
        }

        String operation = request.getParameter("operation");
        if(operation != null){
            String index = request.getParameter("index");
            String city = new String(request.getParameter("city").getBytes("ISO-8859-1"), "UTF-8");
            String region = new String(request.getParameter("region").getBytes("ISO-8859-1"), "UTF-8");
            String street = new String(request.getParameter("street").getBytes("ISO-8859-1"), "UTF-8");
            String place = request.getParameter("place");
            String phone = request.getParameter("phone");
            if(operation.equals("change")){
                Long numI = Long.valueOf(id_address);

                Address address = null;
                if(baseId == 1){
                    address = (Address) DAO1.getObjectById(numI, Address.class);
                    DAO1.closeOpenedSession();
                }
                else{
                    address = (Address) DAO2.getObjectById(numI, Address.class);
                    DAO2.closeOpenedSession();
                }
                if(address != null){
                    address.setInd(index);
                    address.setCity(city);
                    address.setRegion(region);
                    address.setStreet(street);
                    address.setPlace(place);
                    address.setPhone(phone);
                    if(baseId == 1)
                        DAO1.updateObject(address);
                    else
                        DAO2.updateObject(address);
                }
            }
            if(operation.equals("create")){
                Long idKursL = Long.valueOf(request.getParameter("id_kursant"));
                Kursant kursant;
                if(baseId == 1){
                    kursant = (Kursant) DAO1.getObjectById(idKursL, Kursant.class);
                    DAO1.closeOpenedSession();
                }
                else{
                    kursant = (Kursant) DAO2.getObjectById(idKursL, Kursant.class);
                    DAO2.closeOpenedSession();
                }
                Address address = new Address(index, region, city, street, place, phone, kursant);
                if(baseId == 1)
                    DAO1.addObject(address);
                else
                    DAO2.addObject(address);
                return;
            }
        }

        String num = request.getParameter("radio_corteg");
        if(request.getParameter("delete") != null)
            if(num != null){
                Long numI = Long.valueOf(num);
                if(baseId == 1){
                    Kursant kursant = (Kursant) DAO1.getObjectById(numI, Kursant.class);
                    DAO1.closeOpenedSession();
                    if(kursant != null)
                        DAO1.deleteObject(kursant);
                }
                else{
                    Kursant kursant = (Kursant) DAO2.getObjectById(numI, Kursant.class);
                    DAO2.closeOpenedSession();
                    if(kursant != null)
                        DAO2.deleteObject(kursant);
                }
            }

        String save = request.getParameter("save");
        if(save != null){
            String sirname = request.getParameter("sirname");
            String firstname = request.getParameter("firstname");
            String secname = request.getParameter("secname");
            Integer num_group = Integer.valueOf(request.getParameter("num_group"));
            Integer id_kursant = Integer.valueOf(request.getParameter("id_kursant"));
            if(save.equals("Изменить")){
                Long numI = Long.valueOf(num);

                Kursant kursant = null;
                if(baseId == 1){
                    kursant = (Kursant) DAO1.getObjectById(numI, Kursant.class);
                    DAO1.closeOpenedSession();
                }
                else{
                    kursant = (Kursant) DAO2.getObjectById(numI, Kursant.class);
                    DAO2.closeOpenedSession();
                }
                if(kursant != null){
                    kursant.setSirname(sirname);
                    kursant.setFirst_name(firstname);
                    kursant.setSec_name(secname);
                    kursant.setNum_gr(num_group);
                    kursant.setID_kursant(id_kursant);
                    if(baseId == 1)
                        DAO1.updateObject(kursant);
                    else
                        DAO2.updateObject(kursant);
                }
            }
            if(save.equals("Создать")){
                Kursant kursant = new Kursant(num_group, sirname, firstname, secname, id_kursant);
                if(baseId == 1)
                    DAO1.addObject(kursant);
                else
                    DAO2.addObject(kursant);
            }
        }

        if(baseId == 1){
            List lst = DAO1.getAllObjects(Kursant.class);
            DAO1.closeOpenedSession();
            request.setAttribute("kursant_list", lst);
        }
        else{
            List lst = DAO2.getAllObjects(Kursant.class);
            DAO2.closeOpenedSession();
            request.setAttribute("kursant_list", lst);
        }
        RequestDispatcher rd = request.getRequestDispatcher(page);
        rd.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}