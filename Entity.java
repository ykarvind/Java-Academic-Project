/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Arvind
 */
public abstract class Entity implements MovableInterface
{
    char symbol;
    int x;
    int y;
    
    public char move(int x1, int y1, int x2, int y2, char s)
    {
        char t = Maze.maze[y2][x2];
        if (Maze.maze[y1][x1] == s)
        {
            if (Maze.maze[y2][x2] !='*')
            {
                 x = x2;
                 y = y2;
                 Maze.maze[y1][x1] = ' ';
                 Maze.maze[y2][x2] = s;
            }
        }
        else 
        {
           // System.out.println("That symbol is not at this spot.");
        }
        return t;
    }
    abstract public char getSymbol();
    abstract public void create();
        
}

