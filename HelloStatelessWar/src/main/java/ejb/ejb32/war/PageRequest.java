/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.ejb32.war;

import ejb.ejb32.war.html.*;
import java.io.IOException;
import java.util.TreeMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author petro
 */
@WebServlet(name = "PageRequest", urlPatterns = {"/PageRequest"})
public class PageRequest extends WebAppPage {
    TreeMap<String, String> data = new TreeMap();
            
    public PageRequest(){super("Request", "Demonstrates request handling");}
    
    @Override
    protected void logic(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        data.put("name", req.getParameter("name")==null?"":req.getParameter("name"));
        data.put("surname", req.getParameter("surname")==null?"":req.getParameter("surname"));
        data.put("number", req.getParameter("number")==null?"":req.getParameter("number"));
    }
    
    @Override
    protected void content(HtmlTag html, HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        html.addHeader("Demonstrates request handling");
        html.addHeader2("request");
        
        HtmlFormTable form = html.addFormTable();
        form.addFormInputText("name", "Enter your name:");
        form.addFormInputText("surname", "Enter your surname:");
        form.addFormSubmit("Generate Hello");
        
        form.addFormInputText("number", "Enter some number:");
        form.addFormSubmit("Calculate");
        
        html.addHeader2("response");
        if(!"".equals(data.get("name")) && !"".equals(data.get("surname"))){
            html.addParagraph("Hello "+data.get("name")+" "+data.get("surname")+"!");
        }
        
        if(!"".equals(data.get("number"))){
            try{
                int num = Integer.parseInt(data.get("number"));
                html.addParagraph(num+" * 2 = "+(num*2) );
                html.addParagraph(num+" * "+num+" = "+(num*num) );
                html.addParagraph("sqrt("+num+") = " + Math.sqrt(num));
            }catch(Exception e){
                html.addParagraph("Number you entered is probably NOT a number!!");
            }
        }
    }

    

}
