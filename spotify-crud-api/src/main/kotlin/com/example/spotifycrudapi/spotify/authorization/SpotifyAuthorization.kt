package com.example.spotifycrudapi.spotify.authorization

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import se.michaelthelin.spotify.SpotifyApi

@Component
class SpotifyAuthorization {

    @Value("\${spotify.clientid}")
    lateinit var clientId: String

    @Value("\${spotify.clientsecret}")
    lateinit var clientSecret: String

    fun createSpotifyApi(): SpotifyApi {
        return SpotifyApi.builder()
            .setClientId(clientId)
            .setClientSecret(clientSecret)
            .build()
    }

    fun tokenAuthorization(accessToken: String?): SpotifyApi {
        return SpotifyApi.builder().setAccessToken(accessToken).build()
    }
}