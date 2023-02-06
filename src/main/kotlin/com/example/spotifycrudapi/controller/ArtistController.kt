package com.example.spotifycrudapi.controller

import com.example.spotifycrudapi.model.ArtistDto
import com.example.spotifycrudapi.service.ArtistService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/artists")
class ArtistController(
    private val artistService: ArtistService
) {

    @GetMapping
    fun getAllArtists(): Set<ArtistDto> {
        return artistService.getAllArtists()
    }

    @GetMapping("/{artistId}")
    fun getArtistById(@PathVariable("artistId") artistId: String): ArtistDto {
        return artistService.getArtistById(artistId)
    }

    @PutMapping("/{artistId}/{name}")
    fun updateArtistNameById(
        @PathVariable("artistId") artistId: String,
        @PathVariable("name") name: String
    ) {
        artistService.updateArtistNameById(artistId, name)
    }

    @PutMapping("/{artistId}/{popularity}")
    fun updateArtistPopularityById(
        @PathVariable("artistId") artistId: String,
        @PathVariable("popularity") popularity: Int
    ) {
        artistService.updateArtistPopularityById(artistId, popularity)
    }

    @PostMapping("/create")
    fun createNewArtist(@RequestBody artistDto: ArtistDto) {
        artistService.createNewArtist(artistDto)
    }

    @DeleteMapping
    fun deleteAllArtists() {
        artistService.deleteAllArtists()
    }

    @DeleteMapping("/{artistId}")
    fun deleteArtistById(@PathVariable("artistId") artistId: String) {
        artistService.deleteArtistById(artistId)
    }
}