/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author Fritz Reece
 */
public class WorldMap {

    private MapTile[][] tiles;
    private List<MapMob> mobs;
    public final int width;
    public final int height;

    //  public final File background;

    public WorldMap(int dim1, int dim2) {
        width = dim1;
        height = dim2;
        //background = bg;
        tiles = new MapTile[dim1 / 40][dim2 / 40];
        mobs = new ArrayList<>();
        for (int j = 0; j < tiles.length; j++) {
            MapTile[] mt = tiles[j];
            for (int i = 0; i < mt.length; i++) {
                mt[i] = new MapTile(i * 40, j * 40, TileType.GRASS, this);
            }
        }
    }
    //returns true if it succeeds
    // public boolean addThing(MapThing thing, int x, int y){
    //   return tiles[y][x].add(thing);
    //  }

    public MapTile getTile(int x, int y) {
        return tiles[y][x];
    }

    public void createMap() throws IOException {
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        tiles[0][0].setTileType(TileType.WATER);
        tiles[0][1].setTileType(TileType.WATER);
        tiles[0][2].setTileType(TileType.WATER);
        tiles[1][0].setTileType(TileType.WATER);
        tiles[1][1].setTileType(TileType.WATER);
        tiles[1][2].setTileType(TileType.WATER);
        tiles[0][3].setTileType(TileType.WATER);
        tiles[0][4].setTileType(TileType.WATER);
        tiles[2][0].setTileType(TileType.WATER);
        tiles[3][0].setTileType(TileType.WATER);
        tiles[4][0].setTileType(TileType.WATER);
        tiles[2][1].setTileType(TileType.WATER);
        tiles[7][3].setTileType(TileType.WALL);
        tiles[7][4].setTileType(TileType.WALL);
        tiles[7][5].setTileType(TileType.WALL);
        tiles[7][6].setTileType(TileType.WALL);
        tiles[7][7].setTileType(TileType.WALL);
        tiles[7][8].setTileType(TileType.WALL);
        tiles[7][9].setTileType(TileType.WALL);
        tiles[7][16].setTileType(TileType.WALL);
        tiles[17][8].setTileType(TileType.WALL);
        Graphics2D ig2 = bi.createGraphics();
        
        for (int i = 0; i < width / 40; i++) {
            for (int j = 0; j < height / 40; j++) {
                if (tiles[i][j].getTileType() == TileType.GRASS) {
                    BufferedImage img = null;
                    JPanel test = new JPanel();
                    try {
                        InputStream is = getClass().getResourceAsStream("/rpeg/Textures/grassTile1.jpg");
                        img = ImageIO.read(is);
                        ig2.drawImage(img, i * 40, j * 40, test);
                    } catch (IOException ex) {
                        Logger.getLogger(WorldMap.class.getName()).log(Level.SEVERE, null, ex);
                    }
                   // ig2.drawImage("");

                }
                if (tiles[i][j].getTileType() == TileType.WATER) {
                    BufferedImage img = null;
                    JPanel test = new JPanel();
                    try {
                        InputStream is = getClass().getResourceAsStream("/rpeg/Textures/OceanTile.png");
                        img = ImageIO.read(is);
                        ig2.drawImage(img, i * 40, j * 40, test);
                    } catch (IOException ex) {
                        Logger.getLogger(WorldMap.class.getName()).log(Level.SEVERE, null, ex);
                    }
                   // ig2.drawImage("");

                }
                if (tiles[i][j].getTileType() == TileType.WALL) {
                    BufferedImage img = null;
                    JPanel test = new JPanel();
                    try {
                        InputStream is = getClass().getResourceAsStream("/rpeg/Textures/WallTile.gif");
                        img = ImageIO.read(is);
                        ig2.drawImage(img, i * 40, j * 40, test);
                    } catch (IOException ex) {
                        Logger.getLogger(WorldMap.class.getName()).log(Level.SEVERE, null, ex);
                    }
                   // ig2.drawImage("");

                }
            }
        }
        File mapFile = new File("map.png");
        ImageIO.write(bi, "PNG", mapFile);
    }
    
    public void addMob(MapMob m, int posX, int posY){
        mobs.add(m);
       // m.setPosition(posX, posY);
    }

}
