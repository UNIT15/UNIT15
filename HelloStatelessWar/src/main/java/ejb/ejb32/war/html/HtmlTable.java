/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.ejb32.war.html;

import java.io.PrintWriter;
import java.util.*;

/**
 *
 * @author petro
 */
public class HtmlTable extends HtmlTag {
    HtmlTag headTag = new HtmlTag("thead");
    HtmlTag headRow = new HtmlTag("tr");
    
    HtmlTag bodyTag = new HtmlTag("tbody");
    HtmlTag bodyRow = new HtmlTag("tr");
    
    public HtmlTable() {
        super("table");
        addTag(headTag);
        addTag(bodyTag);
        
        headTag.addTag(headRow);
        bodyTag.addTag(bodyRow);
    }

    @Override
    public HtmlTable setAttribute(String attribute, String value) {
        return (HtmlTable)super.setAttribute(attribute, value);
    }

    @Override
    public HtmlTable setClass(String className) {
        return (HtmlTable)super.setClass(className); 
    }

    @Override
    public HtmlTable setName(String name) {
        return (HtmlTable)super.setName(name); 
    }

    @Override
    public HtmlTable setIdName(String id) {
        return (HtmlTable)super.setIdName(id); 
    }

    @Override
    public HtmlTable setId(String id) {
        return (HtmlTable)super.setId(id); 
    }
    
    public HtmlTag addHeadCell(String content){
        HtmlTag cell = new HtmlTag("th");
        cell.addText(content);
        headRow.addTag(cell);
        return cell;
    }
    
    public HtmlTag addBodyCell(){
        HtmlTag cell = new HtmlTag("td");
        bodyRow.addTag(cell);
        return cell;
    }
    
    
    public HtmlTag addBodyCell(String content){
        HtmlTag cell = new HtmlTag("td");
        cell.addText(content);
        bodyRow.addTag(cell);
        return cell;
    }
    
    public HtmlTag addBodyCellBold(String content){
        HtmlTag cell = new HtmlTag("th");
        cell.addText(content);
        bodyRow.addTag(cell);
        return cell;
    }
    
    public void addNewRow(){
        bodyRow = new HtmlTag("tr");
        bodyTag.addTag(bodyRow);
    }

    @Override
    public void print(PrintWriter writer) {
        super.print(writer);
    }
    
    
}
