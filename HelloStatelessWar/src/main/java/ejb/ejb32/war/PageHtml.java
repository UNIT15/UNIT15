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

import ejb.ejb32.war.html.*;
import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name="TestServlet", urlPatterns={"/index","/index1","/index2"})
public class PageHtml extends WebAppPage {
    
    public PageHtml(){super("HTML Output","About page for you :)");}
    
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
	System.out.println("In TestServlet::init()");
    }

    @Override
    protected void content(HtmlTag html, HttpServletRequest req, HttpServletResponse res)
            throws IOException, ServletException {
        
        
        
        html.addHeader("Demonstrates HTML output");
        html.addParagraph("text text text text text text text text text text ");
        html.addLink("click me", "about:blank");
        
        HtmlTable table = html.addTable().setId("table1").setClass("defaultTable");
        table.addHeadCell("Jmeno");
        table.addHeadCell("Prijmeni");
        
        table.addBodyCell("Petro");
        table.addBodyCell("Kostyuk");
        table.addNewRow();
        
        table.addBodyCell("Denys");
        table.addBodyCell("Rozumnyy");
        table.addNewRow();
        
        table.addBodyCell("Daria");
        table.addBodyCell("Silivonenko");
        table.addNewRow();
        
        HtmlTag form = html.addForm();
        form.addFormInputText("jmeno");
        form.addFormInputText("prijmeni");
       
        HtmlFormTable ft = html.addFormTable();
        
        ft.addFormHeader2("About you");
        
        
        ft.addFormInputText("name", "Enter your name");
        ft.addFormInputCheckbox("flowers","Do you like flowers?");
        
        ft.addFormHeader2("Favourite Colors select");
        
        HtmlOptionList opt = ft.addFormInputSelect("favColor", "So what is your fav. color:");
        opt.addItem("red", "I like red");
        opt.addItem("blue", "I like blue");
        opt.addItem("green", "I like green");
        
        ft.addFormHeader2("Favourite Colors radio");
        
        HtmlOptionList opt2 = ft.addFormInputRadio("favColor", "So what is your fav. color:");
        opt2.addItem("red", "I like red");
        opt2.addItem("blue", "I like blue");
        opt2.addItem("green", "I like green");
        
        ft.addFormHeader2("Kalkulacka");
        ft.addFormInputText("a", "Zadejte clen 'a'");
        HtmlOptionList opt3 = ft.addFormInputRadio("operace", "Operace:");
        opt3.addItem("+", "+");
        opt3.addItem("*", "*");
        ft.addFormInputText("b", "Zadejte clen 'b'");
        
        String a = req.getParameter("q");
        String b = req.getParameter("b");
        String op = req.getParameter("operace");

        ft.addFormInputText("result", "vysledek:").setAttribute("value", a+op+b);
        
        ft.addFormSubmit("odeslat");
        
    }
}
