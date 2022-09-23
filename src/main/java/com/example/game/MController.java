package com.example.game;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MController implements Initializable {
    public AnchorPane rootPane;
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() throws IOException {
        AnchorPane fxmlLoader = FXMLLoader.load(getClass().getResource("start-menu.fxml"));
        rootPane.getChildren().setAll(fxmlLoader);
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("asiudfohasudifhasuidfh");
    }
}