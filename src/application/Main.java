package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("My JavaFX Application");
			createMainScene();
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void createMainScene() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Main.fxml"));
		Parent root = loader.load();
		MainController mainController = (MainController) loader.getController();
		mainController.initialize(mainModel);
		scene = new Scene(root);
	}

	static Main instance;
	private MainModel mainModel;
	private Scene scene;

	public Main() {
		instance = this;
		mainModel = new MainModel();
		mainModel.load("test");
	}

	MainModel getModel() {
		return mainModel;
	}

	Scene getScene() {
		return scene;
	}

	public static void main(String[] args) {
		launch(Main.class, args);
	}
}
