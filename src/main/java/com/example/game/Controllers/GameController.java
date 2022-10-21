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
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.io.Console;

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
    @FXML
    public Text firstPlayerScore;
    @FXML
    public Text secondPlayerScore;
    @FXML
    public Text won;
    @FXML
    private void handleKeyPressed(KeyEvent ke){
        this.firstRacket.registerUpMovement(ke)
                .registerDownMovement(ke);
        this.secondRacket.registerUpMovement(ke)
                .registerDownMovement(ke);

        if (ke.getCode() == KeyCode.P){
            this.timeline.play();
        }

    }


    @FXML
    public void initialize(){
        this.pingPongBall = new PingPongBall(this.ball);
        this.firstRacket = new FirstPlayerRacket(firstPlayerRacket);
        this.secondRacket = new SecondPlayerRacket(secondPlayerRacket);
        this.gameRules = new GameRules(pingPongBall);

        this.timeline = new Timeline(new KeyFrame(Duration.millis(SPEED), event -> {

            if (this.gameRules.isGoal()){
                this.gameRules.goalActions();
                this.firstPlayerScore.setText(Integer.toString(this.gameRules.getFirstPlayerScore()));
                this.secondPlayerScore.setText(Integer.toString(this.gameRules.getSecondPlayerScore()));
                if(this.gameRules.checkGameEnded()){
                    this.won.setText(this.gameRules.announceTheWinner());
                }
                this.timeline.pause();
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