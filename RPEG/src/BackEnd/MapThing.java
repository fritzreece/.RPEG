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
public interface MapThing {
    int getX();
    int getY();
    void moveTo(int x, int y);
    boolean transversable();
    boolean deleteThis();
    void destroy();
    void interact();
    void get();
}
