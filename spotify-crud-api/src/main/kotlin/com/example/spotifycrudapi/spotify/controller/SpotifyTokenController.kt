package com.example.spotifycrudapi.spotify.controller

import com.example.spotifycrudapi.spotify.authorization.SpotifyAuthorization
import com.example.spotifycrudapi.spotify.service.SpotifyService
import com.example.spotifycrudapi.spotify.token.Token
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class SpotifyTokenController {

    @Value("\${spotify.clientid}")
    lateinit var clientId: String

    @Value("\${spotify.clientsecret}")
    lateinit var clientSecret: String

    var spotifyAuthorization = SpotifyAuthorization()
    var spotifyService = SpotifyService()

    @GetMapping("/api/spotify/token", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun retrieveTokenFromSpotify(): ResponseEntity<String> {
        val apiToken = Token()
        val spotifyApi =
            spotifyService.clientCredentialsSync(spotifyAuthorization.createSpotifyApi(clientId, clientSecret))
        apiToken.token = spotifyApi?.accessToken
        return ResponseEntity(HttpStatus.OK)
    }

}