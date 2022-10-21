module com.example.game {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;

    opens com.example.game to javafx.fxml;
    exports com.example.game;
    exports com.example.game.Controllers;
    opens com.example.game.Controllers to javafx.fxml;
    exports com.example.game.GameComponents.Rackets;
    opens com.example.game.GameComponents.Rackets to javafx.fxml;
    exports com.example.game.GameComponents.Ball;
    opens com.example.game.GameComponents.Ball to javafx.fxml;
}