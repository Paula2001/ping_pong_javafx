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
        double startFirstPart = racket.getLayoutY();
        double endFirstPart = startFirstPart + 20;
        double endSecondPart = startFirstPart + 65;
        double endThirdPart = startFirstPart + 90;
        double ballY = ball.getLayoutY();

        // TODO : Intervals
        // TODO : First interval layout of racket y -> +20
        // TODO : Second interval +20 -> +65
        // TODO : Third interval layout of +65 -> +90

        if (ballY >= startFirstPart && ballY <= endFirstPart) {
            System.out.println("first part");
            if (yDir != 0) {
                yDir = -1 * yDir; // TODO -1
            }else {
                yDir = 1;
            }
            xDir = -1 * xDir ;
        } else if (ballY >= endFirstPart && ballY <= endSecondPart) {
            System.out.println("second part");
            yDir = 0;
            xDir = -1 * xDir;
        } else if (ballY >= endSecondPart && ballY <= endThirdPart) {
            System.out.println("third part");
            if (yDir != 0) {
                yDir = -1 * yDir; // TODO -1
            }else {
                yDir = 1;
            }
            xDir = -1 * xDir ;
        }


//        System.out.println(heightOfFirstBat);
//        System.out.println(ballY);
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
