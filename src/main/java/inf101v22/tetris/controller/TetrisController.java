package inf101v22.tetris.controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import inf101v22.tetris.model.GameScreen;
import inf101v22.tetris.view.TetrisView;

public class TetrisController implements java.awt.event.KeyListener, java.awt.event.ActionListener  {
    
    TetrisControllable model;
    TetrisView tetrisItem;
    javax.swing.Timer timer;

    public TetrisController(TetrisControllable model, TetrisView tetrisItem) {
        this.model = model;
        this.tetrisItem = tetrisItem;
        this.tetrisItem.addKeyListener(this);
        
        // this.timer = new javax.swing.Timer(model.getMsPerClockTick(), this);
        // timer.start();

    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            model.moveFallingPiece(0,-1); // Left arrow was pressed
        }
        else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            model.moveFallingPiece(0,1); // Right arrow was pressed
        }
        else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            model.moveFallingPiece(1,0);// Down arrow was pressed
        }
        else if (e.getKeyCode() == KeyEvent.VK_UP) {
            model.rotatePiece(); // Up arrow was pressed
        }
        else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            model.pieceDrop(); // Spacebar was pressed
        }
        tetrisItem.repaint();
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

    // @Override
    // public void actionPerformed(ActionEvent e) {
    //     if (GameScreen.ACTIVE_GAME != null) {
    //         model.clockTick();
    //         tetrisItem.repaint();
    //         timer.getDelay();
    //     }
        
    // }

    // private void getDelay() {

    //}
}
