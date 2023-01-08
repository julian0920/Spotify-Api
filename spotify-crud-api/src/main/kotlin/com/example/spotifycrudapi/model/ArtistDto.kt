package com.example.spotifycrudapi.model

data class ArtistDto(
    val id: String,

    val name: String,

    val popularity: String?,

    val genres: List<String>?,

    val albums: List<AlbumDto>?
)
