/**
 * Descriptive paragraph: 
 * 
 * This is the Main class for our Minesweeper game.
 * It asks user which mode of the game they want to run
 * and based on that it either calls the driver to runs tests
 * or the game to play an interactive version.
 * 
 *  - In the Driver, we test 3 simple cases for correctness.
 *  - In the Interactive version, players can actually play the game 
 *    for themselves. There are error handling for cases like out of index
 *    or too many mines and etc. All of these will prompt the user to try
 *    again.
 * 
 * Features: 
 * - The users can define the dimension of the game's matrix and choose
 *   how many mines to be placed inside of them.
 * - The program will randomly place those mines randomly, and do a full
 *   check to fill out the numbers in the cell in accordance to Minesweeper's
 *   rules. Numbers in the cells represent how many mines that are adjencent to 
 *   that cell in all 8 direction.
 * - A closed cell is indicated by an asterisk * and opened cells are either 
 *   numbers, representing the number of mines closed to them or mines, 
 *   indicated by #.
 * - Cells that are 0s if picked will automatically opens cells adjacent
 *   to them. If many cells will 0s are next to each other, they will
 *   recursively open.
 * - A game loop that will prompt the users to input their choices successively,
 *   prompt the user to input again for any error (out-of-index, too many mines 
 *   than cells, etc). We also help the user to keep track their progress by 
 *   prompting how many open cells (cells that are not mines) every single time.
 *   When the game ends (win or lose), the whole grid will be revealed. 
 *   
 * 
 * @author Leul, Duc, Hassan
 * Date: Sunday, Nov. 2, 2025
 * 
 * Reference:
 * - Java Documentation norm: https://www.oracle.com/technical-resources/articles/java/javadoc-tool.html#format
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    // We loop so as to repeatedly as the user for the correct input
    // in their choice. Once we get it the, we get out of the
    // loop and go to the game.

    while (true) {

        System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ ");
        System.out.println();
        System.out.println("Welcome to our Main Menu!");
        System.out.println();
        

        System.out.println("Please choose the mode you want to run.");
        System.out.println();
        System.out.println("Press 1 for interactive mode to play the game.");
        System.out.println("Press 2 for Driver mode to test the game.");
        System.out.println();
        System.out.print("Enter your choice: ");
        

        int userChoice;
        

        // Handling the case where the input from the user may not be a number.
        try 
        {   
           userChoice = scanner.nextInt();
        }

        catch (InputMismatchException e) 
        {   
            System.out.println();
            System.err.println("Error: Only enter numbers!");
            scanner.nextLine();
            continue;
        }

        if (userChoice == 1) {
            Game.main(args);
            break;
        } else if (userChoice == 2) {
            Driver.main(args);
            break;
        } else {
            System.out.println();
            System.out.println("Error: Choice can be either 1 or 2");
            System.out.println();
        }
            
    }
    scanner.close();
    }
}
