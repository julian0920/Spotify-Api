package com.example.spotifycrudapi.model

data class AlbumSimplifiedDto(
    val albumId: String,

    val name: String,

    val releaseDate: String,

    val type: String,

    val artists: Set<ArtistSimplifiedDto>
)