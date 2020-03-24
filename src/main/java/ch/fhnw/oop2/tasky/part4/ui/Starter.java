package ch.fhnw.oop2.tasky.part4.ui;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Starter extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent rootPanel = new ApplicationUI();

		Scene scene = new Scene(rootPanel);

		primaryStage.setScene(scene);

		primaryStage.setWidth(800);
		primaryStage.setHeight(600);
		primaryStage.centerOnScreen();

		primaryStage.show();
	}

}
