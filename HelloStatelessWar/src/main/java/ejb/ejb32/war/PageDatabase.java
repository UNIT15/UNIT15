/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.ejb32.war;

import ejb.ejb32.war.html.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.TreeMap;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author petro
 */
@WebServlet(name = "PageDatabase", urlPatterns = {"/PageDatabase"})
public class PageDatabase extends WebAppPage {

    TreeMap<String, String> data = new TreeMap();
    
    private @EJB Database database;
    
    public PageDatabase(){super("Database","PageDatabase");}
    

    @Override
    protected void logic(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        data.put("login", req.getParameter("login")==null?"":req.getParameter("login"));
        data.put("pass", req.getParameter("pass")==null?"":req.getParameter("pass"));
        data.put("doLogin", req.getParameter("doLogin")==null?"":req.getParameter("doLogin"));
        data.put("doRegister", req.getParameter("doRegister")==null?"":req.getParameter("doRegister"));
    }
    
    @Override
    protected void content(HtmlTag html, HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        HtmlFormTable ft = html.addFormTable();
        ft.addFormHeader2("Login/Register");
        //login
        if(!"".equals(data.get("doLogin"))){
            if("".equals(data.get("login")) || "".equals(data.get("pass"))){
                html.addParagraph("You must fill in both login and password!");
            }
            else{
                if(database.UserLogin(data.get("login"), data.get("pass")))
                    html.addParagraph("User "+data.get("login")+" was loged in sucessfuly.");
                else
                    html.addParagraph("User "+data.get("login")+" was NOT loged in.");
            }
        }
        //register
        else if(!"".equals(data.get("doRegister"))){
            if("".equals(data.get("login")) || "".equals(data.get("pass"))){
                html.addParagraph("You must fill in both login and password!");
            }
            else{
                if(database.UserRegister(data.get("login"), data.get("pass")))
                    html.addParagraph("Registration of user "+data.get("login")+" was sucessful.");
                else
                    html.addParagraph("There was error during user "+data.get("login")+" registration.");
            }
        }
        //create form
        else{
            ft.addFormInputText("login", "login:");
            ft.addFormInputText("pass", "password:");
            ft.addFormSubmitWithName("doLogin", "login");
            ft.addFormSubmitWithName("doRegister","register");
        }
        
        
    }
    
}
