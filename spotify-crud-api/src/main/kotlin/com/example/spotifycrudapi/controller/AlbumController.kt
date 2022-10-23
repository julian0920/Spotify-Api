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
    @ResponseBody
    fun getAllAlbums(): ResponseEntity<List<Album>> {
        return ResponseEntity(albumService.getAllAlbums(), HttpStatus.OK)
    }

    @GetMapping("/album/{albumId}", produces = [MediaType.APPLICATION_JSON_VALUE])
    @ResponseBody
    fun getAlbumById(@PathVariable("albumId") albumId: Long): ResponseEntity<Album> {
        return ResponseEntity(albumService.getAlbumById(albumId), HttpStatus.OK)
    }

    @PutMapping("/updateAlbumName/{albumId}/{name}", produces = [MediaType.APPLICATION_JSON_VALUE])
    @ResponseBody
    fun updateAlbumNameById(
        @PathVariable("albumId") albumId: Long,
        @PathVariable("name") name: String
    ): ResponseEntity<String> {
        albumService.updateAlbumNameById(albumId, name)
        return ResponseEntity(
            String.format("Album %d was successfully updated by name %s", albumId, name),
            HttpStatus.OK
        )
    }

    @PutMapping("/updateAlbumReleaseDate/{albumId}/{releaseDate}", produces = [MediaType.APPLICATION_JSON_VALUE])
    @ResponseBody
    fun updateAlbumReleaseDateById(
        @PathVariable("albumId") albumId: Long,
        @PathVariable("releaseDate") releaseDate: String
    ): ResponseEntity<String> {
        albumService.updateAlbumReleaseDateById(albumId, releaseDate)
        return ResponseEntity(
            String.format("Album %d was successfully updated by releaseDate %s", albumId, releaseDate),
            HttpStatus.OK
        )
    }

    @PostMapping("/newAlbum", produces = [MediaType.APPLICATION_JSON_VALUE])
    @ResponseBody
    fun saveNewAlbum(@RequestBody album: Album): ResponseEntity<String> {
        albumService.saveNewAlbum(album)
        return ResponseEntity("new Album $album was successfully created", HttpStatus.CREATED)
    }

    @DeleteMapping("/deleteAlbums", produces = [MediaType.APPLICATION_JSON_VALUE])
    @ResponseBody
    fun deleteAllAlbums(): ResponseEntity<String> {
        albumService.deleteAllAlbums()
        return ResponseEntity("All Albums have been deleted", HttpStatus.OK)
    }

    @DeleteMapping("/deleteAlbum/{albumId}", produces = [MediaType.APPLICATION_JSON_VALUE])
    @ResponseBody
    fun deleteAlbumById(@PathVariable("albumId") albumId: Long): ResponseEntity<String> {
        albumService.deleteAlbumById(albumId)
        return ResponseEntity(String.format("Album with id %d was successfully deleted", albumId), HttpStatus.OK)
    }
}