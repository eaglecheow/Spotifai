package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import services.spotifyService.authenticator.SpotifyAuth;
import services.spotifyService.models.Track;
import services.spotifyService.services.trackService.TrackService;

import java.net.URL;
import java.util.ResourceBundle;

public class mainPageController implements Initializable {

    @FXML
    private Button testButton;

    /**
     * Called to initialize a controller after its root element has been
     * completely processed.
     *
     * @param location  The location used to resolve relative paths for the root object, or
     *                  <tt>null</tt> if the location is not known.
     * @param resources The resources used to localize the root object, or <tt>null</tt> if
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private void testButtonClicked(ActionEvent e) {
        SpotifyAuth.authenticate();
        TrackService ts = new TrackService();
        Track track = ts.getTrackById("3NxuezMdSLgt4OwHzBoUhL");
        track.printObject();
    }
}
