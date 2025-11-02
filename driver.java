<<<<<<< HEAD
/**
 * @author Leul, Duc, Hassan
 * @date Sunday, Nov. 2, 2025
 This is the driver class that tests how the Minesweeper game works
 It runs three test cases to show how a Minesweeper game behaves:
   Test Case 1: A small 3x3 board where you lose by hitting a mine.
   Test Case 2: A small 3x3 board where you win by opening all safe cells.
   Test Case 3: A larger 5x5 board that ends when a mine is clicked.
*/
public class driver {
=======
public class Driver {
>>>>>>> aa8c8bdaf331e1d5a10a200930af4f21fcb288b4

    public static void main(String[] args) {
        System.out.println("driver test\n");
        
        testCase1();
        testCase2();
        testCase3();
    }


    /**
     * Test Case 1:
     * Creates a 3x3 board with 2 mines.
     * It opens a few cells and ends up clicking a mine so you lose the game
     */
    public static void testCase1() {
        System.out.println("\n A 3*3 board with 2 Mines\n");

        int[][] arr1 = {
            {0,1,-1},
            {1,2,2},
            {1,-1,1}
        };

        Board board = new Board(arr1);

        System.out.println("Displaying the initial board");
        board.displayBoard();

        System.out.println("\nOpening (2, 2):");
        board.checkCells(2, 2);
        board.displayBoard();
        
        System.out.println("\nOpening (0, 2) : This hits the mine:");
        boolean hit = board.checkCells(0, 2);
        System.out.println("Hit mine: " + hit);
        board.displayFullBoard();

        System.out.println("\nYou Lose! . You Clicked on a mine");
    }


     /**
     * Test Case 2:
     * Another 3x3 board with 2 mines.
     * This time, all the safe cells are opened successfully so you win
     */
    public static void testCase2() {
        System.out.println("\n  3x3 Board with 2 Mines- winning in this scenario\n");
        
        int[][] test2 = {
            {0, 0, 0},
            {1, 2, 1},
            {-1, 2, -1}
        };
        
        Board board = new Board(test2);
        
        System.out.println("initial board");
        board.displayFullBoard();
        
        System.out.println("\nOpening (0, 0)");
        board.checkCells(0, 0);
        board.displayBoard();
        
        System.out.println("\nOpening (2, 1) : this is the last safe cell:");
        board.checkCells(2, 1);
        board.displayBoard();
        
        System.out.println("\nYou Win! All safe cells opened!");
    }

    /**
     * Test Case 3:
     * A 5x5 board with 4 mines.
     * Shows opening several safe cells and then hitting a mine at the end.
     */
    public static void testCase3() {
        System.out.println("\n\nTEST CASE 3: 5x5 Board with 4 Mines\n");
        
        int[][] test3 = {
            {-1, 1, 0, 0, 0},
            {1, 1, 0, 1, 1},
            {0, 0, 1, 2, -1},
            {0, 0, 1, -1, 3},
            {0, 0, 1, 2, -1}
        };
        
        Board board = new Board(test3);
        
        System.out.println("initial board");
        board.displayFullBoard();
        
        
        System.out.println("\nOpening (4, 0):");
        board.checkCells(4, 0);
        board.displayBoard();
        
        System.out.println("\nOpening (2, 3):");
        board.checkCells(2, 3);
        board.displayBoard();
        
        System.out.println("\nOpening (3, 3) - hits mine:");
        boolean hit = board.checkCells(3, 3);
        System.out.println("Hit mine: " + hit);
        board.displayFullBoard();

         System.out.println("\nYou Lose! . You Clicked on a mine");
    }
}


    

    




    


    

    



        

    

    
    
    


