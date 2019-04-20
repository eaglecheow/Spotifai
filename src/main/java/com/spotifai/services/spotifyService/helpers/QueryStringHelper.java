package com.spotifai.services.spotifyService.helpers;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class QueryStringHelper {
    private String _query;

    public String query() {
        return this._query;
    }

    public QueryStringHelper(String name, String value) {
        encode(name, value);
    }

    public void add(String name, String value) {
        this._query += "&";
        encode(name, value);
    }

    public void encode(String name, String value) {
        try {
            this._query += URLEncoder.encode(name, "UTF-8");
            this._query += "=";
            this._query += URLEncoder.encode(value, "UTF-8");
        } catch (UnsupportedEncodingException ex) {
            throw new RuntimeException("Broken VM does not support UTF-8");
        }
    }
}
