package com.example.spotifycrudapi.spotify.mapper

import com.example.spotifycrudapi.model.ArtistDto
import org.mapstruct.Mapper
import se.michaelthelin.spotify.model_objects.specification.Artist

@Mapper
interface ArtistMapper {

    fun mapToArtistDto(spotifyArtists: List<Artist>): List<ArtistDto>
}