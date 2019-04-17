package services.spotifyService.models.search;

import com.google.gson.annotations.SerializedName;
import services.spotifyService.models.BaseObject;

public final class PagingObject<T> extends BaseObject {
    @SerializedName("items")
    protected T[] _items;

    @SerializedName("limit")
    protected int _limit;

    @SerializedName("next")
    protected String _next;

    @SerializedName("offset")
    protected int _offset;

    @SerializedName("previous")
    protected String _previous;

    @SerializedName("total")
    protected int _total;

    public T[] items() {
        return this._items;
    }

    public int limit() {
        return this._limit;
    }

    public String next() {
        return this._next;
    }

    public int offset() {
        return this._offset;
    }

    public String previous() {
        return this._previous;
    }

    public int total() {
        return this._total;
    }
}