package com.example.spotifycrudapi.model

data class ArtistDto(
    val artistId: String,

    val name: String,

    val popularity: String?,

    val genres: Set<String>?,

    val albums: Set<AlbumDto>?
)
