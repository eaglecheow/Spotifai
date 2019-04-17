package services.spotifyService.models;

import com.google.gson.annotations.SerializedName;

public final class Track extends BaseObject{

    @SerializedName("album")
    protected Album _album;

    @SerializedName("artists")
    protected Artist[] _artists;

    @SerializedName("available_markets")
    protected String[] _availableMarkets;

    @SerializedName("disc_number")
    protected int _discNumber;

    @SerializedName("duration_ms")
    protected int _durationMs;

    @SerializedName("explicit")
    protected boolean _explicit;

    @SerializedName("id")
    protected String _id;

    @SerializedName("is_playable")
    protected boolean _isPlayable;

    @SerializedName("name")
    protected String _name;

    @SerializedName("preview_url")
    protected String _previewUrl;

    @SerializedName("track_number")
    protected int _trackNumber;

    @SerializedName("uri")
    protected String _uri;

    public Album album() {
        return this._album;
    }

    public Artist[] artists() {
        return this._artists;
    }

    public String[] availableMarkets() {
        return this._availableMarkets;
    }

    public int discNumber() {
        return this._discNumber;
    }

    public int durationMs() {
        return this._durationMs;
    }

    public boolean explicit() {
        return this._explicit;
    }

    public String id() {
        return this._id;
    }

    public boolean isPlayable() {
        return this._isPlayable;
    }

    public String name() {
        return this._name;
    }

    public String previewUrl() {
        return this._previewUrl;
    }

    public int trackNumber() {
        return this._trackNumber;
    }

    public String uri() {
        return this._uri;
    }
}
