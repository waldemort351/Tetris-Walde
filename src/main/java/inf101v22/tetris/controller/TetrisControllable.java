package inf101v22.tetris.controller;

import inf101v22.tetris.model.GameScreen;

public interface TetrisControllable {

    /**
     * Moves the piece around the board.
     * @param deltaRow
     * @param deltaCol
     * @return Boolean value that checks whether the piece actually was moved.
     */
    boolean moveFallingPiece(int deltaRow, int deltaCol);
    
    /**
     * 
     * @return The piece rotated 90 degrees clockwise.
     */
    boolean rotatePiece();

    /**
     * Drops the piece.
     */
    void pieceDrop();

    
    /**
     * 
     * @return An object of the type GameScreen.
     */
    GameScreen getGameScreen();


    /**
     * 
     * @return How many milliseconds that passes for every clocktick.
     */
    int getMsPerClockTick();

    /**
     * A method getting called for every tick.
     * The method either moves the piece down one row, or 
     * glues the piece to the board.
     */
    void clockTick();
}
