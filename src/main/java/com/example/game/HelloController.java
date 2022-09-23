package com.example.game;

import javafx.fxml.FXML;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

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
    public Rectangle secondPlayerRacket;
    @FXML
    public Rectangle firstPlayerRacket;

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