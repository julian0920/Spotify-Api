package com.example.spotifycrudapi.spotify.authorization

import mu.KotlinLogging
import org.springframework.stereotype.Service
import se.michaelthelin.spotify.SpotifyApi
import se.michaelthelin.spotify.exceptions.SpotifyWebApiException
import se.michaelthelin.spotify.model_objects.credentials.ClientCredentials
import java.io.IOException

@Service
class SpotifyService(
    private val spotifyAuthorization: SpotifyAuthorization
) {

    private val logger = KotlinLogging.logger {}

    fun register(spotifyApi: SpotifyApi): SpotifyApi {
        try {
            val clientCredentials: ClientCredentials = spotifyApi.clientCredentials().build().execute()
            return spotifyAuthorization.setAccessToken(clientCredentials.accessToken)
        } catch (exception: IOException) {
            logger.error("Error {}", exception.localizedMessage)
        } catch (spotifyWebApiException: SpotifyWebApiException) {
            logger.error("Spotify web exception: {}", spotifyWebApiException.localizedMessage)
        }
        return SpotifyApi.builder().build()
    }
}