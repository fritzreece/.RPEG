/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


//Push Test

package rpeg;


import BackEnd.MapMob;
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
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javax.imageio.stream.ImageInputStream;
import static rpeg.RPEG.w;
import rpeg.RPEG.*;



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
    private Player pc = new Player();
    @FXML
    private Pane CombatScreen;
    
    @FXML
    private Label playerHealth;
    @FXML
    private Label enemyHealth;
   @FXML
   private ImageView PlayerCombat;
   @FXML
   private ImageView MonsterCombat;
   
           
    private WorldMap w = RPEG.w;
    private Monster fightMe;
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
          map.requestFocus();
          
          paintMonsters();
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
    
    private void paintMonsters(){
        for(Monster m : MobsObjects){
            if((m.getX()*40 > map.getLayoutX() - 250  && map.getLayoutX()+600 -250 > m.getX()*40) && (m.getY()*40 > map.getLayoutY() && map.getLayoutY()+600> m.getY()*40)){
                Mobs.get(MobsObjects.indexOf(m)).setVisible(true);
            }
            else{
                Mobs.get(MobsObjects.indexOf(m)).setVisible(false);
            }
        }
    }


    @FXML
    private void handleKeyPressed(KeyEvent e) {
           // WorldMap.update();
        int x = (int) Player.getLayoutX();
        int y = (int) Player.getLayoutY();
     
         
     
        
     if(e.getCode() == KeyCode.UP  &&  w.getTile(((int) (y-map.getLayoutY())/40) - 1, (int) ((x - 250 - (map.getLayoutX() - 250))/40)).canCross()){
        if(y > 0) {
        Player.setLayoutY(Player.getLayoutY() - 40);
        
        }
        if(y == 0) {
          if(!(map.getLayoutY() == 0)) {
              map.setLayoutY(map.getLayoutY() + 600);
              Player.setLayoutY(600); 
              paintMonsters();
          }
          
        
        }
     }
    else if(e.getCode() == KeyCode.DOWN && w.getTile((int) (y-map.getLayoutY())/40 + 1, (int) (x - 250 - (map.getLayoutX() - 250))/40).canCross()) {
        if(y < 580) {
        Player.setLayoutY(Player.getLayoutY() + 40); 
        System.out.println(map.getLayoutY());
        }
        if(y == 600) {
          
              map.setLayoutY(map.getLayoutY() - 600);
              Player.setLayoutY(0); 
              paintMonsters();

        }
    }
    
     if(e.getCode() == KeyCode.RIGHT && w.getTile(((int) (y-map.getLayoutY())/40) , (((int) (x - 250 - (map.getLayoutX() - 250)))/40)+1).canCross()){
        if ( x < 890) {
        Player.setLayoutX(Player.getLayoutX() + 40); 
        System.out.println(Player.getLayoutX());
        }
        else if(x == 890) {
            map.setLayoutX(map.getLayoutX() - 680);
            Player.setLayoutX(250);
            paintMonsters();
        }
        }
    else if(e.getCode() == KeyCode.LEFT && w.getTile((int) (y-map.getLayoutY())/40, (((int) (x - 250 - (map.getLayoutX() - 250)))/40)-1).canCross()){
        if (  x > 250) {
        Player.setLayoutX(Player.getLayoutX() - 40);   
        System.out.println(map.getLayoutX());
        }
        
        if(x == 250 ) {
           if (!(map.getLayoutX() == 250)) {
            map.setLayoutX(map.getLayoutX() + 680);
            Player.setLayoutX(890);
            paintMonsters();
        }
        }
        }
     
     
    x = (int) Player.getLayoutX();
    y = (int) Player.getLayoutY();
    if(monsterOverlap((int) ((x-250- (map.getLayoutX() - 250))/40), (int) ((y-map.getLayoutY())/40))) {
        Monster m = null;
        for(Monster a : MobsObjects) {
            if(a.getX() == (x-250- (map.getLayoutX() - 250))/40 && a.getY() == (int)((y-map.getLayoutY())/40)) {
            m = a;
        }
        }
            MapScreen.setVisible(false);
            RPEG.primaryStage.setWidth(1226);
        RPEG.primaryStage.setHeight(730);
            CombatScreen.setVisible(true);
            enemyHit();
            
            fightMe = MobsObjects.get(0);
            
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
        int mBH = 5;//fightMe.getBaseHealth();
        int mCH = 100;//fightMe.getCurrentHealth();
        int mD = fightMe.getDef();
        int pA = pc.getAtk();
        mCH = mCH - (pA - mD);
        if(checkAlive(mCH) == false){
            playerHealth.setText("VICTORY!!!!");
            enemyHealth.setText("VICTORY!!!!");
            Image img = new Image("file:rpeg/Textures/EnemyDead.png");
            MonsterCombat.setImage(img);
            delay(4);
            CombatScreen.setVisible(false);
            MobsObjects.remove(MobsObjects.indexOf(fightMe));
            MapScreen.getChildren().remove(Mobs.remove(MobsObjects.indexOf(fightMe)));
            MapScreen.setVisible(true);
        }
        else{
            enemyHealth.setText(mCH + "/" + mBH);
        }
    }
    
    public boolean checkAlive(int combatantHealth){
        String battleState = enemyHealth.getText();
        if(combatantHealth > 0 && !battleState.equals("VICTORY!!!!") && !battleState.equals("Defeat...")){
            return true;
        }
        else{
            return false;
        }
    }
    
    public void enemyHit(){
        File file = new File("PlayerStand.png");
        String path = file.getAbsolutePath();
        
         InputStream is = getClass().getResourceAsStream("/rpeg/Textures/PlayerStand.png");
        Image img = new Image(is);
        PlayerCombat.setImage(img);
        is = getClass().getResourceAsStream("/rpeg/Textures/EnemyStand.png");
        img = new Image(is);
        MonsterCombat.setImage(img);
        enemyHealth.setText("READY!");
        delay(3);
        playerHealth.setText("GO!");
        enemyHealth.setText("GO!");
        int pBH = 5;//pc.getBaseHealth();
       int pCH = 5;//pc.getCurrentHealth();
        int mBH = 5;//fightMe.getBaseHealth();
        int mCH = 5;//fightMe.getCurrentHealth();
        playerHealth.setText(pCH + "/" + pBH);
        enemyHealth.setText(mCH + "/" + mBH);
        int pD = fightMe.getDef();
        int mA = pc.getAtk();
        
        while(checkAlive(pCH)){
            delay(1);
           // img = new Image("file:rpeg/Textures/EnemyShoot.png");
            //MonsterCombat.setImage(img);
            delay(0.2);
           // img = new Image("file:rpeg/Textures/EnemyStand.png");
            //MonsterCombat.setImage(img);
            pCH = pCH - (mA - pD);
            playerHealth.setText(pCH + "/" + pBH);
        }
        if(!checkAlive(pCH)){
            playerHealth.setText("Defeat...");
            enemyHealth.setText("Defeat...");
            //Image otherIMG = new Image("file:rpeg/Textures/PlayerDead.png");
           // PlayerCombat.setImage(otherIMG);
            delay(4);
            CombatScreen.setVisible(false);
            MapScreen.setVisible(true);
        }
    }
    
    public void playerHit(){
        
      //  Image img = new Image("file:rpeg/Textures/PlayerSlash.png");
        //PlayerCombat.setImage(img);
    }
    
    public void playerStand(){
        //Image img = new Image("file:rpeg/Textures/PlayerStand.png");
        //PlayerCombat.setImage(img);
    }
    
    
}
    
//312-340-9343



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//setText? settext?


    
