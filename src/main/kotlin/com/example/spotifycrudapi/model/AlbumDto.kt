package com.example.spotifycrudapi.model

data class AlbumDto(
    val albumId: String,

    val name: String,

    val releaseDate: String?,

    val type: String?,

    val artists: List<ArtistDto>
)
