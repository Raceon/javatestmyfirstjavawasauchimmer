import Characters.Character;
import Characters.CharacterNames;
import org.apache.log4j.Logger;

import java.util.Scanner;

public class Main {

    final static Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        Game.getInstance().start();
    }
}
