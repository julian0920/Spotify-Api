package com.example.spotifycrudapi.mapper

import com.example.spotifycrudapi.model.ArtistSimplifiedDto
import org.mapstruct.InjectionStrategy
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import se.michaelthelin.spotify.model_objects.specification.ArtistSimplified

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
interface ArtistSimplifiedMapper {

    @Mapping(source = "id", target = "artistId")
    @Mapping(source = "type.type", target = "type")
    fun mapArtistSimplifiedToArtistSimplifiedDto(artistSimplified: ArtistSimplified): ArtistSimplifiedDto
}