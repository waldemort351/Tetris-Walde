package inf101v23.tetris.model.piece;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import inf101v23.tetris.model.TetrisBoard;
import inf101v23.tetris.model.TetrisModel;
import inf101v23.tetris.model.piece.PieceShape;
import inf101v23.tetris.model.piece.PositionedPieceFactory;
public class TetrismodelTest {

    @Test
    public void testShape() {
        ArrayList<PieceShape> myArray = new ArrayList<PieceShape>();
        myArray.add(PieceShape.L);
        PositionedPieceFactory piece = new PositionedPieceFactory(myArray);
        TetrisBoard board = new TetrisBoard(6, 5);
        TetrisModel model = new TetrisModel(board, piece);
        assertEquals(PieceShape.L, model.getFallingPiece().shape);

        System.out.println(model.toString());
        assertEquals(String.join("\n",
        "---L-",
        "-LLL-",
        "-----",
        "-----",
        "-----",
        "-----") + "\n", model.toString());
        

    }
    
}
