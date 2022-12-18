package com.example.spotifycrudapi.controller

import com.example.spotifycrudapi.model.Album
import com.example.spotifycrudapi.service.AlbumService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/albums")
class AlbumController(
    private val albumService: AlbumService
) {

    @GetMapping
    fun getAllAlbums(): List<Album> {
        return albumService.getAllAlbums()
    }

    @GetMapping("/{albumId}")
    fun getAlbumById(@PathVariable("albumId") albumId: Long): Album {
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
    fun createNewAlbum(@RequestBody album: Album) {
        albumService.createNewAlbum(album)
    }

    @DeleteMapping("/delete")
    fun deleteAllAlbums() {
        albumService.deleteAllAlbums()
    }

    @DeleteMapping("/{albumId}/delete")
    fun deleteAlbumById(@PathVariable("albumId") albumId: Long) {
        albumService.deleteAlbumById(albumId)
    }
}