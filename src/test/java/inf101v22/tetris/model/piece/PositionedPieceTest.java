package inf101v22.tetris.model.piece;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import inf101v22.grid.Coordinate;
import inf101v22.grid.CoordinateItem;
import inf101v22.tetris.model.Tile;

public class PositionedPieceTest {
    
    @Test
    void iteratorTest() {
        PositionedPiece shapeT = new PositionedPiece(2, 1, PieceShape.T);
        
        List<CoordinateItem<Tile>> items = new ArrayList<>();
        for (CoordinateItem<Tile> tiles: shapeT) {
            items.add(tiles);
    }

    assertEquals(4, items.size());

    assertTrue(items.contains(new CoordinateItem<Tile>(new Coordinate(2, 1), PieceShape.T.getTile())));
    assertTrue(items.contains(new CoordinateItem<Tile>(new Coordinate(2, 2), PieceShape.T.getTile())));
    assertTrue(items.contains(new CoordinateItem<Tile>(new Coordinate(2, 3), PieceShape.T.getTile())));
    assertTrue(items.contains(new CoordinateItem<Tile>(new Coordinate(3, 2), PieceShape.T.getTile())));
    }


}
    
    

