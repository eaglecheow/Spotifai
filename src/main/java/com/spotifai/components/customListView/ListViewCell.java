package com.spotifai.components.customListView;

import javafx.scene.control.ListCell;
import com.spotifai.services.spotifyService.models.Track;

public class ListViewCell extends ListCell<ObjectWithImage<Track>> {
    @Override
    public void updateItem(ObjectWithImage<Track> trackItem, boolean empty) {
        super.updateItem(trackItem, empty);
        if (trackItem != null) {
            Data data = new Data();
            data.setInfo(trackItem);
            setGraphic(data.getBox());
        }
    }
}
