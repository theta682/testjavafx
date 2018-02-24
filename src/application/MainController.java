package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class MainController {
	@FXML
	private URL location;

	@FXML
	private ResourceBundle resources;

	@FXML
	private Text fileNewTarget;

	@FXML
	protected void handleMenuFileNew(ActionEvent event) {
		fileNewTarget.setText("New was activated");
	}

	@FXML
	void initialize() {
		assert fileNewTarget != null : "fx:id=\"fileNewTarget\" was not injected: check your FXML file 'Main.fxml'.";
	}
}
