package com.example.spotifycrudapi.mapper

import com.example.spotifycrudapi.model.AlbumDto
import com.example.spotifycrudapi.persistence.Album
import org.mapstruct.InjectionStrategy
import org.mapstruct.Mapper
import org.mapstruct.MappingConstants.ComponentModel

@Mapper(
    uses = [AlbumSimplifiedMapper::class],
    componentModel = ComponentModel.SPRING,
    injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
interface AlbumMapper {
    fun mapAlbumToAlbumDto(album: Album): AlbumDto

    fun mapAlbumsToAlbumDtoList(albums: List<Album>): List<AlbumDto>

    fun mapAlbumDtoToAlbum(albumDto: AlbumDto): Album

    fun mapAlbumDtosToAlbumList(albumDtos: List<AlbumDto>): List<Album>
}