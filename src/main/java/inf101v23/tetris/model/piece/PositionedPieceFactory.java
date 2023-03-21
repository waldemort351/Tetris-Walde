package inf101v23.tetris.model.piece;

import java.util.ArrayList;
import java.util.Random;

import inf101v23.grid.Coordinate;

/**
 * An object in this class represents a piece with it's corresponding coordinate.
 */

// Hvis jeg vil skal ha konstruktør, ha to stykker. De skal være default.
public class PositionedPieceFactory {
    private Random random = new Random();
    private int center; 

    ArrayList<PieceShape> myArray = new ArrayList<PieceShape>();


    // Empty constructor
    public PositionedPieceFactory() {}

    // Second constructor, for testing purposes. 
    // Se steg 3 for hvordan testen lages.--------
    PositionedPieceFactory(ArrayList<PieceShape> myArray) {
        this.myArray = myArray;
    }

    public void setCenterColumn(int col) {
        this.center = col;
    }

    /**
     * Picks a random PieceShape object and 
     * creates a new PositionedPiece object based on the former.
     * @return A new PositionedPiece object.
     */
    public PositionedPiece getNextPositionedPiece() {
        PieceShape shape; 
        if (myArray.size() == 0) {
            PieceShape[] standardPieces = PieceShape.STANDARD_TETRIS_PIECES;
            int randomNumber = random.nextInt(standardPieces.length);
            shape = standardPieces[randomNumber];
        } else {
            shape = this.myArray.get(0);
            this.myArray.remove(0);
        }
       

        // Creates a new PositionedPiece based on it's shape.
        Coordinate coordinate = new Coordinate(0, this.center- shape.getWidth()/2);
        PositionedPiece newPiece = new PositionedPiece(coordinate.row, coordinate.col, shape);
        return newPiece;

    }
    
}
