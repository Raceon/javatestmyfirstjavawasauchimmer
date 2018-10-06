package GUI;

import Characters.Character;

public interface GUI {

    public abstract void erfrageSpieleranzahl();

    public abstract void willkommen ();

    public abstract void charakterabfrage (int spieler);

    public abstract void ermittlungsleiterabfrage (Character c);

    public abstract void charakterinfo (Character c);

    public abstract boolean isInitialized ();

    public abstract void gameFensterLaden();
}
