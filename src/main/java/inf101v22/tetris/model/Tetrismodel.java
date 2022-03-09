package inf101v22.tetris.model;

import java.awt.Color;
import java.util.List;

import inf101v22.grid.Coordinate;
import inf101v22.grid.CoordinateItem;
import inf101v22.tetris.view.TetrisViewable;

public class Tetrismodel implements TetrisViewable  {

    Tetrisboard tetrisboard;

    public Tetrismodel( Tetrisboard tetrisboard) {

        this.tetrisboard = tetrisboard;

        // coloring of the corners of the board, will remove later...
        this.tetrisboard.set(new Coordinate(0,0), new Tile (Color.GREEN, 'g'));
        this.tetrisboard.set(new Coordinate(0,this.tetrisboard.getCols()-1), new Tile (Color.YELLOW, 'y'));
        this.tetrisboard.set(new Coordinate(this.tetrisboard.getRows()-1, 0), new Tile (Color.RED, 'r'));
        this.tetrisboard.set(new Coordinate(this.tetrisboard.getRows()-1, this.tetrisboard.getCols()-1), new Tile (Color.BLUE, 'b'));
    }

    @Override // lag test
    public int numRows() {
        return tetrisboard.getRows();
    }

    @Override // lag test
    public int numColumns() {
        return tetrisboard.getCols();
    }

    @Override
    public Iterable<CoordinateItem<Tile>> tileCoordinates() {
        return tetrisboard;

    }
    
}
