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
public class Player implements MapMob, Combatant{
    private int xCoord;
    private int yCoord;
    private Direction direction;
    private int atk = 3;
    private int def = 3;
    private int speed = 2;
    private int currentHealth = 10;
    private int baseHealth = 10;
    private int level = 1;

 
    public boolean move() {
        if(direction == Direction.SOUTH){
            moveTo(getX(),getY()+1);
        }
        if(direction == Direction.NORTH){
            moveTo(getX(),getY()-1);
        }
        if(direction == Direction.EAST){
            moveTo(getX()+1,getY());
        }
        if(direction == Direction.WEST){
            moveTo(getX()-1,getY());
        }
        return true;
    }


    public void turnTowards(Direction d) {
        direction = d;
    }


    public int getX() {
        return xCoord;
    }


    public int getY() {
        return yCoord;
    }


    public boolean moveTo(int x, int y) {
        this.xCoord = x;
        this.yCoord = y;
        return true;
    }


    public boolean transversable() {
        return false;
    }

    public boolean deleteThis() {
        return false;
    }


    public void destroy() {
        //Game over?
    }


    public void interact() {
        
    }

    public void get() {
    }

    public Direction getDirection(){
        return direction;
    }


    public void despawn() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    public void setPosition(int x, int y){
        xCoord = x;
        yCoord = y;
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
    public void levelUp(){
        atk += 2;
        def += 2;
        speed += 2;
        baseHealth += 5;
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

//public void attack(int atk, int def);
