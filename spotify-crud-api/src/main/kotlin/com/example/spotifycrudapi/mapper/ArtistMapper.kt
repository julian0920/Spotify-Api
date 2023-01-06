package com.example.spotifycrudapi.mapper

import com.example.spotifycrudapi.model.ArtistDto
import com.example.spotifycrudapi.persistence.Artist
import org.mapstruct.InjectionStrategy
import org.mapstruct.Mapper
import org.mapstruct.MappingConstants.ComponentModel

@Mapper(componentModel = ComponentModel.SPRING, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
interface ArtistMapper {

    fun mapToArtistDtoList(spotifyArtists: List<se.michaelthelin.spotify.model_objects.specification.Artist>): List<ArtistDto>

    fun mapArtistToArtistDto(artist: Artist): ArtistDto

    fun mapArtistsToArtistDtoList(artists: List<Artist>): List<ArtistDto>

    fun mapArtistDtoToArtist(artistDto: ArtistDto): Artist

    fun mapArtistDtosToArtistList(artistDtos: List<ArtistDto>): List<Artist>

    fun mapToArtistList(artists: List<se.michaelthelin.spotify.model_objects.specification.Artist>): List<Artist>
}