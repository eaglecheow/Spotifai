package services.spotifyService.services.trackService;

import com.google.gson.Gson;
import services.spotifyService.models.Track;
import services.spotifyService.requestHelper.RequestHelper;

public class TrackService implements ITrackService {

    private RequestHelper requestHelper = new RequestHelper();
    private Gson jsonParser = new Gson();

    @Override
    public Track getTrackById(String id) {

        String responseString = requestHelper.requestGet("https://api.spotify.com/v1/tracks/" + id);
        Track responseTrack = jsonParser.fromJson(responseString, Track.class);
        return responseTrack;
    }
}
