package com.example.spotifycrudapi.spotify.authorization

import com.fasterxml.jackson.annotation.JsonProperty

data class SpotifyToken(
    @JsonProperty("access_token") val accessToken: String,
    @JsonProperty("token_type") val tokenType: String,
    @JsonProperty("expires_in") val expiresIn: Long,
)
