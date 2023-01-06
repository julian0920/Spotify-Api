package com.example.spotifycrudapi.spotify.service

import com.example.spotifycrudapi.mapper.AlbumMapper
import com.example.spotifycrudapi.persistence.Album
import com.example.spotifycrudapi.spotify.authorization.SpotifyAuthorization
import com.example.spotifycrudapi.spotify.authorization.SpotifyService
import mu.KotlinLogging
import org.springframework.stereotype.Service
import se.michaelthelin.spotify.exceptions.SpotifyWebApiException
import java.io.IOException

@Service
class SpotifyAlbumService(
    private val spotifyAuthorization: SpotifyAuthorization,
    private val spotifyService: SpotifyService
) {

    private val logger = KotlinLogging.logger {}
    private lateinit var albumMapper: AlbumMapper

    fun getArtistAlbumById(artistId: String): List<Album> {
        val spotifyApi = spotifyService.register(spotifyAuthorization.createClientCredentialsSync())
        try {
            val albumSimplifiedList = spotifyApi.getArtistsAlbums(artistId).album_type("album,single").limit(10).build()
                .execute().items.asList()
            return albumMapper.mapAlbumSimplifiedListToAlbum(albumSimplifiedList)
        } catch (ioException: IOException) {
            logger.error("Error {}", ioException.localizedMessage)
        } catch (swae: SpotifyWebApiException) {
            logger.error("Spotify Web Api Exception {}", swae.localizedMessage)
        }
        return emptyList()
    }
}