package services.spotifyService.models.search;

import com.google.gson.annotations.SerializedName;
import services.spotifyService.models.Album;
import services.spotifyService.models.Artist;
import services.spotifyService.models.Track;

public final class SearchResult {
    @SerializedName("album")
    protected PagingObject<Album> _album;

    @SerializedName("artist")
    protected PagingObject<Artist> _artist;

    @SerializedName("track")
    protected PagingObject<Track> _track;

    public PagingObject<Album> album() {
        return this._album;
    }

    public PagingObject<Artist> artist() {
        return this._artist;
    }

    public PagingObject<Track> track() {
        return this._track;
    }
}