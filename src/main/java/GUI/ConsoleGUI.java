package GUI;

import Characters.Character;
import Characters.CharacterNames;
import Game.Game;
import javafx.scene.control.Label;

import java.util.Scanner;

public class ConsoleGUI implements GUI {


    public ConsoleGUI () {}

    public void erfrageSpieleranzahl () {
        System.out.println("Wieviele Spieler spielen?");
        Scanner scanner = new Scanner(System.in);
        String eingabe = scanner.nextLine();
        Game.getInstance().gameStateObject.setSpieleranzahl(Integer.valueOf(eingabe));
    }

    public void willkommen () {
        System.out.println("Herzlich Willkommen bei Eldritch Horror!");
    }

    public void charakterabfrage (int spieler) {
        System.out.println("Spieler " + spieler + " welchen Ermittler möchtest du spielen?");
        try {
            Scanner scanner = new Scanner(System.in);
            String eingabe = scanner.nextLine();
            Game.gameStateObject.addCharacter((Character) CharacterNames.valueOf(eingabe.toUpperCase().replace(" ", "_")).getClassobject().newInstance());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public void ermittlungsleiterabfrage (Character c) {

        Scanner scanner = new Scanner(System.in);

        if (c != null) {
            System.out.println(c.getName() + " ist derzeit Ermittlungsleiter. Soll ein neuer gewählt werden?");
            String eingabe = scanner.nextLine();
            if (eingabe.toUpperCase().equals("NEIN")) return;
        }
        System.out.println("Wer soll der neue Ermittlungleiter werden?");
        String eingabe = scanner.nextLine();

        Game.getInstance().gameStateObject.getCharaktere().stream().forEach(d -> d.setIstErmittlungsleiter(false));
        Game.getInstance().gameStateObject.getCharaktere().stream().filter(character -> character.getName().toUpperCase().equals(eingabe.toUpperCase())).findFirst().get().setIstErmittlungsleiter(true);

    }

    public void charakterinfo (Character c) {
        System.out.println(c.toString());
    }

    @Override
    public boolean isInitialized() {
        return true;
    }

    @Override
    public void gameFensterLaden() {

    }
}
