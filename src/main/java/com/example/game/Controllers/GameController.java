package com.example.game.Controllers;

import com.example.game.GameComponents.Rackets.FirstPlayerRacket;
import com.example.game.GameComponents.Ball.PingPongBall;
import com.example.game.GameComponents.Rackets.Racket;
import com.example.game.GameComponents.Rackets.SecondPlayerRacket;
import com.example.game.GameComponents.Rules.GameRules;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class GameController {

    PingPongBall pingPongBall;
    Racket firstRacket, secondRacket;
    GameRules gameRules;

    private Timeline timeline;
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
        this.pingPongBall = new PingPongBall(this.ball);
        this.firstRacket = new FirstPlayerRacket(firstPlayerRacket);
        this.secondRacket = new SecondPlayerRacket(secondPlayerRacket);
        this.gameRules = new GameRules(pingPongBall);


        this.timeline = new Timeline(new KeyFrame(Duration.millis(SPEED), event -> {

            if (this.gameRules.isGoal()){
                if(this.gameRules.checkGameEnded()){
                    this.gameRules.announceTheWinner();
                }else {
                    System.out.println("time line is stopped");
                    this.gameRules.goalActions();
                    this.timeline.pause();
                }
            }

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