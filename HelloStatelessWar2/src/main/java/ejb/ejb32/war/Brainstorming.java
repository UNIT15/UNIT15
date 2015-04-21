/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.ejb32.war;

import ejb.ejb32.war.html.HtmlTag;
import java.io.IOException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Дарья
 */
@Stateless
@WebServlet(name = "Brainstorming", urlPatterns = {"/PageBrainstorming"})
public class Brainstorming extends WebAppPage {

    public Brainstorming() {
    }

    @Override
    protected void content(HtmlTag html, HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

        EntityManager em = null;
        try {
            em = emf.createEntityManager();

        } catch (Exception ex) {
            throw new ServletException(ex);
        } finally {
            //close the em to release any resources held up by the persistebce provider
            if (em != null) {
                em.close();
            }//To change body of generated methods, choose Tools | Templates.
        }
    }

}
