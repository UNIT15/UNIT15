/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.ejb32.war;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Дарья
 */
@WebServlet(name = "PeopleServlet", urlPatterns = {"/PeopleServlet"})
public class PeopleServlet extends HttpServlet {

    @EJB
    private PeopleDBLocal PeopleDB;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        String name = request.getParameter("name");
        String lastname = request.getParameter("lastname");
        String agestr = request.getParameter("age");
        int age = 0;
        if(agestr != null && !agestr.equals("")){
            age = Integer.parseInt(agestr);
        }
        
        
        People People = new People(name, lastname, age);
        if("Add".equalsIgnoreCase(action)){
            PeopleDB.addPeople(People);
        }else if("Edit".equalsIgnoreCase(action)){
            PeopleDB.editPeople(People);
        }else if("Delete".equalsIgnoreCase(action)){
            PeopleDB.deletePeople(People);
        }else if("Search".equalsIgnoreCase(action)){
            People = PeopleDB.getPeople(People);
        }
        request.setAttribute("people", People);
        request.setAttribute("Allpeople", PeopleDB.getAllPeople());
        request.getRequestDispatcher("Web.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
