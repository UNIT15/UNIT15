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

import ejb.ejb32.war.html.HtmlTag;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.persistence.PersistenceUnit;
import javax.persistence.EntityManagerFactory;
import javax.annotation.Resource;
import javax.transaction.UserTransaction;



public abstract class WebAppPage extends HttpServlet {

    String title = "WebApp Page";
    String name = "WebApp Page";
    
    @PersistenceUnit
    protected EntityManagerFactory emf;
    
    @Resource
    protected UserTransaction transaction;
    
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

        logic(req, res);
        
        res.setContentType("text/html");
        PrintWriter writer = res.getWriter();
        
        writer.println("<!doctype html>");
        HtmlTag html = new HtmlTag("html");
        HtmlTag head = html.addTag(new HtmlTag("head"));
        head.addText("<title>"+this.title+"</title>");
        head(head, req, res);
        
        HtmlTag body = html.addTag(new HtmlTag("body"));
        body(body, req, res);
        
        html.print(writer);
    }
    
    protected void logic(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException { }
    
    protected void head(HtmlTag html, HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
    {
        html.addText("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/style.css\">");
    }
    
    protected void body(HtmlTag html, HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        HtmlTag page = html.addContainer().setId("page").addContainer();
        header(page.addContainer().setId("header").addContainer(),req, res);
        menu(page.addContainer().setId("menu").addContainer(),req, res);
        content(page.addContainer().setId("content").addContainer(),req, res);
        footer(page.addContainer().setId("footer").addContainer(),req, res);
    }
    
    protected void header(HtmlTag html, HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
    {
        html.addText("header");
    }
    
    protected void menu(HtmlTag html, HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
        
        html.addContainer().setClass("menuHeader").addText("Welcome");
        addMenuItem(html, "About Us", "About");
        html.addContainer().setClass("menuSpacer").addText(" ");
        
        html.addContainer().setClass("menuHeader").addText("Samples");
        addMenuItem(html, "HTML Output", "index");
        addMenuItem(html, "Request", "PageRequest");
        addMenuItem(html, "Database", "PageDatabase");
        html.addContainer().setClass("menuSpacer").addText(" ");
        
        html.addContainer().setClass("menuHeader").addText("People");

        addMenuItem(html, "Daria", "PageDasha");
        addMenuItem(html, "Denys", "rozumden");
        addMenuItem(html, "Petro", "PagePetro");

        html.addContainer().setClass("menuSpacer").addText(" ");
        
        html.addContainer().setClass("menuSpacer").addText(" ");
        
    }
    
    protected void addMenuItem(HtmlTag html, String name, String href){
        HtmlTag tag = html.addLink("", href).addContainer();
        if(name.equals(this.name))tag.setClass("menuItem selected");
        else tag.setClass("menuItem");
        tag.addText(name);
        
    }
    
    protected void content(HtmlTag html, HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
    {
        html.addText("content");
    }
    
    protected void footer(HtmlTag html, HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
    {
        html.addText("footer");
    }

}
