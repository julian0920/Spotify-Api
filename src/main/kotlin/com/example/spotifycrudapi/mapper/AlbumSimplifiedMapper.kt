package com.example.spotifycrudapi.mapper

import com.example.spotifycrudapi.model.AlbumDto
import com.example.spotifycrudapi.model.AlbumSimplifiedDto
import org.mapstruct.InjectionStrategy
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.MappingConstants
import se.michaelthelin.spotify.model_objects.specification.AlbumSimplified

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, injectionStrategy = InjectionStrategy.CONSTRUCTOR, uses = [ArtistSimplifiedMapper::class])
interface AlbumSimplifiedMapper {

    @Mapping(target = "albumId", source = "id")
    @Mapping(target = "type", source = "type.type")
    fun mapAlbumSimplifiedToAlbumSimplifiedDto(albumSimplified: AlbumSimplified): AlbumSimplifiedDto

    fun mapAlbumSimplifiedDtoToAlbumDto(albumSimplified: AlbumSimplifiedDto): AlbumDto
}