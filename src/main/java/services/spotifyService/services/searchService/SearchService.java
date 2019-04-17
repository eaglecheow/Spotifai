package services.spotifyService.services.searchService;

import services.spotifyService.models.Album;
import services.spotifyService.models.Artist;
import services.spotifyService.models.Track;

public class SearchService implements ISearchService {
    /**
     * Search for artist
     *
     * @param searchTerm Keyword for search
     * @return An array of Artist object
     */
    @Override
    public Artist[] searchArtist(String searchTerm) {
        return new Artist[0];
    }

    /**
     * Search for album
     *
     * @param searchTerm Keyword for search
     * @return An array of Album object
     */
    @Override
    public Album[] searchAlbum(String searchTerm) {
        return new Album[0];
    }

    /**
     * Search for track
     *
     * @param searchTerm Keyword for search
     * @return An array of Track object
     */
    @Override
    public Track[] searchTrack(String searchTerm) {
        return new Track[0];
    }
}
