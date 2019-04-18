package services.spotifyService.authenticator;

import com.google.gson.Gson;
import services.spotifyService.models.SpotifyToken;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;

public class SpotifyAuth {

    private static Gson jsonParser = new Gson();

    private static String _clientId = "30c0a522723e4ad59056b8b238675fdb";
    private static String _clientSecret = "70475789c7ed42e0a98f878ad2b48cf4";

    private static boolean _isAuthenticated = false;
    private static SpotifyToken _token;

    public static boolean isAuthenticated() {
        return SpotifyAuth._isAuthenticated;
    }

    public static SpotifyToken token() {
        if (SpotifyAuth._isAuthenticated) {
            return SpotifyAuth._token;
        } else {
            throw new Error("Attempt to get token before authentication");
        }
    }

    public static void authenticate() {
        try {
            URL tokenUrl = new URL("https://accounts.spotify.com/api/token");
            HttpURLConnection connection = (HttpURLConnection) tokenUrl.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

            String requestBody = "grant_type=client_credentials";
            String idSecretPair = SpotifyAuth._clientId + ":" + SpotifyAuth._clientSecret;
            String basicAuth = "Basic " + new String(Base64.getEncoder().encode(idSecretPair.getBytes()));

            connection.setRequestProperty("Authorization", basicAuth);

            connection.setDoOutput(true);
            DataOutputStream write = new DataOutputStream((connection.getOutputStream()));
            write.writeBytes(requestBody);
            write.flush();
            write.close();

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            connection.disconnect();

            String contentJson = content.toString();
            SpotifyToken tokenObject = jsonParser.fromJson(contentJson, SpotifyToken.class);

            SpotifyAuth._token = tokenObject;
            SpotifyAuth._isAuthenticated = true;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}