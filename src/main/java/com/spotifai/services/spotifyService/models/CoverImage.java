package com.spotifai.services.spotifyService.models;

import com.google.gson.annotations.SerializedName;

public final class CoverImage extends BaseObject {
    @SerializedName("height")
    protected int _height;

    @SerializedName("url")
    protected String _url;

    @SerializedName("width")
    protected int _width;

    public int height() {
        return this._height;
    }

    public String url() {
        return this._url;
    }

    public int width() {
        return this._width;
    }
}
