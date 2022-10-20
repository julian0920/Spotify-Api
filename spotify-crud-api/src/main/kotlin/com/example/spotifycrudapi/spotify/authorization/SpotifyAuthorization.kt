package com.example.spotifycrudapi.spotify.authorization

import org.springframework.stereotype.Component
import se.michaelthelin.spotify.SpotifyApi

@Component
class SpotifyAuthorization {

    fun createSpotifyApi(clientId: String, clientSecret: String): SpotifyApi {
        return SpotifyApi.builder()
            .setClientId(clientId)
            .setClientSecret(clientSecret)
            .build()
    }

    fun tokenAuthorization(accessToken: String?): SpotifyApi {
        return SpotifyApi.builder().setAccessToken(accessToken).build()
    }
}