package inf101v22.tetris.model.piece;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import inf101v22.tetris.model.TetrisBoard;
import inf101v22.tetris.model.TetrisModel;
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
