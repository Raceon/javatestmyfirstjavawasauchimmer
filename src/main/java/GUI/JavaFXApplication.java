package GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class JavaFXApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent rootWindow = FXMLLoader.load(getClass().getClassLoader().getResource("welcome.fxml"));
        primaryStage.setTitle("Eldritch Horror");
        primaryStage.setScene(new Scene(rootWindow, 1200,800));
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
