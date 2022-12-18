package com.example.spotifycrudapi.controller

import com.example.spotifycrudapi.model.Artist
import com.example.spotifycrudapi.service.ArtistService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/artists")
class ArtistController(
    private val artistService: ArtistService
) {

    @GetMapping
    fun getAllArtists(): List<Artist> {
        return artistService.getAllArtists()
    }

    @GetMapping("/{artistId}")
    fun getArtistById(@PathVariable("artistId") artistId: Long): Artist {
        return artistService.getArtistById(artistId)
    }

    @PutMapping("/{artistId}/{name}")
    fun updateArtistNameById(
        @PathVariable("artistId") artistId: Long,
        @PathVariable("name") name: String
    ) {
        artistService.updateArtistNameById(artistId, name)
    }

    @PutMapping("/{artistId}/{popularity}")
    fun updateArtistPopularityById(
        @PathVariable("artistId") artistId: Long,
        @PathVariable("popularity") popularity: Int
    ) {
        artistService.updateArtistPopularityById(artistId, popularity)
    }

    @PostMapping("/create")
    fun createNewArtist(@RequestBody artist: Artist) {
        artistService.createNewArtist(artist)
    }

    @DeleteMapping("/delete")
    fun deleteAllArtists() {
        artistService.deleteAllArtists()
    }

    @DeleteMapping("/{artistId}/delete")
    fun deleteArtistById(@PathVariable("artistId") artistId: Long) {
        artistService.deleteArtistById(artistId)
    }
}