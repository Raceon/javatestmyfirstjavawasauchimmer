package GUI;

import Characters.Character;
import javafx.application.Application;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

public class JavaFXGUI extends GUI {

    public static Controller controller;

    private static JavaFXGUI instance;

    private JavaFXGUI () {

        Thread thread = new Thread(){
            public void run(){
                launch(JavaFXApplication.class);
            }
        };

        thread.start();
    }

    public static synchronized JavaFXGUI getInstance() {
        if (instance == null) {
            instance = new JavaFXGUI();
        }

        return instance;
    }



    @Override
    public int erfrageSpieleranzahl() {
        return 0;
    }

    @Override
    public void willkommen() {


        try {
            Thread.currentThread().sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        controller.label1.setText("Herzlich Willkommen bei Eldritch Horror!");
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
}
