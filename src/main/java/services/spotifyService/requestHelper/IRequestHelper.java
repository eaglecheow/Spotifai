package services.spotifyService.requestHelper;

public interface IRequestHelper {
    String requestGet(String url);
    <T> String requestPost(T postObject, String url);
    <T> String requestUpdate(T updateObject, String url);
    void requestDelete(String url);
}