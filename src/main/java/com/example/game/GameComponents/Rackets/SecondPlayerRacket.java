package com.example.game.GameComponents.Rackets;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Rectangle;

public class SecondPlayerRacket extends Racket{
    private final Rectangle racket;
    private boolean sIsPressed = false, wIsPressed = false;

    public SecondPlayerRacket(Rectangle racket) {
        this.racket = racket;
    }

    public SecondPlayerRacket registerDownMovement(KeyEvent ke){
        if (ke.getCode() == KeyCode.S || this.sIsPressed) {
            this.sIsPressed = true;
            this.downMovement(this.racket);
        }
        return this;
    }

    public SecondPlayerRacket registerUpMovement(KeyEvent ke){
        if (ke.getCode() == KeyCode.W || this.wIsPressed) {
            this.wIsPressed = true;
            this.upMovement(this.racket);
        }
        return this;
    }

    public void resetClicks(KeyEvent ke){

        if (ke.getCode() == KeyCode.S) {
            this.sIsPressed = false;
        }

        if (ke.getCode() == KeyCode.W) {
            this.wIsPressed = false;
        }
    }
}
