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
public class Boulder implements MapThing{
    private int xCoord;
    private int yCoord;
    private boolean deleteThis = false;
    public Boulder(int x, int y){
        xCoord = x;
        yCoord = y;
    }
    public boolean transversable(){
        return false;
    }
    public void interact(){
        System.out.println("It's a rock.");
    }
    @Override
    public int getX(){
        return xCoord;
    }
    @Override
    public int getY(){
        return yCoord;
    }
    @Override
    public void moveTo(int x, int y) {
        destroy();
        
    }

    @Override
    public void destroy() {
        deleteThis = true;
    }
    @Override
    public boolean deleteThis(){
        return deleteThis;
    }
    @Override
    public void get() {
        System.out.println("You can't pick it up, ya doof.");
    }
}
