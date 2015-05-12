/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.text.AttributedCharacterIterator;
import javax.imageio.ImageIO;
/**
 *
 * @author Fritz Reece
 */
public class WorldMap {
    private MapTile[][] tiles;
    public final int width;
    public final int height;
    public final File background;
    public WorldMap(int dim1, int dim2, File bg){
        width = dim1;
        height = dim2;
        background = bg;
        tiles = new MapTile[dim1/40][dim2/40];
        for(int j=0;j<tiles.length;j++){
            MapTile[] mt = tiles[j];
            for(int i=0;i<mt.length;i++){
                mt[i] = new MapTile(i*40,j*40,TileType.GRASS, this);
            }
        }
    }
    //returns true if it succeeds
   // public boolean addThing(MapThing thing, int x, int y){
     //   return tiles[y][x].add(thing);
  //  }
    public MapTile getTile(int x, int y){
        return tiles[y][x];
    }
    public void createMap() {
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        
        Graphics2D ig2 = bi.createGraphics();
        for(int i = 0; i <= width/40; i++) {
            for(int j = 0; j <=height/40; j++) {
                if(tiles[i][j].getTileType() == TileType.GRASS) {
                    BufferedImage img = null;
                    try {
                     img = ImageIO.read(new File("../rpeg.Textures/grassTile1.jpg"));
                     
                        } catch (IOException e) {
                        }
                   // ig2.drawImage("");
                    
                }
                }
            }
        }
        

        
    }

