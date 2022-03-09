package inf101v22.tetris.view;

import javax.swing.JComponent;

import inf101v22.grid.CoordinateItem;
import inf101v22.tetris.model.Tetrisboard;
import inf101v22.tetris.model.Tile;
import inf101v22.tetris.model.Tetrismodel;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
// import java.awt.Font;


public class TetrisView extends JComponent {

    TetrisViewable item;
    int s = 20;
    int p = 10;

    public TetrisView(TetrisViewable item) {
        this.item = item;

    }

    @Override
    public void paint(Graphics canvas) {
        // This will call the paint -method of the JComponent class
        // It is often a good practice to call the super method when
        // overriding an existing method from an inherited class --
        // it might be doing something important.
        super.paint(canvas);
    }


    @Override
    public Dimension getPreferredSize() {
        // This method returns the "preferred" size of the component. However, if 
        // the user resize the window, the values returned here will not matter.
        // Hence, do not use the return value from here to calculate the size of
        // your components; use this.getWidth() and this.getHeight() instead.
        
        // commented out:
        //int width = this.getWidth();
        //int height = this.getHeight();

        int preferredWidth = (s+p) * this.item.numColumns() + p;
        int preferredHeight = (s+p) * this.item.numRows() + p;
        return new Dimension(preferredWidth, preferredHeight);
        //return new Dimension(preferredWidth, preferredHeight);
    }


    private void drawTileWithRightBottomPadding(Graphics g, int boardX, int boardY, int width, int height, int padding, Color color) {
        g.setColor(color);
        g.fillRect(boardX, boardY, width-padding, height-padding);
        
    }

     // kan muligens settes til private
    void drawBoardWithRightBottomPadding(Graphics g, int boardX, int boardY, int width, int height, int padding, Iterable<CoordinateItem<Tile>> board) {
            
        int row = this.item.numRows();
        int col = this.item.numColumns();

        for (CoordinateItem<Tile> tile : board) {
            int x = boardX + col * width / col;
            int y = boardY + row * height / row;
            int nextX = boardX + (col+1) * width / col;
            int nextY = boardY + (row+1) * height / row;
            int cellHeight = nextY - y;
            int cellWidth = nextX - x;

            drawTileWithRightBottomPadding(g, x, y, cellHeight, cellWidth, padding, tile.item.color);
        }
        
    }

    // Draws the tetrisboard.
    public void drawTetrisBoard(Graphics g, int x, int y, int width, int height, int padding) {
        drawBoardWithRightBottomPadding(g, x, y, width, height, padding, item.tileCoordinates());
        
    }

}


