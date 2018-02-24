package application;

import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class MainController {
	@FXML
	private Text fileNewTarget;

	@FXML
	protected void handleMenuFileNew() {
		fileNewTarget.setText("New was activated");
	}
}
