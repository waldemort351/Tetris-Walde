package inf101v22.tetris.model.piece;

import java.awt.Color;

import inf101v22.tetris.model.Tile;

/**
 * Objects of this class represents the shape of a piece.
 */

public class PieceShape {

    private Tile tileAppearance;
    private boolean[][] shape;

    // T-tile
    static final PieceShape T = new PieceShape(new Tile(Color.PINK, 'T'), new boolean[][] {
        {  true,  true,  true },
        { false,  true, false }
    }
     );
    
     // S-tile
    static final PieceShape S = new PieceShape(new Tile(Color.RED, 'S'), new boolean[][] {
        { false,  true,  true },
        {  true,  true, false }
    }
    );
    
    // Z-tile
    static final PieceShape Z = new PieceShape(new Tile(Color.GREEN, 'Z'), new boolean[][] {
        {  true,  true, false },
        { false,  true,  true }
    }
    );
    
    // I-tile
    static final PieceShape I = new PieceShape(new Tile(Color.CYAN, 'I'), new boolean[][] {
        { true,  true,  true, true }
    }
    );
    
    // J-tile
    static final PieceShape J = new PieceShape(new Tile(Color.BLUE, 'J'), new boolean[][] {
        { true, false, false },
        { true, true,  true }
    }
    );
    
    // L-tile
    static final PieceShape L = new PieceShape(new Tile(Color.ORANGE, 'L'), new boolean[][] {
        { false, false,  true },
        {  true,  true,  true }
    }
    );
    
    // O-tile
    static final PieceShape O = new PieceShape(new Tile(Color.MAGENTA, 'O'), new boolean[][] {
        {  true,  true },
        {  true,  true }
    }
    );
    
    // Array of standardPieces
    static final PieceShape[] STANDARD_TETRIS_PIECES = { T, S, Z, I, J, L, O };

    private PieceShape(Tile tileAppearance, boolean[][] shape) {
        this.tileAppearance = tileAppearance;
        this.shape = shape;

    }

    /**
     * Gets the shape of the tile.
     * @return The shape.
     */
    public boolean[][] getShape() {
        return shape;
    }

    /**
     * Gets the width of the tile.
     * @return the width.
     */
    public int getWidth() {
        return shape[0].length;
        

    }
    /**
     * Gets the height of the tile.
     * @return the height.
     */
    public int getHeight() {
        return shape.length;
    
    }

    /**
     * Gets the value of the tile.
     * @return the tile.
     */
    public Tile getTile() {
        return tileAppearance;

    }
}
