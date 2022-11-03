package com.example.game.GameComponents.Rackets;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Rectangle;

public abstract class Racket {
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

}
