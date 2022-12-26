package com.example.spotifycrudapi.service

import com.example.spotifycrudapi.persistence.Album
import com.example.spotifycrudapi.repositories.AlbumRepository
import mu.KotlinLogging
import org.springframework.stereotype.Service
import java.text.MessageFormat

@Service
class AlbumService(
    private val albumRepository: AlbumRepository
) {

    private val logger = KotlinLogging.logger {}

    fun getAllAlbums(): List<Album> {
        return albumRepository.findAll()
    }

    fun getAlbumById(albumId: Long): Album {
        return albumRepository.findById(albumId)
            .orElseThrow { IllegalArgumentException(MessageFormat.format("unknown album id {}", albumId)) }
    }

    fun createNewAlbum(album: Album) {
        try {
            albumRepository.save(album)
        } catch (iae: IllegalArgumentException) {
            logger.error("unknown entity {}", album)
        }
    }

    fun updateAlbumNameById(albumId: Long, name: String) {
        val album = albumRepository.findById(albumId)
        album.ifPresent {
            it.name = name
            albumRepository.save(it)
        }
    }

    fun updateAlbumReleaseDateById(albumId: Long, releaseDate: String) {
        val album = albumRepository.findById(albumId)
        album.ifPresent {
            it.releaseDate = releaseDate
            albumRepository.save(it)
        }
    }

    fun deleteAllAlbums() {
        albumRepository.deleteAll()
    }

    fun deleteAlbumById(albumId: Long) {
        try {
            albumRepository.deleteById(albumId)
        } catch (iae: IllegalArgumentException) {
            logger.error("unknown album id {}", albumId)
        }
    }
}