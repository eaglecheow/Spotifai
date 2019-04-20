package com.spotifai.services.spotifyService.services.searchService;

import com.google.gson.Gson;
import com.spotifai.services.spotifyService.models.Album;
import com.spotifai.services.spotifyService.models.Artist;
import com.spotifai.services.spotifyService.models.Track;
import com.spotifai.services.spotifyService.models.search.PagingObject;
import com.spotifai.services.spotifyService.models.search.SearchResult;
import com.spotifai.services.spotifyService.helpers.RequestHelper;

import java.util.*;

public class SearchService implements ISearchService {

    private RequestHelper requestHelper = new RequestHelper();
    private Gson jsonParser = new Gson();

    /**
     * Search for artist
     *
     * @param searchTerm Keyword for search
     * @return An array of Artist object
     */
    @Override
    public Artist[] searchArtist(String searchTerm) {

        Map<String, Object> params = new HashMap();
        params.put("q", searchTerm);
        params.put("type", "artist");

        String queryString = requestHelper.urlEncodeUTF8(params);
        String responseString = requestHelper.requestGet("https://api.spotify.com/v1/search?" + queryString);
        SearchResult result = jsonParser.fromJson(responseString, SearchResult.class);
        PagingObject<Artist> artistResult = result.artist();

        return artistResult.items();
    }

    /**
     * Search for album
     *
     * @param searchTerm Keyword for search
     * @return An array of Album object
     */
    @Override
    public Album[] searchAlbum(String searchTerm) {

        Map<String, Object> params = new HashMap();
        params.put("q", searchTerm);
        params.put("type", "album");

        String queryString = requestHelper.urlEncodeUTF8(params);
        String responseString = requestHelper.requestGet("https://api.spotify.com/v1/search?" + queryString);
        SearchResult result = jsonParser.fromJson(responseString, SearchResult.class);
        PagingObject<Album> albumResult = result.album();

        return albumResult.items();
    }

    /**
     * Search for track
     *
     * @param searchTerm Keyword for search
     * @return An array of Track object
     */
    @Override
    public Track[] searchTrack(String searchTerm) {
        Map<String, Object> params = new HashMap();
        params.put("q", searchTerm);
        params.put("type", "track");

        String queryString = requestHelper.urlEncodeUTF8(params);
        System.out.println(queryString);
        String responseString = requestHelper.requestGet("https://api.spotify.com/v1/search?" + queryString);
        SearchResult result = jsonParser.fromJson(responseString, SearchResult.class);
        PagingObject<Track> trackResult = result.track();

        return trackResult.items();
    }
}
