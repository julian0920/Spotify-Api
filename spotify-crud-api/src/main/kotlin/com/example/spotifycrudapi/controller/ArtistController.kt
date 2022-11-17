package com.example.spotifycrudapi.controller

import com.example.spotifycrudapi.model.Artist
import com.example.spotifycrudapi.service.ArtistService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class ArtistController {

    @Autowired
    private val artistService = ArtistService()

    @GetMapping("/artists", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getAllArtists(): ResponseEntity<List<Artist>> {
        return ResponseEntity(artistService.getAllArtists(), HttpStatus.OK)
    }

    @GetMapping("/artist/{artistId}", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getArtistById(@PathVariable("artistId") artistId: Long): ResponseEntity<Artist> {
        return ResponseEntity(artistService.getArtistById(artistId), HttpStatus.OK)
    }

    @PutMapping("/updateArtistName/{artistId}/{name}", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun updateArtistNameById(
        @PathVariable("artistId") artistId: Long,
        @PathVariable("name") name: String
    ) {
        artistService.updateArtistNameById(artistId, name)
    }

    @PutMapping("/updateArtistPopularity/{artistId}/{popularity}", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun updateArtistPopularityById(
        @PathVariable("artistId") artistId: Long,
        @PathVariable("popularity") popularity: Int
    ) {
        artistService.updateArtistPopularityById(artistId, popularity)
    }

    @PostMapping("/newArtist", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun saveNewArtist(@RequestBody artist: Artist) {
        artistService.saveNewArtist(artist)
    }

    @DeleteMapping("/deleteArtists", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun deleteAllArtists() {
        artistService.deleteAllArtists()
    }

    @DeleteMapping("(deleteArtist/{artistId}", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun deleteArtistById(@PathVariable("artistId") artistId: Long) {
        artistService.deleteArtistById(artistId)
    }
}