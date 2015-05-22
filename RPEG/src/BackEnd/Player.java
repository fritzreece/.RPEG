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
public class Player implements MapMob{
    private int xCoord;
    private int yCoord;
    private Direction direction;
    
 
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
}
