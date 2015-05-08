/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


//Push Test

package rpeg;

import java.awt.event.KeyEvent;
import static java.awt.event.KeyEvent.VK_UP;
import java.awt.event.KeyListener;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author csstudent
 */
public class LayeredGUIController implements Initializable, KeyListener {
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
        // TODO
    }    

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
    
    

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(MapScreen.isVisible()) {
            map.setX(1000);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


    
