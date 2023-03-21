package inf101v23.tetris.model.piece;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import inf101v23.tetris.model.TetrisBoard;
import inf101v23.tetris.model.piece.PieceShape;

public class PieceShapeTest {
    
  

    @Test 
    public void testTwoCharArray() {
        TetrisBoard board = new TetrisBoard(2, 2);
        String expectedStringSep = String.join(System.lineSeparator(), "--",
        "--") + "\n";
        String actualStringSep = board.charArray2dToString(board.toCharArray2d());
        
        assertEquals(expectedStringSep.length(), actualStringSep.length());
        assertEquals(expectedStringSep, actualStringSep);

        
    }


    @Test
    public void rotateTest() {
        PieceShape J = PieceShape.J;
        PieceShape rotatedJ = J.rotatedPieceShapeCopy();
        boolean[][] boolJ = new boolean[][] {
            { true, true },
            { true, false },
            { true, false }
        }; 
        for (int i = 0; i < 3; i++) { 
            for (int j = 0; j < 2; j++) {
                assertEquals(boolJ[i][j], rotatedJ.getShape()[i][j]);
            }
        }
    }
}
