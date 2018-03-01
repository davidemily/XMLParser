/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daeth5saxparser;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author david
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private  MenuItem uploadButton;
    
    @FXML
    private  MenuItem clearButton;
    
    @FXML
    private MenuItem exitButton;
    
    @FXML
    private TextArea textArea;
    
    @FXML
    private void handleUploadAction(ActionEvent event) throws ParserConfigurationException, SAXException, IOException{
        SAXParserFactory factory = SAXParserFactory.newInstance();
        DefaultHandler handler = new DefaultHandler() {
            @Override
            public void characters(char[] ch, int start, int length) {
                textArea.appendText("" + new String(ch, start, length));
            }
            @Override
            public void startDocument() throws SAXException {
                setTextArea("Start document: \n");
            }

            @Override
            public void endDocument() throws SAXException {
                setTextArea("\nEnd document");
            }

            @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes)throws SAXException {

            setTextArea("Start element: " + qName);
            }

            @Override
            public void endElement(String uri, String localName, String qName) throws SAXException {
                setTextArea("End element: " + qName);
            }
        };

      try {
            FileChooser fileChooser = new FileChooser();
            File file = fileChooser.showOpenDialog(textArea.getScene().getWindow());            
            FileInputStream is = new FileInputStream(file);
            SAXParser parser = factory.newSAXParser();         
            parser.parse(is, handler);
          } catch (IOException | ParserConfigurationException | SAXException ex) {
            throw (ex);
            }
    }
    @FXML
    private void handleClearAction(ActionEvent event) {
        textArea.setText(" ");
    }
    @FXML
    private void handleExitAction(ActionEvent event) {
        Platform.exit();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void setTextArea(String myString) {
        textArea.appendText(myString);
    }
}
