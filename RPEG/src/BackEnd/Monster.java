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
public class Monster implements MapMob{
    int ypos;
    int xpos;
    public Monster(int xpos, int ypos) {
        this.ypos = ypos;
        this.xpos = xpos;
    }
    public int getX() {
        return xpos;
    }
    public int getY() {
        return ypos;
    }
    @Override
    public void moveTo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void turnToward() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public URL getSprite() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void despawn() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
