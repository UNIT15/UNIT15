/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.ejb32.war;

import ejb.ejb32.war.html.*;
import java.io.IOException;
import javax.ejb.Stateless;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.persistence.EntityManager;

/**
 *
 * @author petro
 */
@Stateless
@WebServlet(name = "About", urlPatterns = {"/Home"})
public class PageAbout extends WebAppPage {

    String comment = "header";
    
    public PageAbout(){
        super("About Us", "Something about us");
    }

    @Override
    protected void logic(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        String login = req.getParameter("login_login");
        String pass = req.getParameter("login_login");
        if(!"".equals(login) && !"".equals(pass) && login!=null && pass!=null){
            comment = "You tried to log in as: "+login;
        }
        
        login = req.getParameter("register_login");
        pass = req.getParameter("register_pass");
        if(!"".equals(login) && !"".equals(pass) && login!=null && pass!=null){
            comment = "You registered new user: "+login;
        }
    }

    @Override
    protected void header(HtmlTag html, HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        html.addText(comment);
    }

    
    
    @Override
    protected void content(HtmlTag html, HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        html.addHeader("About us");
        html.addParagraph("This is sample paragraph of text");
        HtmlFormTable ft = html.addFormTable();
        
        ft.addFormHeader2("Login");
        ft.addFormInputText("login_login", "Login:");
        ft.addFormInputText("login_pass", "Password:");
        ft.addFormSubmit("Login");
        
        ft.addFormHeader2("Register");
        ft.addFormInputText("register_login", "Login:");
        ft.addFormInputText("register_pass", "Password:");
        ft.addFormSubmit("Regisrovat");
        
        html.addHeader2("Registered Users");
        HtmlTable table = new HtmlTable();
        table.addHeadCell("Id");
        table.addHeadCell("Login");
        table.addHeadCell("Pass");
        
        EntityManager em = null;
        try {
            em = emf.createEntityManager();

            //query for all the persons in database
            /**List persons = em.createQuery("select p from User p").getResultList();
            
            for (Object person : persons) {
                table.addBodyCell(person.toString());
                table.addNewRow();
            }/**/
            
        } catch (Exception ex) {
            throw new ServletException(ex);
        } finally {
            //close the em to release any resources held up by the persistebce provider
            if(em != null) {
                em.close();
            }
        }
        
    }
    
    
}
