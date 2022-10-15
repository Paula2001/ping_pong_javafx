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
    private boolean downIsPressed = false;
    private boolean sIsPressed = false;
    private boolean wIsPressed = false;
    private int xDir = 1;
    private int yDir = 1;

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
            double racket = firstPlayerRacket.getY();
            if (racket < 80.0 ){
                firstPlayerRacket.setY(firstPlayerRacket.getY() + 10);
            }
            // Move racket down
        }

        if (ke.getCode() == KeyCode.UP || this.upIsPressed) {
            // Move racket up
            this.upIsPressed = true;
            double racket = firstPlayerRacket.getY();
            if (racket > -190.0 ){
                firstPlayerRacket.setY(firstPlayerRacket.getY() - 10);
            }
            // Move racket up
        }

        if (ke.getCode() == KeyCode.S || this.sIsPressed) {
            // Move racket down
            this.sIsPressed = true;
            double racket = secondPlayerRacket.getY();
            if (racket < 180.0 ){
                secondPlayerRacket.setY(secondPlayerRacket.getY() + 10);
            }
            // Move racket down
        }

        if (ke.getCode() == KeyCode.W || this.wIsPressed) {
            // Move racket down
            this.wIsPressed = true;
            double racket = secondPlayerRacket.getY();
            if (racket > -90 ){
                secondPlayerRacket.setY(secondPlayerRacket.getY() - 10);
            }
            // Move racket down
        }
    }


    @FXML
    public void initialize(){
        PingPongBall pingPongBall = new PingPongBall(ball);
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(5), event -> {
//            System.out.println(ball.getX());
            // TODO : TOP = -220 Y
            // TODO : BOTTOM = 130 Y
            // TODO : RIGHT = X
            // TODO : LEFT = -445 X
//            if (ball.getY() > -220) {
//                ball.setY(ball.getY() + 1);
//            }
//            if (ball.getX() < 140){
//                ball.setX(ball.getX() + 1);
//            }

            if (ball.getBoundsInParent().intersects(firstPlayerRacket.getBoundsInParent()) ) {
                pingPongBall.setRacket(firstPlayerRacket);
                pingPongBall.determineMovementOfBall();
            }
            if (ball.getBoundsInParent().intersects(secondPlayerRacket.getBoundsInParent())){
                pingPongBall.setRacket(secondPlayerRacket);
                pingPongBall.determineMovementOfBall();
            }

            if (ball.getBoundsInParent().intersects(topBorder.getBoundsInParent())) {
//                System.out.println("topBorder");
                pingPongBall.setYDir(-1 * pingPongBall.getYDir());
//                yDir = -1 * yDir ;
            }

            if (ball.getBoundsInParent().intersects(bottomBorder.getBoundsInParent())) {
//                System.out.println("bottomBorder");
//                xDir = -1 * xDir;
//                yDir = -1 * yDir ;
                pingPongBall.setXDir(-1 * pingPongBall.getXDir());
                pingPongBall.setYDir(-1 * pingPongBall.getYDir());

            }

            ball.setY(ball.getY() + pingPongBall.getYDir());
            ball.setX(ball.getX() + pingPongBall.getXDir());

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