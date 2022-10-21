package com.example.game;

import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Rectangle;

abstract class Racket {
    private static final float RACKET_TOP_BOUNDARY  = 300;
    private static final float RACKET_BOTTOM_BOUNDARY  = 10;
    private static final int RACKET_MOVING_RATE = 10;


    protected void downMovement(Rectangle racket) {
        double racketLayoutY = racket.getLayoutY();
        if (racketLayoutY < RACKET_TOP_BOUNDARY) {
            racket.setLayoutY(racket.getLayoutY() + RACKET_MOVING_RATE);
        }
    }

    protected void upMovement(Rectangle racket) {
        double racketLayoutY = racket.getLayoutY();
        if (racketLayoutY > RACKET_BOTTOM_BOUNDARY){
            racket.setLayoutY(racket.getLayoutY() - RACKET_MOVING_RATE);
        }
    }

    public abstract Racket registerDownMovement(KeyEvent ke);
    public abstract Racket registerUpMovement(KeyEvent ke);

    public abstract void resetClicks(KeyEvent ke);

}
