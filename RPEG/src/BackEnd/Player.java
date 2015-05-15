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
    
    @Override
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

    @Override
    public void turnTowards(Direction d) {
        direction = d;
    }

    @Override
    public int getX() {
        return xCoord;
    }

    @Override
    public int getY() {
        return yCoord;
    }

    @Override
    public boolean moveTo(int x, int y) {
        this.xCoord = x;
        this.yCoord = y;
        return true;
    }

    @Override
    public boolean transversable() {
        return false;
    }

    @Override
    public boolean deleteThis() {
        return false;
    }

    @Override
    public void destroy() {
        //Game over?
    }

    @Override
    public void interact() {
        
    }

    @Override
    public void get() {
    }
    
    @Override
    public Direction getDirection(){
        return direction;
    }

    @Override
    public void despawn() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setPosition(int x, int y){
        xCoord = x;
        yCoord = y;
    }
}
