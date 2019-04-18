package services.spotifyService.models;

import com.google.gson.annotations.SerializedName;

public final class Artist extends BaseObject {
    @SerializedName("id")
    protected String _id;

    @SerializedName("images")
    protected CoverImage[] _coverImages;

    @SerializedName("name")
    protected String _name;

    @SerializedName("popularity")
    protected int _popularity;

    @SerializedName("uri")
    protected String _uri;

    public String id() {
        return this._id;
    }

    public CoverImage[] images() {
        return this._coverImages;
    }

    public String name() {
        return this._name;
    }

    public int popularity() {
        return this._popularity;
    }

    public String uri() {
        return this._uri;
    }

}

