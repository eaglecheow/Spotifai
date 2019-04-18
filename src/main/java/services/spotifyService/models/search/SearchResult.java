package services.spotifyService.models.search;

import com.google.gson.annotations.SerializedName;
import services.spotifyService.models.Album;
import services.spotifyService.models.Artist;
import services.spotifyService.models.Track;

public final class SearchResult {
    @SerializedName("albums")
    protected PagingObject<Album> _album;

    @SerializedName("artists")
    protected PagingObject<Artist> _artist;

    @SerializedName("tracks")
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