package com.example.game;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Rectangle;

public class Racket {
    private static final float RACKET_TOP_BOUNDARY  = 300;
    private static final float RACKET_BOTTOM_BOUNDARY  = 10;
    private boolean downIsPressed;
    public Rectangle racket;

    public void moveRacketDown(KeyEvent ke){
        if (ke.getCode() == KeyCode.DOWN || this.downIsPressed) {

            this.downIsPressed = true;
            double racket = this.racket.getLayoutY();
            if (racket < RACKET_TOP_BOUNDARY) {
                this.racket.setLayoutY(this.racket.getLayoutY() + 10);
            }
        }
    }

    public void moveRacketUp() {

    }
}
