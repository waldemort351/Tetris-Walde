package inf101v23.tetris.model;

import java.awt.Color;
import java.lang.Math;

import inf101v23.grid.CoordinateItem;
import inf101v23.tetris.controller.TetrisControllable;
import inf101v23.tetris.model.piece.PositionedPiece;
import inf101v23.tetris.model.piece.PositionedPieceFactory;
import inf101v23.tetris.view.TetrisViewable;

public class TetrisModel implements TetrisViewable, TetrisControllable {

    private TetrisBoard tetrisBoard;
    private PositionedPiece fallingPiece;
    private PositionedPieceFactory pieceFactory;
    private GameScreen screenCondition;

    static final int msPER_CLOCK_TICK = 2000;
    private int countPieces = 0;


    // This constructor is for testing purposes only.
    public TetrisModel(TetrisBoard board, PositionedPieceFactory piece ) {

        this.tetrisBoard = board;

        this.pieceFactory = piece;
        pieceFactory.setCenterColumn(board.getCols()/2);
        this.fallingPiece = pieceFactory.getNextPositionedPiece();
    
        this.screenCondition = GameScreen.ACTIVE_GAME;
    }

    public TetrisModel(TetrisBoard tetrisBoard) {

        this.tetrisBoard = tetrisBoard;

        this.pieceFactory = new PositionedPieceFactory();
        pieceFactory.setCenterColumn(tetrisBoard.getCols()/2);
        this.fallingPiece = pieceFactory.getNextPositionedPiece();
    
        this.screenCondition = GameScreen.ACTIVE_GAME;
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
        return fallingPiece;
    }



    @Override
    public boolean moveFallingPiece(int deltaRow, int deltaCol) {
        PositionedPiece nextCandidate = this.fallingPiece.copy(deltaRow, deltaCol);
        
        if (legalMove(nextCandidate)) {
            this.fallingPiece = nextCandidate;
            return true;
        }
        return false;
        
    }
    
    
    /**
     * Helper method that checks whether a given PositionedPiece
     * has a legal value on the board.
     * @param validCandidate
     * @return True if the entire tile is within the frame and
     * none of the tiles it occupates is already colored by another piece.
     * False otherwise.
     */
    private boolean legalMove(PositionedPiece validCandidate) {
        for (CoordinateItem<Tile> tile : validCandidate) {
            if ( (!this.tetrisBoard.coordinateIsOnGrid(tile.coordinate))) {
                return false;
            }
            Tile getTileCoordinate = this.tetrisBoard.get(tile.coordinate);
            if (getTileCoordinate == null) {
                continue;
            }
            else if (!getTileCoordinate.color.equals(Color.BLACK)) {
                return false;
            }
        }
        return true;
    }

  
    @Override
    public boolean rotatePiece() {
        PositionedPiece rotatedPiece = this.fallingPiece.positionedPieceCopy();
        if (legalMove(rotatedPiece)) {
            this.fallingPiece = rotatedPiece;
            return true;
        }
        return false;
    }

    @Override
    public void pieceDrop() {
        while (moveFallingPiece(1,0)){

        }
        gluePiece();
        tetrisBoard.removeFullRows();
        nextFallingPiece();
    }   

    
    private void nextFallingPiece() {
        PositionedPiece nextCandidate = pieceFactory.getNextPositionedPiece();
        if (legalMove(nextCandidate)) {
            this.fallingPiece = nextCandidate;

        } else { 
            this.screenCondition = GameScreen.GAME_OVER;

        }
        this.countPieces += 1;

    }


    /**
     * 
     * @return A copy of the falling piece.
     */
    public PositionedPiece getFallingPiece() {
        return fallingPiece.copy(0, 0);
    }



    private void gluePiece() {
        for (CoordinateItem<Tile> tile : fallingPiece ) {
            tetrisBoard.set(tile.coordinate, tile.item);
        }
    }

    @Override
    public GameScreen getGameScreen() {
        return screenCondition;
    }




    
    @Override 
    public int getMsPerClockTick() {
        return (int) (msPER_CLOCK_TICK* Math.pow(0.98, countPieces));
    }

    @Override
    public void clockTick() {
        if (moveFallingPiece(1,0)){}
        else {
        gluePiece();
        tetrisBoard.removeFullRows();
        nextFallingPiece();
        }
        
    }

    public String toString() {
        return tetrisBoard.charArray2dToString(this.toCharArray2d());
    }
    
    public char[][] toCharArray2d() {
        char[][] twodDimChar = tetrisBoard.toCharArray2d();
        for (CoordinateItem<Tile> tile : fallingPiece) {
            int row = tile.coordinate.row;
            int col = tile.coordinate.col;
            twodDimChar[row][col] = tile.item.character;
        }
        return twodDimChar;
    }

}
