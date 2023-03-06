package com.example.spotifycrudapi.spotify.api

import com.example.spotifycrudapi.spotify.authorization.SpotifyAuthentication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController("https://api.spotify.com/v1")
class SpotifyAlbumController(private val spotifyAuthentication: SpotifyAuthentication) {

    @GetMapping
    fun getAlbum() {}

    @GetMapping
    fun getSeveralAlbums() {}
}