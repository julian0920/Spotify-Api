package com.example.spotifycrudapi.mapper

import com.example.spotifycrudapi.model.ArtistDto
import org.mapstruct.InjectionStrategy
import org.mapstruct.Mapper
import org.mapstruct.MappingConstants
import se.michaelthelin.spotify.model_objects.specification.Artist

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
interface SpotifyArtistMapper {
    fun mapToArtistDtoList(spotifyArtists: List<Artist>): List<ArtistDto>

}