package Game;

import Characters.Character;
import GUI.ConsoleGUI;
import GUI.GUI;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import GUI.JavaFXGUI;

public class Game {
    int anzahlSpieler;

    List<Character> charaktere = new ArrayList<Character>();

    private static Game instance;

    private static GUI gui;

    private Game(){
        gui = JavaFXGUI.getInstance();
    }

    public static synchronized Game getInstance() {
        if (instance == null) {
            instance = new Game();
        }
        return instance;
    }

    public void start () {
        gui.willkommen();
        anzahlSpieler = gui.erfrageSpieleranzahl();
        for (int i = 1; i <= anzahlSpieler; i++) {
            charaktere.add(gui.charakterabfrage(i));
        }

        for (Character element:charaktere) {
            gui.charakterinfo(element);
        }

        gameloop();
    }

    private void gameloop () {

        do {
            //Aktionsphase
             ermittlungsleiterStep();
        } while (true);
    }

    private void ermittlungsleiterStep() {
        Character ermittlungsleiter;

        try {
            ermittlungsleiter = charaktere.stream().filter(c -> c.isIstErmittlungsleiter()).findFirst().get();
        } catch (NoSuchElementException exe) {
            ermittlungsleiter = null;
        }

        ermittlungsleiter = gui.ermittlungsleiterabfrage(ermittlungsleiter);
        charaktere.stream().forEach(c -> c.setIstErmittlungsleiter(false));
        ermittlungsleiter.setIstErmittlungsleiter(true);
    }

    public List<Character> getCharaktere () {
            return charaktere;
        }
}
