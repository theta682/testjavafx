package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

public class MainController implements Initializable {
	@FXML
	private URL location;

	@FXML
	private ResourceBundle resources;

	@FXML
	private ComboBox<MainModel.EntityType> comboType;

	@FXML
	protected void selectType(ActionEvent event) {
		mainModel.setType(comboType.getSelectionModel().getSelectedItem());
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	}

	public void initialize(MainModel model) {
		mainModel = model;
		comboType.getItems().addAll(mainModel.getAll());
		comboType.getSelectionModel().select(MainModel.EntityType.NA);
	}

	private MainModel mainModel;
}
