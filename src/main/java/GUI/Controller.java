package GUI;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.omg.CORBA.INTERNAL;


public class Controller {

    public Label label1;

    public TextField textField1;

    public void initialize() {
        JavaFXGUI.controller = this;
        JavaFXGUI.initialized = true;
    }

    public void willkommen() {
        label1.setText("Herzlich Willkommen bei Eldritch Horror!");
    }

    public void spielerAnzahlText() {
        label1.setText("Wie viele Spiler spielen mit?");
    }

    public void saveCount() {
        int i = Integer.valueOf(textField1.getText());
        synchronized (JavaFXGUI.lock) {
            JavaFXGUI.stateObject = i;
            JavaFXGUI.lock.notifyAll();
        }
    }
}
