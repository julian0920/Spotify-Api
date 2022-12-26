package com.example.spotifycrudapi.spotify.mapper

import com.example.spotifycrudapi.model.AlbumDto
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import se.michaelthelin.spotify.model_objects.specification.AlbumSimplified

@Mapper
interface AlbumMapper {
    @Mapping(target = "type", source = "type.type")
    fun mapToAlbumDto(albumSimplified: List<AlbumSimplified>): List<AlbumDto>
}