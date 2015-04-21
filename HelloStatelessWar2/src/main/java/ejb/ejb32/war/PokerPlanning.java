/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.ejb32.war;

import ejb.ejb32.war.html.HtmlTag;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Дарья
 */
@Stateless
@WebServlet(name = "PokerPlanning", urlPatterns = {"/PagePokerPlanning"})
public class PokerPlanning extends WebAppPage {

    public PokerPlanning() {

    }

    @Override
    protected void content(HtmlTag html, HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
       
        EntityManager em = null;
        try {
            em = emf.createEntityManager();

            //query for all the persons in database
            /**
             * List persons = em.createQuery("select p from User
             * p").getResultList();
             *
             * for (Object person : persons) {
             * table.addBodyCell(person.toString()); table.addNewRow();
            }/*
             */
        } catch (Exception ex) {
            throw new ServletException(ex);
        } finally {
            //close the em to release any resources held up by the persistebce provider
            if (em != null) {
                em.close();
            }//To change body of generated methods, choose Tools | Templates.
        }
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
}
