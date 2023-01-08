package com.example.spotifycrudapi.model

data class AlbumSimplifiedDto(
    val id: String,

    val name: String,

    val releaseDate: String,

    val type: String,

    val artists: List<ArtistSimplifiedDto>
)