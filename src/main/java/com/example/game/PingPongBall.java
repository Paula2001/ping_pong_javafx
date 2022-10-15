package com.example.game;

import javafx.fxml.FXML;
import javafx.scene.shape.Rectangle;

public class PingPongBall {
    @FXML
    private Rectangle ball, racket;

    private int yDir = 1;
    private int xDir = 1;

    PingPongBall(Rectangle b) {
        ball = b;
    }

    public void determineMovementOfBall() {
        double heightOfFirstBat = racket.getY() + 90 - 20;
        double thirdPart = heightOfFirstBat;
        double secondPart = thirdPart - 23;
        double firstPart = secondPart - 23;
        double ballY = ball.getY();

        if (ballY >= secondPart && ballY <= thirdPart) {
            System.out.println("third part");
            if (yDir != 0) {
                yDir = -1 * yDir; // TODO -1
            }else {
                yDir = 1;
            }
            xDir = -1 * xDir ;
        } else if (ballY > firstPart && ballY < secondPart) {
            System.out.println("middle");
            yDir = 0;
            xDir = -1 * xDir;
        } else if (ballY >= 0 && ballY <= firstPart) {
            if (yDir != 0) {
                yDir = -1 * yDir; // TODO -1
            }else {
                yDir = 1;
            }
            xDir = -1 * xDir ;
        }


        System.out.println(heightOfFirstBat);
        System.out.println(ball.getY());
    }

    public int getXDir() {
        return xDir;
    }

    public int getYDir() {
        return yDir;
    }

    public void setXDir(int xDir) {
        this.xDir = xDir;
    }

    public void setYDir(int yDir) {
        this.yDir = yDir;
    }

    public void setRacket(Rectangle racket) {
        this.racket = racket;
    }

    public void setBall(Rectangle ball) {
        this.ball = ball;
    }


}
