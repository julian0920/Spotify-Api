package com.example.spotifycrudapi.controller

import com.example.spotifycrudapi.model.Album
import com.example.spotifycrudapi.service.AlbumService
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/albums")
class AlbumController(
    private val albumService: AlbumService
) {

    @GetMapping
    fun getAllAlbums(): ResponseEntity<List<Album>> {
        return ResponseEntity(albumService.getAllAlbums(), HttpStatus.OK)
    }

    @GetMapping("/{albumId}")
    fun getAlbumById(@PathVariable("albumId") albumId: Long): ResponseEntity<Album> {
        return ResponseEntity(albumService.getAlbumById(albumId), HttpStatus.OK)
    }

    @PutMapping("/{albumId}/{name}")
    fun updateAlbumNameById(
        @PathVariable("albumId") albumId: Long,
        @PathVariable("name") name: String
    ) {
        albumService.updateAlbumNameById(albumId, name)
    }

    @PutMapping("/{albumId}/{releaseDate}", produces = [MediaType.APPLICATION_JSON_VALUE])
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

    @DeleteMapping("/{albumId}/delete", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun deleteAlbumById(@PathVariable("albumId") albumId: Long) {
        albumService.deleteAlbumById(albumId)
    }
}