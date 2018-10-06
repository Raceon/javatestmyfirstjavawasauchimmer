package GUI;

import Characters.Character;
import Characters.CharacterNames;
import Game.Game;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import org.omg.CORBA.INTERNAL;

import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;


public class Controller {

    public Label label1;

    public TextField textField1;

    public Pane root;

    public ChoiceBox choicebox1;

    public Button cbutton;

    public Button ebutton;

    public VBox gwVBoxSpieler;

    public Label gwCharakterLabel;

    public Label gwLebenLabel;

    public VBox gwVBoxLeftside;
    public Label gwGeistLabel;
    public CheckBox gwErmittlungsleiterCheckbox;
    public Label gwConsoleOutput;
    public TextField gwConsoleInput;

    public void initialize() {
        JavaFXGUI.controller = this;
        JavaFXGUI.initialized = true;
    }

    public void willkommen() {
        label1.setText("Herzlich Willkommen bei Eldritch Horror!");
    }

    public void spielerAnzahlText() {
        label1.setText("Wie viele Spieler spielen mit?");
    }

    public void start() {
        try {
            loadNewFXML("menu.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        syncGUI();
    }

    public void saveCount() {
        int i = Integer.valueOf(textField1.getText());
        Game.getInstance().gameStateObject.setSpieleranzahl(i);
        syncGUI();
    }

    public void charakterabfrage (int spieler){


        label1.setText("Spieler " + spieler + " welchen Ermittler möchtest du spielen?");

        choicebox1.setItems(FXCollections.observableArrayList(Arrays.stream(CharacterNames.values()).map(characterNames -> characterNames.toString()).collect(Collectors.toList())));


    }

    public Character ermittlungsleiterabfrage (Character c) {

        if (c != null) {
            addToConsole(c.getName() + " ist derzeit Ermittlungsleiter. Soll ein neuer gewählt werden? Wenn ja, wer?");
        }
        addToConsole("Wer soll der neue Ermittlungleiter werden?");

        gwConsoleInput.setOnAction(event -> {
            ermittlungsleiterBestimmung();
        });

        return null;
    }

    public void ermittlungsleiterBestimmung () {

        Game.getInstance().gameStateObject.getCharaktere().stream().forEach(d -> d.setIstErmittlungsleiter(false));
        Game.getInstance().gameStateObject.getCharaktere().stream().filter(character -> character.getName().toUpperCase().equals(gwConsoleInput.getText().toUpperCase())).findFirst().get().setIstErmittlungsleiter(true);

        addToConsole(gwConsoleInput.getText() + " ist der neue Ermittlungsleiter.");

        updateCharacterStats();

        syncGUI();

    }

    public void saveCharacter () {
        try {
            Game.gameStateObject.addCharacter((Character) CharacterNames.valueOf((String) choicebox1.getValue()).getClassobject().newInstance());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        syncGUI();
    }

    public void saveErmittlungsleiter() {
        Character character;

        character = (Character) choicebox1.getValue();

        Game.getInstance().gameStateObject.getCharaktere().stream().forEach(d -> d.setIstErmittlungsleiter(false));
        Game.getInstance().gameStateObject.getCharaktere().stream().filter(e -> e.equals(character)).findFirst().get().setIstErmittlungsleiter(true);

        syncGUI();
    }

    public void setGameWindow() {
        updateCharacterStats();

        syncGUI();
    }

    private void updateCharacterStats() {
        gwCharakterLabel.setText(Game.getInstance().gameStateObject.getCharaktere().stream().findFirst().get().getName());
        gwLebenLabel.setText("Leben: " + Game.getInstance().gameStateObject.getCharaktere().stream().findFirst().get().getLeben());
        gwGeistLabel.setText("Geist: " + Game.getInstance().gameStateObject.getCharaktere().stream().findFirst().get().getGeist());
        gwErmittlungsleiterCheckbox.setSelected(Game.getInstance().gameStateObject.getCharaktere().stream().findFirst().get().isIstErmittlungsleiter());
    }

    private void addToConsole(String s) {
        gwConsoleOutput.setText(gwConsoleOutput.getText() + "\n" + s);
    }

    public void loadNewFXML (String fxml) throws IOException {
        root.getChildren().setAll((Node)FXMLLoader.load(getClass().getClassLoader().getResource(fxml)));
    }

    private void syncGUI() {
        synchronized (JavaFXGUI.lock) {
            JavaFXGUI.lock.notifyAll();
        }
    }
}
