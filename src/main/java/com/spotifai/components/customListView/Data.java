package com.spotifai.components.customListView;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import com.spotifai.services.browserService.BrowserService;
import com.spotifai.services.spotifyService.models.Artist;
import com.spotifai.services.spotifyService.models.Track;

import java.io.IOException;

public class Data {
    @FXML
    private HBox hBox;

    @FXML
    private Label artistName;

    @FXML
    private Label trackName;

    @FXML
    private Label albumName;

    @FXML
    private ImageView coverImage;

    @FXML
    private Button previewButton;

    @FXML
    private Button playOnSpotifyButton;

    public Data()
    {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/listCellItem.fxml"));
        fxmlLoader.setController(this);
        try
        {
            fxmlLoader.load();
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    public void setInfo(ObjectWithImage<Track> trackItemWithImage)
    {
        Track trackItem = trackItemWithImage.object();
        StringBuffer artistNameList = new StringBuffer();
        for (Artist artist : trackItem.artists()) {
            if (artistNameList.length() == 0) {
                artistNameList.append(artist.name());
            } else {
                artistNameList.append(", " + artist.name());
            }
        }
        artistName.setText(artistNameList.toString());
        trackName.setText(trackItem.name());
        albumName.setText(trackItem.album().name());
        previewButton.setOnAction(event -> {
            BrowserService.openUrl(trackItem.previewUrl());
        });
        playOnSpotifyButton.setOnAction(event -> {
            BrowserService.openUrl("http://open.spotify.com/track/" + trackItem.id());
        });

        Image image = trackItemWithImage.image();
        coverImage.setImage(image);

    }

    public HBox getBox()
    {
        return hBox;
    }
}
