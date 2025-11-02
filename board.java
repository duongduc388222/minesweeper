/**
 * Descriptive paragraph: 
 * 
 * The game board class for our Minesweeper game.
 * Manages the game matrix containing mines and adjacent mine counts,
 * and tracks which cells have been visited by the player.
 * 
 * @author Leul, Duc, Hassan
 * Date: Sunday, Nov. 2, 2025
 * 
 */


public class Board {

    // A bolean matrix the will be true if a cell has been visited and false otherwise.
    private boolean[][] visitedMatrix;
    private int[][] gameMatrix;
    private int rows;
    private int mines;
    private int cols;


    /**
     * A Contructor to make a Board with specified rows, cols, and number of mines.
     * Initializes both game and visited matrices, then calls initMatrix()
     * to randomly place mines and calculate adjacent mine counts.
     * 
     * @param rows the number of rows
     * @param cols the number of columns
     * @param mines the number of mines
     */

    public Board(int rows, int cols, int mines){
        this.rows = rows;
        this.cols = cols;
        this.mines = mines;
        this.gameMatrix = new int[rows][cols];
        this.visitedMatrix = new boolean[rows][cols];
        initMatrix();

    }

    public Board(int[][] test){
        this.gameMatrix = test;
        this.rows = test.length;
        this.cols = test[0].length;
        this.visitedMatrix = new boolean[rows][cols];
    }


    /**
     * Randomly places the mines in our matrix and ensures there aren't mines
     * in the same position.
     * Calculates the number of adjacent mines and fills the game matrix.
     */

    public void initMatrix(){
        // Randomly place mines
        int minesPlaced = 0;
        java.util.Random random = new java.util.Random();

        while (minesPlaced < mines) {
            int randRow = random.nextInt(rows);
            int randCol = random.nextInt(cols);

            // Check if this position doesn't already have a mine
            if (gameMatrix[randRow][randCol] != -1) {
                gameMatrix[randRow][randCol] = -1;
                minesPlaced++;
            }
        }

        // Calculate adjacent mine counts for all non-mine cells
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (gameMatrix[i][j] != -1) {
                    gameMatrix[i][j] = countAdjacentMines(i, j);
                }
            }
        }
    }

    /**
     * Counts the number of mines adjacent to a specified cell.
     * Checks all 8 surrounding positions as specified in the instructions.
     * 
     * @param row the row index of the cell
     * @param col the column index of the cell
     * @return the number of mines adjacent the cell (0-8)
     */

    public int countAdjacentMines(int row, int col){

        int numberOfAdjacentMines = 0;

        for (int i = -1; i <= 1; i++){
            for (int j = -1; j<=1; j++){

                if (i == 0 && j ==0){
                        continue;
                    }

                if ((isValidPosition(row + i, col + j)) && gameMatrix[row + i][col + j] == -1) {
                    numberOfAdjacentMines++;
                }

            }
        }

        return numberOfAdjacentMines;

    }


    /**
     * Checks if a given position is within the valid bounds.
     * We used the IndexOutOfBoundsException given in the instructions.
     * 
     * 
     * @param row the row index to check
     * @param col the column index to check
     * @return true if the position is valid, false otherwise
     */

    public boolean isValidPosition(int row, int col){

        try 
        {   
            // We try to access a specific value. And if we do,
            // we return true,
            int accessValue = gameMatrix[row][col]; 
            return true;

        }

        catch (IndexOutOfBoundsException e) 
        {   
            return false;
        }
    }


    /**
     * Recursively opens cells starting from a given position. If the cell contains 
     * a mine, returns true to end the game. If the cell has 0 adjacent mines, recursively 
     * opens all adjacent cells. If the cell has 1-8 adjacent mines, marks it as visited 
     * and stops.
     * 
     * @param row the row index of the cell to check
     * @param col the column index of the cell to check
     * @return true if a mine is hit (game over), false otherwise
     */

    public boolean checkCells(int row, int col){
        if (!isValidPosition(row, col)) {
            return false;
        }

        if (visitedMatrix[row][col]){
            return false;
        }

        int cellValue = gameMatrix[row][col];

        if (cellValue == -1){
            visitedMatrix[row][col] = true;
            return true;
        }

        // We add what we have to the visted matrix since we already
        // check any possible repetions or the chance of it being a mine
        // and hence the only thing left for it to be is a new addition.
        visitedMatrix[row][col] = true;

        // Base case for our method
        if (cellValue >=1 && cellValue <=8) {
            return false;
            
        }

        // Recursive case for our method.
        if (cellValue == 0) {

            for (int i = -1; i <=1; i++){
                for (int j = -1; j<=1; j++){

                    // We don't need to check the cell itself.
                
                    if (i == 0 && j ==0){
                        continue;
                    }
                    checkCells(row + i, col + j);
                }
            }
            
        }

        return false;

    }

     /**
     * Displays the current state of the game board to the user.
     */

    public void displayBoard(){

        System.out.println();

        for (int j = 0; j < cols; j++){
            System.out.print((j+1) + "c ");
        }   

        System.out.println();


         for (int i = 0; i < visitedMatrix.length; i++){

            for (int j = 0; j < visitedMatrix[i].length; j++){
                if (!visitedMatrix[i][j]) {
                    System.out.print(" * ");
                } else {

                    if (gameMatrix[i][j] == -1) {
                        System.out.print(" # ");   
                    } else {
                        System.out.print(" " + gameMatrix[i][j] + " ");

                    }
                }
            }

            System.out.println((i+1) + "L");
            }
    }


    /**
     * Displays the full game board with all cells revealed.
     * Used at the end of the game to show all mines and values.
     */
    public void displayFullBoard(){

        System.out.println();

        for (int j = 0; j < cols; j++){
            System.out.print((j+1) + "c ");
        }

        System.out.println();

        for (int i = 0; i < gameMatrix.length; i++){
            for (int j = 0; j < gameMatrix[i].length; j++){
                if (gameMatrix[i][j] == -1) {
                    System.out.print(" # ");
                } else {
                    System.out.print(" " + gameMatrix[i][j] + " ");
                }
            }
            System.out.println((i+1) + "L");
        }
    }


    /**
     * Counts the total number of cells that have been visited.
     *
     * @return the number of visited cells
     */
    public int countVisited(){

        int count = 0;

        for (int i = 0; i < visitedMatrix.length; i++){
            for (int j = 0; j < visitedMatrix[i].length; j++){
                if (visitedMatrix[i][j]){
                    count++;
                }
            }
        }
        return count;

    }


    /**
     * Returns the visited matrix showing which cells have been opened.
     * 
     * @return a 2D boolean array
     */

    public boolean[][] getVistedMatrix(){
        return visitedMatrix;
    }

    /**
     * Returns the game matrix containing mine positions and adjacent mine counts.
     * 
     * @return a 2D integer array
     */

    public int[][] getGameMatrix(){
        return gameMatrix;

    }

    /**
     * Returns the total number of mines on the board.
     * 
     * @return the number of mines
     */

    public int getMines(){
        return mines;
    }

    /**
     * Calculates and returns the total number of cells on the board.
     * 
     * @return the total number of cellss
     */

    public int getTotalCells(){
        int total = rows * cols;
        return total;

    }
    
}
