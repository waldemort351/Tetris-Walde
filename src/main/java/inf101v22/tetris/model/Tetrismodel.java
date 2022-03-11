package inf101v22.tetris.model;

import java.awt.Color;
import java.util.List;

import inf101v22.grid.Coordinate;
import inf101v22.grid.CoordinateItem;
import inf101v22.tetris.model.piece.PositionedPiece;
import inf101v22.tetris.model.piece.PositionedPieceFactory;
import inf101v22.tetris.view.TetrisViewable;

public class TetrisModel implements TetrisViewable  {

    private TetrisBoard tetrisBoard;
    private PositionedPiece fallingPiece;
    private PositionedPieceFactory pieceFactory;

    public TetrisModel(TetrisBoard tetrisBoard) {

        this.tetrisBoard = tetrisBoard;
        // notater til steg 3-------


        // for testing purposes.
        this.tetrisBoard.set(new Coordinate(0,0), new Tile(Color.BLUE, 't'));
        this.tetrisBoard.set(new Coordinate(14,0), new Tile(Color.CYAN, 'c')); 


        this.pieceFactory = new PositionedPieceFactory(10/2);
        this.fallingPiece = pieceFactory.getNextPositionedPiece();




        // coloring of the corners of the board, will remove later...
        this.tetrisBoard.set(new Coordinate(0,0), new Tile (Color.GREEN, 'g'));
        this.tetrisBoard.set(new Coordinate(0,this.tetrisBoard.getCols()-1), new Tile (Color.YELLOW, 'y'));
        this.tetrisBoard.set(new Coordinate(this.tetrisBoard.getRows()-1, 0), new Tile (Color.RED, 'r'));
        this.tetrisBoard.set(new Coordinate(this.tetrisBoard.getRows()-1, this.tetrisBoard.getCols()-1), new Tile (Color.BLUE, 'b'));

       // System.out.println(tetrisBoard.charArray2dToString(tetrisBoard.toCharArray2d()));
    }

    @Override // lag test
    public int numRows() {
        return tetrisBoard.getRows();
    }

    @Override // lag test
    public int numColumns() {
        return tetrisBoard.getCols();
    }

    @Override
    public Iterable<CoordinateItem<Tile>> tileCoordinates() {
        return tetrisBoard;

    }

    @Override
    public Iterable<CoordinateItem<Tile>> tilesInPiece() {
        return tetrisBoard;
    }
    
}
