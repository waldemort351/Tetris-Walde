package inf101v22.tetris.controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import inf101v22.tetris.midi.TetrisSong;
import inf101v22.tetris.model.GameScreen;
import inf101v22.tetris.view.TetrisView;

public class TetrisController implements java.awt.event.KeyListener, java.awt.event.ActionListener   {
    
    TetrisControllable model;
    TetrisView tetrisItem;
    javax.swing.Timer timer;
    TetrisSong song;

    public TetrisController(TetrisControllable model, TetrisView tetrisItem) {
        this.model = model;
        this.tetrisItem = tetrisItem;
        this.tetrisItem.addKeyListener(this);
        
        this.timer = new javax.swing.Timer(model.getMsPerClockTick(), this);
        timer.start();

        // Turned off because... annoying.
        this.song = new TetrisSong();
        // song.run();

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
            if (model.moveFallingPiece(1,0)) // Down arrow was pressed
            timer.restart();
        }
        else if (e.getKeyCode() == KeyEvent.VK_UP) {
            model.rotatePiece(); // Up arrow was pressed
        }
        else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            model.pieceDrop(); // Spacebar was pressed
            timer.restart();
        }
        tetrisItem.repaint();
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ((model.getGameScreen() != GameScreen.GAME_OVER)) {
            model.clockTick();
            tetrisItem.repaint();
            getDelay();
        }
        
    }

    private void getDelay() {
        timer.setDelay(model.getMsPerClockTick());
        timer.setInitialDelay(model.getMsPerClockTick());

    }
}
