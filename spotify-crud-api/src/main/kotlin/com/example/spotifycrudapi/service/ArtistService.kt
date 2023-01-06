package com.example.spotifycrudapi.service

import com.example.spotifycrudapi.mapper.ArtistMapper
import com.example.spotifycrudapi.model.ArtistDto
import com.example.spotifycrudapi.repositories.ArtistRepository
import mu.KotlinLogging
import org.springframework.stereotype.Service
import java.text.MessageFormat

@Service
class ArtistService(
    private val artistRepository: ArtistRepository
) {

    private lateinit var artistMapper: ArtistMapper

    private val logger = KotlinLogging.logger {}

    fun getAllArtists(): List<ArtistDto> {
        return artistMapper.mapArtistsToArtistDtoList(artistRepository.findAll())
    }

    fun getArtistById(artistId: Long): ArtistDto {
        val artist = artistRepository.findById(artistId)
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

    fun updateArtistNameById(artistId: Long, name: String) {
        val artist = artistRepository.findById(artistId)
        artist.ifPresent {
            it.name = name
            artistRepository.save(it)
        }
    }

    fun updateArtistPopularityById(artistId: Long, popularity: Int) {
        val artist = artistRepository.findById(artistId)
        artist.ifPresent {
            it.popularity = popularity
            artistRepository.save(it)
        }
    }

    fun deleteAllArtists() {
        artistRepository.deleteAll()
    }

    fun deleteArtistById(artistId: Long) {
        try {
            artistRepository.deleteById(artistId)
        } catch (iae: IllegalArgumentException) {
            logger.error("unknown artist id {}", artistId)
        }
    }
}