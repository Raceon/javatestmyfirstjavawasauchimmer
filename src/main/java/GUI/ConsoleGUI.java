package GUI;

import Characters.Character;
import Characters.CharacterNames;

import java.util.Scanner;

public class ConsoleGUI {

    private static ConsoleGUI instance;

    private ConsoleGUI () {}

    public static synchronized ConsoleGUI getInstance() {
        if (instance == null) {
            instance = new ConsoleGUI();
        }

        return instance;
    }

    public int erfrageSpieleranzahl () {
        System.out.println("Wieviele Spieler spielen?");
        Scanner scanner = new Scanner(System.in);
        String eingabe = scanner.nextLine();
        return Integer.valueOf(eingabe);
    }

    public void willkommen () {
        System.out.println("Herzlich Willkommen bei Eldritch Horror!");
    }

    public Character charakterabfrage (int spieler) {
        System.out.println("Spieler " + spieler + " welchen Ermittler möchtest du spielen?");
        try {
            Scanner scanner = new Scanner(System.in);
            String eingabe = scanner.nextLine();
            return (Character) CharacterNames.valueOf(eingabe.toUpperCase().replace(" ", "_")).getName().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void charakterinfo (Character c) {
        System.out.println(c.toString());
    }
}
