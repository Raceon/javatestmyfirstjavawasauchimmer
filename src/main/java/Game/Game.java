package Game;

import Characters.Character;
import Characters.CharacterNames;
import GUI.ConsoleGUI;
import GUI.GUI;
import GUI.GUIs;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

import GUI.JavaFXGUI;
import org.apache.log4j.Logger;

public class Game {

    final static Logger logger = Logger.getLogger(Game.class);

    private static Game instance;

    private static GUI gui;

    public static GameStateObject gameStateObject = new GameStateObject();

    private Game(){
    }

    public static synchronized Game getInstance() {
        if (instance == null) {
            instance = new Game();
        }
        return instance;
    }

    public void initialize() throws InvocationTargetException, IllegalAccessException, InstantiationException {

        System.out.println("Select the gui you want to use:");
        int i = 0;
        for (GUIs g : GUIs.values()) {
            System.out.println("" + i + ": " + g.toString());
            i++;
        }
        Scanner scanner = new Scanner(System.in);
        int t = 0;
        do {
            System.out.println(String.format("Enter number 0 - %d (Default: 0 )",i-1));
            String input = scanner.nextLine();

            try {
                 t = Integer.valueOf(input);
            } catch (NumberFormatException e) {
                logger.debug(e);
            }
        } while (!(t < i && t >= 0));

        gui = (GUI) GUIs.values()[t].getClassobject().newInstance();

        while (!gui.isInitialized()) {
            System.out.println("Waiting two seconds for gui to come up");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.start();
    }

    public void start () {
        gui.willkommen();
        gui.erfrageSpieleranzahl();
        for (int i = 1; i <= gameStateObject.getSpieleranzahl(); i++) {
            gui.charakterabfrage(i);
        }

        for (Character element:gameStateObject.getCharaktere()) {
            gui.charakterinfo(element);
        }

        gui.gameFensterLaden();

        gameloop();
    }

    private void gameloop () {

        do {
            //Aktionsphase
            ermittlungsleiterStep();
            aktionStep();
        } while (true);
    }

    private void ermittlungsleiterStep() {
        Character ermittlungsleiter;

        try {
            ermittlungsleiter = gameStateObject.getCharaktere().stream().filter(c -> c.isIstErmittlungsleiter()).findFirst().get();
        } catch (NoSuchElementException exe) {
            ermittlungsleiter = null;
        }

        gui.ermittlungsleiterabfrage(ermittlungsleiter);
    }

    private void aktionStep() {

    }
}
