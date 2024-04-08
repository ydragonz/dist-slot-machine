package com.ydragonz.client;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SlotMachineApp extends Application {
    private Client client = new Client();

    @Override
    public void start(Stage primaryStage) {
        client.startConnection("localhost", 3829);

        VBox vbox = new VBox(10);
        vbox.setAlignment(Pos.CENTER);

        Label resultLabel = new Label();
        Button playButton = new Button("Play");
        playButton.setOnAction(e -> {
            String result = client.play();
            resultLabel.setText(result);
        });

        vbox.getChildren().addAll(playButton, resultLabel);

        Scene scene = new Scene(vbox, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Slot Machine");
        primaryStage.show();
    }

    @Override
    public void stop() {
        client.stopConnection();
    }

    public static void main(String[] args) {
        launch(args);
    }
}