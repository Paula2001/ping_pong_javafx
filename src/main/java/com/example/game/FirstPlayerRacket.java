package com.example.game;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Rectangle;

public class FirstPlayerRacket extends Racket{
    private final Rectangle racket;
    private boolean downIsPressed = false, upIsPressed = false;

    public FirstPlayerRacket(Rectangle racket) {
        this.racket = racket;
    }

    public FirstPlayerRacket registerDownMovement(KeyEvent ke){
        if (ke.getCode() == KeyCode.DOWN || this.downIsPressed) {
            this.downIsPressed = true;
            this.downMovement(this.racket);
        }
        return this;
    }

    public FirstPlayerRacket registerUpMovement(KeyEvent ke){
        if (ke.getCode() == KeyCode.UP || this.upIsPressed) {
            this.upIsPressed = true;
            this.upMovement(this.racket);
        }
        return this;
    }

    public void resetClicks(KeyEvent ke){
        if (ke.getCode() == KeyCode.DOWN) {
            this.downIsPressed = false;
        }

        if (ke.getCode() == KeyCode.UP) {
            this.upIsPressed = false;
        }
    }
}
