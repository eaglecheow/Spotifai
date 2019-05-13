package com.spotifai.services.spotifyService.services.artistService;

import com.google.gson.Gson;
import com.spotifai.services.spotifyService.models.Artist;
import com.spotifai.services.spotifyService.helpers.RequestHelper;

public class ArtistService implements IArtistService {

    private RequestHelper requestHelper = new RequestHelper();
    private Gson jsonParser = new Gson();

    /**
     * Gets artist object from Artist ID
     *
     * @param id Artist ID
     * @return Artist object
     */
    @Override
    public Artist getArtistById(String id) {
        String responseString = requestHelper.requestGet("https://api.spotify.com/v1/artists/" + id);
        Artist responseArtist = jsonParser.fromJson(responseString, Artist.class);
        return responseArtist;
    }
}
