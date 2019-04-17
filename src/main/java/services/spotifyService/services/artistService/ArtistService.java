package services.spotifyService.services.artistService;

import com.google.gson.Gson;
import services.spotifyService.models.Artist;
import services.spotifyService.requestHelper.RequestHelper;

public class ArtistService implements IArtistService {

    private RequestHelper requestHelper = new RequestHelper();
    private Gson jsonParser = new Gson();

    @Override
    public Artist getArtistById(String id) {
        String responseString = requestHelper.requestGet("https://api.spotify.com/v1/artists/" + id);
        Artist responseArtist = jsonParser.fromJson(responseString, Artist.class);
        return responseArtist;
    }
}
