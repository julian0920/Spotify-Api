package com.example.spotifycrudapi.spotify.controller

import com.example.spotifycrudapi.model.Album
import com.example.spotifycrudapi.model.Artist
import com.example.spotifycrudapi.spotify.service.SpotifyArtistService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class SpotifyArtistController {

    @Autowired
    private val spotifyArtistService = SpotifyArtistService()

    @GetMapping("/artists", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getSeveralArtists(): ResponseEntity<List<Artist>> {
        val severalArtistsByIds = spotifyArtistService.getSeveralArtistsByIds()
        return ResponseEntity(severalArtistsByIds, HttpStatus.OK)
    }

    @GetMapping("/artists/{id}/albums", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getArtistsAlbums(@PathVariable("id") artistId: String): ResponseEntity<List<Album>> {
        val artistAlbumsById = spotifyArtistService.getArtistAlbumById(artistId)
        return ResponseEntity(artistAlbumsById, HttpStatus.OK)
    }
}