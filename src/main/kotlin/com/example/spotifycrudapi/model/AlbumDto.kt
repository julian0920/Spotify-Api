package com.example.spotifycrudapi.model

data class AlbumDto(
    val albumId: String,

    var name: String,

    var releaseDate: String?,

    val type: String?,

    val artists: Set<ArtistDto>?
)
