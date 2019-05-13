package com.spotifai.services.spotifyService.services.trackService;

import com.spotifai.services.spotifyService.models.Track;

public interface ITrackService {
    /**
     * Gets track from track ID
     *
     * @param id Track Id
     * @return Track object
     */
    Track getTrackById(String id);
}
