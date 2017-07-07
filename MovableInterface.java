/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Arvind
 */
public interface MovableInterface {
    abstract void create();
    
    abstract char move(int x1, int y1, int x2, int y2, char s);
    
    abstract char getSymbol();
}
