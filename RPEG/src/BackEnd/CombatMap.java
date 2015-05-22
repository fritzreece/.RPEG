/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd;

/**
 *
 * @author jwsti_000
 */
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class CombatMap {

    public final int width;
    public final int height;
    public final File background;
    public CombatMap(int dimX, int dimY, File cbg){
        width = dimX;
        height = dimY;
        background = cbg;
    }
    
    public void createCombatScene(){
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D ig2 = bi.createGraphics();
        for(int i = 0; i < width / 40; i++) {
            for(int j = 0; j < height / 40; j++) {
                BufferedImage img = null;
                JPanel test = new JPanel();
                try {
                    InputStream is = getClass().getResourceAsStream("/rpeg/Textures/BattleBackground.png");
                    img = ImageIO.read(is);
                    ig2.drawImage(img, i * 40, j * 40, test);
                } catch (IOException ex) {
                    Logger.getLogger(CombatMap.class.getName()).log(Level.SEVERE, null, ex);
                }
                       // ig2.drawImage("");


            }
        }
    }
}