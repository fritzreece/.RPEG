/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd;
import java.net.URL;
/**
 *
 * @author csstudent
 */
public interface MapMob extends MapThing{
    public void turnTowards(Direction d);
    public void despawn();
    public Direction getDirection();
    public boolean move();
    //Can fail under certain conditions
    public boolean moveTo(int x, int y);
}
