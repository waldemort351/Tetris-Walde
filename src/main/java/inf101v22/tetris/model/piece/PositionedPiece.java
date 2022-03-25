package inf101v22.tetris.model.piece;

import java.util.ArrayList;
import java.util.Iterator;

import inf101v22.grid.Coordinate;
import inf101v22.grid.CoordinateItem;
import inf101v22.tetris.model.Tile;

// Objects in this class represents a tile with it's corresponding position.

public class PositionedPiece implements Iterable<CoordinateItem<Tile>> {

    int row;
    int col;
    PieceShape shape;



   // This constructor is set to default on purpose.
    PositionedPiece(int row, int col, PieceShape shape) {
        this.row = row;
        this.col = col;
        this.shape = shape;
    }

    /**
     * Gets the width of the tile.
     * @return The width.
     */
    public int getWidth() {
        return shape.getWidth();
        

    }
    /**
     * Gets the height of the tile.
     * @return The height.
     */
    public int getHeight() {
        return shape.getHeight();
    
    }

    /**
     * Gets the value of the tile.
     * @return The tile.
     */
    public Tile getTile() {
        return shape.getTile();
    }



    @Override
    public Iterator<CoordinateItem<Tile>> iterator() {
        ArrayList<CoordinateItem<Tile>> aList = new ArrayList<>();
        for (int row = 0; row < shape.getHeight(); row++) {
            for (int col = 0; col < shape.getWidth(); col++) {
                if (shape.getShape()[row][col]) {
                    CoordinateItem<Tile> coordinateItem = new CoordinateItem<Tile>(new Coordinate(this.row + row, this.col + col), this.shape.getTile());
                    aList.add(coordinateItem);
                    
                }
            }
        }
        return aList.iterator();
    }
    

    /**
     * PositionedPiece method that creates a copy of itself.
     * @param deltaRow
     * @param deltaCol
     * @return A copy of PositionedPiece, 
     * but adjusted according to it's parameters deltaRow and deltaCol.
     */
    public PositionedPiece copy(int deltaRow, int deltaCol) {
        PositionedPiece copy = new PositionedPiece(this.row + deltaRow, this.col + deltaCol, shape);
        return copy;
    }

    /**
     * A copy method.
     * @return a new piece where the rotation is executed within the center
     * of the PositionedPiece.
     */
    public PositionedPiece positionedPieceCopy() {
        PieceShape newShape = shape.rotatedPieceShapeCopy();

        return new PositionedPiece(row+(shape.getHeight()/2) - newShape.getHeight()/2 , col+(shape.getWidth()/2) - newShape.getWidth()/2, newShape);
    }
}
