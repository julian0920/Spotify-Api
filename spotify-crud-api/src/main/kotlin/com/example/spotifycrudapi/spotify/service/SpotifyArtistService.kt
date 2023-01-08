package com.example.spotifycrudapi.spotify.service

import com.example.spotifycrudapi.mapper.ArtistMapper
import com.example.spotifycrudapi.mapper.SpotifyArtistMapper
import com.example.spotifycrudapi.persistence.Artist
import com.example.spotifycrudapi.spotify.authorization.SpotifyAuthorization
import com.example.spotifycrudapi.spotify.authorization.SpotifyService
import mu.KotlinLogging
import org.springframework.stereotype.Service
import se.michaelthelin.spotify.exceptions.SpotifyWebApiException
import java.io.IOException

private const val ARTIST_IDS = "4zYX8Aa744hQ5O2hpAYQI3,37awA8DFCAnCCL7aqYbDnD," +
        "1Cs0zKBU1kc0i8ypK3B9ai,73jBynjsVtofjRpdpRAJGk,0CbeG1224FS58EUx4tPevZ," +
        "2vVNxGBvKRQMWwI5c8KmYh,3gk0OYeLFWYupGFRHqLSR7,5eHs2hHfUzGizdnrLjc3CW," +
        "77AiFEVeAVj2ORpC85QVJs,2o5jDhtHVPhrJdv3cEQ99Z"

@Service
class SpotifyArtistService(
    private val spotifyAuthorization: SpotifyAuthorization,
    private val spotifyService: SpotifyService,
    private val artistMapper: ArtistMapper,
    private val spotifyArtistMapper: SpotifyArtistMapper
) {

    private val logger = KotlinLogging.logger {}

    fun getSeveralArtistsByIds(): List<Artist> {
        val spotifyApi = spotifyService.register(spotifyAuthorization.createClientCredentialsSync())
        try {
            val artistList = spotifyApi.getSeveralArtists(ARTIST_IDS).build().execute().asList()
            val artistDtos = spotifyArtistMapper.mapToArtistDtoList(artistList)
            return artistMapper.mapArtistDtosToArtistList(artistDtos)
        } catch (ioException: IOException) {
            logger.error("Error {}", ioException.localizedMessage)
        } catch (swae: SpotifyWebApiException) {
            logger.error("Spotify Web Api Exception {}", swae.localizedMessage)
        }
        return emptyList()
    }
}