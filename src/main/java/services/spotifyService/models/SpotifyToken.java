package services.spotifyService.models;

import com.google.gson.annotations.SerializedName;

public class SpotifyToken {

    @SerializedName("access_token")
    private String _accessToken;

    @SerializedName("token_type")
    private String _tokenType;

    @SerializedName("expires_in")
    private int _expiresIn;


    public String accessToken() {
        return this._accessToken;
    }

    public String tokenType() {
        return this._tokenType;
    }

    public int expiresIn() {
        return this._expiresIn;
    }
}