package com.example.spotifycrudapi.spotify.service

import com.example.spotifycrudapi.mapper.AlbumMapper
import com.example.spotifycrudapi.mapper.AlbumSimplifiedMapper
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
    private val spotifyService: SpotifyService,
    private val albumSimplifiedMapper: AlbumSimplifiedMapper,
    private val albumMapper: AlbumMapper
) {

    private val logger = KotlinLogging.logger {}

    fun getArtistAlbumById(artistId: String): Set<Album> {
        val spotifyApi = spotifyService.register(spotifyAuthorization.createClientCredentialsSync())
        try {
            val albumSimplifiedList = spotifyApi.getArtistsAlbums(artistId).album_type("album,single").limit(10).build()
                .execute().items.asList()
            val albumSimplifiedDtos = albumSimplifiedList.map { albumSimplifiedMapper.mapAlbumSimplifiedToAlbumSimplifiedDto(it) }
            val albumDtos = albumSimplifiedDtos.map { albumSimplifiedMapper.mapAlbumSimplifiedDtoToAlbumDto(it) }
            return albumDtos.map { albumMapper.mapAlbumDtoToAlbum(it) }.toSet()
        } catch (ioException: IOException) {
            logger.error("Error {}", ioException.localizedMessage)
        } catch (swae: SpotifyWebApiException) {
            logger.error("Spotify Web Api Exception {}", swae.localizedMessage)
        }
        return emptySet()
    }
}