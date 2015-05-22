/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd;

/**
 *
 * @author csstudent
 */
public class MapTile {
    public final int xCoord;
    public final int yCoord;
    private TileType tileType;
    public MapTile(int xCoord, int yCoord, TileType t, WorldMap w){
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        tileType = t;
    }
    public TileType getTileType() {
        return this.tileType;
    }
    public void setTileType(TileType t) {
        tileType = t;
    }
    
    
}
