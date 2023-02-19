package com.example.spotifycrudapi

import com.example.spotifycrudapi.persistence.Album
import com.example.spotifycrudapi.persistence.Artist
import com.example.spotifycrudapi.repositories.AlbumRepository
import com.example.spotifycrudapi.repositories.ArtistRepository
import com.example.spotifycrudapi.spotify.service.SpotifyAlbumService
import com.example.spotifycrudapi.spotify.service.SpotifyArtistService
import org.springframework.context.ApplicationListener
import org.springframework.context.event.ContextRefreshedEvent
import org.springframework.context.event.EventListener
import org.springframework.data.domain.Example
import org.springframework.stereotype.Component

@Component
class StartupApplicationListener(
    private val spotifyArtistService: SpotifyArtistService,
    private val spotifyAlbumService: SpotifyAlbumService,
    private val albumRepository: AlbumRepository,
    private val artistRepository: ArtistRepository
) : ApplicationListener<ContextRefreshedEvent> {
    @EventListener
    override fun onApplicationEvent(event: ContextRefreshedEvent) {
        albumRepository.deleteAll()
        artistRepository.deleteAll()

        val artists = spotifyArtistService.getSeveralArtistsByIds()
        val artistAlbums = spotifyAlbumService.getArtistAlbumById("4zYX8Aa744hQ5O2hpAYQI3")
        artists.forEach { artist -> saveIfArtistNotExists(artist) }
        artistAlbums.forEach { album -> saveIfAlbumNotExists(album) }
    }

    private fun saveIfArtistNotExists(artist: Artist) {
        val exists: Boolean = artistRepository.exists(Example.of(artist))
        if (!exists) {
            artistRepository.save(artist)
        }
    }

    private fun saveIfAlbumNotExists(album: Album) {
        val exists: Boolean = albumRepository.exists(Example.of(album))
        if (!exists) {
            albumRepository.save(album)
        }
    }
}