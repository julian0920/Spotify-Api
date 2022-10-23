package com.example.spotifycrudapi.controller

import com.example.spotifycrudapi.model.Artist
import com.example.spotifycrudapi.service.ArtistService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

class ArtistController {

    @Autowired
    private val artistService = ArtistService()

    @GetMapping("/artists", produces = [MediaType.APPLICATION_JSON_VALUE])
    @ResponseBody
    fun getAllArtists(): ResponseEntity<List<Artist>> {
        return ResponseEntity(artistService.getAllArtists(), HttpStatus.OK)
    }

    @GetMapping("/artist/{artistId}", produces = [MediaType.APPLICATION_JSON_VALUE])
    @ResponseBody
    fun getArtistById(@PathVariable("artistId") artistId: Long): ResponseEntity<Artist> {
        return ResponseEntity(artistService.getArtistById(artistId), HttpStatus.OK)
    }

    @PutMapping("/updateArtistName/{artistId}/{name}", produces = [MediaType.APPLICATION_JSON_VALUE])
    @ResponseBody
    fun updateArtistNameById(
        @PathVariable("artistId") artistId: Long,
        @PathVariable("name") name: String
    ): ResponseEntity<String> {
        artistService.updateArtistNameById(artistId, name)
        return ResponseEntity(
            String.format("Artist %d was successfully updated by name %s", artistId, name),
            HttpStatus.OK
        )
    }

    @PutMapping("/updateArtistPopularity/{artistId}/{popularity}", produces = [MediaType.APPLICATION_JSON_VALUE])
    @ResponseBody
    fun updateArtistPopularityById(
        @PathVariable("artistId") artistId: Long,
        @PathVariable("popularity") popularity: Int
    ): ResponseEntity<String> {
        artistService.updateArtistPopularityById(artistId, popularity)
        return ResponseEntity(
            String.format("Artist %d was successfully updated by popularity %s", artistId, popularity),
            HttpStatus.OK
        )
    }

    @PostMapping("/newArtist", produces = [MediaType.APPLICATION_JSON_VALUE])
    @ResponseBody
    fun saveNewArtist(@RequestBody artist: Artist): ResponseEntity<String> {
        artistService.saveNewArtist(artist)
        return ResponseEntity("new Artist $artist was successfully created", HttpStatus.CREATED)
    }

    @DeleteMapping("/deleteArtists", produces = [MediaType.APPLICATION_JSON_VALUE])
    @ResponseBody
    fun deleteAllArtists(): ResponseEntity<String> {
        artistService.deleteAllArtists()
        return ResponseEntity("All Artists have been deleted", HttpStatus.OK)
    }

    @DeleteMapping("(deleteArtist/{artistId}", produces = [MediaType.APPLICATION_JSON_VALUE])
    @ResponseBody
    fun deleteArtistById(@PathVariable("artistId") artistId: Long): ResponseEntity<String> {
        artistService.deleteArtistById(artistId)
        return ResponseEntity(String.format("Artist with id %d was successfully deleted", artistId), HttpStatus.OK)
    }
}