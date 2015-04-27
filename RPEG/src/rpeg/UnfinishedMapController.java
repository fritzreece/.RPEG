/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpeg;

import java.awt.event.KeyEvent;
import static java.awt.event.KeyEvent.*;
import java.awt.event.KeyListener;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author csstudent
 */
public class UnfinishedMapController implements Initializable, KeyListener {
@FXML
public ImageView map; 
public UnfinishedMapController() {
}

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    public void keyTyped(KeyEvent e) {
        
    }

    @FXML
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == VK_UP) {
            map.setY(map.getY() + 5);
              
    }
    }
    @FXML
    public void keyReleased(KeyEvent e) {
        
    }
  
    
}
