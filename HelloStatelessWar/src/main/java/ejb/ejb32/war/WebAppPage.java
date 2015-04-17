/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 1997-2013 Oracle and/or its affiliates. All rights reserved.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common Development
 * and Distribution License("CDDL") (collectively, the "License").  You
 * may not use this file except in compliance with the License.  You can
 * obtain a copy of the License at
 * https://glassfish.dev.java.net/public/CDDL+GPL_1_1.html
 * or packager/legal/LICENSE.txt.  See the License for the specific
 * language governing permissions and limitations under the License.
 *
 * When distributing the software, include this License Header Notice in each
 * file and include the License file at packager/legal/LICENSE.txt.
 *
 * GPL Classpath Exception:
 * Oracle designates this particular file as subject to the "Classpath"
 * exception as provided by Oracle in the GPL Version 2 section of the License
 * file that accompanied this code.
 *
 * Modifications:
 * If applicable, add the following below the License Header, with the fields
 * enclosed by brackets [] replaced by your own identifying information:
 * "Portions Copyright [year] [name of copyright owner]"
 *
 * Contributor(s):
 * If you wish your version of this file to be governed by only the CDDL or
 * only the GPL Version 2, indicate your decision by adding "[Contributor]
 * elects to include this software in this distribution under the [CDDL or GPL
 * Version 2] license."  If you don't indicate a single choice of license, a
 * recipient has the option to distribute your version of this file under
 * either the CDDL, the GPL Version 2 or to extend the choice of license to
 * its licensees as provided above.  However, if you add GPL Version 2 code
 * and therefore, elected the GPL Version 2 license, then the option applies
 * only if the new code is made subject to such option by the copyright
 * holder.
 */

package ejb.ejb32.war;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public abstract class WebAppPage extends HttpServlet {

    String title = "WebApp Page";
    String name = "WebApp Page";
    
    public WebAppPage(){}
    
    public WebAppPage(String name, String title){
        this.name = name;
        this.title = title;
    }
    
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res)
            throws IOException, ServletException {

        res.setContentType("text/html");
        PrintWriter writer = res.getWriter();
        
        writer.println("<!doctype html>");
        writer.println("<html>");
        writer.println("  <head>");
        writer.println("     <title>"+this.title+"</title>");
        head(req, res);
        writer.println("  </head>");
        writer.println("  <body>");
        body(req, res);
        writer.println("  </body>");
        writer.println("</html>");
    }
    
    protected void body(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        PrintWriter writer = res.getWriter();
        writer.println("<div id='wrap'>");
            
            writer.println("<div id='header'>");
            writer.println("<div>");
                header(req, res);
            writer.println("</div>");
            writer.println("</div>");
        
            writer.println("<div id='right'>");
            writer.println("<div>");
                content(req, res);
            writer.println("</div>");
            writer.println("</div>");
        
            writer.println("<div id='left'>");
            writer.println("<div>");
                menu(req, res);
            writer.println("</div>");
            writer.println("</div>");
            
            writer.println("<div id='footer'>");
            writer.println("<div>");
                footer(req, res);
            writer.println("</div>");
            writer.println("</div>");
            
        writer.println("</div>");
    }
    
    protected void head(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
    {
        PrintWriter writer = res.getWriter();
        writer.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/style.css\">");
    }
    protected void header(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
    {
        PrintWriter writer = res.getWriter();
        writer.println("header");
    }
    protected void footer(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
    {
        PrintWriter writer = res.getWriter();
        writer.println("header");
    }
    protected void menu(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
        PrintWriter writer = res.getWriter();
        writer.println("<h3>Category 1</h3>");
        writer.println("  <ul>");
        writer.println("    <a href='#'><li>item 1</li></a>");
        writer.println("    <a href='#'><li>item 2</li></a>");
        writer.println("    <a href='#'><li>item 3</li></a>");
        writer.println("    <a href='#'><li>item 4</li></a>");
        writer.println("    <a href='#'><li>item 5</li></a>");
        writer.println("  </ul>");
        
        writer.println("<h3>Category 2</h3>");
        writer.println("  <ul>");
        writer.println("    <a href='#'><li>item 1</li></a>");
        writer.println("    <a href='#'><li>item 2</li></a>");
        writer.println("  </ul>");
        
        writer.println("<h3>Category 3</h3>");
        writer.println("  <ul>");
        writer.println("    <a href='#'><li>item 1</li></a>");
        writer.println("    <a href='#'><li>item 2</li></a>");
        writer.println("    <a href='#'><li>item 3</li></a>");
        writer.println("    <a href='#'><li>item 4</li></a>");
        writer.println("  </ul>");
    }
    
    private void writeMenuItem(String name, String href, PrintWriter writer) throws IOException, ServletException{
        String isSelected = name==this.name?" selected":"";
        /*writer.println("<a href='"+href+"'>");
        writer.println("<div class='menuitem"+isSelected+"'>");
        writer.println("<span>"+name+"</span>");
        writer.println("</div>");
        writer.println("</a>");*/
        
    }
    
    private void writeMenuCategory(String name, PrintWriter writer) throws IOException, ServletException{
        /*writer.println("<div class='menuitem category'>");
        writer.println("<span>"+name+"</span>");
        writer.println("</div>");*/
    }
    
    protected void content(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
    {
        PrintWriter writer = res.getWriter();
        writer.println("header");
    }

}
