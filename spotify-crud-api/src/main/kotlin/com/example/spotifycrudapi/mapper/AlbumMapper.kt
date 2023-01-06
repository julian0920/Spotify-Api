package com.example.spotifycrudapi.mapper

import com.example.spotifycrudapi.model.AlbumDto
import com.example.spotifycrudapi.persistence.Album
import org.mapstruct.InjectionStrategy
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.MappingConstants.ComponentModel
import se.michaelthelin.spotify.model_objects.specification.AlbumSimplified

@Mapper(componentModel = ComponentModel.SPRING, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
interface AlbumMapper {
    @Mapping(target = "type", source = "type.type")
    @Mapping(target = "artists", source = "artists")
    fun mapToAlbumDtoList(albumSimplified: List<AlbumSimplified>): List<AlbumDto>

    fun mapAlbumToAlbumDto(album: Album): AlbumDto

    fun mapAlbumsToAlbumDtoList(albums: List<Album>): List<AlbumDto>

    fun mapAlbumDtoToAlbum(albumDto: AlbumDto): Album

    fun mapAlbumDtosToAlbumList(albumDtos: List<AlbumDto>): List<Album>

    @Mapping(target = "type", source = "type.type")
    @Mapping(target = "artists", source = "artists")
    fun mapAlbumSimplifiedListToAlbum(albumsimplifiedList: List<AlbumSimplified>): List<Album>
}