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
public class HtmlOptionList extends HtmlTag {
    IOption option;
    String nameAttr;

    @Override
    public HtmlOptionList setClass(String className) {
        return (HtmlOptionList)super.setClass(className); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HtmlOptionList setName(String name) {
        return (HtmlOptionList)super.setName(name); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HtmlOptionList setIdName(String id) {
        return (HtmlOptionList)super.setIdName(id); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HtmlOptionList setId(String id) {
        return (HtmlOptionList)super.setId(id); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HtmlOptionList setAttribute(String attribute, String value) {
        return (HtmlOptionList)super.setAttribute(attribute, value); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    public HtmlOptionList(String tagName, String nameAttr, IOption option) {
        super(tagName);
        this.option = option;
        this.nameAttr = nameAttr;
    }
    
    public HtmlTag addItem(String value, String title){
        return addTag(option.addItem(value, title, nameAttr));
    }
    
    
    //Options
    
    public interface IOption{
        public HtmlTag addItem(String value, String title, String nameAttr);
    }
    
    public static IOption SelectOption = new IOption() {
        public ejb.ejb32.war.html.HtmlTag addItem(String value, String title, String nameAttr) {
            HtmlTag option = new HtmlTag("option");
            option.setAttribute("value", value).addText(title);
            return option;
        }
    };
    
    public static IOption RadioOption = new IOption() {
        public ejb.ejb32.war.html.HtmlTag addItem(String value, String title, String nameAttr) {
            HtmlTag div = (new HtmlTag("div"));
            HtmlTag radio = div.addFormInput(nameAttr, "radio").setAttribute("value", value);
            div.addText(title);
            return div;
        }
    };
}
