
import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Arvind
 */
public class Squirrel extends Entity
{
    int pointsCollected;
    int totalNutsEaten;
    int spaces;
    int checkval;
    Squirrel()
    {    
        
        pointsCollected = 0;
        totalNutsEaten = 0;
        spaces = 1;
        getSymbol();
        create();
    }
    
    @Override
    public void create()
    {
        try
        {
        System.out.println("Enter the squirrel position:(column,row)");
        Scanner inputValue = new Scanner(System.in);
        System.out.print("x = ");
        x = inputValue.nextInt();
        while (x < 0 || x > Maze.MaxMazeColumn - 1)
        {
            System.out.println("That x is out of bounds.  ");
            System.out.print("x = ");
            x = inputValue.nextInt();
        }
        System.out.print("y = ");
        y = inputValue.nextInt();
        while(y < 0 || y > Maze.MaxMazeRow -1)
        {
            System.out.println("Y is out of bounds.  "
                    + "Please enter an integer from 0 to 19.");
            System.out.print("y = ");
            y = inputValue.nextInt();
        }
        while (Maze.available(y,x) == false)
        {
            System.out.println("Position is not available");
            System.out.println("Enter the squirrel position");
            System.out.print("x = ");
            x = inputValue.nextInt();
            while (x < 0 || x > Maze.MaxMazeColumn - 1)
            {
                System.out.println("X is out of bounds..");
                System.out.print("x = ");
                x = inputValue.nextInt();
            }
            System.out.print("y = ");
            inputValue = new Scanner(System.in);
            y = inputValue.nextInt();
            while(y < 0 || y > Maze.MaxMazeRow -1)
            {
                System.out.println("Y is out of bounds.  ");
                System.out.print("y = ");
                y = inputValue.nextInt();
            }
        }
        }
        catch (InputMismatchException e)
        {
            throw e;
        }
        System.out.println ("User input accepted.");
        Maze.maze[y][x] = '@';
        Maze.display();
    }
    @Override
    public char getSymbol()
    {
        symbol = '@';
        return symbol;
    }
      
    void moveLeft()
    {
        for (int i = 0; i < spaces; i++)
        {
            switch (Maze.maze[y][x-1]) {
                case 'A':
                    almond();
                    i = spaces - 1;
                    break;
                case 'P':
                    peanut();
                    i = spaces - 1;
                    break;
                case 'C':
                    i = 0;
                    poisonousCashew();
                    break;
                default:                
                    break;
            }
            if (pointsCollected < 0)
            {
                deadSquirrel();
                move(x, y, x - 1, y, 'X');
                break;
            }
            move(x, y, x - 1, y, getSymbol());
        }
    }
    
    void moveRight()
    {
        for (int i = 0; i < spaces; i++)
        {
            switch (Maze.maze[y][x+1]) {
                case 'A':
                    almond();
                    i = spaces - 1;
                    break;
                case 'P':
                    peanut();
                    i = spaces - 1;
                    break;
                case 'C':
                    i = 0;
                    poisonousCashew();
                    break;
                default:
                    break;
            }
            if (pointsCollected < 0)
            {
                deadSquirrel();
                move(x, y, x + 1, y, 'X');
                break;
            }         
            move(x, y, x + 1, y, getSymbol());
        }
    }
    
    void moveUp()
    {
        for (int i = 0; i < spaces; i++)
        {
            switch (Maze.maze[y-1][x])
            {
                case 'A':
                    almond();
                    i = spaces - 1;
                    break;
                case 'P':
                    peanut();
                    i = spaces - 1;
                    break;
                case 'C':
                    i = 0;
                    poisonousCashew();
                    break;
                default:
                    break;
            }
            if (pointsCollected < 0)
            {
                deadSquirrel();
                move(x, y, x, y - 1, 'X');
                break;
            }
        move(x, y, x, y - 1, getSymbol());
        }
    }
    
    void moveDown()
    {
        for (int i = 0; i < spaces; i++)
        {
            switch (Maze.maze[y+1][x]) {
                case 'A':
                    almond();
                    i = spaces - 1;
                    break;
                case 'P':
                    peanut();
                    i = spaces - 1;
                    break;
                case 'C':
                    i = 0;
                    poisonousCashew();
                    break;
                default:
                    break;
            }
            if (pointsCollected < 0)
            {
                deadSquirrel();
                move(x, y, x, y + 1, 'X');
                break;
            }
        move(x, y, x, y + 1, getSymbol());
        }
    }
    
    public String Checkpoints()
    {
        return "(Total Points: " + pointsCollected + ", Total Nuts: " + totalNutsEaten + 
                ", Spaces: " + spaces + ")";
    }  
        
    public void almond()
    {
        pointsCollected += 5;
        totalNutsEaten += 1;
        almondMessage();
    }
    
    public void peanut()
    {
        pointsCollected += 10;
        totalNutsEaten += 1;
        spaces= 1;
        peanutMessage();
    }
    
    public void poisonousCashew()
    {
        pointsCollected -= 15;
        spaces= 1;
        poisonousCashewMessage();
    }
    public void deadSquirrel()
    {
        if(pointsCollected < 0)
        {
        Maze.maze[y][x] = ' ';
        }
        deadSquirrelMessage();
    }
    public void almondMessage()
    {
        System.out.println("!!!Squirrel ate an Almond and got 5 points " + Checkpoints() + "!!!");
       
    }
    
    public void peanutMessage()
    {
        System.out.println("!!!Squirrel ate a Peanut and got 10 points" 
                + Checkpoints() + "!!!");
    }
    
    public void poisonousCashewMessage()
    {
        checkval = 1;
        System.out.println("!!!Squirrel ate a Poisonous Cashew. Lose 15 points "
               + Checkpoints());
    }
    
    public void deadSquirrelMessage()
    {
        checkval = 1;
        System.out.println("Squirrel is dead. Game Over");
        System.exit(0);
    }
}
