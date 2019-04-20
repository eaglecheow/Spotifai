package com.spotifai.services.spotifyService.services.trackService;

import com.spotifai.services.spotifyService.models.Track;

public interface ITrackService {
    Track getTrackById(String id);
}
