package com.example.game.Controllers;

import com.example.game.Database.FileDatabase;
import com.example.game.HelloApplication;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FirstScreenController implements Initializable {
    public AnchorPane rootPane;
    public TextField firstPlayerName;
    public TextField secondPlayerName;

    private static final String linkedin = "https://paula-george.guru";
    @FXML
    public Text firstPlayerError;
    @FXML
    public Text secondPlayerError;
    public Text score;
    public Text name;

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
    @FXML
    public void onClickHref(){
        (new Application() {
            @Override
            public void start(Stage stage)  {

            }
        }).getHostServices().showDocument(linkedin);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            JSONObject x = FileDatabase.getHighestScore();
            name.setText((String) x.get("name"));
            score.setText(Long.toString((Long) x.get("score")) );
        } catch (FileNotFoundException | ParseException e) {
            throw new RuntimeException(e);
        }

    }
}