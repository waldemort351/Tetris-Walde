package inf101v22.tetris.view;

import inf101v22.grid.CoordinateItem;
import inf101v22.tetris.model.GameScreen;
import inf101v22.tetris.model.Tile;

public interface TetrisViewable {
    
    /** 
     * @return The number of rows.
     */
    int numRows();

    /**
     * 
     * @return The number of columns.
     */
    int numColumns();

    /**
     * @return An Iterable<CoordinateItem<Tile>> that 
     * iterates over the tiles in the board.
     */
    Iterable<CoordinateItem<Tile>> tileCoordinates();


    /**
     * 
     * @return Iterable<CoordinateItem<Tile>> that 
     * iterates over the tiles in the falling pieces.
     */
    Iterable<CoordinateItem<Tile>> tilesInPiece();

    
    /**
     * 
     * @return An object of the type GameScreen.
     */
    GameScreen getGameScreen();


}
