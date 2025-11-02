public class driver {

    public static void main(String[] args) {
        System.out.println("MINESWEEPER TEST DRIVER\n");
        
        testCase1();
        
        
    }

    public static void testCase1() {
        System.out.println("\n A 3*3 board with 2 Mines\n");

        int[][] arr1 = {
            {0,1,-1},
            {1,2,1},
            {1,-1,1}
        };

        Board board = new Board(arr1);
        System.out.println("Displaying the board");

        System.out.println("\nOpening (2, 2):");
        board.checkCells(2, 2);
        board.displayBoard();
        
        System.out.println("\nOpening (0, 2) - hits mine:");
        boolean hit = board.checkCells(0, 2);
        System.out.println("Hit mine: " + hit);
        board.displayFullBoard();
    }
}

    


    

    



        

    

    
    
    


