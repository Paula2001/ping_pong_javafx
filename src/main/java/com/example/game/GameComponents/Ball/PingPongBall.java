package com.example.game.GameComponents.Ball;

import javafx.fxml.FXML;
import javafx.scene.shape.Rectangle;

public class PingPongBall { // TODO : add movement of the border in here in the future
    @FXML
    private final Rectangle ball;
    @FXML
    private Rectangle racket;

    private int yDir = -1;
    private int xDir = -1;

    public PingPongBall(Rectangle b) {
        ball = b;
    }

    public void determineMovementOfBall() {
        double startFirstPart = racket.getLayoutY();
        double endFirstPart = startFirstPart + 30;
        double endSecondPart = startFirstPart + 55;
        double ballY = ball.getLayoutY();

        if (ballY <= endFirstPart) {
            yDir = -1 ;
        } else if (ballY < endSecondPart) {
            yDir = 0;
        } else if (ballY >= endSecondPart) {
            yDir = 1;
        }
        xDir = -1 * xDir ;
    }

    public int getLayoutXDir() {
        return xDir;
    }

    public int getLayoutYDir() {
        return yDir;
    }

    public void setLayoutYDir(int yDir) {
        this.yDir = yDir;
    }

    public void setRacket(Rectangle racket) {
        this.racket = racket;
    }

    public void centerBall(){
        this.ball.setLayoutX(285);
        this.ball.setLayoutY(180);

    }

    public Rectangle getBall(){
        return ball;
    }
}
