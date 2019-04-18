package components;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import services.browserService.BrowserService;
import services.spotifyService.models.Artist;
import services.spotifyService.models.Track;

import java.io.IOException;

public class Data {
    @FXML
    private HBox hBox;

    @FXML
    private Label artistName;

    @FXML
    private Label trackName;

    @FXML
    private ImageView coverImage;

    @FXML
    private Button previewButton;

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

    public void setInfo(Track trackItem)
    {
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
        previewButton.setOnAction(event -> {
            BrowserService.openUrl(trackItem.previewUrl());
        });

        String url = trackItem.album().images()[0].url();
        Image image = new Image(url);
        coverImage.setImage(image);

    }

    public HBox getBox()
    {
        return hBox;
    }
}
