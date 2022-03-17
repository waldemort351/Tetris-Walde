package inf101v22.tetris.model.piece;

import java.util.ArrayList;
import java.util.Random;

import inf101v22.grid.Coordinate;

/**
 * An object in this class represents a piece with it's corresponding coordinate.
 */

// Hvis jeg vil skal ha konstruktør, ha to stykker. De skal være default.
public class PositionedPieceFactory {
    private Random random = new Random();
    private int center; 

    ArrayList<PositionedPiece> myArray = new ArrayList<PositionedPiece>();


    // Empty constructor
    public PositionedPieceFactory() {}

    // Second constructor, for testing purposes. 
    // Se steg 3 for hvordan testen lages.--------
    PositionedPieceFactory(ArrayList<PositionedPiece> myArray) {
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

        PieceShape[] standardPieces = PieceShape.STANDARD_TETRIS_PIECES;
        int randomNumber = random.nextInt(standardPieces.length);
        PieceShape shape = standardPieces[randomNumber];

        // Creates a new PositionedPiece based on it's shape.
        Coordinate coordinate = new Coordinate(0, this.center- shape.getWidth()/2);
        PositionedPiece newPiece = new PositionedPiece(coordinate.row, coordinate.col, shape);
        return newPiece;

    }
    
}
