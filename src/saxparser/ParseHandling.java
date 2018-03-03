/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saxparser;

import java.util.ArrayList;
import java.util.Arrays;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author wjohnke
 */
public class ParseHandling extends DefaultHandler {
    
    private XMLStructure root;
    private ArrayList<XMLStructure> children;
    public XMLStructure current;
    public XMLStructure parent;
    
    
    @Override
    public void startDocument() throws SAXException{
    }
    @Override
    public void endDocument() throws SAXException{
    }
    
    @Override
    public void startElement(String uri, String localName, String qname, Attributes attributes) throws SAXException{
        int last=0;
        
        if(current==null){
            current=new XMLStructure(qname, "");
            root=current;
        }
        else{
            current.children.add(new XMLStructure(qname, ""));
            last=current.children.size()-1;
            current.children.get(last).parent=current;
            int i=0;
            while(attributes.getLength()>i){
                current.children.get(last).characters+="{"+attributes.getQName(i)+":"+attributes.getValue(i)+"}";
                i++;
            }
            current=current.children.get(last);
        }
    }
    
    @Override
    public void endElement(String uri, String localName, String qname) throws SAXException{
        current=current.parent;
    }
    
    @Override
    public void characters(char ch[], int start, int length) throws SAXException{
        if(length<=1) return;
        String newString=new String(ch, start, length);
        String replaceAll = newString.replaceAll("\\s", "");
        if( !(replaceAll.equals("")) ){
            current.characters+=replaceAll;
        }
    }
    
    public XMLStructure getRoot(){
        return root;
    }
}   
