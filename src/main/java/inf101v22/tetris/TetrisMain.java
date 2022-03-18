package inf101v22.tetris;

import javax.swing.JComponent;
import javax.swing.JFrame;

import inf101v22.tetris.controller.TetrisController;
import inf101v22.tetris.model.TetrisBoard;
import inf101v22.tetris.model.TetrisModel;
import inf101v22.tetris.model.Tile;
// import inf101v22.tetris.view.SampleView;
import inf101v22.tetris.view.TetrisView;
import java.awt.Color;

public class TetrisMain {
    public static final String WINDOW_TITLE = "INF101 Tetris";

    public static void main(String[] args) {
        // JComponent view = new SampleView();

        TetrisBoard board = new TetrisBoard(15, 10, new Tile(Color.BLACK, 'T'));
        TetrisModel model = new TetrisModel(board);
        TetrisView view = new TetrisView(model);
        TetrisController controller = new TetrisController(model, view);
          
        // The JFrame is the "root" application window.
        // We here set som properties of the main window, 
        // and tell it to display our tetrisView
        JFrame frame = new JFrame(WINDOW_TITLE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Here we set which component to view in our window
        frame.setContentPane(view);

        // Call these methods to actually display the window
        frame.pack();
        frame.setVisible(true);

        
    }
    
}
