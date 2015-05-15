/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


//Push Test

package rpeg;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javax.imageio.stream.ImageInputStream;


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
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          map.setFocusTraversable(true);
          Image image = new Image("file:map.png");
          map.setImage(image);
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
           // WorldMap.update();
            
        }
    


}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


    
