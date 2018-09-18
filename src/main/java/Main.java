import Game.Game;
import org.apache.log4j.Logger;

import java.lang.reflect.InvocationTargetException;

public class Main {

    final static Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        try {
            Game.getInstance().initialize();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
