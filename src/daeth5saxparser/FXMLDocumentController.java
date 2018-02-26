/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daeth5saxparser;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 *
 * @author david
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private MenuItem uploadButton;
    
    @FXML
    private MenuItem clearButton;
    
    @FXML
    private MenuItem exitButton;
    
    @FXML
    private TextArea textarea;
    
    @FXML
    private void handleUploadAction(ActionEvent event) {
        textarea.setText("Test Test Test");
    }
    
    @FXML
    private void handleClearAction(ActionEvent event) {
        textarea.setText(" ");
    }
    @FXML
    private void handleExitAction(ActionEvent event) {
        Platform.exit();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
