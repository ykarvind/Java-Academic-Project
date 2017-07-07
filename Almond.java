/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Arvind
 */
public class Almond extends Nuts
{
    Almond()
    {
        NutritionPoints = 5;        
    }
    
    @Override
    public char getSymbol()
    {
        symbol = 'A';
        return symbol;
    }
}

