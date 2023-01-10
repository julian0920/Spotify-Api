package com.example.spotifycrudapi.mapper

import com.example.spotifycrudapi.model.AlbumDto
import com.example.spotifycrudapi.model.AlbumSimplifiedDto
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import se.michaelthelin.spotify.model_objects.specification.AlbumSimplified

@Mapper
interface AlbumSimplifiedMapper {

    @Mapping(target = "type", source = "type.type")
    @Mapping(target = "artists.id", source = "artists.id")
    @Mapping(target = "artists.name", source = "artists.name")
    @Mapping(target = "artists.type", source = "artists.type.type")
    fun mapAlbumSimplifiedListToAlbumSimplifiedDtoList(albumSimplifiedList: List<AlbumSimplified>): List<AlbumSimplifiedDto>

    fun mapAlbumSimplifiedDtoListToAlbumDtoList(albumSimplifiedList: List<AlbumSimplifiedDto>): List<AlbumDto>
}