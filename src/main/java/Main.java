import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import services.spotifyService.authenticator.SpotifyAuth;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/views/mainPage.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();

        //Authenticate Spotify
        System.out.println("Authenticating Spotify...");
        SpotifyAuth.authenticate();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
