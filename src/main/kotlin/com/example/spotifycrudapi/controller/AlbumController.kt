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
    fun getAllAlbums(): Set<AlbumDto> {
        return albumService.getAllAlbums()
    }

    @GetMapping("/{albumId}")
    fun getAlbumById(@PathVariable("albumId") albumId: String): AlbumDto {
        return albumService.getAlbumById(albumId)
    }

    @PutMapping("/update/{albumId}/{name}")
    fun updateAlbumNameById(
        @PathVariable("albumId") albumId: String,
        @PathVariable("name") name: String
    ) {
        albumService.updateAlbumNameById(albumId, name)
    }

    @PutMapping("/{albumId}/{releaseDate}")
    fun updateAlbumReleaseDateById(
        @PathVariable("albumId") albumId: String,
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
    fun deleteAlbumById(@PathVariable("albumId") albumId: String) {
        albumService.deleteAlbumById(albumId)
    }
}