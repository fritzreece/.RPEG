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
public class Monster implements MapMob, Combatant{
    int ypos;
    int xpos;
    private int atk = 1;
    private int def = 1;
    private int speed = 1;
    private int baseHealth = 3;
    private int currentHealth = 3;
    private int level = 1;
    
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
    
    @Override
    public void levelUp(){
        atk += 1;
        def += 1;
        speed += 1;
        baseHealth += 3;
        level += 1;
    }
    
    @Override
    public int getHealth(){
        return currentHealth;
    }
    
    @Override
    public int getAtk(){
        return atk;
    }
    
    @Override
    public int getDef(){
        return def;
    }
    
    @Override
    public int getSpeed(){
        return speed;
    }
    
    @Override
    public void attack(int ATK, int DEF){
        
    }
    
}
