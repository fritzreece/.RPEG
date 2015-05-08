/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd;
import java.io.File;
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
        tiles = new MapTile[dim1][dim2];
        for(int j=0;j<tiles.length;j++){
            MapTile[] mt = tiles[j];
            for(int i=0;i<mt.length;i++){
                mt[i] = new MapTile(i,j,TileType.GRASS,this);
            }
        }
    }
    //returns true if it succeeds
    public boolean addThing(MapThing thing, int x, int y){
        return tiles[y][x].add(thing);
    }
    public MapTile getTile(int x, int y){
        return tiles[y][x];
    }
}
