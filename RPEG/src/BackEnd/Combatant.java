/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd;

/**
 *
 * @author jwsti_000
 */
public interface Combatant {
    
    public void attack(int atk, int def);
    
    public void levelUp();
    
    public int getAtk();
    
    public int getDef();
    
    public int getSpeed();
    
    public int getHealth();
    
}
