package inf101v22.tetris.view;

import javax.swing.JComponent;

import inf101v22.grid.CoordinateItem;
import inf101v22.tetris.model.GameScreen;
import inf101v22.tetris.model.TetrisBoard;
import inf101v22.tetris.model.Tile;
import inf101v22.tetris.model.TetrisModel;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
// import java.awt.Font;

public class TetrisView extends JComponent {
    
    { // This code (between curly braces) is executed when an object is
        // created (before the call to the constructor, if one exists). 
        
        // The call to setFocusable enables the panel to receive events from
        // the user, such as key-presses and mouse movements.
        this.setFocusable(true);
    }

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
        drawTetrisBoard(canvas, 0, 0, this.getWidth(), this.getHeight(), 3);
        if (item.getGameScreen() == GameScreen.GAME_OVER) {
            drawGameOverScreen(canvas);
        }
        
    }
    
    /**
     * Rather than drawing over the entire screen,
     * the program draws a small box with "GAME OVER"
     * over the centre of the board.
     * @param canvas
     *  */
     
    private void drawGameOverScreen(Graphics canvas) {
        Color transparentRed = new Color(0xff, 0, 0, 0x80); // fourth argument is transparency - try out different values 0x00 - 0xff
        canvas.setColor(transparentRed);
        canvas.fillRect(this.getWidth()/2-100, this.getHeight()/2-50, 200, 100);
        canvas.setColor(Color.BLACK);
        GraphicHelperMethods.drawCenteredString(
                canvas, "GAME OVER",
                0, 0, this.getWidth() - 0, this.getHeight() - 0);
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
    }


    private void drawTileWithRightBottomPadding(Graphics g, int boardX, int boardY, int width, int height, int padding, Color color) {
        g.setColor(color);
        g.fillRect(boardX, boardY, width-padding, height-padding);
        
    }

    private void drawBoardWithRightBottomPadding(Graphics g, int boardX, int boardY, int width, int height, int padding, Iterable<CoordinateItem<Tile>> board) {
            
        int nrows = this.item.numRows();
        int ncols = this.item.numColumns();

        for (CoordinateItem<Tile> tile : board) {
            int col = tile.coordinate.col;
            int row = tile.coordinate.row;
            int x = boardX + col * width / ncols;
            int y = boardY + row * height / nrows;
            int nextX = boardX + (col+1) * width / ncols;
            int nextY = boardY + (row+1) * height / nrows;
            int cellHeight = nextY - y;
            int cellWidth = nextX - x;

            Color color = tile.item == null ? Color.BLACK : tile.item.color;

            drawTileWithRightBottomPadding(g, x, y, cellWidth, cellHeight, padding, color);
        }
        
    }

    // Draws the tetrisboard.
    private void drawTetrisBoard(Graphics g, int x, int y, int width, int height, int padding) {
        drawBoardWithRightBottomPadding(g, x, y, width, height, padding, item.tileCoordinates());
        drawBoardWithRightBottomPadding(g, x, y, width, height, padding, item.tilesInPiece());
    }

}



