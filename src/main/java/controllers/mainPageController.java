package controllers;

import components.ListViewCell;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.util.Callback;
import services.spotifyService.authenticator.SpotifyAuth;
import services.spotifyService.models.Artist;
import services.spotifyService.models.Track;
import services.spotifyService.services.searchService.SearchService;
import services.spotifyService.services.trackService.TrackService;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.Set;

public class mainPageController implements Initializable {

    @FXML
    private TextField searchTextField;

    @FXML
    private Button searchButton;

    @FXML
    private ListView<Track> searchResult;
    private Set<Track> trackSet;
    private ObservableList<Track> trackList = FXCollections.observableArrayList();


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
    private void onSearchButtonClicked(ActionEvent e) {
        String queryString = searchTextField.getText();

        SearchService ss = new SearchService();
        Track[] tracks = ss.searchTrack(queryString);

        ObservableList<Track> items = searchResult.getItems();
        items.clear();

//        trackSet.addAll(Arrays.asList(tracks));

//        trackList.setAll(trackSet);
//        searchResult.setItems(trackList);

        for (Track track : tracks) {
            items.add(track);
        }

        searchResult.setCellFactory(new Callback<ListView<Track>, ListCell<Track>>() {
            @Override
            public ListCell<Track> call(ListView<Track> param) {
                return new ListViewCell();
            }
        });
    }
}
