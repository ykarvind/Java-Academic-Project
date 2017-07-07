/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Arvind
 */
public abstract class Nuts extends Entity
{
    final int totalNuts = 5;
    static int NutritionPoints;
    
    int isNuts(char symbol)
    {
        if (symbol == 'P' || symbol == 'A')
        {
            return NutritionPoints;
        }
        else
        {
            return 0;
        }        
    }
    
    @Override
    public void create()
    {
        int xvalue = (int)(Math.random() * 50);
        int yvalue = (int)(Math.random() * 20);
        while (Maze.maze[yvalue][xvalue] != ' ')
        {
             xvalue = (int)(Math.random() * 50);
             yvalue = (int)(Math.random() * 20);
        }
        x = xvalue;
        y = yvalue;
        Maze.maze[y][x] = getSymbol();
    }

}


