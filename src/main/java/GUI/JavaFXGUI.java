package GUI;

import Characters.Character;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

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
    public void erfrageSpieleranzahl() {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                controller.spielerAnzahlText();
            }
        });

        syncGUI();
    }

    @Override
    public void willkommen() {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                controller.willkommen();
            }
        });

        syncGUI();

    }

    @Override
    public void charakterabfrage(int spieler) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    controller.loadNewFXML("menuCharakterabfrage.fxml");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                controller.charakterabfrage(spieler);
            }
        });
        syncGUI();
    }


    //meine Arbeit
    @Override
    public void ermittlungsleiterabfrage(Character c) {


        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                     controller.ermittlungsleiterabfrage(c);
                }
        });

        syncGUI();
    }

    @Override
    public void charakterinfo(Character c) {
        System.out.println(c.toString());

    }

    public void gameFensterLaden() {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    controller.loadNewFXML("gamewindow.fxml");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
    });

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                controller.setGameWindow();
            }
        });

        syncGUI();

    }

    @Override
    public boolean isInitialized() {
        return this.initialized;
    }

    private void syncGUI() {
        synchronized (lock) {
            try {
                lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
