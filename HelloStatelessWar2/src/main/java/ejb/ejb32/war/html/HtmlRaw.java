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
public class HtmlRaw extends Html{
    String rawHtml;
    
    public HtmlRaw(String rawHtml){
        this.rawHtml = rawHtml;
    }
    
    @Override
    public void print(PrintWriter writer) {
        writer.println(rawHtml);
    }
    
}
