package com.example.spotifycrudapi.mapper

import com.example.spotifycrudapi.model.ArtistDto
import com.example.spotifycrudapi.persistence.Artist
import org.mapstruct.InjectionStrategy
import org.mapstruct.Mapper
import org.mapstruct.MappingConstants

@Mapper(
    uses = [AlbumMapper::class],
    componentModel = MappingConstants.ComponentModel.SPRING,
    injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
interface ArtistMapper {

    fun mapArtistToArtistDto(artist: Artist): ArtistDto

    fun mapArtistDtoToArtist(artistDto: ArtistDto): Artist
}