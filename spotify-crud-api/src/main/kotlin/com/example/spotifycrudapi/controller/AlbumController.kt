package com.example.spotifycrudapi.controller

import com.example.spotifycrudapi.model.Album
import com.example.spotifycrudapi.service.AlbumService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class AlbumController {

    @Autowired
    private val albumService = AlbumService()

    @GetMapping("/albums", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getAllAlbums(): ResponseEntity<List<Album>> {
        return ResponseEntity(albumService.getAllAlbums(), HttpStatus.OK)
    }

    @GetMapping("/album/{albumId}", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getAlbumById(@PathVariable("albumId") albumId: Long): ResponseEntity<Album> {
        return ResponseEntity(albumService.getAlbumById(albumId), HttpStatus.OK)
    }

    @PutMapping("/updateAlbumName/{albumId}/{name}", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun updateAlbumNameById(
        @PathVariable("albumId") albumId: Long,
        @PathVariable("name") name: String
    ) {
        albumService.updateAlbumNameById(albumId, name)
    }

    @PutMapping("/updateAlbumReleaseDate/{albumId}/{releaseDate}", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun updateAlbumReleaseDateById(
        @PathVariable("albumId") albumId: Long,
        @PathVariable("releaseDate") releaseDate: String
    ) {
        albumService.updateAlbumReleaseDateById(albumId, releaseDate)
    }

    @PostMapping("/newAlbum", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun saveNewAlbum(@RequestBody album: Album) {
        albumService.saveNewAlbum(album)
    }

    @DeleteMapping("/deleteAlbums", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun deleteAllAlbums() {
        albumService.deleteAllAlbums()
    }

    @DeleteMapping("/deleteAlbum/{albumId}", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun deleteAlbumById(@PathVariable("albumId") albumId: Long) {
        albumService.deleteAlbumById(albumId)
    }
}