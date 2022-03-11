package inf101v22.tetris.model.piece;

import java.util.ArrayList;
import java.util.Iterator;

import inf101v22.grid.Coordinate;
import inf101v22.grid.CoordinateItem;
import inf101v22.tetris.model.Tile;

// Objects in this class represents a tile with it's corresponding position.

// Lag tester som beskrevet i steg 3. ------------------

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

    public int getWidth() {
        return shape.getWidth();
        

    }
    /**
     * Gets the height of the tile.
     * @return the height.
     */
    public int getHeight() {
        return shape.getHeight();
    
    }

    /**
     * Gets the value of the tile.
     * @return the tile.
     */
    public Tile getTile() {
        return shape.getTile();
    }



    @Override
    public Iterator<CoordinateItem<Tile>> iterator() {
        ArrayList<CoordinateItem<Tile>> aList = new ArrayList<>();
        for (row = 0; row < shape.getHeight(); row++) {
            for (col = 0; col < shape.getWidth(); col++) {
                if (shape.getShape()[row][col]) {
                    CoordinateItem<Tile> coordinateItem = new CoordinateItem<Tile>(new Coordinate(row,col), this.shape.getTile());
                    aList.add(coordinateItem);

                    // TODO check the line above. (ikke sikkert det er noe galt med den, kjør og se)
                    
                }
            }
        }
        return aList.iterator();
    }
    
}
