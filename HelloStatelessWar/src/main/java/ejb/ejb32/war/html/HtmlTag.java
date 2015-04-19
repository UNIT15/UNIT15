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
public class HtmlTag extends Html{
    String name = "";
    String attributes = "";
    List<Html> subnodes = new LinkedList();
    
    public HtmlTag(String name){
        this.name = name;
    }
    
    public HtmlTag(String name, String attributes){
        this.name = name;
        this.attributes = attributes;
    }
    
    
    public HtmlTag setAttribute(String attribute, String value){
        value = value.replace("\"", "\\\"");
        this.attributes += " "+attribute+"=\""+value+"\"";
        return this;
    }
    
    public HtmlTag setId(String id){
        return setAttribute("id", id);
    }
    
    public HtmlTag setIdName(String id){
        return setAttribute("id", id).setAttribute("name", id);
    }
    
    public HtmlTag setName(String name){
        return setAttribute("name", name);
    }
    
    public HtmlTag setClass(String className){
        return setAttribute("class", className);
    }
    
    public HtmlTag addNewLine(){
        HtmlTag tag = new HtmlTag("br");
        subnodes.add(tag);
        return tag;
    }
    
    public HtmlTag addHorizontalLine(){
        HtmlTag tag = new HtmlTag("hr");
        subnodes.add(tag);
        return tag;
    }
    
    public void addText(String text){
        subnodes.add(new HtmlRaw(text));
    }
    
    public void addHeader(String text){
        subnodes.add(new HtmlRaw("<h1>"+text+"</h1>"));
    }
    
    public void addHeader2(String text){
        subnodes.add(new HtmlRaw("<h2>"+text+"</h2>"));
    }
    
    public HtmlTag addParagraph(){
        HtmlTag tag = new HtmlTag("p");
        subnodes.add(tag);
        return tag;
    }
    
    public HtmlTag addImage(String image){
        HtmlTag tag = new HtmlTag("img").setAttribute("src", "img/"+image);
        subnodes.add(tag);
        return tag;
    }
    
    public HtmlTag addParagraph(String text){
        HtmlTag tag = new HtmlTag("p");
        tag.addText(text);
        subnodes.add(tag);
        return tag;
    }
    
    public HtmlTag addLink(String text, String linkHref){
        HtmlTag tag = new HtmlTag("a");
        tag.setAttribute("href", linkHref);
        tag.addText(text);
        subnodes.add(tag);
        return tag;
    }
    
    public HtmlTag addContainer(){
        HtmlTag tag = new HtmlTag("div");
        subnodes.add(tag);
        return tag;
    }
    
    public HtmlFormTable addFormTable(){
        HtmlFormTable tag = new HtmlFormTable();
        subnodes.add(tag);
        return tag;
    }
    
    public HtmlTag addForm(){
        HtmlTag tag = new HtmlTag("form");
        subnodes.add(tag);
        return tag;
    }
    
    public HtmlTag addFormInput(String name, String type){
        HtmlTag tag = new HtmlTag("input");
        tag.setAttribute("name", name);
        tag.setAttribute("type", type);
        subnodes.add(tag);
        return tag;
    }
    
    public HtmlTag addFormInputText(String name){
        return addFormInput(name, "text");
    }
    
    public HtmlTag addFormInputCheckbox(String name){
        return addFormInput(name, "checkbox");
    }
    
    public HtmlOptionList addFormInputSelect(String name){
        HtmlOptionList tag = new HtmlOptionList("select", name, HtmlOptionList.SelectOption).setAttribute("name", name);
        addTag(tag);
        return tag;
    }
    
    public HtmlOptionList addFormInputRadioSet(String name){
        HtmlOptionList tag = new HtmlOptionList("div", name, HtmlOptionList.RadioOption).setClass("radioset");
        addTag(tag);
        return tag;
    }
    
    public HtmlTag addFormSubmit(String title){
        return addFormInput("", "submit").setAttribute("value", title);
    }
    
    public HtmlTag addFormSubmitWithName(String name, String title){
        return addFormInput(name, "submit").setAttribute("value", title);
    }
    
    public HtmlTag addTag(HtmlTag tag){
        subnodes.add(tag);
        return tag;
    }
    
    public HtmlTable addTable(){
        HtmlTable tag = new HtmlTable();
        subnodes.add(tag);
        return tag;
    }
    
    @Override
    public void print(PrintWriter writer) {
        if(subnodes.isEmpty())
            writer.println("<"+name+attributes+" />");
        else{
            writer.println("<"+name+attributes+">");
            for (Html subnode : subnodes) {
                subnode.print(writer);
            }
            writer.println("</"+name+">");
        }
    }
}
