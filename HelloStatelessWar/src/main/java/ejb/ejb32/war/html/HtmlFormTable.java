/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.ejb32.war.html;

/**
 *
 * @author petro
 */
public class HtmlFormTable extends HtmlTag{
    HtmlTable table;
    
    public HtmlFormTable(){
        super("form");
        table = addTable();
    }

    @Override
    public HtmlFormTable setClass(String className) {
        return (HtmlFormTable)super.setClass(className); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HtmlFormTable setName(String name) {
        return (HtmlFormTable)super.setName(name); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HtmlFormTable setIdName(String id) {
        return (HtmlFormTable)super.setIdName(id); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HtmlFormTable setId(String id) {
        return (HtmlFormTable)super.setId(id); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HtmlFormTable setAttribute(String attribute, String value) {
        return (HtmlFormTable)super.setAttribute(attribute, value); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public void addFormHeader(String title){
        table.addBodyCell().setAttribute("colspan", "2").addHeader(title);
        table.addNewRow();
    }
    
    public void addFormHeader2(String title){
        table.addBodyCell().setAttribute("colspan", "2").addHeader2(title);
        table.addNewRow();
    }
    
    public HtmlTag addFormInputText(String name, String title){
        table.addBodyCell(title);
        HtmlTag cell = table.addBodyCell();
        table.addNewRow();
        return cell.addFormInputText(name);
    }
    
    public HtmlTag addFormInputCheckbox(String name, String title){
        table.addBodyCell(title);
        HtmlTag cell = table.addBodyCell();
        table.addNewRow();
        return cell.addFormInputCheckbox(name);
    }
    
    @Override
    public HtmlTag addFormSubmit(String title){
        HtmlTag tag = table.addBodyCell().setAttribute("colspan", "2").addFormSubmit(title);
        table.addNewRow();
        return tag;
    }
    
    @Override
    public HtmlTag addFormSubmitWithName(String name, String title){
        HtmlTag tag = table.addBodyCell().setAttribute("colspan", "2").addFormSubmitWithName(name, title);
        table.addNewRow();
        return tag;
    }
    
    
    
    public HtmlOptionList addFormInputSelect(String name, String title){
        table.addBodyCell(title);
        HtmlTag cell = table.addBodyCell();
        table.addNewRow();
        return cell.addFormInputSelect(name);
    }
    
    public HtmlOptionList addFormInputRadio(String name, String title){
        table.addBodyCell(title);
        HtmlTag cell = table.addBodyCell();
        table.addNewRow();
        return cell.addFormInputRadioSet(name);
    }
    
}
