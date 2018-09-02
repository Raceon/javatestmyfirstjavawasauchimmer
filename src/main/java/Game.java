import Characters.Character;
import GUI.ConsoleGUI;

import java.util.ArrayList;
import java.util.List;

public class Game {
    int anzahlSpieler;
    List<Character> charaktere = new ArrayList<Character>();

    private static Game instance;

    private Game(){

    }

    public static synchronized Game getInstance() {
        if (instance == null) {
            instance = new Game();
        }
        return instance;
    }

    public void start () {
        ConsoleGUI.getInstance().willkommen();
        anzahlSpieler = ConsoleGUI.getInstance().erfrageSpieleranzahl();
        for (int i = 1; i <= anzahlSpieler; i++) {
            charaktere.add(ConsoleGUI.getInstance().charakterabfrage(i));
        }

        for (Character element:charaktere) {
            ConsoleGUI.getInstance().charakterinfo(element);
        }
    }
}
