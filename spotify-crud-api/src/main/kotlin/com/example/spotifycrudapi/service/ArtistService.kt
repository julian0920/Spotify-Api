package com.example.spotifycrudapi.service

import com.example.spotifycrudapi.model.Artist
import com.example.spotifycrudapi.repositories.ArtistRepository
import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ArtistService {

    @Autowired
    lateinit var artistRepository: ArtistRepository

    private val logger = KotlinLogging.logger {}

    fun getAllArtists(): List<Artist> {
        return artistRepository.findAll()
    }

    fun getArtistById(artistId: Long): Artist {
        return artistRepository.findById(artistId).get()
    }

    fun saveNewArtist(artist: Artist) {
        try {
            artistRepository.save(Artist(artist.id, artist.name, artist.popularity, artist.genres))
        } catch (iae: IllegalArgumentException) {
            logger.error("unknown entity {}", artist)
        }
    }

    fun updateArtistNameById(artistId: Long, name: String) {
        var artist = artistRepository.findById(artistId)
        artist.get().name = name
        artistRepository.save(artist.get())
    }

    fun updateArtistPopularityById(artistId: Long, popularity: Int) {
        var artist = artistRepository.findById(artistId)
        artist.get().popularity = popularity
        artistRepository.save(artist.get())
    }

    fun deleteAllArtists() {
        artistRepository.deleteAll()
    }

    fun deleteArtistById(artistId: Long) {
        try {
            artistRepository.deleteById(artistId)
        } catch (iae: IllegalArgumentException) {
            logger.error("unknown id {}", artistId)
        }
    }
}