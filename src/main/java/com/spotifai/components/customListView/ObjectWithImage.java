package com.spotifai.components.customListView;

import javafx.scene.image.Image;

public class ObjectWithImage<T> {

    private Image _image;
    private String _imageUrl;
    private T _object;

    public Image image() {
        return this._image;
    }

    public String imageUrl() {
        return this._imageUrl;
    }

    public T object() {
        return this._object;
    }

    public ObjectWithImage(T object, String imageUrl) {
        this._object = object;
        this._imageUrl = imageUrl;
        this._image = new Image(imageUrl);
    }
}
