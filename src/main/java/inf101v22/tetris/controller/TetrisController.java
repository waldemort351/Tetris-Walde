package inf101v22.tetris.controller;

import java.awt.event.KeyEvent;

import inf101v22.tetris.view.TetrisView;

public class TetrisController implements java.awt.event.KeyListener  {
    
    TetrisControllable model;
    TetrisView tetrisItem;

    public TetrisController(TetrisControllable model, TetrisView tetrisItem) {
        this.model = model;
        this.tetrisItem = tetrisItem;
        this.tetrisItem.addKeyListener(this);
        // tetrisView.addKeyListener(this); (ikke sikker på hva som mentes her)
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
            model.moveFallingPiece(0,0); // Up arrow was pressed
            // skal mest sannsynlig erstattes i steg 5.
        }
        else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            model.moveFallingPiece(0,0);// Spacebar was pressed
            // skal mest sannsynlig erstattes.
        }
        tetrisItem.repaint();
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

}
