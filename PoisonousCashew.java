/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Arvind
 */
public class PoisonousCashew extends Nuts
{
    PoisonousCashew()
    {
       NutritionPoints = -15;
       
    }

    @Override
    public char getSymbol()
    {
        symbol = 'C';
        return symbol;
    }
    
}
