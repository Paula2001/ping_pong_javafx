package com.example.game;

import javafx.fxml.FXML;
import javafx.scene.shape.Rectangle;

public class PingPongBall {
    @FXML
    private Rectangle ball, racket;

    private int yDir = -1;
    private int xDir = -1;

    PingPongBall(Rectangle b) {
        ball = b;
    }

    public void determineMovementOfBall() {
        double startFirstPart = racket.getLayoutY();
        double endFirstPart = startFirstPart + 30;
        double endSecondPart = startFirstPart + 55;
        double ballY = ball.getLayoutY();

        if (ballY <= endFirstPart) {
            if (yDir != 0) {
                yDir = -1 * yDir;
            }else {
                yDir = 1;
            }
            xDir = -1 * xDir ;
        } else if (ballY < endSecondPart) {
            yDir = 0;
            xDir = -1 * xDir;
        } else if (ballY >= endSecondPart) {
            if (yDir != 0) {
                yDir = -1 * yDir;
            }else {
                yDir = 1;
            }
            xDir = -1 * xDir ;
        }
        return;
    }

    public int getLayoutXDir() {
        return xDir;
    }

    public int getLayoutYDir() {
        return yDir;
    }

    public void setLayoutXDir(int xDir) {
        this.xDir = xDir;
    }

    public void setLayoutYDir(int yDir) {
        this.yDir = yDir;
    }

    public void setRacket(Rectangle racket) {
        this.racket = racket;
    }

    public void setBall(Rectangle ball) {
        this.ball = ball;
    }


}
