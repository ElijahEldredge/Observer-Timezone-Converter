import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * Main driver for the application
 */
public class FXDriver extends Application{
    public static void main(String[] args) {
        // Launch UI
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        AnchorPane root = FXMLLoader.load(getClass().getResource("observer/gfx/observer.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add("observer/gfx/styles.css");

        primaryStage.setTitle("Observer Pattern Homework");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
