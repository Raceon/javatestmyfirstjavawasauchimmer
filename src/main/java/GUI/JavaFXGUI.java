package GUI;

import Characters.Character;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

public class JavaFXGUI implements GUI {

    public static boolean initialized;
    public static Controller controller;
    public static Object lock = new Object();
    public static Object stateObject;

    public JavaFXGUI () {
        Thread thread = new Thread(){
            public void run(){
                launch(JavaFXApplication.class);
            }
        };
        thread.start();
    }


    @Override
    public int erfrageSpieleranzahl() {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                controller.spielerAnzahlText();
            }
        });

        return getAnzahl();
    }

    private int getAnzahl() {
        synchronized (lock) {
            try {
                lock.wait();
                System.out.println("HI");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return (int) stateObject;
    }

    @Override
    public void willkommen() {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                controller.willkommen();
            }
        });

    }

    @Override
    public Character charakterabfrage(int spieler) {
        return null;
    }

    @Override
    public Character ermittlungsleiterabfrage(Character c) {
        return null;
    }

    @Override
    public void charakterinfo(Character c) {

    }

    @Override
    public boolean isInitialized() {
        return this.initialized;
    }
}
