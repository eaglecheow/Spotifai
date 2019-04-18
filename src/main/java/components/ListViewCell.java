package components;

import javafx.scene.control.ListCell;
import services.spotifyService.models.Track;

public class ListViewCell extends ListCell<Track> {
    @Override
    public void updateItem(Track trackItem, boolean empty) {
        super.updateItem(trackItem, empty);
        if (trackItem != null) {
            Data data = new Data();
            data.setInfo(trackItem);
            setGraphic(data.getBox());
        }
    }
}
