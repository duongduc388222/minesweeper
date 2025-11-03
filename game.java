/**
 * Descriptive paragraph: 
 * 
 * This is the Game Loop for the interactive option. 
 * It will prompt the user to play the game, starting by
 * letting the user choose the dimensions and the amount 
 * of mines, and also let them successively choose their move
 * to play. This file also have many error handlings implementations
 * like not allowing more mines than cells or out-of-index moves. We prompt
 * the user to choose again if these were to happen
 * 
 * A more descriptive paragraph of the overall features will be in
 * Main.java
 *
 * 
 * 
 * @author Leul, Duc, Hassan
 * Date: Sunday, Nov. 2, 2025
 * 
 */

import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Welcome to MINESWEEPER THE GAME made by Duc, Leul, and Hassan!");
        System.out.println("Please kindly provide the dimension of our Minesweeper grid.\n");

        // Ask for rows, columns, and mines
        System.out.print("Enter number of rows: ");
        int rows = scanner.nextInt();

        System.out.print("Enter number of columns: ");
        int cols = scanner.nextInt();

        int mines;
        int totalCells = rows * cols;

        // Validate input for mines - keep prompting until valid
        while (true) {
            System.out.print("Enter number of mines: ");
            mines = scanner.nextInt();

            if (mines >= totalCells) {
                System.out.println("Error: Number of mines must be less than total cells (" + totalCells + ")!");
                System.out.println("Please try again.");
            } else if (mines < 0) {
                System.out.println("Error: Number of mines cannot be negative!");
                System.out.println("Please try again.");
            } else {
                break;
            }
        }

        // Initialize the game board
        Board board = new Board(rows, cols, mines);
        int totalMines = board.getMines();

        System.out.println("\nGame started! Good luck!");
        System.out.println("Note: Rows and columns are 1-indexed for user input.\n");

        // Game loop
        boolean gameOver = false;

        while (!gameOver) {
            // Count visited cells and report status BEFORE displaying board
            int numVisited = board.countVisited();
            int remainingCells = totalCells - numVisited - totalMines;
            System.out.println("\nCurrent situation: There are still " + remainingCells + " free positions.");

            // Display the board
            board.displayBoard();

            // Prompt user for move
            System.out.print("\nEnter row (1-" + rows + "): ");
            int inputRow = scanner.nextInt();

            System.out.print("Enter column (1-" + cols + "): ");
            int inputCol = scanner.nextInt();

            // Convert to 0-indexed
            int row = inputRow - 1;
            int col = inputCol - 1;

            // Validate the input
            if (!board.isValidPosition(row, col)) {
                System.out.println("Invalid position! Please try again.");
                continue;
            }

            // Check if already visited
            if (board.getVistedMatrix()[row][col]) {
                System.out.println("Cell already visited! Please choose another cell.");
                continue;
            }

            // Check the cell
            boolean hitMine = board.checkCells(row, col);

            if (hitMine) {
                // Game over as you have hit a mine
                System.out.println("\nBOOMMMMMMM! You hit a mine!");
                System.out.println("\nHere's the full board:");
                board.displayFullBoard();
                System.out.println("\nGame Over! You lose!");
                gameOver = true;
            } else {
                // Update visited cells count
                numVisited = board.countVisited();

                // Check win condition
                if (numVisited == totalCells - totalMines) {
                    System.out.println("\nCongratulations! You've cleared all safe cells!");
                    System.out.println("\nHere's the full board:");
                    board.displayFullBoard();
                    System.out.println("\nYou Win!");
                    gameOver = true;
                }
            }
        }

        scanner.close();
    }
}
