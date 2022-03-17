package inf101v22.tetris.controller;

public interface TetrisControllable {

    /**
     * Moves the piece around the board.
     * @param deltaRow
     * @param deltaCol
     * @return Boolean value that checks whether the piece actually was moved.
     */
    boolean moveFallingPiece(int deltaRow, int deltaCol);
    
    
}
