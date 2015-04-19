/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.ejb32.war;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author honza
 */
@WebServlet(name = "PageDenys", urlPatterns = {"/rozumden"})
public class PageDenys extends WebAppPage {

    public PageDenys(){
        super("PageDenys", "Denys Rozumnyi");
    }

}
