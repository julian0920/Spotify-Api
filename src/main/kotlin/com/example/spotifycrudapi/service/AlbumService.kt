package com.example.spotifycrudapi.service

import com.example.spotifycrudapi.mapper.AlbumMapper
import com.example.spotifycrudapi.model.AlbumDto
import com.example.spotifycrudapi.repositories.AlbumRepository
import mu.KotlinLogging
import org.springframework.stereotype.Service
import java.text.MessageFormat

@Service
class AlbumService(
    private val albumRepository: AlbumRepository,
    private val albumMapper: AlbumMapper
) {

    private val logger = KotlinLogging.logger {}

    fun getAllAlbums(): Set<AlbumDto> {
        val albums = albumRepository.findAll()
        return albums.map { albumMapper.mapAlbumToAlbumDto(it) }.toSet()
    }

    fun getAlbumById(albumId: String): AlbumDto {
        val album = albumRepository.findByAlbumId(albumId)
            .orElseThrow { IllegalArgumentException(MessageFormat.format("unknown album id {}", albumId)) }
        return albumMapper.mapAlbumToAlbumDto(album)
    }

    fun createNewAlbum(albumDto: AlbumDto) {
        val album = albumMapper.mapAlbumDtoToAlbum(albumDto)
        try {
            albumRepository.save(album)
        } catch (iae: IllegalArgumentException) {
            logger.error("unknown entity {}", album)
        }
    }

    fun updateAlbumNameById(albumId: String, name: String) {
        val album = albumRepository.findByAlbumId(albumId)
        album.ifPresent {
            it.name = name
            albumRepository.save(it)
        }
    }

    fun updateAlbumReleaseDateById(albumId: String, releaseDate: String) {
        val album = albumRepository.findByAlbumId(albumId)
        album.ifPresent {
            it.releaseDate = releaseDate
            albumRepository.save(it)
        }
    }

    fun deleteAllAlbums() {
        albumRepository.deleteAll()
    }

    fun deleteAlbumById(albumId: String) {
        try {
            albumRepository.deleteByAlbumId(albumId)
        } catch (iae: IllegalArgumentException) {
            logger.error("unknown album id {}", albumId)
        }
    }
}