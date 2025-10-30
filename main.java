public class Main {
    public static void main(String[] args) {

        int [][] test1 = {{0, 2, -1, -1, 1},
                          {0, 2, -1, 3, 1},
                          {0, 1, 1, 1, 0},
                          {0, 0, 0, 0, 0}};

        Board testBoard1 = new Board(test1);

        testBoard1.displayBoard();
        testBoard1.checkCells(0, 2);
        testBoard1.displayBoard();
        
    }
}
