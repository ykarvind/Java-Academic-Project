
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Arvind
 */
public class Maze {
    static int MaxMazeRow = 20;
    static int MaxMazeColumn = 50;
    public static char[][] maze;
    BufferedReader CurrentLine;
    Maze(String fileName)
    {
        createMaze(fileName);
        this.maze = maze;
    }
    public void createMaze(String fileName)
    {
        File mazeTemplate = new File(fileName);
        maze = new char[MaxMazeRow][MaxMazeColumn];
        try 
        {
            FileReader read = new FileReader(mazeTemplate);
            CurrentLine = new BufferedReader(read);
        }
        catch (FileNotFoundException NoMaze)
        {
            System.out.println("Please input a maze");
            System.exit(0);
        }
        try 
        {
            for (int i = 0; i < MaxMazeRow; i++)
            {
                String row = CurrentLine.readLine();
                for (int j = 0; j < MaxMazeColumn; j++)
                {
                    maze[i][j] = row.charAt(j);
                }
            }
        }
        catch (IOException e)
        {
            e.printStackTrace(System.out);
        }

        
    }
    
    public static Boolean available(int row, int column)
    {
        if (row > MaxMazeRow - 1 || row < 0)
        {
            System.out.println("Invalid row entry");
            System.exit(0);
        }
        if (column > MaxMazeColumn -1 || column < 0)
        {
            System.out.println("Invalid column entry");
            System.exit(0);
        }
        char spot = maze[row][column];
        if(spot == ' ')
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public static void display()
    {
        for(int i = 0; i < MaxMazeRow; i++)
        {
            String line = "";
            for(int j = 0; j < MaxMazeColumn; j++)
            {
                line += maze[i][j];
            }
            System.out.println(line);
        }
       System.out.println();
    }
    
}
   


