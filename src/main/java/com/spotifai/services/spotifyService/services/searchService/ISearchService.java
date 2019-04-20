package com.spotifai.services.spotifyService.services.searchService;

import com.spotifai.services.spotifyService.models.Album;
import com.spotifai.services.spotifyService.models.Artist;
import com.spotifai.services.spotifyService.models.Track;

public interface ISearchService {
    /**
     * Search for artist
     * @param searchTerm Keyword for search
     * @return An array of Artist object
     */
    Artist[] searchArtist(String searchTerm);

    /**
     * Search for album
     * @param searchTerm Keyword for search
     * @return An array of Album object
     */
    Album[] searchAlbum(String searchTerm);

    /**
     * Search for track
     * @param searchTerm Keyword for search
     * @return An array of Track object
     */
    Track[] searchTrack(String searchTerm);
}
