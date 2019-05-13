package com.spotifai.controllers;

import com.spotifai.components.customListView.ListViewCell;
import com.spotifai.components.customListView.ObjectWithImage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.util.Callback;
import com.spotifai.services.spotifyService.models.Track;
import com.spotifai.services.spotifyService.services.searchService.SearchService;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Set;

public class mainPageController implements Initializable {

    @FXML
    private TextField searchTextField;

    @FXML
    private Button searchButton;

    @FXML
    private ListView<ObjectWithImage<Track>> searchResult;


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

        Alert searchAlert = new Alert(Alert.AlertType.NONE, "Please wait while we're searching for results");
        searchAlert.getDialogPane().getButtonTypes().add(ButtonType.OK);

        Stage stage = (Stage) searchAlert.getDialogPane().getScene().getWindow();
        stage.setTitle("Searching...");
        stage.getIcons().add(new Image(this.getClass().getResource("/images/search.png").toString()));

        searchAlert.show();

        String queryString = searchTextField.getText();

        SearchService ss = new SearchService();
        Track[] tracks = ss.searchTrack(queryString);

        ObservableList<ObjectWithImage<Track>> items = searchResult.getItems();
        items.clear();


        for (Track track : tracks) {
            ObjectWithImage<Track> imageTrackItem = new ObjectWithImage<>(track, track.album().images()[0].url());
            items.add(imageTrackItem);
        }

        searchResult.setCellFactory(new Callback<ListView<ObjectWithImage<Track>>, ListCell<ObjectWithImage<Track>>>() {
            @Override
            public ListCell<ObjectWithImage<Track>> call(ListView<ObjectWithImage<Track>> param) {
                return new ListViewCell();
            }
        });

        searchAlert.close();
    }
}
