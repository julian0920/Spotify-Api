package com.example.spotifycrudapi.service

import com.example.spotifycrudapi.mapper.ArtistMapper
import com.example.spotifycrudapi.model.ArtistDto
import com.example.spotifycrudapi.repositories.ArtistRepository
import mu.KotlinLogging
import org.springframework.stereotype.Service
import java.text.MessageFormat

@Service
class ArtistService(
    private val artistRepository: ArtistRepository,
    private val artistMapper: ArtistMapper
) {

    private val logger = KotlinLogging.logger {}

    fun getAllArtists(): Set<ArtistDto> {
        val artists = artistRepository.findAll()
        return artists.map { artistMapper.mapArtistToArtistDto(it) }.toSet()
    }

    fun getArtistById(artistId: String): ArtistDto {
        val artist = artistRepository.findByArtistId(artistId)
            .orElseThrow { IllegalArgumentException(MessageFormat.format("unknown artist id {}", artistId)) }
        return artistMapper.mapArtistToArtistDto(artist)
    }

    fun createNewArtist(artistDto: ArtistDto) {
        val artist = artistMapper.mapArtistDtoToArtist(artistDto)
        try {
            artistRepository.save(artist)
        } catch (iae: IllegalArgumentException) {
            logger.error("unknown entity {}", artist)
        }
    }

    fun updateArtistNameById(artistId: String, name: String) {
        val artist = artistRepository.findByArtistId(artistId)
        artist.ifPresent {
            it.name = name
            artistRepository.save(it)
        }
    }

    fun updateArtistPopularityById(artistId: String, popularity: Int) {
        val artist = artistRepository.findByArtistId(artistId)
        artist.ifPresent {
            it.popularity = popularity
            artistRepository.save(it)
        }
    }

    fun deleteAllArtists() {
        artistRepository.deleteAll()
    }

    fun deleteArtistById(artistId: String) {
        try {
            artistRepository.deleteByArtistId(artistId)
        } catch (iae: IllegalArgumentException) {
            logger.error("unknown artist id {}", artistId)
        }
    }
}