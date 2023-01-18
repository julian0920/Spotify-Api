package com.example.spotifycrudapi.spotify.authorization

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import se.michaelthelin.spotify.SpotifyApi

@Component
class SpotifyAuthorization(
    @Value("\${spotify.clientid}")
    private val clientId: String,

    @Value("\${spotify.clientsecret}")
    private val clientSecret: String
) {

    fun createClientCredentialsSync(): SpotifyApi {
        return SpotifyApi.builder()
            .setClientId(clientId)
            .setClientSecret(clientSecret)
            .build()
    }

    fun setAccessToken(accessToken: String?): SpotifyApi {
        return SpotifyApi.builder().setAccessToken(accessToken).build()
    }
}