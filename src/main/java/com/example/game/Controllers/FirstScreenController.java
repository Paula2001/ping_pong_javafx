package com.example.game.Controllers;

import com.example.game.HelloApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class FirstScreenController {
    public AnchorPane rootPane;
    public TextField firstPlayerName;
    public TextField secondPlayerName;
    @FXML
    public Text firstPlayerError;
    @FXML
    public Text secondPlayerError;

    @FXML
    protected void onStartGameClick() throws IOException {
        boolean err = false;
        firstPlayerError.setText("");
        secondPlayerError.setText("");
        if (firstPlayerName.getText().equals("")){
            firstPlayerError.setText("please set first player's name");
            err = true;
        }

        if (secondPlayerName.getText().equals("")){
            secondPlayerError.setText("please set second player's name");
            err = true;
        }

        if (err) {
            return;
        }
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(HelloApplication.class.getResource("ping-pong.fxml"));
        loader.load();
        GameController gameController = loader.getController();
        gameController.setFirstPlayerNameAndSecondPlayerName(firstPlayerName.getText(),secondPlayerName.getText());
        Parent p = loader.getRoot();
        Stage stage = (Stage) rootPane.getScene().getWindow();
        stage.setScene(new Scene(p));
        stage.getScene().getRoot().requestFocus();
        stage.show();
    }
}