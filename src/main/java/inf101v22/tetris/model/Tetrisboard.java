package inf101v22.tetris.model;

import java.util.Objects;

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
        
    private boolean elemExistsOnBoard(int row, Tile elem) {
        for (int i = 0; i < getCols(); i++) {
            Coordinate coordinate = new Coordinate(row, i);
            if (Objects.equals(get(coordinate), elem)) {
                return true;
            }
        } return false;
        
    }   
    
    private void fillRow(int row, Tile elem) {
        for (int i = 0; i < getCols(); i++) {
            Coordinate coordinate = new Coordinate(row, i);
            set(coordinate, elem);
        }   
    }   
    

    private void copyElemToAnotherRow(int first, int copyToSecond) {
        for (int i = 0; i < getCols(); i++) {
            Coordinate firCoordinate = new Coordinate(first, i);
            Coordinate secCoordinate = new Coordinate(copyToSecond, i);
            set(secCoordinate, get(firCoordinate));
        }
    }



    /**
     * 
     * @return The number of removed rows.
     */
    public int removeFullRows() {
        int a = this.getRows() - 1;
        int b = this.getRows() - 1;
        int numOfRejectedRows = 0;


        while (a > 0) {
            while (b >= 0 && !elemExistsOnBoard(b, null)) {
                numOfRejectedRows += 1;
                b -= 1;    
            }
         if (b > 0 && b < getRows()) { 
            copyElemToAnotherRow(b,a);
        } 
        else {
            fillRow(a, null);
            } 
            a -= 1;
            b -= 1;
        } 
            return numOfRejectedRows;
        } 
    }


