package com.beblue.cashback.credentials;

import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import com.wrapper.spotify.model_objects.credentials.ClientCredentials;
import com.wrapper.spotify.requests.authorization.client_credentials.ClientCredentialsRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class SpotifyApiCredentials {

    private static final Logger logger =  LoggerFactory.getLogger(SpotifyApiCredentials.class);

    private static final String CLIENT_ID = "8df71ceda4e441cd859c87f9d99f75ff";
    private static final String CLIENT_SECRET = "acdb3f0f7e8540a88b44cbb09a2c3757";

    private static final SpotifyApi spotifyApi = new SpotifyApi.Builder()
            .setClientId(CLIENT_ID)
            .setClientSecret(CLIENT_SECRET)
            .build();

    private static final ClientCredentialsRequest clientCredentialsRequest = spotifyApi.clientCredentials()
            .build();


    public static SpotifyApi getSpotifyApi() {
        try {
            final ClientCredentials clientCredentials = clientCredentialsRequest.execute();

            // Set access token for further "spotifyApi" object usage
            spotifyApi.setAccessToken(clientCredentials.getAccessToken());


        } catch (IOException | SpotifyWebApiException e) {
            logger.error("Erro ao conectar à Api Spotfy -> {}", e.getMessage());
        }

        return spotifyApi;
    }

}

