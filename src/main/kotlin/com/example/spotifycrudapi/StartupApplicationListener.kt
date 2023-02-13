package com.example.spotifycrudapi

import com.example.spotifycrudapi.repositories.AlbumRepository
import com.example.spotifycrudapi.repositories.ArtistRepository
import com.example.spotifycrudapi.spotify.service.SpotifyAlbumService
import com.example.spotifycrudapi.spotify.service.SpotifyArtistService
import org.springframework.context.ApplicationListener
import org.springframework.context.event.ContextRefreshedEvent
import org.springframework.context.event.EventListener
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
        artistRepository.saveAll(spotifyArtistService.getSeveralArtistsByIds())
        albumRepository.saveAll(spotifyAlbumService.getArtistAlbumById("4zYX8Aa744hQ5O2hpAYQI3"))
    }
}