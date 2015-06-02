/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


//Push Test

package rpeg;


import BackEnd.Player;
import BackEnd.Monster;
import BackEnd.TileType;
import BackEnd.WorldMap;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javax.imageio.stream.ImageInputStream;
import static rpeg.RPEG.w;


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
    private ImageView Player;
    @FXML
    private Pane CombatScreen;
    
    private WorldMap w = RPEG.w;
    
    private ArrayList<ImageView> Mobs = new ArrayList();
    private ArrayList<Monster> MobsObjects = new ArrayList();
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          map.setFocusTraversable(true);
          Image image = new Image("file:map.png");
          map.setImage(image);
          populateMap();
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
        Player = new ImageView("/rpeg/Textures/HeroOfTheUniverse.png");
        MapScreen.getChildren().add(Player);
        Player.setLayoutX(410);
        Player.setLayoutY(160);
        Player.setVisible(true);
        Player.toFront();
        MapScreen.setVisible(true); 
       
    }
    public void populateMap() {  
        int number = (int) (Math.random() * 4) ;
        for(int i = 0; i <= number; i++) {
           int xpos = (int) (Math.random()*10) + 5;
           int ypos = (int) (Math.random()*10) + 6;
            ImageView monster = new ImageView();
            while(!w.getTile(ypos, xpos).canCross() || monsterOverlap(xpos,ypos)) {
              ypos = (int) (Math.random()*10) + 5;  
              xpos = (int) (Math.random()*10) + 5;
            }
            
           Monster mob = new Monster(xpos, ypos);
           System.out.println(xpos + "" + ypos);
           
           MobsObjects.add(mob);
           Mobs.add(new ImageView("/rpeg/Textures/Monster.png"));
           MapScreen.getChildren().add(Mobs.get(i));
           Mobs.get(i).setX(xpos*40 + 250);
           Mobs.get(i).setY(ypos*40);
           Mobs.get(i).toFront();
           
           
        }
    }
    
    private boolean monsterOverlap(int xpos, int ypos){
        for(Monster m : MobsObjects){
            if(xpos == m.getX() && ypos == m.getY()){
                return true;
            }
        }
        return false;
    }
    @FXML 
    private void quit(ActionEvent event) {
        Platform.exit();
    }
    


    @FXML
    private void handleKeyPressed(KeyEvent e) {
           // WorldMap.update();
        int x = (int) Player.getLayoutX();
        int y = (int) Player.getLayoutY();
     
         
     
        
     if(e.getCode() == KeyCode.UP ){
        if(y > 0 &&  w.getTile(((int) (y-map.getLayoutY())/40) - 1, (int) ((x - 250 - (map.getLayoutX() - 250))/40)).canCross()) {
        Player.setLayoutY(Player.getLayoutY() - 40);
        
        }
        if(y == 0) {
          if(!(map.getLayoutY() == 0)) {
              map.setLayoutY(map.getLayoutY() + 600);
              Player.setLayoutY(600); 
          }
          
        
        }
     }
    else if(e.getCode() == KeyCode.DOWN) {
        if(y < 580 && w.getTile((int) (y-map.getLayoutY())/40 + 1, (int) (x - 250 - (map.getLayoutX() - 250))/40).canCross()) {
        Player.setLayoutY(Player.getLayoutY() + 40); 
        System.out.println(map.getLayoutY());
        }
        if(y == 600) {
          
              map.setLayoutY(map.getLayoutY() - 600);
              Player.setLayoutY(0); 

        }
    }
     if(e.getCode() == KeyCode.RIGHT && x < 860 && w.getTile(((int) (y-map.getLayoutY())/40) , (((int) (x - 250 - (map.getLayoutX() - 250)))/40)+1).canCross()){
        
        Player.setLayoutX(Player.getLayoutX() + 40);     
        }
    else if(e.getCode() == KeyCode.LEFT && x > 250 && w.getTile((int) (y-map.getLayoutY())/40, (((int) (x - 250 - (map.getLayoutX() - 250)))/40)-1).canCross()){
        
        Player.setLayoutX(Player.getLayoutX() - 40);     
        }
     
     
    x = (int) Player.getLayoutX();
    y = (int) Player.getLayoutY();
    if(monsterOverlap((x-250)/40, y/40)) {
            MapScreen.setVisible(false);
            RPEG.primaryStage.setWidth(1226);
        RPEG.primaryStage.setHeight(730);
            CombatScreen.setVisible(true);
        }
    }
    
    public static void delay(double seconds){
		long t0;
		long t1;
		t0= System.currentTimeMillis();
		do{
			t1= System.currentTimeMillis();
		}
		while(t1-t0 < 1000 * seconds);
		return;
    }
    
    public void hit(){
        int monsterHealth = mob.getHealth();
        int playerHealth = character.getHealth();
    
    }
    
}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//setText? settext?


    
