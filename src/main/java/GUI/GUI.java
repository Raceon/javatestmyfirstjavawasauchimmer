package GUI;

import Characters.Character;

public abstract class GUI {

    public abstract int erfrageSpieleranzahl();

    public abstract void willkommen ();

    public abstract Character charakterabfrage (int spieler);

    public abstract Character ermittlungsleiterabfrage (Character c);

    public abstract void charakterinfo (Character c);
}