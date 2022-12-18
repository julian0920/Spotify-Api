package com.example.spotifycrudapi.service

import com.example.spotifycrudapi.model.Artist
import com.example.spotifycrudapi.repositories.ArtistRepository
import mu.KotlinLogging
import org.springframework.stereotype.Service
import java.text.MessageFormat

@Service
class ArtistService(
    private val artistRepository: ArtistRepository
) {

    private val logger = KotlinLogging.logger {}

    fun getAllArtists(): List<Artist> {
        return artistRepository.findAll()
    }

    fun getArtistById(artistId: Long): Artist {
        return artistRepository.findById(artistId)
            .orElseThrow { IllegalArgumentException(MessageFormat.format("unknown artist id {}", artistId)) }
    }

    fun createNewArtist(artist: Artist) {
        try {
            artistRepository.save(Artist(artist.id, artist.name, artist.popularity, artist.genres))
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