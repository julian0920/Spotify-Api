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

    fun getAllAlbums(): List<AlbumDto> {
        return albumMapper.mapAlbumsToAlbumDtoList(albumRepository.findAll())
    }

    fun getAlbumById(albumId: Long): AlbumDto {
        val album = albumRepository.findById(albumId)
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