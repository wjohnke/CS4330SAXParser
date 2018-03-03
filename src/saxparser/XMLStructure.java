/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saxparser;

import java.util.ArrayList;

/**
 *
 * @author wjohnke
 */
public class XMLStructure {
    public String name;
    public ArrayList<XMLStructure> children;
    public XMLStructure parent;
    public String characters="";
    
    public XMLStructure(String name, String characters){
        this.name=name;
        this.characters=characters;
        children=new ArrayList<XMLStructure>();
    }
    
    @Override
    public String toString(){
        String formation="\n";
        int i=0;
        XMLStructure current;
        current=this;
        
        if(current==null || current.children==null) return "";
        formation+=current.name;
        if( !(current.characters.startsWith("\\s")) ) formation+=":"+current.characters;
        while(true){
            if(current.children.size()>i){
                formation+="\t"+current.children.get(i++).toString();
            }
            else break;
        }
        
        return formation;
    }
    
    
    
    
}
