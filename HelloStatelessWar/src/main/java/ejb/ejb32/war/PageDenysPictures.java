/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.ejb32.war;

import ejb.ejb32.war.html.HtmlTag;
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
@WebServlet(name = "PageDenysPictures", urlPatterns = {"/pictures"})
public class PageDenysPictures extends WebAppPage {
    
    public PageDenysPictures() {
        super("PageDenysPictures","Pictures");
    }

    @Override
    protected void content(HtmlTag html, HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        html.addImage("sphere_prague.jpg").setAttribute("width", "500px");
    }

    
    
}
