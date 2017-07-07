/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Arvind
 */
public class Peanut extends Nuts
{
    Peanut()
    {
        NutritionPoints = 10;        
    }
    
    @Override
    public char getSymbol()
    {
        symbol = 'P';
        return symbol;
    }
 
}
