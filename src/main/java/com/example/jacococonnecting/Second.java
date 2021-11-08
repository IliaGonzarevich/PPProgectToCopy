package com.example.jacococonnecting;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Second extends Application {

    Stage stage = new Stage();

    @Override
    public void start(Stage secondStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(Second.class.getResource("second.fxml"));
        Scene scene = new Scene(loader.load(), 350, 550);
        secondStage.initModality(Modality.APPLICATION_MODAL);
        secondStage.setTitle("Second stage");
        secondStage.setScene(scene);
        secondStage.showAndWait();
    }

    public static void main(String[] args) { launch(); }

    public void showWindow() throws Exception {
        start(stage);
    }
}
