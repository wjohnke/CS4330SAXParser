/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saxparser;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Window;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;

/**
 *
 * @author wjohnke
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    MenuItem open;
    @FXML
    Window ownerWindow;
    @FXML
    AnchorPane output;
    @FXML
    TextArea text;
    
    @FXML
    private void handleOpen(ActionEvent event){
        if(output!=null){
            output.getChildren().clear();
        }
        FileChooser fileChooser=new FileChooser();
        fileChooser.setTitle("Select XML File to Parse");
        fileChooser.setSelectedExtensionFilter(
                new FileChooser.ExtensionFilter("All Files", ".xml")
        );
        File xmlFile=fileChooser.showOpenDialog(ownerWindow);
        if(xmlFile!=null){
            try{
                SAXParserFactory spf=SAXParserFactory.newInstance();
                spf.setNamespaceAware(true);
                SAXParser sp=spf.newSAXParser();
                
                ParseHandling ph= new ParseHandling();
                sp.parse(xmlFile, ph);
                
               
                text.setText(ph.getRoot().toString());
                
                
                
                System.out.println( ph.getRoot().toString() );
                
            }catch(SAXException | ParserConfigurationException | IOException saxex){ saxex.printStackTrace(System.out);}
        }
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
