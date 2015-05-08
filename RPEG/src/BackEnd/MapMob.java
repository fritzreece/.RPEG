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
public interface MapMob {
    public void moveTo();
    public void turnToward();
    public URL getSprite();
    public void despawn();
}
