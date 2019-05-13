package com.spotifai.services.spotifyService.services.artistService;

import com.spotifai.services.spotifyService.models.Artist;

public interface IArtistService {
    /**
     * Gets artist object from Artist ID
     *
     * @param id Artist ID
     * @return Artist object
     */
    Artist getArtistById(String id);
}
