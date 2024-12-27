import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Load the FXML file for the initial screen (Settings page)
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Settings.fxml"));

        // Create the scene from the loaded FXML
        Scene scene = new Scene(loader.load());

        // Set the title for the main window
        primaryStage.setTitle("Personal Budget Management System");

        // Optionally, set an icon for the window (adjust path as necessary)
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/view/icon.png")));

        // Set the scene and display the window
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        // Launch the application
        launch(args);
    }
}
