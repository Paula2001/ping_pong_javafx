package com.example.game;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class HelloController {

    PingPongBall pingPongBall;
    Racket firstRacket, secondRacket;
    private static final int SPEED = 5;
    @FXML
    public Rectangle ball ;
    @FXML
    public Rectangle secondPlayerRacket, firstPlayerRacket, topBorder, bottomBorder;
    @FXML
    public AnchorPane rootPane;
    public Text firstPlayerScore;

    @FXML
    private void handleKeyPressed(KeyEvent ke){
        this.firstRacket.registerUpMovement(ke)
                .registerDownMovement(ke);
        this.secondRacket.registerUpMovement(ke)
                .registerDownMovement(ke);
    }


    @FXML
    public void initialize(){
        this.firstRacket = new FirstPlayerRacket(firstPlayerRacket);
        this.secondRacket = new SecondPlayerRacket(secondPlayerRacket);
        this.pingPongBall = new PingPongBall(this.ball);
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(SPEED), event -> {
            if (ball.getBoundsInParent().intersects(firstPlayerRacket.getBoundsInParent()) ) {
                // TODO : refactor in the future ...
                this.pingPongBall.setRacket(firstPlayerRacket);
                this.pingPongBall.determineMovementOfBall();
            }
            if (ball.getBoundsInParent().intersects(secondPlayerRacket.getBoundsInParent())){
                this.pingPongBall.setRacket(secondPlayerRacket);
                this.pingPongBall.determineMovementOfBall();
            }

            if (ball.getBoundsInParent().intersects(topBorder.getBoundsInParent())) {
                this.pingPongBall.setLayoutYDir(-1 * this.pingPongBall.getLayoutYDir());
            }

            if (ball.getBoundsInParent().intersects(bottomBorder.getBoundsInParent())) {
                this.pingPongBall.setLayoutYDir(-1 * this.pingPongBall.getLayoutYDir());

            }

            ball.setLayoutY(ball.getLayoutY() + this.pingPongBall.getLayoutYDir());
            ball.setLayoutX(ball.getLayoutX() + this.pingPongBall.getLayoutXDir());
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    @FXML
    private void handleKeyReleased(KeyEvent ke) {
        this.firstRacket.resetClicks(ke);
        this.secondRacket.resetClicks(ke);
    }

}