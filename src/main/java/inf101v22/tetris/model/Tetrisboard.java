package inf101v22.tetris.model;

import inf101v22.grid.Coordinate;
import inf101v22.grid.Grid;

// dobbeltsjekk om konstruktøren skal holde på det siste parameteret

/**
 * Objects of this class represents a board of tiles.
 */


public class Tetrisboard extends Grid<Tile>  {

    public Tetrisboard(int row, int col, Tile defaultValue) {
        super(row, col, defaultValue);
        //TODO Auto-generated constructor stub
    }

    public Tetrisboard(int row, int col) {
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
        
    }


