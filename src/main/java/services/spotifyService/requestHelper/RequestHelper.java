package services.spotifyService.requestHelper;

import com.google.gson.Gson;
import services.spotifyService.authenticator.SpotifyAuth;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class RequestHelper implements IRequestHelper {
    private Gson jsonParser = new Gson();

    @Override
    public String requestGet(String url) {

        try {
            URL generatedUrl = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) generatedUrl.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Authorization", "Bearer " + SpotifyAuth.token().accessToken());

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            return getString(connection, in);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public <T> String requestPost(T postObject, String url) {
        try {
            URL generatedUrl = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) generatedUrl.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");

            String postObjectJson = jsonParser.toJson(postObject);

            connection.setDoOutput(true);
            DataOutputStream write = new DataOutputStream(connection.getOutputStream());
            write.writeBytes(postObjectJson);
            write.flush();
            write.close();

            int responseCode = connection.getResponseCode();

            BufferedReader in = new BufferedReader(new InputStreamReader((connection.getInputStream())));
            return getString(connection, in);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    private String getString(HttpURLConnection connection, BufferedReader in) throws IOException {
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        connection.disconnect();

        String contentJson = content.toString();
        return contentJson;
    }

    @Override
    public <T> String requestUpdate(T updateObject, String url) {
        return null;
    }

    @Override
    public void requestDelete(String url) {

    }

}