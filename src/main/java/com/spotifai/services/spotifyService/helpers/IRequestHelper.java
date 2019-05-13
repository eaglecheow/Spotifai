package com.spotifai.services.spotifyService.helpers;

public interface IRequestHelper {
    /**
     * Sends a GET request to a URL
     *
     * @param url Request URL
     * @return Response body in string
     */
    String requestGet(String url);

    /**
     * Sends a POST request to a URL
     *
     * @param postObject Object as request body
     * @param url        Request URL
     * @param <T>        Post object type
     * @return Response body in string
     */
    <T> String requestPost(T postObject, String url);

    /**
     * Sends an UPDATE request to a URL
     *
     * @param updateObject Object as request body
     * @param url          Request URL
     * @param <T>          Update object type
     * @return Response body in string
     */
    <T> String requestUpdate(T updateObject, String url);

    /**
     * Sends a DELETE request to a URL
     *
     * @param url Request URL
     */
    void requestDelete(String url);

}