package Characters;

import java.util.List;

public class Character {

    String name;
    String geschichte;

    boolean lebendig;
    boolean istErmittlungsleiter;

    int leben;

    int geist;
    int wissen;

    int einfluss;
    int wahrnehmung;
    int staerke;
    int willenskraft;


    //TODO Startort, Startgegenstände, Aktion, passive
    public String toString () {
        return "Name: " + this.name + "\nLeben: " + this.leben + "\nGeist: " + this.geist;
    }

    public boolean isIstErmittlungsleiter() {
        return istErmittlungsleiter;
    }

    public void setIstErmittlungsleiter(boolean istErmittlungsleiter) {
        this.istErmittlungsleiter = istErmittlungsleiter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGeschichte() {
        return geschichte;
    }

    public void setGeschichte(String geschichte) {
        this.geschichte = geschichte;
    }

    public boolean isLebendig() {
        return lebendig;
    }

    public void setLebendig(boolean lebendig) {
        this.lebendig = lebendig;
    }

    public int getLeben() {
        return leben;
    }

    public void setLeben(int leben) {
        this.leben = leben;
    }

    public int getGeist() {
        return geist;
    }

    public void setGeist(int geist) {
        this.geist = geist;
    }

    public int getWissen() {
        return wissen;
    }

    public void setWissen(int wissen) {
        this.wissen = wissen;
    }

    public int getEinfluss() {
        return einfluss;
    }

    public void setEinfluss(int einfluss) {
        this.einfluss = einfluss;
    }

    public int getWahrnehmung() {
        return wahrnehmung;
    }

    public void setWahrnehmung(int wahrnehmung) {
        this.wahrnehmung = wahrnehmung;
    }

    public int getStaerke() {
        return staerke;
    }

    public void setStaerke(int staerke) {
        this.staerke = staerke;
    }

    public int getWillenskraft() {
        return willenskraft;
    }

    public void setWillenskraft(int willenskraft) {
        this.willenskraft = willenskraft;
    }
}
