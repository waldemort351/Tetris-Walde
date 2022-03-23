package inf101v22.tetris.model;

import inf101v22.grid.Coordinate;
import inf101v22.grid.Grid;

/**
 * Objects of this class represents a board of tiles.
 */


public class TetrisBoard extends Grid<Tile>  {

    public TetrisBoard(int row, int col, Tile defaultValue) {
        super(row, col, defaultValue);
        //TODO Auto-generated constructor stub
    }

    public TetrisBoard(int row, int col) {
        super(row,col);
    }
    
    /**
     * Checks the value of the tile in the board 
     * @return a char that represents the color if filled, or '-' if empty.
     */
    public char[][] toCharArray2d() {
        char[][] board = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (this.get(new Coordinate(i,j)) != null) {
                    board[i][j] = this.get(new Coordinate(i,j)).character;
                } else {
                    board[i][j] = '-';
                }
                
            } 
        }
        return board;
    }

    /**
     * 
     * @param twoDimArray A two-dimensional array with char-values.
     * @return A string where the symbols in each row is joined.
     */
    public String charArray2dToString(char[][] twoDimArray) {
        String toString = "";
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                toString += twoDimArray[i][j];
            } 
            toString += "\n";
        } 
        return toString;
    } 
        
    private boolean elemExistsOnBoard(TetrisBoard value, int elem) {
        if ()
    }
    
    private void fillRow(TetrisBoard value, int elem) {
        
    }

    private void copyElemToAnotherRow(int first, int copyToSecond) {

    }



    /**
     * 
     * @return The number of removed rows.
     */
    public int removeFullRows() {
        int a = this.getRows() - 1;
        int b = this.getRows() - 2;
        int numOfRejectedRows = 0;


        while (a > 0) {
            while (elemExistsOnBoard(null, b)) {
                numOfRejectedRows += 1;
                b -= 1;    
            }
        } if (elemExistsOnBoard(null, b)) {
            copyElemToAnotherRow(b,a);
        } 
        else {
            fillRow(null, a);
            a -= 1;
            b -= 1;
            }
            return numOfRejectedRows;
        } 
    }


