package GUI;

import Characters.Character;
import Characters.CharacterNames;
import Game.Game;

import java.util.Scanner;

public class ConsoleGUI extends GUI {

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
            return (Character) CharacterNames.valueOf(eingabe.toUpperCase().replace(" ", "_")).getClassobject().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Character ermittlungsleiterabfrage (Character c) {

        Scanner scanner = new Scanner(System.in);

        if (c != null) {
            System.out.println(c.getName() + " ist derzeit Ermittlungsleiter. Soll ein neuer gewählt werden?");
            String eingabe = scanner.nextLine();
            if (eingabe.toUpperCase().equals("NEIN")) return c;
        }
        System.out.println("Wer soll der neue Ermittlungleiter werden?");
        String eingabe = scanner.nextLine();
        return Game.getInstance().getCharaktere().stream().filter(character -> character.getName().toUpperCase().equals(eingabe.toUpperCase())).findFirst().get();

    }

    public void charakterinfo (Character c) {
        System.out.println(c.toString());
    }
}
