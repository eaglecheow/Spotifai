package com.spotifai.services.spotifyService.services.artistService;

import com.spotifai.services.spotifyService.models.Artist;

public interface IArtistService {
    Artist getArtistById(String id);
}
