package com.example.spotifycrudapi.mapper

import com.example.spotifycrudapi.model.ArtistDto
import org.mapstruct.Mapper
import se.michaelthelin.spotify.model_objects.specification.Artist

@Mapper
interface SpotifyArtistMapper {
    fun mapToArtistDtoList(spotifyArtists: List<Artist>): List<ArtistDto>

}