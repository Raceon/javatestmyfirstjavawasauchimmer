package GUI;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
    public Label label1;

public void initialize() {

    Controller controller = this;

    JavaFXGUI.getInstance().controller = controller;
}
}
