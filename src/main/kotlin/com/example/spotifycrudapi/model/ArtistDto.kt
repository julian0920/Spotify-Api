package com.example.spotifycrudapi.model

data class ArtistDto(
    val artistId: String,

    var name: String,

    var popularity: Int?,

    val genres: Set<String>?,

    val album: AlbumDto?
)
