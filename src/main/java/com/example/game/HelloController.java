package com.example.game;

import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class HelloController {
    private boolean upIsPressed = false;

    private static final float RACKET_TOP_BOUNDARY  = 300;
    private static final float RACKET_BOTTOM_BOUNDARY  = 10; // TODO : move to another class ...
    private boolean downIsPressed = false;
    private boolean sIsPressed = false;
    private boolean wIsPressed = false;

    private static final int SPEED = 5;

    @FXML
    public Rectangle ball ;
    @FXML
    public Rectangle secondPlayerRacket, firstPlayerRacket, topBorder, bottomBorder;
//    @FXML
////    public Rectangle firstPlayerRacket;

//    @FXML
//    public Rectangle topBorder;

    @FXML
    public AnchorPane rootPane;
    public Text firstPlayerScore;

    @FXML
    private void handleKeyPressed(KeyEvent ke){
        if (ke.getCode() == KeyCode.DOWN || this.downIsPressed) {
            // Move racket down
            this.downIsPressed = true;
            double racket = firstPlayerRacket.getLayoutY();
            if (racket < RACKET_TOP_BOUNDARY ){
                firstPlayerRacket.setLayoutY(firstPlayerRacket.getLayoutY() + 10);
            }
            // Move racket down
        }

        if (ke.getCode() == KeyCode.UP || this.upIsPressed) {
            // Move racket up
            this.upIsPressed = true;
            double racket = firstPlayerRacket.getLayoutY();
            if (racket > RACKET_BOTTOM_BOUNDARY ){
                firstPlayerRacket.setLayoutY(firstPlayerRacket.getLayoutY() - 10);
            }
            // Move racket up
        }

        if (ke.getCode() == KeyCode.S || this.sIsPressed) {
            // Move racket down
            this.sIsPressed = true;
            double racket = secondPlayerRacket.getLayoutY();
            if (racket < RACKET_TOP_BOUNDARY){
                secondPlayerRacket.setLayoutY(secondPlayerRacket.getLayoutY() + 10);
            }
            // Move racket down
        }

        if (ke.getCode() == KeyCode.W || this.wIsPressed) {
            // Move racket down
            this.wIsPressed = true;
            double racket = secondPlayerRacket.getLayoutY();
            if (racket > 10 ) {
                secondPlayerRacket.setLayoutY(secondPlayerRacket.getLayoutY() - 10);
            }
            // Move racket down
        }
    }


    @FXML
    public void initialize(){


        PingPongBall pingPongBall = new PingPongBall(ball);
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(SPEED), event -> { // TODO : the speed of the ball
            if (ball.getBoundsInParent().intersects(firstPlayerRacket.getBoundsInParent()) ) {
                pingPongBall.setRacket(firstPlayerRacket);
                pingPongBall.determineMovementOfBall();
            }
            if (ball.getBoundsInParent().intersects(secondPlayerRacket.getBoundsInParent())){
                pingPongBall.setRacket(secondPlayerRacket);
                pingPongBall.determineMovementOfBall();
            }

            if (ball.getBoundsInParent().intersects(topBorder.getBoundsInParent())) {
                pingPongBall.setLayoutYDir(-1 * pingPongBall.getLayoutYDir());
            }

            if (ball.getBoundsInParent().intersects(bottomBorder.getBoundsInParent())) {
                pingPongBall.setLayoutYDir(-1 * pingPongBall.getLayoutYDir());

            }

            ball.setLayoutY(ball.getLayoutY() + pingPongBall.getLayoutYDir());
            ball.setLayoutX(ball.getLayoutX() + pingPongBall.getLayoutXDir());
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    @FXML
    private void handleKeyReleased(KeyEvent ke) {
        if (ke.getCode() == KeyCode.DOWN) {
            this.downIsPressed = false;
        }

        if (ke.getCode() == KeyCode.UP) {
            this.upIsPressed = false;
        }

        if (ke.getCode() == KeyCode.S) {
            this.sIsPressed = false;
        }

        if (ke.getCode() == KeyCode.W) {
            this.wIsPressed = false;
        }
    }

}