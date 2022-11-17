package com.example.spotifycrudapi.service

import com.example.spotifycrudapi.model.Album
import com.example.spotifycrudapi.repositories.AlbumRepository
import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class AlbumService {

    @Autowired
    lateinit var albumRepository: AlbumRepository

    private val logger = KotlinLogging.logger {}

    fun getAllAlbums(): List<Album> {
        return albumRepository.findAll()
    }

    fun getAlbumById(albumId: Long): Album {
        return albumRepository.findById(albumId).get()
    }

    fun saveNewAlbum(album: Album) {
        try {
            albumRepository.save(Album(album.id, album.name, album.releaseDate, album.type))
        } catch (iae: IllegalArgumentException) {
            logger.error("unknown entity {}", album)
        }
    }

    fun updateAlbumNameById(albumId: Long, name: String) {
        var album = albumRepository.findById(albumId)
        album.ifPresent { it.name = name }
        albumRepository.save(album.get())
    }

    fun updateAlbumReleaseDateById(albumId: Long, releaseDate: String) {
        var album = albumRepository.findById(albumId)
        album.ifPresent { it.releaseDate = releaseDate }
        albumRepository.save(album.get())
    }

    fun deleteAllAlbums() {
        albumRepository.deleteAll()
    }

    fun deleteAlbumById(albumId: Long) {
        try {
            albumRepository.deleteById(albumId)
        } catch (iae: IllegalArgumentException) {
            logger.error("unknown id {}", albumId)
        }
    }
}