package services.spotifyService.services.artistService;

import services.spotifyService.models.Artist;

public interface IArtistService {
    Artist getArtistById(String id);
}
