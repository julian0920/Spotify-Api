package com.example.spotifycrudapi.mapper

import com.example.spotifycrudapi.model.ArtistDto
import com.example.spotifycrudapi.persistence.Artist
import org.mapstruct.Mapper

@Mapper(uses = [SpotifyArtistMapper::class])
interface ArtistMapper {

    fun mapArtistToArtistDto(artist: Artist): ArtistDto

    fun mapArtistsToArtistDtoList(artists: List<Artist>): List<ArtistDto>

    fun mapArtistDtoToArtist(artistDto: ArtistDto): Artist

    fun mapArtistDtosToArtistList(artistDtos: List<ArtistDto>): List<Artist>
}