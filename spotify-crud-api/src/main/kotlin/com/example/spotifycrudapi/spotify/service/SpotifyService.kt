package com.example.spotifycrudapi.spotify.service

import com.example.spotifycrudapi.spotify.authorization.SpotifyAuthorization
import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import se.michaelthelin.spotify.SpotifyApi
import se.michaelthelin.spotify.exceptions.SpotifyWebApiException
import se.michaelthelin.spotify.model_objects.credentials.ClientCredentials
import java.io.IOException

@Service
class SpotifyService {
    private val logger = KotlinLogging.logger {}

    @Autowired
    private val spotifyAuthorization = SpotifyAuthorization()

    fun clientCredentialsSync(spotifyApi: SpotifyApi): SpotifyApi {
        try {
            val clientCredentials: ClientCredentials = spotifyApi.clientCredentials().build().execute()
            return spotifyAuthorization.tokenAuthorization(clientCredentials.accessToken)
        } catch (exception: IOException) {
            logger.error("Error {}", exception.localizedMessage)
        } catch (spotifyWebApiException: SpotifyWebApiException) {
            logger.error("Spotify web exception: {}", spotifyWebApiException.localizedMessage)
        }
        return SpotifyApi.builder().build()
    }
}