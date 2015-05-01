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
    private MapTile[] tiles;
    public final int width;
    public final int height;
    public final File background;
    public WorldMap(int dim1, int dim2, File bg){
        width = dim1;
        height = dim2;
        background = bg;
        tiles = new MapTile[dim1*dim2];
        for (int i=0;i<dim2;i++){
            for(int j=0;j<dim1;j++){
                //World tiles are stored in this order: left to right, then down a row
                tiles[i+j] = new MapTile(j,i,TileType.GRASS);
            }
        }
    }
}
