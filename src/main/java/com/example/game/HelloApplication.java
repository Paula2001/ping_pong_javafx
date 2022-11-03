package com.example.game;

import com.example.game.Database.FileDatabase;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException, ParseException {
        FileDatabase.CreateDataBase();
        if (FileDatabase.GetLengthOfRecords() == 0) {
            FileDatabase.WriteToDatabase("[]");
        }
        FileDatabase.AddNewRecordToDatabase("malak", 0);
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("start-screen.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Ping pong game");
        stage.setScene(scene);
        stage.show();
        scene.getRoot().requestFocus();
    }

    public static void main(String[] args) {
        launch();
    }

}