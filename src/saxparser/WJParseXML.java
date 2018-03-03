/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saxparser;

import java.io.File;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 *
 * @author wjohnke
 */
public class WJParseXML extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    public WJParseXML(){
        //SAXParserFactory pf=new SAXParserFactory() {};
        //SAXParser sp=pf.newSAXParser();
        
        /*ParseHandling parseHandler=new ParseHandling();
        
        parseHandler.startElement(STYLESHEET_CASPIAN, STYLESHEET_MODENA, STYLESHEET_MODENA, attributes);
        */
    }
    
    
}
