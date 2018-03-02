package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.text.Text;

public class MainController implements Initializable {

	public enum EntityType {
		NA("Not Applicable"),
		Type1("Type 1");

		private final String name;
		private EntityType(String s) {
			name = s;
		}

		public boolean equalsName(String otherName) {
			return name.equals(otherName);
		}

		public String toString() {
			return name;
		}
	}

	@FXML
	private URL location;

	@FXML
	private ResourceBundle resources;

	@FXML
	private Text fileNewTarget;

	@FXML
	private ComboBox<EntityType> comboType;
	public EntityType type;

	@FXML
	protected void handleMenuFileNew(ActionEvent event) {
		fileNewTarget.setText("New was activated");
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		type = EntityType.NA;
		comboType.getItems().addAll(
			EntityType.NA,
			EntityType.Type1);
		comboType.getSelectionModel().select(EntityType.NA);
	}
}
