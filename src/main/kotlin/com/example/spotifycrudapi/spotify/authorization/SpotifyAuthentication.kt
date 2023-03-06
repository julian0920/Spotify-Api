package com.example.spotifycrudapi.spotify.authorization

import org.springframework.beans.factory.annotation.Value
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.BodyInserters
import org.springframework.web.reactive.function.client.WebClient
import java.util.*

@Component
class SpotifyAuthentication(
    @Value("\${spotify.spotify_token_url}")
    private val tokenUrl: String,

    @Value("\${spotify.client_id}")
    private val clientId: String,

    @Value("\${spotify.client_secret}")
    private val clientSecret: String,

    @Value("\${spotify.grant_type}")
    private val grantType: String,
) {

    fun getToken(): SpotifyToken? {
        return WebClient.builder().defaultHeaders {
            it.contentType = MediaType.APPLICATION_FORM_URLENCODED
        }
            .build()
            .post()
            .uri(tokenUrl)
            .body(
                BodyInserters.fromFormData("grant_type", grantType)
                    .with("client_id", clientId)
                    .with("client_secret", clientSecret),
            )
            .exchangeToMono { it.bodyToMono(SpotifyToken::class.java) }
            .block()
    }
}
