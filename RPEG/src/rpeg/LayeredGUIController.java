/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


//Push Test

package rpeg;

import BackEnd.Combatant;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;


/**
 * FXML Controller class
 *
 * @author csstudent
 */
public class LayeredGUIController implements Initializable {
    @FXML
    private Pane MapScreen;
    @FXML
    private ImageView map;
    @FXML
    private Pane InventoryPane;
    @FXML
    private Pane characterView;
    @FXML
    private Pane StartPane;
    @FXML
    private Button StartButton;
    @FXML
    private Button InventoryButton;
    @FXML
    private Button hitButton;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          map.setFocusTraversable(true);
             
    }         
   
        // TODO
        

    @FXML
    private void InventoryPane(ActionEvent event) {
        if(!InventoryPane.isVisible()){
        InventoryPane.setVisible(true);
        InventoryButton.setText("Close");
        
        } else {
          InventoryPane.setVisible(false);
        InventoryButton.setText("Inventory");  
        }
        
    }

    
    @FXML
    private void NextPane(ActionEvent event) {
        StartPane.setOpacity(0);
        RPEG.primaryStage.setWidth(948);
        RPEG.primaryStage.setHeight(663);
        MapScreen.setVisible(true);
    }
    @FXML 
    private void quit(ActionEvent event) {
        Platform.exit();
    }
    


    @FXML
    private void handleKeyPressed(KeyEvent e) {
            
        }
    
    @FXML
    private void hit(Combatant combatant){
        
        
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


    
