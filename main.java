/**
 * Descriptive paragraph: 
 * 
 * The Main class for our Minesweeper game.
 * It asks user which mode of the game they want to run
 * and based on that it either calls the driver to runs tests
 * or the game to play an interactive version
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
