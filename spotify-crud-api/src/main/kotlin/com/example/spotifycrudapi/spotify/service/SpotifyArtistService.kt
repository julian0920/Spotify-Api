package com.example.spotifycrudapi.spotify.service

import com.example.spotifycrudapi.model.Album
import com.example.spotifycrudapi.model.Artist
import com.example.spotifycrudapi.spotify.authorization.SpotifyAuthorization
import com.example.spotifycrudapi.spotify.helper.DozerMappingHelper
import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import se.michaelthelin.spotify.exceptions.SpotifyWebApiException
import java.io.IOException

@Service
class SpotifyArtistService {
    // 10 Artist Ids
    private val artistIds = "4zYX8Aa744hQ5O2hpAYQI3,37awA8DFCAnCCL7aqYbDnD," +
            "1Cs0zKBU1kc0i8ypK3B9ai,73jBynjsVtofjRpdpRAJGk,0CbeG1224FS58EUx4tPevZ," +
            "2vVNxGBvKRQMWwI5c8KmYh,3gk0OYeLFWYupGFRHqLSR7,5eHs2hHfUzGizdnrLjc3CW," +
            "77AiFEVeAVj2ORpC85QVJs,2o5jDhtHVPhrJdv3cEQ99Z"

    private val logger = KotlinLogging.logger {}

    private val mapper = DozerMappingHelper()

    @Autowired
    private val spotifyAuthorization = SpotifyAuthorization()

    @Autowired
    private val spotifyService = SpotifyService()


    fun getSeveralArtistsByIds(): List<Artist> {
        val spotifyApi = spotifyService.clientCredentialsSync(spotifyAuthorization.createSpotifyApi())
        try {
            val artistList = spotifyApi.getSeveralArtists(artistIds).build().execute().asList()
            return mapper.mapToList(artistList, Artist::class)
        } catch (ioException: IOException) {
            logger.error("Error {}", ioException.localizedMessage)
        } catch (swae: SpotifyWebApiException) {
            logger.error("Spotify Web Api Exception {}", swae.localizedMessage)
        }
        return emptyList()
    }

    fun getArtistAlbumById(artistId: String): List<Album> {
        val spotifyApi = spotifyService.clientCredentialsSync(spotifyAuthorization.createSpotifyApi())
        try {
            val albumSimplifiedList = spotifyApi.getArtistsAlbums(artistId).album_type("album,single").limit(10).build()
                .execute().items.asList()
            return mapper.mapToList(albumSimplifiedList, Album::class)
        } catch (ioException: IOException) {
            logger.error("Error {}", ioException.localizedMessage)
        } catch (swae: SpotifyWebApiException) {
            logger.error("Spotify Web Api Exception {}", swae.localizedMessage)
        }
        return emptyList()
    }
}