package com.example.spotifycrudapi.controller

import com.example.spotifycrudapi.model.AlbumDto
import com.example.spotifycrudapi.service.AlbumService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/albums")
class AlbumController(
    private val albumService: AlbumService
) {

    @GetMapping
    fun getAllAlbums(): List<AlbumDto> {
        return albumService.getAllAlbums()
    }

    @GetMapping("/{albumId}")
    fun getAlbumById(@PathVariable("albumId") albumId: Long): AlbumDto {
        return albumService.getAlbumById(albumId)
    }

    @PutMapping("/{albumId}/{name}")
    fun updateAlbumNameById(
        @PathVariable("albumId") albumId: Long,
        @PathVariable("name") name: String
    ) {
        albumService.updateAlbumNameById(albumId, name)
    }

    @PutMapping("/{albumId}/{releaseDate}")
    fun updateAlbumReleaseDateById(
        @PathVariable("albumId") albumId: Long,
        @PathVariable("releaseDate") releaseDate: String
    ) {
        albumService.updateAlbumReleaseDateById(albumId, releaseDate)
    }

    @PostMapping("/create")
    fun createNewAlbum(@RequestBody albumDto: AlbumDto) {
        albumService.createNewAlbum(albumDto)
    }

    @DeleteMapping
    fun deleteAllAlbums() {
        albumService.deleteAllAlbums()
    }

    @DeleteMapping("/{albumId}")
    fun deleteAlbumById(@PathVariable("albumId") albumId: Long) {
        albumService.deleteAlbumById(albumId)
    }
}