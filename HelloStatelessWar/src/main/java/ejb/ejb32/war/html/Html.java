/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.ejb32.war.html;

import java.io.PrintWriter;

/**
 *
 * @author petro
 */
public abstract class Html {
    public static HtmlTag newLine = new HtmlTag("br");
    
    
    public abstract void print(PrintWriter writer);
}
