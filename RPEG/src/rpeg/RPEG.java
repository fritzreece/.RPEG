/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpeg;

import BackEnd.WorldMap;
import com.sun.javaws.Main;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author csstudent
 */
public class RPEG extends Application {
    public static Stage primaryStage = new Stage();
    @Override
    public void start(Stage primaryStage1) throws IOException {
        
   try {
       WorldMap w = new WorldMap(601, 398);
       w.createMap();
       StackPane page = FXMLLoader.load(RPEG.class.getResource("LayeredGUI.fxml"));
       Scene scene = new Scene(page);
       primaryStage.setScene(scene);
       primaryStage.setResizable(false);
       primaryStage.setWidth(601);
       primaryStage.setHeight(398);
       primaryStage.setTitle(".rpeg");
       primaryStage.show();
    } catch (Exception ex) {
            Logger.getLogger(RPEG.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    /**
     * @param args the command line arguments
     */ 
public static void main(String[] args) {
        Application.launch(RPEG.class, (java.lang.String[])null);
    }
    
    
}

