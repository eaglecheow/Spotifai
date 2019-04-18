package services.spotifyService.services.trackService;

import services.spotifyService.models.Track;

public interface ITrackService {
    Track getTrackById(String id);
}
