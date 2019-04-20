package com.spotifai.services.spotifyService.models;

import com.google.gson.annotations.SerializedName;

public final class Album extends BaseObject {
    @SerializedName("album_type")
    protected String _albumType;

    @SerializedName("artists")
    protected Artist[] _artists;

    @SerializedName("available_markets")
    protected String[] _availableMarkets;

    @SerializedName("genres")
    protected String[] _genres;

    @SerializedName("id")
    protected String _id;

    @SerializedName("images")
    protected CoverImage[] _coverImages;

    @SerializedName("label")
    protected String _label;

    @SerializedName("name")
    protected String _name;

    @SerializedName("popularity")
    protected int _popularity;

    @SerializedName("release_data")
    protected String _releaseDate;

    @SerializedName("release_date_precision")
    protected String _releaseDatePrecision;

    @SerializedName("tracks")
    protected Track[] _tracks;

    @SerializedName("uri")
    protected String _uri;

    public String albumType() {
        return this._albumType;
    }

    public Artist[] artists() {
        return this._artists;
    }

    public String[] availableMarkets() {
        return this._availableMarkets;
    }

    public String[] genres() {
        return this._genres;
    }

    public String id() {
        return this._id;
    }

    public CoverImage[] images() {
        return this._coverImages;
    }

    public String _label() {
        return this._label;
    }

    public String name() {
        return this._name;
    }

    public int popularity() {
        return this._popularity;
    }

    public String releaseDate() {
        return this._releaseDate;
    }

    public String releaseDatePrecision() {
        return this._releaseDatePrecision;
    }

    public Track[] tracks() {
        return this._tracks;
    }

    public String uri() {
        return this._uri;
    }

}
