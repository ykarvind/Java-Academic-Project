
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
public class HungrySquirrel {
    public static void main (String[] args){
     
        Maze maze1 = new Maze("Maze.txt");
        Maze.display();
        Squirrel squirrel;
        while(true)
        {
            try
            {
                squirrel = new Squirrel();
                break;
            }
            catch (InputMismatchException m)
            {
               System.out.println("Only integers can be accepted as coordinates."
                       + "Please input integer value.");
            }
        }
        Nuts[] nuts = new Nuts[5];
        for(int i = 0; i < 5; i ++)
        {
            double random = Math.random();
            if (random < 0.5)
            {
               nuts[i] = new Almond();
            }
            else
            {
                nuts[i] = new Peanut();
            }
            nuts[i].create();
            //maze1.display();
        }
        PoisonousCashew[] poison = new PoisonousCashew[5];
        for (int i = 0; i < 5; i++)
        {
            poison[i] = new PoisonousCashew();
            poison[i].create();
        }
        System.out.println("Welcome to the Hungry Squirrel Game. "
                + "Enter the commands u, d, l, r, to move Up, Down,Left,Right");
        maze1.display();
        Scanner Direction = new Scanner(System.in);
        while(!Direction.hasNext("true"))
        {
            if (Direction.hasNext("u"))
            {
                squirrel.moveUp();
                maze1.display();
                Direction.next();
            }
            else if (Direction.hasNext("d"))
            {
                squirrel.moveDown();
                maze1.display();
                Direction.next();
            }
            else if (Direction.hasNext("l"))
            {
                squirrel.moveLeft();
                maze1.display();
                Direction.next();
            }
            else if (Direction.hasNext("r"))
            {
                squirrel.moveRight();
                maze1.display();
                Direction.next();             
            }
            else
            {
                Direction.next();
            }
            if (squirrel.pointsCollected < 0)
            {
                System.exit(0);
            }
            if (squirrel.totalNutsEaten== 5)
            {
                System.out.println("Score: Squirrel " + squirrel.Checkpoints());
                    if (squirrel.totalNutsEaten > 2)
                {    
                    System.out.println("Squirrel collected nuts! Total points " 
                            + squirrel.pointsCollected 
                            +"\nThank you for playing this game");
                    System.exit(0);
                }
          
            }
        }
    }
}


    

