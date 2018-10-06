package Game;

import Characters.Character;

import java.util.ArrayList;
import java.util.List;

public class GameStateObject {

    private List<Character> charaktere = new ArrayList<Character>();

    private int spieleranzahl;

    public void addCharacter (Character character) {
        charaktere.add(character);
    }

    public List<Character> getCharaktere() {
        return charaktere;
    }

    public void setCharaktere(List<Character> charaktere) {
        this.charaktere = charaktere;
    }

    public int getSpieleranzahl() {
        return spieleranzahl;
    }

    public void setSpieleranzahl(int spieleranzahl) {
        this.spieleranzahl = spieleranzahl;
    }
}
