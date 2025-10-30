public class Board {

    private boolean[][] visitedMatrix;
    private int[][] gameMatrix;
    private int rows;
    private int mines;
    private int cols;

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

    public void initMatrix(){

    }

    public int countAdjacentMines(){
        return 0;

    }

    public boolean isValidPosition(int row, int col){
        boolean valid = (row >= 0 && row < rows) && (col >= 0 && col < cols);
        return valid;

    }

    public boolean checkCells(int row, int col){
        return false;

    }

    public void displayBoard(){

    }

    public int countedVisited(){
        return 0;

    }

    public boolean[][] getVistedMatrix(){
        return visitedMatrix;
    }

    public int[][] getGameMatrix(){
        return gameMatrix;

    }

    public int getMines(){
        return mines;
    }

    public int getTotalCells(){
        int total = rows * cols;
        return total;

    }
    
}
